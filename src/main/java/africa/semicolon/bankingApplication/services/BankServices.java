package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.dtos.request.CreateAccountRequest;

import java.util.List;

public interface BankServices {
    String createBank(String bankName);
    List<Bank> findAllBanks();
    String createAccount(CreateAccountRequest createAccountRequest);
}
