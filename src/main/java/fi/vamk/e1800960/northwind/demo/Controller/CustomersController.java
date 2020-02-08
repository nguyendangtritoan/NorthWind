
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

public class CustomersController {

	@Autowired

	private CustomersRepository repository;
	
    @RequestMapping(value = "/Customers" , method = RequestMethod.POST)

    public @ResponseBody Customers create(@RequestBody Customers item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Customers")

    public Iterable<Customers> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Customers/{id}")

    public Optional<Customers> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Customers" , method = RequestMethod.PUT)

    public @ResponseBody Customers update(@RequestBody Customers item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Customers" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Customers item) {

    	repository.delete(item);

        //do business logic

    } 

}
