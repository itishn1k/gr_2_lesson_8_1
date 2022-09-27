package kg.geektech.game.players;

public class Berserk extends Hero {

    public Berserk(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SAVE_DAMAGE_AND_REVERT);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int savedDamage = boss.getDamage();
        boss.setHealth(boss.getHealth() - (this.getDamage()+(savedDamage /2)));
        System.out.println(this.getName()+" gave back "+ savedDamage /2+" of "+boss.getName()+" damage!");
    }
}
