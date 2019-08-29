
/**
 * Write a description of class Job here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Job
{
    // instance variables - replace the example below with your own
    public String jobId;
    public String userName;
    public String title;
    public String deadline;
    public String skills;
    public String location;
    public String category;
    public String description;
    public String compensationLevel;
    /**
     * Constructor for objects of class Job
     */
    public Job()
    {
        jobId = "";
        userName = "";
        title = "";
        deadline = "";
        skills = "";
        location = "";
        category = "";
        description = "";
        compensationLevel = "";
    }
    
    public Job(String jobId,String userName,String title, String deadline, String skills, String location,
    String category, String description, String compensationLevel)
    {
        this.jobId = jobId;
        this.userName = userName;
        this.title = title;
        this.deadline = deadline;
        this.skills = skills;
        this.location = location;
        this.category = category;
        this.description = description;
        this.compensationLevel = compensationLevel;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public void setJobId(String jobId)
    {
        this.jobId = jobId;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
    
    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public void setDeadline(String deadline)
    {
        this.deadline = deadline;
    }
    
    public void setSkills(String skills)
    {
        this.skills = skills;
    }
    
    public void setLocation(String location)
    {
        this.location = location;
    }
    
    public void setCategory(String category)
    {
        this.category = category;
    }
   
    public void setCompensationLevel(String compensationLevel)
    {
        this.compensationLevel = compensationLevel;
    }
    
    public String getJobId()
    {
        return jobId;
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getDeadline()
    {
        return deadline;
    }
    
    public String getSkills()
    {
        return skills;
    }
    
    public String getLocation()
    {
        return location;
    }
    
    public String getCategory()
    {
        return category;
    }
  
    public String getCompensationLevel()
    {
        return compensationLevel;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String printJob()
    {
        String line = "jobId: " + jobId + " userName: " + userName + " title: " + title + " deadline: "
        + deadline + " skills: " + skills + " location: " + location + " category: " + category +
        " description: " + description + " compensationLevel: " + compensationLevel;
        return line;
    }
}
