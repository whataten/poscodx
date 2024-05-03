package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Base64;

public class ChatWindow {

	private static final String SERVER_IP = "127.0.0.1";
	private static final int SERVER_PORT = 5000;
	private static final String FRAME_NAME = "CHAT";

	private static Socket socket = new Socket();
	private BufferedReader br = null;
	private PrintWriter pw = null;
	private ChatClientThread chatClientThread = null;
	private String name;

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;

	public ChatWindow(String name) {
		this.name = name;
		frame = new Frame(FRAME_NAME);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);

		try {
			socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));
			this.br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "utf-8"));
			this.pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"), true);
			this.chatClientThread = new ChatClientThread();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void show() {
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		this.chatClientThread.start();
		pw.println("JOIN:" + encoding(this.name));
	}

	private void sendMessage() {
		String message = textField.getText();

		if ("".equals(message)) {
			return;
		} else if ("quit".equals(message.toLowerCase())) {
			pw.println("QUIT:");
			finish();
		} else {
			pw.println("MSG:" + encoding(message));
		}

		textField.setText("");
		textField.requestFocus();
	}

	private void updateTextArea(String message, boolean isEncoded) {
		if (isEncoded) {
			textArea.append(decoding(message));
		} else {
			textArea.append(message);
		}
		textArea.append("\n");
	}

	private void finish() {
		this.chatClientThread.interrupt();
		pw.println("QUIT:");

		System.exit(0);
	}

	private class ChatClientThread extends Thread {
		public void run() {
			while (true) {
				try {
					if (socket.isClosed()) {
						break;
					}
					String data = br.readLine();
					updateTextArea(data, false);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private static String encoding(String str) {
		return Base64.getEncoder().encodeToString(str.getBytes());
	}

	private static String decoding(String str) {
		return new String(Base64.getDecoder().decode(str));
	}
}