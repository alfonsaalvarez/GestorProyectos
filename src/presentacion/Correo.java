package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Toolkit;
import persistencia.Agente;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.sql.ResultSet;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;

public class Correo {

	private JFrame frmCorreo;
	private JTextPane tPTexto = new JTextPane();
	private String dni,nombre,id,fecha,hora,asunto;
	private JTable table;
	private int c=0;
	private String[][] data = new String[500][500];
	private String[] columnNames = {"De","Asunto","Fecha de envio"};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Correo window = new Correo();
					window.frmCorreo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Correo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCorreo = new JFrame();
		frmCorreo.setIconImage(Toolkit.getDefaultToolkit().getImage(Correo.class.getResource("IconoSoftProject.png")));
		frmCorreo.setResizable(false);
		frmCorreo.setTitle(MessagesCorreo.getString("Correo.frmCorreo.title")); //$NON-NLS-1$
		frmCorreo.setBounds(100, 100, 621, 578);
		frmCorreo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCorreo.getContentPane().setLayout(null);
		frmCorreo.setLocationRelativeTo(null);
		tPTexto.setEditable(false);
		tPTexto.setBounds(40, 285, 522, 127);
		frmCorreo.getContentPane().add(tPTexto);
		JButton btnEliminar = new JButton(MessagesCorreo.getString("Correo.btnEliminar.text")); //$NON-NLS-1$
		btnEliminar.addActionListener(new BtnEliminarActionListener());
		btnEliminar.setBounds(231, 459, 151, 46);
		frmCorreo.getContentPane().add(btnEliminar);
		JButton btnNuevo = new JButton(MessagesCorreo.getString("Correo.btnNuevo.text")); //$NON-NLS-1$
		btnNuevo.addActionListener(new BtnNuevoActionListener());
		btnNuevo.setBounds(40, 459, 140, 46);
		frmCorreo.getContentPane().add(btnNuevo);
		JButton btnNewButton = new JButton(MessagesCorreo.getString("Correo.btnNewButton.text")); //$NON-NLS-1$
		btnNewButton.addActionListener(new BtnNewButtonActionListener());
		btnNewButton.setBounds(435, 459, 127, 46);
		frmCorreo.getContentPane().add(btnNewButton);
		JLabel lblMensaje = new JLabel(MessagesCorreo.getString("Correo.lblMensaje.text")); //$NON-NLS-1$
		lblMensaje.setBounds(40, 264, 94, 14);
		frmCorreo.getContentPane().add(lblMensaje);
		
		JLabel lblId = new JLabel(MessagesCorreo.getString("Correo.lblId.text")); //$NON-NLS-1$
		lblId.setBounds(657, 25, 46, 14);
		lblId.setVisible(false);
		frmCorreo.getContentPane().add(lblId);
		
		setLista();
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(40, 61, 522, 171);
		frmCorreo.getContentPane().add(scrollPane);
		table = new JTable(data,columnNames);
		scrollPane.setViewportView(table);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS
				);
		table.addKeyListener(new TableKeyListener());
		table.addMouseListener(new TableMouseListener());
		
	}
	
	public void setLista() {
		
		Agente b;
		String SQL_Consulta = "SELECT Correos.Id,Correos.Fecha,Correos.Hora,Correos.Asunto,Usuarios.Nombre FROM Usuarios INNER JOIN Correos ON Usuarios.DNI=Correos.Emisor AND Correos.Receptor='"+dni+"'";
		
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				id=lista.getString("Correos.Id");
				nombre=lista.getString("Usuarios.Nombre");
				data[c][0]=id+"-"+nombre;
				fecha=lista.getString("Correos.Fecha");
				hora=lista.getString("Correos.Hora");
				asunto=lista.getString("Correos.Asunto");
				data[c][1]=asunto;
				data[c][2]=fecha+" "+hora;
				c++;
				
			}
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public void setDni(String text) {
		dni=text;
		setLista();
	}
	public JFrame getFrame(){
		return frmCorreo;
	}	
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmCorreo.setVisible(false);
		}
	}
	
	private class BtnEliminarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Agente b;
			String cadena;
			int row=table.getSelectedRow();
			cadena=(String) table.getValueAt(row, 0);
			
			String SQL_Consulta = "DELETE * FROM Correos WHERE Id='"+obtenerDatos(cadena)+"'";
			
			try {
				b = Agente.getAgenteUsuario();
				b.delete(SQL_Consulta);
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	public String obtenerDatos(String texto) {
		String cadena = null;
		for(int c=0 ; c<texto.length() ; c++) {
			if(texto.charAt(c)=='-')
				cadena=texto.substring(0, c);
		}
		
		return cadena;
	}
	private class TableMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			String cadena;
			int row=table.getSelectedRow();
			cadena=(String) table.getValueAt(row, 0);
			
			Agente b;
			String SQL_Consulta = "SELECT Texto FROM Correos WHERE Id='"+obtenerDatos(cadena)+"'";
			String texto = null;
			try {
				b = Agente.getAgenteUsuario();
				ResultSet lista = b.select(SQL_Consulta);
				while(lista.next()){
					texto=lista.getString("Texto");
				}
				tPTexto.setText(texto);
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private class TableKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent arg0) {
			
		}
		@Override
		public void keyReleased(KeyEvent arg0) {
			String cadena;
			int row=table.getSelectedRow();
			cadena=(String) table.getValueAt(row, 0);
			
			Agente b;
			String SQL_Consulta = "SELECT Texto FROM Correos WHERE Id='"+obtenerDatos(cadena)+"'";
			String texto = null;
			try {
				b = Agente.getAgenteUsuario();
				ResultSet lista = b.select(SQL_Consulta);
				while(lista.next()){
					texto=lista.getString("Texto");
				}
				tPTexto.setText(texto);
				
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	private class BtnNuevoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmCorreo.dispose();
			NuevoMensaje ventana=new NuevoMensaje();
			ventana.getFrame().setVisible(true);
			ventana.setDNI(dni);
		}
	}
}
