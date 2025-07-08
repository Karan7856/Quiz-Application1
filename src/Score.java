import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Score extends JFrame implements ActionListener {


    Score(String name,double score){

        setBounds(350, 150, 750, 550);
        getContentPane().setBackground(Color.WHITE); // sets color of the frame
        setLayout(null); // tell java that I don't want to use the built-in swing layout of placing components over a frame, I want to create my own layout

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/score.png")); // Image is loaded using this syntax
        Image i2=i1.getImage().getScaledInstance(300,250,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 200, 300, 250);
        add(image); // we cannot directly pass i1 in add() so first we have to create a JLabel class object and pass that object in add()


        //ADDING QUESTIONno LABEL
        JLabel heading=new JLabel("Thankyou "+name+" for playing on QuizBee");
        heading.setBounds(45,30,700,30);
        heading.setFont(new Font("Tahoma",Font.BOLD,26));
        add(heading);

        //DISPLAYING SCORE

        JLabel lblscore=new JLabel("Your Score is "+score);
        lblscore.setBounds(350,200,300,30);
        lblscore.setFont(new Font("Tahoma",Font.BOLD,26));
        add(lblscore);


        //ADDING Play Again BUTTON

        JButton submit=new JButton("Play Again");
        submit.setBounds(380,270,120,30);
        //submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    }
    public static void main(String[] args) {
        new Score("User",0);
    }


}

