package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import persistencia.Agente;
import javax.swing.ListSelectionModel;
import javax.swing.JPanel;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.Color;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;


public class Gestor_Usuarios {

	private JFrame frmGestorDeUsuarios;
	private JList<String> listUsuarios;
	private JPanel panel;
	private JLabel lblNombre;
	private JTextField tfNombre;
	private JLabel lblApellidos;
	private JTextField tfApellidos;
	private JLabel lblDNI;
	private JFormattedTextField ftfDNI;
	private JLabel lblFechaNacimiento;
	private JLabel lblSexo;
	private JComboBox<String> cbSexo;
	private JLabel lblTelefono;
	private JFormattedTextField ftTelefono;
	private JLabel lblCorreo;
	private JTextField tfCorreo;
	private JButton btnGuardar;
	private JButton btnModificar;
	private JPanel panel_1;
	private JButton btnAnadir;
	private JButton btnEliminar2;
	private JList<String> listProyectos;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private JTextField tfDia;
	private JTextField tfMes;
	private JTextField tfAnio;
	private String nombre,dni,apellidos,telefono,correo,sexo,fecha,dia,mes,anio,identificador;
	private DefaultListModel<String> modelo2 = new DefaultListModel<String>();
	private JButton btnSexo;
	private JLabel lblError;
	private JLabel lblUsuario;
	private JTextField tfUsuario;
	private JLabel lblPass;
	private JTextField tfPass;
	private boolean modificar=false,existe=false;
	private JButton btnSalir;
	private boolean eliminado=false, insertar=false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gestor_Usuarios window = new Gestor_Usuarios();
					window.frmGestorDeUsuarios.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Gestor_Usuarios() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frmGestorDeUsuarios = new JFrame();
		frmGestorDeUsuarios.setIconImage(Toolkit.getDefaultToolkit().getImage(Gestor_Usuarios.class.getResource("/presentacion/IconoSoftProject.png")));
		frmGestorDeUsuarios.setResizable(false);
		frmGestorDeUsuarios.setLocationRelativeTo(null);
		frmGestorDeUsuarios.setTitle(MessagesGestor_Usuarios.getString("Gestor_Usuarios.frmGestorDeUsuarios.title")); //$NON-NLS-1$
		//frmGestorDeUsuarios.setIconImage(Toolkit.getDefaultToolkit().getImage(Gestor_Usuarios.class.getResource(MessagesGestor_Usuarios.getString("Gestor_Usuarios.0")))); //$NON-NLS-1$
		frmGestorDeUsuarios.setBounds(100, 100, 1055, 728);
		frmGestorDeUsuarios.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmGestorDeUsuarios.getContentPane().setLayout(null);
		frmGestorDeUsuarios.setLocationRelativeTo(null);

		listUsuarios = new JList<String>();
		listUsuarios.addListSelectionListener(new ListUsuariosListSelectionListener());
		listUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUsuarios.setBorder(new TitledBorder(null, MessagesGestor_Usuarios.getString("Gestor_Usuarios.listUsuarios.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		listUsuarios.setBounds(25, 13, 272, 643);
		listUsuarios.setModel(modelo);
		frmGestorDeUsuarios.getContentPane().add(listUsuarios);
		
		panel = new JPanel();
		panel.setBorder(UIManager.getBorder(MessagesGestor_Usuarios.getString("Gestor_Usuarios.1"))); //$NON-NLS-1$
		panel.setBackground(SystemColor.controlHighlight);
		panel.setBounds(318, 13, 707, 315);
		frmGestorDeUsuarios.getContentPane().add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 115, 38, 16, 179, 117, 106, 90, 85, 0};
		gbl_panel.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0, 0, 0, 37, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		lblUsuario = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblUsuario.text")); //$NON-NLS-1$
		lblUsuario.setVisible(false);
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.gridx = 4;
		gbc_lblUsuario.gridy = 0;
		panel.add(lblUsuario, gbc_lblUsuario);
		
		tfUsuario = new JTextField();
		tfUsuario.setVisible(false);
		tfUsuario.setEditable(false);
		GridBagConstraints gbc_tfUsuario = new GridBagConstraints();
		gbc_tfUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_tfUsuario.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfUsuario.gridx = 5;
		gbc_tfUsuario.gridy = 0;
		panel.add(tfUsuario, gbc_tfUsuario);
		tfUsuario.setColumns(10);
		
		btnSexo = new JButton(MessagesGestor_Usuarios.getString("Gestor_Usuarios.btnSexo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_btnSexo = new GridBagConstraints();
		gbc_btnSexo.gridheight = 6;
		gbc_btnSexo.gridwidth = 2;
		gbc_btnSexo.insets = new Insets(0, 0, 5, 5);
		gbc_btnSexo.gridx = 1;
		gbc_btnSexo.gridy = 1;
		panel.add(btnSexo, gbc_btnSexo);
		
		lblPass = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblPass.text")); //$NON-NLS-1$
		lblPass.setVisible(false);
		GridBagConstraints gbc_lblPass = new GridBagConstraints();
		gbc_lblPass.anchor = GridBagConstraints.EAST;
		gbc_lblPass.insets = new Insets(0, 0, 5, 5);
		gbc_lblPass.gridx = 4;
		gbc_lblPass.gridy = 1;
		panel.add(lblPass, gbc_lblPass);
		
		tfPass = new JTextField();
		tfPass.setVisible(false);
		tfPass.setEditable(false);
		GridBagConstraints gbc_tfPass = new GridBagConstraints();
		gbc_tfPass.insets = new Insets(0, 0, 5, 5);
		gbc_tfPass.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfPass.gridx = 5;
		gbc_tfPass.gridy = 1;
		panel.add(tfPass, gbc_tfPass);
		tfPass.setColumns(10);
		
		lblNombre = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblNombre.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre = new GridBagConstraints();
		gbc_lblNombre.anchor = GridBagConstraints.EAST;
		gbc_lblNombre.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre.gridx = 4;
		gbc_lblNombre.gridy = 2;
		panel.add(lblNombre, gbc_lblNombre);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.gridx = 5;
		gbc_tfNombre.gridy = 2;
		panel.add(tfNombre, gbc_tfNombre);
		
		lblApellidos = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblApellidos.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblApellidos = new GridBagConstraints();
		gbc_lblApellidos.anchor = GridBagConstraints.EAST;
		gbc_lblApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_lblApellidos.gridx = 4;
		gbc_lblApellidos.gridy = 3;
		panel.add(lblApellidos, gbc_lblApellidos);
		
		tfApellidos = new JTextField();
		tfApellidos.setEditable(false);
		GridBagConstraints gbc_tfApellidos = new GridBagConstraints();
		gbc_tfApellidos.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfApellidos.insets = new Insets(0, 0, 5, 5);
		gbc_tfApellidos.gridx = 5;
		gbc_tfApellidos.gridy = 3;
		panel.add(tfApellidos, gbc_tfApellidos);
		
		lblDNI = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblDNI.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDNI = new GridBagConstraints();
		gbc_lblDNI.anchor = GridBagConstraints.EAST;
		gbc_lblDNI.insets = new Insets(0, 0, 5, 5);
		gbc_lblDNI.gridx = 4;
		gbc_lblDNI.gridy = 4;
		panel.add(lblDNI, gbc_lblDNI);
		
		ftfDNI = new JFormattedTextField((AbstractFormatter) null);
		ftfDNI.setEditable(false);
		GridBagConstraints gbc_ftfDNI = new GridBagConstraints();
		gbc_ftfDNI.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftfDNI.insets = new Insets(0, 0, 5, 5);
		gbc_ftfDNI.gridx = 5;
		gbc_ftfDNI.gridy = 4;
		panel.add(ftfDNI, gbc_ftfDNI);
		
		lblFechaNacimiento = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblFechaNacimiento.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaNacimiento = new GridBagConstraints();
		gbc_lblFechaNacimiento.anchor = GridBagConstraints.EAST;
		gbc_lblFechaNacimiento.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaNacimiento.gridx = 4;
		gbc_lblFechaNacimiento.gridy = 5;
		panel.add(lblFechaNacimiento, gbc_lblFechaNacimiento);
		
		tfDia = new JTextField();
		tfDia.setEditable(false);
		tfDia.addKeyListener(new TfDiaKeyListener());
		GridBagConstraints gbc_tfDia = new GridBagConstraints();
		gbc_tfDia.insets = new Insets(0, 0, 5, 5);
		gbc_tfDia.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfDia.gridx = 5;
		gbc_tfDia.gridy = 5;
		panel.add(tfDia, gbc_tfDia);
		tfDia.setColumns(2);
		
		tfMes = new JTextField();
		tfMes.setEditable(false);
		tfMes.addKeyListener(new TfMesKeyListener());
		tfMes.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.tfMes.text")); //$NON-NLS-1$
		GridBagConstraints gbc_tfMes = new GridBagConstraints();
		gbc_tfMes.insets = new Insets(0, 0, 5, 5);
		gbc_tfMes.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfMes.gridx = 6;
		gbc_tfMes.gridy = 5;
		panel.add(tfMes, gbc_tfMes);
		tfMes.setColumns(2);
		
		
		tfAnio = new JTextField();
		tfAnio.setEditable(false);
		tfAnio.addKeyListener(new TAnioKeyListener());
		GridBagConstraints gbc_tfAnio = new GridBagConstraints();
		gbc_tfAnio.insets = new Insets(0, 0, 5, 5);
		gbc_tfAnio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAnio.gridx = 7;
		gbc_tfAnio.gridy = 5;
		panel.add(tfAnio, gbc_tfAnio);
		tfAnio.setColumns(4);
		
		lblSexo = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblSexo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblSexo = new GridBagConstraints();
		gbc_lblSexo.anchor = GridBagConstraints.EAST;
		gbc_lblSexo.insets = new Insets(0, 0, 5, 5);
		gbc_lblSexo.gridx = 4;
		gbc_lblSexo.gridy = 6;
		panel.add(lblSexo, gbc_lblSexo);
		
		cbSexo = new JComboBox<String>();
		cbSexo.addItemListener(new CbSexoItemListener());
		cbSexo.setEnabled(false);
		cbSexo.setModel(new DefaultComboBoxModel<String>(new String[] {MessagesGestor_Usuarios.getString("Gestor_Usuarios.2"), MessagesGestor_Usuarios.getString("Gestor_Usuarios.3")})); //$NON-NLS-1$ //$NON-NLS-2$
		GridBagConstraints gbc_cbSexo = new GridBagConstraints();
		gbc_cbSexo.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbSexo.insets = new Insets(0, 0, 5, 5);
		gbc_cbSexo.gridx = 5;
		gbc_cbSexo.gridy = 6;
		panel.add(cbSexo, gbc_cbSexo);
		
		lblTelefono = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblTelefono.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTelefono = new GridBagConstraints();
		gbc_lblTelefono.anchor = GridBagConstraints.EAST;
		gbc_lblTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelefono.gridx = 4;
		gbc_lblTelefono.gridy = 7;
		panel.add(lblTelefono, gbc_lblTelefono);
		
		ftTelefono = new JFormattedTextField((AbstractFormatter) null);
		ftTelefono.setEditable(false);
		
		
		GridBagConstraints gbc_ftTelefono = new GridBagConstraints();
		gbc_ftTelefono.fill = GridBagConstraints.HORIZONTAL;
		gbc_ftTelefono.insets = new Insets(0, 0, 5, 5);
		gbc_ftTelefono.gridx = 5;
		gbc_ftTelefono.gridy = 7;
		panel.add(ftTelefono, gbc_ftTelefono);
		
		lblCorreo = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblCorreo.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblCorreo = new GridBagConstraints();
		gbc_lblCorreo.anchor = GridBagConstraints.EAST;
		gbc_lblCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_lblCorreo.gridx = 4;
		gbc_lblCorreo.gridy = 8;
		panel.add(lblCorreo, gbc_lblCorreo);
		
		tfCorreo = new JTextField();
		tfCorreo.setEditable(false);
		GridBagConstraints gbc_tfCorreo = new GridBagConstraints();
		gbc_tfCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfCorreo.gridwidth = 2;
		gbc_tfCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_tfCorreo.gridx = 5;
		gbc_tfCorreo.gridy = 8;
		panel.add(tfCorreo, gbc_tfCorreo);
		
		lblError = new JLabel(MessagesGestor_Usuarios.getString("Gestor_Usuarios.lblError.text")); //$NON-NLS-1$
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font(MessagesGestor_Usuarios.getString("Gestor_Usuarios.4"), Font.BOLD, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 9;
		panel.add(lblError, gbc_lblError);
		
		panel_1 = new JPanel();
		panel_1.setBorder(UIManager.getBorder(MessagesGestor_Usuarios.getString("Gestor_Usuarios.5"))); //$NON-NLS-1$
		panel_1.setBackground(SystemColor.controlHighlight);
		panel_1.setBounds(318, 341, 707, 327);
		frmGestorDeUsuarios.getContentPane().add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 115, 38, 0, 82, 104, 0, 87, 85, 0};
		gbl_panel_1.rowHeights = new int[]{0, 23, 0, 0, 0, 0, 0, 0, -7, 37, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		listProyectos = new JList<String>();
		listProyectos.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listProyectos.setBorder(new TitledBorder(null, MessagesGestor_Usuarios.getString("Gestor_Usuarios.listProyectos.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		
		GridBagConstraints gbc_listProyectos = new GridBagConstraints();
		gbc_listProyectos.gridheight = 7;
		gbc_listProyectos.gridwidth = 8;
		gbc_listProyectos.insets = new Insets(0, 0, 5, 0);
		gbc_listProyectos.fill = GridBagConstraints.BOTH;
		gbc_listProyectos.gridx = 1;
		gbc_listProyectos.gridy = 1;
		panel_1.add(listProyectos, gbc_listProyectos);
		
		btnAnadir = new JButton(MessagesGestor_Usuarios.getString("Gestor_Usuarios.btnAnadir.text")); //$NON-NLS-1$
		btnAnadir.addActionListener(new BtnAnadirActionListener());
		btnAnadir.setFont(new Font(MessagesGestor_Usuarios.getString("Gestor_Usuarios.6"), Font.PLAIN, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnAnadir = new GridBagConstraints();
		gbc_btnAnadir.fill = GridBagConstraints.VERTICAL;
		gbc_btnAnadir.anchor = GridBagConstraints.EAST;
		gbc_btnAnadir.insets = new Insets(0, 0, 0, 5);
		gbc_btnAnadir.gridx = 5;
		gbc_btnAnadir.gridy = 9;
		panel_1.add(btnAnadir, gbc_btnAnadir);
		
		btnEliminar2 = new JButton(MessagesGestor_Usuarios.getString("Gestor_Usuarios.btnEliminar2.text")); //$NON-NLS-1$
		btnEliminar2.addActionListener(new BtnEliminar2ActionListener());
		btnEliminar2.setFont(new Font(MessagesGestor_Usuarios.getString("Gestor_Usuarios.7"), Font.PLAIN, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnEliminar2 = new GridBagConstraints();
		gbc_btnEliminar2.insets = new Insets(0, 0, 0, 5);
		gbc_btnEliminar2.fill = GridBagConstraints.VERTICAL;
		gbc_btnEliminar2.gridx = 6;
		gbc_btnEliminar2.gridy = 9;
		panel_1.add(btnEliminar2, gbc_btnEliminar2);
		
		btnSalir = new JButton(MessagesGestor_Usuarios.getString("Gestor_Usuarios.btnSalir.text")); //$NON-NLS-1$
		btnSalir.addActionListener(new BtnSalirActionListener());
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.BOTH;
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 7;
		gbc_btnSalir.gridy = 9;
		panel_1.add(btnSalir, gbc_btnSalir);
		setLista();
		//btnSexo.setIcon(new ImageIcon(Ventana_Principal.class.getResource(MessagesGestor_Usuarios.getString("Gestor_Usuarios.8")))); //$NON-NLS-1$
		
		btnGuardar = new JButton(MessagesGestor_Usuarios.getString("Gestor_Usuarios.btnGuardar.text")); //$NON-NLS-1$
		btnGuardar.setEnabled(false);
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		
		btnModificar = new JButton(MessagesGestor_Usuarios.getString("Gestor_Usuarios.btnModificar.text")); //$NON-NLS-1$
		btnModificar.addActionListener(new BtnModificarActionListener());
		btnModificar.setFont(new Font(MessagesGestor_Usuarios.getString("Gestor_Usuarios.9"), Font.PLAIN, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnModificar = new GridBagConstraints();
		gbc_btnModificar.fill = GridBagConstraints.VERTICAL;
		gbc_btnModificar.insets = new Insets(0, 0, 0, 5);
		gbc_btnModificar.gridx = 5;
		gbc_btnModificar.gridy = 9;
		panel.add(btnModificar, gbc_btnModificar);
		btnGuardar.setFont(new Font(MessagesGestor_Usuarios.getString("Gestor_Usuarios.10"), Font.PLAIN, 13)); //$NON-NLS-1$
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.anchor = GridBagConstraints.EAST;
		gbc_btnGuardar.fill = GridBagConstraints.VERTICAL;
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.gridx = 6;
		gbc_btnGuardar.gridy = 9;
		panel.add(btnGuardar, gbc_btnGuardar);
	
	}
	public String obtenerDatos(String texto) {
		String cadena = null;
		for(int c=0 ; c<texto.length() ; c++) {
			if(texto.charAt(c)=='-')
				cadena=texto.substring(0, c);
		}
		
		return cadena;
	}
	public void setLista() {
		Agente b;
		String SQL_Consulta = "SELECT Nombre,DNI FROM Usuarios";
		modelo.addElement("");
		modelo.removeAllElements();
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				nombre=lista.getString("Nombre");
				dni=lista.getString("DNI");
				modelo.addElement(dni+"- "+nombre);
				listUsuarios.setModel(modelo);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public JFrame getFrame() {
		return frmGestorDeUsuarios;
	}
	public void setNombre(String texto) {
		tfNombre.setText(texto);
	}
	public void setApellidos(String texto) {
		tfApellidos.setText(texto);
	}
	public void setDia(String texto) {
		tfDia.setText(texto);
	}
	public void setMes(String texto) {
		tfMes.setText(texto);
	}
	public void setAnio(String texto) {
		tfAnio.setText(texto);
	}
	public void setDNI(String texto) {
		ftfDNI.setText(texto);
	}
	public void setTelefono(String texto) {
		ftTelefono.setText(texto);
	}
	public void setCorreo(String texto) {
		tfCorreo.setText(texto);
	}
	public void setSexo(int c) {
		cbSexo.setSelectedIndex(c);
	}
	public void setImagen(String cadena) {
		btnSexo.setIcon(new ImageIcon(Ventana_Principal.class.getResource(cadena)));
	}
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tfNombre.setEditable(true);
			tfApellidos.setEditable(true);
			ftTelefono.setEditable(true);
			tfCorreo.setEditable(true);
			tfDia.setEditable(true);
			tfMes.setEditable(true);
			tfAnio.setEditable(true);
			cbSexo.setEnabled(true);
			tfUsuario.setEditable(true);
			tfPass.setEditable(true);
			btnGuardar.setEnabled(true);
			modificar=true;
		}
	}
	private class TfDiaKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (tfDia.getText().length()== 2) {
			     e.consume();
			}
		}
		@Override
		public void keyPressed(KeyEvent e) {
			
		}
	}
	private class TfMesKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (tfMes.getText().length()== 2) {
			     e.consume();
			}
		}
	}
	private class TAnioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent e) {
			if (tfAnio.getText().length()== 4) {
			     e.consume();
			}
		}
	}
	public void rellenarCampos() {
		Agente b;
		DividirCadena(listUsuarios.getSelectedValue());
		String SQL_Consulta = "SELECT Nombre, Apellidos, Telefono, Sexo, Correo, Fecha_Nacimiento, Imagen FROM Usuarios where DNI='"+identificador+"'";
		
		
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				nombre=lista.getString("Nombre");
				apellidos=lista.getString("Apellidos");
				telefono=lista.getString("Telefono");
				sexo=lista.getString("Sexo");
				correo=lista.getString("Correo");
				fecha=lista.getString("Fecha_Nacimiento");
			}
		}catch (Exception e1) {
			System.out.println(e1.getMessage());
		}
		
		tfNombre.setText(nombre);	
		tfApellidos.setText(apellidos);
		ftfDNI.setText(identificador);
		ftTelefono.setText(telefono);
		tfCorreo.setText(correo);
		
		int d=0,mesP = 0;
		for(int c=0 ; c<fecha.length() ; c++) {
			if(fecha.charAt(c)=='/') {
				d++;
				if(d==1) {
					dia=fecha.substring(0, c);
					mesP=c;
				}
				if(d==2) {
					mes=fecha.substring(mesP+1, c);
					anio=fecha.substring(c+1, fecha.length());
				}
			}
		}
		tfDia.setText(dia);
		tfMes.setText(mes);
		tfAnio.setText(anio);
		
		if(sexo.equals("Hombre")) {
			setSexo(0);
		}
		if(sexo.equals("Mujer")) {
			setSexo(1);
		}
		if(cbSexo.getSelectedIndex()==0) {
			btnSexo.setIcon(new ImageIcon(Ventana_Principal.class.getResource("Hombre.PNG")));
			
		}
		if(cbSexo.getSelectedIndex()==1) {
			btnSexo.setIcon(new ImageIcon(Ventana_Principal.class.getResource("Mujer.PNG")));
		}
	}
	public void rellenarProyectos() {
		modelo2.removeAllElements();
		listProyectos.setModel(modelo2);
		Agente b;
		DividirCadena(listUsuarios.getSelectedValue());
		String SQL_Consulta = "SELECT Nombre FROM Proyectos WHERE DNI_Miembro='"+identificador+"'";
		
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				String proyecto = lista.getString("Nombre");
				if(proyecto.equals(null)) {
					modelo2.addElement(" ");
					listProyectos.setModel(modelo2);
				}
				else {
					modelo2.addElement(proyecto);
					listProyectos.setModel(modelo2);
				}
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}	
	}
	private void DividirCadena(String cadena) {
		char letra;
		for(int i=0 ; i<cadena.length() ; i++) {
			letra=cadena.charAt(i);
			if(letra=='-') {
				identificador=cadena.substring(0, i);
			}
		}
	}
	public void setImagen(ImageIcon i) {
		btnSexo.setIcon(i);
	}
	private class ListUsuariosListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent e) {
			if(!eliminado && !insertar) {
				obtenerDatos(listUsuarios.getSelectedValue());
				rellenarCampos();
				rellenarProyectos();
			}
			tfUsuario.setText("");
			tfPass.setText("");
			eliminado=false;
			insertar=false;
			tfNombre.setEditable(false);
			tfApellidos.setEditable(false);
			ftfDNI.setEditable(false);
			ftTelefono.setEditable(false);
			tfCorreo.setEditable(false);
			tfDia.setEditable(false);
			tfMes.setEditable(false);
			tfAnio.setEditable(false);
			cbSexo.setEnabled(false);
			lblError.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.31")); //$NON-NLS-1$
			btnGuardar.setEnabled(false);
			tfUsuario.setEditable(false);
			tfPass.setEditable(false);
			lblUsuario.setVisible(false);
			tfUsuario.setVisible(false);
			lblPass.setVisible(false);
			tfPass.setVisible(false);
			modificar=false;
		}
			
	}
	private boolean comprobarCampos() {
		boolean bien=true;
		Agente b;
		String SQL_Consulta = "SELECT DNI FROM Usuarios";
		String id;
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				id = lista.getString("Dni");
				if(id.equals(ftfDNI.getText()))
					existe=true;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}	
		
		if(tfNombre.getText().equals("") || tfApellidos.getText().equals("") || ftfDNI.getText().equals("") || ftTelefono.getText().equals("") || tfCorreo.getText().equals("") || tfDia.getText().equals("") || tfMes.getText().equals("") || tfAnio.getText().equals("")) {
			bien=false;
		}
		
		return bien;
	
	}
	private class BtnAnadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tfNombre.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.42")); //$NON-NLS-1$
			tfApellidos.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.43")); //$NON-NLS-1$
			ftfDNI.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.44")); //$NON-NLS-1$
			ftTelefono.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.45")); //$NON-NLS-1$
			tfCorreo.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.46")); //$NON-NLS-1$
			tfDia.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.47")); //$NON-NLS-1$
			tfMes.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.48")); //$NON-NLS-1$
			tfAnio.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.49")); //$NON-NLS-1$
			tfNombre.setEditable(true);
			tfApellidos.setEditable(true);
			ftfDNI.setEditable(true);
			ftTelefono.setEditable(true);
			tfCorreo.setEditable(true);
			tfDia.setEditable(true);
			tfMes.setEditable(true);
			tfAnio.setEditable(true);
			cbSexo.setEnabled(true);
			tfUsuario.setEditable(true);
			tfPass.setEditable(true);
			lblError.setText(MessagesGestor_Usuarios.getString("Gestor_Usuarios.50")); //$NON-NLS-1$
			btnGuardar.setEnabled(true);
			lblUsuario.setVisible(true);
			tfUsuario.setVisible(true);
			lblPass.setVisible(true);
			tfPass.setVisible(true);
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String imagen ="";
			if(tfNombre.isEditable()) {
				if(comprobarCampos()) {
					if(cbSexo.getSelectedIndex()==0) {
							imagen="Hombre.PNG";
							sexo="Hombre";
					}
					if(cbSexo.getSelectedIndex()==1) {
							imagen="Mujer.PNG";
							sexo="Mujer";
					}
					Agente b,c;
					
					//String fecha=dia+"/"+mes+"/"+anio;
	
					if(!modificar && !existe) {
						
						String SQL_Consulta2 = "INSERT INTO Usuarios (Usuario, Password, Nombre, Apellidos, DNI, Telefono,Sexo,Correo,Fecha_Nacimiento,Imagen)"
								+ "VALUES ('"+tfUsuario.getText()+"','"+tfPass.getText()+"','"+tfNombre.getText()+"','"+tfApellidos.getText()+"','"+ftfDNI.getText()+"','"+ftTelefono.getText()+"','"+sexo+"','"+tfCorreo.getText()+"','"+tfDia.getText()+"/"+tfMes.getText()+"/"+tfAnio.getText()+"','"+imagen+"');";
						try {
							b = Agente.getAgenteUsuario();
							b.insert(SQL_Consulta2);
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage());
							
						}
						insertar=true;
						setLista();
						
						
					}
					else {
						
						String SQL_Consulta2 = "UPDATE Usuarios SET Nombre='"+ tfNombre.getText()+"',Apellidos='"+tfApellidos.getText()+"',DNI='"+ftfDNI.getText()+"',Telefono='"+ftTelefono.getText()+"',Sexo='"+sexo+"',Correo='"+tfCorreo.getText()+"',Fecha_Nacimiento='"+tfDia.getText()+"/"+tfMes.getText()+"/"+tfAnio.getText()+"',Imagen='"+imagen+"' WHERE DNI='"+dni+"';";
						
						try {
							c = Agente.getAgenteUsuario();
							c.update(SQL_Consulta2);
							
							
						}catch (Exception e1) {
							System.out.println(e1.getMessage());
							
						}
						//System.out.println(modelo.getSize());
						//modelo.removeElementAt(modelo.getSize()+1);
						
						modificar=false;
						existe=false;
						//setLista();
						tfNombre.setEditable(false);
						tfApellidos.setEditable(false);
						ftTelefono.setEditable(false);
						tfCorreo.setEditable(false);
						tfDia.setEditable(false);
						tfMes.setEditable(false);
						tfAnio.setEditable(false);
						cbSexo.setEnabled(false);
						btnGuardar.setEnabled(false);
					}
					
					
				}
				else {
					lblError.setText("Campos incorrectos");
				}
				
				
			}
		}
	}
	private class CbSexoItemListener implements ItemListener {
		public void itemStateChanged(ItemEvent e) {
			if(cbSexo.getSelectedIndex()==0) {
				btnSexo.setIcon(new ImageIcon(Ventana_Principal.class.getResource("Hombre.PNG")));
			}
			if(cbSexo.getSelectedIndex()==1) {
				btnSexo.setIcon(new ImageIcon(Ventana_Principal.class.getResource("Mujer.PNG")));
			}
		}
	}
	private class BtnEliminar2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Agente b;
			String SQL_Consulta = "DELETE * FROM Usuarios WHERE DNI='"+ftfDNI.getText()+"';";
			try {
				b = Agente.getAgenteUsuario();
				b.delete(SQL_Consulta);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				
			}
			eliminado=true;
			setLista();
			
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmGestorDeUsuarios.dispose();
		}
	}
}
