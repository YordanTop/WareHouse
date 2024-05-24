package SqlManipulation;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SqlSearch implements ActionListener {

    private String SqlCommand;

    private String OriginalCommand;

    private String SearchField;

    private final JComboBox Filter;

    public SqlSearch(String sqlCommand, JComboBox filter,JTextField searchField){
        SqlCommand = sqlCommand;
        Filter = filter;

        searchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                KeyWordSearch();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                KeyWordSearch();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                KeyWordSearch();
            }
            public void KeyWordSearch(){
                SearchField = (searchField.getText().isEmpty())?" ":"Where I.name LIKE '%"+searchField.getText()+"%'";
            }
        });


    }

    //Searching for specific ComboBox option
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(SearchField);
        PrintSearch();
    }

    private void PrintSearch(){
        if(OriginalCommand == null){
            OriginalCommand = SqlCommand;
        }

        if(Filter.getSelectedItem().toString().equals("None")){
            SqlCommand += SearchField+" Order By CC.name";

        }

        if(Filter.getSelectedItem().toString().equals("Alphabet")){
            SqlCommand += SearchField+" Order By CC.name, I.name ASC";
        }

        if(Filter.getSelectedItem().toString().equals("Quantities")){
            SqlCommand += SearchField+" Order By Quantities";
        }

        if(Filter.getSelectedItem().toString().equals("Date")){
            SqlCommand += SearchField+"Order By O.order_data";
        }
        SqlSubmission.SqlInjector(SqlCommand);

        SqlCommand = OriginalCommand;
    }

}
