package br.unipar.programacaoparainternet.pdv.controller;

import br.unipar.programacaoparainternet.pdv.model.Venda;
import br.unipar.programacaoparainternet.pdv.service.VendaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/venda")
@Stateless
public class VendaController {

    @Inject
    private VendaService vendaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarVenda(Venda venda) {
        try {
            vendaService.salvar(venda);
            return Response.status(Response.Status.CREATED).entity("Venda criada com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar venda").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarVendaPorId(@PathParam("id") Long id) {
        Venda venda = vendaService.buscarPorId(id);
        if (venda != null) {
            return Response.ok(venda).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Venda não encontrada").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarVendas() {
        return Response.ok(vendaService.listarTodos()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarVenda(@PathParam("id") Long id) {
        try {
            vendaService.deletar(id);
            return Response.ok("Venda deletada com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar venda").build();
        }
    }
}
