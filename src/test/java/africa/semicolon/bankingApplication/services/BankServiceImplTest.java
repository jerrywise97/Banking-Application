package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.AccountType;
import africa.semicolon.bankingApplication.data.respositories.CustomerRepository;
import africa.semicolon.bankingApplication.data.respositories.CustomerRepositoryImpl;
import africa.semicolon.bankingApplication.dtos.request.CreateAccountRequest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceImplTest {
    BankServices bankServices;
    CustomerRepositoryImpl customerRepository;

    @BeforeEach
    void setUp() {
        bankServices = new BankServiceImpl();
    }

    @AfterEach
    void tearDown() {
        bankServices = null;
        customerRepository = null;

    }

    @Test
    void createBank() {
        //when
       String bankId = bankServices.createBank("GTCO");
       assertEquals("01", bankId);
    }

    @Test
    void createTwoBank_whenIAddAnotherBank(){
        //when
        String gtcoId = bankServices.createBank("GTCO");
        String firstBankId = bankServices.createBank("firstBank");
        assertEquals("01", gtcoId);
        assertEquals("02", firstBankId);
    }
    @Test
    void createTwo_repositoryShouldHave2banks(){
        //when
        String gtcoId = bankServices.createBank("GTCO");
        String firstBankid = bankServices.createBank("first Bank");
        assertEquals("01", gtcoId);
        assertEquals("02", firstBankid);
        assertEquals(2,bankServices.findAllBanks().size());
        System.out.println(bankServices.findAllBanks());
    }
//    @Test
    //static variables dont die with with object it dies with the class
    //inatnce variable dies when the object dies.

    @Test
    void bankCanCreatAccountForCustomer_test(){
        String gtCoId = bankServices.createBank("GTCO");
        //when
        CreateAccountRequest agbaForm = new CreateAccountRequest();
        agbaForm.setFirstName("Agba");
        agbaForm.setFirstName("jerry");
        agbaForm.setBankId("01");
        agbaForm.setAccountType(AccountType.CURRENT);
        String accountNumber =bankServices.createAccount(agbaForm);
        //asssert
        assertEquals("0100000001", accountNumber);
    }
    @Test
    void createTwoAccoountInBank_accNumberShouldBe02(){
        String gtCoId = bankServices.createBank("GTCO");
        //when
        CreateAccountRequest agbaForm = new CreateAccountRequest();
        agbaForm.setFirstName("Agba");
        agbaForm.setFirstName("jerry");
        agbaForm.setBankId("01");
        agbaForm.setAccountType(AccountType.CURRENT);

        CreateAccountRequest elonForm = new CreateAccountRequest();
        elonForm.setFirstName("elon");
        elonForm.setFirstName("musk");
        elonForm.setBankId("01");
        elonForm.setAccountType(AccountType.CURRENT);
        String agbaAccountNumber =bankServices.createAccount(elonForm);
        String elonAccountNumber =bankServices.createAccount(elonForm);
        //asssert
        assertEquals("0100000001", agbaAccountNumber);
        assertEquals("0100000002", elonAccountNumber);
    }
    @Test
    void createTwoAccoountInBank1_andOneAccountInBank2_accNumberShouldBe01(){
        String gtCoId = bankServices.createBank("GTCO");
        String firstBank = bankServices.createBank("First Bank");
        //when
        CreateAccountRequest agbaform = new CreateAccountRequest();
        agbaform.setFirstName("Agba");
        agbaform.setFirstName("jerry");
        agbaform.setBankId("01");
        agbaform.setAccountType(AccountType.CURRENT);

        CreateAccountRequest elonForm = new CreateAccountRequest();
        elonForm.setFirstName("elon");
        elonForm.setFirstName("jerry");
        elonForm.setBankId("01");
        elonForm.setAccountType(AccountType.CURRENT);

        CreateAccountRequest chuksForm = new CreateAccountRequest();
        chuksForm.setFirstName("chuks");
        chuksForm.setFirstName("jerry");
        chuksForm.setBankId("02");
        chuksForm.setAccountType(AccountType.CURRENT);
        String agbaAccountNumber =bankServices.createAccount(agbaform);
        String elonAccountNumber =bankServices.createAccount(elonForm);
        String jerryAccountNumber =bankServices.createAccount(chuksForm);
        //asssert
        assertEquals("0100000001", agbaAccountNumber);
        assertEquals("0100000002", elonAccountNumber);
        assertEquals("0200000001", jerryAccountNumber);
    }
    @Test
    @Order(1)
    void whenAccountIsCreated_customerIscreated(){
        String gtCoId = bankServices.createBank("GTCO");
        CreateAccountRequest agbaForm = new CreateAccountRequest();
        agbaForm.setFirstName("Agba");
        agbaForm.setFirstName("jerry");
        agbaForm.setBankId("01");
        agbaForm.setAccountType(AccountType.CURRENT);
        bankServices.createAccount(agbaForm);
        CustomerServices customerServices = new CustomerServicesImpl();
        assertEquals(1, customerServices.findAll().size());
    }



}