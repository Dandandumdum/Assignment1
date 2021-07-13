package Items;


import attributes.PrimaryAttributes;

public class Armor extends Item{//Give armor as an object to equip
    private ArmorType armorType;
    private PrimaryAttributes primary;

    public Armor(String name, int levelRequired, Slot slot , ArmorType type, PrimaryAttributes primary) {
        super(name, levelRequired, slot);
        this.setArmorType(type);
        this.setPrimary(primary);
    }


    public Armor() {//Blank constructor
        super();
    }

    public String toString(){
        String s = "Name: " + getName() + " Level Required: " + getLevelRequired() + " Armor Type: " + getArmorType() +
                " Primary Attributes: " + "str:" + getPrimary().getStrength() + " dex:" + getPrimary().getDexterity()
                + " int:" + getPrimary().getIntelligence() + " vit:" + getPrimary().getVitality();;
        return s;

    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }

    public PrimaryAttributes getPrimary() {
        return primary;
    }

    public void setPrimary(PrimaryAttributes primary) {
        this.primary = primary;
    }
}
