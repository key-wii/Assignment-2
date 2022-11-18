package com.example.Tally;

import java.util.Arrays;
import java.util.List;

import com.example.TreeView.Group;
import com.example.TreeView.User;

import java.util.ArrayList;

public class TotalPositives implements TallyInterface{
    private double total = 0.0;
    private double positiveCount = 0.0;
    private double positivePercent = 0.0;
    private List<String> positiveWords= new ArrayList<>(Arrays.asList("good", "great", "excellent", "positive"));

    @Override
    public void tallyGroup(Group group) {
        //do nothing
    }
    @Override
    public void tallyUser(User user) {
        for (String message : user.getMyTweets()) {
            total += 1;
            for (String positive : positiveWords) {
                if (message.toLowerCase().contains(positive.toLowerCase())) {
                    positiveCount += 1;
                    break;
                }
            }
        }
    }

    public void setpositivePercent(double positivePercent) {
        this.positivePercent = positivePercent;
    }
    public double getpositivePercent() {
        if (total == 0) {
            return positivePercent;
        }
        
        setpositivePercent((positiveCount / total) * 100.0);
        return (positivePercent);
    }
}