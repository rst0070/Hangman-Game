package hg;

import java.util.Date;
import hg.view.ViewMain;

public class Main {
	
	//프로그램 종료시 호출되는 스레드
	public static class SaveDataAtShutDown extends Thread{
		@Override
		public void run() {
			System.out.println("Saving..");
			hg.model.ScoreHistory.savePresentScore();
		}
	}
	
	public static void main(String[] args) {
		System.out.println("time: "+new Date().toString());
		
		//프로그램 종료시 score history에 저장.
		Runtime r = Runtime.getRuntime();
		r.addShutdownHook(new SaveDataAtShutDown());
		
		new ViewMain();
		
	}
}
