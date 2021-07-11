package Items;

public class Armor extends Item{//Give armor as an object to equip
    private ArmorType armorType;

    public Armor(String name, int levelRequired, Slot slot , ArmorType type) {
        super(name, levelRequired, slot);
        this.setArmorType(type);
    }

    public Armor() {//Blank constructor
        super();
    }

    public ArmorType getArmorType() {
        return armorType;
    }

    public void setArmorType(ArmorType armorType) {
        this.armorType = armorType;
    }
}
