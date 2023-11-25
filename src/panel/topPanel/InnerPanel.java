package panel.topPanel;

import javax.swing.*;
import java.awt.*;

public class InnerPanel extends JPanel {
    private static final FlowLayout INNER_LAYOUT = new FlowLayout(FlowLayout.CENTER, 18, 18);
    private static final Color INNER_COLOR = new Color(35, 24, 22);
    private static final Dimension INNER_SIZE = new Dimension(1000, 100);

    public InnerPanel() {
        this.setLayout(INNER_LAYOUT);
        this.setBackground(INNER_COLOR);
        this.setPreferredSize(INNER_SIZE);
    }
}
