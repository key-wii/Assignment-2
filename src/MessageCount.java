
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Laurence Garcia
 */
public class MessageCount implements VisitorInterface
{
    
    private static int totalMessage = 0;
    
    @Override
    public void visitUser(User user)
    {
        totalMessage++;
    }
    
    @Override 
    public void visitGroup(UserGroup group)
    {
        //Nothing
    }
    
    public int getTotalMessage()
    {
        return totalMessage;
    }
    
    public void setTotalMessage(int total)
    {
        totalMessage = total;
    }
}
