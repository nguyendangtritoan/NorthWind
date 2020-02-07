
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

public class PurchaseOrderDetailsController {

	@Autowired

	private PurchaseOrderDetailsRepository repository;
	
    @RequestMapping(value = "/PurchaseOrderDetails" , method = RequestMethod.POST)

    public @ResponseBody PurchaseOrderDetails create(@RequestBody PurchaseOrderDetails item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/PurchaseOrderDetails")

    public Iterable<PurchaseOrderDetails> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/PurchaseOrderDetails/{id}")

    public Optional<PurchaseOrderDetails> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/PurchaseOrderDetails" , method = RequestMethod.PUT)

    public @ResponseBody PurchaseOrderDetails update(@RequestBody PurchaseOrderDetails item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/PurchaseOrderDetails" , method = RequestMethod.DELETE)

    public void delete(@RequestBody PurchaseOrderDetails item) {

    	repository.delete(item);

        //do business logic

    } 

}
