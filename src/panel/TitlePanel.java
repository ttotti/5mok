package panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import drawutil.Draw_Util;
import frame.*;

public class TitlePanel extends JPanel implements ActionListener {
    Main_Frame main_Frame;
    Draw_Util draw_Util = new Draw_Util();

    JLabel label = new JLabel("title 패널");

    String titleImage = "C:\\Users\\ttotti\\Documents\\Projects\\Java\\5mok\\resource\\title.png";
    JButton gameStart_1 = new JButton(new ImageIcon("C:\\Users\\ttotti\\Documents\\Projects\\Java\\5mok\\resource\\gamestart_1.png"));
    JButton gameExit_1 = new JButton(new ImageIcon("C:\\Users\\ttotti\\Documents\\Projects\\Java\\5mok\\resource\\gameexit_1.png"));
    //JButton gameStart_1 = new JButton("게임 시작");
    //JButton gameExit_1 = new JButton("게임 종료");

    public TitlePanel(Main_Frame main_Frame) {
        this.main_Frame = main_Frame;
        
        setLayout(null);
        setBounds(0, 0, 800, 620);

        gameStart_1.addActionListener(this);
        gameStart_1.setBounds(100,300,200,100);

        gameExit_1.addActionListener(this);
        gameExit_1.setBounds(500,300,200,100);

        add(gameStart_1);
        add(gameExit_1);
    }

    public void paint(Graphics g) {
        draw_Util.drawImage(g, titleImage, 0, 0);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if((JButton)obj == gameStart_1) {
            System.out.println("gameStart 버튼 눌림");
            main_Frame.changePanel("GamePanel");
        }
        else if((JButton)obj == gameExit_1) {
            System.out.println("gameExit 버튼 눌림");
            System.exit(0);
        }

        System.out.println("이벤트 발생!!");
    }
}