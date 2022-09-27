package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Uchiha extends Hero {
    int eyeLevel;
    public Uchiha(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.EYE_POWER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        eyeLevel = RPG_Game.random.nextInt(3);
        switch (eyeLevel) {
            case (1) -> {
                this.setHealth(this.getHealth() + boss.getDamage());
                System.out.println(this.getName() + " dodged a blow from " + boss.getName());
            }
            case (2) -> {
                boss.setHealth(boss.getHealth() - boss.getDamage());
                super.setDamage(0);
                boss.setDamage(0);
                System.out.println(this.getName() + " forced " + boss.getName() + " to hit themself");
            }
        }
    }
}
