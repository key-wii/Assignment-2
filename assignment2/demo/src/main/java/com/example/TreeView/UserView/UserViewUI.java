package com.example.TreeView.UserView;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.ListView;
import com.example.TreeView.Group;
import com.example.TreeView.User;
import javafx.geometry.Pos;

public class UserViewUI {
    private VBox menuBox;
    
    private UserViewUI(User user, Group rootGroup) {
        TextField userIDText=new TextField();
        userIDText.setPromptText("Enter User ID");
        Button follow = new Button();
        follow.setText("Follow User");
        
        Alert informationAlert=new Alert(Alert.AlertType.INFORMATION);
        
        follow.setOnAction((ActionEvent event)-> {
            String UserNeedFollow=userIDText.getText();
            User NeedFollow=rootGroup.getUser(UserNeedFollow);
            if (NeedFollow == user) {
                informationAlert.setContentText("Choose another User");
                informationAlert.showAndWait();
               
            }
            else if (NeedFollow == null) {
                informationAlert.setContentText("User not found");
                informationAlert.showAndWait();
            }
            else { 
                NeedFollow.attach(user);
                user.addFollowingList(NeedFollow);
            }
            userIDText.clear();
        });
        
        TextArea writeTweet=new TextArea();
        writeTweet.setWrapText(true);
        writeTweet.setPrefHeight(70);
        writeTweet.setPromptText("What's happening?");
        Button postTweet = new Button();
        postTweet.setText("Post Tweet");  
        
        postTweet.setOnAction((ActionEvent event)-> {
            String tweet=writeTweet.getText();
            user.tweetMessage(tweet);
            writeTweet.clear();
        });
        
        HBox followUserOption=new HBox(10, userIDText, follow);
        Label currentfollow = new Label("Current Following");

        ListView followlist = new ListView(user.getFollowingList());
        followlist.setPrefHeight(50);
        
        HBox tweetOption = new HBox(10, writeTweet, postTweet);
        tweetOption.setAlignment(Pos.BOTTOM_CENTER);

        Label newsFeed = new Label("News Feed");
        
        ListView newsFeedList = new ListView(user.getNewsFeedList());
        newsFeedList.setPrefHeight(100);
        
        menuBox = new VBox(10, followUserOption, currentfollow, followlist, tweetOption, newsFeed, newsFeedList);
    }
    public VBox getMenuBox() {
        return menuBox;
    }
    public static void openUserUI(User user, Group rootGroup) {
        UserViewUI userViewUI=new UserViewUI(user, rootGroup);
        VBox menuBox=userViewUI.getMenuBox();
        
        Scene userScene = new Scene(menuBox, 570, 400);
        
        Stage userStage=new Stage();
        userStage.setTitle(user.getID());
        userStage.setScene(userScene);
        userStage.show();
    }
}