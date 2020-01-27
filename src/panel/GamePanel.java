package panel;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import java.awt.Graphics;

import drawutil.*;
import gamemanager.*;

public class GamePanel extends JPanel implements Runnable {
    Draw_Util draw = new Draw_Util();
    MouseControl mouse = new MouseControl();
    GameManager gameManager = new GameManager();

    private final int Black = 1;
    private final int White = 2;
    private final int winBlack = 3;
    private final int winWhite = 4;

    // 바둑돌 이미지
    String blackstoneImage = "C:\\Users\\ttotti\\Documents\\Projects\\Java\\5mok\\resource\\blackstone.png";
    String whitestoneImage = "C:\\Users\\ttotti\\Documents\\Projects\\Java\\5mok\\resource\\whitestone.png";
    String pointImage = "C:\\Users\\ttotti\\Documents\\Projects\\Java\\5mok\\resource\\point.png";

    public GamePanel() {
        // 패널을 MouseListener 리스너 등록
        addMouseListener(mouse);
        // 패널을 MouseMotionListener 등록
        addMouseMotionListener(mouse);

        // 위치와 크기를 설정해주는 메소드
        setBounds(20, 20, 550, 550);
        //setBackground(Color.RED);
    }
    
    public void paint(Graphics g) {
        // 패널 지우기
        super.paintComponent(g);

        // 바둑판 모양 그리기
        for (int i = 0; i < 11; i++) {
            draw.paint(g, 1, i * 50 + 20, 20, i * 50 + 20, 520);
            draw.paint(g, 1, 20, i * 50 + 20, 520, i * 50 + 20);
        }

        // 필드 데이터를 순회하며 바둑돌 출력
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if(gameManager.field[j][i] == 1) {
                    draw.drawImage(g, blackstoneImage, i * 50, j * 50);
                }
                else if(gameManager.field[j][i] == 2) {
                    draw.drawImage(g, whitestoneImage, i * 50, j * 50);
                }
            }
        }

        // 마우스 위치에 바둑돌 출력
        if(mouse.isEntered) {
            if(mouse.player == Black) {
                draw.drawImage(g, pointImage, gameManager.getX() * 50 + 20, gameManager.getY() * 50 + 20);
                //draw.drawImage(g, blackstoneImage, gameManager.getX() * 50, gameManager.getY() * 50);
            }
            else {
                draw.drawImage(g, pointImage, gameManager.getX() * 50 + 20, gameManager.getY() * 50 + 20);
                //draw.drawImage(g, whitestoneImage, gameManager.getX() * 50, gameManager.getY() * 50);
            }
        }
    }

    // 쓰레드
    @Override
    public void run() {
        addLog("흑돌 차례입니다");

        for(;;) {
            gameManager.mousePoint(mouse);

            if(mouse.isclick == true) {                
                mouse.setplayer(gameManager.run(mouse.player));
                
                if(mouse.player == Black)
                    addLog("흑돌 차례입니다");
                else
                    addLog("백돌 차례입니다");
                    
                mouse.isclick = false;
            }

            // paint() 메소드 다시 호출
            repaint();

            if(gameManager.winColor == Black) {
                // 다이얼로그
                JOptionPane.showMessageDialog(null, "흑돌이 이겼습니다!!");
                gameManager.init();
                mouse.setplayer(Black);
            }
            else if(gameManager.winColor == White) {
                JOptionPane.showMessageDialog(null, "백돌이 이겼습니다!!");
                gameManager.init();
                mouse.setplayer(Black);
            }
            
            try {
                Thread.sleep(10);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        }
    }

    // 로그창
    JTextArea log = new JTextArea(10, 10);

    // JTextArea에 내용 붙여넣기 + 맨 아래로 스크롤하기
    public void addLog(String s) {
        // 로그 내용을 JTextArea 위에 붙여주고
        log.append(s + "\n");
        // 맨아래로 스크롤 한다
        log.setCaretPosition(log.getDocument().getLength());
    }

    public JTextArea getJTextArea() {
        return log;
    }
}