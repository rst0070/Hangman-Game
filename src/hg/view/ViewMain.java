package hg.view;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
public class ViewMain extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JFrame the_frame = this;
	static final ScoreHistoryPanel history_panel = new ScoreHistoryPanel();
	static final GamePanel game_panel = new GamePanel();
	static final JTabbedPane tabbedPane = new TabbedPane(game_panel, history_panel);
	public ViewMain() {
		super("Hang Man Game");
		add(tabbedPane);
		windowSet();
	}
	
	private void windowSet() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				if (JOptionPane.showConfirmDialog(the_frame, 
			            "Are you sure you want to out of game?", "Close the Game?", 
			            JOptionPane.YES_NO_OPTION,
			            JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
			            System.exit(0);
			    }
				the_frame = new JFrame("Hang Man Game");
				the_frame.add(tabbedPane);
				the_frame.addWindowListener(this);
				the_frame.setBounds( 800, 500, 550, 350);
				the_frame.setVisible(true);
			}
			
		});
		setBounds( 800, 500, 550, 350);
		setVisible(true);
	}

}
