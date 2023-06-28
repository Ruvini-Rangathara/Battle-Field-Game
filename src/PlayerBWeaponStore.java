import java.util.ArrayList;

public class PlayerBWeaponStore {
    ArrayList playerBWeapon = new ArrayList();

    public int scoreCalculate(){

        Weapon [] weapons = {new T56(), new Tank(), new MultiBarrel(), new Pistol(), new Bomb()};

        int fullScoreB=0;
        for(Object w : playerBWeapon){
            if ("T56".equals(w)) {
                fullScoreB = fullScoreB + weapons[0].getScore();
            }else if("Tank".equals(w)){
                fullScoreB = fullScoreB + weapons[1].getScore();
            }else if("MultiBarrel".equals(w)){
                fullScoreB = fullScoreB + weapons[2].getScore();
            }else if("Pistol".equals(w)){
                fullScoreB = fullScoreB + weapons[3].getScore();
            }else if("Bomb".equals(w)){
                fullScoreB = fullScoreB + weapons[4].getScore();
            }
        }
        return fullScoreB;
    }

}
