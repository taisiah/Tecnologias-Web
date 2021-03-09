package view;
import lombok.Data;
import model.Client;
import model.CurrentAccount;
import model.SavingsAccount;

public class Main {
	
	public static void main(String[] args) {
		
		Client client = new Client(1L,"th@gmail.com","Taisia Honorio","83 9 96603238");

		
		CurrentAccount currentaccount = new CurrentAccount();
		currentaccount.setId(1L);
		currentaccount.setAgency(001);
		currentaccount.setNumber(100);
		currentaccount.setClient(client);
		currentaccount.setBalance(510.0);
		
		SavingsAccount  savingsaccount= new SavingsAccount();
		savingsaccount.setId(2L);
		savingsaccount.setAgency(001);
		savingsaccount.setNumber(102);
		savingsaccount.setClient(client);
		savingsaccount.setBalance(100.0);
		savingsaccount.setTax(2.00);
		
				
		
		
		currentaccount.deposit(100.0);
		System.out.println("Depósito efetuado com sucesso!");
		
		
		if (currentaccount.withdraw(150.0)== true) {
			System.out.println("Saque efetuado com sucesso!");		
		}
		else {
			System.out.println("O saldo é insuficiente!");	
		}
		
		
		if (currentaccount.transfer(150.0, savingsaccount)== true) {
			System.out.println("Transferência realizada!");	
		}
		else {
			System.out.println("O saldo é insuficiente!");
		}
		
		
		
		System.out.println("O saldo da conta corrente é: "+ currentaccount.getBalance());
		
		
		
		currentaccount.printTransactions();
		savingsaccount.printTransactions();
		
		
		
		
		System.out.println("O saldo da conta poupança é: "+ savingsaccount.getBalance());
		
		savingsaccount.addtax();
		
		System.out.println("O saldo da conta poupança é: "+ savingsaccount.getBalance());
		
	}
	
	
}
