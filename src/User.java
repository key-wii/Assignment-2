//Users must have unique ID, list of followers, list of followings
//news feed list containing list of twitter messsges
//Observer Pattern also implemented in here

import java.util.*;
import javax.swing.JList;

public class User implements CompositeUser
{
    //Unique user id
    private String userID;

    //List of following
    private ArrayList<User> following;
    private ArrayList<User> followers;
    
    //User messages
    private List<String> message;
    private Message newsFeed;
    
    private JList feed;
    
    public User(String id)
    {
        this.userID = id;
        this.following = new ArrayList<User>();
        this.followers = new ArrayList<User>();
        this.message = new ArrayList<String>();
        this.newsFeed = new Message();
    }

    //Accessor methods
    @Override 
    public void setID(String id)
    {
        userID = id;
    }

    @Override 
    public String getID()
    {
        return userID;
    }

    //Adds followers to list
    public void addFollowing(User userID)
    {
        following.add(userID);
    }

    //Gets list of followers
    public ArrayList<User> getFollowing()
    {
        return following;
    }
    
    public void addFollower(User userID)
    {
        followers.add(userID);
    }
    
    public ArrayList<User> getFollowers()
    {
        return followers;
    }

    public void addMessage(String mess)
    {
        message.add(mess);
    }

    public String getMessage(int pos)
    {
        return message.get(pos);
    }
    
    //OBSERVER Pattern - USERS ARE UPDATED HERE
    public void updateFollowers()
    {
        for (int i = 0; i < followers.size(); i++)
        {
            followers.get(i).updateFeed(followers.get(i).getFeed());
        }
    }
    
    public void updateFeed(JList feed)
    {
        this.newsFeed.printTweets(feed, following, this);
    }
    
    //OBSERVER PATTERN
    public void setFeed(JList news)
    {
        feed = news;
    }
    
    public JList getFeed()
    {
        return this.feed;
    }
    
    //Used to allow method to read name
    @Override
    public String toString()
    {
        return userID;
    }
}
