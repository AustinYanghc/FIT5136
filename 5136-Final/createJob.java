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

public class createJob extends JFrame {
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
	private JLabel label7;
	private JLabel label8;
	private JLabel label9;
	private JLabel label11;
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;
	private JTextField textfield6;
	private JTextField textfield7;
	
	private Job job;
	private VaildationController Vaildationcontroller;
	private RecruiterController Recruitercontroller;
	private ConnectDatabase data;

	//Constructor 
	public createJob(String userId,String type){
	    Recruitercontroller = new RecruiterController();
	    data = new ConnectDatabase();
	    this.userId = userId;
	    this.type = type;
	    job = new Job();
        Recruitercontroller = new RecruiterController();
	    Vaildationcontroller = new VaildationController();

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
		button1.setBounds(100,350,100,35);
		button1.setBackground(new Color(214,217,223));
		button1.setForeground(new Color(0,0,0));
		button1.setEnabled(true);
		button1.setFont(new Font("sansserif",0,12));
		button1.setText("Confirm");
		button1.setVisible(true);
		button1.addMouseListener(new MouseAdapter() 
		{
		    public void mouseClicked(MouseEvent evt) 
		    {
		        procceed1(evt);
		    }
		});	
		
	    button2 = new JButton();
		button2.setBounds(250,350,200,35);
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
		
		label1 = new JLabel();
		label1.setBounds(188,25,150,35);
		label1.setBackground(new Color(214,217,223));
		label1.setForeground(new Color(0,0,0));
		label1.setEnabled(true);
		label1.setFont(new Font("SansSerif",0,23));
		label1.setText("Create Job");
		label1.setVisible(true);

		
		label2 = new JLabel();
		label2.setBounds(45,80,90,35);
		label2.setBackground(new Color(214,217,223));
		label2.setForeground(new Color(0,0,0));
		label2.setEnabled(true);
		label2.setFont(new Font("sansserif",0,12));
		label2.setText("Title");
		label2.setVisible(true);

		label3 = new JLabel();
		label3.setBounds(45,115,90,35);
		label3.setBackground(new Color(214,217,223));
		label3.setForeground(new Color(0,0,0));
		label3.setEnabled(true);
		label3.setFont(new Font("sansserif",0,12));
		label3.setText("Deadline");
		label3.setVisible(true);

		label4 = new JLabel();
		label4.setBounds(45,150,90,35);
		label4.setBackground(new Color(214,217,223));
		label4.setForeground(new Color(0,0,0));
		label4.setEnabled(true);
		label4.setFont(new Font("sansserif",0,12));
		label4.setText("Skills");
		label4.setVisible(true);

		label5 = new JLabel();
		label5.setBounds(45,185,90,35);
		label5.setBackground(new Color(214,217,223));
		label5.setForeground(new Color(0,0,0));
		label5.setEnabled(true);
		label5.setFont(new Font("sansserif",0,12));
		label5.setText("Location");
		label5.setVisible(true);

		label6 = new JLabel();
		label6.setBounds(45,220,90,35);
		label6.setBackground(new Color(214,217,223));
		label6.setForeground(new Color(0,0,0));
		label6.setEnabled(true);
		label6.setFont(new Font("sansserif",0,12));
		label6.setText("Category");
		label6.setVisible(true);

		label7 = new JLabel();
		label7.setBounds(45,255,90,35);
		label7.setBackground(new Color(214,217,223));
		label7.setForeground(new Color(0,0,0));
		label7.setEnabled(true);
		label7.setFont(new Font("sansserif",0,12));
		label7.setText("Description");
		label7.setVisible(true);

		label8 = new JLabel();
		label8.setBounds(45,290,90,35);
		label8.setBackground(new Color(214,217,223));
		label8.setForeground(new Color(0,0,0));
		label8.setEnabled(true);
		label8.setFont(new Font("sansserif",0,12));
		label8.setText("Salary");
		label8.setVisible(true);

		label9 = new JLabel();
		label9.setBounds(350,290,90,35);
		label9.setBackground(new Color(214,217,223));
		label9.setForeground(new Color(0,0,0));
		label9.setEnabled(true);
		label9.setFont(new Font("sansserif",0,12));
		label9.setText("/ year");
		label9.setVisible(true);
	
		label11 = new JLabel();
		label11.setBounds(160,320,300,35);
		label11.setBackground(new Color(214,217,223));
		label11.setForeground(new Color(0,0,0));
		label11.setEnabled(true);
		label11.setFont(new Font("sansserif",0,12));
		label11.setText("");
		label11.setVisible(true);	

		textfield1 = new JTextField();
		textfield1.setBounds(130,85,300,30);
		textfield1.setBackground(new Color(255,255,255));
		textfield1.setForeground(new Color(0,0,0));
		textfield1.setEnabled(true);
		textfield1.setFont(new Font("sansserif",0,12));
		textfield1.setText("");
		textfield1.setVisible(true);

		textfield2 = new JTextField();
		textfield2.setBounds(130,120,300,30);
		textfield2.setBackground(new Color(255,255,255));
		textfield2.setForeground(new Color(0,0,0));
		textfield2.setEnabled(true);
		textfield2.setFont(new Font("sansserif",0,12));
		textfield2.setText("");
		textfield2.setVisible(true);

		textfield3 = new JTextField();
		textfield3.setBounds(130,155,300,30);
		textfield3.setBackground(new Color(255,255,255));
		textfield3.setForeground(new Color(0,0,0));
		textfield3.setEnabled(true);
		textfield3.setFont(new Font("sansserif",0,12));
		textfield3.setText("");
		textfield3.setVisible(true);

		textfield4 = new JTextField();
		textfield4.setBounds(130,190,300,30);
		textfield4.setBackground(new Color(255,255,255));
		textfield4.setForeground(new Color(0,0,0));
		textfield4.setEnabled(true);
		textfield4.setFont(new Font("sansserif",0,12));
		textfield4.setText("");
		textfield4.setVisible(true);

		textfield5 = new JTextField();
		textfield5.setBounds(130,225,300,30);
		textfield5.setBackground(new Color(255,255,255));
		textfield5.setForeground(new Color(0,0,0));
		textfield5.setEnabled(true);
		textfield5.setFont(new Font("sansserif",0,12));
		textfield5.setText("");
		textfield5.setVisible(true);

		textfield6 = new JTextField();
		textfield6.setBounds(130,260,300,30);
		textfield6.setBackground(new Color(255,255,255));
		textfield6.setForeground(new Color(0,0,0));
		textfield6.setEnabled(true);
		textfield6.setFont(new Font("sansserif",0,12));
		textfield6.setText("");
		textfield6.setVisible(true);

		textfield7 = new JTextField();
		textfield7.setBounds(130,295,200,30);
		textfield7.setBackground(new Color(255,255,255));
		textfield7.setForeground(new Color(0,0,0));
		textfield7.setEnabled(true);
		textfield7.setFont(new Font("sansserif",0,12));
		textfield7.setText("");
		textfield7.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(label4);
		contentPane.add(label5);
		contentPane.add(label6);
		contentPane.add(label7);
		contentPane.add(label8);
		contentPane.add(label9);
		contentPane.add(label9);
		contentPane.add(label11);
		contentPane.add(textfield1);
		contentPane.add(textfield2);
		contentPane.add(textfield3);
		contentPane.add(textfield4);
		contentPane.add(textfield5);
		contentPane.add(textfield6);
		contentPane.add(textfield7);

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
	        createResult();
            new mainPage(userId,type);
        }
	}	
	
    private void procceed2 (MouseEvent evt)
	{
	    if (evt.getSource() == button2){
            new mainPage(userId,type);
        }
	}	
	
	public String getJobTitle(){
        String title = textfield1.getText();
        return title ==null || title.isEmpty() ? "": title;
    }
	
	public String getJobDeadline(){
        String dl = textfield2.getText();
        return dl ==null || dl.isEmpty() ? "": dl;
    }
    
    public String getJobSkills(){
        String skill = textfield3.getText();
        return skill ==null || skill.isEmpty() ? "": skill;
    }
    
    public String getJobLocation(){
        String location = textfield4.getText();
        return location ==null || location.isEmpty() ? "": location;
    }
    
    public String getJobCategory(){
        String category = textfield5.getText();
        return category ==null || category.isEmpty() ? "": category;
    }
    
    public String getJobDescription(){
        String description = textfield6.getText();
        return description ==null || description.isEmpty() ? "": description;
    }
    
    public String getJobSalary(){
        String salary = textfield7.getText();
        return salary ==null || salary.isEmpty() ? "": salary;
    }	
    
    public void createResult(){
        String userName = this.userId;
        String jobId = String.valueOf(data.countJob()+1);
        String title = getJobTitle();
        String dl = getJobDeadline();
        String skills = getJobSkills();
        String location = getJobLocation();
        String category = getJobCategory();
        String description = getJobDescription();
        String salary = getJobSalary();
        if(title.equals("")|| dl.equals("")||skills.equals("")||location.equals("")||category.equals("")||description.equals("")||salary.equals(""))
            label11.setText("These areas cannot be empty.");
        else
        {
            Job job = new Job(jobId, userName, title, dl, skills, location, category, description, salary);
            Recruitercontroller.createJob(job);  
        }
        } 
        
	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new createJob("","");
			}
		});
	}

}
   
