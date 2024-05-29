import Productos.Laptop;
import Productos.Producto;


import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

public class LaptopsPanel extends JPanel {
    private static final long serialVersionUID = 1L;
    private JTable laptopsTabla = new JTable();
    private GestionProductos gestionProductos;

    public JTable getLaptopsTabla() {
		return laptopsTabla;
	}

	public void setLaptopsTabla(JTable laptopsTabla) {
		this.laptopsTabla = laptopsTabla;
	}
    
    public LaptopsPanel(GestionProductos gestion) {
        this.gestionProductos = gestion;
        setLayout(null);
        laptopsTabla.getPreferredScrollableViewportSize();
        laptopsTabla.setPreferredSize(new Dimension(700, 800));
        laptopsTabla.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        laptopsTabla.setRowHeight(50);

        JLabel lblNewLabel = new JLabel("LAPTOPS");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
        lblNewLabel.setBounds(490, 5, 225, 55);
        add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setPreferredSize(new Dimension(1210, 700));
        scrollPane.setBounds(10, 70, 1210, 700);
        add(scrollPane);
        laptopsTabla.setFont(new Font("Tahoma", Font.PLAIN, 20));
        scrollPane.setViewportView(laptopsTabla);

        JButton agregarButton = new JButton("Agregar Laptop");
        agregarButton.setBounds(10, 780, 150, 30);
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Producto laptop = new Laptop(null, "Laptop Gaming", 1500.0f, "MarcaX", "ModeloY", 10, 24, 15.6f, 2.5f, "Intel i7", 16, "512GB SSD", "NVIDIA GTX 1650", "Windows 10");
                gestionProductos.agregarProducto(laptop);
                System.out.println("Laptop agregada: " + laptop);
            }
        });
        add(agregarButton);
    }
}
