package africa.semicolon.bankingApplication.dtos.request;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.AccountType;
import lombok.Data;

@Data
public class CreateAccountRequest {
   private String bankId;
   private String firstName;
    private  String lastName;
    private AccountType accountType;
}
