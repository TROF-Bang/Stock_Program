package web_crawler;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Naver_stock {

	public static void main(String[] args) throws Exception {
		
			
		// 쿼리 확인
//		System.out.println("Elements : " + element);
		int day = 5;
		int num = 0;
		
		while (day >= 0) {
			// 주소
			String url = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid2=731&sid1=105&date=2020081" + day;
			String data = "C:\\Users\\bang7\\Desktop\\data\\data" + num + ".txt";			
			BufferedWriter br = new BufferedWriter(new FileWriter(data));
			// 웹에서 내용을 담을 객체 생성
			Document doc = null;
			
			try {
				// 웹 내용을 담는 코드
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// 쿼리 확인
//				System.out.println(doc);
			// 웹 내용에서 원하는 내용 추출 코드(해당 쿼리 추출)
			Elements element = doc.select("div.list_body.newsflash_body");
			// 특정 쿼리 내용 가져오기
			Iterator<Element> iterator = element.select("a").iterator();
			while (iterator.hasNext()) {
				br.write(iterator.next().text());
				// 라인 주기
				br.newLine();
				// 남아 있는 데이터 출력
				br.flush();
			}
			--day;
			++num;
			// write close
			if(day >= 0)
				br.close();
		}
	}
}
