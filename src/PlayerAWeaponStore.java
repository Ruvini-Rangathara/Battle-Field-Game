import java.util.ArrayList;

public class PlayerAWeaponStore {
    ArrayList playerAWeapon = new ArrayList();

    public int scoreCalculate(){

        Weapon [] weapons = {new T56(), new Tank(), new MultiBarrel(), new Pistol(), new Bomb()};

        int fullScoreA=0;
        for(Object w : playerAWeapon){
            if ("T56".equals(w)) {
                fullScoreA = fullScoreA + weapons[0].getScore();
            }else if("Tank".equals(w)){
                fullScoreA = fullScoreA + weapons[1].getScore();
            }else if("MultiBarrel".equals(w)){
                fullScoreA = fullScoreA + weapons[2].getScore();
            }else if("Pistol".equals(w)){
                fullScoreA = fullScoreA + weapons[3].getScore();
            }else if("Bomb".equals(w)){
                fullScoreA = fullScoreA + weapons[4].getScore();
            }
        }
        return fullScoreA;
    }

}
