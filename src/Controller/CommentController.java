/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Comment;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class này điều khiển chức năng nhận xét bài đăng
 * @author Nguyễn Ngọc Hiệp
 */
public class CommentController {
    
    /**
     * Phương thức khởi tạo mặc định
     */
    public CommentController(){}
    
    
    /**
     * Hàm này lấy các comment theo mã bài đăng
     * @param postID là mã bài đăng
     * @return ArrayList các comment
     * @throws SQLException
     */
    public ArrayList<Comment> getListCommentByPostID(int postID) throws SQLException{
        Comment comment = new Comment();
        return comment.getListCommentByPostID(postID);
    }
    
    /**
     * Hàm này thêm bài đăng vào CSDL
     * @param postID là mã bài đăng
     * @param comment là 1 Comment
     */
    public void addComment(int postID, Comment comment){
        comment.addComment(postID);
    }
}
