
package fi.vamk.e1800960.northwind.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.bind.annotation.RestController;

import fi.vamk.e1800960.northwind.demo.Entity.*;
import fi.vamk.e1800960.northwind.demo.Repo.*;


@RestController

public class InventoryTransactionsController {

	@Autowired

	private InventoryTransactionsRepository repository;
	
    @RequestMapping(value = "/InventoryTransactions" , method = RequestMethod.POST)

    public @ResponseBody InventoryTransactions create(@RequestBody InventoryTransactions item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/InventoryTransactions")

    public Iterable<InventoryTransactions> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/InventoryTransactions/{id}")

    public Optional<InventoryTransactions> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/InventoryTransactions" , method = RequestMethod.PUT)

    public @ResponseBody InventoryTransactions update(@RequestBody InventoryTransactions item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/InventoryTransactions" , method = RequestMethod.DELETE)

    public void delete(@RequestBody InventoryTransactions item) {

    	repository.delete(item);

        //do business logic

    } 

}
