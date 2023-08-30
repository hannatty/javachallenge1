import model.CurrentAccount;
import model.SavingAccount;
import utils.DataUtil;


public class App {
  public static void main(String[] args) {
    System.out.println("****************");
    System.out.println("Initializing...");
    System.out.println("****************");
    CurrentAccount my_account = new CurrentAccount("0001", "2020", 3, 100.0);
    System.out.println("Conta 1 foi criada com sucesso em " + my_account.getOpeningDate());
    System.out.println("Saldo atual de CONTA 1 é R$:" + my_account.getBalance());
    System.out.println("****************");
    SavingAccount account2 = new SavingAccount("0001", "2121", 3, 250.0);
    System.out.println("Conta 2 foi criada com sucesso.");
    System.out.println("Saldo atual de CONTA 2 é R$:" + account2.getBalance());
    account2.transfer(25.0, my_account);
    System.out.println("Saldo de CONTA 2 após transferência é de R$: " + account2.getBalance());
    System.out.println("****************");
    System.out.println("Conta 1 recebeu uma transferência e seu novo saldo é R$: " + my_account.getBalance());
    System.out.println("****************");
    
    var formated_date_conta_1 = DataUtil.formatDate(my_account.getOpeningDate());
    var formated_date_conta_2 = DataUtil.formatDate(account2.getOpeningDate());
    System.out.println("Conta 1 criada em: " + formated_date_conta_1);
    System.out.println("Conta 2 criada em: " + formated_date_conta_2);
    System.out.println("****************");
    System.out.println("TRANSAÇÕES");
    my_account.printTransaction();
    account2.printTransaction();


  }
}
