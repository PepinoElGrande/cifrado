package cifrado;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class Main {

	public static void main(String[] args) {
		
		
		/*
	ArrayList<Contacto> agenda = new ArrayList<>();
	
	
	String nombre, apellidos, direccion, telefono;
	Scanner entrada = new Scanner(System.in);
	System.out.println("Introduce un contacto: ");
	System.out.print("Introduce nombre: ");
	nombre = entrada.nextLine();
	System.out.print("Introduce Apellidos: ");
	apellidos = entrada.nextLine();
	System.out.print("Introduce Direccion: ");
	direccion = entrada.nextLine();
	System.out.print("Introduce Telefono: ");
	telefono = entrada.nextLine();
	
	Contacto aux = new Contacto(nombre, apellidos, direccion, telefono);
	
	agenda.add(aux);
	agenda.get(0).mostrarContacto();
	
	String ruta = ""; 
	String fichero = "agenda.txt";
	ruta = ruta + "\\" + fichero;
	agenda.get(0).guardarContacto(ruta);
	
	*/
		
				
		
//		String ruta = "RUTA A LA CARPETA"; 
//		String fichero = "agenda.txt";
//		ruta = ruta + "\\" + fichero;
		File agendaruta =new File ("agenda.txt");

		String Agendaruta=agendaruta.getAbsolutePath();
		String ruta = ""+Agendaruta;
	Agenda agenda = new Agenda();
	
	agenda.addContact();
	String llave4 = "z;Y5q-K1d|O7h:C2u>X3f%W9e@N4i`P6";
	String llave1 = ")9Di!6Kf,7Jc#4Ix'0Mp@5Yd;3Nv+2Vz";
	String llave2 = "Lr:8No@2Aq.9Ih*5Yj'7Ow)1Ca,0Bf;4";
	String llave3 = "o-6Zy@2Wi:9Dd#0Pz=7Tc)4Gv!1Jx?3N";
	
	String llave5 = llave1 + llave2+ llave3 + llave4;
	
encriptadorAES encriptarObj = new encriptadorAES();
	
	String datos = "";
	String linea;
	for(int i =0 ; i < agenda.contactos.size(); i++) {
		linea = agenda.contactos.get(i).nombre +
				";" + agenda.contactos.get(i).getApellidos() +
				";" + agenda.contactos.get(i).getDireccion() +
				";" + agenda.contactos.get(i).getTelefono() + "\n";	
		
		//cifrado = encriptar.encriptar(line	a, llave5); // cifra linea por linea
		datos = datos + linea; // cifra el fichero entero, se guarda linea por linea
	}
	 

		String cifrado;
		try {
			cifrado = encriptarObj.encriptar(datos, llave5);
			
			System.out.println("Cifrado: " + cifrado);
			
			String descifrado = encriptarObj.desencriptar(cifrado, llave5);
			System.out.println("DesCifrado: " + descifrado);
		} catch (InvalidKeyException | UnsupportedEncodingException | NoSuchAlgorithmException | NoSuchPaddingException
				| IllegalBlockSizeException | BadPaddingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	//agenda.contactos.get(0).cifrarAESApellidos(llave1);
	//agenda.contactos.get(0).cifrarAESDireccion(llave2);
	//agenda.contactos.get(0).cifrarAESTelefono(llave3);
	agenda.saveContact(ruta, agenda.contactos.get(agenda.numContactos-1));
	//agenda.contactos.get(0).descifrarContacto();
	//agenda.saveContact(ruta, agenda.contactos.get(agenda.numContactos-1));
}
}
