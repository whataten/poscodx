package prob2;

public class Prob2 {
	public static void main(String[] args) {

		var sb = new StringBuilder();

		// make string
		for (int start = 1; start < 11; start++) {
			int steps = start;
			for (int j = 0; j < 10; j++) {
				sb.append(Integer.toString(steps)).append(" ");
				steps++;
			}
			// newline
			sb.append("\n");
		}

		System.err.println(sb.toString());
	}
}
