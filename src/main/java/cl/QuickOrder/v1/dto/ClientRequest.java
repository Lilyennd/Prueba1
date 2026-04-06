package cl.QuickOrder.v1.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;



@Data
public class ClientRequest {
    @PositiveOrZero (message = "no puede ser una id negativa")
        private int id;

    @NotBlank (message = "el nombre no puede estar vacio")
        private String nombreCliente;

    @NotBlank (message = "defina un estado")
        private String estado;   

    @PositiveOrZero (message = "ingrese un monto valido")
        private int monto;
    
    @NotBlank (message = "ingrese una fecha")
        private String fecha;

    @NotBlank (message = "ingrese una categoria")
    private String categoria;

    @NotBlank (message = "ingrese una descripcion")
        private String descripcion;



}
