/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Entity.Rate;
import java.sql.SQLException;

/**
 * Class này để điều khiển các chức năng liên quan đến rate
 * @author Ngô Quang Hải
 */

public class RateController {

    /**
     * Phương thức khởi tạo mặc định
     */
    public RateController() {
    }

    /**
     * Hàm này lấy số lượng đánh giá của 1 quán ăn trong CSDL thông qua mã của nó
     * @param id : mã của quán ăn
     * @return : Integer là số lượng đánh giá của quán ăn
     * @throws SQLException
     */
    public int getNumberRateByID(int id) throws SQLException {
        Rate rate = new Rate();
        int numberRate = rate.getNumberRateByID(id);
        return numberRate;
    }

    /**
     * Hàm này lấy số lượng đánh giá của 1 quán ăn trong CSDL thông qua mã của quán ăn và loại điểm đánh giá
     * @param id là mã của quán ăn
     * @param pointType là 5 loại điểm đánh giá từ 1 đến 5
     * @return Integer là số lượng đánh giá của quán ăn
     * @throws SQLException
     */
    public int getNumberRateByType(int id, int pointType) throws SQLException {
        Rate rate = new Rate();
        int numberRatebyType = rate.getNumberRateByType(id, pointType);
        return numberRatebyType;
    }

    /**
     * Hàm này để thêm 1 đánh giá vào cơ sở dữ liệu
     * @param rate
     */
    public void addRatePost(Rate rate) {
        rate.addRate();
    }

    /**
     * Hàm này để lấy giá trị điểm đánh giá trung bình của quán ăn trong cơ sở dữ liệu
     * @param id là mã của quán ăn
     * @return Double là điểm đánh giá trung bình của quán ăn
     * @throws SQLException
     */
    public double getAverageRatePost(int id) throws SQLException {
        Rate rate = new Rate();
        return rate.getAverageRate(id);
    }
    
}

