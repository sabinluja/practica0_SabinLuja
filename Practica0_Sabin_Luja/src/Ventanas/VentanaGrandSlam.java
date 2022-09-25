package Ventanas;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class VentanaGrandSlam extends JFrame {
	
	VentanaResultados resultadosGeneral;
	VentanaTorneos torneosGeneral;
	VentanaTenistas tenistasGeneral;
	JTabbedPane pestañas;
	JButton botonEvolucion = new JButton("Evolucion Ranking");
	JPanel panelSur = new JPanel();
	

	public VentanaGrandSlam () {
		panelSur.add(botonEvolucion);

		this.setLayout(new BorderLayout());
		this.add(panelSur, BorderLayout.SOUTH);
		
		this.setSize(1100, 500);
		this.setTitle("Base De Datos GL");
		this.setLocationRelativeTo(null);
		
		iniciarComponentes();
		
		
		botonEvolucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String inicioString = JOptionPane.showInputDialog("Año inicial para ver evolucion de ranking: ");
				String finalString = JOptionPane.showInputDialog("Año final para ver evolucion de ranking:");
				
				int numeroInicio = Integer.parseInt(inicioString);
				int numeroFinal = Integer.parseInt(finalString);
				
				
				
				
				//Comento la siguiente linea debido a que no ejecuta el codigo
				
				//VentanaEvolucion ve = new VentanaEvolucion(numeroInicio, numeroFinal, 19);
				
			}
		});
	}

	private void iniciarComponentes() {
		
		pestañas = new JTabbedPane();
		resultadosGeneral = new VentanaResultados();
		torneosGeneral = new VentanaTorneos();
		tenistasGeneral = new VentanaTenistas();
		
		pestañas.add("Resultados", VentanaResultados.panelResultados);
		pestañas.add("Tenistas", VentanaTenistas.panelTenistas);
		pestañas.add("Torneos", VentanaTorneos.panelTorneos);
		
		add(pestañas);
		
	}
}
