import javax.swing.*;
import java.sql.*;

/**
 * Created by kuritsin on 17.02.16.
 */
public class JavaToMySQL {

    private static final String url = "jdbc:mysql://localhost:3306/myDB";
    private static final String user = "root";
    private static final String password = "000000";
    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;


    public static void main(String[] args){


        String query = "SELECT firstName, lastName, patrName, birthDate, sex, documentType_id, serial, number FROM  `Client`, `ClientDocument` WHERE Client.id = ClientDocument.client_id";

        try{

            //connecting to DataBase
            con = DriverManager.getConnection(url, user, password);
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);

            String row = new String();

            for (int i = 0; rs.next(); i++){
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String patrName = rs.getString("patrName");
                String birthDate = rs.getString("birthDate");
                String sex = rs.getString("sex");
                String documentType_id = rs.getString("documentType_id");
                String serial = rs.getString("serial");
                String number = rs.getString("number");

                System.out.println(firstName + " | " + lastName + " | " + birthDate + " | " + sex + " | " + documentType_id + " | " + serial + " | " + number);

            }


        }catch(SQLException sqlEx) {
            sqlEx.printStackTrace();
        }finally {
            try { con.close(); } catch(SQLException se) {}
            try { stmt.close(); } catch(SQLException se) {}
            try { rs.close(); } catch(SQLException se) {}
        }

    }

}
