package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.AccountType;
import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.models.Bvn;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountRepositoryImplTest {
    private AccountRepository accountRepository;

    @BeforeEach
    void setUp() {
        accountRepository = new AccountRepositoryImpl();

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
//        Bank bank = new Bank("001");
        Account account = new Account();
        account.setCustomerId("3296169ew7");
        account.setNumber("34566786542");
        account.setType(AccountType.CURRENT);
        Account saveAccount = accountRepository.save(account);
        assertEquals(account, saveAccount);

    }

    @Test
    void findAccount() {

        Account account = new Account();
        account.setCustomerId("3296169ew7");
        account.setNumber("34566786542");
        account.setType(AccountType.CURRENT);
        accountRepository.save(account);

        Account foundAccount = accountRepository.findAccount("3296169ew7");
        assertEquals(account, foundAccount);

    }

    @Test
    void deleteAccount() {
//        Bank bank = new Bank("001");
        Account account = new Account();
        account.setCustomerId("3296169ew7");
        account.setNumber("34566786542");
        account.setType(AccountType.CURRENT);
        accountRepository.save(account);

        assertNotNull(accountRepository.findAccount("3296169ew7"));
        accountRepository.deleteAccount(account);
        assertNull(accountRepository.findAccount("3296169ew7"));
    }
    @Test
    void testDeleteAccount(){
        Account account = new Account();
        account.setCustomerId("3296169ew7");
        account.setNumber("34566786542");
        account.setType(AccountType.CURRENT);
        accountRepository.save(account);

        assertNotNull(accountRepository.findAccount("3296169ew7"));
        accountRepository.deleteAccount("3296169ew7");
        assertNull(accountRepository.findAccount("3296169ew7"));
    }

    @Test
    void findAllAccount() {
        Account account = new Account();
        account.setCustomerId("3296169ew7");
        account.setNumber("34566786542");
        account.setType(AccountType.CURRENT);
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        accountRepository.save(account);
        assertEquals(5, accountRepository.findAllAccount().size());

    }
}