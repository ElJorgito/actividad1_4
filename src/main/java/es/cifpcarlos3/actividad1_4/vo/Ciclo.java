package es.cifpcarlos3.actividad1_4.vo;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.io.Serializable;

@Data
@AllArgsConstructor


public class Ciclo implements Serializable {
    private String cod;
    private String descripcion;
    private int numHoras;
    private String cod_familia;
    private String cod_grado;

    @Override
    public String toString() {return "El ciclo " + descripcion + " incluido en la familia " + cod_familia + " es un " + cod_grado;}
}
