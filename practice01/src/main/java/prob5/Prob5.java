package prob5;

public class Prob5 {

	public static void main(String[] args) {

		var sb = new StringBuilder();
		boolean isTarget = false;

		// set range
		for (int i = 1; i < 101; i++) {
			var texts = Integer.toString(i).split("");

			for (var text : texts) {
				if (text.equals("3") || text.equals("6") || text.equals("9")) {
					sb.append("clap!");
					isTarget = true;
				}
			}

			if (isTarget) {
				sb.insert(0, Integer.toString(i) + " ");
				System.out.println(sb.toString());
				sb.setLength(0);
				isTarget = false;
			}
		}
	}
}
