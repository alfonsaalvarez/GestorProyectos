package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class VentanaIdioma {
	@SuppressWarnings("unused")
	private boolean es=true;
	private JFrame frmCambioDeIdioma;
	private JLabel lblidioma = new JLabel("");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIdioma window = new VentanaIdioma();
					window.frmCambioDeIdioma.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaIdioma() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCambioDeIdioma = new JFrame();
		frmCambioDeIdioma.setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaIdioma.class.getResource("/presentacion/IconoSoftProject.png")));
		frmCambioDeIdioma.setTitle("Cambio de idioma");
		frmCambioDeIdioma.setResizable(false);
		frmCambioDeIdioma.setBounds(100, 100, 370, 263);
		frmCambioDeIdioma.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmCambioDeIdioma.getContentPane().setLayout(null);
		
		
		lblidioma.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblidioma.setBounds(57, 11, 279, 141);
		frmCambioDeIdioma.getContentPane().add(lblidioma);
		
		JButton btnCerrar = new JButton("Cerrar");
		btnCerrar.addActionListener(new BtnCerrarActionListener());
		btnCerrar.setBounds(139, 184, 89, 23);
		frmCambioDeIdioma.getContentPane().add(btnCerrar);
		frmCambioDeIdioma.setLocationRelativeTo(null);
	}
	public void setIdiomaES(){
		es=true;
		lblidioma.setText("Idioma cambiado a Español");
	}
	public void setIdiomaEN(){
		es=false;
		lblidioma.setText("Idioma cambiado a Inglés");
	}
	public JFrame getFrame() {
		return frmCambioDeIdioma;
	}
	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			frmCambioDeIdioma.dispose();
		}
	}
}
