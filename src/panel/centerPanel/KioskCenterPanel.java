package panel.centerPanel;

import javax.swing.*;
import java.awt.*;

public class KioskCenterPanel extends JPanel {
    private static final LayoutManager CENTER_LAYOUT = new BorderLayout();
    private MenuPanel menuPanel;
    private OrderPanel orderPanel;
    public KioskCenterPanel() {
        this.setLayout(CENTER_LAYOUT);

        menuPanel = new MenuPanel();
        orderPanel = new OrderPanel();
        this.add(menuPanel, BorderLayout.WEST);
        this.add(orderPanel, BorderLayout.EAST);
    }
}
