package spira.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberMatching {

	public static void main(String args[]){
		String text = " this is my numb, 123-456-7890. call me or 1 718 666 6666";
		Pattern p = Pattern.compile("(1-?\\s*)?(\\d{3}-?\\s*){2}\\d{4}");
		 Matcher m = p.matcher(text);
		 boolean b = m.matches();
		 
		 
		 System.out.println(b);
		 
		while(m.find()){
			String number = text.substring(m.start(),m.end());
			
			System.out.println(number);
		}
	}
}
