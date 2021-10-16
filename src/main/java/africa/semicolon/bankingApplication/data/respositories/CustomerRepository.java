package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Customer;

import java.util.List;

public interface CustomerRepository {
    Customer save(Customer customer);
    Customer findByCustomerId(String id);
    void delete(Customer customer);
    void delete(String id);
    List<Customer> findAll();
}
