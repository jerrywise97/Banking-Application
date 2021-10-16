package africa.semicolon.bankingApplication.data.respositories;

import africa.semicolon.bankingApplication.data.models.Bvn;
import africa.semicolon.bankingApplication.data.models.Customer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerRepositoryImplTest {
    private CustomerRepository customerRepository;

    @BeforeEach
    void setUp() {
        customerRepository = new CustomerRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("4586332", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("jerry");
        customer.setLastName("chuks");
        Customer savedCustomer = customerRepository.save(customer);
        assertEquals(customer, savedCustomer);
    }

    @Test
    void findByCustomer() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("4586332", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("jerry");
        customer.setLastName("chuks");
        customerRepository.save(customer);
        Customer foundCustomer = customerRepository.findByCustomerId("4586332");
        assertEquals(customer, foundCustomer);
    }

    @Test
    void delete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("4586332", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("jerry");
        customer.setLastName("chuks");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("4586332"));
        customerRepository.delete(customer);
        assertNull(customerRepository.findByCustomerId("4586332"));


    }

    @Test
    void testDelete() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("4586332", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("jerry");
        customer.setLastName("chuks");
        customerRepository.save(customer);
        assertNotNull(customerRepository.findByCustomerId("4586332"));
        customerRepository.delete("4586332");
        assertNull(customerRepository.findByCustomerId("4586332"));
    }

    @Test
    void findAll() {
        Customer customer = new Customer();
        Bvn bvn = new Bvn("4586332", customer);
        customer.setBvn(bvn.getId());
        customer.setFirstName("jerry");
        customer.setLastName("chuks");
        customerRepository.save(customer);
        customerRepository.save(customer);
        customerRepository.save(customer);
        assertEquals(3, customerRepository.findAll().size());

    }
}