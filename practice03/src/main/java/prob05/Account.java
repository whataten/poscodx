package prob05;

public class Account {

    private String accountNo;
    private int balance;

    public Account(String accountNum) {
        this.accountNo = accountNum;
        System.out.println(accountNum + "계좌가 개설되었습니다.");
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public void save(int i) {
        System.out.println(this.accountNo + "계좌에 " + Integer.toString(i) + "만원이 입금되었습니다.");
        this.balance += i;
    }

    public void deposit(int i) {
        System.out.println(this.accountNo + "계좌에 " + Integer.toString(i) + "만원이 출금되었습니다.");
        this.balance -= i;
    }
}
