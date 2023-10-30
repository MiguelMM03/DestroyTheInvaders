package uo.cpm.destroyTheInvaders.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import uo.cpm.destroyTheInvaders.game.Juego;
import uo.cpm.destroyTheInvaders.model.CategoriasPremios;
import uo.cpm.destroyTheInvaders.model.Idioma;
import uo.cpm.destroyTheInvaders.model.Premio;
import uo.cpm.destroyTheInvaders.model.Tablero;
import uo.cpm.destroyTheInvaders.service.DestroyTheInvaders;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.TransferHandler;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.net.URL;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.event.ChangeEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import java.awt.Toolkit;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class VentanaPrincipal extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panelVentanas;
	private JPanel panelRegistro;
	private JLabel lbLogo;
	private JPanel panelCodigos;
	private JTextField tfCodigoTienda;
	private JLabel lbCodigoTienda;
	private JLabel lbNumeroTicket;
	private JTextField tfNumeroTicket;
	private ResourceBundle textos;
	private JPanel panelBotones1;
	private JComboBox<Idioma> cbIdioma;
	private JButton btReestablecer1;
	private JButton btContinuar1;
	private JPanel panelInicio;
	private DestroyTheInvaders juego;
	private JPanel panelTextoInicio;
	private JLabel lbEnhorabuenaInicio;
	private JLabel lbTextoInicio;
	private JPanel panelBotonesInicio;
	private JButton btComoJugarInicio;
	private JButton btIniciarPartidaInicio;
	private JCheckBox checkBoxDaltonico;
	private JPanel panelJuego;
	private JPanel panelNorteJuego;
	private JPanel panelCentralJuego;
	private JPanel panelOesteDelPanelNorteJuego;
	private JPanel panelCentralDelPanelNorteJuego;
	private JPanel panelEsteDelPanelNorteJuego;
	private JTextField tfPuntuacionJuego;
	private JButton btAyudaJuego;
	private JButton[] btInvasoresSiguienteRonda=new JButton[Juego.MAXIMO_DE_INVASORES_POR_RONDA+1];
	private JButton[][] tablero=new JButton[Tablero.ROWS][Tablero.COLUMNS];
	private JButton btInvasorSeleccionado;
	private SeleccionaInvasorAColocar seleccInv=new SeleccionaInvasorAColocar();
	private SeleccionaCasillaAColocarInvasor seleccCasilla=new SeleccionaCasillaAColocarInvasor();
	private JPanel panelPuntucionEIteracionJuego;
	private JTextField tfIteracionJuego;
	private JPanel panelResumen;
	private JButton btContinuarResumen;
	private JPanel panelContenidoResumen;
	private JPanel panelEstadisticas;
	private JLabel lbGameOver;
	private JLabel lbInvasoresEliminados;
	private JTextField tfPuntuacionResumen;
	private JLabel lbPuntuacionResumen;
	private JLabel lbCombinacionesDe6;
	private JLabel lbCombinacionesDe3;
	private JLabel lbCombinacionesDe4;
	private JLabel lbCombinacionesDe5;
	private JTextField tfInvasoresEliminados;
	private JTextField tfCombinaciones3;
	private JTextField tfCombinaciones4;
	private JTextField tfCombinaciones5;
	private JTextField tfCombinaciones6;
	private JTextField tfCombinaciones7;
	private JLabel lbCombinacionesDe7;
	private JPanel panelMensajeResultadoPartida;
	private JLabel lbResultadoPartida;
	private JLabel lbMensajeFinPartida;
	private JPanel panelPremios;
	private JPanel panelIzquierdoPremios;
	private JPanel panelCategoriasPremios;
	private JPanel panelFiltrosPremios;
	private JPanel panelNortePremios;
	private JLabel lbPremios;
	private JLabel lbMensajePremio;
	private JTextField tfPuntosRestantes;
	private JScrollPane scrollPanePremios;
	private JPanel panelPremiosCentral;
	private JButton btEscogerPremios;
	private JPanel panelFiltrosYCategoriasPremios;
	private JPanel panelCategorias;
	private JPanel panelFiltros;
	private ProcesaCategorias pc=new ProcesaCategorias();
	private JPanel panelPremiosEscogidos;
	private JLabel lbPremiosEscogidos;
	private JPanel panelSurPremiosEscogidos;
	private JPanel panelDNI;
	private JLabel lbDNI;
	private JTextField textFieldDNI;
	private JButton btValidarDni;
	private JScrollPane scrollpaneCentralPremiosEscogidos;
	private JPanel panelCentralPremiosEscogidos;
	private JLabel lbPuntosMaximos;
	private JSpinner spinnerPuntosMaximos;
	private JLabel lbPuntosMinimos;
	private JSpinner spinnerPuntosMinimos;
	private String categoriaSeleccionada=CategoriasPremios.Todas.getNombre();
	private JMenuBar menuBar;
	private JMenu mnJuego;
	private JMenu mnAyuda;
	private JMenuItem mntmComoJugar;
	private JMenuItem mntmAcercaDe;
	private JSeparator separator;
	private JMenuItem mntmNuevo;
	private JPanel panelBtsPremioEscogido;
	private JButton btAnteriorPremiosEscogidos;

	/**
	 * Create the frame.
	 */
	public VentanaPrincipal(DestroyTheInvaders juego) {
		
		setFont(new Font("Arial", Font.BOLD, 14));
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaPrincipal.class.getResource("/img/fantasma.png")));
		this.juego=juego;

		textos = ResourceBundle.getBundle("rcs/textos",Locale.getDefault(Locale.Category.FORMAT));
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 1200, 700);
		setMinimumSize(new Dimension(1110, 660));
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(textos.getString("titulo"));
		setJMenuBar(getMenuBar_1());
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelVentanas(), BorderLayout.CENTER);
		localizar(Locale.getDefault(Locale.Category.FORMAT));
		cargaAyuda();
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				int respuesta=mostrarMensajeAdvertenciaSalida();
				if(respuesta==JOptionPane.OK_OPTION) {
					System.exit(0);
				}
			}
		});
	}
	
	private int mostrarMensajeAdvertenciaSalida() {
		return JOptionPane.showOptionDialog(this, textos.getString("seguroQueQuieresAbandonar"), textos.getString("salir"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("si"),textos.getString("no")}, null);
		
	}
	private int mostrarAdvertenciaNuevoJuego() {
		return JOptionPane.showOptionDialog(this, textos.getString("seguroQueQuieresIniciarUnNuevoJuego"), textos.getString("iniciarNuevoJuego"), JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("si"),textos.getString("no")}, null);
		
	}

	public DestroyTheInvaders getJuego() {
		return juego;
	}
	private void localizar(Locale localizacion) {
		textos = ResourceBundle.getBundle("rcs/textos",localizacion);
		actualizarMenu();
		mostrarPanelRegistro();
		
	}
	
	private void actualizarMenu() {
		getMnJuego().setText(textos.getString("menu.juego"));
		getMnJuego().setMnemonic(textos.getString("menu.juego").charAt(0));
		getMnAyuda().setText(textos.getString("menu.ayuda"));
		getMnAyuda().setMnemonic(textos.getString("menu.ayuda").charAt(0));
		getMntmNuevo().setText(textos.getString("menu.nuevo"));
		getMntmNuevo().setMnemonic(textos.getString("menu.nuevo").charAt(0));
		getMntmComoJugar().setText(textos.getString("menu.comoJugar"));
		getMntmComoJugar().setMnemonic(textos.getString("menu.comoJugar").charAt(0));
		getMntmAcercaDe().setText(textos.getString("menu.acercaDe"));
		getMntmAcercaDe().setMnemonic(textos.getString("menu.acercaDe").charAt(0));
		
	}

	private JPanel getPanelVentanas() {
		if (panelVentanas == null) {
			panelVentanas = new JPanel();
			panelVentanas.setLayout(new CardLayout(0, 0));
			panelVentanas.add(getPanelRegistro(), "panelRegistro");
			panelVentanas.add(getPanelInicio(), "panelInicio");
			panelVentanas.add(getPanelJuego(), "panelJuego");
			panelVentanas.add(getPanelResumen(), "panelResumen");
			panelVentanas.add(getPanelPremios(), "panelPremios");
			panelVentanas.add(getPanelPremiosEscogidos(), "panelPremiosEscogidos");
		}
		return panelVentanas;
	}
	private JPanel getPanelRegistro() {
		if (panelRegistro == null) {
			panelRegistro = new JPanel();
			panelRegistro.setLayout(new BorderLayout(0, 40));
			panelRegistro.add(getLbLogo(), BorderLayout.NORTH);
			panelRegistro.add(getPanelCodigos(), BorderLayout.CENTER);
			panelRegistro.add(getPanelBotones1_1(), BorderLayout.SOUTH);
		}
		return panelRegistro;
	}
	private JLabel getLbLogo() {
		if (lbLogo == null) {
			lbLogo=new JLabel();
			lbLogo.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbLogo;
	}
	private JPanel getPanelCodigos() {
		if (panelCodigos == null) {
			panelCodigos = new JPanel();
			panelCodigos.setLayout(new GridLayout(2, 2, 0, 10));
			panelCodigos.add(getLbCodigoTienda());
			panelCodigos.add(getTfCodigoTienda());
			panelCodigos.add(getLbNumeroTicket());
			panelCodigos.add(getTfNumeroTicket());
		}
		return panelCodigos;
	}
	private JTextField getTfCodigoTienda() {
		if (tfCodigoTienda == null) {
			tfCodigoTienda = new JTextField();
			tfCodigoTienda.setBackground(new Color(240, 240, 240));
			tfCodigoTienda.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfCodigoTienda.setEditable(false);
			tfCodigoTienda.setFont(new Font("Arial", Font.BOLD, 14));
			tfCodigoTienda.setHorizontalAlignment(SwingConstants.CENTER);
			tfCodigoTienda.setColumns(10);
		}
		return tfCodigoTienda;
	}
	private JLabel getLbCodigoTienda() {
		if (lbCodigoTienda == null) {
			lbCodigoTienda = new JLabel();
			lbCodigoTienda.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbCodigoTienda.setLabelFor(getTfCodigoTienda());
			lbCodigoTienda.setHorizontalAlignment(SwingConstants.CENTER);
			lbCodigoTienda.setFont(new Font("Arial", Font.BOLD, 14));
		}
		return lbCodigoTienda;
	}
	private JLabel getLbNumeroTicket() {
		if (lbNumeroTicket == null) {
			lbNumeroTicket = new JLabel();
			lbNumeroTicket.setBorder(new LineBorder(new Color(0, 0, 0)));
			lbNumeroTicket.setDisplayedMnemonic('t');
			lbNumeroTicket.setLabelFor(getTfNumeroTicket());
			lbNumeroTicket.setHorizontalAlignment(SwingConstants.CENTER);
			lbNumeroTicket.setFont(new Font("Arial", Font.BOLD, 14));
		}
		return lbNumeroTicket;
	}
	private JTextField getTfNumeroTicket() {
		if (tfNumeroTicket == null) {
			tfNumeroTicket = new JTextField();
			tfNumeroTicket.setBackground(new Color(240, 240, 240));
			tfNumeroTicket.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfNumeroTicket.setHorizontalAlignment(SwingConstants.CENTER);
			tfNumeroTicket.setFont(new Font("Arial", Font.BOLD, 14));
			tfNumeroTicket.setColumns(10);
		}
		return tfNumeroTicket;
	}
	private JPanel getPanelBotones1_1() {
		if (panelBotones1 == null) {
			panelBotones1 = new JPanel();
			panelBotones1.setLayout(new GridLayout(1, 0, 0, 0));
			panelBotones1.add(getCbIdioma_1());
			panelBotones1.add(getBtReestablecer1());
			panelBotones1.add(getBtContinuar1());
		}
		return panelBotones1;
	}
	private JComboBox<Idioma> getCbIdioma_1() {
		if (cbIdioma == null) {
			cbIdioma = new JComboBox<Idioma>();
			cbIdioma.setBackground(Color.LIGHT_GRAY);
			cbIdioma.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cambiarIdioma((Idioma)cbIdioma.getSelectedItem());
				}
			});
			cbIdioma.setModel(new DefaultComboBoxModel<Idioma>(Idioma.values()));
		}
		return cbIdioma;
	}
	protected void cambiarIdioma(Idioma selectedItem) {
		localizar(new Locale(selectedItem.getCodigo()));
	}

	private JButton getBtReestablecer1() {
		if (btReestablecer1 == null) {
			btReestablecer1 = new JButton();
			btReestablecer1.setMnemonic('r');
			btReestablecer1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getTfNumeroTicket().setText("");
				}
			});
		}
		return btReestablecer1;
	}
	private JButton getBtContinuar1() {
		if (btContinuar1 == null) {
			btContinuar1 = new JButton();
			btContinuar1.setMnemonic('c');
			btContinuar1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkCodigos();
				}
			});
		}
		return btContinuar1;
	}
	protected void checkCodigos() {
		try {
			if(getTfNumeroTicket().getText().isBlank()) {
				JOptionPane.showOptionDialog(this, textos.getString("numeroTicketNoPuedeEstarVacio"), textos.getString("error"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
				
				return;
			}
			boolean b=juego.startGame(Integer.parseInt(getTfNumeroTicket().getText()));
			if(b==false) {
				int reason=juego.reasonTicketInvalid(Integer.parseInt(getTfNumeroTicket().getText()));
				switch (reason) {
				case DestroyTheInvaders.TICKET_DE_OTRA_TIENDA: 
					mostrarTicketDeOtraTienda();
					break;
				
				case DestroyTheInvaders.TICKET_INFERIOR_AL_PRECIO_MINIMO:
					mostrarTicketInferiorAlPrecioMinimo();
					break;
				
				default:
					mostrarTicketNoValido();
				}
			}else {
				mostrarPanelInicio();
			}
		}catch(NumberFormatException e) {
			mostrarMensajeErrorNumerico();
		}catch(Exception e) {
			mostrarMensajeError();
		}
	}

	private void mostrarMensajeErrorNumerico() {
		JOptionPane.showOptionDialog(this, textos.getString("seHaProducidoUnErrorNumerico"), textos.getString("error"), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
		
	}

	private void mostrarPanelInicio() {
		mostrarMensajesPanelInicio();
		getRootPane().setDefaultButton(null);
		getCheckBoxDaltonico().setSelected(false);
		((CardLayout)getPanelVentanas().getLayout()).show(panelVentanas,"panelInicio");
	}
	private void mostrarMensajesPanelInicio() {
		getLbEnhorabuenaInicio().setText(textos.getString("enhorabuena"));
		getLbTextoInicio().setText(textos.getString("puedesEcharPartida"));
		getBtComoJugarInicio().setText(textos.getString("comoJugar"));
		getBtComoJugarInicio().setMnemonic(textos.getString("comoJugar").charAt(0));
		getBtIniciarPartidaInicio().setText(textos.getString("iniciarPartida"));
		getBtIniciarPartidaInicio().setMnemonic(textos.getString("iniciarPartida").charAt(0));
		getCheckBoxDaltonico().setText(textos.getString("modoDaltonico"));
		getCheckBoxDaltonico().setMnemonic(textos.getString("modoDaltonico").charAt(0));
		
	}

	private void mostrarPanelRegistro() {
		mostrarMensajesPanelRegistro();
		getRootPane().setDefaultButton(getBtContinuar1());
		((CardLayout)getPanelVentanas().getLayout()).show(panelVentanas,"panelRegistro");
	}
	private void mostrarMensajesPanelRegistro() {
		getLbLogo().setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/"+textos.getString("imagen_logo"))));
		getLbCodigoTienda().setText(textos.getString("codigoTienda"));
		getLbNumeroTicket().setText(textos.getString("numeroTicket"));
		getLbNumeroTicket().setDisplayedMnemonic(textos.getString("numeroTicket").charAt(0));
		getBtReestablecer1().setText(textos.getString("reestablecer"));
		getBtReestablecer1().setMnemonic(textos.getString("reestablecer").charAt(0));
		getBtContinuar1().setText(textos.getString("continuar"));
		getBtContinuar1().setMnemonic(textos.getString("continuar").charAt(0));
		getTfCodigoTienda().setText(juego.getTienda().getCodigo());
		getTfNumeroTicket().setText("");
		
	}

	private void mostrarPanelJuego() {
		mostrarMensajesPanelJuego();
		mostrarTooltipsPanelJuego();
		((CardLayout)getPanelVentanas().getLayout()).show(panelVentanas,"panelJuego");
	}
	private void mostrarTooltipsPanelJuego() {
		getPanelCentralDelPanelNorteJuego().setToolTipText(textos.getString("tooltip.panelCentralDelPanelNorteJuego"));
		btInvasoresSiguienteRonda[0].setToolTipText(textos.getString("tooltip.cabecilla"));
		for(int i=1;i<btInvasoresSiguienteRonda.length;i++) {
			btInvasoresSiguienteRonda[i].setToolTipText(textos.getString("tooltip.panelCentralDelPanelNorteJuego"));
		}
		for(JButton[] a:tablero) {
			for(JButton b:a) {
				b.setToolTipText(textos.getString("tooltip.panelCentralJuego"));
			}
		}
		getPanelCentralJuego().setToolTipText(textos.getString("tooltip.panelCentralJuego"));
		
	}

	private void mostrarMensajesPanelJuego() {
		getBtAyudaJuego().setText(textos.getString("ayuda"));
		getBtAyudaJuego().setMnemonic(textos.getString("ayuda").charAt(0));
		
	}

	private void mostrarPanelResumen() {
		mostrarEstadisticas();
		mostrarMensajesPanelResumen();
		((CardLayout)getPanelVentanas().getLayout()).show(panelVentanas,"panelResumen");
	}
	private void mostrarPanelPremios() {
		getRootPane().setDefaultButton(getBtEscogerPremios());
		((CardLayout)getPanelVentanas().getLayout()).show(panelVentanas,"panelPremios");
		mostrarMensajesPanelPremios();
		mostrarTooltipsPanelPremios();
		actualizarPuntosPanelPremios();
		getSpinnerPuntosMaximos().setModel(new SpinnerNumberModel(juego.getJuego().getJugador().getPuntos(),0.0,null,1));
		crearPanelesPremios();
		crearBotonesCategorias();
		filtrarPremios();
	}
	
	private void mostrarTooltipsPanelPremios() {
		getPanelIzquierdoPremios().setToolTipText(textos.getString("tooltip.panelIzquierdoPremios"));
		getPanelCategorias().setToolTipText(textos.getString("tooltip.panelIzquierdoPremios"));
		getPanelFiltros().setToolTipText(textos.getString("tooltip.panelIzquierdoPremios"));
		getSpinnerPuntosMaximos().setToolTipText(textos.getString("tooltip.panelIzquierdoPremios"));
		getSpinnerPuntosMinimos().setToolTipText(textos.getString("tooltip.panelIzquierdoPremios"));
		
	}

	protected void mostrarMensajePuntosInsuficientes() {
		JOptionPane.showOptionDialog(this, textos.getString("mensajePuntosInsuficientes"), textos.getString("puntosInsuficientes"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
		
	}
	private void filtrarPremios() {
		
		Double puntosMax=(Double)getSpinnerPuntosMaximos().getValue();
		Double puntosMin=(Double)getSpinnerPuntosMinimos().getValue();
		if(puntosMin.doubleValue()>puntosMax.doubleValue()) {
			getSpinnerPuntosMinimos().setModel(new SpinnerNumberModel(puntosMax.doubleValue(),0.0, puntosMax.doubleValue(),1));		
		}else {
			getSpinnerPuntosMinimos().setModel(new SpinnerNumberModel(puntosMin.doubleValue(),0.0, puntosMax.doubleValue(),1));		
		}
		getPanelPremiosCentral().removeAll();
		for(Premio p : juego.getPremios()) {
			if((categoriaSeleccionada.equals(CategoriasPremios.Todas.getNombre())||p.getCategoria().equals(categoriaSeleccionada))&&p.getPuntos()>=puntosMin.doubleValue() && p.getPuntos()<=puntosMax.doubleValue()) {
				PanelPremioIndividual panel=new PanelPremioIndividual(this, p, textos);
				getPanelPremiosCentral().add(panel);
			}
		}
		getPanelPremiosCentral().updateUI();
		
	}

	private void crearBotonesCategorias() {
		getPanelCategorias().removeAll();
		for(CategoriasPremios cat : CategoriasPremios.values()) {
			JButton b=new JButton();
			b.setText(textos.getString(cat.getNombre()));
			b.setActionCommand(cat.getNombre());
			b.addActionListener(pc);
			b.setToolTipText(textos.getString("tooltip.panelIzquierdoPremios"));
			getPanelCategorias().add(b);
			b.setMnemonic(textos.getString(cat.getNombre()).charAt(0));
		}
		
	}

	private void mostrarMensajesPanelPremios() {
		getRootPane().setDefaultButton(getBtValidarDni());
		getLbPremios().setText(textos.getString("premios"));
		getLbMensajePremio().setText(textos.getString("textoEscogerRegalo"));
		getTfPuntosRestantes().setText(textos.getString("puntosRestantes")+juego.getJuego().getJugador().getPuntos());
		getBtEscogerPremios().setText(textos.getString("escoger"));
		getBtEscogerPremios().setMnemonic(textos.getString("escoger").charAt(0));
		getLbPuntosMaximos().setText(textos.getString("puntosMaximos"));
		getLbPuntosMaximos().setDisplayedMnemonic(textos.getString("puntosMaximos").charAt(0));
		getLbPuntosMinimos().setText(textos.getString("puntosMinimos"));
		getLbPuntosMinimos().setDisplayedMnemonic(textos.getString("puntosMinimos").charAt(0));
	}

	private void mostrarMensajeError() {
		JOptionPane.showOptionDialog(this, textos.getString("seHaProducidoUnError"), textos.getString("error"), JOptionPane.OK_OPTION, JOptionPane.ERROR_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
		
	}

	private void mostrarTicketNoValido() {
		JOptionPane.showOptionDialog(this, textos.getString("ticketInvalido"), textos.getString("datosInvalidos"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
	}
	private void mostrarTicketInferiorAlPrecioMinimo() {
		JOptionPane.showOptionDialog(this, textos.getString("ticketInvalidoMenorAlPrecioMinimo"), textos.getString("datosInvalidos"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
	}
	private void mostrarTicketDeOtraTienda() {
		JOptionPane.showOptionDialog(this, textos.getString("ticketInvalidoDeOtraTienda"), textos.getString("datosInvalidos"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
	}
	private void mostrarPanelPremiosEscogidos() {
		((CardLayout)getPanelVentanas().getLayout()).show(panelVentanas,"panelPremiosEscogidos");
		getLbPremiosEscogidos().setText(textos.getString("premiosEscogidos"));
		getLbDNI().setText(textos.getString("dni"));
		getLbDNI().setDisplayedMnemonic(textos.getString("dni").charAt(0));
		getLbDNI().setToolTipText(textos.getString("tooltip.dni"));
		getTextFieldDNI().setToolTipText(textos.getString("tooltip.dni"));
		getBtAnteriorPremiosEscogidos().setText(textos.getString("anterior"));
		getBtAnteriorPremiosEscogidos().setMnemonic(textos.getString("anterior").charAt(0));
		getBtValidarDni().setText(textos.getString("validarDniYFinalizar"));
		getBtValidarDni().setMnemonic(textos.getString("validarDniYFinalizar").charAt(0));
		getTextFieldDNI().setText("");
		mostrarPremiosEscogidos();
	}
	


	private void mostrarPremiosEscogidos() {
		getPanelCentralPremiosEscogidos().removeAll();
		for(Premio p : juego.getJuego().getJugador().getPremios()) {
			PanelPremioEscogido panel=new PanelPremioEscogido(p, this, textos);
			getPanelCentralPremiosEscogidos().add(panel);
		}
	}

	private JPanel getPanelInicio() {
		if (panelInicio == null) {
			panelInicio = new JPanel();
			panelInicio.setLayout(new BorderLayout(0, 0));
			panelInicio.add(getPanelTextoInicio(), BorderLayout.NORTH);
			panelInicio.add(getPanelBotonesInicio(), BorderLayout.CENTER);
			panelInicio.add(getCheckBoxDaltonico(), BorderLayout.SOUTH);
		}
		return panelInicio;
	}
	private JPanel getPanelTextoInicio() {
		if (panelTextoInicio == null) {
			panelTextoInicio = new JPanel();
			panelTextoInicio.setLayout(new GridLayout(0, 1, 0, 0));
			panelTextoInicio.add(getLbEnhorabuenaInicio());
			panelTextoInicio.add(getLbTextoInicio());
		}
		return panelTextoInicio;
	}
	private JLabel getLbEnhorabuenaInicio() {
		if (lbEnhorabuenaInicio == null) {
			lbEnhorabuenaInicio = new JLabel();
			lbEnhorabuenaInicio.setHorizontalAlignment(SwingConstants.CENTER);
			lbEnhorabuenaInicio.setFont(new Font("Arial", Font.BOLD, 18));
			
		}
		return lbEnhorabuenaInicio;
	}
	private JLabel getLbTextoInicio() {
		if (lbTextoInicio == null) {
			lbTextoInicio = new JLabel();
			lbTextoInicio.setHorizontalAlignment(SwingConstants.CENTER);
			lbTextoInicio.setFont(new Font("Arial", Font.BOLD, 16));

		}
		return lbTextoInicio;
	}
	private JPanel getPanelBotonesInicio() {
		if (panelBotonesInicio == null) {
			panelBotonesInicio = new JPanel();
			panelBotonesInicio.setLayout(new GridLayout(0, 1, 50, 20));
			panelBotonesInicio.add(getBtComoJugarInicio());
			panelBotonesInicio.add(getBtIniciarPartidaInicio());
		}
		return panelBotonesInicio;
	}
	private JButton getBtComoJugarInicio() {
		if (btComoJugarInicio == null) {
			btComoJugarInicio = new JButton();
			btComoJugarInicio.setMnemonic('?');
			btComoJugarInicio.setFont(new Font("Arial", Font.BOLD, 18));
		}
		return btComoJugarInicio;
	}
	private JButton getBtIniciarPartidaInicio() {
		if (btIniciarPartidaInicio == null) {
			btIniciarPartidaInicio = new JButton();
			btIniciarPartidaInicio.setMnemonic('a');
			btIniciarPartidaInicio.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					iniciarPartida();
				}
			});
			btIniciarPartidaInicio.setFont(new Font("Arial", Font.BOLD, 18));

		}
		return btIniciarPartidaInicio;
	}
	protected void iniciarPartida() {
		getPanelCentralDelPanelNorteJuego().removeAll();
		mostrarCabecilla();
		crearBotonInvasoresSiguienteRonda();
		crearCasillasTablero();
		mostrarPanelJuego();
		mostrarInvasoresAColocar();
		actualizarPuntos();
		actualizarIteracion();
	}

	private JCheckBox getCheckBoxDaltonico() {
		if (checkBoxDaltonico == null) {
			checkBoxDaltonico = new JCheckBox();
			checkBoxDaltonico.setMnemonic('d');
			checkBoxDaltonico.setFont(new Font("Arial", Font.PLAIN, 14));

		}
		return checkBoxDaltonico;
	}
	private JPanel getPanelJuego() {
		if (panelJuego == null) {
			panelJuego = new JPanel();
			panelJuego.setLayout(new BorderLayout(0, 0));
			panelJuego.add(getPanelNorteJuego(), BorderLayout.NORTH);
			panelJuego.add(getPanelCentralJuego(), BorderLayout.CENTER);
		}
		return panelJuego;
	}
	private JPanel getPanelNorteJuego() {
		if (panelNorteJuego == null) {
			panelNorteJuego = new JPanel();
			panelNorteJuego.setBackground(new Color(255, 255, 255));
			panelNorteJuego.setLayout(new BorderLayout(0, 0));
			panelNorteJuego.add(getPanelOesteDelPanelNorteJuego(), BorderLayout.WEST);
			panelNorteJuego.add(getPanelCentralDelPanelNorteJuego(), BorderLayout.CENTER);
			panelNorteJuego.add(getPanelEsteDelPanelNorteJuego(), BorderLayout.EAST);
		}
		return panelNorteJuego;
	}
	private JPanel getPanelCentralJuego() {
		if (panelCentralJuego == null) {
			panelCentralJuego = new JPanel();
			panelCentralJuego.setBackground(new Color(255, 255, 255));
			panelCentralJuego.setLayout(new GridLayout(Tablero.ROWS, Tablero.COLUMNS, 0, 0));

		}
		return panelCentralJuego;
	}
	

	private JPanel getPanelOesteDelPanelNorteJuego() {
		if (panelOesteDelPanelNorteJuego == null) {
			panelOesteDelPanelNorteJuego = new JPanel();
			panelOesteDelPanelNorteJuego.add(getPanelPuntucionEIteracionJuego());
		}
		return panelOesteDelPanelNorteJuego;
	}
	private JPanel getPanelCentralDelPanelNorteJuego() {
		if (panelCentralDelPanelNorteJuego == null) {
			panelCentralDelPanelNorteJuego = new JPanel();
			panelCentralDelPanelNorteJuego.setLayout(new GridLayout(0, 7, 0, 0));

			
		}
		return panelCentralDelPanelNorteJuego;
	}
	private JPanel getPanelEsteDelPanelNorteJuego() {
		if (panelEsteDelPanelNorteJuego == null) {
			panelEsteDelPanelNorteJuego = new JPanel();
			panelEsteDelPanelNorteJuego.add(getBtAyudaJuego());
		}
		return panelEsteDelPanelNorteJuego;
	}
	private JTextField getTfPuntuacionJuego() {
		if (tfPuntuacionJuego == null) {
			tfPuntuacionJuego = new JTextField();
			tfPuntuacionJuego.setEditable(false);
			tfPuntuacionJuego.setFont(new Font("Arial", Font.BOLD, 15));
			tfPuntuacionJuego.setColumns(10);
		}
		return tfPuntuacionJuego;
	}
	private JButton getBtAyudaJuego() {
		if (btAyudaJuego == null) {
			btAyudaJuego=new JButton();
			btAyudaJuego.setFont(new Font("Arial", Font.BOLD, 16));
			btAyudaJuego.setBackground(Color.lightGray);
		}
		return btAyudaJuego;
	}
	
	private void crearBotonInvasoresSiguienteRonda() {
		for(int i=1;i<btInvasoresSiguienteRonda.length;i++) {
			btInvasoresSiguienteRonda[i]=new JButton();
			btInvasoresSiguienteRonda[i].setBackground(Color.LIGHT_GRAY);
			btInvasoresSiguienteRonda[i].setBorder(new LineBorder(Color.gray, 1));
			btInvasoresSiguienteRonda[i].setActionCommand(String.valueOf(i-1));
			getPanelCentralDelPanelNorteJuego().add(btInvasoresSiguienteRonda[i]);
			btInvasoresSiguienteRonda[i].addActionListener(seleccInv);
		}
	}
	private void crearCasillasTablero() {
		panelCentralJuego.removeAll();
		for(int i=0;i<juego.getJuego().getTablero().getTablero().length;i++) {
			for(int j=0;j<juego.getJuego().getTablero().getTablero()[i].length;j++) {
				tablero[i][j]=new JButton();
				tablero[i][j].setBackground(Color.LIGHT_GRAY);
				tablero[i][j].setBorder(new LineBorder(Color.gray,1));
				if(!juego.getJuego().getTablero().getTablero()[i][j].isAvailable()) {
					if(getCheckBoxDaltonico().isSelected()) {
						tablero[i][j].setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/muro.jpg")));
						tablero[i][j].setDisabledIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/muro.jpg")));
					}else {
						tablero[i][j].setBackground(Color.gray);
					}
					tablero[i][j].setEnabled(false);
				}
				else if(juego.getJuego().getTablero().getTablero()[i][j].getInvasor()!=null) {
					tablero[i][j].setIcon(adaptarImagen(VentanaPrincipal.class.getResource(juego.getJuego().getTablero().getTablero()[i][j].getInvasor().getInvasorType().getDireccionFoto())));

				}
				
				tablero[i][j].setActionCommand(i+":"+j);
				panelCentralJuego.add(tablero[i][j]);
				tablero[i][j].addActionListener(seleccCasilla);
			}
		}
	}
	
	private void mostrarCabecilla() {
		btInvasoresSiguienteRonda[0]=new JButton();
		//btInvasoresSiguienteRonda[0].setText(Juego.CABECILLA.getNombre());
		btInvasoresSiguienteRonda[0].setBackground(Color.black);
		btInvasoresSiguienteRonda[0].setBorder(new LineBorder(Color.green,5));
		getPanelCentralDelPanelNorteJuego().add(btInvasoresSiguienteRonda[0]);
		btInvasoresSiguienteRonda[0].setEnabled(false);
		if(getCheckBoxDaltonico().isSelected()) {
			//En este caso no hace falta añadir nada
		}

		btInvasoresSiguienteRonda[0].setIcon(adaptarImagen(VentanaPrincipal.class.getResource(Juego.CABECILLA.getDireccionFoto())));
		btInvasoresSiguienteRonda[0].setDisabledIcon(adaptarImagen(VentanaPrincipal.class.getResource(Juego.CABECILLA.getDireccionFoto())));

	}
	private void mostrarInvasoresAColocar() {
		for(int i=1;i<btInvasoresSiguienteRonda.length;i++) {
			if(juego.getJuego().getInvasores()[i-1]!=null) {
				//btInvasoresSiguienteRonda[i].setText(juego.getJuego().getInvasores()[i-1].getInvasorType().getNombre());
				btInvasoresSiguienteRonda[i].setEnabled(true);
				btInvasoresSiguienteRonda[i].setIcon(adaptarImagen(VentanaPrincipal.class.getResource(juego.getJuego().getInvasores()[i-1].getInvasorType().getDireccionFoto())));
			}
		}
	}

	class SeleccionaInvasorAColocar implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			juego.getJuego().setInvasorSeleccionado(juego.getJuego().getInvasores()[Integer.parseInt(e.getActionCommand())]);
			if(btInvasorSeleccionado==null) {
				btInvasorSeleccionado=(JButton)e.getSource();
				btInvasorSeleccionado.setBorder(new LineBorder(Color.black, 5));
			}else {
				btInvasorSeleccionado.setBorder(new LineBorder(Color.gray,1));
				btInvasorSeleccionado=(JButton)e.getSource();
				btInvasorSeleccionado.setBorder(new LineBorder(Color.black, 5));
			}
			
		}
		
	}
	class SeleccionaCasillaAColocarInvasor implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(juego.getJuego().getInvasorSeleccionado()!=null) {
				JButton bt=(JButton)e.getSource();
				int fila=Integer.parseInt(bt.getActionCommand().split(":")[0]);
				int columna=Integer.parseInt(bt.getActionCommand().split(":")[1]);
				if(juego.colocarInvasor(Integer.parseInt(btInvasorSeleccionado.getActionCommand()), fila, columna)==true) {
					btInvasorSeleccionado.setEnabled(false);
					btInvasorSeleccionado.setBorder(new LineBorder(Color.gray,1));
				}
				actualizarCasilla(fila, columna);
			}
			comprobarFin();
		}
		
	}
	
	private void actualizarTablero() {
		for(int i=0;i<Tablero.ROWS;i++) {
			for(int j=0;j<Tablero.COLUMNS;j++) {
				if(!juego.getJuego().getTablero().getTablero()[i][j].isAvailable()) {
					if(getCheckBoxDaltonico().isSelected()) {
						tablero[i][j].setIcon(new ImageIcon(VentanaPrincipal.class.getResource("/img/muro.jpg")));
					}else {
						tablero[i][j].setBackground(Color.gray);
					}
					tablero[i][j].setEnabled(false);
				}
				else if(juego.getJuego().getTablero().getTablero()[i][j].getInvasor()==null) {
					tablero[i][j].setIcon(null);
				}else {
					//tablero[i][j].setText(juego.getJuego().getTablero().getTablero()[i][j].getInvasor().getInvasorType().getNombre());
					tablero[i][j].setIcon(adaptarImagen(VentanaPrincipal.class.getResource(juego.getJuego().getTablero().getTablero()[i][j].getInvasor().getInvasorType().getDireccionFoto())));;
					
				}
			}
		}
	}
	public void actualizarCasilla(int fila, int columna) {
			if(juego.getJuego().getTablero().getTablero()[fila][columna].getInvasor()==null) {
				//tablero[fila][columna].setText("");
				tablero[fila][columna].setIcon(null);
			}else {
				//tablero[fila][columna].setText(juego.getJuego().getTablero().getTablero()[fila][columna].getInvasor().getInvasorType().getNombre());
				tablero[fila][columna].setIcon(adaptarImagen(VentanaPrincipal.class.getResource(juego.getJuego().getTablero().getTablero()[fila][columna].getInvasor().getInvasorType().getDireccionFoto())));;
			}
	}

	public void actualizarPuntos() {
		getTfPuntuacionJuego().setText(textos.getString("puntuacion")+NumberFormat.getNumberInstance().format(juego.getJuego().getJugador().getPuntos()));
	}
	public void actualizarPuntosRestantes() {
		getTfPuntosRestantes().setText(textos.getString("puntosRestantes")+NumberFormat.getNumberInstance().format(juego.getJuego().getJugador().getPuntosRestantes()));
		getTfPuntosRestantes().updateUI();
	}

	public void comprobarFin() {
		mostrarInvasoresAColocar();
		actualizarTablero();
		actualizarPuntos();
		if(juego.getJuego().isFin()){
			actualizarTablero();
			actualizarPuntos();
			if(juego.getJuego().getFinal()==Juego.CABECILLAS_ELIMINADOS) {
				JOptionPane.showOptionDialog(this, textos.getString("fin.cabecillasEliminados")+juego.getJuego().getJugador().getPuntos(), textos.getString("fin"), JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
			}
			else if(juego.getJuego().getFinal()==Juego.FIN_ITERACIONES) {
				JOptionPane.showOptionDialog(this, textos.getString("fin.finIteraciones")+juego.getJuego().getJugador().getPuntos(), textos.getString("fin"), JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);

				}else if(juego.getJuego().getFinal()==Juego.TODAS_CASILLAS_OCUPADAS) {
					JOptionPane.showOptionDialog(this, textos.getString("fin.casillasOcupadas")+juego.getJuego().getJugador().getPuntos(), textos.getString("fin"), JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
					}
			mostrarPanelResumen();
		}else {
			actualizarIteracion();
		}
		
	}
	
	
	private void actualizarIteracion() {
		getTfIteracionJuego().setText(textos.getString("iteracion")+juego.getJuego().getIteracion()+"/"+Juego.NUMERO_ITERACIONES);
	}

	private JPanel getPanelPuntucionEIteracionJuego() {
		if (panelPuntucionEIteracionJuego == null) {
			panelPuntucionEIteracionJuego = new JPanel();
			panelPuntucionEIteracionJuego.setLayout(new GridLayout(2, 1, 0, 0));
			panelPuntucionEIteracionJuego.add(getTfPuntuacionJuego());
			panelPuntucionEIteracionJuego.add(getTfIteracionJuego());
		}
		return panelPuntucionEIteracionJuego;
	}
	private JTextField getTfIteracionJuego() {
		if (tfIteracionJuego == null) {
			tfIteracionJuego = new JTextField();
			tfIteracionJuego.setFont(new Font("Arial", Font.BOLD, 14));
			tfIteracionJuego.setEditable(false);
			tfIteracionJuego.setColumns(10);
			getTfIteracionJuego().setText(textos.getString("iteracion")+juego.getJuego().getIteracion()+"/"+Juego.NUMERO_ITERACIONES);
		}
		return tfIteracionJuego;
	}
	private JPanel getPanelResumen() {
		if (panelResumen == null) {
			panelResumen = new JPanel();
			panelResumen.setLayout(new BorderLayout(0, 0));
			panelResumen.add(getBtContinuarResumen(), BorderLayout.SOUTH);
			panelResumen.add(getPanelContenidoResumen(), BorderLayout.CENTER);
		}
		return panelResumen;
	}
	private JButton getBtContinuarResumen() {
		if (btContinuarResumen == null) {
			btContinuarResumen = new JButton("");
			btContinuarResumen.setFont(new Font("Arial", Font.PLAIN, 14));
			btContinuarResumen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(juego.getJuego().win()) {
						mostrarPanelPremios();
					}else {
						reiniciar();
					}
				}
			});
		}
		return btContinuarResumen;
	}
	private JPanel getPanelContenidoResumen() {
		if (panelContenidoResumen == null) {
			panelContenidoResumen = new JPanel();
			panelContenidoResumen.setLayout(new BorderLayout(0, 0));
			panelContenidoResumen.add(getPanelEstadisticas(), BorderLayout.CENTER);
			panelContenidoResumen.add(getLbGameOver(), BorderLayout.NORTH);
			panelContenidoResumen.add(getPanelMensajeResultadoPartida(), BorderLayout.SOUTH);
		}
		return panelContenidoResumen;
	}
	private JPanel getPanelEstadisticas() {
		if (panelEstadisticas == null) {
			panelEstadisticas = new JPanel();
			panelEstadisticas.setLayout(new GridLayout(0, 2, 0, 0));
			panelEstadisticas.add(getLbPuntuacionResumen());
			panelEstadisticas.add(getTfPuntuacionResumen());
			panelEstadisticas.add(getLbInvasoresEliminados());
			panelEstadisticas.add(getTfInvasoresEliminados());
			panelEstadisticas.add(getLbCombinacionesDe3());
			panelEstadisticas.add(getTfCombinaciones3());
			panelEstadisticas.add(getLbCombinacionesDe4());
			panelEstadisticas.add(getTfCombinaciones4());
			panelEstadisticas.add(getLbCombinacionesDe5());
			panelEstadisticas.add(getTfCombinaciones5());
			panelEstadisticas.add(getLbCombinacionesDe6());
			panelEstadisticas.add(getTfCombinaciones6());
			panelEstadisticas.add(getLbCombinacionesDe7());
			panelEstadisticas.add(getTfCombinaciones7());
		}
		return panelEstadisticas;
	}
	private JLabel getLbGameOver() {
		if (lbGameOver == null) {
			lbGameOver = new JLabel("");
			lbGameOver.setFont(new Font("Arial", Font.BOLD, 20));
			lbGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbGameOver;
	}
	private JLabel getLbInvasoresEliminados() {
		if (lbInvasoresEliminados == null) {
			lbInvasoresEliminados = new JLabel();
			lbInvasoresEliminados.setHorizontalAlignment(SwingConstants.CENTER);
			lbInvasoresEliminados.setFont(new Font("Arial", Font.PLAIN, 16));
			lbInvasoresEliminados.setBorder(new LineBorder(new Color(0, 0, 0)));

		}
		return lbInvasoresEliminados;
	}
	private JTextField getTfPuntuacionResumen() {
		if (tfPuntuacionResumen == null) {
			tfPuntuacionResumen = new JTextField();
			tfPuntuacionResumen.setHorizontalAlignment(SwingConstants.CENTER);
			tfPuntuacionResumen.setFont(new Font("Arial", Font.PLAIN, 16));
			tfPuntuacionResumen.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfPuntuacionResumen.setEditable(false);
			tfPuntuacionResumen.setColumns(10);
			
		}
		return tfPuntuacionResumen;
	}
	private void mostrarEstadisticas() {
		getTfPuntuacionResumen().setText(String.valueOf(juego.getJuego().getJugador().getPuntos()));
		getTfInvasoresEliminados().setText(String.valueOf(juego.getJuego().getInvasoresEliminados()));
		getTfCombinaciones3().setText(String.valueOf(juego.getJuego().getCombinaciones3()));
		getTfCombinaciones4().setText(String.valueOf(juego.getJuego().getCombinaciones4()));
		getTfCombinaciones5().setText(String.valueOf(juego.getJuego().getCombinaciones5()));
		getTfCombinaciones6().setText(String.valueOf(juego.getJuego().getCombinaciones6()));
		getTfCombinaciones7().setText(String.valueOf(juego.getJuego().getCombinaciones7()));
		
	}
	private JLabel getLbPuntuacionResumen() {
		if (lbPuntuacionResumen == null) {
			lbPuntuacionResumen = new JLabel();
			lbPuntuacionResumen.setHorizontalAlignment(SwingConstants.CENTER);
			lbPuntuacionResumen.setFont(new Font("Arial", Font.PLAIN, 16));
			lbPuntuacionResumen.setBorder(new LineBorder(new Color(0, 0, 0)));

		}
		return lbPuntuacionResumen;
	}
	private JLabel getLbCombinacionesDe6() {
		if (lbCombinacionesDe6 == null) {
			lbCombinacionesDe6 = new JLabel();
			lbCombinacionesDe6.setHorizontalAlignment(SwingConstants.CENTER);
			lbCombinacionesDe6.setFont(new Font("Arial", Font.PLAIN, 16));
			lbCombinacionesDe6.setBorder(new LineBorder(new Color(0, 0, 0)));

		}
		return lbCombinacionesDe6;
	}
	private JLabel getLbCombinacionesDe3() {
		if (lbCombinacionesDe3 == null) {
			lbCombinacionesDe3 = new JLabel();
			lbCombinacionesDe3.setHorizontalAlignment(SwingConstants.CENTER);
			lbCombinacionesDe3.setFont(new Font("Arial", Font.PLAIN, 16));
			lbCombinacionesDe3.setBorder(new LineBorder(new Color(0, 0, 0)));

		}
		return lbCombinacionesDe3;
	}
	private JLabel getLbCombinacionesDe4() {
		if (lbCombinacionesDe4 == null) {
			lbCombinacionesDe4 = new JLabel();
			lbCombinacionesDe4.setHorizontalAlignment(SwingConstants.CENTER);
			lbCombinacionesDe4.setFont(new Font("Arial", Font.PLAIN, 16));
			lbCombinacionesDe4.setBorder(new LineBorder(new Color(0, 0, 0)));

		}
		return lbCombinacionesDe4;
	}
	private JLabel getLbCombinacionesDe5() {
		if (lbCombinacionesDe5 == null) {
			lbCombinacionesDe5 = new JLabel();
			lbCombinacionesDe5.setHorizontalAlignment(SwingConstants.CENTER);
			lbCombinacionesDe5.setFont(new Font("Arial", Font.PLAIN, 16));
			lbCombinacionesDe5.setBorder(new LineBorder(new Color(0, 0, 0)));

		}
		return lbCombinacionesDe5;
	}
	private JTextField getTfInvasoresEliminados() {
		if (tfInvasoresEliminados == null) {
			tfInvasoresEliminados = new JTextField();
			tfInvasoresEliminados.setHorizontalAlignment(SwingConstants.CENTER);
			tfInvasoresEliminados.setFont(new Font("Arial", Font.PLAIN, 16));
			tfInvasoresEliminados.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfInvasoresEliminados.setEditable(false);
			tfInvasoresEliminados.setColumns(10);
			
		}
		return tfInvasoresEliminados;
	}
	private JTextField getTfCombinaciones3() {
		if (tfCombinaciones3 == null) {
			tfCombinaciones3 = new JTextField();
			tfCombinaciones3.setHorizontalAlignment(SwingConstants.CENTER);
			tfCombinaciones3.setFont(new Font("Arial", Font.PLAIN, 16));
			tfCombinaciones3.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfCombinaciones3.setEditable(false);
			tfCombinaciones3.setColumns(10);

		}
		return tfCombinaciones3;
	}
	private JTextField getTfCombinaciones4() {
		if (tfCombinaciones4 == null) {
			tfCombinaciones4 = new JTextField();
			tfCombinaciones4.setHorizontalAlignment(SwingConstants.CENTER);
			tfCombinaciones4.setFont(new Font("Arial", Font.PLAIN, 16));
			tfCombinaciones4.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfCombinaciones4.setEditable(false);
			tfCombinaciones4.setColumns(10);
			
		}
		return tfCombinaciones4;
	}
	private JTextField getTfCombinaciones5() {
		if (tfCombinaciones5 == null) {
			tfCombinaciones5 = new JTextField();
			tfCombinaciones5.setHorizontalAlignment(SwingConstants.CENTER);
			tfCombinaciones5.setFont(new Font("Arial", Font.PLAIN, 16));
			tfCombinaciones5.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfCombinaciones5.setEditable(false);
			tfCombinaciones5.setColumns(10);
			
		}
		return tfCombinaciones5;
	}
	private JTextField getTfCombinaciones6() {
		if (tfCombinaciones6 == null) {
			tfCombinaciones6 = new JTextField();
			tfCombinaciones6.setHorizontalAlignment(SwingConstants.CENTER);
			tfCombinaciones6.setFont(new Font("Arial", Font.PLAIN, 16));
			tfCombinaciones6.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfCombinaciones6.setEditable(false);
			tfCombinaciones6.setColumns(10);
			
			
		}
		return tfCombinaciones6;
	}
	private JTextField getTfCombinaciones7() {
		if (tfCombinaciones7 == null) {
			tfCombinaciones7 = new JTextField();
			tfCombinaciones7.setHorizontalAlignment(SwingConstants.CENTER);
			tfCombinaciones7.setFont(new Font("Arial", Font.PLAIN, 16));
			tfCombinaciones7.setBorder(new LineBorder(new Color(0, 0, 0)));
			tfCombinaciones7.setEditable(false);
			tfCombinaciones7.setColumns(10);
		
		}
		return tfCombinaciones7;
	}
	private JLabel getLbCombinacionesDe7() {
		if (lbCombinacionesDe7 == null) {
			lbCombinacionesDe7 = new JLabel();
			lbCombinacionesDe7.setHorizontalAlignment(SwingConstants.CENTER);
			lbCombinacionesDe7.setFont(new Font("Arial", Font.PLAIN, 16));
			lbCombinacionesDe7.setBorder(new LineBorder(new Color(0, 0, 0)));

		}
		return lbCombinacionesDe7;
	}
	private JPanel getPanelMensajeResultadoPartida() {
		if (panelMensajeResultadoPartida == null) {
			panelMensajeResultadoPartida = new JPanel();
			panelMensajeResultadoPartida.setLayout(new GridLayout(0, 1, 0, 0));
			panelMensajeResultadoPartida.add(getLbResultadoPartida());
			panelMensajeResultadoPartida.add(getLbMensajeFinPartida());
		}
		return panelMensajeResultadoPartida;
	}
	private JLabel getLbResultadoPartida() {
		if (lbResultadoPartida == null) {
			lbResultadoPartida = new JLabel();
			lbResultadoPartida.setFont(new Font("Arial", Font.BOLD, 16));
			lbResultadoPartida.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbResultadoPartida;
	}
	private JLabel getLbMensajeFinPartida() {
		if (lbMensajeFinPartida == null) {
			lbMensajeFinPartida = new JLabel();
			lbMensajeFinPartida.setFont(new Font("Arial", Font.PLAIN, 16));
			lbMensajeFinPartida.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbMensajeFinPartida;
	}
	private void mostrarMensajesPanelResumen() {
		if(juego.getJuego().win()) {
			getLbMensajeFinPartida().setText(textos.getString("pulsaContinuarParaEscogerRegalo"));
			getLbResultadoPartida().setText(textos.getString("hasGanado"));
			getBtContinuarResumen().setText(textos.getString("continuar"));
			getBtContinuarResumen().setMnemonic(textos.getString("continuar").charAt(0));
		}else {
			getLbMensajeFinPartida().setText(textos.getString("pulsaFinalizar"));
			getLbResultadoPartida().setText(textos.getString("hasPerdido"));
			getBtContinuarResumen().setText(textos.getString("finalizar"));
			getBtContinuarResumen().setMnemonic(textos.getString("finalizar").charAt(0));
		}
		getLbGameOver().setText(textos.getString("gameOver"));
		getLbPuntuacionResumen().setText(textos.getString("puntuacion"));
		getLbInvasoresEliminados().setText(textos.getString("invasoresEliminados"));
		getLbCombinacionesDe3().setText(textos.getString("combinaciones3"));
		getLbCombinacionesDe4().setText(textos.getString("combinaciones4"));
		getLbCombinacionesDe5().setText(textos.getString("combinaciones5"));
		getLbCombinacionesDe6().setText(textos.getString("combinaciones6"));
		getLbCombinacionesDe7().setText(textos.getString("combinaciones7"));
		
	}
	
	public void actualizarPuntosPanelPremios() {
		getTfPuntosRestantes().setText(textos.getString("puntosRestantes")+juego.getJuego().getJugador().getPuntosRestantes());
	}
	private JPanel getPanelPremios() {
		if (panelPremios == null) {
			panelPremios = new JPanel();
			panelPremios.setLayout(new BorderLayout(0, 0));
			panelPremios.add(getPanelIzquierdoPremios(), BorderLayout.WEST);
			panelPremios.add(getPanelNortePremios(), BorderLayout.NORTH);
			panelPremios.add(getScrollPanePremios(), BorderLayout.CENTER);
			panelPremios.add(getBtEscogerPremios(), BorderLayout.SOUTH);
			panelPremios.add(getPanelFiltrosYCategoriasPremios(), BorderLayout.WEST);
		}
		return panelPremios;
	}
	private JPanel getPanelIzquierdoPremios() {
		if (panelIzquierdoPremios == null) {
			panelIzquierdoPremios = new JPanel();
			panelIzquierdoPremios.setLayout(new GridLayout(0, 1, 0, 0));
			panelIzquierdoPremios.add(getPanelCategoriasPremios());
			panelIzquierdoPremios.add(getPanelFiltrosPremios());

		}
		return panelIzquierdoPremios;
	}
	private JPanel getPanelCategoriasPremios() {
		if (panelCategoriasPremios == null) {
			panelCategoriasPremios = new JPanel();
		}
		return panelCategoriasPremios;
	}
	private JPanel getPanelFiltrosPremios() {
		if (panelFiltrosPremios == null) {
			panelFiltrosPremios = new JPanel();
		}
		return panelFiltrosPremios;
	}
	private JPanel getPanelNortePremios() {
		if (panelNortePremios == null) {
			panelNortePremios = new JPanel();
			panelNortePremios.setLayout(new GridLayout(0, 1, 0, 0));
			panelNortePremios.add(getLbPremios());
			panelNortePremios.add(getLbMensajePremio());
			panelNortePremios.add(getTfPuntosRestantes());
		}
		return panelNortePremios;
	}
	private JLabel getLbPremios() {
		if (lbPremios == null) {
			lbPremios = new JLabel();
			lbPremios.setFont(new Font("Arial", Font.BOLD, 16));
			lbPremios.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbPremios;
	}
	private JLabel getLbMensajePremio() {
		if (lbMensajePremio == null) {
			lbMensajePremio = new JLabel();
			lbMensajePremio.setFont(new Font("Arial", Font.PLAIN, 14));
			lbMensajePremio.setBackground(new Color(255, 255, 255));
			lbMensajePremio.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lbMensajePremio;
	}
	private JTextField getTfPuntosRestantes() {
		if (tfPuntosRestantes == null) {
			tfPuntosRestantes = new JTextField();
			tfPuntosRestantes.setFont(new Font("Arial", Font.PLAIN, 14));
			tfPuntosRestantes.setEditable(false);
			tfPuntosRestantes.setHorizontalAlignment(SwingConstants.CENTER);
			tfPuntosRestantes.setColumns(10);
		}
		return tfPuntosRestantes;
	}
	private JScrollPane getScrollPanePremios() {
		if (scrollPanePremios == null) {
			scrollPanePremios = new JScrollPane();
			scrollPanePremios.setOpaque(true);
			scrollPanePremios.getVerticalScrollBar().setUI(new BasicScrollBarUI());
			scrollPanePremios.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
			scrollPanePremios.setViewportView(getPanelPremiosCentral());
		}
		return scrollPanePremios;
	}
	private JPanel getPanelPremiosCentral() {
		if (panelPremiosCentral == null) {
			panelPremiosCentral = new JPanel();
			panelPremiosCentral.setBorder(new EmptyBorder(10, 10, 10, 10));
			panelPremiosCentral.setLayout(new GridLayout(0, 3, 10, 10));
		}
		return panelPremiosCentral;
	}

	private void crearPanelesPremios() {
		getPanelPremiosCentral().removeAll();
		for(Premio p : juego.getPremios()) {
			PanelPremioIndividual panel=new PanelPremioIndividual(this, p, textos);
			getPanelPremiosCentral().add(panel);
		}
		
	}
	private JButton getBtEscogerPremios() {
		if (btEscogerPremios == null) {
			btEscogerPremios = new JButton();
			btEscogerPremios.setBackground(Color.LIGHT_GRAY);
			btEscogerPremios.setFont(new Font("Arial", Font.PLAIN, 14));
			btEscogerPremios.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					checkPremiosEscogidos();
				}
			});
		}
		return btEscogerPremios;
	}
	protected void checkPremiosEscogidos() {
		if(juego.getJuego().getJugador().getPremios().isEmpty()) {
			JOptionPane.showOptionDialog(this, textos.getString("mensajeNingunPremioEscogido"), textos.getString("ningunPremioEscogido"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);

		}
		else if(juego.getJuego().checkPremiosEscogidos()) {
			mostrarPanelPremiosEscogidos();
		}
		else {
			JOptionPane.showOptionDialog(this, textos.getString("mensajePuntosInsuficientes"), textos.getString("puntosInsuficientes"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);

			JOptionPane.showMessageDialog(this, textos.getString("mensajePuntosInsuficientes"), textos.getString("puntosInsuficientes"), JOptionPane.WARNING_MESSAGE);
		}
		
	}

	private JPanel getPanelFiltrosYCategoriasPremios() {
		if (panelFiltrosYCategoriasPremios == null) {
			panelFiltrosYCategoriasPremios = new JPanel();
			panelFiltrosYCategoriasPremios.setLayout(new GridLayout(0, 1, 0, 0));
			panelFiltrosYCategoriasPremios.add(getPanelCategorias());
			panelFiltrosYCategoriasPremios.add(getPanelFiltros());
		}
		return panelFiltrosYCategoriasPremios;
	}
	private JPanel getPanelCategorias() {
		if (panelCategorias == null) {
			panelCategorias = new JPanel();
			panelCategorias.setLayout(new GridLayout(0, 1, 0, 0));
		}
		return panelCategorias;
	}
	private JPanel getPanelFiltros() {
		if (panelFiltros == null) {
			panelFiltros = new JPanel();
			panelFiltros.setLayout(new GridLayout(0, 1, 0, 0));
			panelFiltros.add(getLbPuntosMaximos());
			panelFiltros.add(getSpinnerPuntosMaximos());
			panelFiltros.add(getLbPuntosMinimos());
			panelFiltros.add(getSpinnerPuntosMinimos());
		}
		return panelFiltros;
	}
	class ProcesaCategorias implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			categoriaSeleccionada=(((JButton)e.getSource()).getActionCommand());
			filtrarPremios();
		}
		
	}
	private JPanel getPanelPremiosEscogidos() {
		if (panelPremiosEscogidos == null) {
			panelPremiosEscogidos = new JPanel();
			panelPremiosEscogidos.setLayout(new BorderLayout(0, 0));
			panelPremiosEscogidos.add(getLbPremiosEscogidos(), BorderLayout.NORTH);
			panelPremiosEscogidos.add(getPanelSurPremiosEscogidos(), BorderLayout.SOUTH);
			panelPremiosEscogidos.add(getScrollpaneCentralPremiosEscogidos(), BorderLayout.CENTER);
		}
		return panelPremiosEscogidos;
	}
	private JLabel getLbPremiosEscogidos() {
		if (lbPremiosEscogidos == null) {
			lbPremiosEscogidos = new JLabel();
			lbPremiosEscogidos.setHorizontalAlignment(SwingConstants.CENTER);
			lbPremiosEscogidos.setFont(new Font("Arial", Font.BOLD, 18));
		}
		return lbPremiosEscogidos;
	}
	private JPanel getPanelSurPremiosEscogidos() {
		if (panelSurPremiosEscogidos == null) {
			panelSurPremiosEscogidos = new JPanel();
			panelSurPremiosEscogidos.setLayout(new BorderLayout(0, 0));
			panelSurPremiosEscogidos.add(getPanelDNI());
			panelSurPremiosEscogidos.add(getPanelBtsPremioEscogido(), BorderLayout.EAST);
		}
		return panelSurPremiosEscogidos;
	}
	private JPanel getPanelDNI() {
		if (panelDNI == null) {
			panelDNI = new JPanel();
			panelDNI.setBackground(new Color(240, 240, 240));
			panelDNI.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			panelDNI.add(getLbDNI());
			panelDNI.add(getTextFieldDNI());
		}
		return panelDNI;
	}
	private JLabel getLbDNI() {
		if (lbDNI == null) {
			lbDNI = new JLabel();
			lbDNI.setFont(new Font("Arial", Font.BOLD, 16));
		}
		return lbDNI;
	}
	private JTextField getTextFieldDNI() {
		if (textFieldDNI == null) {
			textFieldDNI = new JTextField();
			textFieldDNI.setFont(new Font("Arial", Font.BOLD, 16));
			textFieldDNI.setColumns(10);
		}
		return textFieldDNI;
	}
	private JButton getBtValidarDni() {
		if (btValidarDni == null) {
			btValidarDni = new JButton();
			btValidarDni.setBackground(Color.LIGHT_GRAY);
			btValidarDni.setFont(new Font("Arial", Font.PLAIN, 14));
			btValidarDni.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					validarDni();
				}

				
			});
		}
		return btValidarDni;
	}
	private void validarDni() {
		String dni=getTextFieldDNI().getText();
		if(juego.getJuego().getJugador().setDni(dni)) {
			int respuesta=JOptionPane.showOptionDialog(this, textos.getString("premioEnCaja"), textos.getString("premioDisponible"), JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{textos.getString("aceptar")}, dni);
			if(respuesta==JOptionPane.OK_OPTION ) {
				juego.guardarPremios();
				reiniciar();
			}else if(respuesta==JOptionPane.CLOSED_OPTION) {
				
			}
		}else {
			int respuesta=JOptionPane.showOptionDialog(this, textos.getString("mensajeDniNoValido"), textos.getString("dniNoValido"), JOptionPane.OK_OPTION, JOptionPane.WARNING_MESSAGE, null, new String[]{textos.getString("reintentar")}, dni);
			if(respuesta==JOptionPane.OK_OPTION) {
				getTextFieldDNI().setText("");
			}else if(respuesta==JOptionPane.CLOSED_OPTION) {
				reiniciar();
			}
		}
		
	}

	private void reiniciar() {
		juego.reiniciar();
		mostrarPanelRegistro();
	}
	private JScrollPane getScrollpaneCentralPremiosEscogidos() {
		if (scrollpaneCentralPremiosEscogidos == null) {
			scrollpaneCentralPremiosEscogidos = new JScrollPane();
			scrollpaneCentralPremiosEscogidos.getHorizontalScrollBar().setUI(new BasicScrollBarUI());
			scrollpaneCentralPremiosEscogidos.getVerticalScrollBar().setUI(new BasicScrollBarUI());
			scrollpaneCentralPremiosEscogidos.setViewportView(getPanelCentralPremiosEscogidos());
		}
		return scrollpaneCentralPremiosEscogidos;
	}
	private JPanel getPanelCentralPremiosEscogidos() {
		if (panelCentralPremiosEscogidos == null) {
			panelCentralPremiosEscogidos = new JPanel();
			panelCentralPremiosEscogidos.setLayout(new GridLayout(0, 1, 10, 10));
		}
		return panelCentralPremiosEscogidos;
	}
	private JLabel getLbPuntosMaximos() {
		if (lbPuntosMaximos == null) {
			lbPuntosMaximos = new JLabel();
			lbPuntosMaximos.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPuntosMaximos.setLabelFor(getSpinnerPuntosMaximos());
		}
		return lbPuntosMaximos;
	}
	protected JSpinner getSpinnerPuntosMaximos() {
		if (spinnerPuntosMaximos == null) {
			spinnerPuntosMaximos = new JSpinner();
			spinnerPuntosMaximos.setFont(new Font("Arial", Font.PLAIN, 14));
			
			spinnerPuntosMaximos.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					filtrarPremios();
				}
			});
			
			
		}
		return spinnerPuntosMaximos;
	}
	

	private JLabel getLbPuntosMinimos() {
		if (lbPuntosMinimos == null) {
			lbPuntosMinimos = new JLabel();
			lbPuntosMinimos.setFont(new Font("Arial", Font.PLAIN, 14));
			lbPuntosMinimos.setLabelFor(getSpinnerPuntosMinimos());
			
		}
		return lbPuntosMinimos;
	}
	private JSpinner getSpinnerPuntosMinimos() {
		if (spinnerPuntosMinimos == null) {
			spinnerPuntosMinimos = new JSpinner();
			spinnerPuntosMinimos.setFont(new Font("Arial", Font.PLAIN, 14));
			spinnerPuntosMinimos.setModel(new SpinnerNumberModel(0.0, 0.0, null,1.0));
			spinnerPuntosMinimos.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					filtrarPremios();
				}
			});
			
		}
		return spinnerPuntosMinimos;
	}
	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnJuego());
			menuBar.add(getMnAyuda());
		}
		return menuBar;
	}
	private JMenu getMnJuego() {
		if (mnJuego == null) {
			mnJuego = new JMenu();
			mnJuego.add(getMntmNuevo());
		}
		return mnJuego;
	}
	private JMenu getMnAyuda() {
		if (mnAyuda == null) {
			mnAyuda = new JMenu();
			mnAyuda.add(getMntmComoJugar());
			mnAyuda.add(getSeparator());
			mnAyuda.add(getMntmAcercaDe());
		}
		return mnAyuda;
	}
	private JMenuItem getMntmComoJugar() {
		if (mntmComoJugar == null) {
			mntmComoJugar = new JMenuItem();
			mntmComoJugar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		}
		return mntmComoJugar;
	}
	private JMenuItem getMntmAcercaDe() {
		if (mntmAcercaDe == null) {
			mntmAcercaDe = new JMenuItem();
			mntmAcercaDe.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarAcercaDe();
				}

				
			});
		}
		return mntmAcercaDe;
	}
	private void mostrarAcercaDe() {
		
		JOptionPane.showOptionDialog(this, "Miguel Méndez Murias\nPL-1 CPM 2022/23", textos.getString("menu.acercaDe"), JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[]{textos.getString("aceptar")}, null);
	}
	private JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
		}
		return separator;
	}
	private JMenuItem getMntmNuevo() {
		if (mntmNuevo == null) {
			mntmNuevo = new JMenuItem();
			mntmNuevo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int respuesta=mostrarAdvertenciaNuevoJuego();
					if(respuesta==JOptionPane.OK_OPTION) {
						reiniciar();
					}
				}
			});
		}
		return mntmNuevo;
	}
	private JPanel getPanelBtsPremioEscogido() {
		if (panelBtsPremioEscogido == null) {
			panelBtsPremioEscogido = new JPanel();
			panelBtsPremioEscogido.add(getBtAnteriorPremiosEscogidos());
			panelBtsPremioEscogido.add(getBtValidarDni());
		}
		return panelBtsPremioEscogido;
	}
	private JButton getBtAnteriorPremiosEscogidos() {
		if (btAnteriorPremiosEscogidos == null) {
			btAnteriorPremiosEscogidos = new JButton();
			btAnteriorPremiosEscogidos.setBackground(Color.LIGHT_GRAY);
			btAnteriorPremiosEscogidos.setFont(new Font("Arial", Font.PLAIN, 14));
			btAnteriorPremiosEscogidos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarPanelPremios();
				}
			});
		}
		return btAnteriorPremiosEscogidos;
	}
	
	private ImageIcon adaptarImagen(URL url) {
		ImageIcon imagen=new ImageIcon(url);
		Image imagenOriginal=imagen.getImage();
		Image imgEscalada = imagenOriginal.getScaledInstance((int) (80), (int) (80),Image.SCALE_FAST);
		return new ImageIcon(imgEscalada);
	}
	private void cargaAyuda(){

		   URL hsURL;
		   HelpSet hs;

		    try {
			    	File fichero = new File("help/Ayuda.hs");
			    	hsURL = fichero.toURI().toURL();
			        hs = new HelpSet(null, hsURL);
			      }

		    catch (Exception e){
		      System.out.println("Ayuda no encontrada");
		      return;
		   }

		   HelpBroker hb = hs.createHelpBroker();
		   hb.initPresentation();

		   hb.enableHelpKey(getRootPane(),"introduccion", hs); //Habilita la tecla F1 como tecla de ayuda
		   hb.enableHelpOnButton(getBtAyudaJuego(), "introduccion", hs); 
		   hb.enableHelpOnButton(getMntmComoJugar(), "introduccion", hs); 
		   hb.enableHelpOnButton(getBtComoJugarInicio(), "introduccion", hs); 
		   hb.enableHelp(getPanelPremios(), "premio", hs);
		   hb.enableHelp(getPanelRegistro(), "registro", hs);
	}
}
