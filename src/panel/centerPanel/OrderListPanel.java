package panel.centerPanel;
import menu.Menu;
import panel.ImageSizeConvertor;

import javax.swing.*;
import java.awt.*;

public class OrderListPanel extends JPanel {
    private static final LayoutManager ORDER_LIST_EACH_LAYOUT = new FlowLayout(FlowLayout.CENTER);
    private static final Dimension ORDER_LIST_EACH_SIZE = new Dimension(350, 50);
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

    public int addOrderMenu(Menu menu, int totalPrice) {
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

        orderPanel.add(menuImageLabel);
        orderPanel.add(nameLabel);
        orderPanel.add(priceLabel);
        this.add(orderPanel);

        totalPrice += menu.getPrice();

        orderResultPanel.setPricePanel(totalPrice);
        //화면에 다시 그리기
        this.revalidate();
        this.repaint();

        return totalPrice;
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
