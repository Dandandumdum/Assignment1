import Items.*;
import attributes.PrimaryAttributes;
import attributes.RpgClassType;

public class Main {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        Armor testPlateBody = new Armor();
        testPlateBody.setName("Common Plate Body Armor");
        testPlateBody.setLevelRequired(1);
        testPlateBody.setSlot(Slot.BODY);
        testPlateBody.setArmorType(ArmorType.PLATE);
        testPlateBody.setPrimary(new PrimaryAttributes(1,0,0,2));

        Armor testClothHead = new Armor();
        testClothHead.setName("Common Mail Head Armor");
        testClothHead.setLevelRequired(1);
        testClothHead.setSlot(Slot.HEAD);
        testClothHead.setArmorType(ArmorType.MAIL);
        testClothHead.setPrimary(new PrimaryAttributes( 3, 0, 0, 2));

        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(1);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.AXE);
        testAxe.setDamage(20);
        testAxe.setAttackSpeed(0.5);

        //Setting values
        Character Neil = new Character();
        Neil.setPlayerClass(RpgClassType.WARRIOR);
        Neil.classAttributes(RpgClassType.WARRIOR, 1);
        Neil.setCharacterDamageBonus(RpgClassType.WARRIOR);
        Neil.equipArmor(Slot.HEAD, testClothHead);
        Neil.equipArmor(Slot.BODY, testPlateBody);
        Neil.equipWeapon(Slot.WEAPON, testAxe);


        //Getting Values

            System.out.println(Neil.getPlayerClass());
            Neil.levelUp(RpgClassType.WARRIOR, 1);
            System.out.println("=============================");
            System.out.println(Neil.attributesToString());
            Neil.levelUp(RpgClassType.WARRIOR, 1);
            System.out.println("=============================");
            System.out.println(Neil.attributesToString());
            System.out.println(Neil.getCharacterDamageBonus());
            Neil.showArmor(Slot.HEAD);
            System.out.println("Character DPS: " + Neil.getCharacterDps());
            Neil.showWeapon(Slot.WEAPON);


           // Character John = new Character(RpgClassType.ROGUE, 3);


      //  }catch (NullPointerException e){System.out.println(e);

    }
}
