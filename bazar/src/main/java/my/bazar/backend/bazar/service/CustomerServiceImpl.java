package my.bazar.backend.bazar.service;

import my.bazar.backend.bazar.model.Customer;
import my.bazar.backend.bazar.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    ICustomerRepository custRepo;

    @Override
    public void saveCustomer(Customer customer) {
        custRepo.save(customer);
    }

    @Override
    public Customer getCustomerById(Long id) {
        return custRepo.findById(id).orElse(null);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return custRepo.findAll();
    }

    @Override
    public Customer editCustomer(Long customer_id, String name, String lastname, String dni) {
        Customer customer = this.getCustomerById(customer_id);
        if(customer != null){
            customer.setName(name);
            customer.setLastname(lastname);
            customer.setDni(dni);
            this.saveCustomer(customer);
        }
        return customer;
    }

    @Override
    public void deleteCustomerById(Long id) {
        custRepo.deleteById(id);
    }
}
