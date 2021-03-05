package ru.mshassium.habitica_lite.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.mshassium.habitica_lite.db.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
}
