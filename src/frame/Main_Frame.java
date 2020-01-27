package frame;

import javax.swing.JFrame;

import panel.*;

public class Main_Frame extends JFrame {
    UIPanel uiPanel = new UIPanel();
    TitlePanel title = new TitlePanel(this);

    public Main_Frame() {
        super("5mok Game");

        init();
        scene();

    }

    public void init() {
        setSize(800, 620);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLocationRelativeTo(null);

        // 레이아웃을 직접 설정
        setLayout(null);
        //setBackground(Color.RED);
    }

    public void scene() {
        //add(gamePanel);
        //add(uiPanel);
        //add(uiPanel.getGamePanel());
        add(title);
    }

    public void changePanel(String panelName) {
        if(panelName.equals("GamePanel")) {
            // 등록된 모든 컨테이너 삭제
            getContentPane().removeAll();
            // 다시 등록
            getContentPane().add(uiPanel);
            getContentPane().add(uiPanel.getGamePanel());
            // 다시 그리기
            revalidate();
            repaint();
        }
    }
}