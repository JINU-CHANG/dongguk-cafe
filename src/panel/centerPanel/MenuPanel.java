package panel.centerPanel;
import menu.Menu;

import config.MenuConfig;
import panel.ImageSizeConvertor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPanel extends JPanel {
    private static final int GRID_SIZE = 3;
    private static final LayoutManager MENU_LAYOUT = new GridLayout(GRID_SIZE, GRID_SIZE, 10, 10);
    private static final Dimension MENU_SIZE = new Dimension(600, 500);
    private static final Dimension BUTTON_SIZE = new Dimension(100, 100);
    private static final Font MENU_FONT = new Font("Serif", Font.BOLD, 15);
    private OrderPanel orderPanel;
    private int totalPrice = 0;

    public MenuPanel() {
        this.setLayout(MENU_LAYOUT);
        this.setPreferredSize(MENU_SIZE);

        orderPanel = new OrderPanel();
        setButtons();
    }
        
    private void setButtons() {
        JButton[][] buttons = new JButton[GRID_SIZE][GRID_SIZE];
            
        //3x3 button grid 생성
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(BUTTON_SIZE);
                this.add(buttons[i][j]);
            }
        }
        setMenuInButtons(buttons);
    }
        
    private void setMenuInButtons(JButton[][] buttons) {
        // 메뉴가 존재할 경우, 버튼에 이미지와 이름, 가격 설정
        List<Menu> menus = MenuConfig.setMenu();

        for (int i = 0; i < menus.size() && i < 9; i++) {
            Menu menu = menus.get(i);

            JPanel buttonInnerPanel = new JPanel(new BorderLayout());

            buttonInnerPanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
            buttonInnerPanel.setBackground(Color.WHITE);

            ImageIcon menuImage = ImageSizeConvertor.adjustSize(new ImageIcon(menu.getImgUrl()), 80, 80);
            JLabel imageLabel = new JLabel(menuImage, SwingConstants.CENTER);
            JLabel nameLabel = new JLabel(menu.getName(), SwingConstants.CENTER);
            JLabel priceLabel = new JLabel(String.valueOf(menu.getPrice()), SwingConstants.CENTER);

            //폰트 지정
            nameLabel.setFont(MENU_FONT);
            priceLabel.setFont(MENU_FONT);

            //레이아웃 지정
            buttonInnerPanel.add(imageLabel, BorderLayout.NORTH);
            buttonInnerPanel.add(nameLabel, BorderLayout.CENTER);
            buttonInnerPanel.add(priceLabel, BorderLayout.SOUTH);

            buttons[i / 3][i % 3].addActionListener(new MenuButtonActionListener(menu));
            buttons[i / 3][i % 3].add(buttonInnerPanel);
        }
    }

    private class MenuButtonActionListener implements ActionListener {
        private Menu menu;

        public MenuButtonActionListener(Menu menu) {
            this.menu = menu;
        }
        @Override
        public void actionPerformed(ActionEvent e) {
            // 중복 주문 확인
            if (orderPanel.checkOrderDuplication(menu)) {
                return;
            }
            totalPrice = orderPanel.addOrderMenu(menu, totalPrice);
        }

    }

    public OrderPanel getOrderPanel() {
        return orderPanel;
    }
}
