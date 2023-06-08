package org.java.pizzeria.controller;

import org.java.pizzeria.pojo.Offer;
import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.service.OfferService;
import org.java.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OfferController {
	
	@Autowired
	private OfferService offerService;
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("pizza/{id}/offer/new")
	public String createNewOffer(@PathVariable int id, Model model) {
		Pizza pizza = pizzaService.findById(id).get();
		
		model.addAttribute("offer", new Offer());
		model.addAttribute("pizza", pizza);
		
		return "new-offer";
	}
	
	@PostMapping("pizza/{id}/offer/new")
	public String storeNewPizza(@PathVariable int id, @ModelAttribute Offer offer) {
		offerService.save(offer);
		
		return "redirect:/pizza/{id}";
	}
}
