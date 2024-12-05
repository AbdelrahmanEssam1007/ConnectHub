/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Zaki
 */
public class CustomCellRenderer extends  DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(
            JList<?> list,
            Object value,
            int index,
            boolean isSelected,
            boolean cellHasFocus) {
        
        Component renderer = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        if (UserDB.getInstance().searchUserByUserName((String) value).getStatus()) {
            renderer.setBackground(Color.GREEN);
        }
        else {
            renderer.setBackground(Color.RED);
        }

        // Maintain selection highlight
        if (isSelected) {
            renderer.setBackground(list.getSelectionBackground());
            renderer.setForeground(list.getSelectionForeground());
        }

        return renderer;
    }
}
