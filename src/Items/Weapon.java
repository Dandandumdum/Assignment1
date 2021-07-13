package Items;

public class Weapon extends Item {

    private WeaponType weaponType;
    private double damage;
    private double attackSpeed;
    private double damagePerSecond;


    public Weapon(String name, int levelRequired, Slot slot ,WeaponType type, double dmg, double atkSpd) {
        super(name,levelRequired ,slot);
        this.setWeaponType(type);
        this.setDamage(dmg);
        this.setAttackSpeed(atkSpd);
        this.setDamagePerSecond(this.getDamage(),this.getAttackSpeed());

    }
    public Weapon(){//Blank Constructor
        super();
        this.setWeaponType(WeaponType.NONE);
        this.setDamage(1);
        this.setAttackSpeed(1);
        this.setDamagePerSecond(getDamage(),getAttackSpeed());
    }
    public String toString(){
        return "Name: "+getName() +" Level Required: "+ getLevelRequired() + " Weapon Type: "+getWeaponType() + " DPS: " + getDamagePerSecond() ;
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

    public double getDamagePerSecond() {
        return damagePerSecond;
                //(getDamage()*getAttackSpeed());
    }

    public void setDamagePerSecond(double damage, double attackSpeed) {
        this.damagePerSecond = damage*attackSpeed;
    }
}
