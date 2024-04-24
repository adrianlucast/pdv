package br.unipar.programacaoparainternet.pdv.controller;

import br.unipar.programacaoparainternet.pdv.controller.ItemVendaController;
import br.unipar.programacaoparainternet.pdv.model.ItemVenda;
import br.unipar.programacaoparainternet.pdv.model.ItemVendaService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/itemvenda")
@Stateless
public class ItemVendaController {

    @Inject
    private ItemVendaService itemVendaService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarItemVenda(ItemVenda itemVenda) {
        try {
            itemVendaService.salvar(itemVenda);
            return Response.status(Response.Status.CREATED).entity("Item de venda criado com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar item de venda").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarItemVendaPorId(@PathParam("id") Long id) {
        ItemVenda itemVenda = itemVendaService.buscarPorId(id);
        if (itemVenda != null) {
            return Response.ok(itemVenda).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Item de venda não encontrado").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarItensVenda() {
        return Response.ok(itemVendaService.listarTodos()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarItemVenda(@PathParam("id") Long id) {
        try {
            itemVendaService.deletar(id);
            return Response.ok("Item de venda deletado com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar item de venda").build();
        }
    }
}
