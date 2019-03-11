package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JList;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.Toolkit;
import javax.swing.ListSelectionModel;

import persistencia.Agente;

import javax.swing.JTextArea;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;

public class NuevoMensaje {

	private JFrame frmNuevoMensaje;
	private JTextField tfAsunto;
	private JLabel lblAsunto;
	private JLabel lblNewLabel;
	private JTextArea tAMensaje;
	private JButton btnEnviar;
	private JButton btnSalir;
	private String dni,hora,minutos,ampm;
	private JList<String> listDestinatario = new JList<String>();
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private JButton btnAdjuntarArchivo;
	private JLabel lblAdj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NuevoMensaje window = new NuevoMensaje();
					window.frmNuevoMensaje.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public NuevoMensaje() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmNuevoMensaje = new JFrame();
		frmNuevoMensaje.setIconImage(Toolkit.getDefaultToolkit().getImage(NuevoMensaje.class.getResource("/presentacion/IconoSoftProject.png")));
		frmNuevoMensaje.setTitle(MessagesNuevoMensaje.getString("NuevoMensaje.frmNuevoMensaje.title")); //$NON-NLS-1$
		frmNuevoMensaje.setBounds(100, 100, 805, 457);
		frmNuevoMensaje.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmNuevoMensaje.setLocationRelativeTo(null);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{216, 145, 296, 0};
		gridBagLayout.rowHeights = new int[]{4, 0, 174, 63, 238, 58, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		frmNuevoMensaje.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblDestinatario = new JLabel(MessagesNuevoMensaje.getString("NuevoMensaje.lblDestinatario.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblDestinatario = new GridBagConstraints();
		gbc_lblDestinatario.anchor = GridBagConstraints.SOUTH;
		gbc_lblDestinatario.insets = new Insets(0, 0, 5, 5);
		gbc_lblDestinatario.gridx = 0;
		gbc_lblDestinatario.gridy = 1;
		frmNuevoMensaje.getContentPane().add(lblDestinatario, gbc_lblDestinatario);
		
		listDestinatario.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		GridBagConstraints gbc_listDestinatario = new GridBagConstraints();
		gbc_listDestinatario.insets = new Insets(0, 0, 5, 5);
		gbc_listDestinatario.fill = GridBagConstraints.BOTH;
		gbc_listDestinatario.gridx = 0;
		gbc_listDestinatario.gridy = 2;
		frmNuevoMensaje.getContentPane().add(listDestinatario, gbc_listDestinatario);
		
		lblAsunto = new JLabel(MessagesNuevoMensaje.getString("NuevoMensaje.lblAsunto.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblAsunto = new GridBagConstraints();
		gbc_lblAsunto.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAsunto.insets = new Insets(0, 0, 5, 5);
		gbc_lblAsunto.gridx = 1;
		gbc_lblAsunto.gridy = 2;
		frmNuevoMensaje.getContentPane().add(lblAsunto, gbc_lblAsunto);
		
		tfAsunto = new JTextField();
		GridBagConstraints gbc_tfAsunto = new GridBagConstraints();
		gbc_tfAsunto.anchor = GridBagConstraints.NORTH;
		gbc_tfAsunto.fill = GridBagConstraints.HORIZONTAL;
		gbc_tfAsunto.insets = new Insets(0, 0, 5, 0);
		gbc_tfAsunto.gridx = 2;
		gbc_tfAsunto.gridy = 2;
		frmNuevoMensaje.getContentPane().add(tfAsunto, gbc_tfAsunto);
		tfAsunto.setColumns(10);
		
		lblNewLabel = new JLabel(MessagesNuevoMensaje.getString("NuevoMensaje.lblNewLabel.text")); //$NON-NLS-1$
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.SOUTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 3;
		frmNuevoMensaje.getContentPane().add(lblNewLabel, gbc_lblNewLabel);
		
		btnAdjuntarArchivo = new JButton(MessagesNuevoMensaje.getString("NuevoMensaje.btnAdjuntarArchivo.text")); //$NON-NLS-1$
		btnAdjuntarArchivo.setIcon(new ImageIcon(NuevoMensaje.class.getResource("adjuntar.png")));
		btnAdjuntarArchivo.addActionListener(new ButtonActionListener());
		
		lblAdj = new JLabel(MessagesNuevoMensaje.getString("NuevoMensaje.lblAdj.text")); //$NON-NLS-1$
		lblAdj.setFont(new Font("Comic Sans MS", Font.PLAIN, 15));
		lblAdj.setVisible(false);
		GridBagConstraints gbc_lblAdj = new GridBagConstraints();
		gbc_lblAdj.insets = new Insets(0, 0, 5, 5);
		gbc_lblAdj.gridx = 1;
		gbc_lblAdj.gridy = 3;
		frmNuevoMensaje.getContentPane().add(lblAdj, gbc_lblAdj);
		GridBagConstraints gbc_btnAdjuntarArchivo = new GridBagConstraints();
		gbc_btnAdjuntarArchivo.fill = GridBagConstraints.BOTH;
		gbc_btnAdjuntarArchivo.insets = new Insets(0, 0, 5, 0);
		gbc_btnAdjuntarArchivo.gridx = 2;
		gbc_btnAdjuntarArchivo.gridy = 3;
		frmNuevoMensaje.getContentPane().add(btnAdjuntarArchivo, gbc_btnAdjuntarArchivo);
		
		tAMensaje = new JTextArea();
		GridBagConstraints gbc_tAMensaje = new GridBagConstraints();
		gbc_tAMensaje.gridwidth = 3;
		gbc_tAMensaje.insets = new Insets(0, 0, 5, 0);
		gbc_tAMensaje.fill = GridBagConstraints.BOTH;
		gbc_tAMensaje.gridx = 0;
		gbc_tAMensaje.gridy = 4;
		frmNuevoMensaje.getContentPane().add(tAMensaje, gbc_tAMensaje);
		
		btnEnviar = new JButton(MessagesNuevoMensaje.getString("NuevoMensaje.btnEnviar.text")); //$NON-NLS-1$
		btnEnviar.addActionListener(new BtnEnviarActionListener());
		GridBagConstraints gbc_btnEnviar = new GridBagConstraints();
		gbc_btnEnviar.fill = GridBagConstraints.BOTH;
		gbc_btnEnviar.insets = new Insets(0, 0, 0, 5);
		gbc_btnEnviar.gridx = 0;
		gbc_btnEnviar.gridy = 5;
		frmNuevoMensaje.getContentPane().add(btnEnviar, gbc_btnEnviar);
		
		btnSalir = new JButton(MessagesNuevoMensaje.getString("NuevoMensaje.btnSalir.text")); //$NON-NLS-1$
		btnSalir.addActionListener(new BtnSalirActionListener());
		GridBagConstraints gbc_btnSalir = new GridBagConstraints();
		gbc_btnSalir.fill = GridBagConstraints.BOTH;
		gbc_btnSalir.gridx = 2;
		gbc_btnSalir.gridy = 5;
		frmNuevoMensaje.getContentPane().add(btnSalir, gbc_btnSalir);
		
	}
	public void setLista() {
		Agente b;
		String SQL_Consulta = "SELECT Nombre,DNI FROM Usuarios;";
		String nombre,id;
		
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				nombre=lista.getString("Nombre");
				id=lista.getString("DNI");
				if(!id.equals(dni)) {
					modelo.addElement(id+"- "+nombre);
					listDestinatario.setModel(modelo);
				}
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public JFrame getFrame() {
		return frmNuevoMensaje;
	}
	
	public void setDNI(String DNI) {
		dni=DNI;
		setLista();
	}
	
	public String obtenerDatos(String texto) {
		String cadena = null;
		for(int c=0 ; c<texto.length() ; c++) {
			if(texto.charAt(c)=='-')
				cadena=texto.substring(0, c);
		}
		
		return cadena;
	}
	private void obtenerHora() {
		Date fechaHoraActual = new Date();
		Calendar calendario = new GregorianCalendar();
        calendario.setTime(fechaHoraActual);
        ampm = calendario.get(Calendar.AM_PM) == Calendar.AM ? "AM" : "PM";

        if (ampm.equals("PM")) {
            int h = calendario.get(Calendar.HOUR_OF_DAY);
            hora = h > 9 ? "" + h : "0" + h;
        } else {
            hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        }
        minutos = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        //segundos = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);
        
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			lblAdj.setVisible(false);
			frmNuevoMensaje.dispose();
		}
	}
	private class BtnEnviarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Calendar fecha = new GregorianCalendar();
			int anio = fecha.get(Calendar.YEAR);
	        int mes = fecha.get(Calendar.MONTH)+1;
	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
	        obtenerHora();
			Agente b;
			String SQL_Consulta2 = "INSERT INTO Correos (Emisor, Receptor, Texto, Fecha, Hora, Asunto)"
					+ "VALUES ('"+dni+"','"+obtenerDatos(listDestinatario.getSelectedValue())+"','"+tAMensaje.getText()+"','"+dia+"/"+mes+"/"+anio+"','"+hora+":"+minutos+"','"+tfAsunto.getText()+"');";
			try {
				b = Agente.getAgenteUsuario();
				b.insert(SQL_Consulta2);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
				
			}
			lblAdj.setVisible(false);
			frmNuevoMensaje.dispose();
			Confirmacion ventana =new Confirmacion();
			ventana.getFrame().setVisible(true);
		}
	}
	private class ButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JFileChooser fcAbrir = new JFileChooser();
			int valorDevuelto = fcAbrir.showOpenDialog(frmNuevoMensaje);
			//Recoger el nombre del fichero seleccionado por el usuario
			if (valorDevuelto == JFileChooser.APPROVE_OPTION) {
				File file = fcAbrir.getSelectedFile();
				lblAdj.setVisible(true);
				lblAdj.setText("Adjunto: " + file.getName());
			}
		}
	}
}
