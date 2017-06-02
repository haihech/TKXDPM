/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Boundary;

import Controller.ShowNewestController;
import Entity.Post;
import Entity.Restaurant;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 * Class này là một lớp giao giện dùng để hiển thị các bài viết mới nhất và các
 * chức năng khác của hệ thống
 * @author Ngô Quang Hải
 */
public class MainForm extends javax.swing.JFrame {

    /**
     * Creates new form MainForm
     */
    public MainForm() {
        initComponents();
        this.btnNhanxet.setEnabled(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btnShowNewestPosts = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblPost = new javax.swing.JScrollPane();
        tblNewestPosts = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        Image1 = new javax.swing.JLabel();
        lbPostID1 = new javax.swing.JLabel();
        lbAddress1 = new javax.swing.JLabel();
        lbContent1 = new javax.swing.JLabel();
        lbTime1 = new javax.swing.JLabel();
        btnNhanxet = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(240, 240, 240));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Mạng xã hội chia sẻ quán ăn");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(226, 229, 253));

        btnShowNewestPosts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnShowNewestPosts.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1436825468_find.png"))); // NOI18N
        btnShowNewestPosts.setText("Xem danh sách bài đăng mới nhất");
        btnShowNewestPosts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowNewestPostsActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Danh sách bài đăng");

        tblNewestPosts.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tblNewestPosts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblNewestPosts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNewestPostsMouseClicked(evt);
            }
        });
        tblPost.setViewportView(tblNewestPosts);

        jScrollPane1.setViewportView(tblPost);

        lbPostID1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbAddress1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbContent1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        lbTime1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(Image1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPostID1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addComponent(lbContent1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbTime1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(lbAddress1, javax.swing.GroupLayout.PREFERRED_SIZE, 756, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(lbPostID1, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbContent1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbAddress1, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbTime1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(Image1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnNhanxet.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnNhanxet.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/comment-icon.png"))); // NOI18N
        btnNhanxet.setText("Nhận xét");
        btnNhanxet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanxetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btnShowNewestPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 698, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 976, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnNhanxet, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(168, 168, 168))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(btnShowNewestPosts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnNhanxet, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Home-icon.png"))); // NOI18N
        jMenu1.setText("Trang chủ");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem6.setText("Thoát");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/up-icon.png"))); // NOI18N
        jMenu2.setText("Đăng bài");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem3.setText("Đăng bài chia sẻ");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem2.setText("Đăng bài hỏi");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/1436913859_icon-111-search.png"))); // NOI18N
        jMenu3.setText("Tìm kiếm");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem1.setText("Tìm kiếm quán ăn");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem4.setText("Tìm kiếm quanh địa điểm");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/like-icon.png"))); // NOI18N
        jMenu5.setText("Quán ăn yêu thích");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem5.setText("Xem danh sách yêu thích");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem5);

        jMenuBar1.add(jMenu5);

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Info.png"))); // NOI18N
        jMenu6.setText("Thông tin");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenuItem7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem7.setText("Sản phẩm");
        jMenu6.add(jMenuItem7);

        jMenuItem8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jMenuItem8.setText("Liên hệ");
        jMenu6.add(jMenuItem8);

        jMenuBar1.add(jMenu6);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new AddPostForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    /**
     * Hàm này để hiển thị danh sách các bài đăng bằng một bảng
     * @param list danh sách các bài đăng
     */
    public void displayPostList(ArrayList<Post> list) {
        int size = list.size();
        if (size > 0) {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Mã bài đăng");
            table.addColumn("Nhận xét");
            table.addColumn("Đăng lúc");
            table.addColumn("Mã người đăng");

            for (int i = 0; i < size; i++) {
                table.addRow(dataPost(list.get(i)));
            }
            tblNewestPosts.setModel(table);
            this.validate();

        } else {
            DefaultTableModel table = new DefaultTableModel();
            table.addColumn("Mã bài đăng");
            table.addColumn("Nhận xét");
            table.addColumn("Đăng lúc");
            table.addColumn("Mã người đăng");
            tblNewestPosts.setModel(table);
            this.validate();
            JOptionPane.showMessageDialog(null, "Không có bài đăng gần đây!");
        }

    }

    /**
     * Hàm này định dạng dữ liệu của bài đăng để hiển thị lên bảng
     * @param post là một Post
     * @return mảng chứa các đối tượng là các thuộc tính của bài đăng
     */
    private static Object[] dataPost(Post post) {
        Object[] data = {post.getID_P(), post.getContents(), post.getTime(), post.getID_M()};
        return data;
    }

    private void btnShowNewestPostsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowNewestPostsActionPerformed
        showListNewestPost();
    }//GEN-LAST:event_btnShowNewestPostsActionPerformed

    /**
     * Hàm này dùng để hiển thị danh sách các bài đăng mới nhất
     */
    public void showListNewestPost() {
        ShowNewestController showNewestController = new ShowNewestController();
        try {
            displayPostList(showNewestController.getNewestPosts());
        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void tblNewestPostsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNewestPostsMouseClicked
        showDetailPost();
    }//GEN-LAST:event_tblNewestPostsMouseClicked

    /**
     * Hàm này dùng để hiển thị chi tiết bài đăng
     */
    public void showDetailPost() {
        ShowNewestController showNewestController = new ShowNewestController();
        try {
            ArrayList<Post> listNewestPost = showNewestController.getNewestPosts();
            int index = this.tblNewestPosts.getSelectedRow();
            Post post = listNewestPost.get(index);
            Restaurant restaurant = new Restaurant();
            Restaurant infoRes = restaurant.getRestaurantByPostID(post.getID_P());
            if (infoRes == null) {
                this.lbPostID1.setText("Mã bài đăng: " + post.getID_P());
                this.lbContent1.setText("Nội dung: " + post.getID_M());
                this.lbAddress1.setText("Đăng lúc: " + post.getTime());
                this.lbTime1.setText("Mã người đăng: " + post.getID_M() );
                this.Image1.setEnabled(false);
 
            } else {
                this.Image1.setEnabled(true);
                this.lbPostID1.setText("Mã bài đăng: " + post.getID_P() + "               " + "Đăng lúc: " + post.getTime());
                this.lbContent1.setText("Nhận xét: " + post.getContents());
                this.lbAddress1.setText("Tên quán: " + infoRes.getName() + "               " + "Phố: " + infoRes.getStreet());
                this.lbTime1.setText("Đường: " +infoRes.getPrecint() + "         " + "Quận: " + infoRes.getDistrict()+ "        " + "Thành phố: " + infoRes.getCity());
                infoRes.setImage(Image1);
            }
            
            this.btnNhanxet.setEnabled(true);

        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        new SearchRestaurantForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btnNhanxetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanxetActionPerformed
        ShowNewestController showNewestController = new ShowNewestController();
        try {
            ArrayList<Post> listNewestPost = showNewestController.getNewestPosts();
            int index = this.tblNewestPosts.getSelectedRow();
            Post post = listNewestPost.get(index);
            Restaurant restaurant = new Restaurant();
            Restaurant infoRes = restaurant.getRestaurantByPostID(post.getID_P());
            
            new CommentForm(post, infoRes).setVisible(true);

        } catch (SQLException ex) {
            Logger.getLogger(MainForm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNhanxetActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new FavoriteResForm().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new PostQuestion().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new SearchPlaceNear().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        super.dispose();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Image1;
    private javax.swing.JButton btnNhanxet;
    private javax.swing.JButton btnShowNewestPosts;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbAddress1;
    private javax.swing.JLabel lbContent1;
    private javax.swing.JLabel lbPostID1;
    private javax.swing.JLabel lbTime1;
    private javax.swing.JTable tblNewestPosts;
    private javax.swing.JScrollPane tblPost;
    // End of variables declaration//GEN-END:variables
}