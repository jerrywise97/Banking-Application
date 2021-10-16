package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Account;

import java.util.List;

public interface AccountRepository {
    Account save(Account account);
    Account findAccount(String id);
    void deleteAccount(Account account4rr);
    void deleteAccount(String id);
    List<Account> findAllAccount();
}
