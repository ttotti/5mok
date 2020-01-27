package drawutil;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class MouseControl implements MouseInputListener {
    private int x, y;
    public int player = 1;
    public boolean isclick = false;
    public boolean isEntered;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setplayer(int player) {
        this.player = player;
    }

    // 마우스 클릭 시
    @Override
    public void mouseClicked(MouseEvent e) {
        isclick = true;
    }

    // 마우스가 눌러진 위치
    @Override
    public void mousePressed(MouseEvent e) {
        //System.out.println("Pressed - x = " + e.getX() + " y = " + e.getY());
    }

    // 마우스가 떼어진 위치
    @Override
    public void mouseReleased(MouseEvent e) {
        //System.out.println("Released - x = " + e.getX() + " y = " + e.getY());
    }

    // 마우스가 올라간 컨텐트팬의 주소
    @Override
    public void mouseEntered(MouseEvent e) {
        isEntered = true;
        System.out.println("패널안에 들어옴");
        System.out.println("Entered - x = " + e.getX() + " y = " + e.getY());
    }

    // 마우스가 내려간 컨텐트팬의 주소
    @Override
    public void mouseExited(MouseEvent e) {
        isEntered = false;
        System.out.println("패널에서 벗어남");
    }

    // 마우스가 컨텐트 팬상에서 드래깅되는 동안
    @Override
    public void mouseDragged(MouseEvent e) {
        //System.out.println("Dragged - x = " + e.getX() + " y = " + e.getY());
    }

    // 마우스가 컨텐트 팬상에서 움직이는 동안
    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
        //System.out.println("Moved - x = " + e.getX() + " y = " + e.getY());
    }
}