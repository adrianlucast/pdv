package br.unipar.programacaoparainternet.pdv.controller;

import br.unipar.programacaoparainternet.pdv.controller.ClienteController;
import br.unipar.programacaoparainternet.pdv.model.Cliente;
import br.unipar.programacaoparainternet.pdv.service.ClienteService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/cliente")
@Stateless
public class ClienteController {

    @Inject
    private ClienteService clienteService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarCliente(Cliente cliente) {
        try {
            clienteService.salvar(cliente);
            return Response.status(Response.Status.CREATED).entity("Cliente criado com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar cliente").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarClientePorId(@PathParam("id") Long id) {
        Cliente cliente = clienteService.buscarPorId(id);
        if (cliente != null) {
            return Response.ok(cliente).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Cliente não encontrado").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarClientes() {
        return Response.ok(clienteService.listarTodos()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarCliente(@PathParam("id") Long id) {
        try {
            clienteService.deletar(id);
            return Response.ok("Cliente deletado com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar cliente").build();
        }
    }
}
