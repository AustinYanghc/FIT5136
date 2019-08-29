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
import java.util.ArrayList;


public class searchPage extends JFrame {
 private String userId;
 private String type;
 private JMenuBar menuBar;
 private JButton button1;
 private JButton button2;
 private JButton button3;
 private JLabel label1;
 private JLabel label2;
 private JLabel label3;
 private JLabel label4;
 private JLabel label5;
 private JLabel label6;
 private JTextField textfield1;
 private JTextField textfield2;
 private JTextField textfield3;
 private JTextField textfield4;
 private JTextField textfield5;
 
 private SeekerController Seekercontroller;

 //Constructor 
 public searchPage(String userId,String type){
     Seekercontroller = new SeekerController();
  this.userId = userId;
  this.type = type;
  this.setTitle("GUI_project");
  this.setSize(600,400);
  //menu generate method
  generateMenu();
  this.setJMenuBar(menuBar);

  //pane with null layout
  JPanel contentPane = new JPanel(null);
  contentPane.setPreferredSize(new Dimension(600,400));
  contentPane.setBackground(new Color(255,255,255));

  button1 = new JButton();
  button1.setBounds(130,200,120,35);
  button1.setBackground(new Color(214,217,223));
  button1.setForeground(new Color(0,0,0));
  button1.setEnabled(true);
  button1.setFont(new Font("sansserif",0,12));
  button1.setText("Seek");
  button1.setVisible(true);
  button1.addMouseListener(new MouseAdapter() 
  {
      public void mouseClicked(MouseEvent evt) 
      {
          procceed1(evt);
      }
  }); 

  button2 = new JButton();
  button2.setBounds(345,200,120,35);
  button2.setBackground(new Color(214,217,223));
  button2.setForeground(new Color(0,0,0));
  button2.setEnabled(true);
  button2.setFont(new Font("sansserif",0,12));
  button2.setText("Main Page");
  button2.setVisible(true);
  button2.addMouseListener(new MouseAdapter() 
  {
      public void mouseClicked(MouseEvent evt) 
      {
          procceed2(evt);
      }
  }); 
  
  button3 = new JButton();
  button3.setBounds(250,280,120,35);
  button3.setBackground(new Color(214,217,223));
  button3.setForeground(new Color(0,0,0));
  button3.setEnabled(true);
  button3.setFont(new Font("sansserif",0,12));
  button3.setText("Apply");
  button3.setVisible(true);
  button3.addMouseListener(new MouseAdapter() 
  {
      public void mouseClicked(MouseEvent evt) 
      {
          procceed3(evt);
      }
  });   
    
    
  label1 = new JLabel();
  label1.setBounds(260,20,90,35);
  label1.setBackground(new Color(214,217,223));
  label1.setForeground(new Color(0,0,0));
  label1.setEnabled(true);
  label1.setFont(new Font("SansSerif",0,23));
  label1.setText("Search");
  label1.setVisible(true);

  label2 = new JLabel();
  label2.setBounds(60,70,90,35);
  label2.setBackground(new Color(214,217,223));
  label2.setForeground(new Color(0,0,0));
  label2.setEnabled(true);
  label2.setFont(new Font("sansserif",0,12));
  label2.setText("Keyword");
  label2.setVisible(true);

  label3 = new JLabel();
  label3.setBounds(300,70,90,35);
  label3.setBackground(new Color(214,217,223));
  label3.setForeground(new Color(0,0,0));
  label3.setEnabled(true);
  label3.setFont(new Font("sansserif",0,12));
  label3.setText("Category");
  label3.setVisible(true);

  label4 = new JLabel();
  label4.setBounds(60,150,90,35);
  label4.setBackground(new Color(214,217,223));
  label4.setForeground(new Color(0,0,0));
  label4.setEnabled(true);
  label4.setFont(new Font("sansserif",0,12));
  label4.setText("Location");
  label4.setVisible(true);
  
  label6 = new JLabel();
  label6.setBounds(300,150,90,35);
  label6.setBackground(new Color(214,217,223));
  label6.setForeground(new Color(0,0,0));
  label6.setEnabled(true);
  label6.setFont(new Font("sansserif",0,12));
  label6.setText("Salary");
  label6.setVisible(true);

  label5 = new JLabel();
  label5.setBounds(40,240,290,35);
  label5.setBackground(new Color(214,217,223));
  label5.setForeground(new Color(0,0,0));
  label5.setEnabled(true);
  label5.setFont(new Font("sansserif",0,12));
  label5.setText("Please type in the jobId here");
  label5.setVisible(true);

  textfield1 = new JTextField();
  textfield1.setBounds(120,75,150,30);
  textfield1.setBackground(new Color(255,255,255));
  textfield1.setForeground(new Color(0,0,0));
  textfield1.setEnabled(true);
  textfield1.setFont(new Font("sansserif",0,12));
  textfield1.setText("");
  textfield1.setVisible(true);

  textfield2 = new JTextField();
  textfield2.setBounds(360,75,150,30);
  textfield2.setBackground(new Color(255,255,255));
  textfield2.setForeground(new Color(0,0,0));
  textfield2.setEnabled(true);
  textfield2.setFont(new Font("sansserif",0,12));
  textfield2.setText("");
  textfield2.setVisible(true);

  textfield3 = new JTextField();
  textfield3.setBounds(120,155,150,30);
  textfield3.setBackground(new Color(255,255,255));
  textfield3.setForeground(new Color(0,0,0));
  textfield3.setEnabled(true);
  textfield3.setFont(new Font("sansserif",0,12));
  textfield3.setText("");
  textfield3.setVisible(true);

  textfield4 = new JTextField();
  textfield4.setBounds(360,155,150,30);
  textfield4.setBackground(new Color(255,255,255));
  textfield4.setForeground(new Color(0,0,0));
  textfield4.setEnabled(true);
  textfield4.setFont(new Font("sansserif",0,12));
  textfield4.setText("");
  textfield4.setVisible(true);
  
  textfield5 = new JTextField();
  textfield5.setBounds(250,245,150,30);
  textfield5.setBackground(new Color(255,255,255));
  textfield5.setForeground(new Color(0,0,0));
  textfield5.setEnabled(true);
  textfield5.setFont(new Font("sansserif",0,12));
  textfield5.setText("");
  textfield5.setVisible(true);
  
  //adding components to contentPane panel
  contentPane.add(button1);
  contentPane.add(button2);
  contentPane.add(button3);
  contentPane.add(label1);
  contentPane.add(label2);
  contentPane.add(label3);
  contentPane.add(label4);
  contentPane.add(label5);
  contentPane.add(label6);
  contentPane.add(textfield1);
  contentPane.add(textfield2);
  contentPane.add(textfield3);
  contentPane.add(textfield4);
  contentPane.add(textfield5);

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
 
 public String getSkills(){
        String skill = textfield1.getText();
        return skill ==null || skill.isEmpty() ? "": skill;
    }
    
    public String getJobCategory(){
        String category = textfield2.getText();
        return category ==null || category.isEmpty() ? "": category;
    }
    
    public String getJobLocation(){
        String location = textfield3.getText();
        return location ==null || location.isEmpty() ? "": location;
    }
    
    public String getJobSalary(){
        String salary = textfield4.getText();
        return salary ==null || salary.isEmpty() ? "": salary;
    }
    
    public String getJobId(){
        String jobId = textfield5.getText();
        return jobId ==null || jobId.isEmpty() ? "": jobId;
    }
 
  private void procceed1 (MouseEvent evt)
    {
     String skill = getSkills();
     String category = getJobCategory();
     String location = getJobLocation();
     String salary = getJobSalary();
     if (evt.getSource() == button1){
            ArrayList<Job> jobList = Seekercontroller.searchJob(skill, category, location, salary);
            ArrayList<Integer> rank = Seekercontroller.rankJobList(jobList,skill,salary);
            for (int i = 0 ;i < jobList.size() ; i++)
            {
                System.out.println(jobList.get(i).printJob() + " rank " + rank.get(i));
            }
        }
    } 


    private void procceed2 (MouseEvent evt)
 {
     if (evt.getSource() == button2){
            new mainPage(userId,type);
        }
 } 
 
 private void procceed3 (MouseEvent evt)
 {
     if (evt.getSource() == button3){
            applyResult();
        }
 } 
 
 public void applyResult(){
        String jobId = getJobId();
        Seekercontroller.applyJob(userId,jobId);
    }

  public static void main(String[] args){
  System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
  javax.swing.SwingUtilities.invokeLater(new Runnable() {
   public void run() {
    new searchPage("","");
   }
  });
 }

}