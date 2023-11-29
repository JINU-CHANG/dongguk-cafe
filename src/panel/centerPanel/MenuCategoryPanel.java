package panel.centerPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuCategoryPanel extends JPanel {
    private MenuPanel menuPanel;
    public MenuCategoryPanel(MenuPanel menuPanel) {
        this.menuPanel = menuPanel;

        setCategoryButton();
    }

    private void setCategoryButton() {
        JButton[] categoryButtons = new JButton[]{
                new JButton("Coffee"),
                new JButton("Drinks"),
                new JButton("Cake")
        };

        for (JButton button : categoryButtons) {
            this.add(button);
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
