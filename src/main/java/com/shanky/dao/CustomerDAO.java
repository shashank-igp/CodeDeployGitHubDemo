package com.shanky.dao;

/**
 * Created by shanky on 23/12/16.
 */


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.shanky.model.customer;
public class CustomerDAO {
    private static List<customer> customers;
    {
        customers = new ArrayList();
        customers.add(new customer(101, "John", "Doe", "djohn@gmail.com", "121-232-3435"));
        customers.add(new customer(201, "Russ", "Smith", "sruss@gmail.com", "343-545-2345"));
        customers.add(new customer(301, "Kate", "Williams", "kwilliams@gmail.com", "876-237-2987"));
        customers.add(new customer(System.currentTimeMillis(), "Viral", "Patel", "vpatel@gmail.com", "356-758-8736"));
    }

    /**
     * Returns list of customers from dummy database.
     *
     * @return list of customers
     */
    public List list() {
        return customers;
    }

    /**
     * Return customer object for given id from dummy database. If customer is
     * not found for id, returns null.
     *
     * @param id
     *            customer id
     * @return customer object for given id
     */
    public customer get(Long id) {

        for (customer c : customers) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * Create new customer in dummy database. Updates the id and insert new
     * customer in list.
     *
     * @param customer
     *            customer object
     * @return customer object with updated id
     */
    public customer create(customer customer) {
        customer.setId(System.currentTimeMillis());
        customers.add(customer);
        return customer;
    }

    /**
     * Delete the customer object from dummy database. If customer not found for
     * given id, returns null.
     *
     * @param id
     *            the customer id
     * @return id of deleted customer object
     */
    public Long delete(Long id) {

        for (customer c : customers) {
            if (c.getId().equals(id)) {
                customers.remove(c);
                return id;
            }
        }

        return null;
    }

    /**
     * Update the customer object for given id in dummy database. If customer
     * not exists, returns null
     *
     * @param id
     * @param customer
     * @return customer object with id
     */
    public customer update(Long id, customer customer) {

        for (customer c : customers) {
            if (c.getId().equals(id)) {
                customer.setId(c.getId());
                customers.remove(c);
                customers.add(customer);
                return customer;
            }
        }

        return null;
    }
}

