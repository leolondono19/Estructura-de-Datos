import javax.swing.JPanel;
import java.sql.*;
import javax.swing.JLabel;
import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Productos.Laptop;
import Productos.Monitor;
import Productos.Pc;
import Productos.Raton;
import Productos.Teclado;

public class Page1 extends JPanel {

	private static final long serialVersionUID = 1L;
	Connection connection;
	private Panel panelTablas;
	MonitoresPanel monitoresPanel = new MonitoresPanel();
	TecladosPanel tecladosPanel = new TecladosPanel();
	GestionProductos gestionProductos = new GestionProductos(connection);
	LaptopsPanel laptopsPanel = new LaptopsPanel(gestionProductos);
	RatonesPanel ratonesPanel = new RatonesPanel();
	PcPanel pcPanel = new PcPanel();
	
	public Page1() {
		setOpaque(false);
		setBackground(Color.WHITE);
		setSize(1221, 800);
		setLayout(new BorderLayout(0, 0));
		Menu menu = new Menu();
		menu.setPreferredSize(new Dimension(290, 800));
		add(menu, BorderLayout.WEST);
		menu.setLayout(null);
		
		JPanel logoPanel = new JPanel();
		logoPanel.setBounds(0, 0, 290, 100);
		menu.add(logoPanel);
		logoPanel.setOpaque(false);
		logoPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("GAMING STORE");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Rockwell Condensed", Font.ITALIC, 40));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Treetog-Junior-Computer-ok.64 (1).png"));
		lblNewLabel.setBounds(10, 10, 280, 80);
		logoPanel.add(lblNewLabel);
		
		JButton btnMonitors = new JButton("MONITORES");
		btnMonitors.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pcPanel.setVisible(false);
				laptopsPanel.setVisible(false);
				panelTablas.setVisible(false);
				tecladosPanel.setVisible(false);
				ratonesPanel.setVisible(false);
				llenarMonitores();
				add(monitoresPanel);
				monitoresPanel.setVisible(true);
				revalidate();
			}
		});
		btnMonitors.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnMonitors.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Custom-Icon-Design-Flatastic-11-Monitor.48.png"));
		btnMonitors.setBounds(10, 110, 270, 79);
		btnMonitors.setOpaque(false);
		menu.add(btnMonitors);
		
		JButton btnTeclados = new JButton("TECLADOS");
		btnTeclados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pcPanel.setVisible(false);
				ratonesPanel.setVisible(false);
				laptopsPanel.setVisible(false);
				panelTablas.setVisible(false);
				monitoresPanel.setVisible(false);
				llenarTeclados();
				add(tecladosPanel);
				tecladosPanel.setVisible(true);
				revalidate();
			}
		});
		btnTeclados.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Google-Noto-Emoji-Objects-62829-keyboard.48.png"));
		btnTeclados.setOpaque(false);
		btnTeclados.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnTeclados.setBounds(10, 199, 270, 79);
		menu.add(btnTeclados);
		
		JButton btnMouse = new JButton("MOUSE");
		btnMouse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pcPanel.setVisible(false);
				panelTablas.setVisible(false);
				monitoresPanel.setVisible(false);
				tecladosPanel.setVisible(false);
				laptopsPanel.setVisible(false);
				llenarRatones();
				add(ratonesPanel);
				ratonesPanel.setVisible(true);
				revalidate();
			}
		});
		btnMouse.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Icons8-Windows-8-Computer-Hardware-Mouse.48.png"));
		btnMouse.setOpaque(false);
		btnMouse.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnMouse.setBounds(10, 288, 270, 79);
		menu.add(btnMouse);
		
		JButton btnPcEscritorio = new JButton("PC ESCRITORIO");
		btnPcEscritorio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ratonesPanel.setVisible(false);
				panelTablas.setVisible(false);
				monitoresPanel.setVisible(false);
				tecladosPanel.setVisible(false);
				laptopsPanel.setVisible(false);
				llenarPc();
				add(pcPanel);
				pcPanel.setVisible(true);
				revalidate();
			}
		});
		btnPcEscritorio.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Fasticon-Servers-Server.48.png"));
		btnPcEscritorio.setOpaque(false);
		btnPcEscritorio.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnPcEscritorio.setBounds(10, 377, 270, 79);
		menu.add(btnPcEscritorio);
		
		JButton btnLaptops = new JButton("LAPTOPS");
		btnLaptops.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pcPanel.setVisible(false);
				ratonesPanel.setVisible(false);
				panelTablas.setVisible(false);
				monitoresPanel.setVisible(false);
				tecladosPanel.setVisible(false);
				llenarLaptops();
				add(laptopsPanel);
				laptopsPanel.setVisible(true);
				revalidate();
			}
		});
		btnLaptops.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Microsoft-Fluentui-Emoji-3d-Laptop-3d.48.png"));
		btnLaptops.setOpaque(false);
		btnLaptops.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		btnLaptops.setBounds(10, 466, 270, 79);
		menu.add(btnLaptops);
		
		panelTablas = new Panel();
		add(panelTablas, BorderLayout.CENTER);
		panelTablas.setLayout(null);
		
	}
	
	public void llenarMonitores() {
		String[] columnNames = {"Marca", "Modelo", "Precio", "Stock", "Descripcion", "Tamaño Pantalla", "Resolucion", "Tipo Panel", "HDMI", "Garantia"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		ResultSet rs;
		try {
			Monitor.setConnection(connection);
			rs = Monitor.obtenerDatos();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getString("precio"),
						rs.getString("stock"),
						rs.getString("descripcion"),
						rs.getString("tamaño_pantalla"),
						rs.getString("resolucion"),
						rs.getString("tipo_panel"),
						rs.getString("hdmi"),
						rs.getString("garantia_meses")
				});
			}
			monitoresPanel.getMonitoresTabla().setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarTeclados() {
		String[] columnNames = {"Marca", "Modelo", "Precio", "Stock", "Descripcion", "Tipo Conexion", "Retroiluminacion", "Teclas Programables", "Garantia"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		ResultSet rs;
		try {
			Teclado.setConnection(connection);
			rs = Teclado.obtenerDatos();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getString("precio"),
						rs.getString("stock"),
						rs.getString("descripcion"),
						rs.getString("tipo_conexion"),
						rs.getString("retroiluminacion"),
						rs.getString("teclas_programables"),
						rs.getString("garantia_meses")
				});
			}
			tecladosPanel.getTecladosTabla().setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarLaptops() {
		String[] columnNames = {"Marca", "Modelo", "Precio", "Stock", "Descripcion", "Pantalla Pulgadas", "Procesador", "Memoria Ram", "Almacenamiento", "Tarjeta Grafica", "Sistema Operativo", "Peso Kg", "Garantia"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		ResultSet rs;
		try {
			Laptop.setConnection(connection);
			rs = Laptop.obtenerDatos();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getString("precio"),
						rs.getString("stock"),
						rs.getString("descripcion"),
						rs.getString("pantalla_pulgadas"),
						rs.getString("procesador"),
						rs.getString("memoria_ram"),
						rs.getString("almacenamiento"),
						rs.getString("tarjeta_grafica"),
						rs.getString("sistema_operativo"),
						rs.getString("pesokg"),
						rs.getString("garantia_meses")
				});
			}
			laptopsPanel.getLaptopsTabla().setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarRatones() {
		String[] columnNames = {"Marca", "Modelo", "Precio", "Stock", "Descripcion", "Tipo Conexion", "DPI", "Botones Programables", "Tipo Sensor", "Garantia"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		ResultSet rs;
		try {
			Raton.setConnection(connection);
			rs = Raton.obtenerDatos();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getString("precio"),
						rs.getString("stock"),
						rs.getString("descripcion"),
						rs.getString("tipo_conexion"),
						rs.getString("dpi"),
						rs.getString("botones_programables"),
						rs.getString("tipo_sensor"),
						rs.getString("garantia_meses")
				});
			}
			ratonesPanel.getRatonesTabla().setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarPc() {
		String[] columnNames = {"Marca", "Modelo", "Precio", "Stock", "Descripcion", "Procesador", "Memoria Ram", "Almacenamiento", "Tarjeta Grafica", "Sistema Operativo", "Garantia"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columnNames);
		ResultSet rs;
		try {
			Pc.setConnection(connection);
			rs = Pc.obtenerDatos();
			while(rs.next()) {
				model.addRow(new Object[] {
						rs.getString("marca"),
						rs.getString("modelo"),
						rs.getString("precio"),
						rs.getString("stock"),
						rs.getString("descripcion"),
						rs.getString("procesador"),
						rs.getString("memoria_ram"),
						rs.getString("almacenamiento"),
						rs.getString("tarjeta_grafica"),
						rs.getString("sistema_operativo"),
						rs.getString("garantia_meses")
				});
			}
			pcPanel.getPcTabla().setModel(model);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	protected void paintComponent(Graphics grphcs) {
		Graphics2D g2 = (Graphics2D) grphcs;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON );
		g2.setColor(getBackground());
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
		super.paintComponent(grphcs);
	}
	
	public void setConnection(Connection conn)
	{
		connection = conn;
	}
	
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}

	
