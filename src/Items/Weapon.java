package Items;

public class Weapon extends Item{

    private WeaponType weaponType;
    private int damage;
    private double attackSpeed;


    public Weapon(String name, int levelRequired, Slot slot ,WeaponType type, int dmg, int atkSpd) {
        super(name,levelRequired ,slot);
        this.setWeaponType(type);
        this.setDamage(dmg);
        this.setAttackSpeed(atkSpd);
    }

    public WeaponType getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(WeaponType weaponType) {
        this.weaponType = weaponType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public double getAttackSpeed() {
        return attackSpeed;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeed = attackSpeed;
    }


}
