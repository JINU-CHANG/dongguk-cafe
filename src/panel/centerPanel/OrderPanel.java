package panel.centerPanel;

import menu.Menu;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {
    private static final LayoutManager ORDER_LAYOUT = new BorderLayout();
    private static final Color ORDER_COLOR = Color.WHITE;
    private static final Dimension ORDER_SIZE = new Dimension(350, 300);

    private OrderTopPanel orderTopPanel;
    private OrderListPanel orderListPanel;
    private OrderResultPanel orderResultPanel;

    public OrderPanel() {
        //레이아웃, 배경색, 크기를 지정한다.
        this.setLayout(ORDER_LAYOUT);
        this.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0));
        this.setBackground(ORDER_COLOR);
        this.setPreferredSize(ORDER_SIZE);

        orderTopPanel = new OrderTopPanel();
        orderListPanel = new OrderListPanel();
        orderResultPanel = orderListPanel.getOrderResultPanel();
        this.add(orderTopPanel, BorderLayout.NORTH);
        this.add(orderListPanel, BorderLayout.CENTER);
        this.add(orderResultPanel, BorderLayout.SOUTH);
    }

    public void addOrderMenu(Menu menu) {
        orderListPanel.addOrderMenu(menu);
    }

    public boolean checkOrderDuplication(Menu menu) {
        return orderListPanel.isMenuAlreadyOrdered(menu);
    }
}
