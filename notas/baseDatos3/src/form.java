import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class form {
    public JButton button1;
    public JLabel label;
    public JPanel mainPanel;
    private JTextField consulta;
    private JLabel nombre;
    private JLabel notab1;
    private JLabel comment;
    private JLabel notab2;
    private JLabel notafinal;
    private JLabel estado;
    private JButton button2;

    public Container mainPanel() {
        return mainPanel;
    }

    public form() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/estudiantes";
                String user="root";
                String password="123456";

                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where cedula='"+ consulta.getText()+"'";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        nombre.setText(resultSet.getString("nombre"));
                        notab1.setText(resultSet.getString("b1"));
                        notab2.setText(resultSet.getString("b2"));
                        double b1=Double.parseDouble(resultSet.getString("b1"));
                        double b2=Double.parseDouble(resultSet.getString("b2"));
                        double total=b1+b2;
                        String result = String.format("%.2f",total);
                        notafinal.setText(result);

                        if (total<28){
                            estado.setText("Estudiante Reprobado");
                        } else if (total>=28){
                            estado.setText("Estudiante Aprobado");
                        }
                    }
                } catch (SQLException e1) {
                    System.out.println(e1);
                    System.out.println("MI WEBO" + e1.getMessage());
                }

            }
        });

        consulta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consulta.setText(consulta.getText());
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String url="jdbc:mysql://localhost:3306/estudiantes";
                String user="root";
                String password="123456";

                try (Connection connection= DriverManager.getConnection(url,user,password)){
                    System.out.println("Conectado a la base de datos");
                    String query="select * from estudiantes where nombre='"+ consulta.getText()+"'";
                    Statement statement=connection.createStatement();
                    ResultSet resultSet=statement.executeQuery(query);
                    while(resultSet.next()){
                        nombre.setText(resultSet.getString("nombre"));
                        notab1.setText(resultSet.getString("b1"));
                        notab2.setText(resultSet.getString("b2"));
                        double b1=Double.parseDouble(resultSet.getString("b1"));
                        double b2=Double.parseDouble(resultSet.getString("b2"));
                        double total=b1+b2;
                        String result = String.format("%.2f",total);
                        notafinal.setText(result);

                        if (total<28){
                            estado.setText("Estudiante Reprobado");
                        } else if (total>=28){
                            estado.setText("Estudiante Aprobado");
                        }
                    }
                } catch (SQLException e1) {
                    System.out.println(e1);
                    System.out.println("No funca" + e1.getMessage());
                }

            }
        });
    }
}
