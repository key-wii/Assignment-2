
package com.example.Tally;

import com.example.TreeView.Group;
import com.example.TreeView.User;

public class TotalMessages implements TallyInterface {
    
    private int TotalMessage = 0;
    
    @Override
    public void tallyGroup(Group group) {
       // do nothing
    }
    @Override
    public void tallyUser(User user) {
        setMessageTotal(getMessageTotal() + user.getMyTweets().size());
    }

    public void setMessageTotal(int totalMessage) {
        TotalMessage = totalMessage;
    }
    public int getMessageTotal() {
        return TotalMessage;
    }
}