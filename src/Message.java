
import java.util.*;
import javax.swing.DefaultListModel;
import javax.swing.JList;

/**
 *
 * Observer pattern to update message and news feed
 * 
 */
public class Message 
{
    //Words that are positive
    private String[] positiveWords = {"happy", "positive", "cute", "good", "great", "excellent"};
    
    //Tweets and the users who tweeted them at that time
    private static ArrayList<String> allTweets = new ArrayList<String>();
    private static ArrayList<User> userTweet = new ArrayList<User>();
    private MessageCount totalMessage = new MessageCount();
    
    //Calculates how positive a tweet is
    public float CalculatePosWord()
    {
        float percentPos;
        float posTweet = 0;
        float overallTweet = allTweets.size();
        
        for(int i = 0; i < overallTweet; i++)
        {
            String tweet = allTweets.get(i);
            
            tweet = tweet.toLowerCase();
            
            for(int j = 0; j < positiveWords.length; j++)
            {
                if (tweet.contains(positiveWords[j]))
                {
                    posTweet++;
                }
            }
        }
        
        percentPos = posTweet / overallTweet * 100;
        
        return percentPos;
    }
    
    //Adds a tweet to both arraylists
    public void addTweet(User user, String tweet)
    {
        allTweets.add(tweet);
        userTweet.add(user);
        
        totalMessage.visitUser(user);
        
        System.out.println("Tweets: " + allTweets.toString());
        System.out.println(userTweet.get(userTweet.size() - 1) + ": " + allTweets.get(allTweets.size() - 1));
    }
    
    public ArrayList<String> getTweets()
    {
        return allTweets;
    }
    
    //Print out the tweets to the news feed
    //Checks if user is following them
    public void printTweets(JList newsFeed, ArrayList<User> following, User user)
    {
        DefaultListModel feed = (DefaultListModel) newsFeed.getModel();
        feed.clear();
        
        for (int i = allTweets.size() - 1; i >= 0; i--)
        {
            if (following.contains(userTweet.get(i)) || user.equals(userTweet.get(i)))
            {
                feed.addElement(userTweet.get(i) + ": " + allTweets.get(i));
            }
        }
    }
}
