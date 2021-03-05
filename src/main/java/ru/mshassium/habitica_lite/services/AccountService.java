package ru.mshassium.habitica_lite.services;

import org.springframework.stereotype.Service;
import ru.mshassium.habitica_lite.dao.AccountRepository;
import ru.mshassium.habitica_lite.db.model.Account;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return StreamSupport.stream(accountRepository.findAll().spliterator(), false).collect(Collectors.toList());
    }

    public Account createOrUpdate(Account account) {
        return accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    public Optional<Account> getById(Long id) {
        return accountRepository.findById(id);
    }
}
