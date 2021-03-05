package ru.mshassium.habitica_lite.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mshassium.habitica_lite.db.model.Account;
import ru.mshassium.habitica_lite.services.AccountService;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/getAll")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/get/{id}")
    public Account getById(@PathVariable Long id) {
        return accountService.getById(id).orElse(new Account());
    }

    @PostMapping(value = "/createOrUpdate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Account createOrUpdate(@RequestBody Account account) {
        return accountService.createOrUpdate(account);
    }

    @GetMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }

}
