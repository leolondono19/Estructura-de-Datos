import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class TecladosPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable TecladosTabla = new JTable();
	
	public JTable getTecladosTabla() {
		return TecladosTabla;
	}

	public void setTecladosTabla(JTable tecladosTabla) {
		this.TecladosTabla = tecladosTabla;
	}

	public TecladosPanel() {
		setLayout(null);
		TecladosTabla.getPreferredScrollableViewportSize();
		TecladosTabla.setPreferredSize(new Dimension(700, 800));
		TecladosTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		TecladosTabla.setRowHeight(50);

		
		JLabel lblNewLabel = new JLabel("TECLADOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(490, 5, 225, 55);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1210, 700));
		scrollPane.setBounds(10, 70, 1210, 700);
		add(scrollPane);
		TecladosTabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		scrollPane.setViewportView(TecladosTabla);
	}

}
