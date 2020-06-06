package hg.view;
import javax.swing.*;
public class TabbedPane extends JTabbedPane{

	private static final long serialVersionUID = 1L;

	public TabbedPane(GamePanel game, ScoreHistoryPanel sp ) {
		super();
		addTab("Game board", game);
		addTab("History board", sp);
		addTab("Help", new Help());
	}
}
