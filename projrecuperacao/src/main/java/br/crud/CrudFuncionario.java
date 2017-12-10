/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.crud;

import br.entity.Funcionario;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author Tamy
 */
public class CrudFuncionario extends AbstractCrud<Funcionario>{
    private EntityManager em;
    
    private static final String PU = EMNames.EMN1;
    
    public CrudFuncionario(){
            super(Funcionario.class);
    }

    @Override
    protected EntityManager getEntityManager() {
       if (em == null) {
            em = Persistence.createEntityManagerFactory(PU).createEntityManager();
        }
        return em;
    }
    
    
}
