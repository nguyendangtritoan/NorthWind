
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

public class InvoicesController {

	@Autowired

	private InvoicesRepository repository;
	
    @RequestMapping(value = "/Invoices" , method = RequestMethod.POST)

    public @ResponseBody Invoices create(@RequestBody Invoices item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Invoices")

    public Iterable<Invoices> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Invoices/{id}")

    public Optional<Invoices> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Invoices" , method = RequestMethod.PUT)

    public @ResponseBody Invoices update(@RequestBody Invoices item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Invoices" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Invoices item) {

    	repository.delete(item);

        //do business logic

    } 

}
