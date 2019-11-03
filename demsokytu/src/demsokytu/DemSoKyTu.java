package demsokytu;

import java.util.HashMap;
import java.util.Map;

public class DemSoKyTu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "chi rua chi doa rua an di chi";
		String a[] = s.split(" ");
		for(String c : a) {
			System.out.println(c);
		}
		int count = 0 ;
		Map<String,Integer> map =  new HashMap<>();
		for(String object : a ) {
			if(map.containsKey(object)) {
				count = map.get(object);
				count++;
				map.put(object,count);
			}
			else {
				map.put(object, 1);
			}
		}
		
		for(String o : map.keySet()) {
			System.out.println("Key:"+ o +"Value:"+ map.get(o));
		}
	}
	

}
