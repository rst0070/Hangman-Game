package hg;
import javax.swing.JFrame;

import java.awt.event.*;
import javax.swing.*;
public class Gui extends JFrame{
	final JFrame the_frame = this;
	
	final JPanel the_container = new JPanel();
	final JPanel problem_panel = new JPanel();
	//layout = new BoxLayout(problem_panel, BoxLayout.Y_AXIS);
	final JPanel answer_panel = new JPanel();
	
	JTextArea problemArea;
	JTextField answerField;
	JButton submit = new JButton("submit");
	ActionListener submitAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(answerField.getText().contentEquals(presentProblem.getAnswer())) {
				print("	Problem #"+Main.p_num+" correct!");
				
				Main.p_num++;
				Main.corrects++;
				
				
				presentProblem = Main.bank.getProblem();
			}else {
				print("	Problem #"+Main.p_num+" fail");
				Main.fails_on_one++;
				
				if(Main.fails_on_one >= 5) {
					Main.fails_on_one = 0;
					Main.fails++;
					presentProblem = Main.bank.getProblem();
				}
			}
			print("Problem #"+Main.p_num+' '+presentProblem.getProblem());
			
			if(Main.corrects >= 10 || Main.fails >= 3) {
				System.exit(0);
			}
			
			answerField.setText("");
		}
	
	};
	Problem presentProblem;
	
	public Gui() {
		super("Hang Man Game");
		
		submit.addActionListener(submitAction);
		panelSetting();
		windowSetting();
	}
	
	private void panelSetting() {
		problemArea = new JTextArea("");
		problemArea.setEditable(false);
		problemArea.setColumns(25);
		problemArea.setRows(10);
		
		problem_panel.setLayout(new BoxLayout(problem_panel, BoxLayout.Y_AXIS));
		problem_panel.add(new JLabel("<Problem List>"));
		problem_panel.add(new JScrollPane(problemArea));
		
		
		answerField = new JTextField();
		
		answer_panel.setLayout(new BoxLayout(answer_panel, BoxLayout.Y_AXIS));
		answer_panel.add(new JLabel("<Problem List>"));
		answer_panel.add(answerField);
		answer_panel.add(submit);
		
		
		
		
		the_container.add(problem_panel);
		the_container.add(answer_panel);
	}
	
	private void windowSetting() {
		add(the_container);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(the_frame, 
			            "Are you sure you want to out of game?", "Close the Game?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			            System.exit(0);
			    }
			}
		});
		setBounds( 800, 500, 500, 300);
		setVisible(true);
	}
	
	
	public void startGame() {
		presentProblem = Main.bank.getProblem();
		print("Problem #1 "+presentProblem.getProblem());
	}
	
	private void print(String m) {
		problemArea.setText(problemArea.getText()+m+'\n');
	}
	
}
