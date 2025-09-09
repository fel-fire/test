package com.felfire.SpringBoorFirst;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@SpringBootApplication
public class SpringBoorFirstApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SpringBoorFirstApplication.class, args);
		Arrays.stream(ctx.getBeanDefinitionNames()).forEach(System.out::println);
	}

}
@Getter
class Coffee {
	private final String id;
	@Setter
	private String name;

	public Coffee(String id, String name) {
		this.id = id;
		this.name = name;
	}

	public Coffee(String name) {
		this(UUID.randomUUID().toString(), name);
	}
}

@RestController
@RequestMapping("/coffees")
class RestDemoApiController {
	private List<Coffee> coffees = new ArrayList<>();

	public RestDemoApiController() {
		coffees.addAll(List.of(
				new Coffee("Cafe Cereza"),
				new Coffee("Cafe Ganador"),
				new Coffee("Cafe Lareno"),
				new Coffee("Cafe Tres Pontas"),
				new Coffee("Cafe Nash Lyubimchik")
		));
	}
	@GetMapping
	Iterable<Coffee> getCoffees() {
		return coffees;
	}

	@GetMapping("/{id}")
	Optional<Coffee> getCoffeById(@PathVariable String id) {
		for (Coffee c : coffees) {
			if (c.getId().equals(id)) return Optional.of(c);
		}
		return Optional.empty();
	}

	@PostMapping
	Coffee postCoffee(@RequestParam Coffee coffee) {
		coffees.add(coffee);
		return coffee;
	}

	@PutMapping("/{id}")
	ResponseEntity<Coffee> putCoffee(@PathVariable String id, @RequestBody Coffee coffee) {
		int coffeeIndex = -1;
		for (Coffee c : coffees) {
			if (c.getId().equals(id)) {
				coffeeIndex = coffees.indexOf(c);
				coffees.set(coffeeIndex, coffee);
			}
		}
		return coffeeIndex == -1 ?
				new ResponseEntity<>(postCoffee(coffee), HttpStatus.CREATED) :
				new ResponseEntity<>(coffee, HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	void deleteCoffee(@PathVariable String id) {
		coffees.removeIf((c) -> c.getId().equals(id));
	}

}



