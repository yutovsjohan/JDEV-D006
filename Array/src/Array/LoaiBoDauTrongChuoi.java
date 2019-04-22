package Array;

import java.text.Normalizer;
import java.util.regex.Pattern;

public class LoaiBoDauTrongChuoi {
	public static String removeAccent(String s) {
	  String temp = Normalizer.normalize(s, Normalizer.Form.NFD);
	  Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
	  return pattern.matcher(temp).replaceAll("").replace('đ','d').replace('Đ','D');
	 }
	
	public static String changeTitle(String s) {
		s = removeAccent(s);		
		Pattern pattern = Pattern.compile("[\\W_]");
		s = pattern.matcher(s).replaceAll(" ");
		
		s = s.trim();
		while(s.contains("  ")) {
			s =	s.replaceAll("  ", " ");
		}
		
		s = s.replaceAll(" ", "-");
		s = s.toLowerCase();
		return s;
	}
  
 	public static void main(String[] args) {
 		String str = "  Chào   Mừng    Đến  Với    Lớp    Học     Java ^-^ ~.~ +_= @/#  >.<  ";
 		str = changeTitle(str);
      	System.out.println(str);
	}

}
