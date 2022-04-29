/*
 * Created by JFormDesigner on Fri Apr 29 14:41:32 CEST 2022
 */

package password.manager.window;

import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
 * @author unknown
 */
public class MainMenu extends JFrame {
    public MainMenu() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        ResourceBundle bundle = ResourceBundle.getBundle("password.manager.window.resources.MainFrame");
        tabbedPane1 = new JTabbedPane();
        panel1 = new JPanel();
        label2 = new JLabel();
        button1 = new JButton();

        //======== this ========
        setMinimumSize(new Dimension(650, 350));
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("PasswordManager");
        var contentPane = getContentPane();
        contentPane.setLayout(null);

        //======== tabbedPane1 ========
        {

            //======== panel1 ========
            {
                panel1.setLayout(null);

                //---- label2 ----
                label2.setText(bundle.getString("MainMenu.label2.text"));
                panel1.add(label2);
                label2.setBounds(0, 0, 160, 30);

                //---- button1 ----
                button1.setText(bundle.getString("MainMenu.button1.text"));
                panel1.add(button1);
                button1.setBounds(new Rectangle(new Point(360, 145), button1.getPreferredSize()));

                {
                    // compute preferred size
                    Dimension preferredSize = new Dimension();
                    for(int i = 0; i < panel1.getComponentCount(); i++) {
                        Rectangle bounds = panel1.getComponent(i).getBounds();
                        preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                        preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
                    }
                    Insets insets = panel1.getInsets();
                    preferredSize.width += insets.right;
                    preferredSize.height += insets.bottom;
                    panel1.setMinimumSize(preferredSize);
                    panel1.setPreferredSize(preferredSize);
                }
            }
            tabbedPane1.addTab(bundle.getString("MainMenu.panel1.tab.title"), panel1);
        }
        contentPane.add(tabbedPane1);
        tabbedPane1.setBounds(0, 0, 650, 320);

        {
            // compute preferred size
            Dimension preferredSize = new Dimension();
            for(int i = 0; i < contentPane.getComponentCount(); i++) {
                Rectangle bounds = contentPane.getComponent(i).getBounds();
                preferredSize.width = Math.max(bounds.x + bounds.width, preferredSize.width);
                preferredSize.height = Math.max(bounds.y + bounds.height, preferredSize.height);
            }
            Insets insets = contentPane.getInsets();
            preferredSize.width += insets.right;
            preferredSize.height += insets.bottom;
            contentPane.setMinimumSize(preferredSize);
            contentPane.setPreferredSize(preferredSize);
        }
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JLabel label2;
    private JButton button1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
