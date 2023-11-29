package panel.centerPanel;

import javax.swing.*;
import java.awt.*;

public class KioskCenterPanel extends JPanel {
    private MenuCategoryPanel menuCategoryPanel;
    private MenuPanel menuPanel;
    private OrderPanel orderPanel;

    public KioskCenterPanel() {
        //레이아웃 지정
        this.setLayout(new BorderLayout());
        this.setBorder(BorderFactory.createEmptyBorder(0,15,0,15)); //패널간의 여백 크기 지정

        //주문, 메뉴 패널 생성
        orderPanel = new OrderPanel();
        menuPanel = new MenuPanel(orderPanel);
        menuCategoryPanel = new MenuCategoryPanel(menuPanel);

        //주문, 메뉴 패널들 레이아웃 지정
        this.add(menuCategoryPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.WEST);
        this.add(orderPanel, BorderLayout.EAST);
    }
}
