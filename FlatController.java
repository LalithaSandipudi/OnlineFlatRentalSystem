package com.cg.ofr.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.ofr.entities.Flat;
import com.cg.ofr.exception.FlatNotFoundException;
import com.cg.ofr.service.FlatService;

@RestController 
@RequestMapping("/FlatDetails")
public class FlatController {
	@Autowired
	private FlatService flatService;
	
	
	@PostMapping
	public List<Flat> addFlat(@RequestBody Flat flat) {
		return flatService.addFlat(flat);
	}
	
	@PutMapping("/flatId/{newcost}")
	public List<Flat>updateCost(@PathVariable("flatId")Integer flatId,@PathVariable("newCost")Double cost) throws FlatNotFoundException{
		return flatService.updateFlat(flatId,cost);
	}
	@DeleteMapping("/flatId/{Id}")
	public List<Flat>deleteFlat(@PathVariable("flatId")Integer flatId)throws FlatNotFoundException{
	
		return flatService.deleteFlat(flatId);
	}
	@GetMapping("/flatId/{Id}")
	public Flat viewFlatById(@PathVariable("flatId")Integer flatId)throws FlatNotFoundException {
		return flatService.viewFlat(flatId);
	}
	@GetMapping("/viewAllFlat")
	public List<Flat>viewAllFlat(){
		return flatService.viewAllFlat();
	}
	@GetMapping ("/viewAllFlatByCostAndAvailability")
	public List<Flat> findByCostAndAvailability(@PathVariable("cost")Double cost,@PathVariable("availability")String availability){
		return flatService.findByCostAndAvailability(cost, availability);
	}

}
