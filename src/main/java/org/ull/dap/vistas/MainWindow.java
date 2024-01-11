package org.ull.dap.vistas;

import org.ull.dap.controladores.InicioController;
import org.ull.dap.modelo.apicrypto.notifier.CryptocurrencyNotifier;
import org.ull.dap.modelo.apicrypto.user.User;
import org.ull.dap.modelo.buisness.user.UsersService.UserBLDto;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainWindow extends JFrame {

	public String cryptoSelected = "bitcoin";

	public CryptocurrencyNotifier cc = new CryptocurrencyNotifier();
	public Map<String, List<Double>> precios = new HashMap<>();
	private UserBLDto userlog;
	public User usersuscribe;
	private JPanel panelPrincipal;
	private JPanel pnLogin;

	private JPanel pnRegister;
	public PanelControl pnControl;
	private JPanel pnInicio;
	private JLabel lblTituloAplicacion;
	private JPanel pnInicioInferior;
	private JButton btnInicioEmpezar;
	/**
	 * Create the frame.
	 */
	public MainWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("CryptoAnalyzer");
		setSize(543, 491);
		setLocationRelativeTo(null);
		panelPrincipal = new JPanel();
		panelPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));
		Image icono = Toolkit.getDefaultToolkit().getImage("src/main/java/org/ull/dap/img/icono.png");
		setIconImage(icono);

		setContentPane(panelPrincipal);
		panelPrincipal.setLayout(new CardLayout(0, 0));
		panelPrincipal.add(getPnInicio(), "INICIO");
		panelPrincipal.add(getPnLogin(), "LOGIN");
		panelPrincipal.add(getPnRegister(), "REGISTER");
		panelPrincipal.add(getPnControl(), "CONTROL");
	}

	public JPanel getPnLogin() {
		if (pnLogin == null) {
			pnLogin = new PanelLogin(this);
		}
		return pnLogin;
	}

	private JPanel getPnRegister() {
		if (pnRegister == null) {
			pnRegister = new PanelRegistro(this);
		}
		return pnRegister;
	}

	private JPanel getPnControl() {
		if (pnControl == null) {
			pnControl = new PanelControl(this);

		}
		return pnControl;
	}
	private JPanel getPnInicio() {
		if (pnInicio == null) {
			pnInicio = new JPanel();
			pnInicio.setLayout(new GridLayout(2, 1, 0, 0));
			pnInicio.setBackground(new Color(243, 238, 234));
			pnInicio.add(getLblTituloAplicacion());
			pnInicio.add(getPnInicioInferior());
		}
		return pnInicio;
	}


	private JLabel getLblTituloAplicacion() {
		if (lblTituloAplicacion == null) {
			lblTituloAplicacion = new JLabel("CryptoScanner");
			lblTituloAplicacion.setIcon(resizeIcon(new ImageIcon("src/main/java/org/ull/dap/img/R.png"),150,100));

			lblTituloAplicacion.setHorizontalAlignment(SwingConstants.CENTER);
			lblTituloAplicacion.setFont(new Font("Tahoma", Font.BOLD, 40));
			lblTituloAplicacion.setForeground(Color.BLACK);
		}
		return lblTituloAplicacion;
	}

	public ImageIcon resizeIcon(ImageIcon icon, int width, int height) {
		Image image = icon.getImage(); // Obtiene la imagen del ImageIcon
		Image newImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH); // Redimensiona la imagen
		return new ImageIcon(newImage); // Crea un nuevo ImageIcon con la imagen redimensionada
	}

	private JPanel getPnInicioInferior() {
		if (pnInicioInferior == null) {
			pnInicioInferior = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnInicioInferior.getLayout();
			flowLayout.setVgap(100);
			pnInicioInferior.setBackground(new Color(243, 238, 234));
			pnInicioInferior.add(getBtnInicioEmpezar());
		}
		return pnInicioInferior;
	}
	private JButton getBtnInicioEmpezar() {
		if (btnInicioEmpezar == null) {
			btnInicioEmpezar = new JButton("EMPEZAR");
			btnInicioEmpezar.setBackground(new Color(178, 165, 155));
			btnInicioEmpezar.setBorder(BorderFactory.createEmptyBorder(5, 100, 5, 100));
			btnInicioEmpezar.setBorderPainted(false);

			// Agrega un manejador de eventos del ratón para cambiar la apariencia en hover
			btnInicioEmpezar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnInicioEmpezar.setBackground(new Color(142, 132, 125));


				}

				@Override
				public void mouseExited(MouseEvent e) {
					btnInicioEmpezar.setBackground(new Color(178, 165, 155));

				}
			});

			btnInicioEmpezar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new InicioController().pasarLogin(MainWindow.this);
				}
			});
			btnInicioEmpezar.setFont(new Font("Tahoma", Font.BOLD, 25));
		}
		return btnInicioEmpezar;
	}

	public void pasarPanel(String nombre){
		CardLayout cl = (CardLayout) (panelPrincipal.getLayout());
		cl.show(panelPrincipal, nombre);
	}

	public UserBLDto getUserlog(){
		return userlog;
	}

	public void setUserlog(UserBLDto userlog){
		this.userlog = userlog;
	}
}