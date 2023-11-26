package panel.topPanel;

import javax.swing.*;
import java.awt.*;

public class LogoPanel extends JPanel {
    private static final Color LOGO_PANEL_COLOR = new Color(35, 24, 22);
    private static final String LOGO_TOP_TEXT = "A TWOSOME PLACE";
    private static final Font LOGO_TOP_FONT = new Font("Serif", Font.BOLD, 30);
    private static final String LOGO_BOTTOM_TEXT = "COFFEE & DESSERT";
    private static final Font LOGO_BOTTOM_FONT = new Font("Serif", Font.PLAIN, 25);

    public LogoPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(LOGO_PANEL_COLOR);

        JLabel nameTopLabel = new JLabel(LOGO_TOP_TEXT);
        JLabel nameBelowLabel = new JLabel(LOGO_BOTTOM_TEXT);

        //글자 수직 & 수평 정렬되도록 설정
        nameTopLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameBelowLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        //뒷배경 설정
        nameTopLabel.setForeground(Color.WHITE);
        nameBelowLabel.setForeground(Color.WHITE);

        //글자색 설정
        nameTopLabel.setFont(LOGO_TOP_FONT);
        nameBelowLabel.setFont(LOGO_BOTTOM_FONT);

        this.add(nameTopLabel, BorderLayout.NORTH);
        this.add(nameBelowLabel, BorderLayout.CENTER);
    }
}
