package tacos.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import lombok.extern.slf4j.Slf4j;
import tacos.Ingredient;
import tacos.Ingredient.Type;
import tacos.Taco;
import tacos.TacoOrder;

@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("tacoOrder")
public class DesignTacoController {

	@ModelAttribute
	public void addIngredientsToModel (Model model) {
		
		List<Ingredient> ingredients = Arrays.asList(
				new Ingredient("FLTO", "Мучная лепешка", Type.WRAP),
				new Ingredient("COTO", "Кукурузная лепешка", Type.WRAP),
				new Ingredient("GRBF", "Граунд Биф Tortila", Type.PROTEIN),
				new Ingredient("CARN", "Карнитас", Type.PROTEIN),
				new Ingredient("TMTO", "Дисайд томатос", Type.VEGGIES),
				new Ingredient("LETC", "Лэтусь", Type.VEGGIES),
				new Ingredient("CHED", "Чедар", Type.CHEESE),
				new Ingredient("JACK", "Монтерей Джек", Type.CHEESE),
				new Ingredient("SLSA", "Сальса", Type.SAUCE),
				new Ingredient("SRCR", "Соур Крем", Type.SAUCE)
				);
		
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(),
			filterByType(ingredients, type));
		}
		
	}
	
	@ModelAttribute(name="tacoOrder")
	public TacoOrder order () {
		return new TacoOrder();
	}
	
	
	@ModelAttribute(name="taco")
	public Taco taco() {
		return new Taco();
	}
	
	@GetMapping
	public String ShowDesignForm() {
		return "design";
	}
	
	@PostMapping
	public String processTaco (Taco taco, @ModelAttribute TacoOrder tacoOrder) {

		tacoOrder.addTaco(taco);
		log.info("Processing taco: {}", taco);
		return "redirect:/orders/current";
	}
	private Iterable<Ingredient> filterByType (List<Ingredient> ingredients, Type type){
		
		return ingredients.stream().filter(x->x.getType().equals(type)).collect(Collectors.toList());
	}
	
}
