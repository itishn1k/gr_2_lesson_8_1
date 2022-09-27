package kg.geektech.game.players;

public abstract class GameEntity {
    private int health;
    private int damage;
    private final String name;

    public GameEntity(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = Math.max(health, 0);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return this.getName() +
                " health: " + this.getHealth() + " damage: " + this.getDamage();
    }
}
