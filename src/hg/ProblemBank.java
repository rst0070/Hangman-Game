package hg;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.ArrayList;
public class ProblemBank {
	File file;
	//final int LastWordLine = 25143;
	//FileReader fr;
	BufferedReader br;
	ArrayList<String> words;
	
	public ProblemBank(String filePath) {
		file = new File(filePath);
		try {
			br = new BufferedReader(new FileReader(file));
		}catch(FileNotFoundException e) {
			System.out.println("word파일의 경로가 잘못되었습니다. path.txt파일과 word.txt파일을 확인해 주십시오.");
			System.exit(0);
		}
		
		words = new ArrayList<String>();
		
		readFile();
	}
	
	private void readFile() {
		String word;
		try {
			while((word = br.readLine())!=null)
				if(word.length() > 3)words.add(word);
		}catch(IOException e) {
			
		}
	}
	
	public Problem getProblem() {
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
			public String getAnswer() {
				return answer;
			}

			@Override
			public String getProblem() {
				return problem_str;
			}
			
		};
		
		return pb;
	}
}
