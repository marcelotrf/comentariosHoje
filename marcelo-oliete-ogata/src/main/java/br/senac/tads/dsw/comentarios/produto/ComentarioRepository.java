/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.comentarios.produto;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author adm
 */
@Repository
public class ComentarioRepository {
    @PersistenceContext
    private EntityManager em;
    
    @Transactional
    public Comentario save(Comentario coment) {
        if (coment.getId() == null) {
            // JPA vai incluir novo registro no banco
            em.persist(coment);
        } else {
            // Atualiza categoria existente
            coment = em.merge(coment);
        }
        return coment;
    }
    
      public List<Comentario> findByProdutoId() {
        TypedQuery<Comentario> jpqlQuery = 
                em.createQuery("SELECT c FROM Comentario c ORDER BY c.dataHorario DESC", Comentario.class);
        return jpqlQuery.getResultList();
    }
}
