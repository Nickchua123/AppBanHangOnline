
package model;

import Admin.PanelAction;
import Admin.PanelActionNd;
import User.PanelActionCart;
import User.PanelActionHome;
import java.awt.Component;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JTable;


public class TableActionCellEditor extends DefaultCellEditor{
    private TableActionEvent event;
    private TableActionEventNd eventNd;
     private TableActionEventHomeSales eventHome;
    private  TableActionEventGioHang eventGioHang;
    public TableActionCellEditor(TableActionEvent event) {
        super(new JCheckBox());
        this.event = event;
    }
    public TableActionCellEditor(TableActionEventNd eventNd) {
        super(new JCheckBox());
        this.eventNd = eventNd;
    }
     public TableActionCellEditor(TableActionEventHomeSales eventHome) {
        super(new JCheckBox());
        this.eventHome = eventHome;
    }
   
    public TableActionCellEditor(TableActionEventGioHang eventGioHang) {
        super(new JCheckBox());
        this.eventGioHang = eventGioHang;
    }
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
      if (column == 6 && table.getName().equals("tableDonHang")) {
        PanelAction action1 = new PanelAction();
        action1.initEvent(event, row);
        action1.setBackground(table.getSelectionBackground());
        return action1;

    }else if (column == 6 && table.getName().equals("tableHomeSales")) {
        PanelActionHome action = new PanelActionHome();
        action.initEvent(eventHome, row);
        action.setBackground(table.getSelectionBackground());
        return action;

    

    } else if (column == 5 && table.getName().equals("tableGioHang")){
        PanelActionCart action1 = new PanelActionCart();
        action1.initEvent(eventGioHang, row);
        action1.setBackground(table.getSelectionBackground());
        return action1;
    } else if (column == 4) {
          PanelActionNd action2 = new PanelActionNd(); // Giả sử bạn có PanelAction2 cho cột khác
        action2.initEvent(eventNd, row);
        action2.setBackground(table.getSelectionBackground());
        return action2;

    } else {
        // Trả về thành phần mặc định cho các cột khác
        return super.getTableCellEditorComponent(table, value, isSelected, row, column);
    }
    }
    
}
