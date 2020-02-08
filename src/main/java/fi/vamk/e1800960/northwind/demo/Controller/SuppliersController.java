
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

public class SuppliersController {

	@Autowired

	private SuppliersRepository repository;
	
    @RequestMapping(value = "/Suppliers" , method = RequestMethod.POST)

    public @ResponseBody Suppliers create(@RequestBody Suppliers item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Suppliers")

    public Iterable<Suppliers> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Suppliers/{id}")

    public Optional<Suppliers> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Suppliers" , method = RequestMethod.PUT)

    public @ResponseBody Suppliers update(@RequestBody Suppliers item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Suppliers" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Suppliers item) {

    	repository.delete(item);

        //do business logic

    } 

}
