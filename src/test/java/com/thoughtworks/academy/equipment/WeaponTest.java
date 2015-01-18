package com.thoughtworks.academy.equipment;

import com.thoughtworks.academy.attack.FireStateAttack;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Weapon.class)
public class WeaponTest {
    private Weapon weapon;

    @Before
    public void setUp() throws Exception {
        weapon = new Weapon("优质木棒", 10);
    }

    @Test
    public void testCreateWeapon() throws Exception {
        IAttack attackAttack = new FireStateAttack();
        weapon.addExtraAttack(attackAttack);

        assertThat(weapon.getName(), is("优质木棒"));
        assertThat(weapon.getAttackValue(), is(10));
        assertThat(weapon.getExtraAttack(), is(attackAttack));
    }
}
