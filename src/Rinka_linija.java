import java.awt.Color;
import java.awt.Graphics;
import java.lang.Math.*;
import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.round;

public class Rinka_linija extends javax.swing.JFrame {
boolean click = true;
int xc;
int yc;
int rx;
int ry;


    public Rinka_linija() {
        initComponents();
        
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(500, 500));
        setSize(new java.awt.Dimension(500, 500));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        jButton1.setText("Click");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Radiuss=");

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTextField1.setText("121");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        Graphics g = jPanel1.getGraphics();
        int width = jPanel1.getWidth();
        int height = jPanel1.getHeight();
        g.setColor(Color.black);
        g.drawLine(0, 0, width, height);
        g.drawLine(0, height, width, 0);
        g.drawLine(width/2, 0, width/2, height);
        g.drawLine(0, height/2, width, height/2);
        int xc = width/2;
        int yc = height/2;
        int r = Integer.parseInt(jTextField1.getText());
        
        g.setColor(Color.orange);
        int xn = 0;
        int yn = r;
        int pn = 1-r;
        while(xn<yn){
            if (pn<0)  {
                xn= xn+1;
                pn = pn + 2 * (xn)+1;
            }else{
                xn = xn+1;
                yn= yn - 1;
                pn = pn + 2 * xn - 2 * yn + 1;
            }
            g.fillRect(xc+xn, yc+yn, 1, 1);
            g.fillRect(xc+xn, yc-yn, 1, 1);
            g.fillRect(xc-xn, yc+yn, 1, 1);
            g.fillRect(xc-xn, yc-yn, 1, 1);
            
            g.fillRect(xc+yn, yc+xn, 1, 1);
            g.fillRect(xc+yn, yc-xn, 1, 1);
            g.fillRect(xc-yn, yc+xn, 1, 1);
            g.fillRect(xc-yn, yc-xn, 1, 1);
        }
        
                
    }//GEN-LAST:event_jButton1ActionPerformed

   
    
    private void jPanel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseClicked
        Graphics g = jPanel1.getGraphics();
        int width = jPanel1.getWidth();
        int height = jPanel1.getHeight();
        
        if (evt.getClickCount() % 2 ==1/* click == true*/) {
            int xc = evt.getX();
            int yc = evt.getY();
            click = false;
        }else{
            double rx = abs(evt.getX()-xc);
            double ry = abs(evt.getY()-yc);
            click = true;
        }
        
        
        int r = (int)Math.round(Math.sqrt((pow(rx,2)+pow(ry,2))));
        g.setColor(Color.cyan);
        int xn = 0;
        int yn = r;
        int pn = 1-r;
        while(xn<yn){
            if (pn<0)  {
                xn= xn+1;
                pn = pn + 2 * (xn)+1;
            }else{
                xn = xn+1;
                yn= yn - 1;
                pn = pn + 2 * xn - 2 * yn + 1;
            }
            g.fillRect(xc+xn, yc+yn, 1, 1);
            g.fillRect(xc+xn, yc-yn, 1, 1);
            g.fillRect(xc-xn, yc+yn, 1, 1);
            g.fillRect(xc-xn, yc-yn, 1, 1);
            
            g.fillRect(xc+yn, yc+xn, 1, 1);
            g.fillRect(xc+yn, yc-xn, 1, 1);
            g.fillRect(xc-yn, yc+xn, 1, 1);
            g.fillRect(xc-yn, yc-xn, 1, 1);
        }
       
       
    }//GEN-LAST:event_jPanel1MouseClicked

 
    public static void main(String args[]) {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Rinka_linija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Rinka_linija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Rinka_linija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Rinka_linija.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
 
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Rinka_linija().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
