package com.thoughtworks.academy;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

@PrepareForTest(Weapon.class)
@RunWith(PowerMockRunner.class)
public class WeaponTest {
    private Weapon weapon;

    @Before
    public void setUp() throws Exception {
        weapon = new Weapon("优质木棒", 10);
    }

    @Test
    public void testCreateWeapon() throws Exception {
        assertThat(weapon.getName(), is("优质木棒"));
    }

    @Test
    public void testGetAttackFromWeapon() throws Exception {
        assertThat(weapon.getAttackList().size(), is(1));
        assertThat(weapon.getAttackList().get(0), any(IAttack.class));
    }

    @Test
    public void testGetAttackFromWeaponWithFireAttack() throws Exception {
        FireAttack fireAttack = new FireAttack();

        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(0.5);
        whenNew(Random.class).withNoArguments().thenReturn(random);

        Weapon newWeapon = new Weapon("someWeapon");
        newWeapon.addExtraAttack(fireAttack);

        assertThat(newWeapon.getAttackList().size(), is(1));
    }

    @Test
    public void testGetAttackFromWeaponWithRandomFireAttack() throws Exception {
        FireAttack fireAttack = new FireAttack();

        Random random = mock(Random.class);
        when(random.nextDouble()).thenReturn(0.1);
        whenNew(Random.class).withNoArguments().thenReturn(random);

        Weapon newWeapon = new Weapon("someWeapon");
        newWeapon.addExtraAttack(fireAttack);

        assertThat(newWeapon.getAttackList().size(), is(2));
    }
}
