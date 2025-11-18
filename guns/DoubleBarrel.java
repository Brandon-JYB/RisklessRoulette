package guns;

import util.InputChecker;
import java.util.Random;
import java.util.Scanner;

public class DoubleBarrel extends Gun { // Double Barrel
    public DoubleBarrel() { // Two chambers
        totCham = 2;
    }

    @Override
    public int bullets(){ // How many bullets
        Scanner sc = new Scanner(System.in);
        return InputChecker.bulletCheck(sc, this, "Load how many bullets (x3.5 multiplier for each bullet)?: ");
    }

    @Override
    public void load() { // 50%
        bullPos = random.nextInt(totCham);
        System.out.println("\nDouble Barrel Shotgun loaded.");
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
        return "Double Barrel Shotgun";
    }

    @Override
    public double rewardMult(int bullets) { // Reward
        return 3.5*bullets;
    }
}