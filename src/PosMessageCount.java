/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Laurence Garcia
 */
public class PosMessageCount implements VisitorInterface
{
    
    private float posMessage = 0;
    private Message messageTracker = new Message();
    
    @Override
    public void visitUser(User user)
    {
        //Calculates positive messages
        posMessage = messageTracker.CalculatePosWord();
    }
    
    @Override 
    public void visitGroup(UserGroup group)
    {
        //Nothing
    }
    
    public float getPosMessage()
    {
        return posMessage;
    }
    
}
