
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

public class SalesReportsController {

	@Autowired

	private SalesReportsRepository repository;
	
    @RequestMapping(value = "/SalesReports" , method = RequestMethod.POST)

    public @ResponseBody SalesReports create(@RequestBody SalesReports item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/SalesReports")

    public Iterable<SalesReports> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/SalesReports/{id}")

    public Optional<SalesReports> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/SalesReports" , method = RequestMethod.PUT)

    public @ResponseBody SalesReports update(@RequestBody SalesReports item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/SalesReports" , method = RequestMethod.DELETE)

    public void delete(@RequestBody SalesReports item) {

    	repository.delete(item);

        //do business logic

    } 

}
