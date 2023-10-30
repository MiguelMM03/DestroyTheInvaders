package uo.cpm.destroyTheInvaders.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import uo.cpm.destroyTheInvaders.model.Premio;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ResourceBundle;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DefaultEditor;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.SpringLayout;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.SpinnerNumberModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Cursor;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PanelPremioIndividual extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelSur;
	private JPanel panelNorte;
	private JPanel panelCentro;
	private JLabel lbNombre;
	private JButton btAyuda;
	private JTextField tfPuntos;
	private JLabel lbImagen;
	private VentanaPrincipal vp;
	private Premio premio;
	private ResourceBundle textos;
	private JSpinner spinnerUnidades;
	private JLabel lbUnidades;
	
	public PanelPremioIndividual(VentanaPrincipal vp, Premio premio,ResourceBundle textos) {
		setBackground(new Color(255, 255, 255));
		this.vp=vp;
		this.premio=premio;
		this.textos=textos;
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setLayout(new BorderLayout(0, 0));
		add(getPanelSur(), BorderLayout.SOUTH);
		add(getPanelNorte(), BorderLayout.NORTH);
		add(getPanelCentro(), BorderLayout.CENTER);
	}

	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setLayout(new GridLayout(1, 0, 0, 0));
			panelSur.add(getLbUnidades());
			panelSur.add(getSpinnerUnidades());
		}
		return panelSur;
	}
	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new BorderLayout(0, 0));
			panelNorte.add(getLbNombre(), BorderLayout.CENTER);
			panelNorte.add(getBtAyuda(), BorderLayout.EAST);
		}
		return panelNorte;
	}
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setBackground(new Color(255, 255, 255));
			panelCentro.setLayout(new BorderLayout(0, 0));
			panelCentro.add(getTfPuntos(), BorderLayout.SOUTH);
			panelCentro.add(getLbImagen(), BorderLayout.CENTER);
		}
		return panelCentro;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel();
			lbNombre.setFont(new Font("Arial", Font.BOLD, 14));
			lbNombre.setText(premio.getDenominacion());
		}
		return lbNombre;
	}
	private JButton getBtAyuda() {
		if (btAyuda == null) {
			btAyuda = new JButton();
			btAyuda.setBackground(Color.lightGray);
			btAyuda.setFont(new Font("Arial", Font.PLAIN, 12));
			btAyuda.setActionCommand(premio.getCodigo());
			btAyuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					mostrarDescripcionPremio(((JButton)e.getSource()).getActionCommand());
				}
			});
			btAyuda.setHorizontalAlignment(SwingConstants.LEADING);
			btAyuda.setText("?");
			btAyuda.setToolTipText(textos.getString("tooltip.descripcionPremio"));
			btAyuda.setIcon(null);
		}
		return btAyuda;
	}
	private void mostrarDescripcionPremio(String codigo) {
		Premio premio=buscarPremio(codigo);
		if(premio!=null) {
			DescripcionPremio dp=new DescripcionPremio(this, premio, textos);
			dp.setVisible(true);
		}
	}
	private Premio buscarPremio(String codigo) {
		for(Premio p : vp.getJuego().getPremios()) {
			if(p.getCodigo().equals(codigo)) {
				return p;
			}
		}
		return null;
	}

	private JTextField getTfPuntos() {
		if (tfPuntos == null) {
			tfPuntos = new JTextField();
			tfPuntos.setFont(new Font("Arial", Font.PLAIN, 12));
			tfPuntos.setEditable(false);
			tfPuntos.setColumns(10);
			tfPuntos.setText(textos.getString("puntos")+premio.getPuntos());
		}
		return tfPuntos;
	}
	private JLabel getLbImagen() {
		if (lbImagen == null) {
			lbImagen = new JLabel();
			lbImagen.setHorizontalAlignment(SwingConstants.CENTER);
			lbImagen.setBackground(new Color(255, 255, 255));
			adaptarImagenLabel(new ImageIcon(PanelPremioIndividual.class.getResource("/img/"+premio.getCodigo()+".PNG")));
		}
		return lbImagen;
	}
	private void adaptarImagenLabel(ImageIcon imagen){
		  Image imgOriginal = imagen.getImage();
		  Image imgEscalada = imgOriginal.getScaledInstance((int) (90), (int) (90),Image.SCALE_FAST);
		  getLbImagen().setIcon(new ImageIcon(imgEscalada));
		}
	
	private JSpinner getSpinnerUnidades() {
		if (spinnerUnidades == null) {
			spinnerUnidades = new JSpinner();

			spinnerUnidades.setFont(new Font("Arial", Font.PLAIN, 12));
			
			spinnerUnidades.setToolTipText(textos.getString("tooltip.spinnerPremio"));
			spinnerUnidades.setModel(new SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
			((DefaultEditor) spinnerUnidades.getEditor()).getTextField().setEditable(false);
			spinnerUnidades.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent evt) {
					((JSpinner)evt.getSource()).setValue(vp.getJuego().getJuego().getJugador().getUnidadesPremio(premio));
					vp.actualizarPuntosPanelPremios();
				}
			});
			spinnerUnidades.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					procesarCambioSpinnerUnidades();
				}
			});
		}
		return spinnerUnidades;
	}
	private void procesarCambioSpinnerUnidades() {
		int unidades=vp.getJuego().getJuego().getJugador().getUnidadesPremio(premio);
		if(vp.getJuego().getJuego().getJugador().getPuntosRestantes()>=premio.getPuntos() && ((Integer) getSpinnerUnidades().getValue()).intValue()>unidades) {
			vp.getJuego().getJuego().getJugador().setUnidadesPremio(premio,((Integer) (getSpinnerUnidades().getValue())).intValue());
			vp.actualizarPuntosPanelPremios();
		}else if((((Integer) (getSpinnerUnidades().getValue())).intValue()<unidades &&((Integer)getSpinnerUnidades().getValue()).intValue()>=0)) {
			vp.getJuego().getJuego().getJugador().setUnidadesPremio(premio,((Integer) (getSpinnerUnidades().getValue())).intValue());
			vp.actualizarPuntosPanelPremios();
		}
		else if(((Integer) (getSpinnerUnidades().getValue())).intValue()==unidades){
			
			
		}else {

			//se hace esto para que no vuelva a llamar al evento stateChanged
			if(((Integer) (getSpinnerUnidades().getValue())).intValue()!=0) {
				getSpinnerUnidades().setValue(((Integer) (getSpinnerUnidades().getPreviousValue())).intValue());
				vp.mostrarMensajePuntosInsuficientes();
			}
		}
	}

	private JLabel getLbUnidades() {
		if (lbUnidades == null) {
			lbUnidades = new JLabel();
			lbUnidades.setFont(new Font("Arial", Font.PLAIN, 12));
			lbUnidades.setText(textos.getString("unidades"));
		}
		return lbUnidades;
	}
}
