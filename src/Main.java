
interface HavingSuperAbility {
    void applySuperAbility();
}

abstract class Hero implements HavingSuperAbility {
    protected int health;
    protected int damage;
    protected String superAbility;

    public Hero(int health, int damage, String superAbility) {
        this.health = health;
        this.damage = damage;
        this.superAbility = superAbility;
    }

    @Override
    public void applySuperAbility() {
        System.out.println(this.getClass().getSimpleName() + " применил суперспособность " + superAbility);
    }
}

class Magic extends Hero {
    public Magic(int health, int damage) {
        super(health, damage, "MAGIC ATTACK");
    }
}

// дз на сообразительность
class Medic extends Hero {
    public int healPoints;

    public Medic(int health, int damage, int healPoints) {
        super(health, damage, "HEALING");
        this.healPoints = healPoints;
    }

    public void increaseExperience() {
        healPoints += healPoints * 0.10;
    }
}

class Warrior extends Hero {
    public Warrior(int health, int damage) {
        super(health, damage, "CRITICAL DAMAGE");
    }
}

public class Main {
    public static void main(String[] args) {
        Hero[] heroes = new Hero[3];
        heroes[0] = new Magic(110, 30);
        heroes[1] = new Medic(70, 10, 50);
        heroes[2] = new Warrior(150, 30);

        for (Hero hero : heroes) {
            hero.applySuperAbility();

            if (hero instanceof Medic) {
                ((Medic) hero).increaseExperience();
                System.out.println("Количество единиц лечения увеличен: " + ((Medic) hero).healPoints);
            }
        }
    }
}