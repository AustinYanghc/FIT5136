
/**
 * Write a description of class Notification here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Notification
{
    // instance variables - replace the example below with your own
    public String notificationId;
    public String recruiterId;
    public String seekerId;
    public String info;
    /**
     * Constructor for objects of class Notification
     */
    public Notification()
    {
        notificationId = "";
        recruiterId = "";
        seekerId = "";
        info = "";
    }
    
    public String getNotificationId()
    {
        return notificationId;
    }
    
    public String getRecruiterId()
    {
        return recruiterId;
    }
    
    public String getSeekerId()
    {
        return seekerId;
    }

    public String getInfo()
    {
        return info;
    }
    
    public void setNotificationId(String notificationId)
    {
        this.notificationId = notificationId;
    }
    
    public void setRecruiterId(String recruiterId)
    {
        this.recruiterId = recruiterId;
    }
    
    public void setSeekerId(String seekerId)
    {
        this.seekerId = seekerId;
    }
    
    public void setState(String info)
    {
        this.info = info;
    }
    
    public String printNoti()
    {
        String line = "NotificationId " + notificationId + " recruiterId " + recruiterId + " seekerId "
        + seekerId + " Message " + info;
        return line;
    }
}
