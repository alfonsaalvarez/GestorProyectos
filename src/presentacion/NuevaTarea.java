package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import persistencia.Agente;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class NuevaTarea {

	private JFrame frmNuevaTarea;
	private JTextField tfProyecto;
	private JTextField tfInicio;
	private JTextField tfFin;
	private JTextField tfTarea;
	private JTextField tfRol;
	private String[] personas=new String[255];
	private String id;
	private JTextPane tpDescripcion;
	@SuppressWarnings("rawtypes")
	private JComboBox cbUsuarios;
	@SuppressWarnings("rawtypes")
	private JComboBox cbEstado;
	private JLabel lblError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevaTarea window = new NuevaTarea();
					window.frmNuevaTarea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevaTarea() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private void initialize() {
		frmNuevaTarea = new JFrame();
		frmNuevaTarea.setIconImage(Toolkit.getDefaultToolkit().getImage(NuevaTarea.class.getResource("/presentacion/IconoSoftProject.png")));
		frmNuevaTarea.setTitle(MessagesNuevaTarea.getString("NuevaTarea.frmNuevaTarea.title")); //$NON-NLS-1$
		frmNuevaTarea.setBounds(100, 100, 696, 731);
		frmNuevaTarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{53, 0, 232, 45, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 52, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 67, 58, 40, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frmNuevaTarea.getContentPane().setLayout(gridBagLayout);
		frmNuevaTarea.setLocationRelativeTo(null);
		JLabel lblNewLabel_3 = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblNewLabel_3.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 1;
		gbc_lblNewLabel_3.gridy = 2;
		frmNuevaTarea.getContentPane().add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		tfTarea = new JTextField();
		GridBagConstraints gbc_tfTarea = new GridBagConstraints();
		gbc_tfTarea.insets = new Insets(0, 0, 5, 5);
		gbc_tfTarea.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfTarea.gridx = 2;
		gbc_tfTarea.gridy = 2;
		frmNuevaTarea.getContentPane().add(tfTarea, gbc_tfTarea);
		tfTarea.setColumns(10);
		
		JLabel lblUsuario = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblUsuario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblUsuario = new GridBagConstraints();
		gbc_lblUsuario.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsuario.anchor = GridBagConstraints.EAST;
		gbc_lblUsuario.gridx = 1;
		gbc_lblUsuario.gridy = 4;
		frmNuevaTarea.getContentPane().add(lblUsuario, gbc_lblUsuario);
		setUsuarios();
		//@SuppressWarnings({ "rawtypes", "unchecked" })
		cbUsuarios = new JComboBox(personas);
		GridBagConstraints gbc_cbUsuarios = new GridBagConstraints();
		gbc_cbUsuarios.insets = new Insets(0, 0, 5, 5);
		gbc_cbUsuarios.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbUsuarios.gridx = 2;
		gbc_cbUsuarios.gridy = 4;
		frmNuevaTarea.getContentPane().add(cbUsuarios, gbc_cbUsuarios);
		
		JLabel lblNewLabel = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 6;
		frmNuevaTarea.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		tfProyecto = new JTextField();
		tfProyecto.setEditable(false);
		GridBagConstraints gbc_tfProyecto = new GridBagConstraints();
		gbc_tfProyecto.insets = new Insets(0, 0, 5, 5);
		gbc_tfProyecto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfProyecto.gridx = 2;
		gbc_tfProyecto.gridy = 6;
		frmNuevaTarea.getContentPane().add(tfProyecto, gbc_tfProyecto);
		tfProyecto.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblNewLabel_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 8;
		frmNuevaTarea.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		tfInicio = new JTextField();
		GridBagConstraints gbc_tfInicio = new GridBagConstraints();
		gbc_tfInicio.insets = new Insets(0, 0, 5, 5);
		gbc_tfInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfInicio.gridx = 2;
		gbc_tfInicio.gridy = 8;
		frmNuevaTarea.getContentPane().add(tfInicio, gbc_tfInicio);
		tfInicio.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblNewLabel_2.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 10;
		frmNuevaTarea.getContentPane().add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tfFin = new JTextField();
		GridBagConstraints gbc_tfFin = new GridBagConstraints();
		gbc_tfFin.insets = new Insets(0, 0, 5, 5);
		gbc_tfFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFin.gridx = 2;
		gbc_tfFin.gridy = 10;
		frmNuevaTarea.getContentPane().add(tfFin, gbc_tfFin);
		tfFin.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblNewLabel_4.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 12;
		frmNuevaTarea.getContentPane().add(lblNewLabel_4, gbc_lblNewLabel_4);
		
		//@SuppressWarnings("rawtypes")
		cbEstado = new JComboBox();
		cbEstado.setModel(new DefaultComboBoxModel(new String[] {"COMPLETADA", "TARDIA", "ACTIVA"}));
		GridBagConstraints gbc_cbEstado = new GridBagConstraints();
		gbc_cbEstado.insets = new Insets(0, 0, 5, 5);
		gbc_cbEstado.fill = GridBagConstraints.HORIZONTAL;
		gbc_cbEstado.gridx = 2;
		gbc_cbEstado.gridy = 12;
		frmNuevaTarea.getContentPane().add(cbEstado, gbc_cbEstado);
		
		JLabel lblNewLabel_5 = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblNewLabel_5.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 1;
		gbc_lblNewLabel_5.gridy = 14;
		frmNuevaTarea.getContentPane().add(lblNewLabel_5, gbc_lblNewLabel_5);
		
		tfRol = new JTextField();
		GridBagConstraints gbc_tfRol = new GridBagConstraints();
		gbc_tfRol.insets = new Insets(0, 0, 5, 5);
		gbc_tfRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRol.gridx = 2;
		gbc_tfRol.gridy = 14;
		frmNuevaTarea.getContentPane().add(tfRol, gbc_tfRol);
		tfRol.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblNewLabel_6.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 1;
		gbc_lblNewLabel_6.gridy = 16;
		frmNuevaTarea.getContentPane().add(lblNewLabel_6, gbc_lblNewLabel_6);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 2;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 17;
		frmNuevaTarea.getContentPane().add(scrollPane, gbc_scrollPane);
		
		tpDescripcion = new JTextPane();
		scrollPane.setViewportView(tpDescripcion);
		
		lblError = new JLabel(MessagesNuevaTarea.getString("NuevaTarea.lblError.text")); //$NON-NLS-1$
		lblError.setVisible(false);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 19;
		frmNuevaTarea.getContentPane().add(lblError, gbc_lblError);
		
		JButton btnCrear = new JButton(MessagesNuevaTarea.getString("NuevaTarea.btnCrear.text")); //$NON-NLS-1$
		btnCrear.addActionListener(new BtnCrearActionListener());
		GridBagConstraints gbc_btnCrear = new GridBagConstraints();
		gbc_btnCrear.insets = new Insets(0, 0, 5, 5);
		gbc_btnCrear.gridx = 1;
		gbc_btnCrear.gridy = 20;
		frmNuevaTarea.getContentPane().add(btnCrear, gbc_btnCrear);
		
		JButton btnSalir = new JButton(MessagesNuevaTarea.getString("NuevaTarea.btnSalir.text")); //$NON-NLS-1$
		btnSalir.addActionListener(new BtnSalirActionListener());
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 20;
		frmNuevaTarea.getContentPane().add(btnSalir, gbc_btnSalir);

	}

	public void setUsuarios() {
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
	
	private void DividirCadena(String cadena) {
		char letra;
		for(int i=0 ; i<cadena.length() ; i++) {
			letra=cadena.charAt(i);
			if(letra=='-') {
				id=cadena.substring(0, i);
			}
		}
		
	}
	
	public void setNombre(String cadena) {
		tfProyecto.setText(cadena);
	}
	public JFrame getFrame() {
		return frmNuevaTarea;
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmNuevaTarea.dispose();
			GestorProy v=new GestorProy();
			v.getFrame().setVisible(true);
		}
	}
	private class BtnCrearActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(!tfTarea.getText().equals("") && !tfInicio.getText().equals("") && !tfFin.getText().equals("") && !tfRol.getText().equals("") && !tpDescripcion.getText().equals("")) {
				Agente b;
				DividirCadena(cbUsuarios.getSelectedItem().toString());
				String SQL_Consulta2 = "INSERT INTO Tareas (Usuario,Id_Proyecto, Rol, Fecha_Inicio, Fecha_fin, Estado,Descripcion,Nombre_Tarea)"
						+ "VALUES ('"+id+"','"+tfProyecto.getText()+"','"+tfRol.getText()+"','"+tfInicio.getText()+"','"+tfFin.getText()+"','"+cbEstado.getSelectedItem().toString()+"','"+tpDescripcion.getText()+"','"+tfTarea.getText()+"');";
				try {
					b = Agente.getAgenteUsuario();
					b.insert(SQL_Consulta2);
					
				}catch (Exception e1) {
					System.out.println(e1.getMessage());
					
				}
				
				frmNuevaTarea.dispose();
				GestorProy v=new GestorProy();
				v.getFrame().setVisible(true);
			}
			else
				lblError.setText("Campos incorrectos");
		}
	}
}
