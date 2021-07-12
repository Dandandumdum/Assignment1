import Items.*;
import attributes.RpgClassType;
import attributes.PrimaryAttributes;
import attributes.SecondaryAttributes;

import java.util.HashMap;

public class Character { //Initializes a character (Class type, level, equipment)
    private int level;
    private RpgClassType rpgClassType;
    private PrimaryAttributes primary;
    private SecondaryAttributes secondary;
    private Weapon weapon;
    private Armor head; //must have armor not armor type
    private Armor legs;
    private Armor body;
    private int totalPrimaryAttributes;
    private double characterDps;
    //Have items equipped here, as custom type?

        public Character(){
        }

        public Character(RpgClassType rpgClassType, int level, Weapon weapon, Armor head, Armor body, Armor legs,
                         double characterDps  ){
        this.setPlayerClass(rpgClassType);
        this.setLevel(level); //Initializing character at level 1 unless stated otherwise
        this.setWeapon(weapon);
        this.setHead(head);
        this.setBody(body);
        this.setLegs(legs);
        this.setCharacterDps(characterDps);



    }
    //Initializes Attributes at lvl One based upon character rpg class
    //PrimaryAttributes WARRIOR = new PrimaryAttributes(5,2,1,10); Not required if i make Primary an interface?
    SecondaryAttributes WARRIOR = new SecondaryAttributes(5,2,1,10,1,1,1);
    SecondaryAttributes MAGE = new SecondaryAttributes(1,1,8,5,1,1,1);
    SecondaryAttributes RANGER = new SecondaryAttributes(1,7,1,8,0,0,0);
    SecondaryAttributes ROUGE = new SecondaryAttributes(2,6,1,8,0,0,0);

    public String attributesToString(){// use string builder instead
        System.out.println("Strength: " + getSecondary().getStrength() +" Dexterity: " + getSecondary().getDexterity()
                +" Intelligence: "+ getSecondary().getIntelligence() +" Vitality: "+ getSecondary().getVitality() +
                " Health: "+ getSecondary().getHealth() +" Armor Rating: "+ getSecondary().getArmorRating()
                +" Elemental Resistance: " +getSecondary().getElementalResistance() );

        return "ATTRIBUTES";
    }
    public int getTotalPrimaryAttributes(){
        int i = getSecondary().getStrength() + getSecondary().getDexterity()+ getSecondary().getIntelligence()
                +getSecondary().getVitality();
                return i;
    }
    public  void equipArmor(Slot slot, Armor armor) {
       try{
           if (armor.getLevelRequired() > getLevel()){
               System.out.println("Level Requirement too high.");
           }else{
               HashMap<Slot, Armor> equippedArmor = new HashMap();
               if (slot == Slot.HEAD){
                   setHead(armor);
               }else if (slot == Slot.BODY){
                   setBody(armor);
               }else if (slot == Slot.LEGS){
                   setLegs(armor);
               }else
                   System.out.println("Armor cannot be place in that slot.");
           }
           //}catch (NullPointerException e){
       }catch(InvalidArmorException e){
           System.out.println(e);
       }

    }
    public  void equipWeapon(Slot slot, Weapon weapon) {

        try{
            if (weapon.getLevelRequired() > getLevel()){
                System.out.println("Level Requirement too high.");
            }else{
                HashMap<Slot, Weapon> equippedWeapon = new HashMap();
                if (slot == Slot.WEAPON){
                    setWeapon(weapon);
                }else
                    System.out.println("Weapon cannot be place in that slot.");

            }
        //}catch (NullPointerException e){
        }catch(InvalidArmorException e){
            System.out.println(e);
        }
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


    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getHead() {
        return head;
    }

    public void setHead(Armor head) {
       /* if(  != Slot.HEAD){
            System.out.println("Non-Head Item cannot be placed in this slot");
        }else */
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

    public void setCharacterDps(double characterDps) {
        this.setCharacterDps(characterDps);

    }

    public double getCharacterDps() {
        if(Slot.WEAPON.equals(null)){ // hash map will help Slot.WEAPON == empty
            this.characterDps = 1;
        }else{
            this.characterDps = (1+(getTotalPrimaryAttributes()/100)) * getWeapon().getDps();
        }
        return characterDps;
    }


}
