import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class WordFrequency {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		//creating file input stream and scanner
				FileInputStream find = new FileInputStream("C:\\Users\\meghamishra\\Documents\\javabench.txt\\");
				Scanner fileInput = new Scanner(find);
				
				//creating Map
				Map<String, Integer> wordMap = new HashMap<>();
				
				//reading files
				while(fileInput.hasNext()) {
					String nextWord = fileInput.next();
					
					//check if the word is present
					if(wordMap.containsKey(nextWord)) {
						int frequency = wordMap.get(nextWord);
						wordMap.put(nextWord, frequency + 1);
					}
					else {
						wordMap.put(nextWord, 1);
					}
				}
		        
				for (Entry<String, Integer> entry : wordMap.entrySet()) {
					System.out.println("Count of " + "'" +entry.getKey()+ "'" + " is = " + entry.getValue());
				
		        fileInput.close();
				find.close();
			}

	}

}
