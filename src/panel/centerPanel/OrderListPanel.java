package panel.centerPanel;
import menu.Menu;
import panel.ImageSizeConvertor;

import javax.swing.*;
import java.awt.*;

public class OrderListPanel extends JPanel {
    public OrderListPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);
    }

    public void addOrderMenu(Menu menu) {
        //주문 패널 생성
        JPanel orderPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setMaximumSize(new Dimension(350, 50));

        //메뉴 이미지 설정
        ImageIcon menuImage = new ImageIcon(menu.getImgUrl());
        JLabel menuImageLabel = new JLabel(ImageSizeConvertor.adjustSize(menuImage, 30, 30));

        //메뉴 이름 및 가격 설정
        JLabel nameLabel = new JLabel(menu.getName());
        JLabel priceLabel = new JLabel(String.valueOf(menu.getPrice()));

        //메뉴 이름 및 가격 폰트 설정
        nameLabel.setFont(new Font("Serif", Font.BOLD, 15));
        priceLabel.setFont(new Font("Serif", Font.BOLD, 15));

        orderPanel.add(menuImageLabel);
        orderPanel.add(nameLabel);
        orderPanel.add(priceLabel);
        this.add(orderPanel);

        this.revalidate();
        this.repaint();
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
