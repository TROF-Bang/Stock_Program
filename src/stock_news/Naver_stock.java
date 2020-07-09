package stock_news;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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

				String url = "https://finance.naver.com/news/news_list.nhn?mode=LSS3D&section_id=101&section_id2=258&section_id3=402";
				// ������ ������ ���� ��ü ����
				Document doc = null;
				
				try {
					// �� ������ ��� �ڵ�
					doc = Jsoup.connect(url).get();
				} catch (IOException e) {e.printStackTrace();}
				// ���� Ȯ��
//				System.out.println(doc);
				
				// �� ���뿡�� ���ϴ� ���� ���� �ڵ�(�ش� ���� ����)
				Elements element = doc.select("ul.realtimeNewsList");
				
				// ���� Ȯ��
//				System.out.println("Elements : " + element);
				
				// Ư�� ���� ���� ��������
				Iterator<Element> iterator = element.select("dd.articleSummary").iterator();
				
				while(iterator.hasNext()) {
					System.out.println(iterator.next().text());
				}

	}
}
