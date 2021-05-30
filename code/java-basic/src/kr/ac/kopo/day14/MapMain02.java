package kr.ac.kopo.day14;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapMain02 {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<>();
		map.put("aaa", "1111");
		map.put("bbb", "2222");
		map.put("ccc", "3333");
		map.put("ddd", "4444");
		
		System.out.println(map.containsValue("5555"));
		
		Map<String, String> map2 = new HashMap<>();
		map.put("eee", "1111");
		map.put("fff", "2222");
		map.put("ggg", "3333");
		map.put("ddd", "4444");
		
		map.putAll(map2);
		
		
		Set<Entry<String, String>> entries = map.entrySet(); 
		
		for(Entry<String, String> entry : entries) {
			System.out.println(entry);
		}
		
		Set<String> keySet = map.keySet();
		
		for(String key: keySet) {
			System.out.println(key);
		}
		
	}

}
