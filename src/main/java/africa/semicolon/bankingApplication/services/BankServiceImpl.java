package africa.semicolon.bankingApplication.services;

import africa.semicolon.bankingApplication.data.models.Account;
import africa.semicolon.bankingApplication.data.models.Bank;
import africa.semicolon.bankingApplication.data.models.Customer;
import africa.semicolon.bankingApplication.data.respositories.BankRepository;
import africa.semicolon.bankingApplication.data.respositories.BankRepositoryImpl;
import africa.semicolon.bankingApplication.dtos.request.CreateAccountRequest;

import java.util.List;

public class BankServiceImpl implements BankServices{
    private final BankRepository bankRepository = new BankRepositoryImpl();
    private final CustomerServices customerServices = new CustomerServicesImpl();
//    private int lastBankCreated =0;

    @Override
    public String createBank(String bankName) {
        String bankId = generateBankid();
        Bank bank = new Bank(bankId);
        bank.setName(bankName);
        Bank savedBank = bankRepository.save(bank);
        return savedBank.getId();
    }

    @Override
    public List<Bank> findAllBanks() {
        return bankRepository.findAllBank();
    }

    @Override
    public String createAccount(CreateAccountRequest createAccountRequest) {
        String bankId = createAccountRequest.getBankId();
        String accountNumber = generateSurffixFor(bankId);
        Customer customer = new Customer();

        Account account = new Account();
        account.setNumber(bankId + accountNumber);
        account.setType(createAccountRequest.getAccountType());

        customer.setFirstName(createAccountRequest.getFirstName());
        customer.setLastName(createAccountRequest.getLastName());
        customer.getAccounts().add(account);
        customer.setBvn("78537093322");
        customerServices.addNew(customer);

        Bank bank = bankRepository.findBankByid(bankId);
        bank.getAccounts().add(account);
        bankRepository.save(bank);
        return account.getNumber();

//        String accountSurffix = String.format("%08d", ++lastAccountNumber);

    }
    private String generateSurffixFor(String bankId){
        Bank bank = bankRepository.findBankByid(bankId);
        int lastNumber = bank.getAccounts().size();
        return String.format("%08d", ++lastNumber);
    }

    private String generateBankid(){
        int lastBankIdCreated = findAllBanks().size();
        return String.format("%02d", ++lastBankIdCreated);
    }
}
