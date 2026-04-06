package cl.QuickOrder.v1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.QuickOrder.v1.dto.ClientRequest;
import cl.QuickOrder.v1.exception.ResourseNotFoundException;
import cl.QuickOrder.v1.mapper.PedidoMapper;
import cl.QuickOrder.v1.model.Pedido;
import cl.QuickOrder.v1.service.PedidoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/QuickOrder")
public class PedidoController {

    @Autowired
    private PedidoService pedidoService;

    @GetMapping
    public List <Pedido> getPedidos(){
        if(pedidoService.getPedidos().isEmpty()){
            throw new ResourseNotFoundException("No se encontraron pedidos");
        }
        return pedidoService.getPedidos();
    }

    @GetMapping("{id}")
    public Pedido buscarId(@PathVariable int id){
        Pedido pedido = pedidoService.buscarId(id);
        if (pedido == null){
            throw new ResourseNotFoundException("Pedido no encontrado con id: " + id);
        }
        return pedido;
    }

    @GetMapping("/nombre/{nombre}")
    public Pedido buscarNombre (@PathVariable String nombre){
        Pedido pedido = pedidoService.buscarNombre(nombre);
        if(pedido == null){
            throw new ResourseNotFoundException("Pedido no encontrado con nombre: " + nombre);
        }   
        return pedido;
    }


    @PostMapping
    public ResponseEntity<?> agregarPedido(@Valid @RequestBody ClientRequest request, BindingResult result){
        if (result.hasErrors()){
            return ResponseEntity.badRequest().body(result.getAllErrors());
        }else{Pedido pedido = PedidoMapper.toModel(request);
        pedidoService.agregarPedido(pedido);
        return ResponseEntity.ok(pedido);}
    }


    @PutMapping("{id}")
    public Pedido actualizarPedido(@PathVariable int id, @RequestBody Pedido pedidoActualizado){
        if(pedidoService.buscarId(id) == null){
            throw new ResourseNotFoundException("Pedido no encontrado con id: " + id);
        }
        pedidoService.actualizarPedido(pedidoActualizado);
        return pedidoActualizado;
    }


    @DeleteMapping("{id}")
    public void eliminarPedido(@PathVariable int id){
        if(pedidoService.buscarId(id) == null){
            throw new ResourseNotFoundException("Pedido no encontrado con id: " + id);
        }
        pedidoService.eliminarPedido(id);
    }


    @GetMapping("/total")
    public int totalPedidos(){
        return pedidoService.totalPedidos();
    }



}//fin
