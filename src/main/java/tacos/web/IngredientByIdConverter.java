package tacos.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import tacos.Ingredient;
import tacos.Ingredient.Type;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

	private Map<String,Ingredient> ingredientMap = new HashMap<>();
	
	public IngredientByIdConverter () {
		ingredientMap.put("FLTO", new Ingredient("FLTO", "Мучная лепешка", Type.WRAP));
		ingredientMap.put("COTO", new Ingredient("COTO", "Кукурузная лепешка", Type.WRAP));
		ingredientMap.put("GRBF", new Ingredient("GRBF", "Граунд Биф Tortila", Type.PROTEIN));
		ingredientMap.put("CARN", new Ingredient("CARN", "Карнитас", Type.PROTEIN));
		ingredientMap.put("TMTO", new Ingredient("TMTO", "Дисайд томатос", Type.VEGGIES));
		ingredientMap.put("LETC", new Ingredient("LETC", "Лэтусь", Type.VEGGIES));
		ingredientMap.put("CHED", new Ingredient("CHED", "Чедар", Type.CHEESE));
		ingredientMap.put("JACK", new Ingredient("JACK", "Монтерей Джек", Type.CHEESE));
		ingredientMap.put("SLSA", new Ingredient("SLSA", "Сальса", Type.SAUCE));
		ingredientMap.put("SRCR", new Ingredient("SRCR", "Соур Крем", Type.SAUCE));
	}
	
	@Override
	public Ingredient convert(String id) {
		return ingredientMap.get(id);
		 
	}

}
