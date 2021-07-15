import Items.*;

import attributes.PrimaryAttributes;
import attributes.RpgClassType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {//Tests based upon the items a player character can equip, and whether or not that instance of a player may equip them.
    @Test void tooHighLevelWeaponEquip_level1PlayerLevel2Weapon_true(){
        //Creating a new instance of a weapon of weaponType AXE, name "Test Axe", slot Slot.Weapon, damage 20, attackSpeed 0.5, and level required 2.
        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(2);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.AXE);
        testAxe.setDamage(20);
        testAxe.setAttackSpeed(0.5);
        //Creating an instance of a character "itemChecker" of playerClass WARRIOR, starting at level 1. Used to test item functionality.
        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);

        assertThrows(InvalidWeaponException.class, ()-> itemChecker.equipWeapon(Slot.WEAPON, testAxe));


    }@Test void tooHighLevelArmorEquip_level1PlayerLevel2Armor_true(){
        //Creating a new instance of armor of armorType Plate, name "Common Plate Body Armor", level required 2, slot Slot.BODY, and with primary attributes (str 1, dex 0, intl, 0, vit 2).
        Armor testPlateBody = new Armor();
        testPlateBody.setName("Common Plate Body Armor");
        testPlateBody.setLevelRequired(2);
        testPlateBody.setSlot(Slot.BODY);
        testPlateBody.setArmorType(ArmorType.PLATE);
        testPlateBody.setPrimary(new PrimaryAttributes(1,0,0,2));

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);

        assertThrows(InvalidArmorException.class, ()-> itemChecker.equipArmor(Slot.BODY, testPlateBody));

    }
    @Test void invalidClassWeaponEquip_warriorPlayerBowWeapon_true(){
        Weapon testBow = new Weapon();
        testBow.setName("Common Bow");
        testBow.setLevelRequired(1);
        testBow.setSlot(Slot.WEAPON);
        testBow.setWeaponType(WeaponType.BOW);
        testBow.setDamage(12);
        testBow.setAttackSpeed(0.8);

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);

        assertThrows(InvalidWeaponException.class, ()-> itemChecker.equipWeapon(Slot.WEAPON, testBow));

    }
    @Test void invalidClassArmorEquip_warriorPlayerClothArmor_true(){
        Armor testClothHead = new Armor();
        testClothHead.setName("Common cloth Head Armor");
        testClothHead.setLevelRequired(1);
        testClothHead.setSlot(Slot.HEAD);
        testClothHead.setArmorType(ArmorType.CLOTH);
        testClothHead.setPrimary(new PrimaryAttributes( 0, 0, 5, 1));

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);

        assertThrows(InvalidArmorException.class, ()-> itemChecker.equipArmor(Slot.BODY, testClothHead));
    }
    @Test void validClassWeaponEquip_warriorPlayerAxeWeapon_true(){
        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(1);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.AXE);
        testAxe.setDamage(20);
        testAxe.setAttackSpeed(0.5);

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        assertTrue( itemChecker.equipWeapon(Slot.WEAPON, testAxe));

    }
    @Test void validArmorEquip_warriorPlayerPlateArmor_true(){
        Armor testPlateBody = new Armor();
        testPlateBody.setName("Common Plate Body Armor");
        testPlateBody.setLevelRequired(1);
        testPlateBody.setSlot(Slot.BODY);
        testPlateBody.setArmorType(ArmorType.PLATE);
        testPlateBody.setPrimary(new PrimaryAttributes(1,0,0,2));

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);

        assertTrue(itemChecker.equipArmor(Slot.BODY, testPlateBody));

    }
    @Test void noWeaponDps_warriorPlayerNoWeapon_true(){

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);

        assertTrue(itemChecker.getCharacterDps() == (1*(5/100)));

    }@Test void weaponDps_warriorPlayerAxeWeapon_true(){
        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(1);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.AXE);
        testAxe.setDamage(7);
        testAxe.setAttackSpeed(1.1);

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        itemChecker.equipWeapon(Slot.WEAPON, testAxe);

        assertTrue(itemChecker.getCharacterDps() == (7*1.1)*(1*(5/100)));

    }@Test void weaponAndArmorDps_warriorPlayerAxeWeaponPlateArmor_true(){
        Weapon testAxe = new Weapon();
        testAxe.setName("Test Axe");
        testAxe.setLevelRequired(1);
        testAxe.setSlot(Slot.WEAPON);
        testAxe.setWeaponType(WeaponType.AXE);
        testAxe.setDamage(7);
        testAxe.setAttackSpeed(1.1);

        Armor testPlateBody = new Armor();
        testPlateBody.setName("Common Plate Body Armor");
        testPlateBody.setLevelRequired(1);
        testPlateBody.setSlot(Slot.BODY);
        testPlateBody.setArmorType(ArmorType.PLATE);
        testPlateBody.setPrimary(new PrimaryAttributes(1,0,0,2));

        var itemChecker = new Character();
        itemChecker.setPlayerClass(RpgClassType.WARRIOR);
        itemChecker.classAttributes(RpgClassType.WARRIOR, 1);
        itemChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        itemChecker.equipWeapon(Slot.WEAPON, testAxe);
        itemChecker.equipArmor(Slot.BODY, testPlateBody);

        assertTrue(itemChecker.getCharacterDps() == (7*1.1)*(1*((5+1)/100)));

    }

}