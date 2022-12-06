/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Laurence Garcia
 */
public class GroupCount implements VisitorInterface
{
    private int totalGroup = 0;
    
    @Override
    public void visitUser(User user)
    {
        //Nothing
    }
    
    @Override 
    public void visitGroup(UserGroup group)
    {
        totalGroup++;
    }
    
    public int getTotalGroup()
    {
        return totalGroup;
    }
    
    public void setTotalGroup(int groupTotal)
    {
        totalGroup = groupTotal;
    }
}
