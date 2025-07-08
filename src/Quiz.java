import javax.swing.*;
import java.awt.*;
import java.awt.event.*; //it has ActionListener interface for event
import java.util.*;

public class Quiz extends JFrame implements ActionListener {
    String questions[][]=new String[30][5];
    String answers[][]=new String[30][2];
    String useranswers[][]=new String[30][1];
    JLabel qno,question;
    JRadioButton opt1,opt2,opt3,opt4;
    public static int timer=60;
    public static int ans_given=0;
    public static int count=0;
    public static double score=0;
    JButton next,lifeline,submit;
    ButtonGroup groupoptions;
    String name;
    Quiz(String name){
        this.name=name;
        setBounds(20, 0, 1400, 900);
        getContentPane().setBackground(Color.WHITE); // sets color of the frame
        setLayout(null); // tell java that I don't want to use the built-in swing layout of placing components over a frame, I want to create my own layout

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/quiz.jpg")); // Image is loaded using this syntax
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1400, 397);
        add(image); // we cannot directly pass i1 in add() so first we have to create a JLabel class object and pass that object in add()


        //ADDING QUESTIONno LABEL
        qno=new JLabel();
        qno.setBounds(100,455,50,30);
        qno.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(qno);


        //ADDING QUESTION LABEL
        question=new JLabel();
        question.setBounds(150,455,900,30);
        question.setFont(new Font("Tahoma",Font.PLAIN,24));
        add(question);

        //ADDING QUESTIONS AND THERE OPTIONS TO THE LIBRARY
        questions[0][0] = "Which of the following is not a Java feature?";

        questions[0][1] = "Object-oriented";
        questions[0][2] = "Use of pointers";;
        questions[0][3] = "Portable";
        questions[0][4] = "Dynamic and Extensible";

        questions[1][0] = "Which of these cannot be used for a variable name in Java?";
        questions[1][1] = "identifier";
        questions[1][2] = "keyword";
        questions[1][3] = "variable";
        questions[1][4] = "None of the above";

        questions[2][0] = "Which method is the entry point of a Java program?";
        questions[2][1] = "start()";
        questions[2][2] = "main()";
        questions[2][3] = "run()";
        questions[2][4] = "init()";


        questions[3][0] = "Which component is used to compile, debug and execute Java programs?";
        questions[3][1] = "JRE";
        questions[3][2] = "JIT";
        questions[3][3] = "JDK";
        questions[3][4] = "JVM";

        questions[4][0] = "In which memory a String is stored, when we create a string using new operator?";
        questions[4][1] = "Stack";
        questions[4][2] = "String memory";
        questions[4][3] = "Random storage space";
        questions[4][4] = "Heap memory";

        questions[5][0] = "Which of the following is a marker interface?";
        questions[5][1] = "Runnable interface";
        questions[5][2] = "Remote interface";
        questions[5][3] = "Readable interface";
        questions[5][4] = "Result interface";

        questions[6][0] = "Which keyword is used for accessing the features of a package?";
        questions[6][1] = "import";
        questions[6][2] = "package";
        questions[6][3] = "extends";
        questions[6][4] = "export";

        questions[7][0] = "In java, jar stands for?";
        questions[7][1] = "Java Archive Runner";
        questions[7][2] = "Java Archive";
        questions[7][3] = "Java Application Resource";
        questions[7][4] = "Java Application Runner";

        questions[8][0] = "Which of the following is a mutable class in java?";
        questions[8][1] = "java.lang.StringBuilder";
        questions[8][2] = "java.lang.Short";
        questions[8][3] = "java.lang.Byte";
        questions[8][4] = "java.lang.String";

        questions[9][0] = "Which of the following option leads to the portability and security of Java?";
        questions[9][1] = "Bytecode is executed by JVM";
        questions[9][2] = "The applet makes the Java code secure and portable";
        questions[9][3] = "Use of exception handling";
        questions[9][4] = "Dynamic binding between objects";


        questions[10][0] = "What does the 'final' keyword mean in Java?";
        questions[10][1] = "The value cannot be changed";
        questions[10][2] = "Method cannot be inherited";
        questions[10][3] = "Class cannot be extended";
        questions[10][4] = "All of the above";

        questions[11][0] = "Which is used to find and fix bugs in the Java programs.?";
        questions[11][1] = "JVM";
        questions[11][2] = "JDB";
        questions[11][3] = "JDK";
        questions[11][4] = "JRE";

        questions[12][0] = "What is the return type of the hashCode() method in the Object class?";
        questions[12][1] = "int";
        questions[12][2] = "Object";
        questions[12][3] = "long";
        questions[12][4] = "void";

        questions[13][0] = "Which package contains the Random class?";
        questions[13][1] = "java.util package";
        questions[13][2] = "java.lang package";
        questions[13][3] = "java.awt package";
        questions[13][4] = "java.io package";


        questions[14][0] = "An interface with no fields or methods is known as?";
        questions[14][1] = "Runnable Interface";
        questions[14][2] = "Abstract Interface";
        questions[14][3] = "Marker Interface";
        questions[14][4] = "CharSequence Interface";

        questions[15][0] = "Which of the following is not a type of constructor in Java?";
        questions[15][1] = "Default constructor";
        questions[15][2] = "Parameterized constructor";
        questions[15][3] = "Copy constructor";
        questions[15][4] = "Static constructor";

        questions[16][0] = "Which of these is a super class of all classes in Java?";
        questions[16][1] = "Object class";
        questions[16][2] = "ArrayList class";
        questions[16][3] = "Abstract class";
        questions[16][4] = "String class";

        questions[17][0] = "Which of the following is used to create an object in Java?";
        questions[17][1] = "new keyword";
        questions[17][2] = "alloc keyword";
        questions[17][3] = "newObject keyword";
        questions[17][4] = "create keyword";

        questions[18][0] = "Which operator is used to compare two values?";
        questions[18][1] = "==";
        questions[18][2] = "=";
        questions[18][3] = "!=";
        questions[18][4] = "<>";

        questions[19][0] = "Which exception is thrown when a class is not found?";
        questions[19][1] = "ClassNotFoundException";
        questions[19][2] = "IOException";
        questions[19][3] = "InterruptedException";
        questions[19][4] = "FileNotFoundException";

        questions[20][0] = "Which loop is guaranteed to execute at least once?";
        questions[20][1] = "for loop";
        questions[20][2] = "while loop";
        questions[20][3] = "do-while loop";
        questions[20][4] = "none of the above";

        questions[21][0] = "Which class is used for console input in Java?";
        questions[21][1] = "Scanner";
        questions[21][2] = "System.in";
        questions[21][3] = "InputStream";
        questions[21][4] = "BufferedInput";

        questions[22][0] = "Which keyword is used to inherit a class in Java?";
        questions[22][1] = "extends";
        questions[22][2] = "implements";
        questions[22][3] = "inherits";
        questions[22][4] = "super";

        questions[23][0] = "Which keyword is used to define an interface in Java?";
        questions[23][1] = "interface";
        questions[23][2] = "implements";
        questions[23][3] = "abstract";
        questions[23][4] = "class";

        questions[24][0] = "What is the default value of a boolean variable?";
        questions[24][1] = "true";
        questions[24][2] = "false";
        questions[24][3] = "0";
        questions[24][4] = "null";

        questions[25][0] = "Which of these is not a primitive data type?";
        questions[25][1] = "int";
        questions[25][2] = "Float";
        questions[25][3] = "boolean";
        questions[25][4] = "char";

        questions[26][0] = "What is the size of an int variable in Java?";
        questions[26][1] = "16-bit";
        questions[26][2] = "32-bit";
        questions[26][3] = "64-bit";
        questions[26][4] = "Depends on system";

        questions[27][0] = "Which access modifier makes a member visible to all classes?";
        questions[27][1] = "private";
        questions[27][2] = "protected";
        questions[27][3] = "default";
        questions[27][4] = "public";

        questions[28][0] = "Which exception is thrown when an array is accessed with an illegal index?";
        questions[28][1] = "ArrayIndexOutOfBoundsException";
        questions[28][2] = "IndexOutOfBoundsException";
        questions[28][3] = "IllegalArgumentException";
        questions[28][4] = "NullPointerException";

        questions[29][0] = "Which of the following is true about 'static' keyword?";
        questions[29][1] = "It belongs to the class, rather than instances";
        questions[29][2] = "It can be used to create class-level variables and methods";
        questions[29][3] = "It can be accessed without creating an object";
        questions[29][4] = "All of the above";

        //SETTING THE ANSWER ARRAY TO STORE THE ANSWERS
        answers[0][1] = "Use of pointers";
        answers[1][1] = "keyword";
        answers[2][1] = "main()";
        answers[3][1] = "JDK";
        answers[4][1] = "Heap memory";
        answers[5][1] = "Remote interface";
        answers[6][1] = "import";
        answers[7][1] = "Java Archive";
        answers[8][1] = "java.lang.StringBuilder";
        answers[9][1] = "Bytecode is executed by JVM";
        answers[10][1] = "All of the above";
        answers[11][1] = "JDB";
        answers[12][1] = "int";

        answers[13][1] = "java.util package";

        answers[14][1] = "Marker Interface";
        answers[15][1] = "Static constructor";
        answers[16][1] = "Object class";
        answers[17][1] = "new keyword";
        answers[18][1] = "==";
        answers[19][1] = "ClassNotFoundException";
        answers[20][1] = "do-while loop";
        answers[21][1] = "Scanner";
        answers[22][1] = "extends";
        answers[23][1] = "interface";
        answers[24][1] = "false";
        answers[25][1] = "Float";
        answers[26][1] = "32-bit";
        answers[27][1] = "public";
        answers[28][1] = "ArrayIndexOutOfBoundsException";
        answers[29][1] = "All of the above";

        //SETTING THE RADIO BUTTON
        //OPTION1
        opt1=new JRadioButton();
        opt1.setBounds(170,520,700,30);
        opt1.setFont(new Font("Dialog",Font.PLAIN,20));
        opt1.setBackground(Color.WHITE);
        add(opt1);
        setVisible(true); // making the frame visible (should be done after adding components)

        //OPTION2
        opt2=new JRadioButton();
        opt2.setBounds(170,560,700,30);
        opt2.setFont(new Font("Dialog",Font.PLAIN,20));
        opt2.setBackground(Color.WHITE);
        add(opt2);
        setVisible(true);

        //OPTION3
        opt3=new JRadioButton();
        opt3.setBounds(170,600,700,30);
        opt3.setFont(new Font("Dialog",Font.PLAIN,20));
        opt3.setBackground(Color.WHITE);
        add(opt3);
        setVisible(true);

        //OPTION4
        opt4=new JRadioButton();
        opt4.setBounds(170,640,700,30);
        opt4.setFont(new Font("Dialog",Font.PLAIN,20));
        opt4.setBackground(Color.WHITE);
        add(opt4);


        //USING BUTTONGROUP CLASS TO GROUP THE RADIO BUTTONS SO THAT WE CAN SELECT ONLY ONE OPTION

        groupoptions=new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        //MAKING NEXT BUTTON TO MOVE TO NEXT QUESTION
        next=new JButton("Next");
        next.setBounds(1100,550,200,40);
        next.setFont(new Font("Tahoma",Font.PLAIN,22));
        next.setBackground(new Color(30,144,255));
        next.setForeground(Color.white);
        next.addActionListener(this); //adding an event ActionListener
        add(next);

        //MAKING LIFELINE BUTTON TO TAKE LIFELINE
        lifeline=new JButton("50-50 LifeLine");
        lifeline.setBounds(1100,630,200,40);
        lifeline.setFont(new Font("Tahoma",Font.PLAIN,22));
        lifeline.setBackground(new Color(30,144,255));
        lifeline.setForeground(Color.white);
        lifeline.addActionListener(this);
        add(lifeline);

        //MAKING SUBMIT BUTTON
        submit=new JButton("Submit");
        submit.setBounds(1100,710,200,40);
        submit.setFont(new Font("Tahoma",Font.PLAIN,22));
        submit.setBackground(new Color(30,144,255));
        submit.setForeground(Color.WHITE);
        submit.setEnabled(false); //by default it is true which means it is enable we have to disable it
        submit.addActionListener(this);
        add(submit);


        start(count);
        setVisible(true);

    }

    //ADDING EVENT TO NEXT BUTTON SO THAT WHEN WE CLICK ON NEXT BUTTON WE MOVE TO OTHER QUESTION
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==next){//if next button has been pressed then which action to perform
            repaint();
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            ans_given=1;
            if(groupoptions.getSelection()==null){
                useranswers[count][0]="";
            }
            else{
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();  //WHATEVER USER HAS ANSWERED WILL BE STORED IN useranswers array
            }

            if(count==28){
                next.setEnabled(false); //disble next button when question no 29
                submit.setEnabled(true);//enable submit button
            }
            count++;
            start(count);
        }
        else if(ae.getSource()==lifeline){
            lifeline.setEnabled(false);

            String correct=answers[count][1];

            JRadioButton[] options={opt1,opt2,opt3,opt4};

            ArrayList<JRadioButton> incorrectOptions=new ArrayList<>();

            for(JRadioButton opt:options){
                if(!opt.getActionCommand().equals(correct)){
                    incorrectOptions.add(opt);
                }
            }

            Collections.shuffle(incorrectOptions);
            incorrectOptions.get(0).setEnabled(false);
            incorrectOptions.get(1).setEnabled(false);
        }
        else{
            ans_given=1;
            if(groupoptions.getSelection()==null){
                useranswers[count][0]="";
            }
            else{
                useranswers[count][0]=groupoptions.getSelection().getActionCommand();  //WHATEVER USER HAS ANSWERED WILL BE STORED IN useranswers array
            }

            for (int i = 0; i < answers.length; i++) {
                String userAnswer = useranswers[i][0];
                String correctAnswer = answers[i][1];

                if (userAnswer == null || userAnswer.trim().isEmpty()) {
                    // No answer selected: 0 marks
                    continue;
                } else if (userAnswer.equals(correctAnswer)) {
                    score += 1.0; // Correct answer
                } else {
                    score -= 0.25; // Wrong answer
                }
            }

            setVisible(false);
            new Score(name,score);
        }
    }
    //MAKING OF TIMER--> FOR TIMER WE CAN USE PAINT CLASS AND WE HAVE TO REPAINT THE FRAME AGAIN AND AGAIN AS THE VALUE OF TIMER CHANGES EVERY SECOND

    @Override
    public void paint(Graphics g){
        super.paint(g);

        String time="Time left  - "+timer+ "s";
        g.setColor(Color.red);
        g.setFont(new Font("Tahome",Font.BOLD,25));

        if(timer>0){
            g.drawString(time,1100,500);
        }
        else{
            g.drawString("Times Up!!",1100,500);
        }
        timer--;

        try{
            Thread.sleep(1000);
            repaint();
        }
        catch (Exception e){
            e.printStackTrace();
        }


        //HANDLING CONDITIONS WHEN THE USER HAVE NOT ANSWERED ANY QUESTION AND THE TIME IS OVER THEN WE HAVE TO REDIRECT TO NEXT QUESTION
        if(ans_given==1){
            timer=60;
            ans_given=0;


        }
        else if (timer<0) {
            timer=60;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            if(count==28){
                next.setEnabled(false); //disble next button when question no 29
                submit.setEnabled(true);//enable submit button
            }
            //if question no is 28 and time is automaticall gets over then disable next button enable submit button
            if(count==28){
                next.setEnabled(false); //disble next button when question no 29
                submit.setEnabled(true);//enable submit button
            }

            if(count==29){ //submit button
                if(groupoptions.getSelection()==null){
                    useranswers[count][0]="";
                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();  //WHATEVER USER HAS ANSWERED WILL BE STORED IN useranswers array
                }

                for (int i = 0; i < answers.length; i++) {
                    String userAnswer = useranswers[i][0];
                    String correctAnswer = answers[i][1];

                    if (userAnswer == null || userAnswer.trim().isEmpty()) {
                        // No answer selected: 0 marks
                        continue;
                    } else if (userAnswer.equals(correctAnswer)) {
                        score += 1.0; // Correct answer
                    } else {
                        score -= 0.25; // Wrong answer
                    }
                }

                setVisible(false);
                new Score(name,score);
            }
            else{
                if(groupoptions.getSelection()==null){
                    useranswers[count][0]="";
                }
                else{
                    useranswers[count][0]=groupoptions.getSelection().getActionCommand();  //WHATEVER USER HAS ANSWERED WILL BE STORED IN useranswers array
                }
                count++;
                start(count); //to load the next question if times up
            }


        }
    }





    public void start(int count){
        qno.setText(""+(count+1)+". ");
        question.setText(questions[count][0]);
        opt1.setText(questions[count][1]);
        opt1.setActionCommand(questions[count][1]);
        opt2.setText(questions[count][2]);
        opt2.setActionCommand(questions[count][2]);
        opt3.setText(questions[count][3]);
        opt3.setActionCommand(questions[count][3]);
        opt4.setText(questions[count][4]);
        opt4.setActionCommand(questions[count][4]);

        groupoptions.clearSelection(); //clears the selection of 1st question option so that when we move to new question that option is not already selected

    }

    public static void main(String[] args) {

        new Quiz("User"); // making the object of the class to run the constructor

    }
}
