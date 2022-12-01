package hash;


import Docente.Docente;
import ed.ito.ListaDinamica;

public class Hash {
	static ListaDinamica<Docente>[] hashTable;
	static final int LIMITE = 150;

	public void inicializar() {
	    hashTable = new ListaDinamica[LIMITE];
	    for(int i=0; i<LIMITE; i++)
	        hashTable[i] = new ListaDinamica<Docente>();
	}
	
	public void agregaDocente(Docente m) {
        try {

            hashTable[m.cedulaHash()].add(m);

        } catch (Exception e) {

        }
    }	

	public void eliminarDocente(Docente m) {
        try {
            hashTable[m.cedulaHash()].delete(m);
        } catch (Exception e) {

        }
    }

    public static Docente buscaDocente(int cedula) {
        Docente m = null;
        int i = 0;
        ListaDinamica<Docente> lista = hashTable[Docente.hashCode(cedula)];
        try {
            for (i = 0; i < lista.size(); i++) {
                if (lista.getItem(i).getCedula() == cedula) {
                    m = lista.getItem(i);
                    break;
                }
            }
        } catch (Exception e) {

        }
        return m;
    }

    public void imprimeTabla() {
        try {
            for (int i = 0; i < LIMITE; i++) {
                ListaDinamica<Docente> l = hashTable[i];
                for (int j = 0; j < l.size(); j++) {
                    System.out.println(l.getItem(j));
                }
            }
        } catch (Exception e) {

        }
    }
}