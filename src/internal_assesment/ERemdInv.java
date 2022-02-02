/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internal_assesment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Hritik Gandhi
 */
public class ERemdInv {

    Connection con;
    Statement st;
    ResultSet rs;

    public ERemdInv() {
        connect();
    }

    private void connect() {
        try {

            con = DriverManager.getConnection("jdbc:ucanaccess://C:\\Users\\Hritik Gandhi\\OneDrive\\Netbeans\\Internal_Assesment\\db1.accdb");
            st = con.createStatement();

        } catch (Exception ex) {
            System.out.println("Error Connecting to DB...");
        }
    }

    public void Execute(String Qty, String Book) {
        try {
            String sql = "SELECT * FROM InventoryDB";
            rs = st.executeQuery(sql);
            while (rs.next()) {
                String name = rs.getObject("Books").toString();
                String qty = rs.getObject("quantity").toString();
                if (name.equalsIgnoreCase(Book)) {
                    int result = Integer.parseInt(qty);
                    int resp = Integer.parseInt(Qty);
                    int p = result-resp;
                    Qty = "";
                    Qty = ""+p;
                }
            }
        } catch (Exception e) {

        }
        try {

            // create the java mysql update preparedstatement
            String query = "update InventoryDB set quantity = ? where Books = ?";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, Qty);
            preparedStmt.setString(2, Book);

            // execute the java preparedstatement
            preparedStmt.executeUpdate();

            con.close();
        } catch (Exception e) {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
        }
    }

    public static void main(String qty, String book) {
        int result = Integer.parseInt(qty);
        ERemdInv obj = new ERemdInv();
        obj.Execute(qty, book);
    }
}
