package presentacion;

import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import dominio.Usuario;
import persistencia.Agente;
import javax.swing.JButton;
import java.sql.ResultSet;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPasswordField;

public class Login {

	private JFrame frmIniciarSesin;
	private JTextField tfUsuario;
	private JLabel lblProblem = new JLabel(MessagesLogin.getString("Login.lblProblem.text")); //$NON-NLS-1$
	private JButton btnAceptar = new JButton(MessagesLogin.getString("Login.btnAceptar.text")); //$NON-NLS-1$
	private JPasswordField tfPass;
	Usuario usuario;
	private String dni;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmIniciarSesin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmIniciarSesin = new JFrame();
		frmIniciarSesin.setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/presentacion/IconoSoftProject.png")));
		frmIniciarSesin.setResizable(false);
		frmIniciarSesin.setTitle(MessagesLogin.getString("Login.frmIniciarSesin.title")); //$NON-NLS-1$
		frmIniciarSesin.setBounds(100, 100, 519, 303);
		frmIniciarSesin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmIniciarSesin.getContentPane().setLayout(null);
		frmIniciarSesin.setLocationRelativeTo(null);
		
		JLabel lblUsuario = new JLabel(MessagesLogin.getString("Login.lblUsuario.text")); //$NON-NLS-1$
		lblUsuario.setBounds(252, 69, 116, 28);
		frmIniciarSesin.getContentPane().add(lblUsuario);
		
		JLabel lblPass = new JLabel(MessagesLogin.getString("Login.lblPass.text")); //$NON-NLS-1$
		lblPass.setBounds(247, 118, 82, 22);
		frmIniciarSesin.getContentPane().add(lblPass);
		
		tfUsuario = new JTextField();
		tfUsuario.addKeyListener(new TfUsuarioKeyListener());
		tfUsuario.setBounds(329, 73, 167, 20);
		frmIniciarSesin.getContentPane().add(tfUsuario);
		tfUsuario.setColumns(10);
		tfUsuario.setEnabled(true);
		
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new BtnAceptarActionListener());
		btnAceptar.setBounds(279, 219, 89, 36);
		frmIniciarSesin.getContentPane().add(btnAceptar);
		
		JButton btnSalir = new JButton(MessagesLogin.getString("Login.btnSalir.text")); //$NON-NLS-1$
		btnSalir.addActionListener(new BtnSalirActionListener());
		btnSalir.setBounds(407, 219, 89, 36);
		frmIniciarSesin.getContentPane().add(btnSalir);
		
		JLabel lblTitulo = new JLabel(MessagesLogin.getString("Login.lblTitulo.text")); //$NON-NLS-1$
		lblTitulo.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblTitulo.setForeground(SystemColor.textHighlight);
		lblTitulo.setBounds(49, 11, 133, 45);
		frmIniciarSesin.getContentPane().add(lblTitulo);
		
		JLabel lblFoto = new JLabel(MessagesLogin.getString("Login.lblFoto.text")); //$NON-NLS-1$
		lblFoto.setIcon(new ImageIcon(Login.class.getResource("/presentacion/ImagenLogin.jpg")));
		lblFoto.setBounds(10, 62, 217, 193);
		frmIniciarSesin.getContentPane().add(lblFoto);
		lblProblem.setVisible(false);
		
		lblProblem.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		lblProblem.setBounds(266, 161, 230, 29);
		frmIniciarSesin.getContentPane().add(lblProblem);
		
		JButton btnEsp = new JButton(MessagesLogin.getString("Login.btnEsp.text")); //$NON-NLS-1$
		btnEsp.setForeground(Color.BLACK);
		btnEsp.addActionListener(new BtnEspActionListener());
		btnEsp.setIcon(new ImageIcon(Login.class.getResource("/presentacion/banderaEspana.gif")));
		btnEsp.setBounds(329, 25, 75, 25);
		frmIniciarSesin.getContentPane().add(btnEsp);
		
		JButton btnIng = new JButton(MessagesLogin.getString("Login.btnIng.text")); //$NON-NLS-1$
		btnIng.addActionListener(new BtnIngActionListener());
		btnIng.setIcon(new ImageIcon(Login.class.getResource("/presentacion/banderaGranBretana.png")));
		btnIng.setBounds(414, 25, 75, 25);
		frmIniciarSesin.getContentPane().add(btnIng);
		
		tfPass = new JPasswordField();
		tfPass.setBounds(329, 119, 167, 20);
		tfPass.setEnabled(false);
		frmIniciarSesin.getContentPane().add(tfPass);
		
	}
	
	
	private class BtnAceptarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			iniciarSesion();
		}
	}
	private class BtnSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class TfUsuarioKeyListener extends KeyAdapter {
		@Override
		public void keyTyped(KeyEvent arg0) {
			tfPass.setEnabled(true);
			btnAceptar.setEnabled(true);
		}
	}
	private class BtnIngActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaIdioma v=new VentanaIdioma();
			v.setIdiomaEN();
			//frmIniciarSesin.setVisible(false);
			MessagesLogin.setIdioma("ingles");
			MessagesAcercaDe.setIdioma("ingles"); //$NON-NLS-1$
			MessagesConfirmacion.setIdioma("ingles");
			MessagesCorreo.setIdioma("ingles");
			MessagesGestor_Usuarios.setIdioma("ingles");
			MessagesMi_perfil.setIdioma("ingles");
			MessagesSalir.setIdioma("ingles");
			MessagesNuevoMensaje.setIdioma("ingles");
			MessagesNuevaTarea.setIdioma("ingles");
			MessagesTareas.setIdioma("ingles");
			MessagesVentana_Principal.setIdioma("ingles");
			MessagesGestor_Proyectos.setIdioma("ingles");
			MessagesNuevoProyecto.setIdioma("ingles");
			Login nuevo = new Login();
			frmIniciarSesin.dispose();
			nuevo.getFrame().setVisible(true);
			v.getFrame().setVisible(true);
		}
	}
	private class BtnEspActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			VentanaIdioma v=new VentanaIdioma();
			v.setIdiomaES();
			//frmIniciarSesin.dispose();
			MessagesLogin.setIdioma("espaniol");
			MessagesAcercaDe.setIdioma("espaniol"); //$NON-NLS-1$
			MessagesConfirmacion.setIdioma("espaniol");
			MessagesCorreo.setIdioma("espaniol");
			MessagesGestor_Usuarios.setIdioma("espaniol");
			MessagesMi_perfil.setIdioma("espaniol");
			MessagesSalir.setIdioma("espaniol");
			MessagesNuevoMensaje.setIdioma("espaniol");
			MessagesNuevaTarea.setIdioma("espaniol");
			MessagesTareas.setIdioma("espaniol");
			MessagesVentana_Principal.setIdioma("espaniol");
			MessagesGestor_Proyectos.setIdioma("espaniol");
			MessagesNuevoProyecto.setIdioma("espaniol");
			//Login ventana=new Login();
			//ventana.getFrame().setVisible(true);
			Login nuevo = new Login();
			frmIniciarSesin.dispose();
			nuevo.getFrame().setVisible(true);
			v.getFrame().setVisible(true);
		}
	}
	
	@SuppressWarnings("deprecation")
	private void iniciarSesion()
	{
		frmIniciarSesin.getContentPane().add(lblProblem);
		String SQL_Consulta = "SELECT Usuario, Password, Nombre, Apellidos, DNI, Telefono, Sexo, Correo, Fecha_Nacimiento, Imagen FROM Usuarios;";
		Agente al;
		boolean comprobar = false;
		
		try {
			
			al = Agente.getAgenteUsuario();
			ResultSet lista = al.select(SQL_Consulta);
			
			while(lista.next() && comprobar == false){
				String id = lista.getString("Usuario");
				String password = lista.getString("Password");
				String nombre = lista.getString("Nombre");
				String apellidos = lista.getString("Apellidos");
				dni = lista.getString("DNI");
				String telefono = lista.getString("Telefono");
				String sexo = lista.getString("Sexo");
				String correo = lista.getString("Correo");
				String fechaNacimiento = lista.getString("Fecha_Nacimiento");
				String imagen = lista.getString("Imagen");
				usuario = new Usuario(id, password, nombre, apellidos, dni, telefono,
					 sexo, correo, fechaNacimiento, imagen);
				
				if(tfUsuario.getText().equalsIgnoreCase(id) && tfPass.getText().equalsIgnoreCase(password)){
					comprobar=true;
				}
			}
			

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		if(comprobar == true){
			Ventana_Principal ventana= new Ventana_Principal();
			
			if(usuario.getSexo().equalsIgnoreCase("Hombre")) {
				ventana.setImagenSexo("Hombre.PNG");
				ventana.setBienvenido(MessagesVentana_Principal.getString("Ventana_Principal.lblBienvenido.text")+" "+tfUsuario.getText());
			}
			else {
				ventana.setImagenSexo("Mujer.PNG");
				ventana.setBienvenido(MessagesVentana_Principal.getString("Ventana_Principal.lblBienvenido.text")+" "+tfUsuario.getText());
			}
			ventana.setUsuario(usuario);
			
			Agente b;
			String SQL_Consulta2 = "SELECT Acceso FROM Usuarios WHERE DNI='"+dni+"';";
			String fecha = null;
			try {
				b = Agente.getAgenteUsuario();
				ResultSet lista = b.select(SQL_Consulta2);
				while(lista.next()){
					fecha=lista.getString("Acceso");
				}
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			ventana.setAcceso(MessagesVentana_Principal.getString("Ventana_Principal.lblAcceso.text")+" "+fecha);
			frmIniciarSesin.dispose();
			ventana.getFrame().setVisible(true);
			
		}else{
			lblProblem.setText(MessagesLogin.getString("Login.lblProblema.text"));
			lblProblem.setForeground(Color.RED);
			lblProblem.setVisible(true);
		}
	}
	public JFrame getFrame(){
		return frmIniciarSesin;
	}
}
