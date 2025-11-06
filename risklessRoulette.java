import java.util.Random;
import java.util.Scanner;

public class risklessRoulette {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Riskless Roulette! You get to play without any risk!");
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        Player player = new Player(name, 1000.0);
        Gun gun = null;

        while (player.isAlive() && player.getBal() > 0) { // Playing
            System.out.println("\nYour balance: ₱" + player.getBal());
            System.out.println("Choose your weapon:");
            System.out.println("1. Revolver (6 chambers, x1.5 per chamber)");
            System.out.println("2. Double Barrel Shotgun (2 chambers, high risk, x3 per chamber)");
            System.out.println("3. Pistol (36 chambers, extremely high risk, x5 per chamber)");

            int gunChoice = InputChecker.gunCheck(sc, "Enter Choice: ");

            switch (gunChoice) { // Pick a gun
                case 1:
                    gun = new Revolver();
                    break;
                case 2:
                    gun = new DoubleBarrel();
                    break;
                case 3:
                    gun = new Pistol();
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please pick a number from above.");
                    continue;
            }
            
            double bet = InputChecker.betCheck(sc, player, "\nEnter your bet amount: ₱");   
            
            int bullets = InputChecker.bulletCheck(sc, gun, "How many bullets would you like to chamber?: ");
            
            gun.load();

            boolean pull = InputChecker.yesNoCheck(sc, "\nPull the trigger? (y/n): ");            
            System.out.print("\n");
            if (pull) { // Play
                boolean cont = true;
                while (cont) { // Continous play
                    if (gunChoice == 3) { // Pistol
                        System.out.println("Bang! The " + gun.getGunName() + " fired!\n");
                        System.out.println("You're dead! Tanga pistol yan, anong expected mo?");
                        player.setAlive(false);
                        player.subtractBalance(player.getBal());
                        break;
                    }
                    if (gun.fire()) { // Boom headshot
                        System.out.println("The " + gun.getGunName() + " fired!\n");
                        System.out.println("The bullet went through your head. You died!");
                        player.setAlive(false);
                        player.subtractBalance(player.getBal());
                        break;
                    }
                    else { // Suerte
                        double winnings = bet * gun.rewardMult();
                        System.out.println("Click! No bullet in the chamber. You live!\n");
                        System.out.println("You won ₱" + winnings + "!");
                        player.addBalance(winnings);
                    }

                    cont = InputChecker.yesNoCheck(sc, "\nContinue? (y/n): ");
            
                    if (!cont){ // Quitter
                        break;
                    }

                    System.out.print("\n");
                }
            }
            else { // Duwag
                System.out.println("You backed out this round. No bet placed.");
            }

            if (!player.isAlive()){ // Boom headshot
                break;
            }
            if (player.getBal() <= 0) { // Bankrupt
                System.out.println("\nYou ran out of money. Game over!");
                player.setAlive(false);
            }

            Boolean again = InputChecker.yesNoCheck(sc, "Do you want to play another round? (y/n): ");
            if (!again){ // Player said no
                break;  
            }

            System.out.print("\n");
            }
        
        System.out.println("\nFinal Balance: ₱" + player.getBal());
        System.out.println("Thanks for playing, " + player.getName() + "!");
        sc.close();
    }
}

class InputChecker {
    public static double betCheck(Scanner sc, Player player, String say) {
        double bet;
        while (true) { // Checking bet
            System.out.print(say);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) { // Only  space
                System.out.println("❌ Input cannot be empty.\n");
                continue;
            }
            if (input.contains(" ")) { // No space
                System.out.println("❌ Invalid input. No spaces allowed.\n");
                continue;
            }

            try { // Try
                bet = Double.parseDouble(input);
            }
            catch (NumberFormatException err) { // Catch
                System.out.println("❌ Invalid input. Please enter a number.\n");
                continue;
            }

            if (bet <= 0) { // Broke ass bitch
                System.out.println("❌ Invalid bet. You cannot bet nothing or negative amounts.\n");
            }
            else if (bet > player.getBal()) { // Low credit score
                System.out.println("❌ Invalid bet. Must be between ₱1 and your balance (₱" + player.getBal() + ").\n");
            }
            else { // Good bet
                return bet;
            }
        }
    }

    public static Boolean yesNoCheck(Scanner sc, String say) {
        String input;
        while (true) { // Checking string
            System.out.print(say);
            input = sc.nextLine().trim();

            if (input.isEmpty()) { // Only space
                System.out.println("❌ Input cannot be empty.\n");
                continue;
            }
            if (input.contains(" ")) { // No space
                System.out.println("❌ Invalid input. No spaces allowed.\n");
                continue;
            }

            if (input.equalsIgnoreCase("y") || input.equalsIgnoreCase("n")) { // Goods
                if (input.equalsIgnoreCase("y")){
                    return true;
                }
                else{
                    return false;
                }
            }

            System.out.println("❌ Invalid input. \"Y\" or \"N\" only.\n");
        }
    }

    public static int bulletCheck(Scanner sc, Gun gun, String say){
        int bullet;
        while (true) { // Checking bullets
            System.out.print(say);
            String input = sc.nextLine().trim();

            if (input.isEmpty()) { // Only space
                System.out.println("❌ Input cannot be empty.\n");
                continue;
            }
            if (input.contains(" ")) { // No space
                System.out.println("❌ Invalid input. No spaces allowed.\n");
                continue;
            }

            try { // Try
                bullet = Integer.parseInt(input);
            }
            catch (NumberFormatException err) { // Catch
                System.out.println("❌ Invalid input. Please enter a number.\n");
                continue;
            }

            if (bullet <= 0) { // Lol nice try
                System.out.println("❌ Invalid. You must load at least 1 bullet.\n");
            }
            else if (bullet > gun.getTotCham()) { // Too optimistic
                System.out.println("❌ Invalid. Must be between 1 and (" + gun.getTotCham() + ").\n");
            }
            else { // Goods
                return bullet;
            }
        }
    }

    public static int gunCheck(Scanner sc, String say) {
        int gunChoice;
        
        while (true) { // Checking Gun Choice
            System.out.print(say);
            String input = sc.nextLine().trim();
                if (input.isEmpty()) { // Only space
                    System.out.println("❌ Input cannot be empty.\n");
                continue;
                }
                if (input.contains(" ")) { // No space
                    System.out.println("❌ Invalid input. No spaces allowed.\n");
                    continue;
                }

                try { // Try
                    gunChoice = Integer.parseInt(input);
                }
                catch (NumberFormatException e) { // Catch
                    System.out.println("❌ Invalid input. Please enter a number.\n");
                    continue;
                }

                if (gunChoice <= 0 || gunChoice >4) { // Wait for updates
                    System.out.println("❌ Invalid choice! Choose only from the given choices\n");
                }
                else { // Goods
                    return gunChoice;
                }
            }
    }
}

abstract class Gun {
    public int getTotCham() {
        return totCham;
    }

    protected int totCham;
    protected int bullPos;
    protected Random random = new Random();

    public abstract int bullets();
    public abstract void load();
    public abstract boolean fire();
    public abstract String getGunName();
    public abstract double rewardMult();
}

class Revolver extends Gun { // Revolver
    public Revolver() { // Revolver mag size
        totCham = 6;
    }

    @Override
    public int bullets(){ // How many bullets
        Scanner sc = new Scanner(System.in);
        return InputChecker.bulletCheck(sc, this, "Load how many bullets (x2 multiplier for each bullet)?: ");
    }

    @Override
    public void load() { // Load gun
        bullPos = random.nextInt(totCham);
        System.out.println("\nRevolver loaded.");
    }

    @Override
    public boolean fire() { // Bang!
        int bullets = bullets();
        Random rand = new Random();
        boolean[] chamber = new boolean[totCham];
        
        int bulletsChambed = 0;
        while (bulletsChambed < bullets) { // Inserting bullets
            int pos = rand.nextInt(totCham);
            if (!chamber[pos]) {
                chamber[pos] = true;
                bulletsChambed++;
            }
        }

        int firePos = rand.nextInt(totCham);
        return chamber[firePos];
    }


    @Override
    public String getGunName() { // Name
        return "Revolver";
    }

    @Override
    public double rewardMult() { // Reward
        return 1.5;
    }
}

class DoubleBarrel extends Gun { // Double Barrel
    public DoubleBarrel() { // Two chambers
        totCham = 2;
    }

    @Override
    public int bullets(){ // How many bullets
        Scanner sc = new Scanner(System.in);
        return InputChecker.bulletCheck(sc, this, "Load how many bullets (x2 multiplier for each bullet)?: ");
    }

    @Override
    public void load() { // 50%
        bullPos = random.nextInt(totCham);
        System.out.println("\nDouble Barrel Shotgun loaded.");
    }

    @Override
    public boolean fire() { // Bang!
        int bullets = bullets();
        Random rand = new Random();
        boolean[] chamber = new boolean[totCham];
        
        int bulletsChambed = 0;
        while (bulletsChambed < bullets) { // Inserting bullets
            int pos = rand.nextInt(totCham);
            if (!chamber[pos]) {
                chamber[pos] = true;
                bulletsChambed++;
            }
        }

        int firePos = rand.nextInt(totCham);
        return chamber[firePos];
    }

    @Override
    public String getGunName() { // Name
        return "Double Barrel Shotgun";
    }

    @Override
    public double rewardMult() { // Reward
        return 3.0;
    }
}

class Pistol extends Gun { // Pistol
    public Pistol() {  // Mag size
        totCham = 36;
    }

    @Override
    public int bullets(){ // How many bullets
        Scanner sc = new Scanner(System.in);
        return InputChecker.bulletCheck(sc, this, "Load how many bullets (x2 multiplier for each bullet)?: ");
    }

    @Override
    public void load() { // Bullet at top of magazine
        bullPos = 0;
        System.out.println("\nPistol loaded.");
    }

    @Override
    public boolean fire() { // Bang!
        int bullets = bullets();
        Random rand = new Random();
        boolean[] chamber = new boolean[totCham];
        
        int bulletsChambed = 0;
        while (bulletsChambed < bullets) { // Inserting bullets
            int pos = rand.nextInt(totCham);
            if (!chamber[pos]) {
                chamber[pos] = true;
                bulletsChambed++;
            }
        }

        int firePos = rand.nextInt(totCham);
        return chamber[firePos];
    }

    @Override
    public String getGunName() { // Name
        return "Pistol";
    }

    @Override
    public double rewardMult() { // "Reward" lol
        return 5.0;
    }
}

class Player { // You
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
