package tacos;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.validator.constraints.CreditCardNumber;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class TacoOrder {

	@NotBlank(message = "Имя доставки обязательно должно быть заполнено")
	private String deliveryName;
	
	@NotBlank (message = "Укажите улицу")
	private String deliveryStreet;
	
	@NotBlank (message = "Укажите город")
	private String deliveryCity;
	
	@NotBlank (message = "Укажите регион")
	private String deliveryState;
	
	@NotBlank (message = "Укажите код")
	private String deliveryZip;
	
	@CreditCardNumber(message = "Не корректный номер карты")
	private String ccNumber;
	
	@Pattern(regexp="^(0[1-9][1[0-2])([\\/])([2-9][0-9])$", message="Не корректнаф дата")	
	private String ccExpiration;
	
	@Digits (integer=3, fraction=0, message = "Не корректный код CW")
	private String ccCW;
	
	private List <Taco> tacos = new ArrayList();
	
	public void addTaco(Taco taco) {
		this.tacos.add(taco);
	}

}
