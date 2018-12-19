package wordCount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class WordCountSort {

	public static void main(String[] args) throws IOException
	{
		File file = new File("wordcount.txt");
		BufferedReader br = new BufferedReader(new FileReader(file));
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		String readline;
		while ((readline = br.readLine()) != null)
		{
//			char[] chars = readline.toCharArray();
//			for ( char c: chars )
//			{
//				if ( Character.isLetterOrDigit(c) )
//				{
//					// compare char
//				}
//			}
						
			String[] str = readline.split("[^a-zA-Z]"); // letter
			// String[] words = readline.split("[^a-zA-Z0-9]"); // letter and number
			// String[] words = readline.split("[^a-zA-Z0-9\\u4e00-\\u9fa5]"); // letter, number and Chinese character
			for ( String s: str)
			{
				if (s.length() != 0)
				{
					if (map.containsKey(s))
					{
						map.put(s, map.get(s)+1);
					}
					else {
						map.put(s, 1);
					}
				}
			}
		}
		
		List<Map.Entry<String, Integer>> list = new ArrayList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {

			@Override
			public int compare(Entry<String, Integer> o1,
					Entry<String, Integer> o2) {
				// TODO Auto-generated method stub
//				return o1.getKey().compareTo(o2.getKey()); // ascending of the key
//				return o2.getKey().compareTo(o1.getKey()); // descending of the key
				return o2.getValue().compareTo(o1.getValue()); // descending of the value
//				return o1.getValue().compareTo(o2.getValue()); // ascending of the value
			}
		});
		
		for (Map.Entry<String, Integer> l: list)
		{
			System.out.println(l.getKey() + ": " + l.getValue());
		}
		
	}
	
}
