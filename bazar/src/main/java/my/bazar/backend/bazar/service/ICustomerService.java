package my.bazar.backend.bazar.service;

import my.bazar.backend.bazar.model.Customer;

import java.util.List;

public interface ICustomerService {
    public void saveCustomer(Customer customer);
    public Customer getCustomerById(Long id);
    public List<Customer> getAllCustomers();
    public Customer editCustomer(Long customer_id, String name, String lastname, String dni);
    public void deleteCustomerById(Long id);
}
