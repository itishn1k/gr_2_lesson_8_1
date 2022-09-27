package kg.geektech.game.players;

public class Magic extends Hero {
    int boostPoints;
    public Magic(int health, int damage, int boostPoints, String name) {
        super(health, damage, name, SuperAbility.BOOST);
        this.boostPoints = boostPoints;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            hero.setDamage(hero.getDamage() + boostPoints);
        }
        System.out.println(this.getName()+" boosted every-hero's damage for "+boostPoints+" units!");
    }
}
