/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swing_test;

import com.pojos.Options;
import com.pojos.Question;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import org.hibernate.Query;
import org.hibernate.Session;

public class MainTest {

    private String background = "background-407193_1920.jpg";
    private JPanel p;
    private MyFrame myframe;
    private int counter = 300;
    private Thread timmer;
    private JLabel heading;
    private JPanel questionsContainer;
    private List<Question> questios;
    private int current;
    private JButton next;
    private int score = 0;
    private Question q;
    private JRadioButton[] options = new JRadioButton[4];

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public MainTest(MyFrame myframe) {
        current = 0;
        p = new MyPanel(new BorderLayout(10, 10), "src/" + this.getBackground());
        this.myframe = myframe;
        heading = new JLabel(String.valueOf(counter));
        heading.setFont(myframe.getFont());
        timmer = new Thread() {
            public void run() {
                while (true) {
                    // System.out.print(counter);
                    if (counter == 0) {
                        break;
                    }
                    counter--;
                    heading.setText(String.valueOf(counter));
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            }
        };

        initQuestions();

    }

    public MainTest(JPanel p) {
        this.p = p;
    }

    public JPanel getP() {
        return p;
    }

    public void setP(JPanel p) {
        this.p = p;
    }

    public JPanel init() {
        heading.setHorizontalAlignment(SwingConstants.RIGHT);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        p.add(heading, BorderLayout.NORTH);
        timmer.start();

        questionsContainer = new JPanel(new BorderLayout(10, 10));
        // questionsContainer.setBackground(Color.BLACK);
        questionsContainer.setOpaque(false);
        q = questios.get(current);
        System.out.println(q.getAns().getAnswer());
        JLabel question = new JLabel(q.getQuestion());
        question.setForeground(Color.white);
        question.setFont(myframe.getFont());
        //  question.setForeground(Color.WHITE);
        question.setHorizontalAlignment(SwingConstants.CENTER);
        questionsContainer.add(question, BorderLayout.NORTH);

        ButtonGroup bg = new ButtonGroup();
        Set<Options> op = q.getOptions();
        for (int i = 0; i < 4; i++) {
            options[i] = new JRadioButton();
            options[i].setFont(myframe.getFont());

            bg.add(options[i]);

        }

        int i = 0;
        for (Options o : op) {
            options[i].setText(o.getO());
            i++;

        }

        JPanel optionsContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
        for (JRadioButton x : options) {
            optionsContainer.add(x);
        }
        optionsContainer.setOpaque(false);

        next = new JButton("next");
        initEvent();
        next.setFont(myframe.getFont());
        optionsContainer.add(next, BorderLayout.SOUTH);

        questionsContainer.add(optionsContainer, BorderLayout.CENTER);

        Label notice = new Label();
        notice.setFont(new Font("Times New Roman", Font.PLAIN, 20));
        notice.setAlignment(Label.CENTER);
        notice.setForeground(Color.red);
      
        Thread t = new Thread() {
            public void run() {
                String text = "If your answer is wrong for any question then there will a negative marking for quesiton.";
                while (true) {
                    try {
                        Thread.sleep(1000);
                      
                            
                    } catch (InterruptedException ex) {
                        Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    notice.setText(text);
                    
                    char a=text.charAt(0);
                    String temp=text.substring(1);
                    text=temp+a;
                    
                    
                    
                    
                }
            }

        };
        t.start();
        p.add(notice, BorderLayout.SOUTH);
        p.add(questionsContainer, BorderLayout.CENTER);

        return p;
    }

    private void initQuestions() {

        Session s = Helper.getFactory().openSession();

        Query q = s.createQuery("from Question");
        questios = q.list();

        s.close();
    }

    private void initEvent() {

        next.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String selected = "";
                    for (int i = 0; i < options.length; i++) {
                        if (options[i].isSelected()) {
                            selected = options[i].getText();
                        }

                    }
                    if (selected.equals(q.getAns().getAnswer())) {
                        //   JOptionPane.showMessageDialog(null, "correct");
                        score += 5;
                        //  JOptionPane.showMessageDialog(null, score);
                    }
                    else
                    {
                        score-=2;
                    }
                    current++;
                    if (current >= 10) {

                        Thread tt = new Thread() {
                            public void run() {

                                myframe.getI0().doClick();
                                try {
                                    Thread.sleep(000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                myframe.getButton().setIcon(null);
                                //JOptionPane.showMessageDialog(null, score);
                                myframe.getButton().setText("Your Score is = " + score);

                                try {
                                    Thread.sleep(5000);
                                } catch (InterruptedException ex) {
                                    Logger.getLogger(MainTest.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                myframe.getButton().setText("Start Again");

                            }

                        };

                        tt.start();

                        throw new Exception("Questions over wait we are calculating the result...");
                    }
                    questionsContainer.removeAll();
                    q = questios.get(current);

                    JLabel question = new JLabel(q.getQuestion());
                    question.setForeground(Color.white);
                    questionsContainer.setOpaque(false);
                    question.setFont(myframe.getFont());
                    //  question.setForeground(Color.WHITE);
                    question.setHorizontalAlignment(SwingConstants.CENTER);
                    questionsContainer.add(question, BorderLayout.NORTH);

                    ButtonGroup bg = new ButtonGroup();
                    Set<Options> op = q.getOptions();
                    for (int i = 0; i < 4; i++) {
                        options[i] = new JRadioButton();
                        options[i].setFont(myframe.getFont());

                        bg.add(options[i]);

                    }

                    int i = 0;
                    for (Options o : op) {
                        options[i].setText(o.getO());
                        i++;

                    }

                    JPanel optionsContainer = new JPanel(new FlowLayout(FlowLayout.CENTER, 40, 10));
                    for (JRadioButton x : options) {
                        optionsContainer.add(x);
                    }
                    optionsContainer.setOpaque(false);
                    next = new JButton("next");
                    initEvent();
                    next.setFont(myframe.getFont());
                    optionsContainer.add(next, BorderLayout.SOUTH);

                    questionsContainer.add(optionsContainer, BorderLayout.CENTER);
                        Label showScore=new Label("Scrore ="+score);
                        showScore.setFont(new Font("Times New Roman",Font.BOLD,20));
                        showScore.setForeground(Color.BLACK);
                        showScore.setAlignment(Label.CENTER);
                        questionsContainer.add(showScore,BorderLayout.SOUTH);
                    
                    
                    
                    questionsContainer.revalidate();
                    questionsContainer.repaint();
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, ee.getMessage());
                }

            }
        });

    }

}
