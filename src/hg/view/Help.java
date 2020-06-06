package hg.view;
import javax.swing.*;
public class Help extends JPanel{
	private JEditorPane p = new JEditorPane();
	private String helpText = "<p>This is 'Hangman Game'(https://en.wikipedia.org/wiki/Hangman_(game)) made by java.<br/></p>"+
		"<h2>1. Rules</h2>"+
	"<ol><li >The program reads words and show it as problem.</li>"+
	"<li>The problem is word that is hidding some letters.</li>"+
	"<li>Number of Hidden letters is under 30% of the word length.</li>"+
	"<li>If user fails over 5 times at an word, program changes the word as a new problem.</li>"+
	"<li>If user user solves over 10 problems or fails over 3 problems, the game is over.</li></ol>"+
	"<p>By changing 'words.txt'file on root directory, you can change words that used as problem<br/>"+
	"However, 'words.txt'file must classify words line by line</p>"+
		"<h2>2. Tab: Game board</h2>"+
	"<p>At the Game board Tab, you can solve problems by input your answers,<br/>"+
	"and program will show you whether your answer is correct or not.</p>"+
		"<h2>3. Tab: History board</h2>"+
	"<p>This tab shows previous game scores and present game score by computing 'score.csv'file.<br/>"+
	"If you want to clear history, remove the 'score.csv'file</p>"
	;
	public Help() {
		p.setEditable(false);
		p.setContentType("text/html");
		p.setText(helpText);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JScrollPane(p));
			
	}
}
