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
    private double characterDps;
    private double characterDamageBonus;
    HashMap<Slot, Armor> equippedArmor = new HashMap<Slot, Armor>();
    HashMap<Slot, Weapon> equippedWeapon = new HashMap();
    //Have items equipped here, as custom type?

        public Character(){
        }

        public Character(RpgClassType rpgClassType, int level){
        this.setPlayerClass(rpgClassType);
        this.setLevel(level); //Initializing character at level 1 unless stated otherwise
        this.setCharacterDps(getPrimary().getTotalPrimaryAttributes(), equippedWeapon.get(Slot.WEAPON).getDamagePerSecond());
        this.setCharacterDamageBonus(getPlayerClass());

    }
    //Initializes Attributes at lvl One based upon character rpg class

    PrimaryAttributes WARRIOR = new PrimaryAttributes(5,2,1,10);
    PrimaryAttributes MAGE = new  PrimaryAttributes(1,1,8,5);
    PrimaryAttributes RANGER = new  PrimaryAttributes(1,7,1,8);
    PrimaryAttributes ROUGE = new  PrimaryAttributes(2,6,1,8);
    SecondaryAttributes WARRIORSEC = new SecondaryAttributes(WARRIOR.getStrength(), WARRIOR.getDexterity(), WARRIOR.getIntelligence(),
                                                                WARRIOR.getVitality(), WARRIOR.getVitality()*10,WARRIOR.getStrength() + WARRIOR.getDexterity(),
                                                                 WARRIOR.getIntelligence());
    SecondaryAttributes MAGESEC = new SecondaryAttributes(MAGE.getStrength(), MAGE.getDexterity(),MAGE.getIntelligence(), MAGE.getVitality(),
                                                                MAGE.getVitality()*10, MAGE.getStrength() + MAGE.getDexterity(), MAGE.getIntelligence());
    SecondaryAttributes RANGERSEC = new SecondaryAttributes(RANGER.getStrength(), RANGER.getDexterity(), RANGER.getIntelligence(), ROUGE.getVitality(),
                                                                RANGER.getVitality()*10, RANGER.getStrength() + RANGER.getDexterity(), RANGER.getVitality());
    SecondaryAttributes ROUGESEC = new SecondaryAttributes(ROUGE.getStrength(), ROUGE.getDexterity(), ROUGE.getIntelligence(), ROUGE.getVitality(), ROUGE.getVitality()*10,
                                                                 ROUGE.getStrength() + ROUGE.getDexterity(), ROUGE.getIntelligence());
    public String attributesToString(){// use string builder instead
        return "Strength: " + getPrimary().getStrength() +" Dexterity: " + getPrimary().getDexterity()
                +" Intelligence: "+ getPrimary().getIntelligence() +" Vitality: "+ getPrimary().getVitality() +
                " Health: "
                + getSecondary().getHealth() +" Armor Rating: "+ getSecondary().getArmorRating()
                +" Elemental Resistance: " +getSecondary().getElementalResistance();
    }


    public  void equipArmor(Slot slot, Armor armor) { //Equips armor to specified slot on character, if allowed.
       try{
           if (armor.getLevelRequired() > getLevel()){
               System.out.println("Level Requirement too high.");
           }else{

               if (slot == Slot.HEAD){
                   equippedArmor.put(Slot.HEAD, armor);
                   setPrimary(new PrimaryAttributes((getPrimary().getStrength() + armor.getPrimary().getStrength()) ,
                           (getPrimary().getDexterity() + armor.getPrimary().getDexterity()) ,
                           (getPrimary().getIntelligence() + armor.getPrimary().getIntelligence()) ,
                           (getPrimary().getVitality() + armor.getPrimary().getVitality())));

               }else if (slot == Slot.BODY){
                   equippedArmor.put(Slot.BODY, armor);
                   setPrimary(new PrimaryAttributes((getPrimary().getStrength() + armor.getPrimary().getStrength()) ,
                           (getPrimary().getDexterity() + armor.getPrimary().getDexterity()) ,
                           (getPrimary().getIntelligence() + armor.getPrimary().getIntelligence()) ,
                           (getPrimary().getVitality() + armor.getPrimary().getVitality())));
               }else if (slot == Slot.LEGS){
                   equippedArmor.put(Slot.LEGS, armor);
                   setPrimary(new PrimaryAttributes((getPrimary().getStrength() + armor.getPrimary().getStrength()) ,
                           (getPrimary().getDexterity() + armor.getPrimary().getDexterity()) ,
                           (getPrimary().getIntelligence() + armor.getPrimary().getIntelligence()) ,
                           (getPrimary().getVitality() + armor.getPrimary().getVitality())));
               }else
                   System.out.println("Armor cannot be placed in that slot.");
           }
           }catch (NullPointerException e){
       }catch(InvalidArmorException e){
           System.out.println(e);
       }

    }
    public void showArmor(Slot slot) {
        try {
            if (slot == Slot.HEAD) {
                System.out.println(equippedArmor.get(Slot.HEAD).toString());
            } else if (slot == Slot.BODY) {
                System.out.println(equippedArmor.get(Slot.BODY).toString());
            } else if (slot == Slot.LEGS) {
                System.out.println(equippedArmor.get(Slot.LEGS).toString());
            } else
                System.out.println("Armor cannot be worn in that slot.");
        } catch(NullPointerException e){
            System.out.println(e);
        }

    }

    public  void equipWeapon(Slot slot, Weapon weapon) {

        try{
            if (weapon.getLevelRequired() > getLevel()){
                System.out.println("Level Requirement too high.");
            }else{
                if (slot == Slot.WEAPON){
                    equippedWeapon.put(Slot.WEAPON, weapon);
                }else
                    System.out.println("Weapon cannot be place in that slot.");
            }
        //}catch (NullPointerException e){
        }catch(InvalidArmorException e){
            System.out.println(e);
        }
    }
    public void showWeapon(Slot slot){ //prints out information on the currently equipped weapon
        if(equippedWeapon.get(Slot.WEAPON).equals(WeaponType.NONE)){
            System.out.println("No weapon equipped.");
        }else
        if(slot == Slot.WEAPON){
            System.out.println(equippedWeapon.get(Slot.WEAPON).toString());
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
    public double getCharacterDps() {
        return characterDps;
    }

    public void setCharacterDps(double totalPrimary, double weaponDps) {
        if(Slot.WEAPON.equals(WeaponType.NONE)){ // hash map will help Slot.WEAPON == empty
            this.characterDps = 1;
        }else{
            this.characterDps = (1+(totalPrimary/100) + characterDamageBonus) * weaponDps;
        }
    }

    public double getCharacterDamageBonus() {
        return characterDamageBonus;
    }

    public void setCharacterDamageBonus(RpgClassType rpgClass) {
        if (rpgClass.equals(RpgClassType.WARRIOR)){
            this.characterDamageBonus = Double.valueOf(getPrimary().getStrength())/100;
        }else if (rpgClass.equals(RpgClassType.MAGE)){
            this.characterDamageBonus = Double.valueOf(getPrimary().getIntelligence())/100;
        }else if (rpgClass.equals(RpgClassType.RANGER)){
            this.characterDamageBonus =Double.valueOf(getPrimary().getDexterity())/100;
        }else if (rpgClass.equals(RpgClassType.ROGUE)){
            this.characterDamageBonus =Double.valueOf(getPrimary().getDexterity())/100;
        }
    }


}

