package guns;

import util.InputChecker;
import java.util.Random;
import java.util.Scanner;

public class desertEagle extends Gun { // Desert Eagle
    public desertEagle() {  // Mag size
        totCham = 9;
    }

    @Override
    public int bullets(){ // How many bullets
        Scanner sc = new Scanner(System.in);
        return InputChecker.bulletCheck(sc, this, "\nLoad how many bullets (x2 multiplier for each bullet)?: ");
    }

    @Override
    public void load() { // Bullet at top of magazine
        bullPos = 0;
        System.out.println("\nDesert Eagle loaded.");
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
        return "Desert Eagle";
    }

    @Override
    public double rewardMult(int bullets) { // "Reward" lol
        return 5.0;
    }
}
