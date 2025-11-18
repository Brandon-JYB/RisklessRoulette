package guns;

import util.InputChecker;
import java.util.Random;
import java.util.Scanner;

public class pepperBox extends Gun { // Pepperbox Pistol
    public pepperBox() { // Revolver mag size
        totCham = 4;
    }

    @Override
    public int bullets(){ // How many bullets
        Scanner sc = new Scanner(System.in);
        return InputChecker.bulletCheck(sc, this, "Load how many bullets (x2.5 multiplier for each bullet)?: ");
    }

    @Override
    public void load() { // Load gun
        bullPos = random.nextInt(totCham);
        System.out.println("\nPepperbox loaded.");
    }

    @Override
    public boolean fire(int bullets) { // Bang!
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
        return "Pepperbox Pistol";
    }

    @Override
    public double rewardMult(int bullets) { // Reward
        return 2.5*bullets;
    }
}