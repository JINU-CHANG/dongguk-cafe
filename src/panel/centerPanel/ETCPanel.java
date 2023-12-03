package panel.centerPanel;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ETCPanel extends JPanel {
    private JLabel colorLabel;
    private JSlider [] sl = new JSlider [3];

    public ETCPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        colorLabel = new JLabel(" SLIDER EXAMPLE ");
        for (int i = 0; i < sl.length; i++) {
            sl[i] = new JSlider(JSlider.HORIZONTAL, 0, 255, 128);
            sl[i].setPaintLabels(true); //라벨을 그린다.
            sl[i].setPaintTicks(true); //눈금을 그린다.
            sl[i].setPaintTrack(true); //트랙을 그린다.
            sl[i].setMajorTickSpacing(50); //주눈금의 간격을 지정한다.
            sl[i].setMinorTickSpacing(10); //보조눈금의 간격을 지정한다.
            sl[i].addChangeListener(new MyChangeListener()); //배경색을 바꿀 이벤트 리스너를 지정한다.
            add(sl[i]);
        }


        //컴포넌트의 전경색상을 지정한다.
        sl[0].setForeground(Color.RED);
        sl[1].setForeground(Color.GREEN);
        sl[2].setForeground(Color.BLUE);

        int r = sl[0].getValue();
        int g = sl[1].getValue();
        int b = sl[2].getValue();

        colorLabel.setOpaque(true);
        colorLabel.setBackground(new Color(r,g,b));
        this.add(colorLabel);
    }

    //슬라이더의 색을 가져와 배경색을 지정하는 이벤트 리스너
    class MyChangeListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            int r = sl[0].getValue();
            int g = sl[1].getValue();
            int b = sl[2].getValue();
            colorLabel.setBackground(new Color(r,g,b));
        }
    }
}
