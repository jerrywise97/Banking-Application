package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.data.respositories.CustomerRepository;
import africa.semicolon.bankingApplication.data.respositories.CustomerRepositoryImpl;
import africa.semicolon.bankingApplication.dtos.response.CustomerResponse;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class CustomerServicesImpl implements CustomerServices {
    private final static CustomerRepository customerRepository = new CustomerRepositoryImpl();


    @Override
    public List<CustomerResponse> findAll() {
        List<CustomerResponse> responses = new ArrayList<>();
        List<Customer> ourRealCustomers = customerRepository.findAll();

        for (Customer customer: ourRealCustomers) {
            responses.add(new CustomerResponse(customer));
//            ourRealCustomers.forEach(customer1 -> responses.add(new CustomerResponse(customer)));

        }
        return responses;
    }

    @Override
    public void addNew(Customer customer) {
        customerRepository.save(customer);
    }

}
