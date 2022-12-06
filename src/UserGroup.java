//Composite Pattern - holds user and groups

import java.util.*;

public class UserGroup implements CompositeUser
{
    //Unique group id
    private String groupID;

    //Holds group of users
    private ArrayList<CompositeUser> groupUsers;
    
    public UserGroup(String id)
    {
        groupID = id;
        groupUsers = new ArrayList<CompositeUser>();
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
}
