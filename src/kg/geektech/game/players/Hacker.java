package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Hacker extends Hero {
    int stolenHP = 20;
    int randomHero;

    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.HACKING);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        boss.setHealth(boss.getHealth() - this.stolenHP);
        this.randomHero = RPG_Game.random.nextInt(heroes.length);

        for (int randomHero = 0; randomHero < heroes.length; randomHero++) {
            if (heroes[randomHero] != this && this.getHealth() > 0 && heroes[randomHero].getHealth() < 0) {
                heroes[randomHero].setHealth(heroes[randomHero].getHealth() + stolenHP);
                break;
            }
        }
        System.out.println(this.getName() + " took " + this.stolenHP + " HP from " +
                boss.getName() + " and gave it to " + heroes[randomHero].getName());
    }
}

//    public void applySuperPower(Boss boss, Hero[] heroes) {
//        this.stolenHP = boss.getHealth() / 50;
//        boss.setHealth(boss.getHealth() - this.stolenHP);
//        this.randomHero = RPG_Game.random.nextInt(heroes.length);
//        for (int i = 0; i < heroes.length; i++) {
//            if (heroes[i] != heroes[5] && heroes[5].getHealth() > 0 && heroes[i].getHealth() < 0) {
//                heroes[i].setHealth(heroes[i].getHealth() + 20);
//                break;
//            }
//        }


//        if (randomHero.getHealth() > 0 && randomHero != this) {
//            randomHero.setHealth(randomHero.getHealth() + stolenHP);
//        }
