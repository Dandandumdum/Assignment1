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
    private Armor head;
    private Armor legs;
    private Armor body;
    private double characterDps;
    private double weaponDps;
    private double characterDamageBonus;
    HashMap<Slot, Armor> equippedArmor = new HashMap<Slot, Armor>();
    HashMap<Slot, Weapon> equippedWeapon = new HashMap<Slot, Weapon>();


        public Character(){
        }

        public Character(RpgClassType rpgClassType, int level){
        this.setPlayerClass(rpgClassType);
        this.setLevel(level); //Initializing character at level 1 unless stated otherwise
        this.setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
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
    public String attributesToString(){// returns a string of primary and secondary attributes
        return "Strength: " + getPrimary().getStrength() +" Dexterity: " + getPrimary().getDexterity()
                +" Intelligence: "+ getPrimary().getIntelligence() +" Vitality: "+ getPrimary().getVitality() +
                " Health: "
                + getSecondary().getHealth() +" Armor Rating: "+ getSecondary().getArmorRating()
                +" Elemental Resistance: " +getSecondary().getElementalResistance();
    }


    public  void equipArmor(Slot slot, Armor armor) throws InvalidArmorException { //Equips armor to specified slot on character, if allowed.
       try{
           if (armor.getLevelRequired() > getLevel()){
                  throw new InvalidArmorException("Invalid armor selection, level too high. Level required: " + armor.getLevelRequired()
                  + " ,current player level:  " + getLevel());
           }else if(!armorClassCheck(getPlayerClass(), armor.getArmorType())){
               throw new InvalidArmorException("Invalid Armor Selection, "+ getPlayerClass() + " may not equip "
                                                + armor.getArmorType());
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
                   throw new InvalidArmorException( armor.getName() +" cannot be placed in the " + slot +" slot." );
                              }
           } catch(InvalidArmorException e){

       }

    }
    public void showArmor(Slot slot) {//shows armor in a specified slot
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

    public  void equipWeapon(Slot slot, Weapon weapon) throws InvalidWeaponException {

        try{
            if (weapon.getLevelRequired() > getLevel()){
                throw new InvalidWeaponException("Invalid Weapon Selection, level requirement too high.");
            }else if(!weaponClassCheck(getPlayerClass(), weapon.getWeaponType())){
                throw new InvalidWeaponException("Invalid Weapon Selection, "+ getPlayerClass()+ " may not equip "+
                        weapon.getWeaponType());
            }
            else{
                if (slot == Slot.WEAPON){
                    equippedWeapon.put(Slot.WEAPON, weapon);
                    setWeaponDps(equippedWeapon.get(Slot.WEAPON).getDamage(), equippedWeapon.get(Slot.WEAPON).getAttackSpeed());
                }else
                    System.out.println("Weapon cannot be place in that slot.");
            }
        //}catch (NullPointerException e){
        }catch(InvalidWeaponException e){

        }
    }//equips a weapon if valid
    public boolean weaponClassCheck(RpgClassType classType, WeaponType weapon){//checks if the weapon type being equipped is compatible with the current player class type
        if((weapon.equals(WeaponType.AXE) || weapon.equals(WeaponType.HAMMER)) && !classType.equals(RpgClassType.WARRIOR)){
            return false;
        }else if((weapon.equals(WeaponType.WAND) || weapon.equals(WeaponType.STAFF)) && !classType.equals(RpgClassType.MAGE)){
            return false;
        }else if(weapon.equals(WeaponType.BOW) && !classType.equals(RpgClassType.RANGER)){
            return false;
        }else if(weapon.equals(WeaponType.DAGGER) && !classType.equals(RpgClassType.ROGUE)){
            return false;
        }else if(weapon.equals(WeaponType.SWORD)&& (!classType.equals(RpgClassType.WARRIOR)|| !classType.equals(RpgClassType.ROGUE))){
            return false;
        }else{
            return true;
        }
    }
    public boolean armorClassCheck(RpgClassType classType, ArmorType armor){// checks if the armor type being equipped is compatible with the current player class
        if(armor.equals(ArmorType.PLATE)  && !classType.equals(RpgClassType.WARRIOR)){
            return false;
        }else if(armor.equals(ArmorType.CLOTH) && !classType.equals(RpgClassType.MAGE)){
            return false;
        }else if(armor.equals(ArmorType.LEATHER) && (!classType.equals(RpgClassType.RANGER) || !classType.equals(RpgClassType.ROGUE))){
            return false;
        }else if(armor.equals(ArmorType.MAIL) && (classType.equals(RpgClassType.MAGE))){
            return false;
        }else{
            return true;
        }
    }
    public boolean hasWeaponEquipped(Slot slot){
        if (slot == null){
            return false;
        }return true;
    }

    public void showWeapon(Slot slot){ //prints out information on the currently equipped weapon in the specified slot
        if(!hasWeaponEquipped(Slot.WEAPON)){
            System.out.println("No weapon equipped.");
        }else if(slot == Slot.WEAPON){
            System.out.println(equippedWeapon.get(Slot.WEAPON).toString());
        }

    }

    public void levelUp(RpgClassType rpgClass){//Increases the player level by 1, and raises primary attributes based upon class specifications
        if (rpgClass.equals(RpgClassType.WARRIOR)){
            setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 3, getPrimary().getDexterity() + 2, getPrimary().getIntelligence()+1, getPrimary().getVitality()+10));
            setCharacterDamageBonus(RpgClassType.WARRIOR);
            setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
        }else if (rpgClass.equals(RpgClassType.MAGE)){
            setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 1, getPrimary().getDexterity() + 1, getPrimary().getIntelligence()+5, getPrimary().getVitality()+3));
            setCharacterDamageBonus(RpgClassType.MAGE);
            setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());

        }else if (rpgClass.equals(RpgClassType.RANGER)){
            setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 1, getPrimary().getDexterity() + 5, getPrimary().getIntelligence()+1, getPrimary().getVitality()+2));
            setCharacterDamageBonus(RpgClassType.RANGER);
            setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
        }else if (rpgClass.equals(RpgClassType.ROGUE)){
            setPrimary(new PrimaryAttributes(getPrimary().getStrength() + 1, getPrimary().getDexterity() + 4, getPrimary().getIntelligence()+1, getPrimary().getVitality()+3));
            setCharacterDamageBonus(RpgClassType.ROGUE);
            setCharacterDps(getPrimary().getTotalPrimaryAttributes(), getWeaponDps());
        }
        setLevel(getLevel() + 1);
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

    public void setCharacterDps(double totalPrimary, double weaponDps) { //Sets the character dps based upon primary attributes and weapon dps
        if(weaponDps == 0){
            this.characterDps = 1;
        }else{
            this.characterDps = (1+(totalPrimary/100) + characterDamageBonus) * weaponDps;
        }
    }

    public double getCharacterDamageBonus() {
        return characterDamageBonus;
    }

    public void setCharacterDamageBonus(RpgClassType rpgClass) {//Sets Character bonus damage in percent based upon the current player class
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


    public double getWeaponDps() {
        return weaponDps;
    }

    public void setWeaponDps(double damage, double attackSpeed) {
        if(hasWeaponEquipped(equippedWeapon.get(Slot.WEAPON).getSlot())){
            this.weaponDps = damage *attackSpeed;
        }else{
            this.weaponDps = 0;
        }

    }
}

