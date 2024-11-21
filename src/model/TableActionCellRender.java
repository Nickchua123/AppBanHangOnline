package model;

import Admin.PanelAction;
import Admin.PanelActionNd;
import User.PanelActionCart;
import User.PanelActionHome;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author dungp
 */
public class TableActionCellRender extends DefaultTableCellRenderer{

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column); 
          if (column == 6 && table.getName().equals("tableDonHang")) {
            PanelAction action = new PanelAction();
            // Thiết lập màu nền cho `PanelAction` đầu tiên
            if (!isSelected && row % 2 == 0) {
                action.setBackground(Color.WHITE);
            } else {
                action.setBackground(new Color(240, 240, 240));
            }
            return action;

        }if (column == 6  && table.getName().equals("tableHomeSales")) {
              PanelActionHome action = new PanelActionHome();
            // Thiết lập màu nền cho `PanelAction` đầu tiên
            if (!isSelected && row % 2 == 0) {
                action.setBackground(Color.WHITE);
            } else {
                action.setBackground(new Color(240, 240, 240));
            }
            return action;

        } else if(column == 5 && table.getName().equals("tableGioHang")) {
             PanelActionCart action = new PanelActionCart();
            // Thiết lập màu nền cho `PanelAction` đầu tiên
            if (!isSelected && row % 2 == 0) {
                action.setBackground(Color.WHITE);
            } else {
                action.setBackground(new Color(240, 240, 240));
            }
            return action;
        } else if (column == 4) {
            PanelActionNd action2 = new PanelActionNd();
            // Thiết lập màu nền cho `PanelAction` thứ hai
            if (!isSelected && row % 2 == 0) {
                action2.setBackground(Color.WHITE);
            } else {
                action2.setBackground(new Color(240, 240, 240));
            }
            return action2;

        } else {
            // Trả về component mặc định cho các cột khác
            return super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
        }
    }
    }
    

