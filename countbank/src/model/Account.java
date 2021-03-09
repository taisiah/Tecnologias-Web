package model;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor

public abstract class Account {
	private Long id;
	private Integer number;
	private Integer agency;
	private Client client ; 
	private Double balance;
	private List<Transaction> transactions = new ArrayList<Transaction>();
	
	
	public boolean withdraw (Double value) {
		if( value <= balance ) {
			balance -= value;
			this.transactions.add(createTransaction(this,-value,"Saque       ",LocalDateTime.now()));
			return true;
		}
		else {
			return false;
		}
	}
	
	private boolean withdrawTransfer (Double value) {
		if( value <= balance ) {
			balance -= value;
			this.transactions.add(createTransaction(this,-value,"Transf. Env.",LocalDateTime.now()));
			return true;
		}
		else {
			return false;
		}
	}
	
	

	public boolean transfer (Double value,Account account) {
		boolean withdraw_status = withdrawTransfer(value);	
		if (withdraw_status== true) { 
			account.depositTransfer(value);
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public double deposit (Double value) {
		balance += value;
		this.transactions.add(createTransaction(this,value,"Depósito     ",LocalDateTime.now()));
		return balance;
	}
	
	private double depositTransfer (Double value) {
		balance += value;
		this.transactions.add(createTransaction(this,value,"Transf.Rec.  ",LocalDateTime.now()));
		return balance ;
	}
	
	
	public List<Transaction> transactions(){
		return this.transactions;
	}
	
	private Transaction createTransaction(Account account,Double value,String typeTransaction,LocalDateTime dateTimeTransaction) {
		Transaction transaction = new Transaction ();
		transaction.setAccount_id(account.getId());
		transaction.setValue(value);
		transaction.setTypeTransaction(typeTransaction);
		transaction.setDateTimeTransaction(formatDate(LocalDateTime.now()));
		transaction.setCurrentBalance(balance);
		
		return transaction;
	}
	
	
	
	public void printTransactions () {
		
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("EXTRATO     CONTA: "+ number  +"     AGENCIA: "+ agency );
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("   DATA     HORA            TRANSAÇÃO                 VALOR         CONTA            SALDO");
		System.out.println("------------------------------------------------------------------------------------------");
		for(int i=0 ;i<getTransactions().size() ;i++) { 
			System.out.println(getTransactions().get(i).getDateTimeTransaction() + "         " +
		    getTransactions().get(i).getTypeTransaction() + "              " +
		    getTransactions().get(i).getValue() +"          " +
			getTransactions().get(i).getAccount_id() + "             "+ 
			getTransactions().get(i).getCurrentBalance()); 
			System.out.println("------------------------------------------------------------------------------------------");
			
			
		}
		
		
	}
	
	
	private String formatDate(LocalDateTime date) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
		String dateNow = date.format(formatter);
		return dateNow;
	}
	
	
		
	
}
