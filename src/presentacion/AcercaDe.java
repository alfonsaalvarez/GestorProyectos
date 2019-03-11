package presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AcercaDe {

	private JFrame frmAcercaDe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AcercaDe window = new AcercaDe();
					window.frmAcercaDe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AcercaDe() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcercaDe = new JFrame();
		frmAcercaDe.setTitle(MessagesAcercaDe.getString("AcercaDe.frmAcercaDe.title")); //$NON-NLS-1$
		frmAcercaDe.setResizable(false);
		frmAcercaDe.setIconImage(Toolkit.getDefaultToolkit().getImage(AcercaDe.class.getResource("IconoSoftProject.png")));
		frmAcercaDe.setBounds(100, 100, 441, 300);
		frmAcercaDe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAcercaDe.getContentPane().setLayout(null);
		frmAcercaDe.setLocationRelativeTo(null);
		
		JLabel lblAcerca = new JLabel(MessagesAcercaDe.getString("AcercaDe.lblAcerca.text")); //$NON-NLS-1$
		lblAcerca.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblAcerca.setBounds(130, 26, 162, 44);
		frmAcercaDe.getContentPane().add(lblAcerca);
		
		JLabel lblAlbertoLpezHurtado = new JLabel(MessagesAcercaDe.getString("AcercaDe.lblAlbertoLpezHurtado.text")); //$NON-NLS-1$
		lblAlbertoLpezHurtado.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblAlbertoLpezHurtado.setBounds(112, 81, 232, 44);
		frmAcercaDe.getContentPane().add(lblAlbertoLpezHurtado);
		
		JLabel lblAlfonsaAlvarezBelln = new JLabel(MessagesAcercaDe.getString("AcercaDe.lblAlfonsaAlvarezBelln.text")); //$NON-NLS-1$
		lblAlfonsaAlvarezBelln.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblAlfonsaAlvarezBelln.setBounds(112, 136, 232, 44);
		frmAcercaDe.getContentPane().add(lblAlfonsaAlvarezBelln);
		
		JButton btnCerrar = new JButton(MessagesAcercaDe.getString("AcercaDe.btnCerrar.text")); //$NON-NLS-1$
		btnCerrar.addActionListener(new BtnCerrarActionListener());
		btnCerrar.setBounds(168, 203, 100, 36);
		frmAcercaDe.getContentPane().add(btnCerrar);
		
	}
	public JFrame getFrame() {
		return frmAcercaDe;
	}
	private class BtnCerrarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			frmAcercaDe.dispose();
		}
	}
}
