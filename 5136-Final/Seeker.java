
/**
 * Write a description of class Seeker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Seeker extends User
{
    // instance variables - replace the example below with your own
    public String skillsets;
    public String typeOfJob;
    public String compensationLevel;
    /**
     * Constructor for objects of class Seeker
     */
    public Seeker()
    {
        // initialise instance variables
        skillsets = "";
        typeOfJob = "";
        compensationLevel = "";
    }
    
    public Seeker(String skills, String type, String salary)
    {
        // initialise instance variables
        skillsets = skills;
        typeOfJob = type;
        compensationLevel = salary;
    }

    public String getSkillsets()
    {
        return skillsets;
    }
    
    public String getTypeOfJob()
    {
        return typeOfJob;
    }
    
    public String getCompensationLevel()
    {
        return compensationLevel;
    }
    
    public void setSkillsets(String skillsets)
    {
        this.skillsets = skillsets;
    }
    
    public void setTypeOfJob(String typeOfJob)
    {
        this.typeOfJob = typeOfJob;
    }
    
    public void setCompensationLevel(String compensationLevel)
    {
        this.compensationLevel = compensationLevel;
    }
}
