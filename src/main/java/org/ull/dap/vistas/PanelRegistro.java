package org.ull.dap.vistas;

import org.ull.dap.controladores.SignController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelRegistro extends JPanel {
	private JTextField txNick;
	private JTextField txEmail;
	private JTextField txPassword;
	private JButton btnRegistrar;
	private JLabel lblTitulo;
	private JTextArea txaErroresNick;
	private JTextArea txaErroresEmail;
	private JTextArea txaErroresContraseña;
	private JLabel lblContraseña;
	private JLabel lblEmail;
	private JLabel lblNick;
	private MainWindow m;

	/**
	 * Create the panel.
	 */
	public PanelRegistro(MainWindow m) {
		this.m = m;
		setLayout(null);
		add(getTxNick());
		add(getTxEmail());
		add(getTxPassword());
		add(getBtnRegistrar());
		add(getLblTitulo());
		add(getTxaErroresNick());
		add(getTxaErroresEmail());
		add(getTxaErroresContraseña());
		add(getLblContraseña());
		add(getLblEmail());
		add(getLblNick());

	}

	public JTextField getTxNick() {
		if (txNick == null) {
			txNick = new JTextField();
			txNick.setBounds(40, 146, 369, 19);
			txNick.setColumns(10);
		}
		return txNick;
	}

	public JTextField getTxEmail() {
		if (txEmail == null) {
			txEmail = new JTextField();
			txEmail.setBounds(40, 255, 369, 19);
			txEmail.setColumns(10);
		}
		return txEmail;
	}

	public JTextField getTxPassword() {
		if (txPassword == null) {
			txPassword = new JTextField();
			txPassword.setBounds(40, 353, 369, 19);
			txPassword.setColumns(10);
		}
		return txPassword;
	}

	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Register");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SignController().register(PanelRegistro.this, m);
				}
			});
			btnRegistrar.setBounds(174, 421, 85, 21);
		}
		return btnRegistrar;
	}

	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("Register");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblTitulo.setBounds(40, 10, 249, 40);
		}
		return lblTitulo;
	}

	public JTextArea getTxaErroresNick() {
		if (txaErroresNick == null) {
			txaErroresNick = new JTextArea();
			txaErroresNick.setEditable(false);
			txaErroresNick.setForeground(Color.RED);
			txaErroresNick.setWrapStyleWord(true);
			txaErroresNick.setBackground(SystemColor.control);
			txaErroresNick.setBounds(40, 175, 369, 33);
		}
		return txaErroresNick;
	}

	public JTextArea getTxaErroresEmail() {
		if (txaErroresEmail == null) {
			txaErroresEmail = new JTextArea();
			txaErroresEmail.setWrapStyleWord(true);
			txaErroresEmail.setForeground(Color.RED);
			txaErroresEmail.setEditable(false);
			txaErroresEmail.setBackground(SystemColor.control);
			txaErroresEmail.setBounds(40, 279, 369, 33);
		}
		return txaErroresEmail;
	}

	public JTextArea getTxaErroresContraseña() {
		if (txaErroresContraseña == null) {
			txaErroresContraseña = new JTextArea();
			txaErroresContraseña.setEditable(false);
			txaErroresContraseña.setForeground(Color.RED);
			txaErroresContraseña.setWrapStyleWord(true);
			txaErroresContraseña.setBackground(SystemColor.control);
			txaErroresContraseña.setBounds(40, 378, 369, 33);
		}
		return txaErroresContraseña;
	}

	private JLabel getLblContraseña() {
		if (lblContraseña == null) {
			lblContraseña = new JLabel("Password");
			lblContraseña.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblContraseña.setBounds(40, 322, 192, 28);
		}
		return lblContraseña;
	}

	private JLabel getLblEmail() {
		if (lblEmail == null) {
			lblEmail = new JLabel("Email");
			lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblEmail.setBounds(40, 217, 192, 28);
		}
		return lblEmail;
	}

	private JLabel getLblNick() {
		if (lblNick == null) {
			lblNick = new JLabel("Username");
			lblNick.setFont(new Font("Tahoma", Font.PLAIN, 18));
			lblNick.setBounds(40, 107, 192, 28);
		}
		return lblNick;
	}
}