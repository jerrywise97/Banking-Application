package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Bank;

import java.util.List;

public interface BankRepository {
    Bank save(Bank bank);
    Bank findBankByid(String id);
    void delete(Bank bank);
    void delete(String id);
    List<Bank> findAllBank();
}
