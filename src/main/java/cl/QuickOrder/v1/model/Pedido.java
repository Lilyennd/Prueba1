package cl.QuickOrder.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Pedido {

    private int id;
    private String nombreCliente;
    private String estado;
    private int monto;
    private String fechaPedido;
    private String categoria;
    private String descripcion;

}
