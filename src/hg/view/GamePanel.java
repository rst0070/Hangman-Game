package hg.view;
import java.awt.event.*;
import javax.swing.*;

import hg.model.ScoreHistory;
import hg.model.Problem;
import hg.model.ProblemBank;
public class GamePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	final JPanel problem_panel = new JPanel();
	final JPanel answer_panel = new JPanel();
	
	JTextArea problemArea;
	Problem presentProblem;
	JTextField answerField;
	JButton submit = new JButton("submit");
	
	ActionListener submitAction = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(answerField.getText().contentEquals(presentProblem.answer())) {
				print(answerField.getText()+": correct!");
				
				ScoreHistory.p_num++;
				ScoreHistory.presentScore.corrects++;
				
				
				presentProblem = ProblemBank.getProblem();
			}else {
				print(answerField.getText()+": incorrect");
				ScoreHistory.fails_on_one++;
				
				if(ScoreHistory.fails_on_one >= 5) {
					ScoreHistory.fails_on_one = 0;
					ScoreHistory.presentScore.fails++;
					presentProblem = ProblemBank.getProblem();
				}
			}
			print("Problem #"+ScoreHistory.p_num+' '+presentProblem.problem());
			
			if(ScoreHistory.presentScore.corrects >= 10 || ScoreHistory.presentScore.fails >= 3) {
				if(ScoreHistory.presentScore.corrects >= 10) {
					JOptionPane.showConfirmDialog(null, "Good Job! 10 of your answers are correct!\n", "End of Game", JOptionPane.CLOSED_OPTION);
				}else {
					JOptionPane.showConfirmDialog(null, "Well done! 3 of your answers are incorrect.\n I recommend you to study more than you did:)"
							, "End of Game", JOptionPane.CLOSED_OPTION);
				}
				System.exit(0);
			}
			
			answerField.setText("");
			//ScoreHistory.presentScore.notify();
			ViewMain.history_panel.refreshPs();
		}
	
	};
	
	private void print(String m) {
		problemArea.setText(problemArea.getText()+m+'\n');
	}
	
	public GamePanel() {
		problemArea = new JTextArea("");
		problemArea.setEditable(false);
		problemArea.setColumns(25);
		problemArea.setRows(10);
		
		problem_panel.setLayout(new BoxLayout(problem_panel, BoxLayout.Y_AXIS));
		problem_panel.add(new JLabel("Problem and Your answer"));
		problem_panel.add(new JScrollPane(problemArea));
		
		
		answerField = new JTextField();
		answerField.addKeyListener(new KeyListener() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER && answerField.getText().length() > 0)	submitAction.actionPerformed(null);
			}
			@Override
			public void keyReleased(KeyEvent arg0) {}
			@Override
			public void keyTyped(KeyEvent arg0) {}
		});
		answer_panel.setLayout(new BoxLayout(answer_panel, BoxLayout.Y_AXIS));
		answer_panel.add(new JLabel("Insert your Answer below:"));
		answer_panel.add(answerField);
		
		submit.addActionListener(submitAction);
		answer_panel.add(submit);
		
		
		
		
		this.add(problem_panel);
		this.add(answer_panel);
		
		startGame();
	}
	
	public void startGame() {
		presentProblem = ProblemBank.getProblem();
		print("Problem #1 "+presentProblem.problem());
	}
}
