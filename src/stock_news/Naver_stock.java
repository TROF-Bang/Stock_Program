package stock_news;


import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Naver_stock {

	public static void main(String[] args) throws Exception {
		// Jsoup를 이용해서 http://www.cgv.co.kr/movies/ 크롤링
//				String url = "http://www.cgv.co.kr/movies/"; //크롤링할 url지정
//				Document doc = null;        //Document에는 페이지의 전체 소스가 저장된다
//
//				try {
//					doc = Jsoup.connect(url).get();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				//select를 이용하여 원하는 태그를 선택한다. select는 원하는 값을 가져오기 위한 중요한 기능이다.
//				Elements element = doc.select("div.sect-movie-chart");    
//
//				System.out.println("============================================================");
//
//				//Iterator을 사용하여 하나씩 값 가져오기
//				Iterator<Element> ie1 = element.select("strong.rank").iterator();
//				Iterator<Element> ie2 = element.select("strong.title").iterator();
//				        
//				while (ie1.hasNext()) {
//					System.out.println(ie1.next().text()+"\t"+ie2.next().text());
//				}
//				
//				System.out.println("============================================================");

				String url = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid2=731&sid1=105&date=20200815";
				// 웹에서 내용을 담을 객체 생성
				Document doc = null;
				
				try {
					// 웹 내용을 담는 코드
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {e.printStackTrace();}
				// 쿼리 확인
//				System.out.println(doc);
				
				// 웹 내용에서 원하는 내용 추출 코드(해당 쿼리 추출)
				Elements element = doc.select("div.list_body.newsflash_body");
				
				// 쿼리 확인
//				System.out.println("Elements : " + element);
				
				// 특정 쿼리 내용 가져오기
				Iterator<Element> iterator = element.select("a").iterator();
				
				while(iterator.hasNext()) {
					System.out.println(iterator.next().text());
				}

	}
}
