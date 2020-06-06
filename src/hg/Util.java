package hg;

import java.util.Calendar;

/**
 * static Utility methods for application.
 * @author Wonbin Kim
 *
 */
public class Util {
	static private Calendar time;
	public static int random() {
		time = Calendar.getInstance();
		int seed = time.get(Calendar.MINUTE) + time.get(Calendar.SECOND);
		int re = 2784325*seed + 398103;
		if(re < 0) re = re*(-1);
		return re;
	}
}
