package hg.view;
import javax.swing.*;
import hg.model.ScoreHistory;
import hg.model.Score;
public class ScoreHistoryPanel extends JPanel{

	private static final long serialVersionUID = 1L;

	private Object[] columnNames = {"DATE", "Corrects", "Fails"};
	
	private Object[][] ps_data = {{ScoreHistory.presentScore.date, ScoreHistory.presentScore.corrects, ScoreHistory.presentScore.fails}};
	private	JTable presentTable = new JTable(ps_data, columnNames);
	public void refreshPs() {
		System.out.println("changing History board - present score");
		
		ps_data[0][0] = ScoreHistory.presentScore.date;
		ps_data[0][1] = ScoreHistory.presentScore.corrects;
		ps_data[0][2] = ScoreHistory.presentScore.fails;
		
		presentTable.repaint();
	}
	
	private Object[][] previousData;
	private JTable previousTable;
	public ScoreHistoryPanel() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		add(new JLabel("Present Score"));
		add(new JScrollPane(presentTable));
		
		add(new JLabel("Previous Scores"));
		
		previousData = new Object[ScoreHistory.historySize()][3];
		Score stmp;
		for(int i = 0; (stmp = ScoreHistory.getScore())!=null; i++) {
			previousData[i][0] = stmp.date;
			previousData[i][1] = stmp.corrects;
			previousData[i][2] = stmp.fails;
		}
		previousTable = new JTable(previousData, columnNames);
		
		add(new JScrollPane(previousTable));
	}
}
