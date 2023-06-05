package org.java.pizzeria;

import org.java.pizzeria.pojo.Pizza;
import org.java.pizzeria.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	
	@Autowired
	private PizzaService pizzaService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		
		Pizza p1 = new Pizza("margherita", "che bella pizza", 
					"https://vitaitaliantours.com.au/wp-content/uploads/2016/03/Neapolitan-Pizza-Margherita.jpg", 
					5.0f);
		Pizza p2 = new Pizza("diavola", "spicy",
					"https://www.silviocicchi.com/pizzachef/wp-content/uploads/2015/03/d2.jpg",
					6.0f);
		Pizza p3 = new Pizza("valtellina", "buona!",
				"https://recepten.be/wp-content/uploads/Pizza-Valtellina.jpg",
				7.0f);
		
		pizzaService.save(p1);
		pizzaService.save(p2);
		pizzaService.save(p3);
	}

}
