/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica2;

/**
 *
 * @author Milena
 */
public class Estudiante {
    private String nombre;
    private String apellido;
    private int comision;
    private String mail;
    private String direc;

    public Estudiante(String nombre, String apellido, int comision, String mail, String direc) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.comision = comision;
        this.mail = mail;
        this.direc = direc;
    }
    
    public String tusDatos() {
		String datos = "";
		
		datos += "Nombre: " + getNombre() + "\n";
		datos += "Apellido: " + getApellido() + "\n";
		datos += "Email: " + getMail() + "\n";
		datos += "Comision: " + getComision() + "\n";
		datos += "Direccion: " + getDirec() + "\n";
		
		return datos;
	}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int comision) {
        this.comision = comision;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getDirec() {
        return direc;
    }

    public void setDirec(String direc) {
        this.direc = direc;
    }
    
    
}
