/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_assesment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hritik Gandhi
 */
public class VendorOrder extends javax.swing.JFrame {

    /**
     * Creates new form VendorOrder
     */
    Connection con;
    Statement st;
    ResultSet rs;
    public VendorOrder() {
        initComponents();
        connect();
        FillCombo1();
        FillCombo2();
    }
public void connect()
    {
       try
       {
       
       con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Hritik Gandhi\\OneDrive\\Netbeans\\Internal_Assesment\\db1.accdb");       
       st = con.createStatement();
       
       }
       catch(Exception ex)
       {
           textComponent.append("Error Connecting to the Database..."+"\n\r");
       }
    }
    private void FillCombo1()
    {
        int t = 0;
        try
        {
           String sql = "select * from VendorDB";
           rs = st.executeQuery(sql);
           
           while(rs.next())
           {
               t++;
               String name = rs.getString("name");
               vendorSelector.addItem(name);
           }
            System.out.println("");
        }
        catch(Exception e)
        {
            textComponent.append("Error Filling Combo Box..."+"\n\r");
        }
    }
    private void FillCombo2()
    {
        try
        {
           String sql = "select * from InventoryDB";
           rs = st.executeQuery(sql);
           
           while(rs.next())
           {
               String name = rs.getString("Books");
               bookSelector.addItem(name);
           }
        }
        catch(Exception e)
        {
            textComponent.append("Error Filling Combo Box..."+"\n\r");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Title = new javax.swing.JLabel();
        labelVendor = new javax.swing.JLabel();
        vendorSelector = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        inputQty = new javax.swing.JTextField();
        booklabel = new javax.swing.JLabel();
        bookSelector = new javax.swing.JComboBox<>();
        AddButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        textComponent = new javax.swing.JTextArea();
        backButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Title.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        Title.setText("Place Order");

        labelVendor.setText("Select Vendor:");

        vendorSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--" }));
        vendorSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vendorSelectorActionPerformed(evt);
            }
        });

        jLabel1.setText("Qty:");

        booklabel.setText("Select Books:");

        bookSelector.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Select--" }));
        bookSelector.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookSelectorActionPerformed(evt);
            }
        });

        AddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/internal_assesment/save-icon1px.png"))); // NOI18N
        AddButton.setText("Save Order");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        textComponent.setEditable(false);
        textComponent.setColumns(20);
        textComponent.setRows(5);
        jScrollPane1.setViewportView(textComponent);

        backButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/internal_assesment/back-icon.png"))); // NOI18N
        backButton.setText("Go Back");
        backButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Title)
                            .addComponent(labelVendor)
                            .addComponent(vendorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 203, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backButton, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddButton, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(booklabel)
                                .addGap(41, 41, 41)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(bookSelector, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputQty)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(labelVendor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(vendorSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(booklabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputQty, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bookSelector, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AddButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(backButton)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        String n = vendorSelector.getSelectedItem().toString();
        textComponent.append("Email Has been Sent to "+n+"\n\r");        // TODO add your handling code here:
    }//GEN-LAST:event_AddButtonActionPerformed

    private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
        MainUI.main();        
        setVisible(false); 
        dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_backButtonActionPerformed

    private void bookSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bookSelectorActionPerformed

    private void vendorSelectorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vendorSelectorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vendorSelectorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main() {
        new VendorOrder();/* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(VendorOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VendorOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VendorOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VendorOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VendorOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JLabel Title;
    private javax.swing.JButton backButton;
    private javax.swing.JComboBox<String> bookSelector;
    private javax.swing.JLabel booklabel;
    private javax.swing.JTextField inputQty;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelVendor;
    private javax.swing.JTextArea textComponent;
    private javax.swing.JComboBox<String> vendorSelector;
    // End of variables declaration//GEN-END:variables
}
