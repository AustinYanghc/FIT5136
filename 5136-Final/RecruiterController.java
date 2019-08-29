import java.util.ArrayList;
/**
 * Write a description of class RecruiterController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RecruiterController
{
    private ConnectDatabase ojssDb;
    /**
     * Constructor for objects of class RecruiterController
     */
    public RecruiterController()
    {
        ojssDb = new ConnectDatabase();
    }
    
    public void createUser(Recruiter newRecruiter)
    {
        ojssDb.insertUserSignUp(newRecruiter.getUserName(),newRecruiter.getName(),newRecruiter.getPassword(),newRecruiter.getEmail()
        ,newRecruiter.getRole(),newRecruiter.getAddress(),newRecruiter.getDob(),newRecruiter.getMobile());
    }
    
    public void createCategory(String userName, String newCategory)
    {
        ojssDb.setNewCategory(userName, newCategory);
    }
    
    public String getCategory(String userName)
    {
        return ojssDb.getCategory(userName);
    }
    
    public void deleteCategory(String userName, String deleteCategory)
    {
        String category = ojssDb.getCategory(userName);
        String[] categoryList = category.split(",");
        String newCategory = "";
        for (int i = 0 ; i < categoryList.length ; i++)
        {
            if (!categoryList[i].equalsIgnoreCase(deleteCategory))
            {
                newCategory = newCategory + categoryList[i] + ",";
            }
        }
        newCategory = newCategory.substring(0,newCategory.length() - 1);
        ojssDb.setCategory(userName, newCategory);
    }
    
    public void modifyCategory(String userName, String changedCategory)
    {
        ojssDb.setCategory(userName, changedCategory);
    }
    
    public void createJob(Job job)
    {
        ojssDb.insertNotAdvertiseJob(job.getJobId(),job.getUserName(),job.getTitle(),job.getDeadline(),
        job.getSkills(),job.getLocation(),job.getCategory(),job.getDescription(),job.getCompensationLevel());
    }
    
    public void advertiseJob(Job job)
    {
        ojssDb.deleteNotAdvertiseJob(job.getUserName(), job.getJobId());
        ojssDb.insertAdvertiseJob(job.getJobId(),job.getUserName(),job.getTitle(),job.getDeadline(),
        job.getSkills(),job.getLocation(),job.getCategory(),job.getDescription(),job.getCompensationLevel());
    }
    
    public ArrayList<String> matchSeeker(String userId)
    {
        String userName = "";
        String jobId = "";
        int match = 30;
        ArrayList<Seeker> seekerList = ojssDb.showAllSeeker();
        ArrayList<Job> jobList = ojssDb.showOneJob(userId);
        
        ArrayList<Integer> ScoreList = new ArrayList<Integer>();
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0 ; i < seekerList.size() ; i++)
        {
            for ( int j = 0 ; j < jobList.size() ; j++)
            {
                 if (skillCompare(seekerList.get(i).getSkillsets(),jobList.get(j).getSkills()) >= 1 &&
                 jobList.get(j).getCategory().equalsIgnoreCase(seekerList.get(i).getTypeOfJob()))
                 {
                     String line = "SeekerName: " + seekerList.get(i).getUserName() + " JobId: " + jobList.get(j).getJobId();
                     int skillScore = skillCompare(seekerList.get(i).getSkillsets(),jobList.get(j).getSkills()) * 5;
                     int compensationScore = 0;
                     if ( Integer.valueOf(jobList.get(j).getCompensationLevel()) >= Integer.valueOf(seekerList.get(i).getCompensationLevel()))
                           compensationScore = (Integer.valueOf(jobList.get(j).getCompensationLevel()) 
                           - Integer.valueOf(seekerList.get(i).getCompensationLevel())) / 1000 * 5;
                     match = match + compensationScore + skillScore;
                     line = line + " match Score: " + match;
                     list.add(line);
                 }
            }
        }
        return list;
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
    
    public ArrayList<Application> checkApplication(String userName)
    {
        ArrayList<String> jobList = ojssDb.showJobId(userName);
        ArrayList<Application> appList = new ArrayList<Application>();
        for (int i = 0; i < jobList.size() ; i++)
        {
            ArrayList<Application> partList = ojssDb.showApplication(jobList.get(i));
            for( int j = 0; j < partList.size() ; j++)
            {
                appList.add(partList.get(j));
            }
        }
        return appList;
    } 
    
    public Seeker checkSeekerInfo(String userName)
    {
        Seeker newSeeker = ojssDb.showSeekerInfo(userName);
        return newSeeker;
    }
    
    public void setNotification(String recruiterId,String seekerId,String info)
    {
        int number = ojssDb.countNotification() + 1;
        ojssDb.insertNotification(String.valueOf(number),recruiterId,seekerId,info);
    }
}

