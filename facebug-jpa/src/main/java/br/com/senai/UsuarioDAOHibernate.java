package br.com.senai;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOHibernate {
	
	@PersistenceContext
    private EntityManager em;

    public List<Usuario> getUsuario(String email, String senha) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Usuario> query = criteriaBuilder.createQuery(Usuario.class);
        Root<Usuario> root = query.from(Usuario.class);
        Path<String> nomePath = root.<String>get("email");
        Path<String> senhaPath = root.<String>get("senha");
        
        //List<Predicate> predicates = new ArrayList<>();
        
        Predicate predicateNome = criteriaBuilder.like(nomePath, email);
        //predicates.add(predicateNome);
        Predicate predicateSenha = criteriaBuilder.equal(senhaPath, senha);
        //predicates.add(predicateSenha);
        query.where(predicateNome, predicateSenha);
        
        

        TypedQuery<Usuario> typedQuery = em.createQuery(query);
        
        Usuario usuario = (Usuario) typedQuery;

        return typedQuery.getResultList();
    }

}
