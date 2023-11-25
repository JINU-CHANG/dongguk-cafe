package panel.centerPanel;

import javax.swing.*;
import java.awt.*;

public class KioskCenterPanel extends JPanel {
    private static final LayoutManager CENTER_LAYOUT = new BorderLayout();
    private MenuPanel menuPanel;
    public KioskCenterPanel() {
        this.setLayout(CENTER_LAYOUT);

        menuPanel = new MenuPanel();
        this.add(menuPanel, BorderLayout.WEST);
    }
}
