package panel.centerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuTopPanel extends JPanel {
    private MenuPanel menuPanel;
    public MenuTopPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;

        JButton[] categoryButtons = new JButton[]{
                new JButton("Coffee"),
                new JButton("Drinks"),
                new JButton("Cake")
        };

        for (JButton button : categoryButtons) {
            add(button);
            button.addActionListener(new CategoryButtonActionListener(button.getText()));
        }
    }

    private class CategoryButtonActionListener implements ActionListener {
        private String category;

        public CategoryButtonActionListener(String category) {
            this.category = category;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            menuPanel.setMenuCategory(category);
        }
    }
}
