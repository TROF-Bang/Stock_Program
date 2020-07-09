package stock_news;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class test_Main {

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new FileReader(new File("C:\\Users\\Administrator\\Desktop\\Naver_stock_news.txt")));
		String data = null;
		while((data = reader.readLine()) != null) {
			String[] strings = data.split(" ");
			for (String string : strings) {
				System.out.println(string);
			}
		}
		reader.close();
	}
}
