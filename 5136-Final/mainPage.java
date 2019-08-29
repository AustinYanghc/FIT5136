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
import java.util.ArrayList;

public class mainPage extends JFrame {
    public String userId;
    public String type;
    private JMenuBar menuBar;
    private JButton button1;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JLabel label1;
    private JLabel label5;
    private SeekerController seeker;

    //Constructor 
    public mainPage(String userId, String type){
        seeker = new SeekerController();
        this.userId = userId;
        this.type = type;
        this.setTitle("GUI_project");
        this.setSize(500,500);
        //menu generate method
        generateMenu();
        this.setJMenuBar(menuBar);

        //pane with null layout
        JPanel contentPane = new JPanel(null);
        contentPane.setPreferredSize(new Dimension(500,500));
        contentPane.setBackground(new Color(255,255,255));


        button1 = new JButton();
        button1.setBounds(145,170,200,35);
        button1.setBackground(new Color(214,217,223));
        button1.setForeground(new Color(0,0,0));
        button1.setEnabled(true);
        button1.setFont(new Font("sansserif",0,12));
        button1.setText("Create Job");
        button1.setVisible(true);
        button1.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed1(evt);
            }
        }); 

        button3 = new JButton();
        button3.setBounds(145,220,200,35);
        button3.setBackground(new Color(214,217,223));
        button3.setForeground(new Color(0,0,0));
        button3.setEnabled(true);
        button3.setFont(new Font("sansserif",0,12));
        button3.setText("Manage Seeker Information");
        button3.setVisible(true);
        button3.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed2(evt);
            }
        }); 
        
        button4 = new JButton();
        button4.setBounds(145,270,200,35);
        button4.setBackground(new Color(214,217,223));
        button4.setForeground(new Color(0,0,0));
        button4.setEnabled(true);
        button4.setFont(new Font("sansserif",0,12));
        button4.setText("Manage Job Category");
        button4.setVisible(true);
        button4.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed3(evt);
            }
        }); 
        
        button5 = new JButton();
        button5.setBounds(145,320,200,35);
        button5.setBackground(new Color(214,217,223));
        button5.setForeground(new Color(0,0,0));
        button5.setEnabled(true);
        button5.setFont(new Font("sansserif",0,12));
        button5.setText("Get Application");
        button5.setVisible(true);
        button5.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed4(evt);
            }
        }); 
        
        button6 = new JButton();
        button6.setBounds(145,120,200,35);
        button6.setBackground(new Color(214,217,223));
        button6.setForeground(new Color(0,0,0));
        button6.setEnabled(true);
        button6.setFont(new Font("sansserif",0,12));
        button6.setText("Search");
        button6.setVisible(true);
        button6.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed5(evt);
            }
        }); 
        
        button8 = new JButton();
        button8.setBounds(145,370,200,35);
        button8.setBackground(new Color(214,217,223));
        button8.setForeground(new Color(0,0,0));
        button8.setEnabled(true);
        button8.setFont(new Font("sansserif",0,12));
        button8.setText("Get Notification");
        button8.setVisible(true);
        button8.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed7(evt);
            }
        });
  
        button7 = new JButton();
		button7.setBounds(145,420,200,35);
		button7.setBackground(new Color(214,217,223));
		button7.setForeground(new Color(0,0,0));
		button7.setEnabled(true);
		button7.setFont(new Font("sansserif",0,12));
		button7.setText("Match Seeker");
		button7.setVisible(true);
		button7.addMouseListener(new MouseAdapter() 
		{
		    public void mouseClicked(MouseEvent evt) 
		    {
		        procceed8(evt);
		    }
		});
        
        label1 = new JLabel();
        label1.setBounds(185,25,150,35);
        label1.setBackground(new Color(214,217,223));
        label1.setForeground(new Color(0,0,0));
        label1.setEnabled(true);
        label1.setFont(new Font("SansSerif",0,23));
        label1.setText("Main Page");
        label1.setVisible(true);

        label5 = new JLabel();
        label5.setBounds(45,70,440,35);
        label5.setBackground(new Color(214,217,223));
        label5.setForeground(new Color(0,0,0));
        label5.setEnabled(true);
        label5.setFont(new Font("sansserif",0,12));
        label5.setText("——————————————————————————————————");
        label5.setVisible(true);

        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(button3);
        contentPane.add(button4);
        contentPane.add(button5);
        contentPane.add(button6);
        contentPane.add(button7);
        contentPane.add(button8);
        contentPane.add(label1);
        contentPane.add(label5);

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
        if (evt.getSource() == button1){
            new createJob(userId,type);
        }
    }
    
    private void procceed2 (MouseEvent evt)
    {
        if (evt.getSource() == button3){
            new manageSeekerInfo(userId,type);
        }
    }   
    
    private void procceed3 (MouseEvent evt)
    {
        if (evt.getSource() == button4){
            new manageJobCategory(userId,type);
        }
    }   
    
    private void procceed4 (MouseEvent evt)
    {
        if (evt.getSource() == button5){
            ArrayList<Application> appList = seeker.showApplication(userId);
            for (Application app :appList)
            {
                System.out.println(app.printApplication());
            }
            new mainPage(userId,type);
        }
    }   
    
    private void procceed5 (MouseEvent evt)
    {
        if (evt.getSource() == button6){
            new searchPage(userId,type);
        }
    } 
    
        private void procceed7 (MouseEvent evt)
     {
         if (evt.getSource() == button8){
             ArrayList<Notification> note = seeker.receiveNotification(userId);
             for (Notification noti : note)
             {
                 System.out.println(noti.printNoti());
             }
             new mainPage(userId,type);
         }
     }
     
    private void procceed8 (MouseEvent evt)
	{
	    if (evt.getSource() == button7){
            new matching(userId,type);
        }
	} 
    
     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new mainPage("","");
            }
        });
    }

}