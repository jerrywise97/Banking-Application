package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountRepositoryImpl implements AccountRepository{
    List<Account> accounts = new ArrayList<>();

    @Override
    public Account save(Account account) {
        accounts.add(account);
        return findAccount(account.getCustomerId());
    }


    @Override
    public Account findAccount(String id) {
        for (Account account: accounts) {
            if (account.getCustomerId().equalsIgnoreCase(id)){
                return account;
            }
        }
        return null;
    }

    @Override
    public void deleteAccount(Account account) {
        accounts.remove(account);

    }

    @Override
    public void deleteAccount(String id) {
        Account account = findAccount(id);
        deleteAccount(account);
    }

    @Override
    public List<Account> findAllAccount() {
        return accounts;
    }
}
