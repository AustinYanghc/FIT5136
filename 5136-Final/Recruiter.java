import java.util.ArrayList;
/**
 * Write a description of class Recruiter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Recruiter extends User
{
    // instance variables - replace the example below with your own
    private ArrayList<String> categoryList;
    
    /**
     * Constructor for objects of class Recruiter
     */
    public Recruiter()
    {
        categoryList = new ArrayList<String>();
    }
    
    public void setJobCategory(ArrayList<String> categoryList)
    {
        this.categoryList = categoryList;
    }
    
    public ArrayList<String> getJobCategory()
    {
        return categoryList;
    }
    
    public void addCategory(String category)
    {
        categoryList.add(category);
    }
    
    public void deleteCategory(String category)
    {
        categoryList.remove(category);
    }
}
