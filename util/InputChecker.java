package util;

import guns.Gun;
import java.util.Scanner;
import player.Player;

public class InputChecker {
    public static double betCheck(Scanner sc, Player player, String say) {
        double bet;
        while (true) { // Checking bet
            System.out.print(say);
            String input = sc.nextLine();
            input = input.trim();

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
            input = sc.nextLine();
            input = input.trim();

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
            String input = sc.nextLine();
            input = input.trim();

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
            String input = sc.nextLine();
            input = input.trim();

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