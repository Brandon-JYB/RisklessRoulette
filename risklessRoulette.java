import java.util.Scanner;
import util.InputChecker;
import guns.Gun;
import guns.desertEagle;
import guns.DoubleBarrel;
import guns.pepperBox;
import guns.revolver;
import player.Player;

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
            System.out.println("\nChoose your weapon:");
            System.out.println("1. Desert Eagle (9 chambers, x5 per chamber)");
            System.out.println("2. Revolver (6 chambers, x1.5 per chamber)");
            System.out.println("3. Pepperbox Pistol (4 chambers, x2.5 per chamber)");
            System.out.println("4. Double Barrel Shotgun (2 chambers, x3.5 per chamber)");
  
            
            int gunChoice = InputChecker.gunCheck(sc, "\nEnter Choice: ");

            switch (gunChoice) { // Pick a gun
                case 1:
                    gun = new desertEagle();
                    break;
                case 2:
                    gun = new revolver();
                    break;
                case 3:
                    gun = new pepperBox();
                    break;
                case 4:
                    gun = new DoubleBarrel();
                    break;
                default:
                    System.out.println("❌ Invalid choice. Please pick a number from above.");
                    continue;
            }
            
            double bet = InputChecker.betCheck(sc, player, "\nEnter your bet amount: ₱");   
            
            int bullet = InputChecker.bulletCheck(sc, gun, "\nHow many bullets would you like to chamber?: ");
            
            gun.load();

            boolean pull = InputChecker.yesNoCheck(sc, "\nPull the trigger? (y/n):");            
            System.out.print("\n");
            if (pull) { // Play
                boolean cont = true;
                while (cont) { // Continous play
                    if (gunChoice == 1) { // Desert Eagle
                        System.out.println("Bang! The " + gun.getGunName() + " fired!\n");
                        System.out.println("You're dead! **** pistol yan, anong expected mo?");
                        player.setAlive(false);
                        player.subtractBalance(bet);
                        break;
                    }
                    if (gun.fire(bullet)) { // Boom headshot
                        System.out.println("The " + gun.getGunName() + " fired!\n");
                        System.out.println("The bullet went through your head. You died!");
                        player.setAlive(false);
                        player.subtractBalance(bet);
                        break;
                    }
                    else { // Suerte
                        double winnings = bet * gun.rewardMult(bullet);
                        System.out.println("Click! No bullet in the chamber. You live!\n");
                        System.out.println("You won ₱" + winnings + "!");
                        player.addBalance(winnings);
                    }

                    cont = InputChecker.yesNoCheck(sc, "\nPlay again using the same gun? (y/n): ");
            
                    if (!cont){ // Quitter
                        break;
                    }

                    System.out.print("\n");
                }
            }
            else { // Duwag
                System.out.println("You backed out this round.\n");
            }

            if (!player.isAlive()){ // Boom headshot
                break;
            }
            if (player.getBal() <= 0) { // Bankrupt
                System.out.println("\nYou ran out of money. Game over!");
                player.setAlive(false);
            }

            Boolean again = InputChecker.yesNoCheck(sc, "\nDo you want to play another round? (y/n): ");
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