/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import javax.swing.UIManager.LookAndFeelInfo;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import javax.swing.border.Border;
import javax.swing.*;


public class login extends JFrame {
    private mainPage ap;
    private String userId;
    private String type;
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button2;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JPasswordField passwordfield1;
    private JTextField textfield1;

    private User user;
    private VaildationController Vaildationcontroller;
    
    //Constructor 
    public login(){
        Vaildationcontroller = new VaildationController();
        userId = "";
        type = "";
        this.setTitle("GUI_project");
        this.setSize(500,400);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,400));
        contentPane.setBackground(new Color(255,255,255));


        button1 = new JButton();
        button1.setBounds(210,240,90,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Sign in");
        button1.setVisible(true);
        button1.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed2(evt);
            }
        }); 
        
        button2 = new JButton();
        button2.setBounds(305,320,90,35);
        button2.setBackground(new Color(214,217,223));
        button2.setForeground(new Color(0,0,0));
        button2.setEnabled(true);
        button2.setFont(new Font("sansserif",0,12));
        button2.setText("Register");
        button2.setVisible(true);
        button2.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed1(evt);
            }
        }); 

        label1 = new JLabel();
        label1.setBounds(75,280,400,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("sansserif",0,12));
        label1.setText("—————————————— or ——————————————");
        label1.setVisible(true);

        label2 = new JLabel();
        label2.setBounds(210,25,90,35);
        label2.setBackground(new Color(214,217,223));
        label2.setForeground(new Color(0,0,0));
        label2.setEnabled(true);
        label2.setFont(new Font("SansSerif",0,23));
        label2.setText("Log in");
        label2.setVisible(true);

        label3 = new JLabel();
        label3.setBounds(75,80,90,35);
        label3.setBackground(new Color(214,217,223));
        label3.setForeground(new Color(0,0,0));
        label3.setEnabled(true);
        label3.setFont(new Font("sansserif",0,12));
        label3.setText("UserName");
        label3.setVisible(true);

        label4 = new JLabel();
        label4.setBounds(75,150,90,35);
        label4.setBackground(new Color(214,217,223));
        label4.setForeground(new Color(0,0,0));
        label4.setEnabled(true);
        label4.setFont(new Font("sansserif",0,12));
        label4.setText("Password");
        label4.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(90,320,150,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("sansserif",0,12));
        label5.setText("* Don't have an account ?");
        label5.setVisible(true);

        label6 = new JLabel();
        label6.setBounds(240,360,150,35);
        label6.setBackground(new Color(214,217,223));
        label6.setForeground(new Color(0,0,0));
        label6.setEnabled(true);
        label6.setFont(new Font("sansserif",0,12));
        label6.setText("test");
        label6.setVisible(true);
        
        passwordfield1 = new JPasswordField();
        passwordfield1.setBounds(70,180,350,30);
        passwordfield1.setBackground(new Color(255,255,255));
        passwordfield1.setForeground(new Color(0,0,0));
        passwordfield1.setEnabled(true);
        passwordfield1.setFont(new Font("sansserif",0,12));
        passwordfield1.setVisible(true);

        textfield1 = new JTextField();
        textfield1.setBounds(70,110,350,30);
        textfield1.setBackground(new Color(255,255,255));
        textfield1.setForeground(new Color(0,0,0));
        textfield1.setEnabled(true);
        textfield1.setFont(new Font("sansserif",0,12));
        textfield1.setText("");
        textfield1.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(button2);
        contentPane.add(label1);
        contentPane.add(label2);
        contentPane.add(label3);
        contentPane.add(label4);
        contentPane.add(label5);
        contentPane.add(label6);
        contentPane.add(passwordfield1);
        contentPane.add(textfield1);

        //adding panel to JFrame and seting of window position and close operation
        this.add(contentPane);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.pack();
        this.setVisible(true);
    }

    //method for generate menu
    public void generateMenu(){
        menuBar = new JMenuBar();

        JMenu file = new JMenu("File");
        JMenu tools = new JMenu("Tools");
        JMenu help = new JMenu("Help");

        JMenuItem open = new JMenuItem("Open   ");
        JMenuItem save = new JMenuItem("Save   ");
        JMenuItem exit = new JMenuItem("Exit   ");
        JMenuItem preferences = new JMenuItem("Preferences   ");
        JMenuItem about = new JMenuItem("About   ");

        file.add(open);
        file.add(save);
        file.addSeparator();
        file.add(exit);
        tools.add(preferences);
        help.add(about);

        menuBar.add(file);
        menuBar.add(tools);
        menuBar.add(help);
    }
    
    private void procceed1 (MouseEvent evt)
    {
        if (evt.getSource() == button2){
            new register();
        } /*else if (evt.getSource() == exitButton) {
            System.exit(0);
        } */
    }
    
    private void procceed2 (MouseEvent evt)
    {
        if (evt.getSource() == button1){
            if(loginResult())
                new mainPage(this.userId,this.type);
        }
    }   
    
    public String getUserId(){
        String id = textfield1.getText();
        return id ==null || id.isEmpty() ? "": id;
    }   
    
    public String getUserPassword(){
        String password = passwordfield1.getText();
        return password ==null || password.isEmpty() ? "": password;
    }   
    
    public boolean loginResult(){
        User user = new User();
        String userId = getUserId();
        String password = getUserPassword();
        boolean checkExist = Vaildationcontroller.checkExist(userId);
        if(!checkExist){
            label6.setText("User does not exist.");
            return false;
        } else {
            boolean checkMatch = Vaildationcontroller.checkLogin(userId, password);
            if (checkMatch){
                String loginUserType = Vaildationcontroller.getType(userId);
                this.userId = userId;
                this.type = loginUserType;
                label6.setText("Login successfully");
                return true;
            }
              else if (!checkMatch) {
                this.label6.setText("UserId or password is incorrect.");
                return false;
            }  
        }
        return true;
    }

     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new login();
            }
        });
    }

}