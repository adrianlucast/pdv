package br.unipar.programacaoparainternet.pdv.dao;

import br.unipar.programacaoparainternet.pdv.dao.VendaDAO;
import br.unipar.programacaoparainternet.pdv.model.Venda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.List;

@Stateless
public class VendaDAO {

    private final EntityManager entityManager;

    public VendaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }


    public void salvar(Venda venda) {
        entityManager.getTransaction().begin();
        entityManager.persist(venda);
        entityManager.getTransaction().commit();
    }


    public void atualizar(Venda venda) {
        entityManager.getTransaction().begin();
        entityManager.merge(venda);
        entityManager.getTransaction().commit();
    }


    public void deletar(Long id) {
        entityManager.getTransaction().begin();
        Venda venda = entityManager.find(Venda.class, id);
        if (venda != null) {
            entityManager.remove(venda);
        }
        entityManager.getTransaction().commit();
    }


    public Venda buscarPorId(Long id) {
        return entityManager.find(Venda.class, id);
    }


    public List<Venda> buscarTodos() {
        return entityManager.createQuery("SELECT v FROM Venda v", Venda.class).getResultList();
    }
}
