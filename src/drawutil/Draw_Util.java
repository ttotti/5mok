package drawutil;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
//import java.awt.Image;
import java.awt.geom.Line2D;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
//import java.nio.Buffer;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

public class Draw_Util {
    public void paint(final Graphics g, final int thickness, final int p1, final int p2, final int p3, final int p4) {
        final Graphics2D g2 = (Graphics2D) g;

        g2.setStroke(new BasicStroke(thickness, BasicStroke.CAP_BUTT, 0));
        g2.draw(new Line2D.Double(p1, p2, p3, p4));
    }

    public void drawImage(Graphics g, final String filename, final int x, final int y) {
        BufferedImage img = null;

        try {
            img = ImageIO.read(new File(filename));
        } catch (final IOException e) {
            JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
            e.printStackTrace();
            System.exit(0);
        }

        g.drawImage(img, x, y, null);
    }

    // 작동은 하는데.. 이미지 투명배경이 적용이 안된 상태로 이미지를 저장해버린다..
    // 당장은 필요없고 뭐가 문제인지 모르겠다 상당히 졸려서 머리가 잘 안돌아가니까 다음에 기회가 된다면 고치도록 하자
    // public void Resize_drawImage(Graphics g, final String filename, final int x, final int y, final int width, final int height) {
    //     final String targetPath = "C:\\Users\\ttotti\\Documents\\Projects\\Java\\5mok\\resource\\Re_blackstone.png";
    //     BufferedImage newImage = null;
    //     Image img = null;
    //     Image resizeImage = null;

    //     try {
    //         img = ImageIO.read(new File(filename));
    //         // 이미지 크기 조정과 어떻게 이미지를 그릴지(속도를 우선하느냐 등..)를 매개변수로 넣어준다
    //         resizeImage = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);

    //         newImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

    //         g = newImage.getGraphics();
    //         // drawImage 메소드는 비동기와 관련이 있다 - 보통 this 나 null
    //         g.drawImage(resizeImage, x, y, null);
    //         g.dispose();
    //         ImageIO.write(newImage, "png", new File(targetPath));

    //     } catch (final IOException e) {
    //         JOptionPane.showMessageDialog(null, "이미지 불러오기 실패");
    //         e.printStackTrace();
    //         System.exit(0);
    //     }
    // }
}