package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;

public abstract class Account {
  protected String agency;
  protected String accountNumber;
  protected Integer digit;
  protected Double balance;
  protected Date openingDate;
  protected ArrayList<Transaction> transactions;
  protected Double MIN_VALUE = 10.0;


  //#region Personalized Constructor
  public Account(){}
  public Account(String agency, String accountNumber, Integer digit, Double openingBalance) {
    this.agency = agency;
    this.accountNumber = accountNumber;
    this.digit = digit;
    this.balance = openingBalance;
    this.openingDate = new Date();
    this.transactions = new ArrayList<Transaction>(); //Garante instância de array.

    //Criando primeira transação
    Transaction transaction = new Transaction("Abertura de conta", openingBalance );

    //salvando transação dentro do meu array transactions
    // Aqui se inicia o extrato bancário
    this.transactions.add(transaction);

  }

  //#endregion

  //#region Getters and Setters
  public String getAgency(){
    return agency;
  }

  public void setAgency(String agency){
    this.agency = agency;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public Integer getDigit() {
    return digit;
  }

  public void setDigit(Integer digit) {
    this.digit = digit;
  }

  public Double getBalance() {
    return balance;
  }

   public Date getOpeningDate() {
    return openingDate;
  }

  //#endregion

  //#region Methods

  public void deposit(Double value){
    if(value < MIN_VALUE){
      throw new InputMismatchException("Valor mínimo de depósito é R$:" + MIN_VALUE);
    }
    this.balance += value;

    //Registrando nova transação
    Transaction transaction = new Transaction("Depósito", value);
    this.transactions.add(transaction);
  }

  public Double withdraw(Double value){
    if(value > balance){
      throw new InputMismatchException("Saldo insuficiente.");
    }
    this.balance -= value;
    //Registrando nova transação
    Transaction transaction = new Transaction("Retirada de Valor", value);
    this.transactions.add(transaction);

    return value;
  }

  public void transfer(Double value, Account destinationAccount){
    this.withdraw(value);
    destinationAccount.deposit(value);
  }

  //Métodos abstratos não possuem implementação.
  public abstract void printTransaction();

  //#endregion

}
