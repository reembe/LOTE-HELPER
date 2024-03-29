
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

public class MainMenu extends JFrame implements ActionListener{

private JMenu saveMenu;
private JMenu restartMenu;
private JMenuBar menuBar;
private JButton mcQuiz;
private JButton Listening;
private JButton trueorFalse;
private JButton mcQuiz2;
private JButton surprise;
private JButton mcQuiz3;
private JLabel title;
private static User user;
private JMenuItem restart;
private static Clip clip;
private JMenuItem save;


    public MainMenu(User s) throws UnsupportedAudioFileException, IOException, LineUnavailableException
    {
        user = s;

        File file = new File("candyland (2).wav");
		AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
		clip = AudioSystem.getClip();
		clip.open(audioStream);
		clip.start();


        menuBar = new JMenuBar();
        saveMenu = new JMenu("Save");
        restartMenu = new JMenu("Restart");
        restart = new JMenuItem("Confirm");
        save = new JMenuItem("Nuh uh");

        mcQuiz = new JButton();
        mcQuiz.setBounds(20,180,400,200);
		mcQuiz.setFont(new Font("WEST JAVA",Font.BOLD,35)); 

		mcQuiz.setFocusable(false);
		mcQuiz.addActionListener(this);
		mcQuiz.setText("Level 1: MC Quiz");

        mcQuiz2 = new JButton();
        mcQuiz2.setBounds(520,180,400,200);
		mcQuiz2.setFont(new Font("WEST JAVA",Font.BOLD,35));
		mcQuiz2.setFocusable(false);
		mcQuiz2.addActionListener(this);
		mcQuiz2.setText("Level 2: MC Quiz");

        mcQuiz3 = new JButton();
        mcQuiz3.setBounds(1060,180,400,200);
		mcQuiz3.setFont(new Font("WEST JAVA",Font.BOLD,35));
		mcQuiz3.setFocusable(false);
		mcQuiz3.addActionListener(this);
		mcQuiz3.setText("Level 3: MC Quiz");
        
        Listening = new JButton();
        Listening.setBounds(20,450,400,200);
		Listening.setFont(new Font("WEST JAVA",Font.BOLD,35));
		Listening.setFocusable(false);
		Listening.addActionListener(this);
		Listening.setText("Listening Practice!");

        trueorFalse = new JButton();
        trueorFalse.setBounds(520,450,400,200);
		trueorFalse.setFont(new Font("WEST JAVA",Font.BOLD,35));
		trueorFalse.setFocusable(false);
		trueorFalse.addActionListener(this);
		trueorFalse.setText("True or False?");

        surprise = new JButton();
        surprise.setBounds(1060,450,400,200);
		surprise.setFont(new Font("WEST JAVA",Font.BOLD,35));
		surprise.setFocusable(false);
		surprise.addActionListener(this);
		surprise.setText("SURPRISE!");

        title = new JLabel();
        title.setText("Please select which mode you want to practice with:");
        title.setBounds(0,57,10000000,100);
        title.setForeground(Color.black);
     
        save.setMnemonic(KeyEvent.VK_S);
        

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1920,1080);
        this.getContentPane().setBackground(new Color(255,238,255));
        this.setLayout(null);
        this.setResizable(true);
        this.setTitle("LOTE Helper");


        this.setVisible(true);

        this.add(mcQuiz);
        this.add(trueorFalse);
        this.add(mcQuiz2);
        this.add(mcQuiz3);
        this.add(Listening);

        this.add(surprise);

        restart.setMnemonic(KeyEvent.VK_R);

        menuBar.add(saveMenu);
        menuBar.add(restartMenu);
        restartMenu.add(restart);
        saveMenu.add(save);
        this.setJMenuBar(menuBar);

        restart.addActionListener(this);
        save.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       
        if (e.getSource() == mcQuiz)
        {
            clip.stop();
            Games Games = new Games("mcQuiz", user);
                Games.mcQuiz();
                this.setVisible(false);
          
        }
        if (e.getSource() == mcQuiz2)
        {
            clip.stop();
            Games2 Games2 = new Games2("mcQuiz", user);
                Games2.mcQuiz();
                this.setVisible(false);
          
        }
        if (e.getSource() == mcQuiz3)
        {
            clip.stop();
            Games3n Games = new Games3n("mcQuiz", user);
                Games.mcQuiz();
                this.setVisible(false);
          
        }
        if (e.getSource() == trueorFalse)
        {
            if (user.getLanguage().equals("french"))
            {
                clip.stop();
            TrueOrFalseF TrueOrFalseF = new TrueOrFalseF();
            TrueOrFalseF.Quiz(user);
            this.setVisible(false);
            } 
            else{
                clip.stop();
            TrueOrFalseS TrueOrFalseS = new TrueOrFalseS();
            TrueOrFalseS.Quiz(user);
            this.setVisible(false);
            }
        }

        if (e.getSource() == Listening)
        {
            if (user.getLanguage().equals("french"))
            {
            Listening Listening = new Listening();
            try {
                clip.stop();
                Listening.Quiz(user);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            this.setVisible(false);
            } 
            else{
                Listenings Listenings = new Listenings(user);
                try {
                    clip.stop();
                    Listenings.Quiz();
                } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                this.setVisible(false);
            }
        }
        if (e.getSource() == restart)
        {
            try {
                introductionMenu introductionMenu = new introductionMenu();
                clip.stop();
                this.setVisible(false);
            } catch (FontFormatException | IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        if (e.getSource() == surprise)
        {
            try {
                clip.stop();
                Surprise surprise = new Surprise(user);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            } 
        }

      

    }
}


