package panel.topPanel;

import javax.swing.*;
import java.awt.*;

public class KioskTopPanel extends JPanel {
    private static final FlowLayout TOP_LAYOUT = new FlowLayout(FlowLayout.CENTER, 20,20);
    private static final Color TOP_PANEL_COLOR = new Color(177, 33, 24);
    private static final Dimension TOP_PANEL_SIZE = new Dimension(1000, 140);

    private JPanel innerPanel;
    private JPanel logoPanel;

    public KioskTopPanel() {
        //패널 레이아웃, 배경색, 사이즈 설정
        this.setLayout(TOP_LAYOUT);
        this.setBackground(TOP_PANEL_COLOR);
        this.setPreferredSize(TOP_PANEL_SIZE);

        //내부 패널 설정
        setInnerPanel();
        setLogoPanel();
    }

    public void setInnerPanel() {
        innerPanel = new InnerPanel();
        this.add(innerPanel);
    }

    public void setLogoPanel() {
        logoPanel = new LogoPanel();
        innerPanel.add(logoPanel);
    }
}
