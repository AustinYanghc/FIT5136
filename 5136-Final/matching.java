/**
*Text genereted by Simple GUI Extension for BlueJ
*/
import java.util.ArrayList;
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


public class matching extends JFrame {
    private String userId;
    private String type;
	private JMenuBar menuBar;
	private JButton button1;
	private JButton button2;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	private JTextField textfield1;
	private JTextField textfield2;
	private JTextField textfield3;
	
	private SeekerController Seekercontroller;
	private RecruiterController Recruitercontroller;

	//Constructor 
	public matching(String userId,String type){
	    Seekercontroller = new SeekerController();
	    Recruitercontroller = new RecruiterController();
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
		button1.setBounds(70,323,180,35);
		button1.setBackground(new Color(214,217,223));
		button1.setForeground(new Color(0,0,0));
		button1.setEnabled(true);
		button1.setFont(new Font("sansserif",0,12));
		button1.setText("Show the Matching Info");
		button1.setVisible(true);
		button1.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed1(evt);
            }
        }); 

		button2 = new JButton();
		button2.setBounds(270,323,150,35);
		button2.setBackground(new Color(214,217,223));
		button2.setForeground(new Color(0,0,0));
		button2.setEnabled(true);
		button2.setFont(new Font("sansserif",0,12));
		button2.setText("Send Notication");
		button2.setVisible(true);
		button2.addMouseListener(new MouseAdapter() 
        {
            public void mouseClicked(MouseEvent evt) 
            {
                procceed2(evt);
            }
        }); 

		label1 = new JLabel();
		label1.setBounds(142,36,200,35);
		label1.setBackground(new Color(214,217,223));
		label1.setForeground(new Color(0,0,0));
		label1.setEnabled(true);
		label1.setFont(new Font("SansSerif",0,23));
		label1.setText("Matching System");
		label1.setVisible(true);

		label2 = new JLabel();
		label2.setBounds(142,100,200,35);
		label2.setBackground(new Color(214,217,223));
		label2.setForeground(new Color(0,0,0));
		label2.setEnabled(true);
		label2.setFont(new Font("sansserif",0,12));
		label2.setText("Please type in the Seeker ID here");
		label2.setVisible(true);
		
		label3 = new JLabel();
		label3.setBounds(142,170,200,35);
		label3.setBackground(new Color(214,217,223));
		label3.setForeground(new Color(0,0,0));
		label3.setEnabled(true);
		label3.setFont(new Font("sansserif",0,12));
		label3.setText("Please type in the Recruiter ID here");
		label3.setVisible(true);
		
		label4 = new JLabel();
		label4.setBounds(142,240,200,35);
		label4.setBackground(new Color(214,217,223));
		label4.setForeground(new Color(0,0,0));
		label4.setEnabled(true);
		label4.setFont(new Font("sansserif",0,12));
		label4.setText("Please type in the message here");
		label4.setVisible(true);

		textfield1 = new JTextField();
		textfield1.setBounds(140,130,200,38);
		textfield1.setBackground(new Color(255,255,255));
		textfield1.setForeground(new Color(0,0,0));
		textfield1.setEnabled(true);
		textfield1.setFont(new Font("sansserif",0,12));
		textfield1.setText("");
		textfield1.setVisible(true);
		
		textfield2 = new JTextField();
		textfield2.setBounds(140,200,200,38);
		textfield2.setBackground(new Color(255,255,255));
		textfield2.setForeground(new Color(0,0,0));
		textfield2.setEnabled(true);
		textfield2.setFont(new Font("sansserif",0,12));
		textfield2.setText("");
		textfield2.setVisible(true);
		
		textfield3 = new JTextField();
		textfield3.setBounds(140,270,200,38);
		textfield3.setBackground(new Color(255,255,255));
		textfield3.setForeground(new Color(0,0,0));
		textfield3.setEnabled(true);
		textfield3.setFont(new Font("sansserif",0,12));
		textfield3.setText("");
		textfield3.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(button1);
		contentPane.add(button2);
		contentPane.add(label1);
		contentPane.add(label2);
		contentPane.add(label3);
		contentPane.add(label4);
		contentPane.add(textfield1);
		contentPane.add(textfield2);
		contentPane.add(textfield3);

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
            showResult();
        }
    }
    
    private void procceed2 (MouseEvent evt)
    {
        if (evt.getSource() == button2){
            sendNotification();
        }
    }
	
	public String getSeekerId(){
        String seekerId = textfield1.getText();
        return seekerId ==null || seekerId.isEmpty() ? "": seekerId;
    }
    
    public String getRecruiterId(){
        String seekerId = textfield2.getText();
        return seekerId ==null || seekerId.isEmpty() ? "": seekerId;
    }
    
    public String getInfo(){
        String seekerId = textfield3.getText();
        return seekerId ==null || seekerId.isEmpty() ? "": seekerId;
    }
		
    public void showResult(){
        ArrayList<String> line = Recruitercontroller.matchSeeker(userId);
        for(String x : line)
        {
            System.out.println(x);
        }
    }
    
    public void sendNotification(){ 
        String seekerId = getSeekerId();
        String recruiterId = getRecruiterId();
        String getInfo = getInfo();
        Recruitercontroller.setNotification(recruiterId,seekerId,getInfo);
    }

	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new matching("","");
			}
		});
	}

}