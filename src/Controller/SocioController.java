package Controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Datasource.Prestamo;
import Datasource.Socio;

public class SocioController {
	
	private static final String NOMBRE_ARCHIVO= "socios.txt";
	private static final String SEPARADOR_CAMPO= ";";
	private static final String SEPARADOR_REGISTRO= "\n";
	
	public static void solicitarDatosParaRegistrar() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese número de socio: ");
		String numero = sc.nextLine();
		System.out.println("Ingrese nombre de socio: ");
		String nombre = sc.nextLine();
		System.out.println("Ingrese dirección de socio: ");
		String direccion = sc.nextLine();
		SocioController.registrar(new Socio(numero, nombre, direccion));
		System.out.println("Registrado exitosamente");
	}
	
	public static void registrar(Socio socio) {
		try {
			BufferedWriter bufferredWriter = new BufferedWriter(new FileWriter(NOMBRE_ARCHIVO, true));
			bufferredWriter.write(socio.getCi() + SEPARADOR_CAMPO + socio.getNombre()+ SEPARADOR_CAMPO
					+ socio.getDirección() + SEPARADOR_CAMPO);
			bufferredWriter.close();
		} catch (IOException e) {
			System.out.println("Error escribiendo el archivo " + e.getMessage());
		}
	}
	
	public static  ArrayList<Socio> obtener() {
		ArrayList<Socio> socios = new ArrayList<>();
		FileReader fileReader = null;
		BufferedReader bufferedReader = null;
		try {
			fileReader = new FileReader(NOMBRE_ARCHIVO);
			bufferedReader = new BufferedReader(fileReader);
			String linea;
			while ((linea = bufferedReader.readLine()) != null) {
				String[] socioComoArreglo= linea.split(SEPARADOR_CAMPO);
				socios.add(new Socio (socioComoArreglo[0], socioComoArreglo[1], socioComoArreglo[2]));
			}
		} catch (IOException e) {
			System.out.println("Excepción leyendo archivo "+ e.getMessage());
		} finally {
			try {
				if (fileReader != null) {
					fileReader.close();
				}
				if (bufferedReader != null) {
					bufferedReader.close();
				}
			} catch (final IOException e2) {
				System.out.println("Excepción cerrando: "+e2.getMessage());
			}
			return socios;
		}
	}
    public static void imprimirSocios(ArrayList<Socio> socios) {
        ArrayList<Prestamo> prestamos = PrestamoController.obtener();
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", "#", "No. socio", "Nombre", "Direccion",
                "Libros prestados");
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < socios.size(); x++) {
            Socio socio = socios.get(x);
            System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", x + 1, socio.getCi(), socio.getNombre(),
                    socio.getDirección(), PrestamoController.cantidadLibrosPrestados(socio.getCi(), prestamos));
            System.out.println(
                    "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }

    public static void imprimirSociosNoFiables(ArrayList<Socio> socios) {
        ArrayList<Prestamo> prestamos = PrestamoController.obtener();
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", "#", "No. socio", "Nombre", "Direccion",
                "Libros prestados");
        System.out.println(
                "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        for (int x = 0; x < socios.size(); x++) {
            Socio socio = socios.get(x);
            int librosPrestados = PrestamoController.cantidadLibrosPrestados(socio.getCi(), prestamos);
            if (librosPrestados < 10) {
                continue;
            }
            System.out.printf("|%-5s|%-10s|%-40s|%-40s|%-20s|\n", x + 1, socio.getCi(), socio.getNombre(),
                    socio.getDirección(), librosPrestados);
            System.out.println(
                    "+-----+----------+----------------------------------------+----------------------------------------+--------------------+");
        }
    }

    public static int buscarSocioPorNumero(String numero, ArrayList<Socio> socios) {
        for (int x = 0; x < socios.size(); x++) {
            Socio socio = socios.get(x);
            if (socio.getCi().equals(numero)) {
                return x;
            }
        }
        return -1;
    }

    public static Socio imprimirSociosYPedirSeleccion() {
        ArrayList<Socio> socios = SocioController.obtener();
        Scanner sc = new Scanner(System.in);
        while (true) {
            SocioController.imprimirSocios(socios);
            System.out.println("Ingrese el numero de socio: ");
            String numero = sc.nextLine();
            int indice = SocioController.buscarSocioPorNumero(numero, socios);
            if (indice == -1) {
                System.out.println("No existe socio con ese numero");
            } else {
                return socios.get(indice);
            }
        }
    }
}
