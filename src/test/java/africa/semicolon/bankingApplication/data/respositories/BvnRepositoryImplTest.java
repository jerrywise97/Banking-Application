package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BvnRepositoryImplTest {
    private BvnRepository bvnRepository;

    @BeforeEach
    void setUp() {
        bvnRepository = new BvnRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
         Customer customer = new Customer();
         Bvn bvn = new Bvn("3453432", customer);
         Bvn savedBvn = bvnRepository.save(bvn);
         assertEquals(bvn, savedBvn);
    }

    @Test
    void findBvnById() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("3453432", customer);
        Bvn savedBvn = bvnRepository.save(bvn);
        assertEquals(bvn, savedBvn);
        Bvn foundBvn = bvnRepository.findBvnById("3453432");
        assertEquals(bvn,foundBvn);
    }

    @Test
    void deleteBvn() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("3453432", customer);
        Bvn savedBvn = bvnRepository.save(bvn);
        assertEquals(bvn, savedBvn);
        assertNotNull(bvnRepository.findBvnById("3453432"));
        bvnRepository.deleteBvn("3453432");
        assertNull(bvnRepository.findBvnById("3453432"));

    }

    @Test
    void findAllBvn() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("3453432", customer);
       bvnRepository.save(bvn);
       bvnRepository.save(bvn);
       bvnRepository.save(bvn);
        assertEquals(3, bvnRepository.findAllBvn().size());


    }
}