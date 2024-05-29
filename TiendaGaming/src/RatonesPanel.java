import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class RatonesPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable ratonesTabla = new JTable();
	
	public JTable getRatonesTabla() {
		return ratonesTabla;
	}

	public void setRatonesTabla(JTable ratonesTabla) {
		this.ratonesTabla = ratonesTabla;
	}
	
	public RatonesPanel() {
		setLayout(null);
		ratonesTabla.getPreferredScrollableViewportSize();
		ratonesTabla.setPreferredSize(new Dimension(700, 800));
		ratonesTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		ratonesTabla.setRowHeight(50);

		
		JLabel lblNewLabel = new JLabel("RATONES");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(490, 5, 225, 55);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1210, 700));
		scrollPane.setBounds(10, 70, 1210, 700);
		add(scrollPane);
		ratonesTabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		scrollPane.setViewportView(ratonesTabla);
	}

}
