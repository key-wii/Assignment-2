package com.example.Tally;

import com.example.TreeView.Group;
import com.example.TreeView.User;

public class TotalGroupUser implements TallyInterface {
    //Variable to count
    private int totalGroup = 0;
    
    public void tallyGroup(Group group) {
        setGroupTotal(getGroupTotal() + 1);
    }
    public void tallyUser(User user) {
        //do nothing
    }

    public void setGroupTotal(int totalUser) {
        this.totalGroup = totalUser;
    }
    public int getGroupTotal() {
        return totalGroup;
    }
}
    

