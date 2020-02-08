
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

public class EmployeePrivilegesController {

	@Autowired

	private EmployeePrivilegesRepository repository;
	
    @RequestMapping(value = "/EmployeePrivileges" , method = RequestMethod.POST)

    public @ResponseBody EmployeePrivileges create(@RequestBody EmployeePrivileges item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/EmployeePrivileges")

    public Iterable<EmployeePrivileges> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/EmployeePrivileges/{id}")

    public Optional<EmployeePrivileges> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/EmployeePrivileges" , method = RequestMethod.PUT)

    public @ResponseBody EmployeePrivileges update(@RequestBody EmployeePrivileges item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/EmployeePrivileges" , method = RequestMethod.DELETE)

    public void delete(@RequestBody EmployeePrivileges item) {

    	repository.delete(item);

        //do business logic

    } 

}
