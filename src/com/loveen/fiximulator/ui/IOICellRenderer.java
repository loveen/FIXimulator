/*
 * File     : IOICellRenderer.java
 *
 * Author   : Zoltan Feledy
 * 
 * Contents : This renderer is used on the JTable that displays IOI 
 *            messages and colors the messages based on their types.
 * 
 */

package com.loveen.fiximulator.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class IOICellRenderer  extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        int myRow = table.convertRowIndexToModel(row);
        Component component = super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus, myRow, column);
        String type = (String) table.getModel()
                .getValueAt(myRow, 1);
        if (type.equals("NEW")) {
            component.setForeground(Color.BLACK);
        }
        if (type.equals("CANCEL")) {
            component.setForeground(Color.RED);
        }
        if (type.equals("REPLACE")) {
            component.setForeground(Color.BLUE);
        }
        return component;
    }        
}
