package panel.centerPanel;

import menu.Menu;

import javax.swing.*;
import java.awt.*;

public class OrderPanel extends JPanel {
    private OrderTopPanel orderTopPanel;
    private OrderListPanel orderListPanel;
    private OrderResultPanel orderResultPanel;

    public OrderPanel() {
        //레이아웃, 배경색, 크기를 지정한다.
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(30, 0, 30, 0)); //여백 지정
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(350, 300));

        orderTopPanel = new OrderTopPanel();
        orderListPanel = new OrderListPanel();
        orderResultPanel = orderListPanel.getOrderResultPanel();

        //레이아웃 위치 지정
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
