package africa.semicolon.bankingApplication.dtos.response;

import africa.semicolon.bankingApplication.data.models.Customer;
import lombok.Data;

@Data
public class CustomerResponse {
    private String firstName;
    private String lastName;
    private String bvn;
    private int numberOfAccount;

    public CustomerResponse(Customer customer){
        firstName = customer.getFirstName();
        lastName = customer.getLastName();
        bvn = customer.getBvn();
        numberOfAccount = customer.getAccounts().size();
    }

}
