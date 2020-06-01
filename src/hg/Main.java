package hg;

public class Main {
	static int corrects = 0;
	static int fails = 0;
	static int p_num = 1;
	static int fails_on_one = 0;
	
	static ProblemBank bank;
	
	public static void main(String[] args) {
		bank = new ProblemBank("words.txt");
		Gui window = new Gui();
		
		window.startGame();
		
	}
}
