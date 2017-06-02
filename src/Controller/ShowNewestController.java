/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Post;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 * Class này điều khiển chức năng xem các bài đăng mới nhất
 * @author Ngô Quang Hải
 */
public class ShowNewestController {

    private static ShowNewestController me;

    /**
     * Phương thức khởi tạo mặc định
     */
    public ShowNewestController() {}

    /**
     * Hàm này khởi tạo cho đối tượng dùng chung duy nhất của ShowNewestController nếu đối tượng đố null
     * @return đối tượng dùng chung duy nhất của ShowNewestController
     */
    public static ShowNewestController getInstance() {
        if (me == null) {
            me = new ShowNewestController();
        }
        return me;
    }

    /**
     * Hàm này lấy về danh sách các bài đăng mới nhất trong thời gian gần đây
     * @return danh sách các bài đăng mới nhất
     * @throws SQLException
     */
    public ArrayList<Post> getNewestPosts() throws SQLException {
        Post post = new Post();
        ArrayList<Post> listNewestPost = post.getListNewestPost();
        return listNewestPost;
    }
}
