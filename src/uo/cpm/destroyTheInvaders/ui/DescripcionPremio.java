package uo.cpm.destroyTheInvaders.ui;


import javax.swing.JDialog;
import javax.swing.JPanel;

import uo.cpm.destroyTheInvaders.model.Premio;

import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.SwingConstants;

public class DescripcionPremio extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lbImagenPremioPanelDescripcion;
	private JPanel panelDescripcion;
	private JLabel lbNombrePremio;
	private JTextPane textPaneDescripcion;
	private PanelPremioIndividual ppi;
	private Premio premio;
	private ResourceBundle textos;

	public DescripcionPremio(PanelPremioIndividual ppi, Premio premio, ResourceBundle textos) {
		setResizable(false);
		this.ppi=ppi;
		this.premio=premio;
		this.textos=textos;
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 623, 368);
		contentPane = new JPanel();
		setModal(false);
		setTitle(textos.getString("descripcionPremio"));
		setContentPane(contentPane);
		setLocationRelativeTo(ppi);
		contentPane.setLayout(new GridLayout(0, 2, 10, 10));
		contentPane.add(getLbImagenPremioPanelDescripcion());
		contentPane.add(getPanelDescripcion());
	}

	private JLabel getLbImagenPremioPanelDescripcion() {
		if (lbImagenPremioPanelDescripcion == null) {
			lbImagenPremioPanelDescripcion = new JLabel();
			lbImagenPremioPanelDescripcion.setBackground(new Color(255, 255, 255));
			lbImagenPremioPanelDescripcion.setHorizontalAlignment(SwingConstants.CENTER);
			lbImagenPremioPanelDescripcion.setIcon(adaptarImagen(DescripcionPremio.class.getResource("/img/"+premio.getCodigo()+".PNG")));
		}
		return lbImagenPremioPanelDescripcion;
	}
	private JPanel getPanelDescripcion() {
		if (panelDescripcion == null) {
			panelDescripcion = new JPanel();
			panelDescripcion.setLayout(new BorderLayout(10, 10));
			panelDescripcion.add(getLbNombrePremio(), BorderLayout.NORTH);
			panelDescripcion.add(getTextPaneDescripcion(), BorderLayout.CENTER);
		}
		return panelDescripcion;
	}
	private JLabel getLbNombrePremio() {
		if (lbNombrePremio == null) {
			lbNombrePremio = new JLabel();
			lbNombrePremio.setHorizontalAlignment(SwingConstants.CENTER);
			lbNombrePremio.setBorder(new LineBorder(new Color(0, 0, 0), 2));
			lbNombrePremio.setText(premio.getDenominacion());
		}
		return lbNombrePremio;
	}
	private JTextPane getTextPaneDescripcion() {
		if (textPaneDescripcion == null) {
			textPaneDescripcion = new JTextPane();
			textPaneDescripcion.setBorder(new LineBorder(new Color(0, 0, 0)));
			textPaneDescripcion.setEditable(false);
			textPaneDescripcion.setText(premio.getDescripcion());
		}
		return textPaneDescripcion;
	}
	private ImageIcon adaptarImagen(URL url) {
		ImageIcon imagen=new ImageIcon(url);
		Image imagenOriginal=imagen.getImage();
		Image imgEscalada = imagenOriginal.getScaledInstance((int) (250), (int) (250),Image.SCALE_FAST);
		return new ImageIcon(imgEscalada);
	}
}
