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


public class homepage extends JFrame {

	private JMenuBar menuBar;
	private JButton button2;
	private JButton button3;
	private JLabel label1;
	
    private  JTable conferenceTable;
    private  JPanel panel;
    private  JPanel welcome;

	//private ConferenceController cc;
    private  JPanel page;
    private  JPanel buttons;
    private  CardLayout cl;

	//Constructor 
	public homepage(){

		this.setTitle("GUI_project");
		this.setSize(500,300);
		//menu generate method
		generateMenu();
		this.setJMenuBar(menuBar);

		//pane with null layout
		JPanel contentPane = new JPanel(null);
		contentPane.setPreferredSize(new Dimension(500,300));
		contentPane.setBackground(new Color(255,255,255));

		button2 = new JButton();
		button2.setBounds(105,235,90,35);
		button2.setBackground(new Color(204,204,204));
		button2.setForeground(new Color(0,0,0));
		button2.setEnabled(true);
		button2.setFont(new Font("sansserif",0,12));
		button2.setText("Sign in");
		button2.setVisible(true);
	    button2.addMouseListener(new MouseAdapter() 
		{
		    public void mouseClicked(MouseEvent evt) 
		    {
		        procceed2(evt);
		    }
		});
		
		button3 = new JButton();
		button3.setBounds(308,235,90,35);
		button3.setBackground(new Color(204,204,204));
		button3.setForeground(new Color(0,0,0));
		button3.setEnabled(true);
		button3.setFont(new Font("sansserif",0,12));
		button3.setText("Register");
		button3.setVisible(true);
	    button3.addMouseListener(new MouseAdapter() 
		{
		    public void mouseClicked(MouseEvent evt) 
		    {
		        procceed1(evt);
		    }
		});

		label1 = new JLabel();
		label1.setBounds(108,49,300,35);
		label1.setBackground(new Color(214,217,223));
		label1.setForeground(new Color(0,0,0));
		label1.setEnabled(true);
		label1.setFont(new Font("SansSerif",0,23));
		label1.setText("Online Job Seeking System");
		label1.setVisible(true);

		//adding components to contentPane panel
		contentPane.add(button2);
		contentPane.add(button3);
		contentPane.add(label1);

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
	    if (evt.getSource() == button3){
            new register();
        } /*else if (evt.getSource() == exitButton) {
            System.exit(0);
        } */
	}
	
    private void procceed2 (MouseEvent evt)
	{
	    if (evt.getSource() == button2){
            new login();
        }
	}	

	 public static void main(String[] args){
		System.setProperty("swing.defaultlaf", "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new homepage();
			}
		});
	}

}