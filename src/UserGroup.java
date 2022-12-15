//Composite Pattern - holds user and groups

import java.util.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class UserGroup implements CompositeUser
{
    //Unique group id
    private String groupID;
    private long creationTime;

    //Holds group of users
    private ArrayList<CompositeUser> groupUsers;
    
    public UserGroup(String id)
    {
        groupID = id;
        groupUsers = new ArrayList<CompositeUser>();
        this.creationTime = System.currentTimeMillis();
    }
    
    //Accessor Methods
    @Override 
    public void setID(String id)
    {
        groupID = id;
    }

    @Override //Get Group ID
    public String getID()
    {
        return groupID;
    }

    //Adds user to a group
    public void addUserToGroup(User userID)
    {
        groupUsers.add(userID);
    }

    //Returns the users in a group
    public ArrayList<CompositeUser> getGroup()
    {
        return groupUsers;
    }
    
    //Used to allow method to read
    @Override
    public String toString()
    {
        return groupID;
    }
    
    public long getTimestamp() {
        return creationTime;
    }
    
    public long getLastUpdate() {
        return creationTime;
    }
    
    public int getSize() {
        return groupUsers.size();
    }
    
    public CompositeUser getChildAt(int i) {
        return groupUsers.get(i);
    }
}
