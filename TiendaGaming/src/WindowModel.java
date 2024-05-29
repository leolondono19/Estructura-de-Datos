import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import net.miginfocom.swing.MigLayout;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPasswordField;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.*;

import Productos.*;
import java.io.*;
import java.sql.Connection;

public class WindowModel extends JFrame {
	
	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	private JTextField logNameTextField;
	private JPasswordField logPasswordField;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldTelefono;
	private JPasswordField passwordFieldContra;
	private JPasswordField passwordFieldConfirContra;
	private JPasswordField passwordFieldCodigo;
	
	private JComboBox comboBoxCiudad;
	private JComboBox comboBoxTipoUsuario;
	private Connection connection;
	
	SystemConfiguration configuration = new SystemConfiguration();
	
	public WindowModel() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(1139, 848);
		JPanel principalPanel = new JPanel();
		getContentPane().add(principalPanel, BorderLayout.CENTER);
		principalPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setBackground(new Color(156, 198, 79));
		principalPanel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel image = new JLabel("");
		image.setHorizontalAlignment(SwingConstants.CENTER);
		image.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Treetog-Junior-Computer-ok.64.png"));
		topPanel.add(image);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setOpaque(false);
		topPanel.add(loginPanel, BorderLayout.EAST);
		loginPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("   ");
		loginPanel.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("   ");
		loginPanel.add(lblNewLabel_1, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_2 = new JLabel("                              ");
		loginPanel.add(lblNewLabel_2, BorderLayout.EAST);
		
		JPanel panelGridLogin = new JPanel();
		panelGridLogin.setOpaque(false);
		loginPanel.add(panelGridLogin, BorderLayout.CENTER);
		panelGridLogin.setLayout(new GridLayout(2, 4, 15, 0));
		
		JLabel lblNewLabel_3 = new JLabel("Tipo de Usuario");
		panelGridLogin.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Nombre");
		panelGridLogin.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Contraseña");
		panelGridLogin.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("   ");
		panelGridLogin.add(lblNewLabel_6);
		
		JComboBox logComboBox = new JComboBox();
		logComboBox.setModel(new DefaultComboBoxModel(new String[] {"Select....", "ADMINISTRATOR", "BUYER"}));
		panelGridLogin.add(logComboBox);
		
		logNameTextField = new JTextField();
		panelGridLogin.add(logNameTextField);
		logNameTextField.setColumns(10);
		
		logPasswordField = new JPasswordField();
		panelGridLogin.add(logPasswordField);
		
		JButton btnNewButton = new JButton("LOG IN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(logComboBox.getSelectedIndex() == 1) {
					Administrador admin = new Administrador(connection);
					if (admin.EsAdministratorValido(logNameTextField.getText(), new String(logPasswordField.getPassword()))) {
								principalPanel.setVisible(false);
								Page1 page1 = new Page1();
								page1.setConnection(connection);
								getContentPane().add(page1);
								return;
							}
							else {
								JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
							}
						}
					if(logComboBox.getSelectedIndex() == 2) {
						Comprador comprador = new Comprador(connection);
						if (comprador.EsCompradorValido(logNameTextField.getText(), new String(logPasswordField.getPassword()))) {
							principalPanel.setVisible(false);
							Page1 page1 = new Page1();
							page1.setConnection(connection);
							getContentPane().add(page1);
							return;
						}
						else {
							JOptionPane.showMessageDialog(null, "CONTRASEÑA INCORRECTA");
						}
					}
				}
			}
		);
		panelGridLogin.add(btnNewButton);
		
		JPanel bottomPanel = new JPanel();
		bottomPanel.setBackground(new Color(156, 198, 79));
		principalPanel.add(bottomPanel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_7 = new JLabel("DESARROLLADO POR: LEONEE LONDOÑO");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bottomPanel.add(lblNewLabel_7);
		
		JPanel centralPanel = new JPanel();
		centralPanel.setBackground(new Color(0, 64, 128));
		principalPanel.add(centralPanel, BorderLayout.CENTER);
		centralPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel imageLogo = new JLabel("");
		imageLogo.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogo.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\6d0cb206bdfd4ab5a29b6ed893628cc1.png"));
		centralPanel.add(imageLogo);
		
		JPanel formPanel = new JPanel();
		formPanel.setPreferredSize(new Dimension(700, 300));
		centralPanel.add(formPanel, BorderLayout.EAST);
		formPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel paintBottomPanel = new JPanel();
		paintBottomPanel.setBackground(new Color(0, 64, 128));
		formPanel.add(paintBottomPanel, BorderLayout.SOUTH);
		
		JLabel enterBottomLabel = new JLabel("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		paintBottomPanel.add(enterBottomLabel);
		
		JPanel paintTopPanel = new JPanel();
		paintTopPanel.setBackground(new Color(0, 64, 128));
		formPanel.add(paintTopPanel, BorderLayout.NORTH);
		paintTopPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel enterTopLabel = new JLabel("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		paintTopPanel.add(enterTopLabel);
		
		JPanel welcomePanel = new JPanel();
		paintTopPanel.add(welcomePanel, BorderLayout.CENTER);
		welcomePanel.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("BIENVENIDO A LA MEJOR TIENDA GAMING DE TODO EL PAIS");
		lblNewLabel_12.setFont(new Font("Californian FB", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(55, 0, 574, 23);
		welcomePanel.add(lblNewLabel_12);
		
		JPanel welcomeTopPanel = new JPanel();
		welcomeTopPanel.setBackground(new Color(0, 64, 128));
		paintTopPanel.add(welcomeTopPanel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_9 = new JLabel("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		welcomeTopPanel.add(lblNewLabel_9);
		
		JPanel welcomeRightPanel = new JPanel();
		welcomeRightPanel.setBackground(new Color(0, 64, 128));
		paintTopPanel.add(welcomeRightPanel, BorderLayout.EAST);
		
		JLabel welcomeLabelSpace = new JLabel("                ");
		welcomeLabelSpace.setBackground(new Color(0, 64, 128));
		welcomeRightPanel.add(welcomeLabelSpace);
		
		JPanel welcomeBottomPanel = new JPanel();
		welcomeBottomPanel.setBackground(new Color(0, 64, 128));
		paintTopPanel.add(welcomeBottomPanel, BorderLayout.SOUTH);
		
		JLabel lblNewLabel_11 = new JLabel("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
		welcomeBottomPanel.add(lblNewLabel_11);
		
		JPanel paintRightPanel = new JPanel();
		paintRightPanel.setBackground(new Color(0, 64, 128));
		formPanel.add(paintRightPanel, BorderLayout.EAST);
		
		JLabel spaceLabel = new JLabel("                ");
		paintRightPanel.add(spaceLabel);
		
		JTabbedPane tabPanel = new JTabbedPane(JTabbedPane.TOP);
		tabPanel.setToolTipText("");
		formPanel.add(tabPanel, BorderLayout.CENTER);
		
		JPanel adminPanel = new JPanel();
		tabPanel.addTab("REGISTRAR USUARIO", null, adminPanel, null);
		adminPanel.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\leone\\Downloads\\Prasilarts-Claire-Monitor-14-Computer-Violet-Ring.96.png"));
		lblNewLabel_8.setBounds(268, 10, 96, 83);
		adminPanel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("NOMBRE:");
		lblNewLabel_10.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(44, 143, 90, 23);
		adminPanel.add(lblNewLabel_10);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(131, 143, 155, 23);
		adminPanel.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		JLabel lblNewLabel_10_1 = new JLabel("APELLIDO:");
		lblNewLabel_10_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_1.setBounds(314, 143, 90, 23);
		adminPanel.add(lblNewLabel_10_1);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(414, 143, 155, 23);
		adminPanel.add(textFieldApellido);
		
		JLabel lblNewLabel_10_2 = new JLabel(" E-MAIL:");
		lblNewLabel_10_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_2.setBounds(54, 176, 67, 23);
		adminPanel.add(lblNewLabel_10_2);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(131, 176, 273, 23);
		adminPanel.add(textFieldEmail);
		
		JLabel lblNewLabel_10_2_1 = new JLabel("TELEFONO:");
		lblNewLabel_10_2_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_2_1.setBounds(28, 209, 96, 23);
		adminPanel.add(lblNewLabel_10_2_1);
		
		textFieldTelefono = new JTextField();
		textFieldTelefono.setColumns(10);
		textFieldTelefono.setBounds(131, 209, 155, 23);
		adminPanel.add(textFieldTelefono);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("CIUDAD: ");
		lblNewLabel_10_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_1_1.setBounds(314, 209, 90, 23);
		adminPanel.add(lblNewLabel_10_1_1);
		
		comboBoxCiudad = new JComboBox();
		comboBoxCiudad.setModel(new DefaultComboBoxModel(new String[] {"SELECT...", "La Paz", "Cochabamba", "Oruro", "Santa Cruz", "Tarija", "Sucre"}));
		comboBoxCiudad.setBounds(414, 209, 155, 24);
		adminPanel.add(comboBoxCiudad);
		
		JPanel panelShowAdminCode = new JPanel();
		panelShowAdminCode.setBounds(10, 357, 614, 137);
		adminPanel.add(panelShowAdminCode);
		panelShowAdminCode.setLayout(null);
		panelShowAdminCode.setVisible(false);
		
		JTextPane txtpnHola = new JTextPane();
		txtpnHola.setFont(new Font("Yu Gothic Medium", Font.PLAIN, 14));
		txtpnHola.setText("Bienvenido, para confirmar que eres un Administrador, por favor ingresa el codigo secreto de Admin.\r\n");
		txtpnHola.setBounds(0, 0, 614, 64);
		panelShowAdminCode.add(txtpnHola);
		
		JLabel lblNewLabel_10_2_1_1_2_1 = new JLabel("CODIGO SECRETO: ");
		lblNewLabel_10_2_1_1_2_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_2_1_1_2_1.setBounds(10, 80, 174, 23);
		panelShowAdminCode.add(lblNewLabel_10_2_1_1_2_1);
		
		passwordFieldCodigo = new JPasswordField();
		passwordFieldCodigo.setBounds(168, 80, 300, 23);
		panelShowAdminCode.add(passwordFieldCodigo);
		
		JLabel lblNewLabel_10_2_1_1 = new JLabel("NUEVA CONTRASEÑA");
		lblNewLabel_10_2_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_2_1_1.setBounds(68, 253, 174, 23);
		adminPanel.add(lblNewLabel_10_2_1_1);
		
		JLabel lblNewLabel_10_2_1_1_1 = new JLabel("CONFIRMAR CONTRASEÑA");
		lblNewLabel_10_2_1_1_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_2_1_1_1.setBounds(28, 286, 214, 23);
		adminPanel.add(lblNewLabel_10_2_1_1_1);
		
		passwordFieldContra = new JPasswordField();
		passwordFieldContra.setBounds(268, 255, 300, 23);
		adminPanel.add(passwordFieldContra);
		
		passwordFieldConfirContra = new JPasswordField();
		passwordFieldConfirContra.setBounds(268, 286, 300, 23);
		adminPanel.add(passwordFieldConfirContra);
		
		JLabel lblNewLabel_10_2_1_1_2 = new JLabel("TIPO DE USUARIO:");
		lblNewLabel_10_2_1_1_2.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel_10_2_1_1_2.setBounds(28, 324, 174, 23);
		adminPanel.add(lblNewLabel_10_2_1_1_2);
		
		comboBoxTipoUsuario = new JComboBox();
		comboBoxTipoUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxTipoUsuario.getSelectedItem().equals("ADMINISTRADOR")) {
					panelShowAdminCode.setVisible(true);
				}
				else {
					panelShowAdminCode.setVisible(false);
				}
			}
		});
		comboBoxTipoUsuario.setModel(new DefaultComboBoxModel(new String[] {"SELECT...", "ADMINISTRADOR", "COMPRADOR"}));
		comboBoxTipoUsuario.setBounds(184, 324, 220, 24);
		adminPanel.add(comboBoxTipoUsuario);
		
		JButton registerButtom = new JButton("REGISTRAR");
		registerButtom.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RegisterUser();
				Limpiar();
			}
		});
		registerButtom.setFont(new Font("Arial Black", Font.PLAIN, 18));
		registerButtom.setBounds(313, 504, 311, 42);
		adminPanel.add(registerButtom);
		
		JButton btnNewButton_1_1 = new JButton("LIMPIAR");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Limpiar();
			}
		});
		btnNewButton_1_1.setFont(new Font("Arial Black", Font.PLAIN, 18));
		btnNewButton_1_1.setBounds(10, 504, 311, 42);
		adminPanel.add(btnNewButton_1_1);
		
	}
	
	public void SetConnection(Connection myConnection)
	{
		connection = myConnection;
	}

	private void Limpiar() {
		textFieldNombre.setText(null);
		textFieldApellido.setText("");
		textFieldEmail.setText("");
		textFieldTelefono.setText("");
		passwordFieldContra.setText(null);
		passwordFieldConfirContra.setText(null);
		passwordFieldCodigo.setText(null);
		comboBoxCiudad.setSelectedIndex(0);
		comboBoxTipoUsuario.setSelectedIndex(0);
	}
	
	private void RegisterUser()
	{
		String nombre = textFieldNombre.getText();
		String apellido = textFieldApellido.getText();
		String email = textFieldEmail.getText();
		String ciudad = comboBoxCiudad.getSelectedItem().toString();
		String telefono = textFieldTelefono.getText();
		String contraseña = new String(passwordFieldContra.getPassword());
		Usuario usuario = null;
		Comprador comprador = new Comprador(connection, nombre, apellido, email, ciudad, telefono, contraseña);
		Administrador admin = new Administrador(connection, nombre, apellido, email, ciudad, telefono, contraseña);
		if(comboBoxTipoUsuario.getSelectedIndex() == 1) {
			
			if(new String(passwordFieldCodigo.getPassword()).equals(admin.getCodigoSecreto())) {
				usuario = new Administrador(connection, nombre, apellido, email, ciudad, telefono, contraseña);
			}
			else {
				JOptionPane.showMessageDialog(null, "Ponga el codigo correcto");
			}
		} 
		
		else if(comboBoxTipoUsuario.getSelectedIndex() == 2) {
			usuario = new Comprador(connection, nombre, apellido, email, ciudad, telefono, contraseña);
		} 
		else {
			JOptionPane.showMessageDialog(null, "Por favor, selecciona un tipo de usuario");
			return;
		}
		
		String pass = new String(passwordFieldContra.getPassword());
		String confirPass = new String(passwordFieldConfirContra.getPassword());
		
		if(!pass.equals(confirPass)) {
			JOptionPane.showMessageDialog(null, "Contraseña no coincide, vuelva a intentar!");
			return;
		}
		
		
		if(usuario instanceof Comprador) {
			((Comprador) usuario).registrarComprador(comprador);
		}
		else if(usuario instanceof Administrador) {
			((Administrador) usuario).registrarAdmin(admin);
		}	
	}
}
