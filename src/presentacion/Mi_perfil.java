package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import persistencia.Agente;
import javax.swing.JButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.ListSelectionModel;

public class Mi_perfil {

	private JFrame frmMiPerfil;
	private JTextField tfNombre;
	private JTextField tfApellidos;
	private JTextField tfFecha;
	private JButton btnImagen;
	private String dni;
	private String proyecto;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private JList<String> list=new JList<String>(modelo);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mi_perfil window = new Mi_perfil();
					window.frmMiPerfil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mi_perfil() {
		initialize();
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		
		frmMiPerfil = new JFrame();
		frmMiPerfil.setIconImage(Toolkit.getDefaultToolkit().getImage(Mi_perfil.class.getResource("/presentacion/IconoSoftProject.png")));
		frmMiPerfil.setTitle(MessagesMi_perfil.getString("Mi_perfil.frmMiPerfil.title")); //$NON-NLS-1$
		frmMiPerfil.setResizable(false);
		frmMiPerfil.setBounds(100, 100, 496, 527);
		frmMiPerfil.getContentPane().setLayout(null);
		frmMiPerfil.setLocationRelativeTo(null);
		btnImagen = new JButton();
		JLabel lblNombre = new JLabel(MessagesMi_perfil.getString("Mi_perfil.lblNombre.text")); //$NON-NLS-1$
		lblNombre.setBounds(226, 33, 72, 23);
		frmMiPerfil.getContentPane().add(lblNombre);
		list = new JList<String>();
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JLabel lblApellidos = new JLabel(MessagesMi_perfil.getString("Mi_perfil.lblApellidos.text")); //$NON-NLS-1$
		lblApellidos.setBounds(214, 73, 84, 23);
		frmMiPerfil.getContentPane().add(lblApellidos);
		
		JLabel lblFecha = new JLabel(MessagesMi_perfil.getString("Mi_perfil.lblFecha.text")); //$NON-NLS-1$
		lblFecha.setBounds(168, 120, 130, 23);
		frmMiPerfil.getContentPane().add(lblFecha);
		
		tfNombre = new JTextField();
		tfNombre.setEditable(false);
		tfNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfNombre.setBounds(311, 36, 137, 20);
		frmMiPerfil.getContentPane().add(tfNombre);
		tfNombre.setColumns(10);
		
		tfApellidos = new JTextField();
		tfApellidos.setEditable(false);
		tfApellidos.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfApellidos.setBounds(311, 76, 137, 20);
		frmMiPerfil.getContentPane().add(tfApellidos);
		tfApellidos.setColumns(10);
		
		tfFecha = new JTextField();
		tfFecha.setEditable(false);
		tfFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		tfFecha.setBounds(311, 121, 137, 20);
		frmMiPerfil.getContentPane().add(tfFecha);
		tfFecha.setColumns(10);
		
		list.setBorder(new TitledBorder(null, MessagesMi_perfil.getString("Mi_perfil.list.borderTitle"), TitledBorder.LEADING, TitledBorder.TOP, null, null)); //$NON-NLS-1$
		setLista();
		list.setBounds(37, 212, 400, 174);
		frmMiPerfil.getContentPane().add(list);
		
		JButton btnCerrar = new JButton(MessagesMi_perfil.getString("Mi_perfil.btnCerrar.text")); //$NON-NLS-1$
		btnCerrar.addActionListener(new BtnCerrarActionListener());
		btnCerrar.setBounds(199, 425, 98, 31);
		frmMiPerfil.getContentPane().add(btnCerrar);
		btnImagen.setBounds(21, 23, 137, 137);
		frmMiPerfil.getContentPane().add(btnImagen);
		setLista();
	}
	
	public void setLista() {
		Agente b;
		String SQL_Consulta = "SELECT Nombre FROM Proyectos WHERE DNI_Miembro='"+dni+"'";
		
		try {
			b = Agente.getAgenteUsuario();
			ResultSet lista = b.select(SQL_Consulta);
			while(lista.next()){
				proyecto=lista.getString("Nombre");
				modelo.addElement(proyecto);
				list.setModel(modelo);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			
		}	
		
	}
	public JFrame getFrame(){
		return frmMiPerfil;
	}
	public void setDNI(String texto) {
		dni=texto;
		setLista();
	}
	public void setNombre(String n) {
		tfNombre.setText(n);
	}
	public void setFecha(String n) {
		tfFecha.setText(n);
	}
	public void setApellidos(String n) {
		tfApellidos.setText(n);
	}
	public void setImagen(ImageIcon i) {
		btnImagen.setIcon(i);
	}
	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmMiPerfil.setVisible(false);
		}
	}
}
