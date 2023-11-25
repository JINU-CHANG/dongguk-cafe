package panel.centerPanel;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {
    private static final LayoutManager ORDER_LAYOUT = new BorderLayout();
    private static final Color COLOR = Color.WHITE;
    private static final Dimension SIZE = new Dimension(350, 500);

    private OrderTopPanel orderTopPanel;
    private OrderListPanel orderListPanel;
    public OrderPanel() {
        this.setLayout(ORDER_LAYOUT);
        this.setBackground(COLOR);
        this.setPreferredSize(SIZE);

        orderTopPanel = new OrderTopPanel();
        orderListPanel = new OrderListPanel();
        this.add(orderTopPanel, BorderLayout.NORTH);
        this.add(orderListPanel, BorderLayout.CENTER);
    }
}
