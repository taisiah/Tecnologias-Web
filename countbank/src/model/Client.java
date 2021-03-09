package model;
import lombok.Data;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
public class Client {
	private Long id;
	private String name;
	private String email;
	private String phone;
}
