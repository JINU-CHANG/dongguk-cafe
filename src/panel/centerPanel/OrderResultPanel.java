package panel.centerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static panel.centerPanel.MenuPanel.TOTAL_PRICE;

public class OrderResultPanel extends JPanel {
    private static final LayoutManager ORDER_RESULT_LAYOUT = new BorderLayout();
    private static final Dimension ORDERS_DETAILS_SIZE = new Dimension(200, 50);
    private static final Color ORDER_RESULT_COLOR = Color.WHITE;
    private OrderListPanel orderListPanel;

    public OrderResultPanel(OrderListPanel orderListPanel) {
        this.setLayout(ORDER_RESULT_LAYOUT);
        this.setBackground(ORDER_RESULT_COLOR);

        this.orderListPanel = orderListPanel;
        //초기 금액은 0원으로 설정
        setPricePanel(0);
        setOrderResultButton();
    }

    public void setPricePanel(int totalPrice) {
        JPanel pricePanel = new JPanel(new FlowLayout());
        pricePanel.setBackground(Color.WHITE);

        JLabel priceStringLabel = new JLabel("총금액 : " + totalPrice);
        pricePanel.add(priceStringLabel);

        this.add(priceStringLabel, BorderLayout.NORTH);
    }

    private void setOrderResultButton() {
        JButton orderButton = new JButton("주문하기");
        orderButton.addActionListener(new OrderResultButtonListener(orderListPanel));
        this.add(orderButton, BorderLayout.SOUTH);
    }

    private class OrderResultButtonListener implements ActionListener {
        private OrderListPanel orderListPanel;

        public OrderResultButtonListener(OrderListPanel orderListPanel) {
            this.orderListPanel = orderListPanel;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // 주문 내역을 표시할 새로운 창 생성
            JFrame orderDetailsFrame = new JFrame("주문 내역");
            orderDetailsFrame.setSize(400, 400);
            orderDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            // 주문 내역 패널 생성
            JPanel orderDetailsPanel = new JPanel();
            orderDetailsPanel.setLayout(new BoxLayout(orderDetailsPanel, BoxLayout.Y_AXIS));
            orderDetailsPanel.setMaximumSize(ORDERS_DETAILS_SIZE);

            // 주문 내역 추가
            for (Component component : orderListPanel.getComponents()) {
                JPanel orderMenuDetailsPanel = new JPanel(new FlowLayout());
                Component name = (((JPanel) component).getComponents())[1];
                Component price = (((JPanel) component).getComponents())[2];
                Component quantity = (((JPanel) component).getComponents())[4];
                orderMenuDetailsPanel.add(name);
                orderMenuDetailsPanel.add(price);
                orderMenuDetailsPanel.add(quantity);
                orderDetailsPanel.add(orderMenuDetailsPanel);
            }

            // 총금액 라벨 추가
            JLabel totalPriceLabel = new JLabel("총금액: " + TOTAL_PRICE);
            orderDetailsPanel.add(totalPriceLabel);

            orderDetailsFrame.add(orderDetailsPanel);
            orderDetailsFrame.setVisible(true);
        }
    }
}
