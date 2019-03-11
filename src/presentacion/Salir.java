package presentacion;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

@SuppressWarnings("serial")
public class Salir extends JDialog {

	private final JPanel contentPanel = new JPanel();
	@SuppressWarnings("unused")
	private String dni;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Salir dialog = new Salir();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public void setDNI(String dni) {
		this.dni=dni;
	}
	public Salir() {
		setTitle(MessagesSalir.getString("Salir.this.title")); //$NON-NLS-1$
		setIconImage(Toolkit.getDefaultToolkit().getImage(Salir.class.getResource("/presentacion/IconoSoftProject.png")));
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 381, 248);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		setLocationRelativeTo(null);
		JButton btnNewButton = new JButton(/*MessagesSalir.getString("Salir.btnNewButton.text")*/);
		btnNewButton.setIcon(new ImageIcon(Salir.class.getResource("/presentacion/pregunta.png")));
		contentPanel.add(btnNewButton);
		{
			JLabel label = new JLabel(MessagesSalir.getString("Salir.label.text")); //$NON-NLS-1$
			contentPanel.add(label);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSi = new JButton(MessagesSalir.getString("Salir.btnSi.text")); //$NON-NLS-1$
				btnSi.addActionListener(new BtnSiActionListener());
				btnSi.setActionCommand(MessagesSalir.getString("Salir.btnSi.actionCommand")); //$NON-NLS-1$
				buttonPane.add(btnSi);
				getRootPane().setDefaultButton(btnSi);
			}
			{
				JButton btnNo = new JButton(MessagesSalir.getString("Salir.btnNo.text")); //$NON-NLS-1$
				btnNo.addActionListener(new BtnNoActionListener());
				btnNo.setActionCommand(MessagesSalir.getString("Salir.btnNo.actionCommand")); //$NON-NLS-1$
				buttonPane.add(btnNo);
			}
		}
	}
	
	private class BtnSiActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			
		}
	}
	private class BtnNoActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			dispose();
			GestorProy ventana=new GestorProy();
			ventana.getFrame().setVisible(true);
		}
	}
}
