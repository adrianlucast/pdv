package br.unipar.programacaoparainternet.pdv.controller;

import br.unipar.programacaoparainternet.pdv.model.Produto;
import br.unipar.programacaoparainternet.pdv.controller.ProdutoController;
import br.unipar.programacaoparainternet.pdv.model.ProdutoService;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/produto")
@Stateless
public class ProdutoController {

    @Inject
    private ProdutoService produtoService;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response criarProduto(Produto produto) {
        try {
            produtoService.salvar(produto);
            return Response.status(Response.Status.CREATED).entity("Produto criado com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao criar produto").build();
        }
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response buscarProdutoPorId(@PathParam("id") Long id) {
        Produto produto = produtoService.buscarPorId(id);
        if (produto != null) {
            return Response.ok(produto).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("Produto não encontrado").build();
        }
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response listarProdutos() {
        return Response.ok(produtoService.listarTodos()).build();
    }

    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletarProduto(@PathParam("id") Long id) {
        try {
            produtoService.deletar(id);
            return Response.ok("Produto deletado com sucesso").build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Erro ao deletar produto").build();
        }
    }
}
