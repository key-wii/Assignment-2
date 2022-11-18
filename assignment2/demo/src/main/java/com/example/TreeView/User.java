package com.example.TreeView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.example.Tally.TallyInterface;
import com.example.TreeView.UserView.FollowInterface;
import com.example.TreeView.UserView.UserObserver;

public class User extends UserObserver implements TreeViewInterface, FollowInterface {
   //declare variables for UserLeaf functions
   private String userID;
   private List<User> following = new ArrayList<>();
   private ObservableList<User> followingList = FXCollections.observableList(following);
   private List<String> myTweets = new ArrayList<>();
   private List<String> newsFeed = new ArrayList<>(Arrays.asList());
   private ObservableList<String> newsFeedList = FXCollections.observableList(newsFeed);
    
   //Set ID of User and created User
    public User(String newID) {
        this.userID = newID;
    }
    
    @Override
    public String getID() {
        return userID;
    }
    
    @Override
    public String toString() {
        return userID;
    }

    @Override
    public void accept(TallyInterface visitor) {
        visitor.tallyUser(this);
    }
    @Override
    public void update(UserObserver observer, String tweet) {
        if (observer instanceof User) {
            this.newsFeedList.add("-" + ((User) observer).getID() + " : " + tweet);
        }
    }
    public ObservableList<User> getFollowingList() {
        return followingList;
    }
    //if follow user, add to following list
    public void addFollowingList(User user) {
        followingList.add(user);
    }

    public List<String> getMyTweets() {
        return myTweets;
    }

    public ObservableList<String> getNewsFeedList() {
        return newsFeedList;
    }
    
    public void tweetMessage (String tweet) {
        myTweets.add(tweet);
        newsFeedList.add("-" + this.userID + " : " + tweet);
        updateFollowers(tweet);
    }
}