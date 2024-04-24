package br.unipar.programacaoparainternet.pdv.model;

import br.unipar.programacaointernet.servicecep.model.Produto;
import br.unipar.programacaoparainternet.pdv.dao.ProdutoDAO;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class ProdutoService {

    @Inject
    private ProdutoDAO produtoDAO;

    @Transactional
    public void salvar(Produto produto) {
        produtoDAO.salvar(produto);
    }

    public Produto buscarPorId(Long id) {
        return produtoDAO.buscarPorId(id);
    }

    public List<Produto> listarTodos() {
        return produtoDAO.buscarTodos();
    }

    @Transactional
    public void deletar(Long id) {
        Produto produto = produtoDAO.buscarPorId(id);
        produtoDAO.deletar(id);
    }
}
