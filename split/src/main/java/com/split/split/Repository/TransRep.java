package com.split.split.Repository;

import com.split.split.DAO.Transactions;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TransRep extends MongoRepository<Transactions,String> {
Transactions findByTrId(String TrId);
Transactions deleteByTrId(String TrId);
}
