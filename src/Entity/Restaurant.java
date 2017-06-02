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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;


/**
 * Class này để quản lý thông tin liên quan đến Restaurant
 * @author nhom06
 */
public class Restaurant {

    private int ID_R;
    private String name;
    private String street;
    private String precint;
    private String district;
    private String city;
    private String image;
    private int ID_P;

    /**
     * Phương thức khởi tạo mặc định
     */
    public Restaurant() {
    }

    /**
     * Phương thức khởi tạo với tham số
     * @param ID_R : Mã của quán ăn
     * @param name : Tên quán ăn
     * @param street : Phố (địa chỉ quán ăn)
     * @param precint : Đường (địa chỉ quán ăn)
     * @param district  : Quận (địa chỉ quán ăn)
     * @param city : Thành phố (địa chỉ quán ăn)
     * @param image : Tên file ảnh
     * @param ID_P : Mã của bài post
     */
    public Restaurant(int ID_R, String name, String street, String precint, String district, String city, String image, int ID_P) {
        this.ID_R = ID_R;
        this.name = name;
        this.street = street;
        this.precint = precint;
        this.district = district;
        this.city = city;
        this.image = image;
        this.ID_P = ID_P;
    }

    /**
     * Hàm này để lấy mã của quán ăn
     * @return A Integer là ID_R
     */
    public int getID_R() {
        return ID_R;
    }

    /**
     * Hàm này để gán giá trị cho mã quán ăn
     * @param ID_R là ID_R
     */
    public void setID_R(int ID_R) {
        this.ID_R = ID_R;
    }

    /**
     * Hàm này để lấy tên của quán ăn
     * @return A String là name
     */
    public String getName() {
        return name;
    }

    /**
     * Hàm này để gán giá trị cho tên quán ăn
     * @param name là name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Hàm này để lấy tên phố
     * @return A String là street
     */
    public String getStreet() {
        return street;
    }

    /**
     * Hàm này để gán giá trị cho tên phố
     * @param street là street
     */
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * Hàm này để lấy tên đường
     * @return A String là precint
     */
    public String getPrecint() {
        return precint;
    }

    /**
     * Hàm này để gán giá trị cho tên đường
     * @param precint là precint
     */
    public void setPrecint(String precint) {
        this.precint = precint;
    }

    /**
     * Hàm này để lấy tên quận
     * @return A String là district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Hàm này để gán giá trị cho tên quận
     * @param district là district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Hàm này để lấy tên thành phố
     * @return A String là city
     */
    public String getCity() {
        return city;
    }

    /**
     * Hàm này để gán giá trị cho tên thành phố
     * @param city là city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Hàm này để lấy mã của bài post
     * @return A Integer là ID_P
     */
    public int getID_P() {
        return ID_P;
    }

    /**
     * Hàm này để gán giá trị cho mã bài đăng
     * @param ID_P là ID_P
     */
    public void setID_P(int ID_P) {
        this.ID_P = ID_P;
    }
    
    /**
     * Hàm này để gán giá trị cho tên file ảnh
     * @param image là image
     */
    public void setStrImage(String image){
        this.image = image;
    }
    
    /**
     * Hàm này để gán ảnh cho quán ăn
     * @param label A label để hiển thị ảnh
     */
    public void setImage(JLabel label) {
        String srcImage = "src/images/";
        String path;
        if (image == null) {
            path = srcImage + "default.jpg";
        } else {
            path = srcImage + image + ".jpg";
        }

        SetPicture.setPicture(label, path);
    }

    /**
    * Hàm này thực hiện việc thêm một quán ăn vào cơ sở dữ liệu
    * @param postID là mã bài đăng
    * @throws SQLException
    * @see SQLException
    */
    public void addRestaurant(int postID) throws SQLException {
        String queryStr = "insert into restaurant(name,street,precint,district,city,image,ID_P)"
                + "values (?,?,?,?,?,?,?)";
        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);

        stmt.setString(1, name);
        stmt.setString(2, street);
        stmt.setString(3, precint);
        stmt.setString(4, district);
        stmt.setString(5, city);
        stmt.setString(6, image);
        stmt.setInt(7, postID);

        stmt.executeUpdate();
        conn.close();
    }

    /**
     * Hàm này để tìm kiếm các quán ăn theo tên quán ăn hoặc địa chỉ
     * @param restaurantName : têm quán ăn
     * @param street : phố
     * @return : ArrayList chứa các quán ăn
     * @throws SQLException
     */
    public ArrayList<Restaurant> getListResByNameOrAddress(String restaurantName, String street) throws SQLException {
        ArrayList<Restaurant> listRestaurant = new ArrayList<>();

        String queryStr;
        if (restaurantName.compareTo("") == 0) {
            queryStr = "select distinct * from restaurant where street like '%" + street + "%';";
        } else if (street.compareTo("") == 0) {
            queryStr = "select distinct * from restaurant where name like '%" + restaurantName + "%';";
        } else {
            queryStr = "select distinct * from restaurant where name like '%" + restaurantName + "%' or street like '%" + street + "%';";
        }

        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);
        ResultSet rs = stmt.executeQuery(queryStr);

        //Check empty result
        if (!rs.first()); else {
            do {
                int ID = rs.getInt("ID_R");
                String nameRes = rs.getString("name");
                String str = rs.getString("street");
                String precintRes = rs.getString("precint");
                String districtRes = rs.getString("district");
                String cityRes = rs.getString("city");
                int ID_PRes = rs.getInt("ID_P");
                String imageRes = rs.getString("image");

                listRestaurant.add(new Restaurant(ID, nameRes, str, precintRes, districtRes, cityRes, imageRes, ID_PRes));
            } while (rs.next());
        }
        conn.close();
        return listRestaurant;
    }

    /**
     * hàm này để lấy quán ăn theo mã của bài đăng
     * @param postID : Mã của bài đăng
     * @return A Restaurant
     * @throws SQLException
     */
    public Restaurant getRestaurantByPostID(int postID) throws SQLException {
        String queryStr = "select * from restaurant where ID_P = " + postID + ";";

        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);
        ResultSet rs = stmt.executeQuery(queryStr);

        //Check empty result
        if (!rs.first()); else {
            do {
                int ID = rs.getInt("ID_R");
                String nameRes = rs.getString("name");
                String str = rs.getString("street");
                String precintRes = rs.getString("precint");
                String districtRes = rs.getString("district");
                String cityRes = rs.getString("city");
                int ID_PRes = rs.getInt("ID_P");
                String imageRes = rs.getString("image");

                return new Restaurant(ID, nameRes, str, precintRes, districtRes, cityRes, imageRes, ID_PRes);
            } while (rs.next());
        }
        conn.close();

        return null;
    }

    /**
     * Hàm này để lấy quán ăn theo mã quán ăn
     * @param resID : mã của quán ăn
     * @return A Restaurant
     * @throws SQLException
     */
    public Restaurant getRestaurantByResID(int resID) throws SQLException {
        String queryStr = "select * from restaurant where ID_R = " + resID + ";";

        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(queryStr);
        ResultSet rs = stmt.executeQuery(queryStr);

        //Check empty result
        if (!rs.first()); else {
            do {
                int ID = rs.getInt("ID_R");
                String nameRes = rs.getString("name");
                String str = rs.getString("street");
                String precintRes = rs.getString("precint");
                String districtRes = rs.getString("district");
                String cityRes = rs.getString("city");
                int ID_PRes = rs.getInt("ID_P");
                String imageRes = rs.getString("image");

                return new Restaurant(ID, nameRes, str, precintRes, districtRes, cityRes, imageRes, ID_PRes);
            } while (rs.next());
        }
        conn.close();

        return null;
    }

    /**
     * Hàm này thực hiện việc tìm danh sách quán ăn theo dữ liệu nhập vào là tên phường
     * @param district là tên phường
     * @return ResultSet lưu danh sách quán ăn
     * @see SQLException
     */
    public ResultSet searchPlaceNear(String district) {
        ResultSet rs = null;
        try {
            Connection conn = ConnectToDB.getConnection();
            String sql = "SELECT * FROM restaurant WHERE district IN (SELECT place1 FROM near WHERE place2 = ?)\n"
                    + "UNION\n"
                    + "SELECT * FROM restaurant WHERE district IN (SELECT place2 FROM near WHERE place1 = ?)\n"
                    + "UNION\n"
                    + "SELECT * FROM restaurant WHERE district = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, district);
            stmt.setString(2, district);
            stmt.setString(3, district);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    /**
     * Hàm này thực hiện việc tìm quán ăn theo ID
     * @param ID_R là mã quán ăn
     * @return ResultSet lưu danh sách quán ăn
     * @see SQLException
     */
    public ResultSet searchPlace(int ID_R) {
        ResultSet rs = null;
        try {
            Connection conn = ConnectToDB.getConnection();
            String sql = "SELECT * FROM restaurant WHERE ID_R = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, ID_R);

            rs = stmt.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(Restaurant.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rs;
    }
}
