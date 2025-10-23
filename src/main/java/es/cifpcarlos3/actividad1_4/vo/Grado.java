package es.cifpcarlos3.actividad1_4.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor

public class Grado implements Serializable {
    private String cod;
    private String nombre;
    private String categoria;
}
