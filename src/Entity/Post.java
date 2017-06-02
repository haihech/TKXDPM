/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class này quản lý các thông tin liên quan đến Post
 * @author nhom06
 */
public class Post {
    private int ID_P;
    private String contents;
    private String time;
    private String ID_M;
    
    /**
    * Phương thức khởi tạo mặc định
    */ 
    public Post(){
        
    }

    /**
    * Hàm này để khởi tạo giá trị cho đối tượng Post
    * @param ID_P : mã của bài đăng
    * @param contents : Nội dung bài đăng (nhận xét của người đăng)
    * @param time : Thời gian đăng bài
    * @param ID_M : Mã của người đăng
    */ 
    public Post(int ID_P, String contents, String time, String ID_M) {
        this.ID_P = ID_P;
        this.contents = contents;
        this.time = time;
        this.ID_M = ID_M;
    }

    /**
    * Hàm này để lấy ra ID_P
    * @return String là ID_P
    */ 
    public int getID_P() {
        return ID_P;
    }

    /**
    * Hàm này để gán giá trị cho ID_P
    * @param ID_P là ID_P
    */
    public void setID_P(int ID_P) {
        this.ID_P = ID_P;
    }

    /**
    * Hàm này để lấy ra contents
    * @return String là contents
    */
    public String getContents() {
        return contents;
    }

    /**
    * Hàm này để gán giá trị cho contents
    * @param contents là contents
    */ 
    public void setContents(String contents) {
        this.contents = contents;
    }

    /**
    * Hàm này để lấy ra time
    * @return String là time
    */ 
    public String getTime() {
        return time;
    }

    /**
    * Hàm này để gán giá trị cho time
    * @param time là time
    */
    public void setTime(String time) {
        this.time = time;
    }

    /**
    * Hàm này để lấy ra ID_M
    * @return String là ID_M
    */ 
    public String getID_M() {
        return ID_M;
    }

    /**
    * Hàm này để gán giá trị cho ID_M
    * @param ID_M là ID_M
    */ 
    public void setID_M(String ID_M) {
        this.ID_M = ID_M;
    }
    
    /**
    * Hàm này thực hiện việc thêm mới bài đăng vào cơ sở dữ liệu
    * @return void
    * @throws SQLException
    * @see SQLException
    */
    public void addPost() throws SQLException {

        String queryStr = "insert into post(contents,time,ID_M) values (?,?,?)";

        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);

        stmt.setString(1, contents);
        stmt.setString(2, time);
        stmt.setString(3, ID_M);
        
        stmt.executeUpdate();
        conn.close();

    }
    
    /**
    * Hàm này thực hiện việc lấy các bài đăng mới nhất
    * @return ArrayList các bài đăng
    * @throws SQLException
    */
    public ArrayList<Post> getListNewestPost() throws SQLException {

        ArrayList<Post> listNewestPost = new ArrayList<>();
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String timeCurrent = dateFormat.format(date);
        String queryStr = "select *from post where datediff(" + "'" + timeCurrent + "'," + "time)" + "< 1";

        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);
        ResultSet rs = stmt.executeQuery(queryStr);

        //Check empty result
        if (!rs.first()); else {
            do {
                int ID = rs.getInt("ID_P");
                String content = rs.getString("contents");
                String memberID = rs.getString("ID_M");  
                Date timePost = rs.getDate("time");
                DateFormat df = new SimpleDateFormat("ss:MM:hh dd/MM/yyyy");
                String dateStr = df.format(timePost);

                listNewestPost.add(new Post(ID, content, dateStr, memberID));
            } while (rs.next());
        }
        conn.close();

        return listNewestPost;

    }
    
    /**
    * Hàm này thực hiện việc lấy mã bài đăng lớn nhất
    * @return int là mã bài đăng
    * @throws SQLException
    */
    public int getMaxPostID() throws SQLException {
        int maxPostID = 0;
        String queryStr = "SELECT ID_P as maxID FROM mxh.post where ID_P = (SELECT max(ID_P) FROM mxh.post);";
        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);
        ResultSet rs = stmt.executeQuery(queryStr);
        
        if(!rs.next());
        else{
            maxPostID = rs.getInt("maxID");
        }
        
        return maxPostID;
                
    }
        
}
