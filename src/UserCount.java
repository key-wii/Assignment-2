/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Laurence Garcia
 */
public class UserCount implements VisitorInterface
{
    
    private int totalUser = 0;
    
    @Override
    public void visitUser(User user)
    {
        totalUser++;
    }
    
    @Override 
    public void visitGroup(UserGroup group)
    {
        //Nothing
    }
    
    public int getTotalUser()
    {
        return totalUser;
    }
    
    public void setTotalUser(int userTotal)
    {
        totalUser = userTotal;
    }
}
