/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Post;
import Entity.Restaurant;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class này điều khiển chức năng đăng bài
 * @author nhom06
 */
public class AddPostController {
    
    /**
     * Phương thức khởi tạo mặc định
     */
    public AddPostController(){}
    
    /**
    * Phương thức này điều khiển việc đăng bài chia sẻ quán ăn
    * @param sharePost là nội dung bài đăng
    * @param restaurant là quán ăn chia sẻ
    * @throws SQLException
    */
    public void addSharePost(Post sharePost, Restaurant restaurant) throws SQLException{
        sharePost.addPost();
        int postID = sharePost.getMaxPostID();
        restaurant.addRestaurant(postID);
    }
    
    /**
    * Phương thức này điều khiển việc đăng bài hỏi
    * @param contents là nội dung bài đăng
    * @see SQLException
    */
    public void PostQuestion(String contents){
        Post post = new Post();
        post.setID_M("1");
        post.setContents(contents);
        
        Date date = new Date();
        Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        post.setTime(formatter.format(date));
        
        try {
            post.addPost();
        } catch (SQLException ex) {
            Logger.getLogger(AddPostController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
        
}
