package panel.centerPanel;

import panel.util.PanelCreator;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.util.List;

import static panel.centerPanel.MenuPanel.TOTAL_PRICE;

public class ReceiptPanel extends JPanel {

    public ReceiptPanel(List<String> orderDetails) {
        this.setLayout(new BorderLayout());

        setReceiptTopPanel();
        setReceiptCenterPanel(orderDetails);
        setReceiptBottomPanel();
    }

    private void setReceiptTopPanel() {
        //수직 정렬 레이아웃 지정
        JPanel topPanel = PanelCreator.createYAxisAlignedPanel();

        JLabel receiptText = new JLabel("<영수증>");
        JLabel localDate = new JLabel(LocalDate.now().toString());

        //가운데 정렬
        receiptText.setAlignmentX(Component.CENTER_ALIGNMENT);
        localDate.setAlignmentX(Component.CENTER_ALIGNMENT);

        topPanel.add(receiptText);
        topPanel.add(localDate);

        this.add(topPanel, BorderLayout.NORTH);
    }

    private void setReceiptCenterPanel(List<String> orderDetails) {
        JPanel centerPanel = PanelCreator.createYAxisAlignedPanel();

        for (String detail : orderDetails) {
            JLabel label = new JLabel(detail);

            //가운데 정렬
            label.setAlignmentX(Component.CENTER_ALIGNMENT);

            centerPanel.add(label);
            centerPanel.add(Box.createVerticalStrut(20)); //여백 지정
        }

        centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        this.add(centerPanel, BorderLayout.CENTER);
    }

    private void setReceiptBottomPanel() {
        JPanel bottomPanel = PanelCreator.createYAxisAlignedPanel();

        JLabel totalPrice = new JLabel("총 결제 금액 : " + TOTAL_PRICE);
        JLabel at = new JLabel("투썸 플레이스 동국대점");

        //가운데 정렬
        totalPrice.setAlignmentX(Component.CENTER_ALIGNMENT);
        at.setAlignmentX(Component.CENTER_ALIGNMENT);

        bottomPanel.add(totalPrice);
        bottomPanel.add(at);

        this.add(bottomPanel, BorderLayout.SOUTH);
    }
}
