package uo.cpm.destroyTheInvaders;

import java.awt.Color;
import java.awt.EventQueue;


import javax.swing.UIManager;
import javax.swing.plaf.ColorUIResource;

import uo.cpm.destroyTheInvaders.service.DestroyTheInvaders;
import uo.cpm.destroyTheInvaders.ui.VentanaPrincipal;

public class Main {
	public static final int DEBUG=0;
	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					UIManager.put("Button.background", Color.LIGHT_GRAY);
					UIManager.put("Panel.background", Color.white);
					UIManager.put("Label.font","Arial 32");
					UIManager.put("ScrollBar.thumb", new ColorUIResource(Color.lightGray));
					//GraphicsDevice grafica=GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
					DestroyTheInvaders juego=new DestroyTheInvaders();
					VentanaPrincipal frame = new VentanaPrincipal(juego);
					//grafica.setFullScreenWindow(frame);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
