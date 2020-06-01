package hg;

import java.util.Calendar;

/**
 * static Utility methods for application.
 * @author kwb07
 *
 */
public class Util {
	private static Calendar time= Calendar.getInstance();
	public static int random() {
		time= Calendar.getInstance();
		int seed = time.get(time.MINUTE) + time.get(time.SECOND);
		int re = 2784325*seed + 398103;
		if(re < 0) re = re*(-1);
		return re;
	}

}
