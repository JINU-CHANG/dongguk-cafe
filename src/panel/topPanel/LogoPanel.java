package panel.topPanel;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {
    private static final Color LOGO_PANEL_COLOR = new Color(35, 24, 22);
    private static final String LOGO_TOP_TEXT = "A TWOSOME PLACE";
    private static final String LOGO_BOTTOM_TEXT = "COFFEE & DESSERT";
    private static final Font LOGO_TOP_FONT = new Font("Serif", Font.BOLD, 30);
    private static final Font LOGO_BOTTOM_FONT = new Font("Serif", Font.PLAIN, 25);

    public LogoPanel() {
        //수직&수평 정렬을 위해 BoxLayout 설정
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(LOGO_PANEL_COLOR);

        //글자를 담기 위한 라벨 생성
        JLabel nameTopLabel = new JLabel(LOGO_TOP_TEXT);
        JLabel nameBelowLabel = new JLabel(LOGO_BOTTOM_TEXT);

        //수직 & 수평 정렬
        nameTopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameBelowLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //글자색 지정
        nameTopLabel.setForeground(Color.WHITE);
        nameBelowLabel.setForeground(Color.WHITE);

        //글자폰트 지정
        nameTopLabel.setFont(LOGO_TOP_FONT);
        nameBelowLabel.setFont(LOGO_BOTTOM_FONT);

        //라벨 레이아웃 위에 추가
        this.add(nameTopLabel, BorderLayout.NORTH);
        this.add(nameBelowLabel, BorderLayout.CENTER);
    }
}
