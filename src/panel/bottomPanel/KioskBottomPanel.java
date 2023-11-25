package panel.bottomPanel;

import panel.ImageSizeConvertor;

import javax.swing.*;
import java.awt.*;

public class KioskBottomPanel extends JPanel {
    private static final LayoutManager BOTTOM_LAYOUT = new BorderLayout();
    private static final Color BOTTOM_COLOR = Color.WHITE;
    private static final Dimension BOTTOM_SIZE = new Dimension(1000, 50);

    public KioskBottomPanel() {
        this.setLayout(BOTTOM_LAYOUT);
        this.setBackground(BOTTOM_COLOR);
        this.setPreferredSize(BOTTOM_SIZE);

        JLabel donggukLogo = createDonggukLogo();
        this.add(donggukLogo);
    }

    private JLabel createDonggukLogo() {
        ImageIcon donggukImage = new ImageIcon("/Users/jinwoo/Desktop/kiosk-image/donggukLogo2.png");
        JLabel donggukLabel = new JLabel(ImageSizeConvertor.adjustSize(donggukImage, 150, 60));

        return donggukLabel;
    }
}
