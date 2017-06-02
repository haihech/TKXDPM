/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * Class này dùng để gán hình ảnh của bài đăng vào Jlabel
 * @author nhom06
 */
public class SetPicture {

    /**
     * Hàm này dùng để gán hình ảnh vào một JLabel
     * @param label là một JLabel
     * @param filename là tên của file ảnh
     */
    public static void setPicture(JLabel label, String filename) {

        File file = new File(filename);
        BufferedImage image;
        try {
            if (file.exists()) {
                image = ImageIO.read(file);
            } 
            else {
                image = ImageIO.read(new File("src/images/default.jpg"));
            }
            int x = label.getSize().width;
            int y = label.getSize().height;

            int ix = image.getWidth();
            int iy = image.getHeight();
            int dx, dy;

            if (x / y > ix / iy) {
                dy = y;
                dx = ix * dy / iy;
            } else {

                dx = x;
                dy = iy * dx / ix;
            }

            ImageIcon icon = new ImageIcon(image.getScaledInstance(dx, dy, image.SCALE_SMOOTH));
            label.setIcon(icon);

        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Error setPicture () : " + ex.getMessage());
        }
    }
}
