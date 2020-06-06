package hg.model;
import java.util.Stack;
import java.util.StringTokenizer;

import javax.swing.JOptionPane;

import java.io.*;
/**
 * This class is container of methods that regards history of previous scores and present score.
 * @author Wonbin Kim
 *
 */
public class ScoreHistory {
	private static File file;
	//date	corrects fails
	private static BufferedReader br;
	private static Stack<Score> history = new Stack<Score>();
	
	public static int p_num = 1;
	public static int fails_on_one = 0;
	public static Score presentScore = new Score();
	
	static {
		file = new File("score.csv");
		try {
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e) {
			try {
				file.createNewFile();
				br = new BufferedReader(new FileReader(file));
			}catch(Exception ee) {
				JOptionPane.showConfirmDialog(null, "can not find, create 'score.csv' file.\n To fix this problem,"+
			" create 'score.csv' at root of this game directory\n"+ee.toString(), "Error", JOptionPane.CLOSED_OPTION);
				System.exit(0);
			}
		}
		
		String str;
		StringTokenizer st;
		try {
			while((str=br.readLine())!=null) {
				st = new StringTokenizer(str, "	");
				history.push(new Score(st.nextToken(), st.nextToken(), st.nextToken()));
			}
			br.close();
		}catch(IOException e) {
			JOptionPane.showConfirmDialog(null, "can not read previous scores\n"+e.toString(), "Error", JOptionPane.CLOSED_OPTION);
		}
	}
	
	public static int historySize() {
		return history.size();
	}
	public static Score getScore() {
		Score re = null;
		if(!history.isEmpty()) re = history.pop();
		return re;
	}
	
	public static void savePresentScore() {
		try {
			PrintWriter pw = new PrintWriter(new FileWriter(file.getPath(), true));
			pw.println(presentScore.date+'	'+presentScore.corrects+'	'+presentScore.fails);
			pw.close();
		}catch(IOException e) {
			JOptionPane.showConfirmDialog(null, "can not save present score\n"+e.toString(), "Error", JOptionPane.CLOSED_OPTION);
		}
		
	}

}
