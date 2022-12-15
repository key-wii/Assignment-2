/**
 *
 * Composite pattern
 */
public interface CompositeUser 
{
    public void setID(String id);
    public String getID();
    public String toString();
    public long getTimestamp();
    public long getLastUpdate();
    public int getSize();
    public CompositeUser getChildAt(int i);
}
