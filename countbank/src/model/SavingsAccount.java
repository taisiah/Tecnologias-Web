package model;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SavingsAccount extends Account {
	
	private double tax ;
	
	
	public SavingsAccount(Long id, Integer number, Integer agency, Client client, Double balance,
			List<Transaction> transactions,Double tax ) {
		super(id, number, agency, client, balance, transactions);
		this.tax = tax;
		
	}

	public double addtax () {
		super.setBalance(super.getBalance() * ( tax/100) + super.getBalance());
		return super.getBalance();
	}

	
}
