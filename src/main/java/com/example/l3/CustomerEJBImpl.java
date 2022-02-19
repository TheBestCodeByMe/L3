package com.example.laboratory3;


import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class CustomerEJBImpl implements CustomerEJB {
    @PersistenceContext(unitName = "ris")
    private EntityManager entityManager;

    @Override
    public List<Customer> findAll() {
        Query q = entityManager.createQuery("SELECT c from Customer c");
        return q.getResultList();
    }

    @Override
    public void create(Customer incoming) {
        entityManager.persist(incoming);
    }

    @Override
    public void update(Long id, Customer incoming) {
        Customer ent = entityManager.find(Customer.class, id);
        ent.setName(incoming.getName());
        ent.setZip(incoming.getZip());
        ent.setNumbFax(incoming.getNumbFax());
        ent.setFirstAddress(incoming.getFirstAddress());
        ent.setSecondAddress(incoming.getSecondAddress());
        ent.setCity(incoming.getCity());
        entityManager.merge(ent);
    }

    @Override
    public void remove(Long id) {
        Customer ent = entityManager.find(Customer.class, id);
        entityManager.remove(ent);
    }
}