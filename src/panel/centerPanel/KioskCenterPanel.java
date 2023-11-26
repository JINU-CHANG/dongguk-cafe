package panel.centerPanel;

import javax.swing.*;
import java.awt.*;

public class KioskCenterPanel extends JPanel {
    private static final LayoutManager CENTER_LAYOUT = new BorderLayout();
    private MenuTopPanel menuTopPanel;
    private MenuPanel menuPanel;
    private OrderPanel orderPanel;

    public KioskCenterPanel() {
        this.setLayout(CENTER_LAYOUT);
        this.setBorder(BorderFactory.createEmptyBorder(0,15,0,15));

        //주문, 메뉴 패널 생성
        orderPanel = new OrderPanel();
        menuPanel = new MenuPanel(orderPanel);
        menuTopPanel = new MenuTopPanel(menuPanel);

        //주문, 메뉴 패널들 레이아웃 지정
        this.add(menuTopPanel, BorderLayout.NORTH);
        this.add(menuPanel, BorderLayout.WEST);
        this.add(orderPanel, BorderLayout.EAST);
    }
}
