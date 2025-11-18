package player;

public class Player { // You
    private String name;
    private boolean isAlive = true;
    private double balance;

    public Player(String name, double balance) { // Name and wallet
        this.name = name;
        this.balance = balance;
    }

    public String getName() { // Name for inheritance 
        return name;
    }

    public boolean isAlive() { // Check for pulse
        return isAlive;
    }

    public void setAlive(boolean status) { // Diagnosis
        this.isAlive = status;
    }

    public double getBal() { // Check gcash
        return balance;
    }

    public void addBalance(double amount) { // Cash in
        balance += amount;
    }

    public void subtractBalance(double amount) { // Cash out
        balance -= amount;
    }
}