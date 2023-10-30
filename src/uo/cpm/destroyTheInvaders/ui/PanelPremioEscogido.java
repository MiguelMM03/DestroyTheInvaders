package uo.cpm.destroyTheInvaders.ui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.Image;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JLabel;
import javax.swing.JTextField;

import uo.cpm.destroyTheInvaders.model.Premio;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import java.awt.Font;

public class PanelPremioEscogido extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbFotoPremio;
	private JPanel panelDerecho;
	private JTextField textFieldNombre;
	private JTextField textFieldUnidades;
	private VentanaPrincipal vp;
	private Premio premio;
	private ResourceBundle textos;

	/**
	 * Create the panel.
	 */
	public PanelPremioEscogido(Premio p, VentanaPrincipal vp, ResourceBundle textos) {
		setAlignmentX(Component.LEFT_ALIGNMENT);
		setBorder(new LineBorder(new Color(0, 0, 0), 2));
		this.premio=p;
		this.vp=vp;
		this.textos=textos;
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{223, 223, 0, 0};
		gridBagLayout.rowHeights = new int[]{296, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		GridBagConstraints gbc_lbFotoPremio = new GridBagConstraints();
		gbc_lbFotoPremio.gridwidth = 2;
		gbc_lbFotoPremio.fill = GridBagConstraints.VERTICAL;
		gbc_lbFotoPremio.insets = new Insets(0, 0, 0, 5);
		gbc_lbFotoPremio.gridx = 0;
		gbc_lbFotoPremio.gridy = 0;
		add(getLbFotoPremio(), gbc_lbFotoPremio);
		GridBagConstraints gbc_panelDerecho = new GridBagConstraints();
		gbc_panelDerecho.gridwidth = 2;
		gbc_panelDerecho.fill = GridBagConstraints.BOTH;
		gbc_panelDerecho.gridx = 2;
		gbc_panelDerecho.gridy = 0;
		add(getPanelDerecho(), gbc_panelDerecho);

	}

	private JLabel getLbFotoPremio() {
		if (lbFotoPremio == null) {
			lbFotoPremio = new JLabel();
			lbFotoPremio.setHorizontalAlignment(SwingConstants.CENTER);
			lbFotoPremio.setIcon(adaptarImagen(PanelPremioEscogido.class.getResource("/img/"+premio.getCodigo()+".PNG")));
			
		}
		return lbFotoPremio;
	}
	private JPanel getPanelDerecho() {
		if (panelDerecho == null) {
			panelDerecho = new JPanel();
			panelDerecho.setLayout(new GridLayout(0, 1, 0, 0));
			panelDerecho.add(getTextFieldNombre());
			panelDerecho.add(getTextFieldUnidades());
		}
		return panelDerecho;
	}
	private JTextField getTextFieldNombre() {
		if (textFieldNombre == null) {
			textFieldNombre = new JTextField();
			textFieldNombre.setFont(new Font("Arial", Font.BOLD, 16));
			textFieldNombre.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNombre.setEditable(false);
			textFieldNombre.setColumns(10);
			textFieldNombre.setText(premio.getDenominacion());
		}
		return textFieldNombre;
	}
	private JTextField getTextFieldUnidades() {
		if (textFieldUnidades == null) {
			textFieldUnidades = new JTextField();
			textFieldUnidades.setFont(new Font("Arial", Font.BOLD, 16));
			textFieldUnidades.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldUnidades.setEditable(false);
			textFieldUnidades.setColumns(10);
			textFieldUnidades.setText(textos.getString("unidades")+premio.getUnidades());
		}
		return textFieldUnidades;
	}
	
	private ImageIcon adaptarImagen(URL url) {
		ImageIcon imagen=new ImageIcon(url);
		Image imagenOriginal=imagen.getImage();
		Image imgEscalada = imagenOriginal.getScaledInstance((int) (300), (int) (300),Image.SCALE_FAST);
		return new ImageIcon(imgEscalada);
	}
}
