package panel.centerPanel;

import panel.ImageSizeConvertor;

import javax.swing.*;
import java.awt.*;

public class OrderTopPanel extends JPanel{
    private static final LayoutManager ORDER_TOP_PANEL = new FlowLayout();
    private static final Color ORDER_TOP_COLOR = Color.WHITE;
    private static final String ORDER_TOP_TEXT = "Orders";
    private static final Font ORDER_TOP_FONT = new Font("Serif", Font.BOLD, 20);

    public OrderTopPanel() {
        this.setLayout(ORDER_TOP_PANEL);
        this.setBackground(ORDER_TOP_COLOR);

        JLabel orderLabel = new JLabel(ORDER_TOP_TEXT);
        orderLabel.setFont(ORDER_TOP_FONT);

        this.add(orderLabel);
    }
}
