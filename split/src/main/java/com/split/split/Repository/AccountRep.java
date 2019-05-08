package com.split.split.Repository;

import com.split.split.DAO.Accounts;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRep extends MongoRepository<Accounts,String> {

Accounts findByName(String name);

}
