import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

@SuppressWarnings("serial")
public class Guesser extends JFrame {

    private JPanel contentPane;
    private JTextField input1;
    Random rand = new Random();
    int ran;
    URL s;
    Sound su = new Sound();
    private JTextField Random_number;
    private JTextField input2;
    private JTextField input3;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
	    public void run() {
		try {
		    Guesser frame = new Guesser();
		    frame.setVisible(true);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	});
    }

    /**
     * Create the frame.
     */
    public Guesser() {
	s = getClass().getResource("ia.wav");
	su.Setmusic(s);
	su.play();

	setUndecorated(true);
	setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	setBounds(100, 100, 720, 480);
	contentPane = new JPanel();
	contentPane.setBackground(new Color(147, 225, 204));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	this.setLocationRelativeTo(null);

	setContentPane(contentPane);
	contentPane.setLayout(null);

	JLabel lblPerson = new JLabel("Person 3");
	lblPerson.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	lblPerson.setForeground(Color.WHITE);
	lblPerson.setBounds(556, 171, 50, 17);
	contentPane.add(lblPerson);

	JLabel lblPerson_1 = new JLabel("Person 2");
	lblPerson_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	lblPerson_1.setForeground(Color.WHITE);
	lblPerson_1.setBounds(329, 171, 50, 17);
	contentPane.add(lblPerson_1);

	JLabel lblNewLabel = new JLabel("Person 1");
	lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 14));
	lblNewLabel.setForeground(new Color(255, 255, 255));
	lblNewLabel.setBounds(91, 171, 50, 17);
	contentPane.add(lblNewLabel);

	input3 = new JTextField();
	input3.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	input3.setOpaque(false);
	input3.setForeground(new Color(206, 247, 255));
	input3.setFont(new Font("Times New Roman", Font.BOLD, 16));
	input3.setHorizontalAlignment(SwingConstants.CENTER);
	input3.setColumns(10);
	input3.setBounds(499, 199, 150, 50);
	contentPane.add(input3);

	input2 = new JTextField();
	input2.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	input2.setOpaque(false);
	input2.setForeground(new Color(206, 247, 255));
	input2.setFont(new Font("Times New Roman", Font.BOLD, 16));
	input2.setHorizontalAlignment(SwingConstants.CENTER);
	input2.setColumns(10);
	input2.setBounds(275, 199, 150, 50);
	contentPane.add(input2);

	JLabel head = new JLabel("Guesser Game");
	head.setForeground(new Color(255, 255, 255));
	head.setFont(new Font("Orbitron", Font.BOLD, 18));
	head.setBounds(289, 11, 149, 19);
	contentPane.add(head);

	JLabel subhead = new JLabel("GUESS A NUMBER B/W (0 TO 500)");
	subhead.setForeground(new Color(255, 255, 255));
	subhead.setFont(new Font("Times New Roman", Font.BOLD, 16));
	subhead.setBounds(249, 100, 252, 20);
	contentPane.add(subhead);

	input1 = new JTextField();
	input1.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if(!Character.isDigit(c)) {
		    e.consume();
		}
	    }
	});
	input1.setForeground(new Color(206, 247, 255));
	input1.setFont(new Font("Times New Roman", Font.BOLD, 16));
	input1.setBounds(40, 199, 150, 50);
	input1.setHorizontalAlignment(SwingConstants.CENTER);
	contentPane.add(input1);
	input1.setColumns(10);
	input1.setOpaque(false);

	JButton guesser = new JButton("");
	guesser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	guesser.setOpaque(false);
	guesser.setContentAreaFilled(false);
	guesser.setBorderPainted(false);
	Image img1 = new ImageIcon(this.getClass().getResource("/guess.png")).getImage();
	guesser.setIcon(new ImageIcon(img1));
	guesser.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		ran = rand.nextInt(500); 
		int guess1 = Integer.valueOf(input1.getText());
		int guess2 = Integer.valueOf(input2.getText());
		int guess3 = Integer.valueOf(input3.getText());

		Random_number.setText(Integer.toString(ran));
		if(ran == guess1) {
		    JOptionPane.showMessageDialog(guesser, "Person 1 Guess Correctly");
		}
		if(ran == guess2) {
		    JOptionPane.showMessageDialog(guesser, "Person 2 Guess Correctly");
		}
		if(ran == guess3) {
		    JOptionPane.showMessageDialog(guesser, "Person 3 Guess Correctly");
		}
		else {
		    su.stop();
		    s = getClass().getResource("incorrect.wav");
		    su.Setmusic(s);
		    su.play();
		    JOptionPane.showMessageDialog(guesser, "Everyone's Guesses are Incorrect : Play again");
		}
	    }
	});
	guesser.setFont(new Font("Times New Roman", Font.BOLD, 18));
	guesser.setBounds(499, 279, 181, 77);
	contentPane.add(guesser);

	JButton exit = new JButton("");
	exit.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	exit.setOpaque(false);
	exit.setContentAreaFilled(false);
	exit.setBorderPainted(false);
	Image img = new ImageIcon(this.getClass().getResource("/exit.png")).getImage();
	exit.setIcon(new ImageIcon(img));

	exit.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(ABORT);
	    }
	});
	exit.setBounds(329, 410, 83, 59);
	contentPane.add(exit);

	Random_number = new JTextField();
	Random_number.setForeground(new Color(206, 247, 255));
	Random_number.setFont(new Font("Times New Roman", Font.BOLD, 16));
	Random_number.setHorizontalAlignment(SwingConstants.CENTER);
	Random_number.setBounds(340, 294, 150, 50);
	contentPane.add(Random_number);
	Random_number.setColumns(10);
	Random_number.setOpaque(false);


	JLabel lblTheRandomNumber = new JLabel("THE RANDOM NUMBER GENERATED");
	lblTheRandomNumber.setForeground(new Color(255, 255, 255));
	lblTheRandomNumber.setFont(new Font("Times New Roman", Font.BOLD, 16));
	lblTheRandomNumber.setBounds(40, 309, 290, 20);
	contentPane.add(lblTheRandomNumber);

	JLabel by = new JLabel("by Manoj");
	by.setForeground(new Color(147, 225, 204));
	by.setFont(new Font("Ink Free", Font.PLAIN, 14));
	by.setBounds(660, 451, 50, 18);
	contentPane.add(by);

	JLabel bg = new JLabel("");
	bg.setBounds(0, 0, 720, 480);
	contentPane.add(bg);
	Image img7 = new ImageIcon(this.getClass().getResource("/bg.jpg")).getImage();
	bg.setIcon(new ImageIcon(img7));
    }
}
