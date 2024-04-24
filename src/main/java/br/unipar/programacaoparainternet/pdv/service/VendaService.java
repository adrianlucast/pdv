package br.unipar.programacaoparainternet.pdv.service;

import br.unipar.programacaoparainternet.pdv.dao.VendaDAO;
import br.unipar.programacaoparainternet.pdv.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class VendaService {

    @Inject
    private VendaDAO vendaDAO;

    @Transactional
    public void salvar(Venda venda) {
        vendaDAO.salvar(venda);
    }

    public Venda buscarPorId(Long id) {
        return vendaDAO.buscarPorId(id);
    }

    public List<Venda> listarTodos() {
        return vendaDAO.buscarTodos();
    }

    @Transactional
    public void deletar(Long id) {
        vendaDAO.deletar(id);
    }
}
