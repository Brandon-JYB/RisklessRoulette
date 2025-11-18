package guns;

import util.InputChecker;
import java.util.Random;
import java.util.Scanner;

public class revolver extends Gun { // Revolver
    public revolver() { // Revolver mag size
        totCham = 6;
    }

    @Override
    public int bullets(){ // How many bullets
        Scanner sc = new Scanner(System.in);
        return InputChecker.bulletCheck(sc, this, "Load how many bullets (x1.5 multiplier for each bullet)?: ");
    }

    @Override
    public void load() { // Load gun
        bullPos = random.nextInt(totCham);
        System.out.println("\nRevolver loaded.");
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
        return "Revolver";
    }

    @Override
    public double rewardMult(int bullets) { // Reward
        return 1.5*bullets;
    }
}