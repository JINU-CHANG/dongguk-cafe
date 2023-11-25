import javax.swing.*;
import java.awt.*;

public class KioskTopPanel extends JPanel {
    private static final FlowLayout LAYOUT = new FlowLayout(FlowLayout.CENTER, 20,20);
    private static final Color COLOR = new Color(177, 33, 24);
    private static final Dimension SIZE = new Dimension(1000, 140);
    private static final FlowLayout INNER_LAYOUT = new FlowLayout(FlowLayout.CENTER, 18, 18);
    private static final Color INNER_COLOR = new Color(35, 24, 22);
    private static final Dimension INNER_SIZE = new Dimension(1000, 100);
    private JPanel innerPanel;

    KioskTopPanel() {
        this.setLayout(LAYOUT);
        this.setBackground(COLOR);
        this.setPreferredSize(SIZE);
    }

    public void setInnerPanel() {
        innerPanel = new JPanel(INNER_LAYOUT);
        innerPanel.setBackground(INNER_COLOR);
        innerPanel.setPreferredSize(INNER_SIZE);
        this.add(innerPanel);
    }
}
