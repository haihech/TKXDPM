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
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Class này quản lý thông tin liên quan đến Rate
 * @author Ngô Quang Hải
 */
public class Rate {

    private int rateID;
    private int restaurantID;
    private int ratePoint;
    private String rateDate;

    /**
     * Phương thức khởi tạo mặc định
     */
    public Rate() {

    }

    /**
     * Phương thức khởi tạo với tham số
     * @param rateID : Mã của đánh giá
     * @param restaurantID : Mã của quán ăn
     * @param ratePoint : Điểm đánh giá
     * @param rateDate : Ngày đánh giá
     */
    public Rate(int rateID, int restaurantID, int ratePoint, String rateDate) {
        this.rateID = rateID;
        this.restaurantID = restaurantID;
        this.ratePoint = ratePoint;
        this.rateDate = rateDate;
    }

    /**
     * Hàm này để lấy mã của đánh giá
     * @return String là rateID
     */
    public int getRateID() {
        return rateID;
    }

    /**
     * Hàm này để gán giá trị cho rateID
     * @param rateID là rateID
     */
    public void setRateID(int rateID) {
        this.rateID = rateID;
    }

    /**
     * Hàm này để lấy mã của quan an
     * @return String là restaurantID
     */
    public int getRestaurantID() {
        return restaurantID;
    }

    /**
     * Hàm này để gán giá trị cho restaurantID
     * @param restaurantID là restaurantID
     */
    public void setRestaurantID(int restaurantID) {
        this.restaurantID = restaurantID;
    }

    /**
     * Hàm này để lấy điểm của đánh giá
     * @return Integer là ratePoint
     */
    public int getRatePoint() {
        return ratePoint;
    }

    /**
     * Hàm này để gán trị cho ratePoint
     * @param ratePoint là ratePont
     */
    public void setRatePoint(int ratePoint) {
        this.ratePoint = ratePoint;
    }

    /**
     * Hàm này để lấy giá trị của thời gian đánh giá
     * @return String là rateDate
     */
    public String getRateDate() {
        return rateDate;
    }

    /**
     * Hàm này để gán trị cho rateDate
     * @param rateDate là rateDate
     */
    public void setRateDate(String rateDate) {
        this.rateDate = rateDate;
    }

    /**
     * Hàm này thêm đánh giá vào cơ sở dữ liệu
     */
    public void addRate() {
        String addStr = "INSERT INTO rate(ID_R,point,date) VALUES(?,?,?)";
        try {
            Connection conn = ConnectToDB.getConnection();
            PreparedStatement addStmt = conn.prepareStatement(addStr);
            addStmt.setInt(1, restaurantID);
            addStmt.setInt(2, ratePoint);
            addStmt.setString(3, rateDate);

            addStmt.addBatch();
            addStmt.executeBatch();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Information invalid. Input again!");
        }
    }

    
    /**
     * Hàm này lấy điểm đánh giá trung bình của 1 quán ăn thông qua mã của quán ăn
     * @param id là restaurantID
     * @return điểm đánh giá trung bình của 1 quán ăn
     * @throws SQLException
     */
    public double getAverageRate(int id) throws SQLException {

        double average = 0;
        String query = "select avg(point) as TB from rate where ID_R = " + id + ";";

        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);

        if (!rs.first()) {
            System.out.println("No have records");
        } else {
            average = rs.getDouble("TB");
            DecimalFormat df = new DecimalFormat("###.##");
            return Double.parseDouble(df.format(average));
        }
        return average;
    }

    /**
     * Hàm này lấy tổng số đánh giá của 1 quán ăn thông qua mã của quán ăn
     * @param id là restaurantID
     * @return tổng số đánh giá của 1 quán ăn
     * @throws SQLException
     */
    public int getNumberRateByID(int id) throws SQLException {
        int count = 0;
        String query = "select count(*) as number from rate where ID_R = " + id + ";";
        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);
        if (!rs.first()) {
            System.out.println("No have records");
        } else {
            count = rs.getInt("number");
        }
        return count;
    }
    

    /**
     * Hàm này lấy tổng số đánh giá của 1 quán ăn thông qua mã của quán ăn và loại điểm đánh giá
     * @param id là restaurantID
     * @param pointType là 5 loại điểm đánh giá từ 1 đến 5
     * @return số lượng đánh giá của quán ăn
     * @throws SQLException
     */
    public int getNumberRateByType(int id, int pointType) throws SQLException {
        int count = 0;
        String query = "select count(*) as number from rate where ID_R = " + id + " and point = " + pointType + ";";
        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);
        if (!rs.first()) {
            System.out.println("No have records");
        } else {
            count = rs.getInt("number");
        }
        return count;
    }
    
    /**
     * Hàm này lấy các mã của quán ăn có điểm đánh giá cao và số lượng đánh giá đủ lớn
     * @return ArrayList chứa các mã của quán ăn
     * @throws SQLException
     */
    public ArrayList<Integer> getIDResFavorited() throws SQLException {
        ArrayList<Integer> list = new ArrayList<>();
        String query = "select distinct ID_R as favorite FROM mxh.rate group by ID_R having avg(point) >= 4 and count(*) > 5;";
        Connection conn = ConnectToDB.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query);
        ResultSet rs = stmt.executeQuery(query);
        if (!rs.first()) {
            System.out.println("No have records");
        } else {
            do {
                list.add(rs.getInt("favorite"));
            } while (rs.next());
        }
        conn.close();
        return list;
    }
}

