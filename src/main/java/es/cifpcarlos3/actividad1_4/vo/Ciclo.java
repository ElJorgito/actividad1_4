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
    public String toString() {return cod + descripcion + numHoras + cod_familia + cod_grado ;}
}
