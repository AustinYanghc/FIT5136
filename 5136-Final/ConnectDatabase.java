import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.ArrayList;
public class ConnectDatabase
{
    
   public static void main(String[] args) {
      Connection con = null;
      
      try {
         //Registering the HSQLDB JDBC driver
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         //Creating the connection with HSQLDB
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         if (con!= null){
            System.out.println("Connection created successfully");
            
         }else{
            System.out.println("Problem with creating connection");
         }
      
      }  catch (Exception e) {
         e.printStackTrace(System.out);
      }
   }
     
    public void insertUserSignUp(String newUserName, String newName, String newPassword, String newEmail, String newRole, String newAddress, String newDob, String newMobileNum)
    {
     Connection con = null; 
     Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO user VALUES ('"+newUserName+"','"+ newPassword +"','"+ newEmail +"', '"+ newRole +"','"+ newAddress +"', '"+ newDob +"', '"+ newMobileNum +"', '"+ newName +"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
     System.out.println(result+" rows effected"); 
     System.out.println("Rows inserted successfully"); 
    }
   
    public void insertJob ( String newJob, String newTitle, String newSalary, String newLocation, String newDeadline, String newUserName )
    {
      Connection con = null;
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO user  VALUES ('"+ newJob +"','"+ newUserName +"', '"+ newTitle +"','"+ newSalary +"', '"+ newDeadline +"', '"+ newUserName +"','default', 'default', 'default');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
    }
    
    public void insertJobDesc ( String newJob, String newDesc, String newCategory, String newSkill)
    {
      Connection con = null;
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO user VALUES ('"+ newJob +"','"+ newDesc +"', '"+ newCategory +"','"+ newSkill +"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
    }
    
    public void insertRecruiter ( String newCompanyName, String newUsername)
    {
      Connection con = null;
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO recruiter VALUES ('"+ newCompanyName +"','"+ newUsername +"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
    }
   
      public void insertSeeker ( String newSkill, String typeOfJob, String compensationLevel, String newUsername)
    {
      Connection con = null;
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO seeker VALUES ('"+ newSkill +"','"+typeOfJob+"','"+compensationLevel+"','"+ newUsername +"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
    }
    
    public ArrayList<Job> showJob (String UserName)
    {
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      Job object = new Job();
      ArrayList<Job> jobList = new ArrayList<Job>();
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
          result = stmt.executeQuery("SELECT * FROM job where job.userName like '"+ UserName +"';");
      
         while(result.next()){
               object.jobId = result.getString("jobId");
               object.userName = result.getString("userName");
               object.title = result.getString("title");
               object.deadline = result.getString("deadline");
               object.skills = result.getString("skill");
               object.location = result.getString("location");
               object.category = result.getString("category");
               object.description = result.getString("description");
               object.compensationLevel = result.getString("compensation");
               jobList.add(object);
        }
        
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return jobList;
   }
   
   public void updateSeeker(String newUserName, String skillsets, String typeOfJob, String salary)
   {      
      Connection con = null;
      Statement stmt = null; 
      int result = 0; 
      int resultSalary = 0;
      int updateResult = 0;
      String newSkill = null;
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("Update seeker set typeOfJob = '"+ typeOfJob +"' where userName like '"+newUserName+"';");
         resultSalary = stmt.executeUpdate("Update seeker set compensation = '"+salary+"' where userName like '"+newUserName+"';");
         updateResult = stmt.executeUpdate(" Update seeker set skill = '"+ skillsets+ "' where userName like '" +newUserName+ "' ;"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
   }
   
   public void deleteSkillsets(String newUserName)
   {
      Connection con = null;
      Statement stmt = null;
      int result = 0;      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeUpdate("DELETE keySkill FROM seeker   WHERE userName like '"+ newUserName +"';");
      } catch (Exception e) {
      
         e.printStackTrace(System.out);
      }
      System.out.println(result+" Rows effected");
   }
   
   
   public ArrayList<Job> showAllJob()
   {
      ArrayList<Job> jobList = new ArrayList<Job>();
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
       try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT * FROM job;");
         
         while(result.next()){
               Job object = new Job();
               object.jobId = result.getString("jobId");
               object.userName = result.getString("userName");
               object.title = result.getString("title");
               object.deadline = result.getString("deadline");
               object.skills = result.getString("skills");
               object.location = result.getString("location");
               object.category = result.getString("category");
               object.description = result.getString("description");
               object.compensationLevel = result.getString("compensation");
               jobList.add(object);
         }        
      } catch (Exception e) {
         e.printStackTrace(System.out);
      } 
      return jobList;
   }
   
   public void insertApplication(String number,String userName, String jobId, String state)
   {
      Connection con = null; 
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO application VALUES (' " + number +"', '"+ userName + "', '" + jobId + "', '" + state +"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
   } 
   
   public void insertNotification(String number,String recruiterId, String seekerId, String info)
   {
      Connection con = null; 
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO notification VALUES (' " + number +"', '"+ recruiterId + "', '" + seekerId + "', '" + info +"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
   } 
   
   
   
   public ArrayList<Notification> showNotification(String userName)
   {
      ArrayList<Notification> noteList = new ArrayList<>();
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT * FROM notification where notification.seekerid like '"+ userName +"';");
         
         while(result.next()){
               Notification notif = new Notification();
               notif.notificationId = result.getString("notificationid");
               notif.recruiterId = result.getString("recruiterid");
               notif.seekerId = result.getString("seekerid");
               notif.info = result.getString("info");
               noteList.add(notif);
         }        
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return noteList;
   }
   
   public ArrayList<Application> showApplication(String userName)
   {
      ArrayList<Application> noteList = new ArrayList<>();
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT * FROM application where application.username like '"+ userName+"';");
         
         while(result.next()){
               Application app = new Application();
               app.applicationId = result.getString("applicationid");
               app.userName = result.getString("username");
               app.jobId = result.getString("jobid");
               app.state = result.getString("state");
               noteList.add(app);
         }        
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return noteList;
   }
   
   public String getCategory(String userName)
   {
       String newCategory = "";
       Connection con = null;
       Statement stmt = null;
       ResultSet result = null;
        try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT * FROM recruiter where recruiter.userName like '"+ userName +"';");
         while(result.next()){
              newCategory = result.getString("category");
         }        
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
       return newCategory;
   }
   
   public void setNewCategory(String newUserName, String Category)
   {
       Connection con = null;
       Statement stmt =  null;
       int result = 0;
       try 
       { 
           Class.forName("org.hsqldb.jdbc.JDBCDriver");
           con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
           stmt = con.createStatement(); 
           result = stmt.executeUpdate("Insert INTO recruiter values (' " + Category +"', '"+ newUserName+"') ;"); 
           con.commit(); 
        }
        catch(Exception e)
        { e.printStackTrace(System.out);
        }
        System.out.println(result+" rows affected");
   }
    
   public void setCategory(String newUserName,String newCategory)
   {
      Connection con = null; 
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("UPDATE recruiter SET category = '"+ newCategory+"' WHERE userName like '"+newUserName+"' ;"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
   }
   //Inserting Job details from the control class into the database 
   public void insertNotAdvertiseJob(String newjobId, String newUserName, String newtitle, String newdeadline, String newskills, String newlocation,
    String newcategory, String newdescription, String newcompensationLevel)
   {
      Connection con = null; 
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO job VALUES ('"+newjobId+"','"+newUserName+"','"+newtitle+"','"+newcompensationLevel+"','"+newdeadline+"','"+newskills+"','"+newlocation+"','"+newdescription+"','"+newcategory+"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
   }
   
   public void deleteNotAdvertiseJob(String userName, String jobId)
   {
        Connection con = null;
      Statement stmt = null;
      int result = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeUpdate("DELETE FROM job   WHERE userName like '"+ userName +"' and state like 'notAdvertise';");
      } catch (Exception e) {
      
         e.printStackTrace(System.out);
      }
      System.out.println(result+" Rows effected");
   }


   public void insertAdvertiseJob(String newjobId, String newuserName, String newtitle, String newdeadline, String newskills, String newlocation,
    String newcategory, String newdescription, String newcompensationLevel)
   { Connection con = null; 
      Statement stmt = null; 
      int result = 0; 
      try { 
         Class.forName("org.hsqldb.jdbc.JDBCDriver"); 
         con = DriverManager.getConnection( "jdbc:hsqldb:hsql://localhost/ojssdb", "SA", ""); 
         stmt = con.createStatement(); 
         result = stmt.executeUpdate("INSERT INTO job (jobId,userName, title, deadline, skill, location , description, compensation , state) VALUES ('"+newjobId+"','"+newuserName+"','"+newtitle+"','"+newdeadline+"','"+newskills+"','"+newlocation+"','"+newcategory+"','"+newdescription+"','"+newcompensationLevel+"');"); 
         con.commit(); 
      }catch (Exception e) { 
         e.printStackTrace(System.out); 
      } 
      System.out.println(result+" rows effected"); 
      System.out.println("Rows inserted successfully"); 
       
   }
   
   //this method return the jobId for this userName
   public ArrayList<String> showJobId(String newUserName)
   {
       ArrayList<String> idList = new ArrayList<String>();
       Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      String existJobId = null;
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection(
            "jdbc:hsqldb:hsql://localhost/testdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT jobId FROM job where userName like '"+ newUserName+"';");
         
         while(result.next()){
           existJobId = result.getString("jobId");
          idList.add(existJobId);
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
       return idList;
   }
   
   public ArrayList<Seeker> showAllSeeker()
   {
      ArrayList<Seeker> seekerList = new ArrayList<Seeker>();
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT * FROM seeker;");
         while(result.next()){
            Seeker newSeeker = new Seeker();
            newSeeker.skillsets = result.getString("skill");
            newSeeker.userName = result.getString("userName");
            newSeeker.typeOfJob = result.getString("typeOfJob");
            newSeeker.compensationLevel = result.getString("compensation");
            seekerList.add(newSeeker);
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
       return seekerList;
       
   }
   
   public Seeker showSeekerInfo(String newUserName)
   {
      Seeker newSeeker = new Seeker();
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT * FROM seeker where userName like '"+ newUserName +"';");
         
         while(result.next()){
            newSeeker.skillsets = result.getString("skill");
            newSeeker.userName = result.getString("userName");
            newSeeker.typeOfJob = result.getString("typeOfJob");
            newSeeker.compensationLevel = result.getString("compensation");
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
       return newSeeker;
   }
     
   public ArrayList<Job> showOneJob(String userId)
   {
      ArrayList<Job> jobList = new ArrayList<>();
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT * FROM job where username like '"+ userId +"';");
         
         while(result.next()){
               Job object = new Job();
               object.jobId = result.getString("jobId");
               object.userName = result.getString("userName");
               object.title = result.getString("title");
               object.deadline = result.getString("deadline");
               object.skills = result.getString("skills");
               object.location = result.getString("location");
               object.category = result.getString("category");
               object.description = result.getString("description");
               object.compensationLevel = result.getString("compensation");
               jobList.add(object);
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return jobList;   
   }
   // Listing all usernames from the User table from database and returning the result to the control class
   public ArrayList<String> showAllUserName()
   {
     ArrayList<String> userList = new ArrayList<String>();
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      String temp = null;
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT userName FROM user;");
         
         while(result.next()){
            temp = result.getString("userName");
            userList.add(temp);
            temp = null;
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return userList;
   }
   
   public String[] showPasswordAndType( String newUserName )
   {
      String[] list = new String[2];
      Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      String temp = null;
      String tempRole = null;
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT password, role FROM user WHERE userName like '"+newUserName+"';");
         
         while(result.next()){
            temp = result.getString("password");
            list[0] = temp;
            tempRole = result.getString("role");
            list[1] = tempRole;
         }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return list;
    }
    
   public String showSkillSet ( String newUserName )
   {
    Connection con = null;
      Statement stmt = null;
      ResultSet result = null;
      String temp = null;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT skills FROM job WHERE userName like '"+newUserName+"';");
         
         while(result.next()){
            temp = result.getString("skills");
            
                   }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return temp;   
   }
    
   public int countJob()
   {
       Connection con = null;
       Statement stmt = null;
        ResultSet result = null;
      int temp = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT count(*) as counts FROM job ;");
         
         while(result.next()){
            temp = result.getInt("counts");
            
                   }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return temp;   
       
    }
    
    public int countApplication()
   {
       Connection con = null;
       Statement stmt = null;
        ResultSet result = null;
      int temp = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT count(*) as counts FROM application;");
         
         while(result.next()){
            temp = result.getInt("counts");
            
                   }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return temp;   
       
    }
    
    public int countNotification()
   {
       Connection con = null;
       Statement stmt = null;
        ResultSet result = null;
      int temp = 0;
      
      try {
         Class.forName("org.hsqldb.jdbc.JDBCDriver");
         con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/ojssdb", "SA", "");
         stmt = con.createStatement();
         result = stmt.executeQuery("SELECT count(*) as counts FROM notification;");
         
         while(result.next()){
            temp = result.getInt("counts");
            
                   }
      } catch (Exception e) {
         e.printStackTrace(System.out);
      }
      return temp;   
       
    }
   
   }
     
   
   


