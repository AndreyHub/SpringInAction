package tacos;

import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Taco {
	@NotNull
	@Size(min=5, message ="Имя должно быть не менее 5 символов")
	private String name;
	
	@NotNull
	@Size(min=1, message="Выберите не менее одного ингредиента")
	private List<Ingredient> ingredients;

}
