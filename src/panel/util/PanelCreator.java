package panel.util;

import javax.swing.*;

public class PanelCreator {
    public static JPanel createYAxisAlignedPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        return panel;
    }
}
