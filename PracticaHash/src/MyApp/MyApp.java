package MyApp;

import javax.swing.JOptionPane;

import Docente.Docente;
import hash.Hash;

public class MyApp {

	public static void run() {
		runMenu();
	}
	
	// Menú:
	static int menu() {
		int opc = 0;
		String[] datos = {
				"1) Agregar Docentes",
				"2) Buscar Docente",
				"3) Eliminar Docente",
				"4) Listar los Docentes",
				"5) Salir"
		};
		String x = (String)JOptionPane.showInputDialog(null, "Seleccione uno", "Menu", 
				JOptionPane.INFORMATION_MESSAGE, null,datos, datos[0]);
		opc = Integer.parseInt(x.charAt(0)+"");
		return opc;
	}
	
	static void runMenu() {
		boolean salir = false;
		
		while(!salir) {
			Hash hash = new Hash();
			int buscar;
			switch(menu()) {
			case 1:
				int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa tu cedula"));
				String nombre = JOptionPane.showInputDialog(null, "Ingresa tu Nombre");
				String profesion = JOptionPane.showInputDialog(null, "Ingresa tu profesion");
				int anioTitulacion = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa tu anio de Titulacion"));;
				float sueldo = Float.parseFloat(JOptionPane.showInputDialog(null, "Ingresa tu sueldo"));;
				String puesto = JOptionPane.showInputDialog(null, "Ingresa tu puesto");; 
				
				hash.inicializar();
				// Agregar docentes de forma manual:
				Docente docente = new Docente(cedula, nombre, profesion, anioTitulacion, sueldo, puesto);
				hash.agregaDocente(docente);
				break;
				
			case 2: 
				buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la cedula del docente a bsucar")); 
				Docente buscado = Hash.buscaDocente(buscar);
				if(buscado != null) {
					System.out.println(buscado.toString());
				}
				else {
					System.out.println("El docente no fue encontrado");
				}
				
				break;
				
			case 3: 
				buscar = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingresa la cedula del docente a eliminar")); 
				Docente eliminar = Hash.buscaDocente(buscar);
				if(eliminar != null) {
					hash.eliminarDocente(eliminar);
					System.out.println("El docente fue eliminado con Exito");
				}
				else {
					System.out.println("El docente no existe, NO SE PUEDE ELIMINAR");	
				}
				
				break;
				
			case 4: hash.imprimeTabla(); break;	
			case 5: salir = true;
			}
		}
	}
	
	public static void main(String[] args) {
		run();
	}

}
