package cl.QuickOrder.v1.mapper;

import cl.QuickOrder.v1.dto.ClientRequest;
import cl.QuickOrder.v1.model.Pedido;

public class PedidoMapper {

    public static Pedido toModel(ClientRequest request) {
        return new Pedido(
            request.getId(),
            request.getNombreCliente(),
            request.getEstado(),
            request.getMonto(),
            request.getFecha(),
            request.getCategoria(),
            request.getDescripcion()
        );
    }
}
