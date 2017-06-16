package Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Testes {

	public static void main(String[] args) {
		String g = "0 20 [3;2;3;4] 1 0 0";
		String p = "[3:5;7:9;12:15;18:19]";
		List<String> list = Arrays.asList(p.substring(1, p.length() - 1).split(";"));
		ArrayList<String> Alt1 = null;

		ArrayList<Integer> numbers = new ArrayList<Integer>();

		String auxNum = "";
		String num1 = "", num2 = "";
		int x = 0, y = 0;
		int ponto = 0;

		for (byte w = 0; w < list.size(); w++) {
			auxNum = list.get(w);
			ponto = auxNum.indexOf(':');
			num1 = auxNum.substring(0, ponto);
			num2 = auxNum.substring(ponto + 1);
			x = Integer.valueOf(num1);
			y = Integer.valueOf(num2);

			for (int z = x; z <= y; z++) {
				numbers.add(z);
			}
		}

		// String Alt[] = g.split(Pattern.quote(" "));

		System.out.println(numbers.toString());

		// for (int i = 0; i < Alt.length; i++) {
		// System.out.println(Alt[i]);
		// }

	}

}
