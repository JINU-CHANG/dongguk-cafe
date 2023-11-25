package panel.centerPanel;

import menu.Menu;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {
    private static final LayoutManager ORDER_LAYOUT = new BorderLayout();
    private static final Color ORDER_COLOR = Color.WHITE;
    private static final Dimension ORDER_SIZE = new Dimension(350, 500);

    private OrderTopPanel orderTopPanel;
    private OrderListPanel orderListPanel;
    public OrderPanel() {
        this.setLayout(ORDER_LAYOUT);
        this.setBackground(ORDER_COLOR);
        this.setPreferredSize(ORDER_SIZE);

        orderTopPanel = new OrderTopPanel();
        orderListPanel = new OrderListPanel();
        this.add(orderTopPanel, BorderLayout.NORTH);
        this.add(orderListPanel, BorderLayout.CENTER);
    }

    public void addOrderMenu(Menu menu) {
        orderListPanel.addOrderMenu(menu);
    }

    public boolean checkOrderDuplication(Menu menu) {
        return orderListPanel.isMenuAlreadyOrdered(menu);
    }
}
