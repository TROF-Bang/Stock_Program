package jdbc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class newsDao {

	private Connection conn;    //DB 커넥션(연결) 객체
    private static final String USERNAME = "root";   //DB 접속시 ID
    private static final String PASSWORD = "1234";    //DB 접속시 패스워드
    //DB접속 경로(스키마=데이터베이스명)설정
    private static final String URL = "jdbc:mysql://localhost:3306/stockdata"; 
 
    //생성자
    public newsDao() {
        // connection객체를 생성해서 DB에 연결함.
        try {
            System.out.println("생성자");
           //동적 객체를 만들어줌 
            Class.forName("com.mysql.jdbc.Driver"); 
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("드라이버 로딩 성공!!");
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("드라이버 로드 실패!!");
        }
    }    
    
    //DB에 데이터를 저장하는 메서드
    public void insertStudent(Stock_news stock) {
        //쿼리문 준비
       String sql = "insert into stock values(?,?);";
        //DB에 값을 넣어주는 클래스(원래 Statement클래스로 하였으나,
       //사용하기가 즉 가독성이 좋치않아서, PreparedStatement클래스를
       //많이 사용한다.
       PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, stock.getData());   //첫 번째 ? 매핑
//            pstmt.setString(2, stock.getData()); //두 번째 ? 매핑
//            pstmt.setString(3, stock.getGrade());//세 번째 ? 매핑
            //쿼리문 실행하라.
            pstmt.executeUpdate();
            System.out.println("Student데이터 삽입 성공!");
        } catch (SQLException e) {            
           System.out.println("Student데이터 삽입 실패!");
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {                
                e.printStackTrace();
            }
        }
    }
    
 
    public void updateStudent(Student student) {
        String sql = "update student set name=?, grade=? where id = ?;";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, student.getName());
            pstmt.setString(2, student.getGrade());
            pstmt.setString(3, student.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //조건에 맞는 행을 DB에서 삭제하는 메서드
    public void deleteStudent(String id) {
        String sql = "delete from student where id = ?;";
        PreparedStatement pstmt = null;
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    //조건에 맞는 행을 DB에서 1개 행만 가져오는 메서드
    public Student selectOne(String id) {
        String sql = "select * from student where id = ?;";
        PreparedStatement pstmt = null;
        Student re = new Student();
        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, id);
            //pstmt.setString(2, id);  //and 조건이 붙을 때마다 추가한다. 
            ResultSet rs = pstmt.executeQuery();
            //select한 결과는 ResultSet에 담겨 리턴된다.
            if (rs.next()) {  //가져올 행이 있으면 true, 없으면 false
                re.setId(rs.getString("id"));
                re.setName(rs.getString("name"));
                re.setGrade(rs.getString("grade"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return re;
    }
    //student테이블에 존재하는 모든 행을 가져오는 메서드임
    public List<Stock> selectAll() {
       
       String sql = "select * from student;";
        PreparedStatement pstmt = null; 
        List<Stock> list = new ArrayList<Stock>();
        try {
            pstmt = conn.prepareStatement(sql);
            ResultSet re = pstmt.executeQuery();
 
            while (re.next()) {   //가져올게 있느냐?
            	Stock s = new Stock();
                s.setCODE(re.getString("CODE"));
                s.setCNAME(re.getString("CNAME"));
//                s.setGrade(re.getString("grade"));
                list.add(s);   //List<Student>에다가 추가함.
            } 
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null && !pstmt.isClosed())
                    pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
}
