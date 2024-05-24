package SqlManipulation;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DBConnection.DBConnection;
import Warehouse_frame.MainFrame;
import Warehouse_frame.MyModel;

import javax.swing.*;

public class SqlSubmission implements ActionListener {

    private final String SqlCommand;

    public SqlSubmission(){
        SqlCommand = null;
    }

    public SqlSubmission(String sqlCommand){
        SqlCommand = sqlCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        SqlInjector(SqlCommand);
    }
    // Executing the sql code
    public static void SqlInjector(String SqlCommand){

    	Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement state = conn.prepareStatement(SqlCommand);
            ResultSet result = state.executeQuery();
            try {
                MainFrame.productTable.setModel(new MyModel(result));
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void SqlInsertion(String SqlCommand,JTextField[] fields){

        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement state = conn.prepareStatement(SqlCommand);

            try {
                state.setString(1, fields[0].getText());
                state.setString(2, fields[1].getText());
                state.setString(3, fields[2].getText());

                state.setString(4, fields[3].getText());
                state.setInt(5, Integer.parseInt(fields[4].getText()));
                state.setString(6, fields[3].getText());
                state.setString(7, fields[0].getText());

                state.execute();


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static void SqlUpdate(String SqlCommand,JTextField[] fields){
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement state = conn.prepareStatement(SqlCommand);

            try {
                state.setInt(1, Integer.parseInt(fields[1].getText()));
                state.setString(2, fields[0].getText());
                state.setString(3, fields[2].getText());

                state.execute();


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void SqlDelete(String SqlCommand,JTextField[] fields){
        Connection conn = DBConnection.getConnection();
        try {
            PreparedStatement state = conn.prepareStatement(SqlCommand);

            try {
                state.setString(1, fields[0].getText());
                state.setString(2, fields[0].getText());
                state.setString(3, fields[1].getText());

                state.execute();


            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static boolean isFieldsEmpty(JTextField[] fields){
        for(JTextField field : fields){
            if(field.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Every field has to be filled with info","Missing Info!",JOptionPane.INFORMATION_MESSAGE);
            return true;
            }
        }
        return false;
    }
}
/*CREATE TABLE Product(
 Product_Id IDENTITY PRIMARY KEY,
 Name VARCHAR(50),
 Price DECIMAL(6,2),
 Release_Date TIMESTAMP
);*/