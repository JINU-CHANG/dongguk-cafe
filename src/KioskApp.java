import panel.centerPanel.KioskCenterPanel;
import panel.topPanel.KioskTopPanel;

import javax.swing.*;
import java.awt.*;
public class KioskApp extends JFrame {

    public KioskApp() {
        //기본 프레임 설정
        setTitle("Kiosk App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 프로세스까지 삭제
        setSize(1000, 1200);

        //키오스크 패널 생성
        KioskTopPanel topPanel = new KioskTopPanel();
        KioskCenterPanel centerPanel = new KioskCenterPanel();

        //프레임에 패널 추가
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(topPanel, BorderLayout.NORTH);
        c.add(centerPanel, BorderLayout.CENTER);

        // 프레임을 보이도록 설정
        setVisible(true);
    }

    public static void main(String[] args) {
        KioskApp kioskApp = new KioskApp();
    }
}
