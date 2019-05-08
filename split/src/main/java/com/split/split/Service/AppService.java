package com.split.split.Service;

import com.split.split.DAO.Accounts;
import com.split.split.DAO.Transactions;
import com.split.split.MailFactory.Generate;
import com.split.split.Repository.AccountRep;
import com.split.split.Repository.TransRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.stereotype.Service;


import javax.sql.rowset.spi.SyncResolver;
import java.util.List;

@ServletComponentScan
@Service
@EnableMongoAuditing
public class AppService {
    @Autowired
    Generate generate;

    @Autowired
    AccountRep accountRep;

    @Autowired
    TransRep transRep;


    public List<Transactions> trnsList() {return transRep.findAll();}


    public List<Accounts> accountsList() {

        return  accountRep.findAll();
    }

    public Accounts member(Accounts accounts) {
        return  accountRep.save(accounts);
    }

    public void postnew(Transactions transactions) throws Exception {
        transRep.save(transactions);
        String GB=transactions.getGivenBy(); //GB is GivenBy
        String TB =transactions.getTakenBy();// TB is Taken BY
        int Amount=transactions.getAmount();
        String amount=Integer.toString(Amount);

            Accounts ac1=accountRep.findByName(GB);
            generate.run(ac1.getMail()," You have given: "+amount+" to "+TB);
            ac1.setBalance(ac1.getBalance()+Amount);
            accountRep.save(ac1);

            Accounts ac2=accountRep.findByName(TB);
            ac2.setBalance(ac2.getBalance()-Amount);
            accountRep.save(ac2);

            generate.run(ac2.getMail(),GB+" has given you amount: "+amount);


    }

    public void deleteall() {
        accountRep.deleteAll();
    }

    public void deleteallTrns() {
        transRep.deleteAll();
    }

    public void del(String TrId) { transRep.deleteByTrId(TrId);}


    public void postall(Transactions transactions)throws  Exception {
        transRep.save(transactions);
        String GB=transactions.getGivenBy(); //GB is GivenBy
       // String TB =transactions.getTakenBy();// TB is Taken BY
        int Amount=transactions.getAmount();


        List<Accounts>accounts=accountRep.findAll();
        int DivAmount=(Amount/((int)accountRep.count()) );
        String divamount=Integer.toString(DivAmount);
        System.out.println("Check............"+divamount);
        for(Accounts it:accounts){
            if(it.getName()!=GB){
                it.setBalance(it.getBalance()-DivAmount);

                generate.run(it.getMail(),GB+" has given you amount: "+ divamount);
            }
            else if(it.getName()==GB){
                it.setBalance(it.getBalance()+DivAmount);

                generate.run(it.getMail(),"You have given All amount :"+ Amount);
            }

            accountRep.saveAll(accounts);
        }
    }
}
