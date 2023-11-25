import topPanel.KioskTopPanel;

import javax.swing.*;
import java.awt.*;
public class KioskApp extends JFrame {

    public KioskApp() {
        //기본 프레임 설정
        setTitle("Kiosk App");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //종료시 프로세스까지 삭제
        setSize(1000, 1200);

        //투썸 로고 보여주는 패널 생성
        KioskTopPanel topPanel = new KioskTopPanel();

        //프레임에 패널 추가
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        c.add(topPanel, BorderLayout.NORTH);

        // 프레임을 보이도록 설정
        setVisible(true);
    }

    public static void main(String[] args) {
        KioskApp kioskApp = new KioskApp();
    }
}
