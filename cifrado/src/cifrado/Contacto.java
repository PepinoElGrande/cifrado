package cifrado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

//import encriptadoAES.EncriptadorAES;

public class Contacto {

	public int idContacto;
	public String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;

	public String getApellidos() {
		return apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getTelefono() {
		return telefono;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;

	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	
	public void mostrarContacto() {
		System.out.println("Nombre: " + this.nombre);
		System.out.println("Apellidos: " + this.apellidos);
		System.out.println("Direccion: " + this.direccion);
		System.out.println("Telefono: " + this.telefono);
	}

	public void guardarContacto(String ruta) {
		try {
			FileWriter fichero = new FileWriter(ruta, true); // true es modo append
			BufferedWriter bw = new BufferedWriter(fichero);

			bw.write("Nombre: " + this.nombre + "\n");
			bw.write("Apellidos: " + this.apellidos + "\n");
			bw.write("Direccion: " + this.direccion + "\n");
			bw.write("Telefono: " + this.telefono + "\n");
			bw.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public Contacto() {

	}

	public Contacto(String nombre, String apellidos, String direccion, String telefono) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
	}

	public void cifrarContacto() { // cifrado 
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		String apellido = getApellidos().toUpperCase();
		String direccion = getDireccion().toUpperCase();
		String apellidoCodif = "";
		String direccionCodif = "";
		char aux;
		for (int i = 0; i < apellido.length(); i++) {
			aux = apellido.charAt(i);
			int pos = letras.indexOf(aux);
			if (pos == -1) {
				apellidoCodif = apellidoCodif + aux;
			}else {
				apellidoCodif = apellidoCodif + letras.charAt((pos + 3)%letras.length());
			}
		}
		
		for (int i = 0; i < direccion.length(); i++) {
			aux = direccion.charAt(i);
			int pos = letras.indexOf(aux);
			if (pos == -1) {
				direccionCodif = direccionCodif + aux;
			}else {
				direccionCodif = direccionCodif + letras.charAt((pos + 3)%letras.length());
			}
		}
		
		setApellidos(apellidoCodif);
		setDireccion(direccionCodif);
	}

	public void descifrarContacto() {
		
		String letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
		String apellido = getApellidos().toUpperCase();
		String direccion = getDireccion().toUpperCase();
		String apellidoDecodif = "";
		String direccionDeCodif = "";
		char aux;
		for (int i = 0; i < apellido.length(); i++) {
			aux = apellido.charAt(i);
			int pos = letras.indexOf(aux);
			if (pos == -1) {
				apellidoDecodif = apellidoDecodif + aux;
			}else {
				if(pos -3 < 0) {
					apellidoDecodif = apellidoDecodif + letras.charAt(letras.length() + (pos - 3));
				}else {
					apellidoDecodif = apellidoDecodif + letras.charAt((pos - 3)%letras.length());	
				}
				
			}
		}
		
		for (int i = 0; i < direccion.length(); i++) {
			aux = direccion.charAt(i);
			int pos = letras.indexOf(aux);
			if (pos == -1) {
				direccionDeCodif = direccionDeCodif + aux;
			}else {
				if(pos -3 < 0) {
					direccionDeCodif = direccionDeCodif + letras.charAt(letras.length() + (pos - 3));
				}else {
					direccionDeCodif = direccionDeCodif + letras.charAt((pos - 3)%letras.length());	
				}
				
			}
		}
		
		setApellidos(apellidoDecodif);
		setDireccion(direccionDeCodif);

	}
	
	
	public void cifrarAES() {
		
		try {
			final String claveEncriptacion = "Nz\"0En@7Rb'4Jk*1Vr-3Zx=8Xu)5Qe+9";
			String apellidos = getApellidos();
			String direccion = getDireccion();
			String telefono = getTelefono();

			encriptadorAES encriptador = new encriptadorAES();

			String encriptadoApellidos = encriptador.encriptar(apellidos, claveEncriptacion);
			String encriptadoDireccion = encriptador.encriptar(direccion, claveEncriptacion);
			String encriptadoTelefono = encriptador.encriptar(telefono, claveEncriptacion);
			
			setApellidos(encriptadoApellidos);
			setDireccion(encriptadoDireccion);
			setTelefono(encriptadoTelefono);
			
			} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException ex) {
			Logger.getLogger(encriptadorAES.class.getName()).log(Level.SEVERE, null, ex);
		}

		
		
	}
	
	
public void cifrarAESApellidos(String claveEncriptacion) {
		
		try {
			//final String claveEncriptacion = "Nz\"0En@7Rb'4Jk*1Vr-3Zx=8Xu)5Qe+9";
			String apellidos = getApellidos();
			

			encriptadorAES encriptador = new encriptadorAES();

			String encriptadoApellidos = encriptador.encriptar(apellidos, claveEncriptacion);
			
			
			setApellidos(encriptadoApellidos);
		
			
			} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException ex) {
			Logger.getLogger(encriptadorAES.class.getName()).log(Level.SEVERE, null, ex);
		}

		
		
	}
	
	public void descifrarAESApellidos(String claveEncriptacion) {
		
		try {
			//final String claveEncriptacion = "Nz\"0En@7Rb'4Jk*1Vr-3Zx=8Xu)5Qe+9";
			String apellidos = getApellidos();

			encriptadorAES encriptador = new encriptadorAES();

			
			String desencriptado = encriptador.desencriptar(apellidos, claveEncriptacion);

			setApellidos(desencriptado);

		} catch (UnsupportedEncodingException | NoSuchAlgorithmException | InvalidKeyException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException ex) {
			Logger.getLogger(encriptadorAES.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	



}

