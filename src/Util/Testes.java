package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Testes {	
	
	public static void main(String[] args){
		String g = "0 20 [3;2;3;4] 1 0 0";
		String p = "[3;2;3;4]";
		List<String> list = Arrays.asList(p.substring(1, p.length() - 1).split(";"));
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		for(int i = 0; i < list.size(); i++) {
		   numbers.add(Integer.parseInt(list.get(i)));   
		}
		
		String Alt[] = g.split(Pattern.quote(" "));
		
		System.out.println(numbers.toString());
		
		
		for(int i=0;i<Alt.length;i++){
			System.out.println(Alt[i]);
		}
			
	}

}
