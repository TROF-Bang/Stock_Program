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
		
			
		// ���� Ȯ��
//		System.out.println("Elements : " + element);
		int day = 5;
		int num = 0;
		
		while (day >= 0) {
			// �ּ�
			String url = "https://news.naver.com/main/list.nhn?mode=LS2D&mid=shm&sid2=731&sid1=105&date=2020081" + day;
			String data = "C:\\Users\\bang7\\Desktop\\data\\data" + num + ".txt";			
			BufferedWriter br = new BufferedWriter(new FileWriter(data));
			// ������ ������ ���� ��ü ����
			Document doc = null;
			
			try {
				// �� ������ ��� �ڵ�
				doc = Jsoup.connect(url).get();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			// ���� Ȯ��
//				System.out.println(doc);
			// �� ���뿡�� ���ϴ� ���� ���� �ڵ�(�ش� ���� ����)
			Elements element = doc.select("div.list_body.newsflash_body");
			// Ư�� ���� ���� ��������
			Iterator<Element> iterator = element.select("a").iterator();
			while (iterator.hasNext()) {
				br.write(iterator.next().text());
				// ���� �ֱ�
				br.newLine();
				// ���� �ִ� ������ ���
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
