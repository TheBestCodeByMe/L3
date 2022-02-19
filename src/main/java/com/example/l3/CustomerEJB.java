package com.example.laboratory3;

import java.util.List;
import javax.ejb.Local;

@Local
public interface CustomerEJB {
    List<Customer> findAll();
    void create(Customer incoming);
    void update(Long id, Customer incoming);
    void remove(Long id);
}
