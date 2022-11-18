package com.example.TreeView.UserView;

import java.util.List;
import java.util.ArrayList;

public class UserObserver {
    private List<FollowInterface> followers = new ArrayList<>();

    public void attach(FollowInterface observer) {
        followers.add(observer);
    }
    
    public void updateFollowers(String message) {
        for(FollowInterface observer : this.followers) {
            observer.update(this, message);
        }
    }

}