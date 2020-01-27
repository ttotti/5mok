package panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Font;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import drawutil.MouseControl;

public class UIPanel extends JPanel implements ActionListener {
    GamePanel gamePanel = new GamePanel();
    Thread gamemanager = new Thread(gamePanel);
    
    JButton btn_restart = new JButton("초기화");
    //JTextArea log = new JTextArea(10,10);
    // JTextArea에서 스크롤바를 자동으로 설정
    JScrollPane scroll = new JScrollPane(gamePanel.getJTextArea());

    //MouseControl mouse = new MouseControl();

    public UIPanel() {
        System.out.println("uiPanel 생성자!!");
        setBounds(520, 40, 250, 500);
        setLayout(null);
        setBackground(Color.GRAY);

        // 초기화 버튼
        btn_restart.setBounds(70, 460, 120, 30);
        btn_restart.addActionListener(this);
        add(btn_restart);

        scroll.setBounds(60,10,180,300);
        scroll.setForeground(Color.BLACK);
        add(scroll);

        // 쓰레드 시작
        gamemanager.start();

        // 패널을 MouseListener 리스너 등록
        //addMouseListener(mouse);
        // 패널을 MouseMotionListener 등록
        //addMouseMotionListener(mouse);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        
        if((JButton)obj == btn_restart) {
            gamePanel.gameManager.init();
            gamePanel.addLog("초기화");
            //System.out.println("초기화 버튼 눌림");
        }

        System.out.println("이벤트 발생!!");
    }

    // JTextArea에 내용 붙여넣기 + 맨 아래로 스크롤하기
    // public void addLog(String s) {
    //     // 로그 내용을 JTextArea 위에 붙여주고
    //     log.append(s + "\n");
    //     // 맨아래로 스크롤 한다
    //     log.setCaretPosition(log.getDocument().getLength());
    // }

    public GamePanel getGamePanel() {
        return gamePanel;
    }
}