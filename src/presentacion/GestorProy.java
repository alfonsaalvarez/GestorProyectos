package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.TextField;
import javax.swing.JTextPane;
import java.awt.event.ActionEvent;
import persistencia.Agente;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.List;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Toolkit;
import java.awt.Window;

import javax.swing.border.TitledBorder;
import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.ListSelectionModel;


@SuppressWarnings("unused")
public class GestorProy {
	private JFrame gestor_proyectos;
	private JTextField textFieldFecha;
	private JButton btnAñadir;
	private JButton btnModificar;
	private JButton btnBorrar;
	private JButton btnSalir;
	private JButton btnGuardar = new JButton(MessagesGestor_Proyectos.getString("Gestor_Proyectos.btnGuardar.text")); //$NON-NLS-1$
	private JTextField textResponsable=new JTextField();;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private DefaultListModel<String> modelo2 = new DefaultListModel<String>();
	private DefaultListModel<String> modelo3 = new DefaultListModel<String>();
	private JTextPane textPane = new JTextPane();
	private JTextPane textPaneDescripcion =new JTextPane();
	private JList<String> listTarea = new JList<String>();
	private String[][] data = new String[500][500];
	private JList<String> listMi = new JList<String>();
	private JList <String>listP = new JList<String>();
	private JTextField tfFin;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GestorProy window = new GestorProy();
					window.gestor_proyectos.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GestorProy() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		gestor_proyectos = new JFrame();
		gestor_proyectos.setTitle(MessagesGestor_Proyectos.getString("Gestor_Proyectos.gestor_proyectos.title")); //$NON-NLS-1$
		gestor_proyectos.setIconImage(Toolkit.getDefaultToolkit().getImage(GestorProy.class.getResource("/presentacion/IconoSoftProject.png")));
		gestor_proyectos.setBounds(100, 100, 1000, 948);
		gestor_proyectos.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		gestor_proyectos.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{34, 190, 125, 79, 29, 69, 85, 250, 40, 52, 72, 45};
		gridBagLayout.rowHeights = new int[]{34, 43, 72, 77, 55, 30, 79, 116, 134, 0, 60, 0, 69, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 1.0, Double.MIN_VALUE, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gestor_proyectos.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblResponsable = new JLabel(MessagesGestor_Proyectos.getString("Gestor_Proyectos.lblResponsable.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblResponsable = new GridBagConstraints();
		gbc_lblResponsable.anchor = GridBagConstraints.WEST;
		gbc_lblResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_lblResponsable.gridx = 1;
		gbc_lblResponsable.gridy = 1;
		gestor_proyectos.getContentPane().add(lblResponsable, gbc_lblResponsable);
		textResponsable.setEditable(false);
		GridBagConstraints gbc_textResponsable = new GridBagConstraints();
		gbc_textResponsable.gridwidth = 2;
		gbc_textResponsable.insets = new Insets(0, 0, 5, 5);
		gbc_textResponsable.fill = GridBagConstraints.HORIZONTAL;
		gbc_textResponsable.gridx = 2;
		gbc_textResponsable.gridy = 1;
		gestor_proyectos.getContentPane().add(textResponsable, gbc_textResponsable);
		textResponsable.setColumns(10);
		
		JLabel lblFechaDeCreacion = new JLabel(MessagesGestor_Proyectos.getString("Gestor_Proyectos.lblFechaDeCreacion.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeCreacion = new GridBagConstraints();
		gbc_lblFechaDeCreacion.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeCreacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeCreacion.gridx = 1;
		gbc_lblFechaDeCreacion.gridy = 2;
		gestor_proyectos.getContentPane().add(lblFechaDeCreacion, gbc_lblFechaDeCreacion);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		GridBagConstraints gbc_textFieldFecha = new GridBagConstraints();
		gbc_textFieldFecha.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldFecha.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldFecha.gridx = 2;
		gbc_textFieldFecha.gridy = 2;
		gestor_proyectos.getContentPane().add(textFieldFecha, gbc_textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblFin = new JLabel(MessagesGestor_Proyectos.getString("Gestor_Proyectos.lblFin.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFin = new GridBagConstraints();
		gbc_lblFin.anchor = GridBagConstraints.EAST;
		gbc_lblFin.insets = new Insets(0, 0, 5, 5);
		gbc_lblFin.gridx = 7;
		gbc_lblFin.gridy = 2;
		gestor_proyectos.getContentPane().add(lblFin, gbc_lblFin);
		
		tfFin = new JTextField();
		tfFin.setEditable(false);
		GridBagConstraints gbc_tfFin = new GridBagConstraints();
		gbc_tfFin.gridwidth = 3;
		gbc_tfFin.insets = new Insets(0, 0, 5, 5);
		gbc_tfFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFin.gridx = 8;
		gbc_tfFin.gridy = 2;
		gestor_proyectos.getContentPane().add(tfFin, gbc_tfFin);
		tfFin.setColumns(10);
		
		
		listMi.setBorder(new TitledBorder(null, MessagesGestor_Proyectos.getString("Gestor_Proyectos.listMi.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		listMi.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_listMi = new GridBagConstraints();
		gbc_listMi.gridheight = 3;
		gbc_listMi.gridwidth = 4;
		gbc_listMi.insets = new Insets(0, 0, 5, 5);
		gbc_listMi.fill = GridBagConstraints.BOTH;
		gbc_listMi.gridx = 1;
		gbc_listMi.gridy = 3;
		gestor_proyectos.getContentPane().add(listMi, gbc_listMi);
		setProyectos();
		listP.addListSelectionListener(new ListPListSelectionListener());
		
		
		listP.setBorder(new TitledBorder(null, MessagesGestor_Proyectos.getString("Gestor_Proyectos.listP.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		listP.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_listP = new GridBagConstraints();
		gbc_listP.gridheight = 6;
		gbc_listP.gridwidth = 5;
		gbc_listP.insets = new Insets(0, 0, 5, 5);
		gbc_listP.fill = GridBagConstraints.BOTH;
		gbc_listP.gridx = 6;
		gbc_listP.gridy = 3;
		gestor_proyectos.getContentPane().add(listP, gbc_listP);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridheight = 2;
		gbc_scrollPane.gridwidth = 4;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 6;
		gestor_proyectos.getContentPane().add(scrollPane, gbc_scrollPane);
		
				textPaneDescripcion = new JTextPane();
				scrollPane.setViewportView(textPaneDescripcion);
				textPaneDescripcion.setEditable(false);
				textPaneDescripcion.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), MessagesGestor_Proyectos.getString("Gestor_Proyectos.textPaneDescripcion.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))); //$NON-NLS-2$
				
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 3;
		gbc_panel.gridwidth = 4;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 8;
		gestor_proyectos.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
				
		listTarea.setBorder(new TitledBorder(null, MessagesGestor_Proyectos.getString("Gestor_Proyectos.listTarea.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		listTarea.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTarea.setToolTipText(MessagesGestor_Proyectos.getString("Gestor_Proyectos.listTarea.toolTipText")); //$NON-NLS-1$
		//listTarea.addListSelectionListener(new ListTareaListSelectionListener());
		panel.add(listTarea, BorderLayout.CENTER);
																										
		JButton btnTareas = new JButton(MessagesGestor_Proyectos.getString("Gestor_Proyectos.btnTareas.text")); //$NON-NLS-1$
		GridBagConstraints gbc_btnTareas = new GridBagConstraints();
		gbc_btnTareas.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnTareas.insets = new Insets(0, 0, 5, 5);
		gbc_btnTareas.gridx = 1;
		gbc_btnTareas.gridy = 11;
		gestor_proyectos.getContentPane().add(btnTareas, gbc_btnTareas);
		btnTareas.addActionListener(new BtnAñadirTareaActionListener());
		JButton btnAñadir_1 = new JButton("A\u00F1adir proyecto"); //$NON-NLS-1$
		btnAñadir_1.addActionListener(new BtnAñadirActionListener());
		
		JButton btnNueva = new JButton(MessagesGestor_Proyectos.getString("Gestor_Proyectos.btnNueva.text")); //$NON-NLS-1$
		btnNueva.addActionListener(new BtnNuevaActionListener());
		GridBagConstraints gbc_btnNueva = new GridBagConstraints();
		gbc_btnNueva.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNueva.insets = new Insets(0, 0, 5, 5);
		gbc_btnNueva.gridx = 2;
		gbc_btnNueva.gridy = 11;
		gestor_proyectos.getContentPane().add(btnNueva, gbc_btnNueva);
		
		JButton btnEliminar = new JButton(MessagesGestor_Proyectos.getString("Gestor_Proyectos.btnEliminar.text")); //$NON-NLS-1$
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		GridBagConstraints gbc_btnEliminar = new GridBagConstraints();
		gbc_btnEliminar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEliminar.gridwidth = 2;
		gbc_btnEliminar.insets = new Insets(0, 0, 5, 5);
		gbc_btnEliminar.gridx = 3;
		gbc_btnEliminar.gridy = 11;
		gestor_proyectos.getContentPane().add(btnEliminar, gbc_btnEliminar);
		GridBagConstraints gbc_btnAñadir_1 = new GridBagConstraints();
		gbc_btnAñadir_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAñadir_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnAñadir_1.gridx = 1;
		gbc_btnAñadir_1.gridy = 13;
		gestor_proyectos.getContentPane().add(btnAñadir_1, gbc_btnAñadir_1);
		JButton btnModificar_1 = new JButton(MessagesGestor_Proyectos.getString("Gestor_Proyectos.btnModificar_1.text")); //$NON-NLS-1$
		btnModificar_1.addActionListener(new BtnModificarActionListener());
		GridBagConstraints gbc_btnModificar_1 = new GridBagConstraints();
		gbc_btnModificar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnModificar_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnModificar_1.gridx = 2;
		gbc_btnModificar_1.gridy = 13;
		gestor_proyectos.getContentPane().add(btnModificar_1, gbc_btnModificar_1);
		JButton btnSalir_1 = new JButton(MessagesGestor_Proyectos.getString("Gestor_Proyectos.btnSalir_1.text")); //$NON-NLS-1$
		btnSalir_1.addActionListener(new BtnSalirActionListener());
		JButton btnBorrar_1 = new JButton(MessagesGestor_Proyectos.getString("Gestor_Proyectos.btnBorrar_1.text")); //$NON-NLS-1$
		btnBorrar_1.addActionListener(new BtnBorrarActionListener());
		GridBagConstraints gbc_btnBorrar_1 = new GridBagConstraints();
		gbc_btnBorrar_1.gridwidth = 2;
		gbc_btnBorrar_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBorrar_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnBorrar_1.gridx = 3;
		gbc_btnBorrar_1.gridy = 13;
		gestor_proyectos.getContentPane().add(btnBorrar_1, gbc_btnBorrar_1);
		
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.gridwidth = 2;
		gbc_btnGuardar.insets = new Insets(0, 0, 5, 5);
		gbc_btnGuardar.gridx = 5;
		gbc_btnGuardar.gridy = 13;
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		gestor_proyectos.getContentPane().add(btnGuardar, gbc_btnGuardar);
		GridBagConstraints gbc_btnSalir_1 = new GridBagConstraints();
		gbc_btnSalir_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalir_1.gridwidth = 3;
		gbc_btnSalir_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnSalir_1.gridx = 8;
		gbc_btnSalir_1.gridy = 13;
		gestor_proyectos.getContentPane().add(btnSalir_1, gbc_btnSalir_1);
		btnGuardar.setEnabled(false);
	}
	
	
	private void setProyectos(){
		String Consulta="SELECT DISTINCT Nombre FROM Proyectos";
		Agente b;
		String nombre;
		modelo.addElement("");
		modelo.removeAllElements();
		try {
			b=Agente.getAgenteUsuario();
			ResultSet lista = b.select(Consulta);
			
			while(lista.next()) {
				nombre=lista.getString("Nombre");
				modelo.addElement(nombre);
				listP.setModel(modelo);
			}
			
		} catch (Exception e3) {
			System.out.println(e3.getMessage());
		}
	}
	
	private class BtnAñadirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NuevoProyecto v=new NuevoProyecto();
			v.getFrame().setVisible(true);
			gestor_proyectos.dispose();
		}
		

	}

	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Salir ventana= new Salir ();
			ventana.setVisible(true);
			gestor_proyectos.dispose();	
		}
	}
	private class BtnBorrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Agente b;
			String SQL_Consulta = "DELETE * FROM Proyectos WHERE Nombre='"+listP.getSelectedValue()+"';";
			try {
				b = Agente.getAgenteUsuario();
				b.delete(SQL_Consulta);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				
			}
			setProyectos();
			setLista();
		}
	}
	
	private class BtnModificarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			tfFin.setEditable(true);
			textPaneDescripcion.setEditable(true);
			btnGuardar.setEnabled(true);
		}
	}
	private class BtnAñadirTareaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Tareas t=new Tareas();
			t.setNombre(listTarea.getSelectedValue());
			t.tarea.setVisible(true);	
		}
	}
	public void setLista() {
		modelo2.addElement("");
		modelo2.removeAllElements();
		modelo3.addElement("");
		modelo3.removeAllElements();
		
		String Consulta="SELECT Usuarios.Nombre,Usuarios.Apellidos,Proyectos.Descripcion,Proyectos.Fecha_Creacion,Proyectos.Fecha_Fin FROM Proyectos INNER JOIN Usuarios ON Usuarios.DNI=Proyectos.DNI_Miembro WHERE Proyectos.Nombre='"+listP.getSelectedValue()+"';";
		Agente b;
		
		try {
			b=Agente.getAgenteUsuario();
			ResultSet lista = b.select(Consulta);
			
			while(lista.next()) {
				modelo2.addElement(lista.getString("Nombre")+" "+lista.getString("Apellidos"));
				listMi.setModel(modelo2);
				textFieldFecha.setText(lista.getString("Fecha_Creacion"));
				tfFin.setText(lista.getString("Fecha_Fin"));
				textPaneDescripcion.setText(lista.getString("Proyectos.Descripcion"));
			}
			
		} catch (Exception e3) {
			System.out.println(e3.getMessage());
		}
		
		String Consulta1="SELECT Usuarios.Nombre,Usuarios.Apellidos FROM Proyectos INNER JOIN Usuarios ON Usuarios.DNI=Proyectos.Responsable WHERE Proyectos.Nombre='"+listP.getSelectedValue()+"';";
		Agente c;
		
		try {
			c=Agente.getAgenteUsuario();
			ResultSet lista = c.select(Consulta1);
			while(lista.next()) {
				textResponsable.setText(lista.getString("Nombre")+" "+lista.getString("Apellidos"));
			}
			
		} catch (Exception e3) {
			System.out.println(e3.getMessage());
		}
		
		String Consulta2="SELECT Nombre_Tarea FROM Tareas WHERE Id_Proyecto='"+listP.getSelectedValue()+"';";
		Agente d;
		
		try {
			d=Agente.getAgenteUsuario();
			ResultSet lista = d.select(Consulta2);
			while(lista.next()) {
				modelo3.addElement(lista.getString("Nombre_Tarea"));
				listTarea.setModel(modelo3);
			}
			
		} catch (Exception e3) {
			System.out.println(e3.getMessage());
		}
	}
	private class ListPListSelectionListener implements ListSelectionListener {
		public void valueChanged(ListSelectionEvent arg0) {
			setLista();
		}
	}
	
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		
			Agente c;
			String SQL_Consulta = "UPDATE Proyectos SET Fecha_Fin='"+ tfFin.getText()+"',Descripcion='"+textPaneDescripcion.getText()+"' WHERE Nombre='"+listP.getSelectedValue()+"';";
			
			try {
				c = Agente.getAgenteUsuario();
				c.update(SQL_Consulta);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				
			}
			
			
			tfFin.setEditable(false);
			btnGuardar.setEnabled(false);
		}
	}
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Agente b;
			String SQL_Consulta = "DELETE * FROM Tareas WHERE Nombre_Tarea='"+listTarea.getSelectedValue()+"';";
			try {
				b = Agente.getAgenteUsuario();
				b.delete(SQL_Consulta);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				
			}
			setLista();
		}
	}
	private class BtnNuevaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			NuevaTarea v=new NuevaTarea();
			v.setNombre(listP.getSelectedValue());
			gestor_proyectos.dispose();
			v.getFrame().setVisible(true);
		}
	}
	
	public JFrame getFrame() {
		return gestor_proyectos;
	}

}



