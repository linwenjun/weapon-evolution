package com.thoughtworks.academy;

import com.thoughtworks.academy.equipment.Weapon;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class SoldierTest {

    @Test
    public void testName() throws Exception {
        Soldier jack = new Soldier("jack", 100, 10);
        Weapon weapon = mock(Weapon.class);

        jack.setWeapon(weapon);

        assertThat(jack.getCareer(), is("战士"));
        assertThat(jack.getWeapon(), is(weapon));
    }

}
