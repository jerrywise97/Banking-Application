package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Bank;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankRepositoryImplTest {
    private BankRepository bankRepository;

    @BeforeEach
    void setUp() {
        bankRepository = new BankRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Bank bank = new Bank("001");
        bank.setName("WEMA BANK");
        Bank savedBank = bankRepository.save(bank);
        assertEquals(bank, savedBank);
    }

    @Test
    void findBankByid() {
        Bank bank = new Bank("001");
        bank.setName("Wema bank");
        bankRepository.save(bank);

        Bank foundBank = bankRepository.findBankByid("001");
        assertEquals(bank, foundBank);
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void findAllBank() {
    }
}