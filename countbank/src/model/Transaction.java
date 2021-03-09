package model;
import lombok.Data;


@Data
public class Transaction {
	
	private Long account_id;
	private Double value;
	private String typeTransaction;
	private String dateTimeTransaction;
	private Double currentBalance;	

}
