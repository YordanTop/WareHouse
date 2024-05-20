package Warehouse_frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SqlSubmission implements ActionListener {

    private String SqlCommand;

    public SqlSubmission(String sqlCommand){
        SqlCommand = sqlCommand;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
