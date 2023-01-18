package cifrado;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agenda extends Contacto {

	public int numContactos; //
	public ArrayList<Contacto> contactos;

	public Agenda() {

		this.contactos = new ArrayList<>();
	}

	public void addContact() {

		String nombre, apellidos, direccion, telefono;
		Scanner entrada = new Scanner(System.in);
//		System.out.println("Introduce un contacto: ");
		System.out.print("Introduce nombre: ");
		nombre = entrada.nextLine();
		System.out.print("Introduce Apellidos: ");
		apellidos = entrada.nextLine();
		System.out.print("Introduce Direccion: ");
		direccion = entrada.nextLine();
		System.out.print("Introduce Telefono: ");
		telefono = entrada.nextLine();
		this.contactos.add(new Contacto(nombre, apellidos, direccion, telefono));
		this.numContactos = this.numContactos + 1;
	}

	public void saveContact(String ruta, Contacto aux) {

		try {
			FileWriter fichero = new FileWriter(ruta, true); // true es modo append
			BufferedWriter bw = new BufferedWriter(fichero);
			bw.write("ID: " + aux.idContacto + "\n");
			bw.write("Nombre: " + aux.nombre + "\n");
			bw.write("Apellidos: " + aux.getApellidos() + "\n");
			bw.write("Direccion: " + aux.getDireccion() + "\n");
			bw.write("Telefono: " + aux.getTelefono() + "\n");
			bw.close();
			fichero.close();

			bw.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void saveAgenda(String ruta) {

		try {
			FileWriter fichero = new FileWriter(ruta, true); // true es modo append
			BufferedWriter bw = new BufferedWriter(fichero);

			for (int i = 0; i < this.contactos.size(); i++) {
				bw.write("Nombre: " + this.contactos.get(i).idContacto + "\n");
				bw.write("Apellidos: " + this.contactos.get(i).getApellidos() + "\n");
				bw.write("Direccion: " + this.contactos.get(i).getDireccion() + "\n");
				bw.write("Telefono: " + this.contactos.get(i).getTelefono() + "\n");
			}

			bw.close();
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public Agenda(String nombre, String apellidos, String direccion, String telefono) {
		super(nombre, apellidos, direccion, telefono);
		// TODO Auto-generated constructor stub
	}

}
