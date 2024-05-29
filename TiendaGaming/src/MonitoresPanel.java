import javax.swing.*;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MonitoresPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable monitoresTabla = new JTable();
	
	
	public JTable getMonitoresTabla() {
		return monitoresTabla;
	}

	public void setMonitoresTabla(JTable monitoresTabla) {
		this.monitoresTabla = monitoresTabla;
	}


	public MonitoresPanel() {
		setLayout(null);
		monitoresTabla.getPreferredScrollableViewportSize();
		monitoresTabla.setPreferredSize(new Dimension(700, 800));
		monitoresTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		monitoresTabla.setRowHeight(50);

		
		JLabel lblNewLabel = new JLabel("MONITORES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(490, 5, 225, 55);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1210, 700));
		scrollPane.setBounds(10, 70, 1210, 700);
		add(scrollPane);
		monitoresTabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		scrollPane.setViewportView(monitoresTabla);

	}
}
