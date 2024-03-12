package Principal;

import java.util.Scanner;

import Controller.LibrosController;
import Controller.PrestamoController;
import Controller.SocioController;

public class Biblioteca {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        String eleccion = "";
        while (!eleccion.equals("9")) {
            System.out.println(
                    "1. Registrar socio\n2. Registrar libro\n3. Registrar prestamo\n4. Ver socios\n5. Ver libros\n6. Ver prestamos\n7. Ver socios no fiables\n8. Cambiar localizacion de libro\n9. Salir\nElige:");
            eleccion = sc.nextLine();
            if (eleccion.equals("1")) {
                SocioController.solicitarDatosParaRegistrar();
            }
            if (eleccion.equals("2")) {
                LibrosController.solicitarDatosParaRegistrar();
            }
            if (eleccion.equals("3")) {
                PrestamoController.solicitarDatosYCrearPrestamo();
            }
            if (eleccion.equals("4")) {
                SocioController.imprimirSocios(SocioController.obtener());
            }
            if (eleccion.equals("5")) {
                LibrosController.imprimirLibros(LibrosController.obtener());
            }
            if (eleccion.equals("6")) {
                PrestamoController.imprimirPrestamos(PrestamoController.obtener());
            }
            if (eleccion.equals("7")) {
                SocioController.imprimirSociosNoFiables(SocioController.obtener());
            }
            if (eleccion.equals("8")) {
                LibrosController.solicitarDatosParaCambiarSignatura();
            }

        }
    }

	}
