package Items;

public class Weapon extends Item {

    private WeaponType weaponType;
    private double damage;
    private double attackSpeed;
    private double dps;


    public Weapon(String name, int levelRequired, Slot slot ,WeaponType type, double dmg, double atkSpd, double dps) {
        super(name,levelRequired ,slot);
        this.setWeaponType(type);
        this.setDamage(dmg);
        this.setAttackSpeed(atkSpd);
        this.setDps(dps);
    }
    public Weapon(){//Blank Constructor
        super();

    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }

    public double getDps() {
        return (getDamage()*getAttackSpeed());
    }

    public void setDps(double dps) {
        this.dps = (getDamage()*getAttackSpeed());
    }
}
