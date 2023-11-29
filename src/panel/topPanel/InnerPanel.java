package panel.topPanel;

import panel.util.PanelCreator;

import javax.swing.*;
import java.awt.*;

public class InnerPanel extends JPanel {
    public InnerPanel() {
        //패널 여백, 배경색, 사이즈 설정
        this.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); //위 아래 여백 생성
        this.setBackground(new Color(35, 24, 22));
        this.setPreferredSize(new Dimension(1000, 100));

        setLogoPanel();
    }

    private void setLogoPanel() {
        JPanel logoPanel = PanelCreator.createYAxisAlignedPanel();
        logoPanel.setBackground(new Color(35, 24, 22));

        setText(logoPanel);
        this.add(logoPanel);
    }

    private void setText(JPanel logoPanel) {
        //글자를 담기 위한 라벨 생성
        JLabel nameTopLabel = new JLabel("A TWOSOME PLACE");
        JLabel nameBelowLabel = new JLabel("COFFEE & DESSERT");

        //글자색 지정
        nameTopLabel.setForeground(Color.WHITE);
        nameBelowLabel.setForeground(Color.WHITE);

        //글자폰트 지정
        nameTopLabel.setFont(new Font("Serif", Font.BOLD, 30));
        nameBelowLabel.setFont(new Font("Serif", Font.PLAIN, 25));

        //수직 & 가운데 정렬
        nameTopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameBelowLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        logoPanel.add(nameTopLabel);
        logoPanel.add(nameBelowLabel);
    }
}
