/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Restaurant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class này điều khiển chức năng tìm kiếm quán ăn
 * @author nhom06
 */
public class SearchRestaurantController {
    
    public SearchRestaurantController(){}
    
    /**
     * Hàm này để tìm kiếm các quán ăn theo tên quán ăn hoặc địa chỉ
     * @param restaurantName : têm quán ăn
     * @param street : phố
     * @return : ArrayList chứa các quán ăn
     * @throws SQLException
     */
    public ArrayList<Restaurant> getListResByNameOrAddress(String restaurantName, String street) throws SQLException{
        Restaurant restaurant = new Restaurant();
        return restaurant.getListResByNameOrAddress(restaurantName, street);
    }
    
    /**
    * Phương thức này điều khiển việc tìm kiếm địa điểm gần một địa điểm
    * @param district là quận
    * @return ResultSet
    */
    public ResultSet searchPlaceNear(String district){
        Restaurant res = new Restaurant();
        return res.searchPlaceNear(district);
    }
    
    /**
    * Phương thức này thực hiện việc tìm kiếm địa điểm theo ID
    * @param ID_R là mã quán ăn
    * @return ResultSet
    */
    public ResultSet searchPlace(int ID_R){
        Restaurant res = new Restaurant();
        return res.searchPlace(ID_R);
    }
}
