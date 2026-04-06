package cl.QuickOrder.v1.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.QuickOrder.v1.model.Pedido;
import cl.QuickOrder.v1.repository.PedidoRepository;


@Service
public class PedidoService {
@Autowired
    private PedidoRepository pedidoRepository;

    public List<Pedido> getPedidos(){
        return pedidoRepository.getPedidos();
    }

    public void agregarPedido(Pedido pedido){
         pedidoRepository.agregarPedido(pedido);
    }

    public Pedido buscarId(int id ){
        return pedidoRepository.buscarId(id);
    }

    public Pedido buscarNombre (String nombre){
        return pedidoRepository.buscarNombre(nombre);
    }

    public void eliminarPedido(int id){
        pedidoRepository.eliminarPedido(id);
    }

    public void actualizarPedido(Pedido pedidoActualizado){
        pedidoRepository.actualizarPedido(pedidoActualizado);
    }

    public int totalPedidos(){
        return pedidoRepository.totalPedidos();
    }


}//fin
