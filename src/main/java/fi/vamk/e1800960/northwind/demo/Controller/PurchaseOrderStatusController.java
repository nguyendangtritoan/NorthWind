
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

public class PurchaseOrderStatusController {

	@Autowired

	private PurchaseOrderStatusRepository repository;
	
    @RequestMapping(value = "/PurchaseOrderStatus" , method = RequestMethod.POST)

    public @ResponseBody PurchaseOrderStatus create(@RequestBody PurchaseOrderStatus item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/PurchaseOrderStatus")

    public Iterable<PurchaseOrderStatus> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/PurchaseOrderStatus/{id}")

    public Optional<PurchaseOrderStatus> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/PurchaseOrderStatus" , method = RequestMethod.PUT)

    public @ResponseBody PurchaseOrderStatus update(@RequestBody PurchaseOrderStatus item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/PurchaseOrderStatus" , method = RequestMethod.DELETE)

    public void delete(@RequestBody PurchaseOrderStatus item) {

    	repository.delete(item);

        //do business logic

    } 

}
