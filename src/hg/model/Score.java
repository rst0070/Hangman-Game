package hg.model;
/**
 * 
 * @author Wonbin Kim
 *
 */
public class Score {
	public int corrects;
	public int fails = 0;
	public String date;
	public Score() {
		corrects = 0;
		fails = 0;
		date = new java.util.Date().toString();
	}
	public Score(String d, String c, String f) {
		date = d;
		corrects = Integer.parseInt(c);
		fails = Integer.parseInt(f);
	}
}
