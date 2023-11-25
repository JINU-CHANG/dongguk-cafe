package topPanel;

import javax.swing.*;
import java.awt.*;

public class KioskTopPanel extends JPanel {
    private static final FlowLayout LAYOUT = new FlowLayout(FlowLayout.CENTER, 20,20);
    private static final Color COLOR = new Color(177, 33, 24);
    private static final Dimension SIZE = new Dimension(1000, 140);

    private JPanel innerPanel;
    private JPanel logoPanel;

    public KioskTopPanel() {
        this.setLayout(LAYOUT);
        this.setBackground(COLOR);
        this.setPreferredSize(SIZE);

        setInnerPanel();
        setLogoPanel();
    }

    public void setInnerPanel() {
        innerPanel = new KioskInnerPanel();
        this.add(innerPanel);
    }

    public void setLogoPanel() {
        logoPanel = new KioskLogoPanel();
        innerPanel.add(logoPanel);
    }
}
