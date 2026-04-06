package cl.QuickOrder.v1.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import cl.QuickOrder.v1.model.Pedido;
@Repository
public class PedidoRepository {


     private ArrayList<Pedido> listaPedidos = new ArrayList <> ();

     public List<Pedido> getPedidos (){
        return listaPedidos;
     }

    public Pedido buscarId(int id) {
        for (Pedido pedido : listaPedidos) {
            if (pedido.getId() == id) {
                return pedido;
            }
        }
        return null;
    }

    public Pedido buscarNombre (String nombre){
        for (Pedido pedido : listaPedidos){
            if (pedido.getNombreCliente().equals(nombre)){
                return pedido;
            }
        }
        return null;
    }

    public Pedido agregarPedido (Pedido pedido){
        listaPedidos.add(pedido);
        return pedido;
    }


    
    public void actualizarPedido(Pedido pedidoActualizado){
        for (int i = 0; i<listaPedidos.size();i++){
            if(listaPedidos.get(i).getId() == pedidoActualizado.getId()){
                listaPedidos.set(i, pedidoActualizado);
                break;
            }
        }

    }


    public void eliminarPedido(int id){
        listaPedidos.removeIf(pedido -> pedido.getId()==id);
    }


    public int totalPedidos (){
        return listaPedidos.size();
    }



}//fin
