package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class JPTableElements extends JPanel {

    private static final long serialVersionUID = 1L;
    private static final String[] identifiers = {"Posicion", "Palabra", "Valor"};


    private DefaultTableModel dtmElements;
    private JTable jtElements;
    private JScrollPane jspTable;

    public JPTableElements() {
        initComponents();
    }


    public DefaultTableModel getDtmElements() {
        return dtmElements;
    }

    public void setDtmElements(DefaultTableModel dtmElements) {
        this.dtmElements = dtmElements;
    }


    private void initComponents() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        dtmElements = new DefaultTableModel() {

            private static final long serialVersionUID = 1L;

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        dtmElements.setColumnIdentifiers(identifiers);
        jtElements = new JTable();
        jtElements.setIntercellSpacing(new Dimension(0, 0));

        jtElements.setShowVerticalLines(false);
        jtElements.setFocusable(false);
        jtElements.getTableHeader().setResizingAllowed(false);
        jtElements.setBackground(Color.WHITE);
        jtElements.getTableHeader().setPreferredSize(new Dimension(0, 25));
        jtElements.getTableHeader().setBackground(new Color(0,87,187));
        jtElements.getTableHeader().setForeground(Color.WHITE);
        jtElements.getTableHeader().setOpaque(false);

        jtElements.setRowHeight(25);
        jtElements.setBorder(null);
        jtElements.setSelectionBackground(new Color(129, 212, 250));
        jtElements.setModel(dtmElements);

        jspTable = new JScrollPane(jtElements);
        jspTable.setForeground(Color.WHITE);
        jspTable.setBorder(null);
        this.add(jspTable, BorderLayout.PAGE_END);

        centerTextInCell();
        this.setBorder(null);

    }


    public void refresh(Object[][] vector) {
        cleanRowsTable();
        for (int i = 0; i < vector.length; i++) {
            if (i < 10 ) {
                addElementToTable(vector[i]);
            }
        }
    }

    public void addElementToTable(Object[] vector) {
        dtmElements.addRow(vector);
        centerTextInCell();
    }

    public void cleanRowsTable() {
        dtmElements.setNumRows(0);
    }

    private void centerTextInCell() {
        DefaultTableCellRenderer centerModel = new DefaultTableCellRenderer();
        centerModel.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < dtmElements.getColumnCount(); i++) {
            jtElements.getColumnModel().getColumn(i).setCellRenderer(centerModel);
        }
    }
}
