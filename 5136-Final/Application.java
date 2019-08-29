
/**
 * Write a description of class Application here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Application
{
    // instance variables - replace the example below with your own
    public String applicationId;
    public String userName;
    public String jobId;
    public String state;
    /**
     * Constructor for objects of class Application
     */
    public Application()
    {
        // initialise instance variables
        applicationId = "";
        userName = "";
        jobId = "";
        state = "";
    }
    
    public String getApplicationId()
    {
        return applicationId;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getJobId()
    {
        return jobId;
    }
    
    public String getState()
    {
        return state;
    }
    
    public void setApplicationId(String applicationId)
    {
        this.applicationId = applicationId;
    }
    
    public void setUserId(String userId)
    {
        this.userName = userName;
    }
    
    public void setJobId(String jobId)
    {
        this.jobId = jobId;
    }
    
    public void setState(String state)
    {
        this.state = state;
    }
    
    public String printApplication()
    {
        String line = "applicationId " + applicationId + " userName " + userName + " jobId " + jobId
        + " state " + state;
        return line;
    }
}
