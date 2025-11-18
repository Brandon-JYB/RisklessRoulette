package guns;

import java.util.Random;

public abstract class Gun {
    public int getTotCham() {
        return totCham;
    }

    protected int totCham;
    protected int bullPos;
    protected Random random = new Random();

    public abstract int bullets();
    public abstract void load();
    public abstract boolean fire(int bullets);
    public abstract String getGunName();
    public abstract double rewardMult(int bullets);
}