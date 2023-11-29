package panel.bottomPanel;

import panel.util.ImageConvertor;

import javax.swing.*;
import java.awt.*;

public class KioskBottomPanel extends JPanel {
    private static final LayoutManager BOTTOM_LAYOUT = new FlowLayout();
    private static final Color BOTTOM_COLOR = Color.WHITE;
    private static final Font BOTTOM_FONT =  new Font("Serif", Font.BOLD, 15);
    private static final Dimension BOTTOM_SIZE = new Dimension(1000, 50);

    public KioskBottomPanel() {
        //레이아웃, 배경색, 크기 지정
        this.setLayout(BOTTOM_LAYOUT);
        this.setBackground(BOTTOM_COLOR);
        this.setPreferredSize(BOTTOM_SIZE);

        //동국로고 지정
        setDonggukLogo();
        //동국글자 지정
        setDonggukText();
    }

    private void setDonggukLogo() {
        ImageIcon image = ImageConvertor.adjustSize("/Users/jinwoo/Desktop/kiosk-image/dongguk-logo.jpeg", 50, 45);
        JLabel imageLabel = new JLabel(image);
        this.add(imageLabel);
    }

    private void setDonggukText() {
        JLabel text = new JLabel("DONGGUK");
        text.setFont(BOTTOM_FONT);
        this.add(text);
    }
}
