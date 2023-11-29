package panel.centerPanel;
import menu.Menu;

import config.MenuConfig;
import panel.util.ImageConvertor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuPanel extends JPanel {
    private static final int GRID_SIZE = 3;
    public static int TOTAL_PRICE = 0;
    private String currentCategory; //현재 카테고리
    private final OrderPanel orderPanel;

    public MenuPanel(OrderPanel orderPanel) {
        this.orderPanel = orderPanel;

        //레이아웃 및 크기 지정
        this.setLayout(new GridLayout(GRID_SIZE, GRID_SIZE, 5, 5)); //그리드 레이아웃 지정
        this.setPreferredSize(new Dimension(600, 450));

        //초기 카테고리 커피로 설정
        currentCategory = "Coffee";

        //메뉴 버튼 생성
        setButtons();
    }

    public void setMenuCategory(String category) {
        currentCategory = category;
        refreshMenu();
    }

    private void refreshMenu() {
        //현재 컨테이너의 모든 내용을 지운다.
        removeAll();

        //빈 버튼을 생성하고, 빈 버튼에 메뉴를 넣는다.
        setButtons();

        //swing 컴포넌트를 업데이트하고 다시 그리도록 한다.
        revalidate();
        repaint();
    }
        
    private void setButtons() {
        JButton[][] emptyButtons = createEmptyButtons();
        setMenuIn(emptyButtons);
    }
        
    private void setMenuIn(JButton[][] buttons) {
        //현재 카테고리에 해당되는 메뉴들만 필터링해서 가져오기
        List<Menu> menus = MenuConfig.setMenu().stream().filter(menu -> menu.isTypeOf(currentCategory)).toList();

        for (int i = 0; i < menus.size(); i++) {
            //메뉴 정보들을 담기 위한 패널 생성
            JPanel buttonInnerPanel = new JPanel(new BorderLayout());
            buttonInnerPanel.setBackground(Color.WHITE);

            //메뉴 정보 가져오기
            Menu menu = menus.get(i);

            //메뉴 이미지, 이름, 가격 라벨 생성
            JLabel imageLabel = new JLabel(ImageConvertor.adjustSize(menu.getImgUrl(), 80, 80), SwingConstants.CENTER);
            JLabel nameLabel = new JLabel(menu.getName(), SwingConstants.CENTER);
            JLabel priceLabel = new JLabel(String.valueOf(menu.getPrice()), SwingConstants.CENTER);

            //폰트 지정
            nameLabel.setFont(new Font("Serif", Font.BOLD, 15));
            priceLabel.setFont(new Font("Serif", Font.BOLD, 15));

            //레이아웃 지정
            buttonInnerPanel.add(imageLabel, BorderLayout.NORTH);
            buttonInnerPanel.add(nameLabel, BorderLayout.CENTER);
            buttonInnerPanel.add(priceLabel, BorderLayout.SOUTH);

            buttons[i / 3][i % 3].addActionListener(new MenuButtonActionListener(menu));
            buttons[i / 3][i % 3].add(buttonInnerPanel);
        }
    }

    private JButton[][] createEmptyButtons() {
        JButton[][] buttons = new JButton[GRID_SIZE][GRID_SIZE];
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(80, 80));
                add(buttons[i][j]);
            }
        }

        return buttons;
    }

    private class MenuButtonActionListener implements ActionListener {
        private Menu menu;
        public MenuButtonActionListener(Menu menu) {
            this.menu = menu;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //중복 주문 확인
            if (orderPanel.checkOrderDuplication(menu)) {
                return;
            }
            //중복되지 않은 메뉴만 주문서에 포함한다.
            orderPanel.addOrderMenu(menu);
        }
    }
}
