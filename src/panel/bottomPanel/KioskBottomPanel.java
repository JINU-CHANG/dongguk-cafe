package panel.bottomPanel;

import panel.ImageSizeConvertor;

import javax.swing.*;
import java.awt.*;

public class KioskBottomPanel extends JPanel {
    private static final LayoutManager BOTTOM_LAYOUT = new FlowLayout();
    private static final Color BOTTOM_COLOR = Color.WHITE;
    private static final Font BOTTOM_FONT =  new Font("Serif", Font.BOLD, 15);
    private static final Dimension BOTTOM_SIZE = new Dimension(1000, 50);

    public KioskBottomPanel() {
        this.setLayout(BOTTOM_LAYOUT);
        this.setBackground(BOTTOM_COLOR);
        this.setPreferredSize(BOTTOM_SIZE);

        JLabel donggukLogo = setDonggukLogo();
        JLabel donggukText = setDonggukText();
        this.add(donggukLogo);
        this.add(donggukText);
    }

    private JLabel setDonggukLogo() {
        ImageIcon donggukImage = new ImageIcon("/Users/jinwoo/Desktop/kiosk-image/dongguk-logo.jpeg");
        return new JLabel(ImageSizeConvertor.adjustSize(donggukImage, 50, 45));
    }

    private JLabel setDonggukText() {
        JLabel donggukText = new JLabel("DONGGUK");
        donggukText.setFont(BOTTOM_FONT);

        return donggukText;
    }
}
