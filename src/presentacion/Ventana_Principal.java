package presentacion;
import persistencia.Agente;

import java.awt.EventQueue;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Toolkit;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import java.awt.SystemColor;
import com.toedter.calendar.JCalendar;
import dominio.Usuario;
import java.awt.Frame;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Ventana_Principal extends javax.swing.JFrame implements Runnable
{

	private JFrame frmPrincipal;
	private JLabel lblBienvenido;
	private JLabel lblAcceso;
	private JLabel lblHora;
	private JButton btnProyectos;
	private JButton btnUsuarios;
	private JButton btnCorreo;
	private JButton btnPerfil;
	private String hora,minutos,ampm,dni,dia,mes,anio; 
	private Thread h1;
	private Usuario usuario ;
	private JPanel panel;
	private String nombre,apellidos,telefono,correo,fecha,sexo;
	Gestor_Usuarios ventana=new Gestor_Usuarios();
	private JMenuItem mntmGestorDeProyectos;
	private JMenuItem mntmGestorDeUsuarios;
	private JMenuItem mntmCorreo;
	private JMenuItem mntmMiPerfil;
	private JMenuItem mntmCerrarSesion;
	private JMenuItem mntmSalir;
	private JMenu mTamanio;
	private JRadioButtonMenuItem miGrande;
	private JRadioButtonMenuItem miNormal;
	private JRadioButtonMenuItem miPequeña;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	/**
	 * Launch the application.
	 */
	public void calcula() {
        Calendar calendario = new GregorianCalendar();
        Date fechaHoraActual = new Date();

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
	
	public void run() {
        Thread ct = Thread.currentThread();
        
        while (ct == h1) {
            calcula();
            
            lblHora.setText(hora + ":" + minutos);
     
            try {
            	
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana_Principal window = new Ventana_Principal();
					window.frmPrincipal.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Ventana_Principal() {
		initialize();
		frmPrincipal.setExtendedState(Frame.MAXIMIZED_VERT);
		h1 = new Thread(this);
        h1.start();
        
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	@SuppressWarnings("unused")
	private void initialize() {
		
		frmPrincipal = new JFrame();
		frmPrincipal.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frmPrincipal.setIconImage(Toolkit.getDefaultToolkit().getImage(Ventana_Principal.class.getResource("IconoSoftProject.png")));
		frmPrincipal.setTitle(MessagesVentana_Principal.getString("Ventana_Principal.frmPrincipal.title")); //$NON-NLS-1$
		frmPrincipal.setBounds(100, 100, 988, 844);
		frmPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPrincipal.getContentPane().setLayout(null);
		Calendar fecha = new GregorianCalendar();
		int anio = fecha.get(Calendar.YEAR);
        int mes = fecha.get(Calendar.MONTH)+1;
        int dia = fecha.get(Calendar.DAY_OF_MONTH);
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frmPrincipal.setSize(new Dimension(1366, 805));
        frmPrincipal.setLocationRelativeTo(null);
		JPanel panel1 = new JPanel();
		panel1.setBounds(0, 26, 1360, 725);
		frmPrincipal.getContentPane().add(panel1);
		GridBagLayout gbl_panel1 = new GridBagLayout();
		gbl_panel1.columnWidths = new int[]{20, 220, 93, 400, 400, 20, 0};
		gbl_panel1.rowHeights = new int[]{15, 49, 54, 67, 67, 33, 261, 100, 0, 0};
		gbl_panel1.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panel1.setLayout(gbl_panel1);
		
		lblHora = new JLabel(); //$NON-NLS-1$
		lblHora.setBackground(SystemColor.inactiveCaption);
		lblHora.setForeground(SystemColor.textHighlight);
		lblHora.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		GridBagConstraints gbc_lblHora = new GridBagConstraints();
		gbc_lblHora.gridheight = 2;
		gbc_lblHora.insets = new Insets(0, 0, 5, 5);
		gbc_lblHora.gridx = 1;
		gbc_lblHora.gridy = 1;
		panel1.add(lblHora, gbc_lblHora);
		
		btnPerfil = new JButton(); //$NON-NLS-1$
		GridBagConstraints gbc_btnPerfil = new GridBagConstraints();
		gbc_btnPerfil.gridheight = 2;
		gbc_btnPerfil.anchor = GridBagConstraints.WEST;
		gbc_btnPerfil.fill = GridBagConstraints.VERTICAL;
		gbc_btnPerfil.insets = new Insets(0, 0, 5, 5);
		gbc_btnPerfil.gridx = 2;
		gbc_btnPerfil.gridy = 1;
		panel1.add(btnPerfil, gbc_btnPerfil);
		btnPerfil.addActionListener(new BtnPerfilActionListener());
		lblBienvenido = new JLabel(MessagesVentana_Principal.getString("Ventana_Principal.lblBienvenido.text"));
		lblBienvenido.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		GridBagConstraints gbc_lblBienvenido = new GridBagConstraints();
		gbc_lblBienvenido.fill = GridBagConstraints.BOTH;
		gbc_lblBienvenido.insets = new Insets(0, 0, 5, 5);
		gbc_lblBienvenido.gridx = 3;
		gbc_lblBienvenido.gridy = 1;
		panel1.add(lblBienvenido, gbc_lblBienvenido);
		
		lblBienvenido.setVisible(true);
		
		JButton btnCerrar = new JButton(MessagesVentana_Principal.getString("Ventana_Principal.btnCerrar.text")); //$NON-NLS-1$
		btnCerrar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnCerrar = new GridBagConstraints();
		gbc_btnCerrar.anchor = GridBagConstraints.EAST;
		gbc_btnCerrar.fill = GridBagConstraints.VERTICAL;
		gbc_btnCerrar.insets = new Insets(0, 0, 5, 5);
		gbc_btnCerrar.gridx = 4;
		gbc_btnCerrar.gridy = 1;
		panel1.add(btnCerrar, gbc_btnCerrar);
		btnCerrar.addActionListener(new BtnNewButtonActionListener());
		btnCerrar.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/presentacion/CerrarSesion.png")));
		
		lblAcceso = new JLabel(); //$NON-NLS-1$
		lblAcceso.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		GridBagConstraints gbc_lblAcceso = new GridBagConstraints();
		gbc_lblAcceso.fill = GridBagConstraints.BOTH;
		gbc_lblAcceso.insets = new Insets(0, 0, 5, 5);
		gbc_lblAcceso.gridx = 3;
		gbc_lblAcceso.gridy = 2;
		panel1.add(lblAcceso, gbc_lblAcceso);
		
		
		btnCorreo = new JButton(MessagesVentana_Principal.getString("Ventana_Principal.btnCorreo.text")); //$NON-NLS-1$
		btnCorreo.addActionListener(new BtnCorreoActionListener());
		btnCorreo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		GridBagConstraints gbc_btnCorreo = new GridBagConstraints();
		gbc_btnCorreo.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnCorreo.anchor = GridBagConstraints.NORTH;
		gbc_btnCorreo.insets = new Insets(0, 0, 5, 5);
		gbc_btnCorreo.gridx = 1;
		gbc_btnCorreo.gridy = 4;
		panel1.add(btnCorreo, gbc_btnCorreo);
		btnCorreo.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/presentacion/Correo.png")));
		
		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.gridheight = 4;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 3;
		gbc_panel.gridy = 4;
		panel1.add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{479, 517, 0};
		gbl_panel.rowHeights = new int[]{293, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnProyectos = new JButton(); //$NON-NLS-1$
		btnProyectos.addMouseListener(new BtnProyectosMouseListener());
		btnProyectos.addActionListener(new BtnProyectosActionListener());
		GridBagConstraints gbc_btnProyectos = new GridBagConstraints();
		gbc_btnProyectos.fill = GridBagConstraints.BOTH;
		gbc_btnProyectos.insets = new Insets(0, 0, 0, 5);
		gbc_btnProyectos.gridx = 0;
		gbc_btnProyectos.gridy = 0;
		panel.add(btnProyectos, gbc_btnProyectos);
		btnProyectos.setSelectedIcon(new ImageIcon(Ventana_Principal.class.getResource("IconoSoftProject.png")));
		btnProyectos.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/presentacion/GestorProyectos1.png")));
		
		btnUsuarios = new JButton(); //$NON-NLS-1$
		btnUsuarios.addActionListener(new BtnUsuariosActionListener());
		GridBagConstraints gbc_btnUsuarios = new GridBagConstraints();
		gbc_btnUsuarios.fill = GridBagConstraints.BOTH;
		gbc_btnUsuarios.gridx = 1;
		gbc_btnUsuarios.gridy = 0;
		panel.add(btnUsuarios, gbc_btnUsuarios);
		btnUsuarios.setIcon(new ImageIcon(Ventana_Principal.class.getResource("/presentacion/GestorUsuarios1.png")));
		
		JCalendar calendar = new JCalendar();
		GridBagConstraints gbc_calendar = new GridBagConstraints();
		gbc_calendar.fill = GridBagConstraints.BOTH;
		gbc_calendar.insets = new Insets(0, 0, 5, 5);
		gbc_calendar.gridx = 1;
		gbc_calendar.gridy = 6;
		panel1.add(calendar, gbc_calendar);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1360, 28);
		frmPrincipal.getContentPane().add(menuBar);
		
		JMenu mnArchivo = new JMenu(MessagesVentana_Principal.getString("Ventana_Principal.mnArchivo.text")); //$NON-NLS-1$
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		mntmGestorDeProyectos = new JMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.mntmGestorDeProyectos.text")); //$NON-NLS-1$
		mntmGestorDeProyectos.addActionListener(new MntmGestorDeProyectosActionListener());
		mnArchivo.add(mntmGestorDeProyectos);
		
		mntmGestorDeUsuarios = new JMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.mntmGestorDeUsuarios.text")); //$NON-NLS-1$
		mntmGestorDeUsuarios.addActionListener(new MntmGestorDeUsuariosActionListener());
		mnArchivo.add(mntmGestorDeUsuarios);
		
		mntmCorreo = new JMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.mntmCorreo.text")); //$NON-NLS-1$
		mntmCorreo.addActionListener(new MntmCorreoActionListener());
		mnArchivo.add(mntmCorreo);
		
		mntmMiPerfil = new JMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.mntmMiPerfil.text")); //$NON-NLS-1$
		mntmMiPerfil.addActionListener(new MntmMiPerfilActionListener());
		mnArchivo.add(mntmMiPerfil);
		
		mntmCerrarSesion = new JMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.mntmCerrarSesion.text")); //$NON-NLS-1$
		mntmCerrarSesion.addActionListener(new MntmCerrarSesionActionListener());
		mnArchivo.add(mntmCerrarSesion);
		
		mntmSalir = new JMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.mntmSalir.text")); //$NON-NLS-1$
		mntmSalir.addActionListener(new MntmSalirActionListener());
		mnArchivo.add(mntmSalir);
		
		JMenu mnEdicion = new JMenu(MessagesVentana_Principal.getString("Ventana_Principal.mnEdicion.text")); //$NON-NLS-1$
		mnEdicion.setMnemonic('E');
		menuBar.add(mnEdicion);
		
		mTamanio = new JMenu(MessagesVentana_Principal.getString("Ventana_Principal.mTamanio.text")); //$NON-NLS-1$
		mnEdicion.add(mTamanio);
		
		miGrande = new JRadioButtonMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.miGrande.text")); //$NON-NLS-1$
		miGrande.addActionListener(new MiGrandeActionListener());
		buttonGroup.add(miGrande);
		mTamanio.add(miGrande);
		
		miNormal = new JRadioButtonMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.miNormal.text")); //$NON-NLS-1$
		miNormal.addActionListener(new MiNormalActionListener());
		miNormal.setSelected(true);
		buttonGroup.add(miNormal);
		mTamanio.add(miNormal);
		
		miPequeña = new JRadioButtonMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.miPequeña.text")); //$NON-NLS-1$
		miPequeña.addActionListener(new MiPequeñaActionListener());
		buttonGroup.add(miPequeña);
		mTamanio.add(miPequeña);
		
		JMenu mnAyuda = new JMenu(MessagesVentana_Principal.getString("Ventana_Principal.mnAyuda.text")); //$NON-NLS-1$
		mnAyuda.setMnemonic('Y');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmAcerca = new JMenuItem(MessagesVentana_Principal.getString("Ventana_Principal.mntmAcerca.text")); //$NON-NLS-1$
		mntmAcerca.addActionListener(new MntmAcercaActionListener());
		mnAyuda.add(mntmAcerca);
		
	}
	public JFrame getFrame(){
		return frmPrincipal;
	}
	public void setBienvenido(String texto) {
		lblBienvenido.setText(texto);
	}
	public void setImagenSexo(String texto) {
		btnPerfil.setIcon(new ImageIcon(Ventana_Principal.class.getResource(texto)));
	}
	
	public void setUsuario(Usuario id) {
		usuario = id;
	}
	private class BtnNewButtonActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			Calendar fecha = new GregorianCalendar();
			int anio = fecha.get(Calendar.YEAR);
	        int mes = fecha.get(Calendar.MONTH)+1;
	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
			Agente b;
			
			String SQL_Consulta = "UPDATE Usuarios SET Acceso='"+dia+"/"+mes+"/"+anio+"' WHERE DNI='"+usuario.getDni()+"';";
			
			try {
				b = Agente.getAgenteUsuario();
				b.update(SQL_Consulta);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			frmPrincipal.dispose();
			Login.main(null);
		}
	}
	
	private class BtnPerfilActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mi_perfil v = new Mi_perfil();
			v.setImagen(new ImageIcon(Ventana_Principal.class.getResource(usuario.getImagen())));
			v.setNombre(usuario.getNombre());
			v.setApellidos(usuario.getApellidos());
			v.setFecha(usuario.getFechaNacimiento());
			v.setDNI(usuario.getDni());
			v.getFrame().setVisible(true);	
		}
	}
	private class MntmAcercaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			AcercaDe ventana=new AcercaDe();
			ventana.getFrame().setVisible(true);
		}
	}
	private class BtnCorreoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Correo ventana=new Correo();
			ventana.setDni(usuario.getDni());
			ventana.getFrame().setVisible(true);
		}
	}
	private class BtnUsuariosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Gestor_Usuarios ventana=new Gestor_Usuarios();
			ventana.getFrame().setVisible(true);
			Agente b;
			dni=usuario.getDni();
			String SQL_Consulta = "SELECT Nombre, Apellidos, Telefono, Sexo, Correo, Fecha_Nacimiento, Imagen FROM Usuarios where DNI='"+dni+"'";
			
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
			
			ventana.setNombre(nombre);
			ventana.setApellidos(apellidos);
			ventana.setDNI(dni);
			ventana.setTelefono(telefono);
			ventana.setCorreo(correo);
			if(sexo.equals("Hombre")) {
				ventana.setSexo(0);
				ventana.setImagen("Hombre.PNG");
			}
			if(sexo.equals("Mujer")) {
				ventana.setSexo(1);
				ventana.setImagen("Mujer.PNG");
			}
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
			ventana.setAnio(anio);
			ventana.setMes(mes);
			ventana.setDia(dia);
		}
	}
	public void setAcceso(String texto) {
		lblAcceso.setText(texto);
	}
	private class BtnProyectosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			//Gestor_Proyectos gestor=new Gestor_Proyectos();
			//gestor.getFrame().setVisible(true);
			GestorProy gestor=new GestorProy();
			gestor.getFrame().setVisible(true);
			
		}
	}
	private class MntmSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	private class MntmCorreoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Correo ventana=new Correo();
			ventana.setDni(usuario.getDni());
			ventana.getFrame().setVisible(true);
		}
	}
	private class MntmGestorDeUsuariosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Gestor_Usuarios ventana=new Gestor_Usuarios();
			ventana.getFrame().setVisible(true);
			Agente b;
			dni=usuario.getDni();
			String SQL_Consulta = "SELECT Nombre, Apellidos, Telefono, Sexo, Correo, Fecha_Nacimiento, Imagen FROM Usuarios where DNI='"+dni+"'";
			
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
			
			ventana.setNombre(nombre);
			ventana.setApellidos(apellidos);
			ventana.setDNI(dni);
			ventana.setTelefono(telefono);
			ventana.setCorreo(correo);
			if(sexo.equals("Hombre")) {
				ventana.setSexo(0);
			}
			if(sexo.equals("Mujer")) {
				ventana.setSexo(1);
			}
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
			ventana.setAnio(anio);
			ventana.setMes(mes);
			ventana.setDia(dia);
		}
	}
	private class MntmCerrarSesionActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Calendar fecha = new GregorianCalendar();
			int anio = fecha.get(Calendar.YEAR);
	        int mes = fecha.get(Calendar.MONTH)+1;
	        int dia = fecha.get(Calendar.DAY_OF_MONTH);
			Agente b;
			
			String SQL_Consulta = "UPDATE Usuarios SET Acceso='"+dia+"/"+mes+"/"+anio+"' WHERE DNI='"+usuario.getDni()+"';";
			
			try {
				b = Agente.getAgenteUsuario();
				b.update(SQL_Consulta);
				
			}catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
			frmPrincipal.dispose();
			Login.main(null);
		}
	}
	private class MntmGestorDeProyectosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GestorProy ventana=new GestorProy();
			ventana.getFrame().setVisible(true);
		}
	}
	private class MntmMiPerfilActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Mi_perfil v = new Mi_perfil();
			v.setImagen(new ImageIcon(Ventana_Principal.class.getResource(usuario.getImagen())));
			v.setNombre(usuario.getNombre());
			v.setApellidos(usuario.getApellidos());
			v.setFecha(usuario.getFechaNacimiento());
			v.setDNI(usuario.getDni());
			v.getFrame().setVisible(true);	
		}
	}
	private class MiPequeñaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblHora.setFont(new Font(lblHora.getFont().getFontName(),
					lblHora.getFont().getStyle(), 20));
		}
	}
	private class MiNormalActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblHora.setFont(new Font(lblHora.getFont().getFontName(),
					lblHora.getFont().getStyle(), 40));
		}
	}
	private class MiGrandeActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			lblHora.setFont(new Font(lblHora.getFont().getFontName(),
					lblHora.getFont().getStyle(), 60));
		}
	}
	private class BtnProyectosMouseListener extends MouseAdapter {
		@Override
		public void mouseClicked(MouseEvent arg0) {

		}
	}
}
