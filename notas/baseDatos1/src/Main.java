import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        String url="jdbc:mysql://localhost:3306/estudiantes1";
        String user="root";
        String password="123456";

        String nombre="Josue Guerra";
        String cedula="1596824378";
        Double b1=12.36;
        Double b2=18.45;

        String sql = "INSERT INTO estudiantes1 (cedula, nombre, b1, b2) VALUES (?, ?, ?, ?)";



        try (Connection connection= DriverManager.getConnection(url,user,password)){
            PreparedStatement cadenaPreparada = connection.prepareStatement(sql);

            cadenaPreparada.setString(1, cedula);
            cadenaPreparada.setString(2, nombre);
            cadenaPreparada.setDouble(3, b1);
            cadenaPreparada.setDouble(4, b2);

            cadenaPreparada.executeUpdate();
            System.out.println("Estudainte ingresado de manera correcta");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }}