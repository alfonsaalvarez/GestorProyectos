package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JList;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.border.TitledBorder;

import persistencia.Agente;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.TextArea;
import java.awt.Toolkit;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTextPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JToolBar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("unused")
public class Tareas {

	JFrame tarea;
	private JTextField textNombre;
	private JTextField textEncargado;
	private JTextField tfFin;
	private JTextField tfInicio;
	private JLabel lblFoto;
	private JTextArea textArea;
	private String tareaN;
	private JButton btnCargaFoto;
	private JScrollPane scrollPane;
	private JButton btnEditar;
	private JButton btnGuardar;
	private JLabel lblNombre;
	private JLabel lblEncargado;
	private JLabel lblFcreaacion;
	private JLabel lblFfinalizacion;
	@SuppressWarnings("rawtypes")
	private JComboBox estado;
	private DefaultListModel<String> modelo= new DefaultListModel<String>();
	private JList<String> listTareas;
	private JTextField tfRol;
	private JTextField tfComent;
	private JPanel panel;
	private JToolBar toolBar;
	private JButton btnAnotacion;
	private JButton btnRectangulo;
	private JScrollPane scrollPane_1;
	private JButton btnCargar;
	private MiAreaDibujo miAreaDibujo;
	
	private ImageIcon imagen;
	
	int modo = -1;
	private int x,y ;
	private final int RECTANGULO = 1;
	private final int TEXTO = 2;
	private Toolkit toolkit;
	private Image imagRectangulo;
	private Image imagTexto;
	private Cursor cursorRectangulo;
	private Cursor cursorTexto;
	private JTextField txtTexto = new JTextField();
	private JLabel lblNewLabel_1;
	private JLabel lblId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tareas window = new Tareas();
					window.tarea.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tareas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initialize() {
		tarea = new JFrame();
		tarea.setIconImage(Toolkit.getDefaultToolkit().getImage(Tareas.class.getResource("/presentacion/IconoSoftProject.png")));
		
		tarea.setTitle(MessagesTareas.getString("Tareas.tarea.title")); //$NON-NLS-1$
		tarea.setVisible(true);
		tarea.setBounds(100, 100, 878, 499);
		tarea.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{52, 178, 0, 0, 0, 62, 0, 134, 73, 83, 61, 52, 0};
		gridBagLayout.rowHeights = new int[]{35, 0, 0, 0, 32, 38, 48, 29, 0, 91, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		tarea.getContentPane().setLayout(gridBagLayout);
		tarea.setLocationRelativeTo(null);
		lblNewLabel_1 = new JLabel(MessagesTareas.getString("Tareas.lblNewLabel_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 1;
		tarea.getContentPane().add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JLabel lblNombre_1 = new JLabel(MessagesTareas.getString("Tareas.lblNombre_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNombre_1 = new GridBagConstraints();
		gbc_lblNombre_1.anchor = GridBagConstraints.EAST;
		gbc_lblNombre_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNombre_1.gridx = 6;
		gbc_lblNombre_1.gridy = 1;
		tarea.getContentPane().add(lblNombre_1, gbc_lblNombre_1);
		
		textNombre = new JTextField();
		textNombre.setEditable(false);
		GridBagConstraints gbc_textNombre = new GridBagConstraints();
		gbc_textNombre.gridwidth = 4;
		gbc_textNombre.insets = new Insets(0, 0, 5, 5);
		gbc_textNombre.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNombre.gridx = 7;
		gbc_textNombre.gridy = 1;
		tarea.getContentPane().add(textNombre, gbc_textNombre);
		textNombre.setColumns(10);
		
		JLabel lblEncargado_1 = new JLabel(MessagesTareas.getString("Tareas.lblEncargado_1.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEncargado_1 = new GridBagConstraints();
		gbc_lblEncargado_1.anchor = GridBagConstraints.EAST;
		gbc_lblEncargado_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblEncargado_1.gridx = 6;
		gbc_lblEncargado_1.gridy = 2;
		tarea.getContentPane().add(lblEncargado_1, gbc_lblEncargado_1);
		
		textEncargado = new JTextField();
		textEncargado.setEditable(false);
		GridBagConstraints gbc_textEncargado = new GridBagConstraints();
		gbc_textEncargado.gridwidth = 2;
		gbc_textEncargado.insets = new Insets(0, 0, 5, 5);
		gbc_textEncargado.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEncargado.gridx = 7;
		gbc_textEncargado.gridy = 2;
		tarea.getContentPane().add(textEncargado, gbc_textEncargado);
		textEncargado.setColumns(10);
		
		JLabel lblFechaDeCreacion = new JLabel(MessagesTareas.getString("Tareas.lblFechaDeCreacion.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblFechaDeCreacion = new GridBagConstraints();
		gbc_lblFechaDeCreacion.anchor = GridBagConstraints.WEST;
		gbc_lblFechaDeCreacion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeCreacion.gridx = 6;
		gbc_lblFechaDeCreacion.gridy = 3;
		tarea.getContentPane().add(lblFechaDeCreacion, gbc_lblFechaDeCreacion);
		
		tfInicio = new JTextField();
		tfInicio.setEditable(false);
		GridBagConstraints gbc_tfInicio = new GridBagConstraints();
		gbc_tfInicio.gridwidth = 2;
		gbc_tfInicio.insets = new Insets(0, 0, 5, 5);
		gbc_tfInicio.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfInicio.gridx = 7;
		gbc_tfInicio.gridy = 3;
		tarea.getContentPane().add(tfInicio, gbc_tfInicio);
		tfInicio.setColumns(10);
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridwidth = 3;
		gbc_panel.gridheight = 5;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		tarea.getContentPane().add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		toolBar = new JToolBar();
		panel.add(toolBar, BorderLayout.NORTH);
		
		btnAnotacion = new JButton();
		btnAnotacion.setToolTipText(MessagesTareas.getString("Tareas.btnAnotacion.toolTipText")); //$NON-NLS-1$
		btnAnotacion.setIcon(new ImageIcon(Tareas.class.getResource("/presentacion/aniadirAnotacion.png")));
		btnAnotacion.addActionListener(new BtnAnotacionActionListener());
		toolBar.add(btnAnotacion);
		
		btnRectangulo = new JButton(/*MessagesTareas.getString("Tareas.btnRectangulo.text")*/);
		btnRectangulo.setToolTipText(MessagesTareas.getString("Tareas.btnRectangulo.toolTipText")); //$NON-NLS-1$
		btnRectangulo.setIcon(new ImageIcon(Tareas.class.getResource("/presentacion/rectangulo.png")));
		btnRectangulo.addActionListener(new BtnRectanguloActionListener());
		toolBar.add(btnRectangulo);
		
		scrollPane_1 = new JScrollPane();
		panel.add(scrollPane_1, BorderLayout.CENTER);
		
		
		JLabel lblFechaDeFinalizcion = new JLabel(MessagesTareas.getString("Tareas.lblFechaDeFinalizcion.text")); //$NON-NLS-1$
		lblFechaDeFinalizcion.setFocusCycleRoot(true);
		GridBagConstraints gbc_lblFechaDeFinalizcion = new GridBagConstraints();
		gbc_lblFechaDeFinalizcion.gridwidth = 3;
		gbc_lblFechaDeFinalizcion.anchor = GridBagConstraints.EAST;
		gbc_lblFechaDeFinalizcion.insets = new Insets(0, 0, 5, 5);
		gbc_lblFechaDeFinalizcion.gridx = 4;
		gbc_lblFechaDeFinalizcion.gridy = 4;
		tarea.getContentPane().add(lblFechaDeFinalizcion, gbc_lblFechaDeFinalizcion);
		
		tfFin = new JTextField();
		tfFin.setEditable(false);
		GridBagConstraints gbc_tfFin = new GridBagConstraints();
		gbc_tfFin.gridwidth = 2;
		gbc_tfFin.insets = new Insets(0, 0, 5, 5);
		gbc_tfFin.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfFin.gridx = 7;
		gbc_tfFin.gridy = 4;
		tarea.getContentPane().add(tfFin, gbc_tfFin);
		tfFin.setColumns(10);
		
		JLabel lblEstado = new JLabel(MessagesTareas.getString("Tareas.lblEstado.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblEstado = new GridBagConstraints();
		gbc_lblEstado.anchor = GridBagConstraints.EAST;
		gbc_lblEstado.insets = new Insets(0, 0, 5, 5);
		gbc_lblEstado.gridx = 6;
		gbc_lblEstado.gridy = 5;
		tarea.getContentPane().add(lblEstado, gbc_lblEstado);
		
		estado = new JComboBox<String>();
		estado.setEnabled(false);
		estado.setModel(new DefaultComboBoxModel(new String[] {"COMPLETADA", "TARDIA", "ACTIVA"}));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.gridwidth = 2;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 7;
		gbc_comboBox.gridy = 5;
		tarea.getContentPane().add(estado, gbc_comboBox);
		
		JLabel lblRol = new JLabel(MessagesTareas.getString("Tareas.lblRol.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblRol = new GridBagConstraints();
		gbc_lblRol.anchor = GridBagConstraints.EAST;
		gbc_lblRol.insets = new Insets(0, 0, 5, 5);
		gbc_lblRol.gridx = 6;
		gbc_lblRol.gridy = 6;
		tarea.getContentPane().add(lblRol, gbc_lblRol);
		
		tfRol = new JTextField();
		tfRol.setEditable(false);
		GridBagConstraints gbc_tfRol = new GridBagConstraints();
		gbc_tfRol.insets = new Insets(0, 0, 5, 5);
		gbc_tfRol.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfRol.gridx = 7;
		gbc_tfRol.gridy = 6;
		tarea.getContentPane().add(tfRol, gbc_tfRol);
		tfRol.setColumns(10);
		
		JButton btnSalir = new JButton(MessagesTareas.getString("Tareas.btnSalir.text")); //$NON-NLS-1$
		btnSalir.addActionListener(new BtnSalirActionListener());
		
		btnCargar = new JButton(MessagesTareas.getString("Tareas.btnCargar.text")); //$NON-NLS-1$
		btnCargar.addActionListener(new BtnCargarActionListener());
		GridBagConstraints gbc_btnCargar = new GridBagConstraints();
		gbc_btnCargar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCargar.gridx = 1;
		gbc_btnCargar.gridy = 7;
		tarea.getContentPane().add(btnCargar, gbc_btnCargar);
		
		JLabel lblNewLabel = new JLabel(MessagesTareas.getString("Tareas.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 9;
		tarea.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		tfComent = new JTextField();
		tfComent.setEditable(false);
		GridBagConstraints gbc_tfComent = new GridBagConstraints();
		gbc_tfComent.gridwidth = 9;
		gbc_tfComent.insets = new Insets(0, 0, 5, 5);
		gbc_tfComent.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfComent.gridx = 2;
		gbc_tfComent.gridy = 9;
		tarea.getContentPane().add(tfComent, gbc_tfComent);
		tfComent.setColumns(10);
		
		lblId = new JLabel(MessagesTareas.getString("Tareas.lblId.text")); //$NON-NLS-1$
		lblId.setVisible(false);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 1;
		gbc_lblId.gridy = 11;
		tarea.getContentPane().add(lblId, gbc_lblId);
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSalir.insets = new Insets(0, 0, 0, 5);
		gbc_btnSalir.gridx = 8;
		gbc_btnSalir.gridy = 12;
		tarea.getContentPane().add(btnSalir, gbc_btnSalir);
		
		btnEditar = new JButton(MessagesTareas.getString("Tareas.btnEditar.text")); //$NON-NLS-1$
		btnEditar.addActionListener(new BtnEditarActionListener());
		GridBagConstraints gbc_btnEditar = new GridBagConstraints();
		gbc_btnEditar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnEditar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEditar.gridx = 9;
		gbc_btnEditar.gridy = 12;
		tarea.getContentPane().add(btnEditar, gbc_btnEditar);
		
		btnGuardar = new JButton(MessagesTareas.getString("Tareas.btnGuardar.text")); //$NON-NLS-1$
		btnGuardar.addActionListener(new BtnGuardarActionListener());
		GridBagConstraints gbc_btnGuardar = new GridBagConstraints();
		gbc_btnGuardar.insets = new Insets(0, 0, 0, 5);
		gbc_btnGuardar.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnGuardar.gridx = 10;
		gbc_btnGuardar.gridy = 12;
		tarea.getContentPane().add(btnGuardar, gbc_btnGuardar);
		
		miAreaDibujo = new MiAreaDibujo();
		miAreaDibujo.addMouseMotionListener(new MiAreaDibujoMouseMotionListener());
		miAreaDibujo.addMouseListener(new MiAreaDibujoMouseListener());
		miAreaDibujo.setIcon(null);
		scrollPane_1.setViewportView(miAreaDibujo);
		
		
		toolkit = Toolkit.getDefaultToolkit();
		
		imagRectangulo =toolkit.getImage(getClass().getClassLoader().getResource("assets/rectangulo.png"));
		imagTexto =toolkit.getImage(getClass().getClassLoader().getResource("assets/aniadirAnotacion.png"));
		cursorRectangulo = toolkit.createCustomCursor(imagRectangulo,new Point(0,0),"CURSOR_RECTANGULO");
		cursorTexto= toolkit.createCustomCursor(imagTexto,new Point(0,0),"CURSOR_TEXTO");
		btnGuardar.setEnabled(false);
		
	}
	
	public JFrame getFrame() {
		return tarea;
	}
	
	private void rellenarCampos() {
		String Consulta="SELECT Tareas.Id,Usuarios.Nombre,Usuarios.Apellidos,Tareas.Rol,Tareas.Fecha_Inicio,Tareas.Fecha_fin,Tareas.Estado,Tareas.Descripcion FROM Usuarios INNER JOIN Tareas ON Usuarios.DNI=Tareas.Usuario WHERE Tareas.Nombre_Tarea='"+tareaN+"';";
		Agente b;
		String id;
		try {
			b=Agente.getAgenteUsuario();
			ResultSet lista = b.select(Consulta);
			
			while(lista.next()) {
				id=lista.getString("Tareas.Id");
				textEncargado.setText(lista.getString("Usuarios.Nombre")+" "+lista.getString("Usuarios.Apellidos"));
				textNombre.setText(tareaN);
				tfInicio.setText(lista.getString("Fecha_Inicio"));
				tfFin.setText(lista.getString("Fecha_fin"));
				tfRol.setText(lista.getString("Tareas.Rol"));
				tfComent.setText(lista.getString("Tareas.Descripcion"));
				lblId.setText(id);
				if(lista.getString("Tareas.Estado").equals("COMPLETADA")) {
					estado.setSelectedIndex(0);
				}
				if(lista.getString("Tareas.Estado").equals("ACTIVA")) {
					estado.setSelectedIndex(2);
				}
				if(lista.getString("Tareas.estado").equals("TARDIA")) {
					estado.setSelectedIndex(1);
				}
			}
			
		} catch (Exception e3) {
			System.out.println(e3.getMessage());
		}
	}
	
	
	private class BtnEditarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			btnEditar.setEnabled(false);
			tfFin.setEditable(true);
			tfFin.setEnabled(true);
			estado.setEnabled(true);
			tfComent.setEditable(true);	
			btnGuardar.setEnabled(true);
			
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			tarea.dispose();
		}
	}
	private class BtnGuardarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			
			String cadena = null;
			
			if(estado.getSelectedIndex()==0) {
				cadena="COMPLETADA";
			}
			if(estado.getSelectedIndex()==1) {
				cadena="TARDIA";
			}
			if(estado.getSelectedIndex()==2) {
				cadena="ACTIVA";
			}
			
			Agente c;

			String SQL_Consulta = "UPDATE Tareas SET Fecha_fin='"+ tfFin.getText()+"',Estado='"+cadena+"',Descripcion='"+tfComent.getText()+"' WHERE Nombre_Tarea='"+textNombre.getText()+"';";
			
			try {
				c = Agente.getAgenteUsuario();
				c.update(SQL_Consulta);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				
			}
			
			tfFin.setEditable(false);
			tfFin.setEnabled(false);
			estado.setEnabled(false);
			tfComent.setEditable(false);	
			btnGuardar.setEnabled(false);
			btnEditar.setEnabled(true);
		}
	}
	private class BtnCargarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
				JFileChooser fcAbrir = new JFileChooser();
				int valorDevuelto = fcAbrir.showOpenDialog(tarea);
				if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				imagen = new ImageIcon(file.getAbsolutePath());
				miAreaDibujo.setIcon(imagen);
				}
		}
	}
	private class BtnAnotacionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = TEXTO;
			tarea.setCursor(cursorTexto);
		}
	}
	private class BtnRectanguloActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			modo = RECTANGULO;
			tarea.setCursor(cursorRectangulo);
		}
	}
	private class MiAreaDibujoMouseListener extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			x = e.getX();
			y = e.getY();
			toolkit = Toolkit.getDefaultToolkit();
			if (imagen != null){
				switch (modo){
				case RECTANGULO:
					miAreaDibujo.addObjetoGrafico(new RectanguloGrafico(x,y,x,y,Color.RED));
				break;
				case TEXTO:
					txtTexto.setBounds(x, y, 200,30);
					txtTexto.setVisible(true);
					txtTexto.requestFocus();
					txtTexto.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg) {
							if(!txtTexto.getText().equals(""))
								miAreaDibujo.addObjetoGrafico(new TextoGrafico(x, y+15, txtTexto.getText(),
										Color.BLUE));
							txtTexto.setText("");
							txtTexto.setVisible(false);
							miAreaDibujo.repaint();
						}
					});
					miAreaDibujo.add(txtTexto);
				}
			}
		}

	}

	private class MiAreaDibujoMouseMotionListener extends MouseMotionAdapter {
		@Override
		public void mouseDragged(MouseEvent e) {
			if (modo == RECTANGULO && imagen!=null) {
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setX1(e.getX());
				((RectanguloGrafico)miAreaDibujo.getUltimoObjetoGrafico()).setY1(e.getY());
				miAreaDibujo.repaint();
			}
		}
	}
	
	
	
	
	public void setNombre(String cadena) {
		tareaN=cadena;
		rellenarCampos();
	}
	
}
