/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Rate;
import Entity.Restaurant;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Class này điều khiển chức năng xem danh sách quan ăn yêu thích
 * @author Nguyễn Ngọc Hiệp
 */
public class FavoriteResController {
    
    /**
     * Phương thức khởi tạo mặc định
     */
    public FavoriteResController(){}
    
     /**
     * Hàm này lấy các quán ăn được yêu thích
     * @return : ArrayList các quán ăn
     * @throws SQLException
     */
    public ArrayList<Restaurant> getListFavoriteRestaurant() throws SQLException {
        ArrayList<Restaurant> listRes = new ArrayList<>();
        Rate rate = new Rate();
        Restaurant restaurant = new Restaurant();
        ArrayList<Integer> list = rate.getIDResFavorited();
        if(list.isEmpty()){
            return null;
        }
        else{
            for(int i = 0; i < list.size(); i++){
                listRes.add(restaurant.getRestaurantByResID(list.get(i)));
            }
        }
        return listRes;
    }
}
