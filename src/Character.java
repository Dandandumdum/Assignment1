import Items.Armor;
import Items.ArmorType;
import Items.WeaponType;
import attributes.RpgClassType;
import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;

public class Character { //Initializes a character (Class type, level, equipment)
    private int level;
    private RpgClassType rpgClassType;
    private PrimaryAttributes primary;
    private SecondaryAttributes secondary;
    private WeaponType weaponType;
    private Armor head; //must have armor not armor type
    private Armor legs;
    private Armor body;
    private int totalAttributes;
    private int dps;
    //Have items equipped here, as custom type?

        public Character(){
        }

        public Character(RpgClassType rpgClassType, int level, WeaponType weaponType, Armor head, Armor body, Armor legs){
        this.setPlayerClass(rpgClassType);
        this.setLevel(1); //Initializing character at level 1 unless stated otherwise
        this.setWeapon(weaponType);
        this.setHead(head);
        this.setBody(body);
        this.setLegs(legs);

    }
    //Initializes Attributes at lvl One based upon character rpg class
    SecondaryAttributes WARRIOR = new SecondaryAttributes(5,2,1,10,1,1,1);
    SecondaryAttributes MAGE = new SecondaryAttributes(1,1,8,5,1,1,1);
    SecondaryAttributes RANGER = new SecondaryAttributes(1,7,1,8,0,0,0);
    SecondaryAttributes ROUGE = new SecondaryAttributes(2,6,1,8,0,0,0);

    public String getAttributes(){
        System.out.println("Strength: " + getSecondary().getStrength() +" Dexterity: " + getSecondary().getDexterity()
                +" Intelligence: "+ getSecondary().getIntelligence() +" Vitality: "+ getSecondary().getVitality() +
                " Health: "+ getSecondary().getHealth() +" Armor Rating: "+ getSecondary().getArmorRating()
                +" Elemental Resistance: " +getSecondary().getElementalResistance() );

        return "ATTRIBUTES";
    }

    public PrimaryAttributes getPrimary() {
        return primary;
    }

    public void setPrimary(PrimaryAttributes primary) {
        this.primary = primary;
    }

    public SecondaryAttributes getSecondary() {
        return secondary;
    }

    public void setSecondary(SecondaryAttributes secondary) {
        this.secondary = secondary;
    }


    public RpgClassType getPlayerClass() {
        return rpgClassType;
    }

    public void setPlayerClass(RpgClassType rpgClassType) {
        this.rpgClassType = rpgClassType;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }





    public WeaponType getWeapon() {
        return weaponType;
    }

    public void setWeapon(WeaponType weaponType) {
        this.weaponType = weaponType;
    }



    public Armor getHead() {
        return head;
    }

    public void setHead(Armor head) {
        this.head = head;
    }

    public Armor getLegs() {
        return legs;
    }

    public void setLegs(Armor legs) {
        this.legs = legs;
    }

    public Armor getBody() {
        return body;
    }

    public void setBody(Armor body) {
        this.body = body;
    }
}
