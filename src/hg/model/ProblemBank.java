package hg.model;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import hg.Util;

/**
 * This is a container class of static method(getProblem()) that returns 'Problem' object.
 * @author Wonbin Kim
 *
 */
public class ProblemBank {
	private static  File file;
	private static BufferedReader br;
	private static ArrayList<String> words;
	
	static{
		file = new File("words.txt");
		try {
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e) {
			JOptionPane.showConfirmDialog(null, "can not find 'word.txt' file.\n check path or name of the file", "Error", JOptionPane.CLOSED_OPTION);
			System.exit(0);
		}
		
		words = new ArrayList<String>();
		
		readFile();
	}
	
	private static void readFile() {
		String word;
		try {
			while((word = br.readLine())!=null)
				if(word.length() > 3)words.add(word);
		}catch(IOException e) {
			
		}
	}
	
	public static Problem getProblem() {
		int random = Util.random()%words.size();
		
		String answer = words.get(random);
		char[] problem = answer.toCharArray();
		
		boolean[] visited = new boolean[problem.length];
		
		int i = (Util.random() % (new Double(Math.floor(answer.length()*0.3)).intValue())) + 1;
		for(;i > 0; i--) {
			random = Util.random()%problem.length;
			if(visited[random]) {
				i++;
				continue;
			}
			
			problem[random] = '-';
			visited[random] = true;
		}
		
		String problem_str = new String(problem);
		
		Problem pb = new Problem() {
			@Override
			public String answer() {
				return answer;
			}

			@Override
			public String problem() {
				return problem_str;
			}
			
		};
		
		return pb;
	}
}
