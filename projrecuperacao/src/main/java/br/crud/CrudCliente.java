/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.crud;

import br.entity.Cliente;
import br.entity.Funcionario;
import java.text.Normalizer;
import java.util.Collection;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Tamy
 */
public class CrudCliente extends AbstractCrud<Cliente>{
    private EntityManager em;
    
    private static final String PU = EMNames.EMN1;

    public CrudCliente() {
        super(Cliente.class);
    }
    public Collection<Cliente> SelectByNome(String nome){
        try {
            nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
	    nome = nome.replaceAll("[^\\p{ASCII}]", "");
            return getEntityManager().createNamedQuery("Cliente.findByNome").setParameter("nome", "%" + nome.toUpperCase() + "%").getResultList();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null; 
    }
    @Override
    protected EntityManager getEntityManager() {
        if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }
    
}
