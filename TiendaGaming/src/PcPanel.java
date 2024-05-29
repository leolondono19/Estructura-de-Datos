import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class PcPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable pcTabla = new JTable();
	
	public JTable getPcTabla() {
		return pcTabla;
	}

	public void setPcTabla(JTable pcTabla) {
		this.pcTabla = pcTabla;
	}
	
	public PcPanel() {
		setLayout(null);
		pcTabla.getPreferredScrollableViewportSize();
		pcTabla.setPreferredSize(new Dimension(700, 800));
		pcTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		pcTabla.setRowHeight(50);

		
		JLabel lblNewLabel = new JLabel("PCs ESCRITORIO");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(490, 5, 322, 55);
		add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(1210, 700));
		scrollPane.setBounds(10, 70, 1210, 700);
		add(scrollPane);
		pcTabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		scrollPane.setViewportView(pcTabla);
	}

}
