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


public class manageJobCategory extends JFrame {
    public String userId;
    public String type;
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
    private RecruiterController Recruitercontroller;
	
	
    //Constructor 
    public manageJobCategory(String userId,String type){
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
    label1.setBounds(120,25,300,35);
    label1.setBackground(new Color(214,217,223));
    label1.setForeground(new Color(0,0,0));
    label1.setEnabled(true);
    label1.setFont(new Font("SansSerif",0,23));
    label1.setText("Manage Job Category");
    label1.setVisible(true);   

	label6 = new JLabel();
	label6.setBounds(45,220,90,35);
	label6.setBackground(new Color(214,217,223));
	label6.setForeground(new Color(0,0,0));
	label6.setEnabled(true);
	label6.setFont(new Font("sansserif",0,12));
	label6.setText("Category");
	label6.setVisible(true);
	
	label11 = new JLabel();
	label11.setBounds(160,320,300,35);
	label11.setBackground(new Color(214,217,223));
	label11.setForeground(new Color(0,0,0));
	label11.setEnabled(true);
	label11.setFont(new Font("sansserif",0,12));
	label11.setText("");
	label11.setVisible(true);	
	
	textfield5 = new JTextField();
	textfield5.setBounds(130,225,300,30);
	textfield5.setBackground(new Color(255,255,255));
	textfield5.setForeground(new Color(0,0,0));
	textfield5.setEnabled(true);
	textfield5.setFont(new Font("sansserif",0,12));
	textfield5.setText(Recruitercontroller.getCategory(userId));
	textfield5.setVisible(true);




        //adding components to contentPane panel
        contentPane.add(button1);
        contentPane.add(button2);
	contentPane.add(label1);

	contentPane.add(label6);


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

    private void procceed1 (MouseEvent evt)
	{
	    if (evt.getSource() == button1){
            createResult();
        }
	}
	
    private void procceed2 (MouseEvent evt)
	{
	    if (evt.getSource() == button2){
            new mainPage(userId,type);
        }
	}
    
    public String getJobCategory(){
        String category = textfield5.getText();
        return category ==null || category.isEmpty() ? "": category;
    }
    
    public void createResult(){
        String useId = this.userId;
        String category = getJobCategory();
        Recruitercontroller.modifyCategory(userId, category);
    }    

     public static void main(String[] args){
        System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new manageJobCategory("","");
            }
        });
    }

}
   
