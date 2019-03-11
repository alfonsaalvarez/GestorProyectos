package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import persistencia.Agente;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

public class NuevoProyecto {

	private JFrame frmNuevoProyecto;
	private JTextField tfNombre;
	private JTextField tfInicio;
	private JTextField tfFin;
	private JLabel lblNewLabel_1;
	private JList<String> listUsuarios;
	private JLabel lblNewLabel_2;
	private JButton btnAgregar;
	private JButton btnCrear;
	private JButton btnSalir;
	private JList<String> listP;
	private DefaultListModel<String> modeloUsuarios = new DefaultListModel<String>();
	private DefaultListModel<String> modeloParticipantes = new DefaultListModel<String>();
	private String identificador1,id1;
	private JLabel lblError;
	private JLabel lblNewLabel_3;
	@SuppressWarnings("rawtypes")
	private JComboBox cBPersonas;
	private JTextPane tpDescrip;
	private JLabel lblNewLabel_4;
	private JScrollPane scrollPane;
	private String[] personas=new String[255];
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoProyecto window = new NuevoProyecto();
					window.frmNuevoProyecto.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevoProyecto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmNuevoProyecto = new JFrame();
		frmNuevoProyecto.setIconImage(Toolkit.getDefaultToolkit().getImage(NuevoProyecto.class.getResource("/presentacion/IconoSoftProject.png")));
		frmNuevoProyecto.setTitle(MessagesNuevoProyecto.getString("NuevoProyecto.frmNuevoProyecto.title")); //$NON-NLS-1$
		frmNuevoProyecto.setBounds(100, 100, 993, 603);
		frmNuevoProyecto.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 191, 184, 91, 59, 156, 219, 0, 0};
		gridBagLayout.rowHeights = new int[]{50, 0, 0, 0, 22, 0, 0, 67, 157, 113, 120, 60, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		frmNuevoProyecto.getContentPane().setLayout(gridBagLayout);
		frmNuevoProyecto.setLocationRelativeTo(null);
		
		lblNewLabel_3 = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblNewLabel_3.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		frmNuevoProyecto.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		setCombo();
		cBPersonas = new JComboBox(personas);
		GridBagConstraints gbc_cBPersonas = new GridBagConstraints();
		gbc_cBPersonas.gridwidth = 2;
		gbc_cBPersonas.insets = new Insets(0, 0, 5, 5);
		gbc_cBPersonas.fill = GridBagConstraints.HORIZONTAL;
		gbc_cBPersonas.gridx = 2;
		gbc_cBPersonas.gridy = 2;
		frmNuevoProyecto.getContentPane().add(cBPersonas, gbc_cBPersonas);
		
		JLabel lblTtuloDelProyecto = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblTtuloDelProyecto.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblTtuloDelProyecto = new GridBagConstraints();
		gbc_lblTtuloDelProyecto.anchor = GridBagConstraints.EAST;
		gbc_lblTtuloDelProyecto.insets = new Insets(0, 0, 5, 5);
		gbc_lblTtuloDelProyecto.gridx = 1;
		gbc_lblTtuloDelProyecto.gridy = 3;
		frmNuevoProyecto.getContentPane().add(lblTtuloDelProyecto, gbc_lblTtuloDelProyecto);
		
		tfNombre = new JTextField();
		GridBagConstraints gbc_tfNombre = new GridBagConstraints();
		gbc_tfNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfNombre.insets = new Insets(0, 0, 5, 5);
		gbc_tfNombre.gridx = 2;
		gbc_tfNombre.gridy = 3;
		frmNuevoProyecto.getContentPane().add(tfNombre, gbc_tfNombre);
		tfNombre.setColumns(10);
		
		lblNewLabel_1 = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblNewLabel_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 3;
		frmNuevoProyecto.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		listP = new JList<String>();
		listP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_listP = new GridBagConstraints();
		gbc_listP.gridwidth = 2;
		gbc_listP.gridheight = 5;
		gbc_listP.insets = new Insets(0, 0, 5, 5);
		gbc_listP.fill = GridBagConstraints.BOTH;
		gbc_listP.gridx = 5;
		gbc_listP.gridy = 4;
		frmNuevoProyecto.getContentPane().add(listP, gbc_listP);
		
		JLabel lblFechaDeInicio = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblFechaDeInicio.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeInicio = new GridBagConstraints();
		gbc_lblFechaDeInicio.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeInicio.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeInicio.gridx = 1;
		gbc_lblFechaDeInicio.gridy = 5;
		frmNuevoProyecto.getContentPane().add(lblFechaDeInicio, gbc_lblFechaDeInicio);
		
		tfInicio = new JTextField();
		GridBagConstraints gbc_tfInicio = new GridBagConstraints();
		gbc_tfInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfInicio.insets = new Insets(0, 0, 5, 5);
		gbc_tfInicio.gridx = 2;
		gbc_tfInicio.gridy = 5;
		frmNuevoProyecto.getContentPane().add(tfInicio, gbc_tfInicio);
		tfInicio.setColumns(10);
		
		JLabel lblNewLabel = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		frmNuevoProyecto.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		tfFin = new JTextField();
		GridBagConstraints gbc_tfFin = new GridBagConstraints();
		gbc_tfFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFin.insets = new Insets(0, 0, 5, 5);
		gbc_tfFin.gridx = 2;
		gbc_tfFin.gridy = 6;
		frmNuevoProyecto.getContentPane().add(tfFin, gbc_tfFin);
		tfFin.setColumns(10);
		
		lblNewLabel_2 = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblNewLabel_2.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_2.gridwidth = 2;
		gbc_lblNewLabel_2.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 7;
		frmNuevoProyecto.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		listUsuarios = new JList<String>();
		listUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUsuarios.setToolTipText(MessagesNuevoProyecto.getString("NuevoProyecto.listUsuarios.toolTipText")); //$NON-NLS-1$
		GridBagConstraints gbc_listUsuarios = new GridBagConstraints();
		gbc_listUsuarios.gridwidth = 2;
		gbc_listUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_listUsuarios.fill = GridBagConstraints.BOTH;
		gbc_listUsuarios.gridx = 1;
		gbc_listUsuarios.gridy = 8;
		frmNuevoProyecto.getContentPane().add(listUsuarios, gbc_listUsuarios);
		
		btnCrear = new JButton(MessagesNuevoProyecto.getString("NuevoProyecto.btnCrear.text")); //$NON-NLS-1$
		btnCrear.addActionListener(new BtnCrearActionListener());
		
		btnAgregar = new JButton(MessagesNuevoProyecto.getString("NuevoProyecto.btnAgregar.text")); //$NON-NLS-1$
		btnAgregar.addActionListener(new BtnAgregarActionListener());
		GridBagConstraints gbc_btnAgregar = new GridBagConstraints();
		gbc_btnAgregar.gridwidth = 2;
		gbc_btnAgregar.insets = new Insets(0, 0, 5, 5);
		gbc_btnAgregar.gridx = 3;
		gbc_btnAgregar.gridy = 8;
		frmNuevoProyecto.getContentPane().add(btnAgregar, gbc_btnAgregar);
		
		lblNewLabel_4 = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblNewLabel_4.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 9;
		frmNuevoProyecto.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrear.gridx = 5;
		gbc_btnCrear.gridy = 9;
		frmNuevoProyecto.getContentPane().add(btnCrear, gbc_btnCrear);
		
		btnSalir = new JButton(MessagesNuevoProyecto.getString("NuevoProyecto.btnSalir.text")); //$NON-NLS-1$
		btnSalir.addActionListener(new BtnSalirActionListener());
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 6;
		gbc_btnSalir.gridy = 9;
		frmNuevoProyecto.getContentPane().add(btnSalir, gbc_btnSalir);
		
		scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 10;
		frmNuevoProyecto.getContentPane().add(scrollPane, gbc_scrollPane);
		
		tpDescrip = new JTextPane();
		scrollPane.setViewportView(tpDescrip);
		
		lblError = new JLabel(MessagesNuevoProyecto.getString("NuevoProyecto.lblError.text"));
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.gridwidth = 2;
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 5;
		gbc_lblError.gridy = 10;
		frmNuevoProyecto.getContentPane().add(lblError, gbc_lblError);
		setLista();
	}
	
	public void setCombo() {
		int c=0;
		Agente b;
		String SQL_Consulta = "SELECT DNI,Nombre,Apellidos FROM Usuarios";
		String nombre,apellidos,dni;
		
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				nombre=lista.getString("Nombre");
				apellidos=lista.getString("Apellidos");
				dni=lista.getString("DNI");
				personas[c]=dni+"-"+nombre+" "+apellidos;
				c++;
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void setLista() {
		Agente b;
		String SQL_Consulta = "SELECT DNI,Nombre,Apellidos FROM Usuarios";
		String nombre,apellidos,dni;
		
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				nombre=lista.getString("Nombre");
				apellidos=lista.getString("Apellidos");
				dni=lista.getString("DNI");
				modeloUsuarios.addElement(dni+"-"+nombre+" "+apellidos);
				listUsuarios.setModel(modeloUsuarios);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public JFrame getFrame() {
		return frmNuevoProyecto;
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmNuevoProyecto.dispose();
			GestorProy v=new GestorProy();
			v.getFrame().setVisible(true);
		}
	}
	private class BtnAgregarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(modeloUsuarios.getSize()>=1) {
				int c=listUsuarios.getSelectedIndex();
				modeloParticipantes.addElement(listUsuarios.getSelectedValue());
				listP.setModel(modeloParticipantes);
				modeloUsuarios.removeElementAt(c);
			}
		}
	}
	
	private void DividirCadena1(String cadena) {
		char letra;
		for(int i=0 ; i<cadena.length() ; i++) {
			letra=cadena.charAt(i);
			if(letra=='-') {
				identificador1=cadena.substring(0, i);
			}
		}
		
	}
	
	private void DividirCadena2(String cadena) {
		char letra;
		for(int i=0 ; i<cadena.length() ; i++) {
			letra=cadena.charAt(i);
			if(letra=='-') {
				id1=cadena.substring(0, i);
			}
		}
	}
	
	private class BtnCrearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			int tam=modeloParticipantes.getSize();
			if(!tfNombre.getText().equals("") && !tfInicio.getText().equals("") && !tfFin.getText().equals("") && listP.getModel().getSize()>=1 && !tpDescrip.getText().equals("")) {
				Agente b;
				for(int i=0 ; i<tam ; i++) {	
					DividirCadena1(modeloParticipantes.getElementAt(i));
					DividirCadena2(cBPersonas.getSelectedItem().toString());
					String SQL_Consulta2 = "INSERT INTO Proyectos (DNI_Miembro, Nombre, Descripcion, Fecha_Creacion, Responsable, Fecha_Fin)"
							+ "VALUES ('"+identificador1+"','"+tfNombre.getText()+"','"+tpDescrip.getText()+"','"+tfInicio.getText()+"','"+id1+"','"+tfFin.getText()+"');";
					try {
						b = Agente.getAgenteUsuario();
						b.insert(SQL_Consulta2);
						
					}catch (Exception e1) {
						System.out.println(e1.getMessage());
						
					}
				}
				
				frmNuevoProyecto.dispose();
				GestorProy v=new GestorProy();
				v.getFrame().setVisible(true);
			}
			else {
				lblError.setText("Campos incorrectos");
			}
		}
	}
}
