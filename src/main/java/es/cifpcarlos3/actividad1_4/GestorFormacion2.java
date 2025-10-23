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
        Grado grado = cargarGrado(codigo_grado);
        List<Ciclo> ciclos = cargarCiclo(codigo_familia, codigo_grado);

        if (familia == null || grado == null) {
            System.out.println("No se encontró la familia o el grado especificado.");
            return;
        }

        System.out.println("Familia profesional: " + familia.getNombre() + " (" + familia.getCodigo() + ")");
        System.out.println("Grado seleccionado: " + grado.getNombre());
        System.out.println("Ciclos encontrados: ");

        if (ciclos.isEmpty()) {
            System.out.println("No hay ciclos asociados a esta familia.");
        } else {
            ciclos.forEach(System.out::println);
        }

        // Serialización
        serializarLista(ciclos);
    }

    public static FamiliaProfesional cargarFamilia(String codigo_familia) {
        String ruta = "src/main/java/es/cifpcarlos3/actividad1_4/familia_profesional.dat";
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("=");
                if (partes.length == 2) {
                    String codigo = partes[0].trim().toUpperCase();
                    String nombre = partes[1].trim();
                    if (codigo.equals(codigo_familia)) {
                        return new FamiliaProfesional(codigo, nombre);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el familia " + e.getMessage());
        }
        return null;
    }

    public static Grado cargarGrado(String codigo_grado) {
        String ruta = "src/main/java/es/cifpcarlos3/actividad1_4/grados.csv";
        try(BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split("#");
                if (partes.length == 3) {
                    String cod = partes[0].trim().toUpperCase();
                    String nombre = partes[1].trim();
                    String categoria = partes[2].trim();
                    if (cod.equals(codigo_grado)) {
                        return new Grado(cod, nombre, categoria);
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error al leer el grado " + e.getMessage());
        }
        return null;
    }

    public static List<Ciclo> cargarCiclo(String codigo_familia, String codigo_grado) {
        List<Ciclo> ciclos = new ArrayList<>();
        String ruta = "src/main/java/es/cifpcarlos3/actividad1_3/informacion_ciclos.txt";
        try (BufferedReader  br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                linea = linea.trim();
                if(linea.isEmpty())continue;
                linea = linea.replace("'", "");

                String[] partes = linea.split(",");

                if (partes.length == 5) {
                    String cod = partes[0].trim().toUpperCase();
                    String descripcion = partes[1].trim();
                    int numHoras = Integer.parseInt(partes[2].trim());
                    String cod_familia = partes[3].trim();
                    String cod_grado = partes[4].trim();
                    if (cod_familia.equals(codigo_familia) && cod_grado.equals(codigo_grado)) {
                        ciclos.add(new Ciclo(cod, descripcion, numHoras, cod_familia, cod_grado));
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Error al cargar el ciclo: " + e.getMessage());
        }
        return ciclos;
    }

    public static void serializarLista(List<Ciclo> ciclos) {
        try (ObjectOutputStream oos = new ObjectOutputStream
                (new FileOutputStream("src/main/java/es/cifpcarlos3/actividad1_4/lista_ciclos.ser")))
        {
            oos.writeObject(ciclos);
            System.out.println("Lista serializada correctamente en lista_ciclos.ser");
        } catch (IOException e) {
            System.out.println("Error al serializar la lista: " + e.getMessage());
        }
    }
}
