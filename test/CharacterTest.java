import attributes.RpgClassType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CharacterTest {
    @Test
    void isLevelOne_levelOne_true(){
        var levelOneChecker = new Character();
        assertTrue(levelOneChecker.getLevel() == 1);
    }
    @Test
    void levelUpTo2_levelOneToLevelTwo_true(){
        var levelUpChecker = new Character();
        levelUpChecker.setPlayerClass(RpgClassType.WARRIOR);
        levelUpChecker.classAttributes(RpgClassType.WARRIOR, 1);
        levelUpChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        levelUpChecker.levelUp(levelUpChecker.getPlayerClass(),1);
        assertTrue(levelUpChecker.getLevel() == 2);
        }
    @Test
    void zeroLevelUp_levelOneToLevelOne_true(){
        var levelUpChecker = new Character();
        levelUpChecker.setPlayerClass(RpgClassType.WARRIOR);
        levelUpChecker.classAttributes(RpgClassType.WARRIOR, 1);
        levelUpChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        assertThrows(IllegalArgumentException.class, ()-> levelUpChecker.levelUp(levelUpChecker.getPlayerClass(),0));

    }
    @Test
    void warriorDefaultAttributes_levelOne_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.WARRIOR);
        attributeChecker.classAttributes(RpgClassType.WARRIOR, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        int expected[] = new int[]{10,5,2,1};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void mageDefaultAttributes_levelOne_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.MAGE);
        attributeChecker.classAttributes(RpgClassType.MAGE, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.MAGE);
        int expected[] = new int[]{5,1,1,8};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void rangerDefaultAttributes_levelOne_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.RANGER);
        attributeChecker.classAttributes(RpgClassType.RANGER, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.RANGER);
        int expected[] = new int[]{8,1,7,1};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void rougeDefaultAttributes_levelOne_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.ROGUE);
        attributeChecker.classAttributes(RpgClassType.ROGUE, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.ROGUE);
        int expected[] = new int[]{8,2,6,1};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void warriorLevelTwoAttributes_levelOneToLevelTwo_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.WARRIOR);
        attributeChecker.classAttributes(RpgClassType.WARRIOR, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        attributeChecker.levelUp(attributeChecker.getPlayerClass(),1);
        int expected[] = new int[]{15,8,4,2};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void mageLevelTwoAttributes_levelOneToLevelTwo_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.MAGE);
        attributeChecker.classAttributes(RpgClassType.MAGE, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.MAGE);
        attributeChecker.levelUp(attributeChecker.getPlayerClass(),1);
        int expected[] = new int[]{8,2,2,13};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void rougeLevelTwoAttributes_levelOneToLevelTwo_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.ROGUE);
        attributeChecker.classAttributes(RpgClassType.ROGUE, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.ROGUE);
        attributeChecker.levelUp(attributeChecker.getPlayerClass(),1);
        int expected[] = new int[]{11,3,10,2};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void rangerLevelTwoAttributes_levelOneToLevelTwo_true(){
        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.RANGER);
        attributeChecker.classAttributes(RpgClassType.RANGER, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.RANGER);
        attributeChecker.levelUp(attributeChecker.getPlayerClass(),1);
        int expected[] = new int[]{10,2,12,2};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getPrimary().getVitality(), attributeChecker.getPrimary().getStrength()
                ,attributeChecker.getPrimary().getDexterity(), attributeChecker.getPrimary().getIntelligence()};
        assertArrayEquals(expected, classAttributesAtLevelOne);
    }
    @Test
    void secondaryAttributes_levelOneToLevelTwo_true(){

        var attributeChecker = new Character();
        attributeChecker.setPlayerClass(RpgClassType.WARRIOR);
        attributeChecker.classAttributes(RpgClassType.WARRIOR, 1);
        attributeChecker.setCharacterDamageBonus(RpgClassType.WARRIOR);
        attributeChecker.levelUp(attributeChecker.getPlayerClass(),1);
        int expected[] = new int[]{150,12,2};
        int classAttributesAtLevelOne[] = new int[]{attributeChecker.getHealth(), attributeChecker.getArmorRating()
                ,attributeChecker.getElementalResistance()};
        assertArrayEquals(expected, classAttributesAtLevelOne);

    }
    }


