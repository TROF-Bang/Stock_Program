package jdbc_connection;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

public class Main {

	public static void main(String[] args) throws Exception {
		
		StudentDao sDao = new StudentDao();
		
//		sDao.insertStudent(new Student("shin", "Ω≈¿∫«ı", "A"));
//		sDao.deleteStudent("shin");
//		Student student = sDao.selectOne("hong");
//		System.out.println(student);
		
//		List<Stock> list = sDao.selectAll();
//		System.out.println(list);
		
		File file = new File("C:\\Users\\Administrator\\Desktop\\stock2.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String data;
		String[] str;
		List<Stock> list;
 		while (true) {
			if ((data = reader.readLine()) != null) {
				str = data.split(" ");
				sDao.insertStudent(new Stock(str[0], str[1]));
				System.out.println(str[0]+" " +str[1]);
				list = sDao.selectAll();
				System.out.println(list);
 		}
			else
				break;
		}
		reader.close();
	}
	
	

}
