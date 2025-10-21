package es.cifpcarlos3.actividad1_4;

import es.cifpcarlos3.actividad1_4.vo.Ciclo;
import es.cifpcarlos3.actividad1_4.vo.FamiliaProfesional;
import es.cifpcarlos3.actividad1_4.vo.Grado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorFormacion2 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java GestorInformacion2 <codigo_familia> <codigo-grado>");
            return;
        }
        String codigo_familia = args[0].trim().toUpperCase();
        String codigo_grado = args[1].trim().toUpperCase();

        FamiliaProfesional familia = cargarFamilia(codigo_familia);

        if (familia == null) {
            System.out.println("Familia no encontrada");
            return;
        }

        System.out.println("Familia profesional: " + familia.getNombre());
        System.out.println("Grado seleccionado: ");

        List<Ciclo> ciclos = cargarCiclo(codigo_familia, codigo_grado);

        System.out.println("Ciclos encontrados: ");
        if (ciclos.isEmpty()) {
            System.out.println("No hay ciclos asociados a esta familia.");
        } else {
            ciclos.forEach(System.out::println);
        }
    }
    private static FamiliaProfesional cargarFamilia(String codigo_familia) {
        String ruta = "src/main/java/es/cifpcarlos3/actividad1_4/familia_profesional.dat";
        try (FileInputStream fis = new FileInputStream(ruta)) {

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static Grado cargarGrado(String codigo_grado) {
        String ruta = "src/main/java/es/cifpcarlos3/actividad1_4/grados.csv";
        return null;
    }

    public static Ciclo cargarCiclo(String codigo_familia, String codigo_grado) {
        List<Ciclo> ciclos = new ArrayList<>();
        String ruta = "src/main/java/es/cifpcarlos3/actividad1_3/informacion_ciclos.txt";
        try () {

        } catch (Exception e) {
            System.err.println("Error al cargar el ciclo: " + e.getMessage());
        }
        return null;
    }
}
