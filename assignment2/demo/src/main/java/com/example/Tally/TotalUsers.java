package com.example.Tally;

import com.example.TreeView.Group;
import com.example.TreeView.User;

public class TotalUsers implements TallyInterface {
    
    private int totalUser = 0;
    
    @Override
    public void tallyUser(User user) {
        setUserTotal(getUserTotal() + 1);
    }
    @Override
    public void tallyGroup(Group group) {
        // do nothing
    }

    public void setUserTotal(int totalUser) {
        this.totalUser = totalUser;
    }
    public int getUserTotal() {
        return totalUser;
    }
}