package br.unipar.programacaoparainternet.pdv.service;

import br.unipar.programacaoparainternet.pdv.dao.ItemVendaDAO;
import br.unipar.programacaoparainternet.pdv.model.ItemVenda;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class ItemVendaService {

    @Inject
    private ItemVendaDAO itemVendaDAO;

    @Transactional
    public void salvar(ItemVenda itemVenda) {
        itemVendaDAO.salvar(itemVenda);
    }

    public ItemVenda buscarPorId(Long id) {
        return itemVendaDAO.buscarPorId(id);
    }

    public List<ItemVenda> listarTodos() {
        return itemVendaDAO.buscarTodos();
    }

    @Transactional
    public void deletar(Long id) {
        ItemVenda itemVenda = itemVendaDAO.buscarPorId(id);
        itemVendaDAO.deletar(id);
    }
}
