package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/*public class TwitterDriver extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Admin adminControlPanel = Admin.getInstance();
        Box adminView = adminControlPanel.getAdminControlPanel();

        Scene scene = new Scene(adminView, 570, 270);
        primaryStage.setTitle("Admin Control Panel");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}*/

public class TwitterDriver extends Application {
    
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        Admin adminControlPanel = new Admin(); //bug on this line
        Box adminView = adminControlPanel.getAdminControlPanel();
        
        /*JPanel contentPane = new JPanel(new BorderLayout());
        Border someBorder;
        contentPane.setBorder(someBorder);
        contentPane.add(adminView);*/
        
        JFrame frame = new JFrame("JFrame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPane = frame.getContentPane();
        contentPane.add(adminView);
        frame.setBounds(50, 50, 570, 270);
        frame.setVisible(true);
    
        /*Scene scene = new Scene(adminView, 570, 270);
        primaryStage.setTitle("Admin Control Panel");
        primaryStage.setScene(scene);
        primaryStage.show();*/
    }
}