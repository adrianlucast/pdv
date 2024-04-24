package br.unipar.programacaoparainternet.pdv.dao;

import br.unipar.programacaoparainternet.pdv.model.ItemVenda;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.List;

@Stateless
public class ItemVendaDAO {

    private final EntityManager entityManager;

    public ItemVendaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(ItemVenda itemVenda) {
        entityManager.getTransaction().begin();
        entityManager.persist(itemVenda);
        entityManager.getTransaction().commit();
    }


    public void atualizar(ItemVenda itemVenda) {
        entityManager.getTransaction().begin();
        entityManager.merge(itemVenda);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        entityManager.getTransaction().begin();
        ItemVenda itemVenda = entityManager.find(ItemVenda.class, id);
        if (itemVenda != null) {
            entityManager.remove(itemVenda);
        }
        entityManager.getTransaction().commit();
    }

    public ItemVenda buscarPorId(Long id) {
        return entityManager.find(ItemVenda.class, id);
    }

    public List<ItemVenda> buscarTodos() {
        return entityManager.createQuery("SELECT i FROM ItemVenda i", ItemVenda.class).getResultList();
    }
}
