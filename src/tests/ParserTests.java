package tests;

import java.util.Arrays;

import mian.Parser;

public class ParserTests {

	public static void main(String[] args) {
		Parser parser = new Parser();
		
		String showItems = Arrays.toString(parser.parse("show_items"));
		String showTowns = Arrays.toString(parser.parse("show_towns  "));
		String showShippings = Arrays.toString(parser.parse(" show_shippings "));
		
		System.out.println("corrects:");
		System.out.println(showItems);
		System.out.println(showTowns);
		System.out.println(showShippings);
		
		String error1 = Arrays.toString(parser.parse("show_a"));
		String error2 = Arrays.toString(parser.parse("show_items show_towns"));
		String error3 = Arrays.toString(parser.parse(""));
		
		System.out.println("incorrects:");
		System.out.println(error1);
		System.out.println(error2);
		System.out.println(error3);
		
		String deleteItem = Arrays.toString(parser.parse("delete_item %2%"));
		String deleteTowns = Arrays.toString(parser.parse("delete_town %12321%"));
		String deleteShippings = Arrays.toString(parser.parse("delete_shipping      %12321321%"));
		
		System.out.println("corrects:");
		System.out.println(deleteItem);
		System.out.println(deleteTowns);
		System.out.println(deleteShippings);
		
		String error4 = Arrays.toString(parser.parse("delete_item%2%"));
		String error5 = Arrays.toString(parser.parse("delete_town 12321%"));
		String error6 = Arrays.toString(parser.parse("delete_shipping      %%"));
		
		System.out.println("incorrects:");
		System.out.println(error4);
		System.out.println(error5);
		System.out.println(error6);		
		
		String add_item = Arrays.toString(
				parser.parse(" add_item  %item_name%  %quantity% "));
		String add_town = Arrays.toString(
				parser.parse("add_town %town_name% %distance%"));
		String add_shipping = Arrays
				.toString(parser
				.parse("add_shipping %item_id% %town_ad% %start_date% %end_date%"));
		String add_shipping2 = Arrays
				.toString(parser
						.parse("add_shipping %item_id%%town_ad%%start_date%%end_date%"));
		
		System.out.println("corrects:");
		System.out.println(add_item);
		System.out.println(add_town);
		System.out.println(add_shipping);
		System.out.println(add_shipping2);
		
		String error7 = Arrays.toString(
				parser.parse("add_item %item_name% quantity%"));
		String error8 = Arrays.toString(
				parser.parse("add_town %% %distance%"));
		String error9 = Arrays
				.toString(parser
				.parse("add_shipp %item_id% %town_ad% %start_date% %end_date%"));
		String error10 = Arrays
				.toString(parser
						.parse("add_shipping %item_id%end_date%"));
		
		System.out.println("incorrects:");
		System.out.println(error7);
		System.out.println(error8);
		System.out.println(error9);	
		System.out.println(error10);	
	}

}
