package panel.centerPanel;

import panel.util.PanelCreator;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class OrderDetailsPanel extends JPanel {
    public OrderDetailsPanel(List<String> orderDetails) {
        setOrderDetails(orderDetails);
        this.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
    }

    public void setOrderDetails(List<String> orderDetails) {
        JPanel orderDetailsPanel = PanelCreator.createYAxisAlignedPanel();

        for (String detail : orderDetails) {
            JLabel label = new JLabel(detail);
            label.setAlignmentX(Component.CENTER_ALIGNMENT);
            orderDetailsPanel.add(label);
            orderDetailsPanel.add(Box.createVerticalStrut(20));
        }

        this.add(orderDetailsPanel);
    }
}
