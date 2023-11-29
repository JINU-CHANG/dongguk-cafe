package panel.centerPanel;
import menu.Menu;
import panel.util.ImageConvertor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class OrderListPanel extends JPanel {
    private static final Dimension BUTTON_SIZE = new Dimension(35, 20);
    private static final Font ORDER_LIST_FONT = new Font("Serif", Font.BOLD, 15);
    private OrderResultPanel orderResultPanel;

    public OrderListPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(Color.WHITE);

        orderResultPanel = new OrderResultPanel(this);
    }

    public OrderResultPanel getOrderResultPanel() {
        return orderResultPanel;
    }

    public boolean isMenuAlreadyOrdered(Menu input) {
        //리스트들을 순회하면서 중복된 이름이 있으면 true, 없으면 false를 반환한다.
        for (Component component : this.getComponents()) {
            String menuName = getMenuName((JPanel) component);

            if (menuName.equals(input.getName())) {
                return true;
            }
        }

        return false;
    }

    public void addOrderMenu(Menu menu) {
        //주문 패널 생성
        JPanel orderPanel = new JPanel(new FlowLayout());
        orderPanel.setBackground(Color.WHITE);
        orderPanel.setMaximumSize(new Dimension(350, 50));

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

        orderResultPanel.updatePrice(menu.getPrice());

        //화면에 다시 그리기
        this.revalidate();
        this.repaint();
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

    public List<String> getOrderDetails() {
        List<String> details = new ArrayList<>();

        for (Component component : this.getComponents()) {
                JPanel orderMenuDetailsPanel = (JPanel) component;
                Component[] components = orderMenuDetailsPanel.getComponents();

                // Assuming the components array has at least 5 elements
                Component name = components[1];
                Component price = components[2];
                Component quantity = components[4];

                // Extracting text from JLabels (assuming these components are JLabels)
                String nameText = ((JLabel) name).getText();
                String priceText = ((JLabel) price).getText();
                String quantityText = ((JLabel) quantity).getText();

                // Creating a string with the extracted information
                String detailString = nameText + " " + priceText + " " + quantityText + "개";

                details.add(detailString);
            }
        return details;
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
                orderResultPanel.updatePrice(menu.getPrice());
            } else if (e.getActionCommand().equals("-")) {
                if (quantity > 1) {
                    //수량을 감소시킨다.
                    quantityLabel.setText(String.valueOf(quantity - 1));
                    //수량만큼 가격을 감소시킨다.
                    orderResultPanel.updatePrice(-menu.getPrice());
                }

                //수량이 1이면 주문서에서 제거한다.
                if (quantity == 1) {
                    orderResultPanel.updatePrice(-menu.getPrice());
                    removeOrderPanel((JPanel) quantityLabel.getParent());
                }
            }
        }
    }


}
