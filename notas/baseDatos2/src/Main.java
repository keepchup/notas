import javax.swing.*;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Mi aplicación");
        frame.setContentPane(new form1().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 900);
        frame.pack();
        frame.setVisible(true);
        System.out.println("woola");
    }
}
