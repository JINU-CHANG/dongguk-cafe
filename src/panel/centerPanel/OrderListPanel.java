package panel.centerPanel;
import menu.Menu;
import panel.ImageSizeConvertor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static panel.centerPanel.MenuPanel.TOTAL_PRICE;

public class OrderListPanel extends JPanel {
    private static final LayoutManager ORDER_LIST_EACH_LAYOUT = new FlowLayout();
    private static final Dimension ORDER_LIST_EACH_SIZE = new Dimension(350, 50);
    private static final Dimension BUTTON_SIZE = new Dimension(35, 20);
    private static final Font ORDER_LIST_FONT = new Font("Serif", Font.BOLD, 15);
    private OrderResultPanel orderResultPanel;

    public OrderListPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);

        orderResultPanel = new OrderResultPanel();
    }

    public OrderResultPanel getOrderResultPanel() {
        return orderResultPanel;
    }

    public void addOrderMenu(Menu menu) {
        //주문 패널 생성
        JPanel orderPanel = new JPanel(ORDER_LIST_EACH_LAYOUT);
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setMaximumSize(ORDER_LIST_EACH_SIZE);

        //메뉴 이미지 설정
        ImageIcon menuImage = new ImageIcon(menu.getImgUrl());
        JLabel menuImageLabel = new JLabel(ImageSizeConvertor.adjustSize(menuImage, 30, 30));

        //메뉴 이름 및 가격 설정
        JLabel nameLabel = new JLabel(menu.getName());
        JLabel priceLabel = new JLabel(String.valueOf(menu.getPrice()));

        //메뉴 이름 및 가격 폰트 설정
        nameLabel.setFont(ORDER_LIST_FONT);
        priceLabel.setFont(ORDER_LIST_FONT);

        //메뉴 수량 증감 버튼
        JButton plusButton = new JButton("+");
        JLabel quantityLabel = new JLabel("1"); //디폴트 수량
        JButton minusButton = new JButton("-");

        plusButton.setPreferredSize(BUTTON_SIZE);
        minusButton.setPreferredSize(BUTTON_SIZE);

        //플러스 버튼을 누르면 수량이 증가한다.
        plusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityLabel.getText()) + 1;
                quantityLabel.setText(String.valueOf(quantity));
                updateTotalPrice(menu.getPrice());
            }
        });

        //마이너스 버튼을 누르면 수량이 감소한다.
        minusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int quantity = Integer.parseInt(quantityLabel.getText());
                if (quantity > 1) {
                    quantityLabel.setText(String.valueOf(quantity - 1));
                    updateTotalPrice(-menu.getPrice());
                }

                if (quantity == 1) {
                    updateTotalPrice(-menu.getPrice());
                    removeOrderPanel(orderPanel);
                }
            }
        });

        orderPanel.add(menuImageLabel);
        orderPanel.add(nameLabel);
        orderPanel.add(priceLabel);
        orderPanel.add(plusButton);
        orderPanel.add(quantityLabel);
        orderPanel.add(minusButton);
        this.add(orderPanel);

        TOTAL_PRICE += menu.getPrice();
        orderResultPanel.setPricePanel(TOTAL_PRICE);

        // 화면에 다시 그리기
        this.revalidate();
        this.repaint();
    }

    private void updateTotalPrice(int amount) {
        TOTAL_PRICE += amount;
        orderResultPanel.setPricePanel(TOTAL_PRICE);
    }

    private void removeOrderPanel(JPanel orderPanel) {
        this.remove(orderPanel);
        revalidate();
        repaint();
    }

    public boolean isMenuAlreadyOrdered(Menu menu) {
        // 주문 목록에서 중복된 메뉴를 찾아서 이미 주문되었다면 true 반환
        for (Component component : this.getComponents()) {
            if (component instanceof JPanel) {
                JPanel panel = (JPanel) component;
                Component[] components = panel.getComponents();
                if (components.length >= 2 && components[1] instanceof JLabel) {
                    JLabel nameLabel = (JLabel) components[1];
                    if (nameLabel.getText().equals(menu.getName())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
