/*
 * File     : IOITableModel.java
 *
 * Author   : Zoltan Feledy
 * 
 * Contents : This class is the TableModel for the IOI Table.
 * 
 */

package com.loveen.fiximulator.ui;

import com.loveen.fiximulator.core.FIXimulator;
import com.loveen.fiximulator.core.IOI;
import com.loveen.fiximulator.core.IOIset;

import javax.swing.table.AbstractTableModel;

public class IOITableModel extends AbstractTableModel {
    private static IOIset iois = FIXimulator.getApplication().getIOIs();
    private static String[] columns = 
        {"ID", "Type", "Side", "Shares", "Symbol", "Price", 
         "SecurityID", "IDSource", "Natural", "RefID"}; 
    

    public IOITableModel(){
        FIXimulator.getApplication().getIOIs().addCallback(this);
    }
    
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }
    
    @Override
    public Class getColumnClass(int column) {
        if (column == 3) return Double.class;
        if (column == 5) return Double.class;
        return String.class;
    }

    public int getRowCount() {
        return iois.getCount();
    }

    public Object getValueAt(int row, int column) {
        IOI ioi = iois.getIOI(row);
        if (column == 0) return ioi.getID();
        if (column == 1) return ioi.getType();
        if (column == 2) return ioi.getSide();
        if (column == 3) return ioi.getQuantity();
        if (column == 4) return ioi.getSymbol();
        if (column == 5) return ioi.getPrice();
        if (column == 6) return ioi.getSecurityID();
        if (column == 7) return ioi.getIDSource();
        if (column == 8) return ioi.getNatural();
        if (column == 9) return ioi.getRefID();
        return new Object();
    }
    
    public void update() {
        fireTableDataChanged();
    }
}
