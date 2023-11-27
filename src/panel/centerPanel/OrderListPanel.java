package panel.centerPanel;
import menu.Menu;
import panel.ImageConvertor;

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

    //주문 메뉴에서 중복된 메뉴가 있는지 확인한다.
    public boolean isMenuAlreadyOrdered(Menu input) {
        //OrderPanel들을 순회한다.
        for (Component component : this.getComponents()) {
            //OrderPanel 각각의 메뉴이름을 가져온다.
            String menuName = getMenuName((JPanel) component);

            //메뉴 이름이 input의 메뉴 이름과 같으면 중복된 메뉴이므로 true 반환
            if (menuName.equals(input.getName())) {
                return true;
            }
        }

        //해당하는 것이 없다면 중복되지 않은 메뉴이므로 false 반환
        return false;
    }

    public void addOrderMenu(Menu menu) {
        //주문 패널 생성
        JPanel orderPanel = new JPanel(ORDER_LIST_EACH_LAYOUT);
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setMaximumSize(ORDER_LIST_EACH_SIZE);

        //메뉴 이미지, 이름, 가격 라벨 생성
        JLabel menuImageLabel = new JLabel(ImageConvertor.adjustSize(menu.getImgUrl(), 30, 30));
        JLabel nameLabel = new JLabel(menu.getName());
        JLabel priceLabel = new JLabel(String.valueOf(menu.getPrice()));

        //메뉴 이름 및 가격 폰트 설정
        nameLabel.setFont(ORDER_LIST_FONT);
        priceLabel.setFont(ORDER_LIST_FONT);

        //메뉴 수량 증감 버튼
        JButton plusButton = new JButton("+");
        JLabel quantityLabel = new JLabel("1"); //디폴트 수량
        JButton minusButton = new JButton("-");

        //버튼 크기 지정
        plusButton.setPreferredSize(BUTTON_SIZE);
        minusButton.setPreferredSize(BUTTON_SIZE);

        //메뉴 수량 증감 버튼에 이벤트 리스너 지정
        plusButton.addActionListener(new OrderQuantityButtonListener(menu, quantityLabel));
        minusButton.addActionListener(new OrderQuantityButtonListener(menu, quantityLabel));

        orderPanel.add(menuImageLabel);
        orderPanel.add(nameLabel);
        orderPanel.add(priceLabel);
        orderPanel.add(plusButton);
        orderPanel.add(quantityLabel);
        orderPanel.add(minusButton);

        this.add(orderPanel);

        TOTAL_PRICE += menu.getPrice();
        orderResultPanel.setPricePanel(TOTAL_PRICE);

        //화면에 다시 그리기
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

    private String getMenuName(JPanel jPanel) {
        Component[] panelComponents = jPanel.getComponents();
        return ((JLabel) panelComponents[1]).getText(); //index 1은 메뉴 이름을 나타냄.
    }

    private class OrderQuantityButtonListener implements ActionListener {
        private Menu menu;
        private JLabel quantityLabel;

        public OrderQuantityButtonListener(Menu menu, JLabel quantityLabel) {
            this.menu = menu;
            this.quantityLabel = quantityLabel;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            //현재 수량을 가져온다.
            int quantity = Integer.parseInt(quantityLabel.getText());

            if (e.getActionCommand().equals("+")) {
                //수량을 증가시킨다.
                quantityLabel.setText(String.valueOf(quantity + 1));
                //수량만큼 가격을 증가시킨다.
                updateTotalPrice(menu.getPrice());
            } else if (e.getActionCommand().equals("-")) {
                if (quantity > 1) {
                    //수량을 감소시킨다.
                    quantityLabel.setText(String.valueOf(quantity - 1));
                    //수량만큼 가격을 감소시킨다.
                    updateTotalPrice(-menu.getPrice());
                }

                //수량이 1이면 주문서에서 제거한다.
                if (quantity == 1) {
                    updateTotalPrice(-menu.getPrice());
                    removeOrderPanel((JPanel) quantityLabel.getParent());
                }
            }
        }
    }


}
