package modernjavainaction.onlinetutorials.mementopattern;

class Memento
{
    public int balance;

    public Memento(int balance) {
        this.balance = balance;
    }
}

public class BankAccount {

    private int balance;

    public BankAccount(int balance) {
        this.balance = balance;
    }

    public Memento deposit(int amount) {
        balance += amount;
        return new Memento(balance);
    }

    public void restore(Memento m) {
        balance = m.balance;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return String.valueOf(balance);
    }

}

class Demo {
    public static void main(String[] args) {
        BankAccount ba = new BankAccount(100);
        Memento m1 = ba.deposit(50);
        Memento m2 = ba.deposit(20);
        System.out.println(ba);

        // restore to m1
        ba.restore(m1);
        System.out.println(ba);

        // restore to m2
        ba.restore(m2);
        System.out.println(ba);
    }
}
