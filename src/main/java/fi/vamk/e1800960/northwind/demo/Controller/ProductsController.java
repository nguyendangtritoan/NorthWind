
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

public class ProductsController {

	@Autowired

	private ProductsRepository repository;
	
    @RequestMapping(value = "/Products" , method = RequestMethod.POST)

    public @ResponseBody Products create(@RequestBody Products item) {

    	return repository.save(item);

    }  

	

    @RequestMapping("/Products")

    public Iterable<Products> municipalities(@RequestParam(value="name", defaultValue="World") String name) {

        return repository.findAll();

    }    

    

    @RequestMapping("/Products/{id}")

    public Optional<Products> get(@PathVariable("id") int id) {
        return repository.findById(id);
    }    



    @RequestMapping(value = "/Products" , method = RequestMethod.PUT)

    public @ResponseBody Products update(@RequestBody Products item) {

    	return repository.save(item);

    } 

    

    @RequestMapping(value = "/Products" , method = RequestMethod.DELETE)

    public void delete(@RequestBody Products item) {

    	repository.delete(item);

        //do business logic

    } 

}
