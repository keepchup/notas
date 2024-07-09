import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class form1 {
    private JButton button1;
    public JPanel mainPanel;
    private JLabel nombreTxt;

    public form1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/estudiantes";
                String user="root";
                String password="123456";

                try (Connection connection= DriverManager.getConnection(url,user,password))
                {
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where cedula=1752370344";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        System.out.println(resultSet.getString("nombre"));
                        nombreTxt.setText(resultSet.getString("nombre"));
                    }
                }catch (SQLException e1){
                    System.out.println(e1);
                    System.out.println("Error al conectar a la base de datos: " + e1.getMessage());
                }
            }
        });
    }
}
