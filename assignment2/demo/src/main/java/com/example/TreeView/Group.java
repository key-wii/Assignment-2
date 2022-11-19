package com.example.TreeView;

import javax.swing.tree.*;
import javax.swing.JTree;
import java.util.List;
import java.util.ArrayList;
import com.example.Tally.TallyInterface;

public class Group implements TreeViewInterface {
    private String groupID;
    private Long createdGroup;
    private List<DefaultMutableTreeNode> groupUsers = new ArrayList<>();
    
    public Group(String newID) {
        this.createdGroup = System.currentTimeMillis();
        this.groupID = newID;
    }
    
    @Override
    public String getID() {
        return this.groupID;
    }

    public List<DefaultMutableTreeNode> getGroupUsers() {
        return groupUsers;
    }

    @Override
    public String toString() {
        return groupID;
    }
    
    @Override
    public void accept(TallyInterface visitor) {
        visitor.tallyGroup(this);
        for(DefaultMutableTreeNode members : groupUsers) {
            if (members.getUserObject() instanceof User) {
                ((User) members.getUserObject()).accept(visitor);
            } else if (members.getUserObject() instanceof Group) {
                ((Group) members.getUserObject()).accept(visitor);
            }
        }
    }
    public void addUser(DefaultMutableTreeNode newUser) {
        this.groupUsers.add(newUser);
    }
    public void addGroup(DefaultMutableTreeNode newGroup) {
        this.groupUsers.add(newGroup);
    }
    public User getUser(String userID) {
        for (DefaultMutableTreeNode members : groupUsers) {
            if (members.getUserObject() instanceof User) {
                if (((User) members.getUserObject()).getID().equals(userID))
                    return (User) members.getUserObject();
            }
            else if (members.getUserObject() instanceof Group) {
                // iterate through all groups in group and check if the 
                //user id exist there
                if (((Group) members.getUserObject()).containsUser(userID))
                    return ((Group) members.getUserObject()).getUser(userID);
            }
        }
        return null;
    }
    public Boolean containsUser(String UserID) {
        for (DefaultMutableTreeNode members : groupUsers) {
            if (members.getUserObject() instanceof User) {
                if (((User) members.getUserObject()).getID().equals(UserID)) {
                    return true;
                }
            }
            else if (members.getUserObject() instanceof Group) {
                if (((Group) members.getUserObject()).containsUser(UserID)) {
                    return true;
                }
            }
        }
        return false;
    }
    public Boolean containsGroup(String memberID) {
        for (DefaultMutableTreeNode members : groupUsers) {
            if (members.getUserObject() instanceof User)
                continue;
            // check for a group in this.groupMembers
            else if (members.getUserObject() instanceof Group) {
                if (((Group) members.getUserObject()).getID().equals(memberID))
                    return true;
                //check ID of groups within groups
                else {
                    if (((Group) members.getUserObject()).containsGroup(memberID))
                        return true;
                }
            }
        }
        return false;
    }
}