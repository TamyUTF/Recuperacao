/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.crud;

import java.util.List;
import javax.persistence.EntityManager;



/**
 *
 * @author Tamy
 */
public abstract class AbstractCrud<E> {
    
    private Class<E> entityClass;
    
    public AbstractCrud(Class<E> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract EntityManager getEntityManager();

    public void persist(E entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().persist(entity);
        getEntityManager().getTransaction().commit();
    }

    public void merge(E entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().merge(entity);
        getEntityManager().getTransaction().commit();
    }

    public void remove(E entity) {
        getEntityManager().getTransaction().begin();
        getEntityManager().remove(getEntityManager().merge(entity));
        getEntityManager().getTransaction().commit();
    }

    public E find(Object id) {
        return getEntityManager().find(entityClass, id);
    }

    public List<E> getAll() {
        try{
        javax.persistence.criteria.CriteriaQuery cq;
        cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
}
