package panel.topPanel;

import javax.swing.*;
import java.awt.*;

public class KioskTopPanel extends JPanel {
    public KioskTopPanel() {
        //패널 레이아웃, 배경색, 사이즈 설정
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20,20));
        this.setBackground(new Color(177, 33, 24));
        this.setPreferredSize(new Dimension(1000, 140));

        //내부 패널 설정
        setInnerPanel();
    }

    public void setInnerPanel() {
        //로고를 담기 위한 내부 패널 생성
        InnerPanel innerPanel = new InnerPanel();
        this.add(innerPanel);
    }
}
