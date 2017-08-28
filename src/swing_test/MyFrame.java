package swing_test;

import com.pojos.Main_Hiber;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.io.FileInputStream;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class MyFrame extends JFrame {

    JPanel panel, p1;
    private JLabel heading;
    private Font font;
    private JButton button;
    private JMenuBar bar;
    private JMenu menu, menu1, setting;
    private JMenuItem i0, i1, i2, i3, i4, i5, moveRight, moveLeft,insertDummyDatatoDB;

    public JButton getButton() {
        return button;
    }

    public JMenuItem getI0() {
        return i0;
    }

    public Font getFont() {
        return font;
    }

    public void setFont(Font font) {
        this.font = font;
    }

    MyFrame() throws Exception {
        this.setTitle("MyFrame");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setIconImage(ImageIO.read(new FileInputStream("src/Folder.png")));
        //  this.setSize(new Dimension(900, 600));
        this.setSize(Toolkit.getDefaultToolkit().getScreenSize());
        initComp();
        initMenus();
        initEvent();
        this.setLocationRelativeTo(null);

        this.setVisible(true);
        this.setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    private void initComp() {
        panel = new MyPanel(new BorderLayout(10, 10), "src/background.jpg");;

        font = new Font("Courier New", Font.PLAIN, 20);
        button = new JButton("Start Test");
        button.setFont(font);
        button.setSize(300, 300);
        button.setIcon(new ImageIcon("src/icons8-Tab Mac-100.png"));
        button.setHorizontalTextPosition(SwingConstants.LEFT);
        //     button.setBorder(BorderFactory.createTitledBorder("click here to start object"));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setToolTipText("Click here to start the test");
        Map p = font.getAttributes();
        p.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
        heading = new JLabel("Online Examination Center", SwingConstants.CENTER);
        heading.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        heading.setFont(font.deriveFont(p));
        heading.setForeground(Color.WHITE);
        panel.add(heading, BorderLayout.NORTH);
        JPanel buttonContainer = new JPanel(new FlowLayout());
        buttonContainer.setOpaque(false);
        buttonContainer.add(button);

        JSeparator sp = new JSeparator();
        panel.add(sp);
        panel.add(buttonContainer, BorderLayout.CENTER);
        this.add(panel);

    }

    private void initMenus() {
        bar = new JMenuBar();
        bar.setFont(font);
        menu = new JMenu("Options");
        menu1 = new JMenu("Help");
        setting = new JMenu("Settings");
        setting.setFont(font);
        moveLeft = new JMenuItem("Move Menu Items to Left");
        moveLeft.setFont(font);
        moveRight = new JMenuItem("Move Menu items to Right");
        moveRight.setFont(font);
        menu1.setFont(font);
        menu.setFont(font);
        i0 = new JMenuItem("Home");
        i0.setFont(font);
        i0.setIcon(new ImageIcon("src/icons8-Menu-64.png"));
        i1 = new JMenuItem("New Test");
        i1.setFont(font);
        i1.setIcon(new ImageIcon("src/icons8-Replace Filled-50.png"));
        i2 = new JMenuItem("Old Test");
        i2.setFont(font);
        i2.setIcon(new ImageIcon("src/icons8-Hint-50.png"));
        i3 = new JMenuItem("Exit");
        i3.setFont(font);
        i3.setIcon(new ImageIcon("src/icons8-Exit-48.png"));
        i4 = new JMenuItem("About us");
        i4.setFont(font);
        i5 = new JMenuItem("Contact us");
        i5.setFont(font);
        insertDummyDatatoDB=new JMenuItem("Insert dummy data to Database");
        insertDummyDatatoDB.setFont(font);
        menu1.add(insertDummyDatatoDB);
        setting.add(moveLeft);
        setting.addSeparator();
        setting.add(moveRight);
        menu.add(i0);
        menu.addSeparator();

        menu.add(i1);
        menu.addSeparator();
        menu.add(i2);
        menu.addSeparator();
        menu.add(i3);
        menu1.add(i4);
        menu1.addSeparator();
        menu1.add(i5);

        bar.add(menu);
        bar.add(setting);
        bar.add(menu1);
        this.setJMenuBar(bar);
    }

    private void initEvent() {
        i0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                MyFrame.this.remove(new JScrollPane(p1));
                MyFrame.this.add(panel);
                MyFrame.this.revalidate();
                MyFrame.this.repaint();

            }
        });

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button.setText("wait.....");

                MyFrame.this.remove(panel);
                // MyFrame.this.repaint();
                MainTest t = new MainTest(MyFrame.this);
                p1 = t.init();
                MyFrame.this.add(p1);

                MyFrame.this.revalidate();
                MyFrame.this.repaint();

            }
        });

        //event for exit event
        i3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(12);
            }
        });
        moveLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bar.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
                bar.revalidate();
                bar.repaint();

            }
        });
        moveRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                bar.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
                bar.revalidate();
                bar.repaint();

            }
        });
        insertDummyDatatoDB.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Main_Hiber.main(new String[]{});
            }
        });

    }

}
