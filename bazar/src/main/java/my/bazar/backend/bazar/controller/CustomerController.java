package my.bazar.backend.bazar.controller;

import my.bazar.backend.bazar.model.Customer;
import my.bazar.backend.bazar.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    ICustomerService custService;

    @PostMapping("/customer/create")
    public String createCustomer(@RequestBody Customer customer){
        custService.saveCustomer(customer);

        return "Customer successfully created";
    }

    @GetMapping("/customer/get/{id}")
    public Customer getCustomerById(@PathVariable Long id){
        return custService.getCustomerById(id);
    }

    @GetMapping("/customer/get/all")
    public List<Customer> getAllCustomers(){
        return custService.getAllCustomers();
    }

    @PutMapping("/customer/edit/{id}")
    public Customer editCustomer(@PathVariable Long id,
                                 @RequestParam(required = false, name = "name")String newName,
                                 @RequestParam(required = false, name = "lastname")String newLastname,
                                 @RequestParam(required = false, name ="cost")String newDni){
        Customer customer = custService.getCustomerById(id);
        if(customer!=null){
            customer.setName(newName);
            customer.setLastname(newLastname);
            customer.setDni(newDni);
            custService.saveCustomer(customer);
        }
        return customer;
    }

    @DeleteMapping("/customer/delete/{id}")
    public String deleteCustomerById(@PathVariable Long id){
        custService.deleteCustomerById(id);
        return "Customer successfully deleted";
    }

}
