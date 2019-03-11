package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Confirmacion {

	private JFrame frmEnvio;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Confirmacion window = new Confirmacion();
					window.frmEnvio.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Confirmacion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEnvio = new JFrame();
		frmEnvio.setIconImage(Toolkit.getDefaultToolkit().getImage(Confirmacion.class.getResource("IconoSoftProject.png")));
		frmEnvio.setResizable(false);
		frmEnvio.setTitle(MessagesConfirmacion.getString("Confirmacion.frmEnvio.title")); //$NON-NLS-1$
		frmEnvio.setBounds(100, 100, 450, 300);
		frmEnvio.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmEnvio.getContentPane().setLayout(null);
		frmEnvio.setLocationRelativeTo(null);
		
		JLabel lblEnviado = new JLabel(MessagesConfirmacion.getString("Confirmacion.lblEnviado.text")); //$NON-NLS-1$
		lblEnviado.setFont(new Font("Comic Sans MS", Font.BOLD, 22));
		lblEnviado.setBounds(87, 26, 332, 154);
		frmEnvio.getContentPane().add(lblEnviado);
		
		JButton btnCerrar = new JButton(MessagesConfirmacion.getString("Confirmacion.btnCerrar.text")); //$NON-NLS-1$
		btnCerrar.addActionListener(new BtnCerrarActionListener());
		btnCerrar.setBounds(166, 180, 122, 50);
		frmEnvio.getContentPane().add(btnCerrar);
	}
	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frmEnvio.dispose();
		}
	}
	public JFrame getFrame() {
		return frmEnvio;
	}
}
