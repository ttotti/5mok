package gamemanager;

import javax.swing.JOptionPane;

import drawutil.MouseControl;
import java.util.Arrays;

import javax.swing.JButton;

public class GameManager {
    private int mx, my;

    private final int Black = 1;
    private final int White = 2;

    public int winColor = 0;

    // 필드 - 바둑판 역할을 한다
    public int[][] field = new int[11][11];

    public GameManager() {
        //btn.setBounds(10, 10, 50, 10);
        //btn.addActionListener(this);
        System.out.println("GameManager 생성자!!");
    }
    
    public void init() {
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                field[i][j] = 0;
            }
        }

        winColor = 0;
    }

    public int run(int player) {
        System.out.println("GameManager run() 호출");
        System.out.println("x = " + mx + " y = " + my);

        // 마우스를 클릭한 위치에 이미 돌이 위치해 있다면 상태를 바꾸지 않는다
        if(player == Black) {
            if(field[my][mx] == 0 && field[my][mx] != White) {
                System.out.println("흑돌");
                field[my][mx] = player;

                if(Omoklogic(my, mx, player)) {
                    winColor = Black;
                }

                return White;
            }
            else {
                return Black;
            }
        }
        else {
            if(field[my][mx] == 0 && field[my][mx] != Black) {
                System.out.println("백돌");
                field[my][mx] = player;

                if(Omoklogic(my, mx, player)) {
                    winColor = White;
                }

                return Black;
            }
            else {
                return White;
            }
        }
    }

    // 오목
    public boolean Omoklogic(int my, int mx, int player) {
        int y = my;
        int x = mx;
        int win = 0;

        // 가로
        while (field[y][x] == player) {
            x--;

            if(x < 0)
                break;
        }

        while (field[y][x+1] == player) {
            x++;
            win++;

            if(x >= 10)
                break;
        }

        if (win == 5) {
            return true;
        }

        // 세로
        y = my;
        x = mx;
        win = 0;

        while (field[y][x] == player) {
            y--;

            if(y < 0)
                break;
        }

        while (field[y+1][x] == player) {
            y++;
            win++;

            if(y >= 10)
                break;
        }

        if (win == 5) {
            return true;
        }

        // ↘ 방향
        y = my;
        x = mx;
        win = 0;

        while (field[y][x] == player) {
            y--;
            x--;

            if(y < 0 || x < 0)
                break;
        }

        while (field[y+1][x+1] == player) {
            y++;
            x++;
            win++;

            if(y >= 10 || x >= 10)
                break;
        }

        if (win == 5) {
            return true;
        }

        // ↙ 방향
        y = my;
        x = mx;
        win = 0;

        while (field[y][x] == player) {
            y--;
            x++;

            if(y < 0 || x >= 10)
                break;
        }

        while (field[y+1][x-1] == player) {
            y++;
            x--;
            win++;

            if(y >= 10 || x <= 0)
                break;
        }

        if (win == 5) {
            return true;
        }

        return false;
    }

    public void mousePoint(MouseControl m) {
        mx = m.getX() / 50;
        my = m.getY() / 50;
    }

    public int getX() {
        return mx;
    }

    public int getY() {
        return my;
    }
}