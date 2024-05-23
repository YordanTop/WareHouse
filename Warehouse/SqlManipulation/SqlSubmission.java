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
        ShowInfo(SqlCommand);
    }

    public static void ShowInfo(String SqlCommand){

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
}
/*CREATE TABLE Product(
 Product_Id IDENTITY PRIMARY KEY,
 Name VARCHAR(50),
 Price DECIMAL(6,2),
 Release_Date TIMESTAMP
);*/