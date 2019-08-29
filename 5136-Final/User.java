
/**
 * Write a description of class User here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class User
{
    // instance variables - replace the example below with your own
    public String userName;
    private String name;
    private String role;
    private String password;
    private String email;
    private String type;
    private String address;
    private String Dob;
    private String mobileNumber;
    /**
     * Constructor for objects of class User
     */
    public User()
    {
        userName = "";
        name = "";
        password = "";
        email = "";
        type = "";
        address = "";
        Dob = "";
        mobileNumber = "";
    }
    
    public User(String userId, String name, String password, String email, String type, String address, String dob, String number)
    {
        userName = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.type = type;
        this.address = address;
        Dob = dob;
        mobileNumber = number;
    }
    
    public String getRole()
    {
        return type;
    }
    
    public String getUserName()
    {
        return userName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
    public String getEmail()
    {
        return email;
    }
    
    public String getAddress()
    {
        return address;
    }
    
    public String getDob()
    {
        return Dob;
    }
    
    public String getMobile()
    {
        return mobileNumber;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setUserName(String userName)
    {
        this.userName = userName;
    }
    
    public void setPassword(String password)
    {
        this.password = password;
    }
    
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public void setAddress(String address)
    {
        this.address = address;
    }
    
    public void setDob(String Dob)
    {
        this.Dob = Dob;
    }
    
    public void setMobileNumber(String mobileNumber)
    {
        this.mobileNumber = mobileNumber;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setRole(String role)
    {
        this.role = role;
    }
    

 
}
