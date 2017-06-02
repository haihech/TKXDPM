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
 * Class này quản lý các thông tin liên quan đến Comment
 * @author Nguyễn Ngọc Hiệp
 */
public class Comment {
    private int commentID;
    private int postID;
    private String content;
    private String date;
    
    /**
     * Phuong thức khởi tạo mặc định
     */
    public Comment(){}

    /**
     * Phương thức khởi tạo với tham số
     * @param commentID : là mã của nhận xét
     * @param postID : mã của bài đăng
     * @param content : nội dung nhận xét
     * @param date : thời gian đăng
     */
    public Comment(int commentID, int postID, String content, String date) {
        this.commentID = commentID;
        this.postID = postID;
        this.content = content;
        this.date = date;
    }

    /**
     * Hàm này để lấy mã của nhận xét
     * @return int là commentID
     */
    public int getCommentID() {
        return commentID;
    }

    /** 
     * Hàm này để gán giá trị cho mã nhận xét
     * @param commentID là commentID
     */
    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    /**
     * Hàm này để lấy mã của bài đăng
     * @return int là postID
     */
    public int getPostID() {
        return postID;
    }

    /**
     * Hàm này để gán giá trị cho postID
     * @param postID là postID
     */
    public void setPostID(int postID) {
        this.postID = postID;
    }

    /**
     * Hàm này để lấy giá trị của nội dung bài đăng
     * @return A String là content
     */
    public String getContent() {
        return content;
    }

    /**
     * Hàm này để gán giá trị cho content
     * @param content là content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Hàm này để lấy ngày đăng nhận xét
     * @return A String là date
     */
    public String getDate() {
        return date;
    }

    /**
     * Hàm này để gán giá trị cho date
     * @param date là date
     */
    public void setDate(String date) {
        this.date = date;
    }
    
    /**
     * Hàm này để lấy các Comment theo mã của bài đăng
     * @param postID : mã của bài đăng
     * @return ArrayList chứa các Comment
     * @throws SQLException
     */
    public ArrayList<Comment> getListCommentByPostID(int postID) throws SQLException
    {
        ArrayList<Comment> listComments = new ArrayList<>();
        String queryStr = "select * from comment where ID_P ="+postID;
        
        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);
        ResultSet rs = stmt.executeQuery(queryStr);

        //Check empty result
        if (!rs.first()); else {
            do {
                int ID = rs.getInt("ID");
                int post = rs.getInt("ID_P");
                String cont = rs.getString("contents");  
                Date timePost = rs.getDate("date");
                DateFormat df = new SimpleDateFormat("ss:MM:hh dd/MM/yyyy");
                String dateStr = df.format(timePost);

                listComments.add(new Comment(ID, post, cont, dateStr));
            } while (rs.next());
        }
        conn.close();
        
        return listComments;
    }
    
    /**
     * Hàm này để thêm comment vào CSDL
     * @param id : mã của bài đăng
     */
    public void addComment(int id){
        String addStr = "INSERT INTO comment(ID_P,contents,date) VALUES(?,?,?)";
        try {
            Connection conn = ConnectToDB.getConnection();
            PreparedStatement addStmt = conn.prepareStatement(addStr);
            addStmt.setInt(1, id);
            addStmt.setString(2, content);
            addStmt.setString(3, date);

            addStmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
