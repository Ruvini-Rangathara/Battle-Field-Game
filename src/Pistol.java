import java.util.Random;

public class Pistol implements Weapon{
    @Override
    public int shoot() {
        Random random = new Random();
        int score =(1+ random.nextInt(10));
        return score;
    }

    @Override
    public int getScore() {
        return shoot();
    }
}
