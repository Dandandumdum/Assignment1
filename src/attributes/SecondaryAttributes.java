package attributes;

public class SecondaryAttributes extends PrimaryAttributes{ //Takes primary attributes and generates secondary attributes from them
    private int health;
    private int armorRating;
    private int elementalResistance;

    public SecondaryAttributes(int str, int dex, int intl, int vit, int hp, int def, int mgDef){
        super(str,dex,intl,vit);
        this.setHealth(hp);
        this.setArmorRating(def);
        this.setElementalResistance(mgDef);

    }
    public SecondaryAttributes(){

    }

    public int getHealth() {

        return health = getVitality()*10;
    }

    public void setHealth(int health) {
        this.health = getVitality()*10;
    }

    public int getArmorRating() {
        return armorRating  = (getStrength() + getDexterity());
    }

    public void setArmorRating(int armorRating) {
        this.armorRating = (getStrength() + getDexterity());
    }

    public int getElementalResistance() {
        return elementalResistance = getIntelligence();
    }

    public void setElementalResistance(int elementalResistance) {
        this.elementalResistance = getIntelligence();
    }

}

