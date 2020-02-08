
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

public class PurchaseOrdersController {

	@Autowired

	private PurchaseOrdersRepository repository;
	
    @RequestMapping(value = "/PurchaseOrders" , method = RequestMethod.POST)

    public @ResponseBody PurchaseOrders create(@RequestBody PurchaseOrders item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/PurchaseOrders")

    public Iterable<PurchaseOrders> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/PurchaseOrders/{id}")

    public Optional<PurchaseOrders> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/PurchaseOrders" , method = RequestMethod.PUT)

    public @ResponseBody PurchaseOrders update(@RequestBody PurchaseOrders item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/PurchaseOrders" , method = RequestMethod.DELETE)

    public void delete(@RequestBody PurchaseOrders item) {

    	repository.delete(item);

        //do business logic

    } 

}
