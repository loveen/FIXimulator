/*
 * File     : ExecutionCellRenderer.java
 *
 * Author   : Zoltan Feledy
 * 
 * Contents : This renderer is used on the JTable that displays 
 *            Executions and colors the executions that have received
 *            a DontKnowTrade.
 * 
 */

package com.loveen.fiximulator.ui;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

public class ExecutionCellRenderer  extends DefaultTableCellRenderer {

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, 
            boolean isSelected, boolean hasFocus, int row, int column) {
        
        int myRow = table.convertRowIndexToModel(row);
        Component component = super.getTableCellRendererComponent(table, value,
                                          isSelected, hasFocus, myRow, column);
        Boolean DKd = (Boolean) table.getModel()
                .getValueAt(myRow, 12);
                
        if ( DKd ) {
            component.setForeground(Color.RED);
        }
        if ( !DKd ) {
            component.setForeground(Color.BLACK);
        }
        return component;
    }        
}
