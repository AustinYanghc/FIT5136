import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.UnsupportedEncodingException;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
/**
 * Write a description of class VaildationController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class VaildationController
{
    private ConnectDatabase ojssDb;
    
    // instance variables - replace the example below with your own
    /**
     * Constructor for objects of class VaildationController
     */
    public VaildationController()
    {
        // initialise instance variables
        ojssDb = new ConnectDatabase();
    }
    
    public boolean isNumber(String checkString)
    {
        if (checkString.isEmpty())
        {
            return false;
        }
        for (int i = 0; i < checkString.length(); i++)
        {
            if (!Character.isDigit(checkString.charAt(i)))
                return false;
        }
        return true;
    }
    
    public boolean isAlphabetOrDigit(String checkString)
    {
        if (checkString.isEmpty())
        {
            return false;
        }
        for (int i = 0; i < checkString.length(); i++)
        {
            if (!Character.isLetter(checkString.charAt(i)) && !Character.isDigit(checkString.charAt(i)))
                return false;
        }
        return true;
    }
    
     public static String hex(String content) {
        byte[] hash;
        try {
            hash = MessageDigest.getInstance("MD5").digest(content.getBytes("UTF-8"));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("NoSuchAlgorithmException",e);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UnsupportedEncodingException", e);
        }

        StringBuilder hex = new StringBuilder(hash.length * 2);
        for (byte b : hash) {
            if ((b & 0xFF) < 0x10){
                hex.append("0");
            }
            hex.append(Integer.toHexString(b & 0xFF));
        }
        return hex.toString();
    }
    
    public static boolean checkEmail(String email) {
        boolean flag = false;
        try {
            String check = "\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*";
            Pattern regex = Pattern.compile(check);
            Matcher matcher = regex.matcher(email);
            flag = matcher.matches();
        } catch (Exception e) {
            flag = false;
        }
        return flag;
    }
    
    public boolean checkExist(String userName)
    {
        ArrayList<String> userList = ojssDb.showAllUserName();
        for (String user : userList)
        {
            if(user.equalsIgnoreCase(userName))
                return true;    
        }
        return false;
    }
    
    public boolean checkLogin(String userName, String password)
    {
        String[] info = ojssDb.showPasswordAndType(userName);
        if (password.equalsIgnoreCase(info[0]))
        {
            return true;
        }
        else
            return false;
    }

    public boolean checkType(String userName, String type)
    {
        String[] info = ojssDb.showPasswordAndType(userName);
        if (type.equalsIgnoreCase(info[1]))
        {
            return true;
        }
        else
            return false;
    }
    
    public boolean checkName(String checkString)
    {
        int hyphenNumber = 0;
        for (int i = 0; i < checkString.length(); i++)
        {
            if ((i == 0 && (!Character.isLetter(checkString.charAt(i)))) || 
                (i == checkString.length() - 1 && (!Character.isLetter(checkString.charAt(i)))))
                return false;
            else 
            {
                if (checkString.charAt(i) == '-')
                {
                    hyphenNumber++;
                }
                else if (!Character.isLetter(checkString.charAt(i)))
                {
                    return false;
                }
            }
        }
        if ( checkString.length() < 2 || checkString.length() > 10 || hyphenNumber > 1)
            return false;
        return true;
    }
    
    public String getType(String userName)
    {
        String[] info = ojssDb.showPasswordAndType(userName);
        return info[1];
    }
    
    public boolean checkPhone(String phoneNumber)
    {
        if (isNumber(phoneNumber) && phoneNumber.length() == 10)
            return true;
        else
            return false;
    }
}
