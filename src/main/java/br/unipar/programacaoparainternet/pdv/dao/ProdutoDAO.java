package br.unipar.programacaoparainternet.pdv.dao;

import br.unipar.programacaoparainternet.pdv.dao.ProdutoDAO;
import br.unipar.programacaoparainternet.pdv.model.Produto;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import java.util.List;

@Stateless
public class ProdutoDAO {

    private final EntityManager entityManager;

    public ProdutoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salvar(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.persist(produto);
        entityManager.getTransaction().commit();
    }

    public void atualizar(Produto produto) {
        entityManager.getTransaction().begin();
        entityManager.merge(produto);
        entityManager.getTransaction().commit();
    }

    public void deletar(Long id) {
        entityManager.getTransaction().begin();
        Produto produto = entityManager.find(Produto.class, id);
        if (produto != null) {
            entityManager.remove(produto);
        }
        entityManager.getTransaction().commit();
    }

    public Produto buscarPorId(Long id) {
        return entityManager.find(Produto.class, id);
    }

    public List<Produto> buscarTodos() {
        return entityManager.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
    }
}
