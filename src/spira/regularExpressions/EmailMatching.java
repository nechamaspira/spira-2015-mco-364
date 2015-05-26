package spira.regularExpressions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailMatching {
	private static final Pattern EMAIL_PATTERN = Pattern.compile("\\S+?@\\S+?\\.\\S+");
	//compile method is a factory method = u dont call new Pattern. this static method returns a new object instead of a constructor
	//patterns are thread safe, and they should always be constants
	
	public static void main(String args[]){
		String text = "hey whats up nechamaspira@gmail.com" ;
		//Pattern p = Pattern.compile("\\S+?@\\S+?\\.\\S+");
		 Matcher m = EMAIL_PATTERN.matcher(text);
		 boolean b = m.matches();
		 
		 //advanced text editor - cntrl f
		 System.out.println(b);
		 
		while(m.find()){
			String number = text.substring(m.start(),m.end());
			
			System.out.println(number);
		}
	}
}
