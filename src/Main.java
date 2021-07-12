import Items.*;
import attributes.RpgClassType;

public class Main {

    public static void main(String[] args) {
        test();


    }

    public static void test(){
       /* Character Ben = new Character(RpgClassType.MAGE,1, WeaponType.WAND, Armor.CLOTH, ArmorType.CLOTH, ArmorType.CLOTH);//Need Item head, body, arm, and legs
        System.out.println(Ben.getPlayerClass() + " " + Ben.getLevel() + " " + Ben.getAttributes());
        System.out.println(Ben.getSecondary());//Null pointer exeptions
        System.out.println(RpgClassType.MAGE.getSecondary().toString()); */
        Armor testMailBody = new Armor();
        testMailBody.setName("Shiny Mail Body Armor");
        testMailBody.setLevelRequired(3);
        testMailBody.setSlot(Slot.BODY);
        testMailBody.setArmorType(ArmorType.MAIL);
        System.out.println("=============================");

        Armor testClothHead = new Armor();
        testClothHead.setName("Common Cloth Head Armor");
        testClothHead.setLevelRequired(2);
        testClothHead.setSlot(Slot.HEAD);
        testClothHead.setArmorType(ArmorType.CLOTH);
        System.out.println("=============================");

        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(2);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.AXE);
        testAxe.setDamage(20);
        testAxe.setAttackSpeed(0.5);

        //Setting values
        Character Neil = new Character();
        Neil.setPlayerClass(RpgClassType.WARRIOR);
        Neil.setSecondary(Neil.WARRIOR);
        Neil.setLevel(4);
        //Neil.setHead(testClothHead);
        Neil.equipArmor(Slot.HEAD, testClothHead);
        Neil.equipArmor(Slot.BODY, testMailBody);
        Neil.equipWeapon(Slot.WEAPON, testAxe);
       // Neil.equipArmor(Slot.BODY, testClothHead);//Must give error, slot wrong
        //Getting Values
        try{
            System.out.println(Neil.getPlayerClass());
            System.out.println(Neil.attributesToString());
            System.out.println(Neil.getHead().getName());
            System.out.println(Neil.getBody().getName());//Should not allow Head items, also null pointer exception if empty
            System.out.println("=============================");
            Neil.setPlayerClass(RpgClassType.MAGE);
            Neil.setSecondary(Neil.MAGE);
            System.out.println(Neil.attributesToString());
            System.out.println(Neil.getCharacterDps());

      //  }catch (NullPointerException e){System.out.println(e);
        }catch(InvalidArmorException e){
            System.out.println(e);
        }
    }
}
