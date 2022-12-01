package Docente;

import java.util.Objects;

public class Docente implements Comparable {
	// Atributos:
	private int cedula;
	private String nombre;
	private String profesion;
	private int anioTitulacion;
	private float sueldo;
	private String puesto;
	
	// Constructor:
	public Docente(int cedula, String nombre, String profesion, int anioTitulacion, float sueldo, String puesto) {
		this.cedula         = cedula;
		this.nombre         = nombre;
		this.profesion      = profesion;
		this.anioTitulacion = anioTitulacion;
		this.sueldo         = sueldo;
		this.puesto         = puesto;
	}
	
	// Metodos getter y setter
	public int getCedula() {
		return cedula;
	}
	
	public void setCedula(int cedula) {
		this.cedula = cedula;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getProfesion() {
		return profesion;
	}
	
	public void setProfesion(String profesion) {
		this.profesion = profesion;
	}
	
	public int getAnioTitulacion() {
		return anioTitulacion;
	}
	
	public void setAnioTitulacion(int anioTitulacion) {
		this.anioTitulacion = anioTitulacion;
	}
	
	public float getSueldo() {
		return sueldo;
	}
	
	public void setSueldo(float sueldo) {
		this.sueldo = sueldo;
	}
	
	public String getPuesto() {
		return puesto;
	}
	
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	@Override
	public String toString() {
		return "Cedula: [ "+cedula+" ] - Nombre: [ "+nombre+" ] - Profesion: [ "+profesion+" ] - Año de titulación: [ "+anioTitulacion+" ] - Sueldo: [  "+sueldo+" ] - Puesto: [ "+puesto+" ]";
	}
	
	public int cedulaHash(){
        final int prime= 11;
        long result =0;
        long auxCedula = cedula;
        while(auxCedula!=0){
            result=(result*prime+(auxCedula%10))%150;
            auxCedula = auxCedula/10;
        }
        return (int) result;
    }
	
	public static int hashCode(int cedula) {
		final int prime= 11;
        long resultado =0;
        while(cedula!=0){
            resultado=(resultado*prime+(cedula%10))%150;
            cedula = cedula/10;
        }
        return (int) resultado;
	}

	@Override
	public int compareTo(Object o) {
		Docente m = (Docente) o;
        return this.cedula-m.getCedula();
	}
}
