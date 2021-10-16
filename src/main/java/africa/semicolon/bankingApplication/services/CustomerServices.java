package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.dtos.response.CustomerResponse;

import java.util.List;

public interface CustomerServices {

    List<CustomerResponse> findAll();

    void addNew(Customer customer);
}
