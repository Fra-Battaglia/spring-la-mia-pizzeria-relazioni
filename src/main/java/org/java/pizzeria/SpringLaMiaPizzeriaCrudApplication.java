package org.java.pizzeria;

import java.time.LocalDate;

import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.pojo.Offer;
import org.java.pizzeria.service.OfferService;
import org.java.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;
	
	@Autowired 
	private OfferService offerService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("margherita", "che bella pizza", "https://vitaitaliantours.com.au/wp-content/uploads/2016/03/Neapolitan-Pizza-Margherita.jpg", 5.0f);
		Pizza p2 = new Pizza("diavola", "spicy", "https://www.silviocicchi.com/pizzachef/wp-content/uploads/2015/03/d2.jpg",6.0f);
		Pizza p3 = new Pizza("valtellina", "buona!", "https://recepten.be/wp-content/uploads/Pizza-Valtellina.jpg",7.0f);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
		
		Offer o1 = new Offer(LocalDate.parse("2023-09-21"), LocalDate.parse("2023-10-21"), "Fine Estate", 50.0f, p1);
		Offer o2 = new Offer(LocalDate.parse("2024-02-21"), LocalDate.parse("2024-03-21"), "Fine Inverno", 50.0f, p2);
		Offer o3 = new Offer(LocalDate.parse("2023-05-21"), LocalDate.parse("2023-06-21"), "Fine Primavera", 50.0f, p3);
		Offer o4 = new Offer(LocalDate.parse("2023-11-21"), LocalDate.parse("2023-12-21"), "Fine Autunno", 50.0f, p3);
		
		offerService.save(o1);
		offerService.save(o2);
		offerService.save(o3);
		offerService.save(o4);
	}

}
