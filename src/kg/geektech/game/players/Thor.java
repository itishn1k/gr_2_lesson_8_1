package kg.geektech.game.players;

import kg.geektech.game.general.RPG_Game;

public class Thor extends Hero {
    boolean stunning;

    public Thor(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.THUNDER);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        stunning = RPG_Game.random.nextBoolean();
        if (this.stunning) {
            boss.setDamage(0);
            System.out.println("Boss stunned");
        }
    }
}
