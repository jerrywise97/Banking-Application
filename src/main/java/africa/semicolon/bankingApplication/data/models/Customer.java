package africa.semicolon.bankingApplication.data.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Customer {
    private String bvn;
    private List<Account> accounts = new ArrayList<Account>();
    private String firstName;
    private String LastName;

}
