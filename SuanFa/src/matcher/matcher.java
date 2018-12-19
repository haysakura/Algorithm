package matcher;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public class matcher {

	public static void main(String[] args)
	{
		String[] ss1 = {"abab", "aaaa", "aaab", "aabb"};
		String[] ss2 = {"dog cat dog cat",
				        "dog dog dog cat",
				        "dog dog dog cat",
				        "dog cat cat cat"};
		Boolean flag = false;
		
		Map<Character, String> pattern = math(ss1[0], ss2[0]);
		Iterator<Map.Entry<Character, String>> it = pattern.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry<Character, String> item = it.next();
			System.out.println("key is: " + item.getKey() + ", value is: " + item.getValue());
		}
		
		for (int i = 0; i < ss2.length; i++) {
			flag = matcher(ss1[i], ss2[i], pattern);
			System.out.println("s1 is: " + ss1[i] + ", s2 is: " + ss2[i] + ", and the returned value is: " + flag);
		}
	}
	
	public static boolean matcher(String s1, String s2, Map<Character, String> math)
	{
		boolean flags = false;
		char[] s1_char = s1.toCharArray();
		String[] s2_string = s2.split(" ");
		
//		Map<Character, String> map_value = new HashMap<Character, String>();
//		map_value.put('a', "dog");
//		map_value.put('b', "cat");
		
		if (s1_char.length == s2_string.length) {
			for (int i = 0; i < s1_char.length; i++) {
				if (s2_string[i].equals(math.get(s1_char[i]))) {
					flags = true;
				}
				else {
					flags = false;
					break;
				}
			}
		}
		
		return flags;
	}
	
	public static Map<Character, String> math(String char_key, String string_value)
	{
		Map<Character, String> map_return = new HashMap<Character, String>();
				
		char[] key_array = char_key.toCharArray();
		String[] value_array = string_value.split(" ");
		
		for (int i = 0; i < key_array.length; i++) {
			if (!map_return.containsKey(key_array[i])) {
				map_return.put(key_array[i], value_array[i]);
			}
		}
		
		return map_return;
	}
	
	
}
