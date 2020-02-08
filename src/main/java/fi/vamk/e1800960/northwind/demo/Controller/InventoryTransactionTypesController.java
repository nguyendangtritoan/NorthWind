
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

public class InventoryTransactionTypesController {

	@Autowired

	private InventoryTransactionTypesRepository repository;
	
    @RequestMapping(value = "/InventoryTransactionTypes" , method = RequestMethod.POST)

    public @ResponseBody InventoryTransactionTypes create(@RequestBody InventoryTransactionTypes item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/InventoryTransactionTypes")

    public Iterable<InventoryTransactionTypes> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/InventoryTransactionTypes/{id}")

    public Optional<InventoryTransactionTypes> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/InventoryTransactionTypes" , method = RequestMethod.PUT)

    public @ResponseBody InventoryTransactionTypes update(@RequestBody InventoryTransactionTypes item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/InventoryTransactionTypes" , method = RequestMethod.DELETE)

    public void delete(@RequestBody InventoryTransactionTypes item) {

    	repository.delete(item);

        //do business logic

    } 

}
