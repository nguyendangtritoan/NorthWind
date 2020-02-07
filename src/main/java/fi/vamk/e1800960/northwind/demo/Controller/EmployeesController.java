
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

public class EmployeesController {

	@Autowired

	private EmployeesRepository repository;
	
    @RequestMapping(value = "/Employees" , method = RequestMethod.POST)

    public @ResponseBody Employees create(@RequestBody Employees item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Employees")

    public Iterable<Employees> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Employees/{id}")

    public Optional<Employees> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Employees" , method = RequestMethod.PUT)

    public @ResponseBody Employees update(@RequestBody Employees item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Employees" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Employees item) {

    	repository.delete(item);

        //do business logic

    } 

}
