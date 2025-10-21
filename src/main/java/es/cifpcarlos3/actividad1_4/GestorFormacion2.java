package es.cifpcarlos3.actividad1_4;

import es.cifpcarlos3.actividad1_4.vo.Ciclo;
import es.cifpcarlos3.actividad1_4.vo.FamiliaProfesional;
import es.cifpcarlos3.actividad1_4.vo.Grado;

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

        List<Ciclo> ciclos = cargarCiclosPorFamilia(codigoFamilia);

        System.out.println("Ciclos encontrados: ");
        if (ciclos.isEmpty()) {
            System.out.println("No hay ciclos asociados a esta familia.");
        } else {
            ciclos.forEach(System.out::println);
        }
    }
    private static FamiliaProfesional cargarFamilia(String codigo_familia) {
        String ruta = "src/main/java/es/cifpcarlos3/actividad1_4/familia_profesional.dat";
        return null;
    }
}
