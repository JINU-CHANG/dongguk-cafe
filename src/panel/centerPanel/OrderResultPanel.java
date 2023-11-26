package panel.centerPanel;

import javax.swing.*;
import java.awt.*;

public class OrderResultPanel extends JPanel {
    private static final LayoutManager ORDER_RESULT_LAYOUT = new BorderLayout();
    private static final Color ORDER_RESULT_COLOR = Color.WHITE;
    private JPanel pricePanel;

    public OrderResultPanel() {
        this.setLayout(ORDER_RESULT_LAYOUT);
        this.setBackground(ORDER_RESULT_COLOR);

        setPricePanel(0);
    }

    public void setPricePanel(int totalPrice) {
        JPanel pricePanel = new JPanel(new FlowLayout());
        pricePanel.setBackground(Color.WHITE);

        JLabel priceStringLabel = new JLabel("총금액 : " + totalPrice);
        pricePanel.add(priceStringLabel);

        this.add(pricePanel, BorderLayout.SOUTH);
    }

}
