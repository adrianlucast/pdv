package br.unipar.programacaoparainternet.pdv.service;

import br.unipar.programacaoparainternet.pdv.dao.ClienteDAO;
import br.unipar.programacaoparainternet.pdv.model.Cliente;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@Stateless
public class ClienteService {

    @Inject
    private ClienteDAO clienteDAO;

    @Transactional
    public void salvar(Cliente cliente) {
        clienteDAO.salvar(cliente);
    }

    public Cliente buscarPorId(Long id) {
        return clienteDAO.buscarPorId(id);
    }

    public List<Cliente> listarTodos() {
        return clienteDAO.buscarTodos();
    }

    @Transactional
    public void deletar(Long id) {
        Cliente cliente = clienteDAO.buscarPorId(id);
        clienteDAO.deletar(id);
    }
}
