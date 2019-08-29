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


public class manageSeekerInfo extends JFrame {
    public String userId;
    public String type;
	private JMenuBar menuBar;
	private JButton button1;
	private JButton button2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JLabel label11;
	private JTextField textfield1;
	private JTextField textfield3;
	private JTextField textfield4;
	private JTextField textfield5;
	private JTextField textfield6;
	private JTextField textfield7;
	
	private SeekerController Seekercontroller;
	

	//Constructor 
	public manageSeekerInfo(String userId,String type){
        Seekercontroller = new SeekerController();
	    this.userId = userId;
	    this.type = type;
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
		button1.setBounds(100,330,90,35);
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
		button2.setBounds(250,330,190,35);
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
		label1.setBounds(120,15,300,35);
		label1.setBackground(new Color(214,217,223));
		label1.setForeground(new Color(0,0,0));
		label1.setEnabled(true);
		label1.setFont(new Font("SansSerif",0,23));
		label1.setText("Manage Seeker Skillsets");
		label1.setVisible(true);

		label2 = new JLabel();
		label2.setBounds(45,90,90,35);
		label2.setBackground(new Color(214,217,223));
		label2.setForeground(new Color(0,0,0));
		label2.setEnabled(true);
		label2.setFont(new Font("sansserif",0,12));
		label2.setText("Skillsets");
		label2.setVisible(true);

		label3 = new JLabel();
		label3.setBounds(45,150,90,35);
		label3.setBackground(new Color(214,217,223));
		label3.setForeground(new Color(0,0,0));
		label3.setEnabled(true);
		label3.setFont(new Font("sansserif",0,12));
		label3.setText("TypeOfJob");
		label3.setVisible(true);

		label4 = new JLabel();
		label4.setBounds(45,210,90,35);
		label4.setBackground(new Color(214,217,223));
		label4.setForeground(new Color(0,0,0));
		label4.setEnabled(true);
		label4.setFont(new Font("sansserif",0,12));
		label4.setText("Salary");
		label4.setVisible(true);
		
		label11 = new JLabel();
		label11.setBounds(160,300,382,32);
		label11.setBackground(new Color(214,217,223));
		label11.setForeground(new Color(0,0,0));
		label11.setEnabled(true);
		label11.setFont(new Font("sansserif",0,12));
		label11.setText("");
		label11.setVisible(true);
		
        String[] result = Seekercontroller.showSeekerInfo(userId);
		textfield1 = new JTextField();
		textfield1.setBounds(140,210,300,30);
		textfield1.setBackground(new Color(255,255,255));
		textfield1.setForeground(new Color(0,0,0));
		textfield1.setEnabled(true);
		textfield1.setFont(new Font("sansserif",0,12));
		
		textfield1.setText(result[2]);
		textfield1.setVisible(true);
		
		textfield3 = new JTextField();
		textfield3.setBounds(140,150,300,30);
		textfield3.setBackground(new Color(255,255,255));
		textfield3.setForeground(new Color(0,0,0));
		textfield3.setEnabled(true);
		textfield3.setFont(new Font("sansserif",0,12));
		textfield3.setText(result[1]);
		textfield3.setVisible(true);

		textfield4 = new JTextField();
		textfield4.setBounds(140,90,300,30);
		textfield4.setBackground(new Color(255,255,255));
		textfield4.setForeground(new Color(0,0,0));
		textfield4.setEnabled(true);
		textfield4.setFont(new Font("sansserif",0,12));
		textfield4.setText(result[0]);
		textfield4.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(label4);
		contentPane.add(label11);
		contentPane.add(textfield1);
		contentPane.add(textfield3);
		contentPane.add(textfield4);


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
            confirmResult();
        }
	}
	
    private void procceed2 (MouseEvent evt)
	{
	    if (evt.getSource() == button2){
            new mainPage(userId,type);
        }
	}	
	
	public String getSkills(){
        String skill = textfield4.getText();
        return skill ==null || skill.isEmpty() ? "": skill;
    }
    
    public String getJobType(){
        String type = textfield3.getText();
        return type ==null || type.isEmpty() ? "": type;
    }
    
    public String getSalary(){
        String salary = textfield1.getText();
        return salary ==null || salary.isEmpty() ? "": salary;
    }
    
    public void confirmResult(){
        String useId = this.userId;
        String skills = getSkills();
        String typeOfJob = getJobType();
        String salary = getSalary();
        Seekercontroller.modifySeeker(userId,skills,typeOfJob,salary);
    }    

	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new manageSeekerInfo("","");
			}
		});
	}

}