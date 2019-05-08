package com.split.split.Controller;

import com.split.split.DAO.Accounts;
import com.split.split.DAO.Transactions;

import com.split.split.Service.AppService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequestMapping(value ="/v1" )
public class controller {
   @Autowired
    AppService appService;

//Get all Transactions
    @RequestMapping(method = RequestMethod.GET,value = "/trns")
    public List<Transactions>trnsList(){
        return appService.trnsList();
    }

//Get Account Balance for everyone
    @RequestMapping(method = RequestMethod.GET,value = "/acc")
    public List<Accounts>accountsList(){
    return appService.accountsList();
    }

//Add new member
    @RequestMapping(method = RequestMethod.POST,value = "/member")// add new member
    public void member(@RequestBody Accounts accounts){   appService.member(accounts);
    }


    @RequestMapping(method = RequestMethod.POST,value = "/new")  //adding new transaction
    public void postnew(@RequestBody Transactions transactions) throws Exception {
        appService.postnew(transactions);

    }

    @RequestMapping(method = RequestMethod.POST,value = "/new/all")  //adding new transaction
    public void posall(@RequestBody Transactions transactions) throws Exception {
        appService.postall(transactions);

    }

    @RequestMapping(method=RequestMethod.DELETE,value = "/deleteAcc")
    public void deleteall(){
        appService.deleteall();
    }

    @RequestMapping(method=RequestMethod.DELETE,value = "/deleteTrns")
    public void deleteallTrns(){
        appService.deleteallTrns();
    }

    //delete a transaction

    @RequestMapping(method=RequestMethod.DELETE,value = "/deleteTrns/{TrId}")
    public void del( @PathVariable String TrId){
          appService.del(TrId);

    }


}
