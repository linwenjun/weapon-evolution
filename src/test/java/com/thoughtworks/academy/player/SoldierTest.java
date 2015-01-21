package com.thoughtworks.academy.player;

import com.thoughtworks.academy.equipment.Weapon;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SoldierTest {

    Soldier jack;

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Before
    public void setUp() throws Exception {

        jack = new Soldier("jack", 100, 10);
    }

    @Test
    public void testNewSoldier() throws Exception {

        assertThat(jack.getCareer(), is("战士"));
    }

    @Test
    public void testSetWeapon() throws Exception {

        Weapon weapon = mock(Weapon.class);
        when(weapon.getSize()).thenReturn(Weapon.MEDIUM_SIZE);
        jack.setWeapon(weapon);
        assertThat(jack.getWeapon(), is(weapon));
    }

    @Test
    public void testSetWeaponWillThrowExceptionWhenSizeIsNotSuitable() throws Exception {

        Weapon weapon = mock(Weapon.class);
        when(weapon.getSize()).thenReturn(Weapon.LONG_SIZE);

        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Unsuitable Weapon Size");

        jack.setWeapon(weapon);
    }
}
