import java.util.ArrayList;
/**
 * Write a description of class SeekerController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SeekerController
{
    // instance variables - replace the example below with your own
    private ConnectDatabase ojssDb;
    /**
     * Constructor for objects of class SeekerController
     */
    public SeekerController()
    {
        ojssDb = new ConnectDatabase();
    }
    
    public void createUser(User newSeeker)
    {
        ojssDb.insertUserSignUp(newSeeker.getUserName(),newSeeker.getName(),newSeeker.getPassword(),newSeeker.getEmail()
        ,newSeeker.getRole(),newSeeker.getAddress(),newSeeker.getDob(),newSeeker.getMobile());
    }
    
    public void createSeeker(String skills,String type,String salary,String userName)
    {
        ojssDb.insertSeeker(skills,type,salary,userName);
    }
    
    public void modifySeeker(String userName,String skillsets, String typeOfJob, String salary)
    {
        ojssDb.updateSeeker(userName,skillsets,typeOfJob,salary);
    }
    
    public ArrayList<Job> searchJob(String skills, String typesOfJobs, String location, String compensationLevel)
    {
        ArrayList<Job> jobList = ojssDb.showAllJob();
        ArrayList<Job> relevantJob = new ArrayList<Job>();
        for (int i = 0 ; i < jobList.size(); i++)
        {
             if ( skillCompare(skills, jobList.get(i).getSkills()) >= 1 && jobList.get(i).getCategory().equalsIgnoreCase(typesOfJobs) 
             && jobList.get(i).getLocation().equalsIgnoreCase(location))
                relevantJob.add(jobList.get(i));
        }
        return relevantJob;
    }
    
    public ArrayList<Integer> rankJobList(ArrayList<Job> jobList,String skills, String compensationLevel)
    {
        ArrayList<Integer> rankList = new ArrayList<Integer>();
        int matchScore = 50;
        for (int i = 0; i < jobList.size() ; i++)
        {
            int skillScore = skillCompare(skills, jobList.get(i).getSkills()) * 5;
            int compensationScore = 0;
            if ( Integer.valueOf(compensationLevel) >= Integer.valueOf(jobList.get(i).getCompensationLevel()))
                compensationScore = (Integer.valueOf(compensationLevel) - Integer.valueOf(jobList.get(i).getCompensationLevel())) / 1000 * 5;
            matchScore = skillScore + compensationScore + matchScore;
            rankList.add(matchScore);
        }
        return rankList;
    }
    
    public int skillCompare(String skills, String compareSkills)
    {
        String[] skillsets = skills.split(",");
        String[] compareSkillsets = compareSkills.split(",");
        int similarity = 0;
        for (int i = 0 ; i < skillsets.length; i++)
        {
            for (int j = 0 ; j < compareSkillsets.length; j ++)
            {
                if (skillsets[i].equalsIgnoreCase(compareSkillsets[j]))
                    similarity ++ ;
            }
        }
        return similarity;
    }
    
    public void applyJob(String userName, String jobId)
    {
        String number = String.valueOf(ojssDb.countApplication() + 1);
        ojssDb.insertApplication(number,userName, jobId,"applied");
    }
   
    public ArrayList<Notification> receiveNotification(String userName)
    {
        ArrayList<Notification> notelist = ojssDb.showNotification(userName);
        return notelist;
    }
    
    public String showSkillsets(String userName)
    {   
       return ojssDb.showSkillSet(userName);
    }
    
    public ArrayList<Application> showApplication(String userName)
    {
        ArrayList<Application> app = ojssDb.showApplication(userName);
        return app;
    }
    
    public String[] showSeekerInfo(String userName)
    {
        String[] list = new String[4];
        Seeker newSeeker = ojssDb.showSeekerInfo(userName);
        list[0] = newSeeker.getSkillsets();
        list[1] = newSeeker.getTypeOfJob();
        list[2] = newSeeker.getCompensationLevel();
        return list;
    }
}
