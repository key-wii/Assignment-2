package com.example;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.tree.*;
import static javax.swing.JOptionPane.showMessageDialog;
/*import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;*/
import com.example.Tally.TotalPositives;
import com.example.Tally.TotalGroupUser;
import com.example.Tally.TotalMessages;
import com.example.Tally.TotalUsers;
import com.example.TreeView.Group;
import com.example.TreeView.TreeViewInterface;
import com.example.TreeView.User;
import com.example.TreeView.UserView.UserViewUI;

public class Admin {
    private static Admin control;
    private Box menuBox;
    
    public Admin() {
        Group rootGroup = new Group("Root");

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");
        DefaultTreeModel treeModel = new DefaultTreeModel(root);
        treeModel.addTreeModelListener(new MyTreeModelListener());

        JTree treeView = new JTree(treeModel);
        treeView.setEditable(true);
        treeView.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        treeView.setShowsRootHandles(true);
        rootGroup.addGroup(treeView);
        
        JButton butAddUser = new JButton("Add User");
        JTextField UserIDText = new JTextField("Enter User ID");
        butAddUser.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                DefaultMutableTreeNode selectedUser = new DefaultMutableTreeNode(treeView.getSelectionModel().getSelectionPath());
                String newUserInput = String.valueOf(UserIDText.getText());
                //if (rootGroup.containsUser(newUserInput)) { UNCOMMENT THIS LATER
                    //showMessageDialog(null, "This User is taken"); UNCOMMENT THIS LATER
                //} UNCOMMENT THIS LATER
                //else {
                    User user = new User(newUserInput);
                    ((Group) selectedUser.getUserObject()).addUser(user);
                    //selectedUser.getChildren().add(new TreeItem<>(user));
                //} UNCOMMENT THIS LATER
            }
        });

        JButton butAddgroup = new JButton("Add Group");
        JTextField GroupIDText = new JTextField("Enter Group ID");
        butAddgroup.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                DefaultMutableTreeNode selectedGroup = new DefaultMutableTreeNode(treeView.getSelectionModel().getSelectionPath());
                String newGroup = String.valueOf(GroupIDText.getText());
            
                Group group = new Group(newGroup); //maybe should be DefaultMutableTreeNode instead?
                ((Group) selectedGroup.getUserObject()).addGroup(group);
            }
        });

        JButton butUserView = new JButton("Open User View");
        butUserView.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                DefaultMutableTreeNode selectedUser = new DefaultMutableTreeNode(treeView.getSelectionModel().getSelectionPath());
                if (selectedUser.getUserObject() instanceof User) {
                    User userViewUser = (User) selectedUser.getUserObject();
                    //UserViewUI.openUserUI(userViewUser, rootGroup); UNCOMMENT THIS LATER
                }
            }
        });
        JButton butUserTotal = new JButton("Show User Total");
        butUserTotal.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                TotalUsers userTotalUser = new TotalUsers();
                rootGroup.accept(userTotalUser);
                showMessageDialog(null, "Total Users: " + userTotalUser.getUserTotal()); 
            }
        });
        JButton butGroupTotal = new JButton("Show Group Total");
        butGroupTotal.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
            /*TotalGroupUser groupTotalUser=new TotalGroupUser();
                rootGroup.accept(groupTotalUser);
                informationAlert.setContentText("Total Groups: " + groupTotalUser.getGroupTotal());
                informationAlert.showAndWait();
                showMessageDialog(null, "Total Groups: " + groupTotalUser.getGroupTotal());*/
                
            }
        });
        JButton butMessagetotal = new JButton("Show Message Total");
        butMessagetotal.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                /*TotalMessages messageTotalUser=new TotalMessages();
                    rootGroup.accept(messageTotalUser);
                    informationAlert.setContentText("Total Tweets: " + messageTotalUser.getMessageTotal());
                    informationAlert.showAndWait();
                    showMessageDialog(null, "Total Tweets: " + messageTotalUser.getMessageTotal());*/
                
            }
        });
        JButton butPositive = new JButton("Show Positive Percentage");
        butPositive.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent e) {
                /*TotalPositives positiveUser = new TotalPositives();
                    rootGroup.accept(positiveUser);
                    informationAlert.setContentText(String.format("Positive Messages: %.2f%% of total messages", positiveUser.getpositivePercent()));
                    informationAlert.showAndWait();
                    showMessageDialog(null, String.format("Positive Messages: %.2f%% of total messages", positiveUser.getpositivePercent()));*/
                
            }
        });

        Box treeBox = new Box(1);
        treeBox.add(treeView);

        Box userBox = new Box(1);
        userBox.add(UserIDText);
        userBox.add(butAddUser);
        Box groupBox = new Box(1);
        groupBox.add(GroupIDText);
        groupBox.add(butAddgroup);
        Box userGroupTotalBox = new Box(1);
        userGroupTotalBox.add(butUserTotal);
        userGroupTotalBox.add(butGroupTotal);
        Box positivesBox = new Box(1);
        positivesBox.add(butMessagetotal);
        positivesBox.add(butPositive);

        Box topButtons = new Box(1);
        topButtons.add(userBox);
        topButtons.add(groupBox);
        topButtons.add(butUserView);
        topButtons.add(userGroupTotalBox);
        topButtons.add(positivesBox);
        Box bottomButtons = new Box(1);
        bottomButtons.add(userGroupTotalBox);
        bottomButtons.add(positivesBox);

        Box allButtons = new Box(1);
        allButtons.add(topButtons);
        allButtons.add(bottomButtons);
        userBox.add(butUserView);
        
        menuBox = userBox;
        menuBox.add(treeBox);
        menuBox.add(allButtons);
    }

    public Box getAdminControlPanel() {
        return menuBox;
    }
}
