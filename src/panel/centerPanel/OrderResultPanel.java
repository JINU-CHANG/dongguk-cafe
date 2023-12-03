package panel.centerPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class OrderResultPanel extends JPanel {
    private int totalPrice = 0;
    private static final LayoutManager ORDER_RESULT_LAYOUT = new BorderLayout();
    private static final Color ORDER_RESULT_COLOR = Color.WHITE;

    public OrderResultPanel(OrderListPanel orderListPanel) {
        this.setLayout(ORDER_RESULT_LAYOUT);
        this.setBackground(ORDER_RESULT_COLOR);

        //초기 금액은 0원으로 설정
        setPricePanel();
        setOrderResultButton(orderListPanel);
    }

    public void setPricePanel() {
        //가격 패널 및 라벨 생성
        JPanel pricePanel = new JPanel(new FlowLayout());
        pricePanel.setBackground(ORDER_RESULT_COLOR);
        JLabel priceStringLabel = new JLabel("총금액 : " + totalPrice);

        //가격 패널 및 라벨을 add한다.
        pricePanel.add(priceStringLabel);
        this.add(pricePanel, BorderLayout.NORTH);
    }

    public void updatePrice(int price) {
        totalPrice += price;
        setPricePanel();
    }

    private void setOrderResultButton(OrderListPanel orderListPanel) {
        //주문하기 버튼 생성
        JButton orderButton = new JButton("주문하기");

        //주문하기 버튼을 누르면 OrderListPanel에 저장된 값들을 새로운 창에 출력하는 이벤트 리스너 지정
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
            showOrderDetails(orderListPanel.getOrderDetails());
        }

        private void showOrderDetails(List<String> orderDetails) {
            //새로운 프레임 생성
            JFrame orderDetailsFrame = new JFrame("주문 내역");
            orderDetailsFrame.setSize(400, 400);
            orderDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            OrderDetailsPanel orderDetailsPanel = new OrderDetailsPanel(orderDetails);

            //출력 버튼 눌렀을 때 영수증 출력하는 이벤트 리스너 지정
            JButton additionalButton = new JButton("출력하기");
            additionalButton.addActionListener(new ReceiptPrintListener(orderListPanel, orderDetailsFrame));

            //레이아웃 위치 지정
            orderDetailsFrame.add(new OrderTopPanel(), BorderLayout.NORTH);
            orderDetailsFrame.add(orderDetailsPanel, BorderLayout.CENTER);
            orderDetailsFrame.add(additionalButton, BorderLayout.SOUTH);
            orderDetailsFrame.setVisible(true);
        }

    }

    public void clearTotalPrice() {
        totalPrice = 0;
        this.revalidate();
        this.repaint();
    }

    private class ReceiptPrintListener implements ActionListener {
        private OrderListPanel orderListPanel;
        private JFrame orderDetailsFrame;

        public ReceiptPrintListener(OrderListPanel orderListPanel, JFrame orderDetailsFrame) {
            this.orderListPanel = orderListPanel;
            this.orderDetailsFrame = orderDetailsFrame;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            showReceipt(orderListPanel.getOrderDetails(), orderDetailsFrame);
            clearOrderList(); //영수증 출력 후 주문내역을 초기화한다.
        }

        private void showReceipt(List<String> orderDetails, JFrame orderDetailsFrame) {
            JFrame receiptFrame = new JFrame("주문 내역");

            ReceiptPanel receiptPanel = new ReceiptPanel(orderDetails, totalPrice);

            receiptFrame.add(receiptPanel);
            receiptFrame.setSize(300, 200);
            receiptFrame.setLocationRelativeTo(orderDetailsFrame);
            receiptFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            receiptFrame.setVisible(true);

            orderDetailsFrame.dispose();
        }

        private void clearOrderList() {
            orderListPanel.clearOrderList();
            clearTotalPrice();
        }

    }
}
