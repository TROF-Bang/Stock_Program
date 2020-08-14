package stock_news;


import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Naver_stock {

	public static void main(String[] args) throws Exception {
		// Jsoup�� �̿��ؼ� http://www.cgv.co.kr/movies/ ũ�Ѹ�
//				String url = "http://www.cgv.co.kr/movies/"; //ũ�Ѹ��� url����
//				Document doc = null;        //Document���� �������� ��ü �ҽ��� ����ȴ�
//
//				try {
//					doc = Jsoup.connect(url).get();
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
//				//select�� �̿��Ͽ� ���ϴ� �±׸� �����Ѵ�. select�� ���ϴ� ���� �������� ���� �߿��� ����̴�.
//				Elements element = doc.select("div.sect-movie-chart");    
//
//				System.out.println("============================================================");
//
//				//Iterator�� ����Ͽ� �ϳ��� �� ��������
//				Iterator<Element> ie1 = element.select("strong.rank").iterator();
//				Iterator<Element> ie2 = element.select("strong.title").iterator();
//				        
//				while (ie1.hasNext()) {
//					System.out.println(ie1.next().text()+"\t"+ie2.next().text());
//				}
//				
//				System.out.println("============================================================");

				String url = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid2=731&sid1=105&date=20200815";
				// ������ ������ ���� ��ü ����
				Document doc = null;
				
				try {
					// �� ������ ��� �ڵ�
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {e.printStackTrace();}
				// ���� Ȯ��
//				System.out.println(doc);
				
				// �� ���뿡�� ���ϴ� ���� ���� �ڵ�(�ش� ���� ����)
				Elements element = doc.select("div.list_body.newsflash_body");
				
				// ���� Ȯ��
//				System.out.println("Elements : " + element);
				
				// Ư�� ���� ���� ��������
				Iterator<Element> iterator = element.select("a").iterator();
				
				while(iterator.hasNext()) {
					System.out.println(iterator.next().text());
				}

	}
}
