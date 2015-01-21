package com.thoughtworks.academy.equipment;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class LongWeaponTest {
    LongWeapon longWeapon;

    @Before
    public void setUp() throws Exception {

        longWeapon = new LongWeapon("方天画戟", 20);
    }

    @Test
    public void testGetSize() throws Exception {

        assertThat(longWeapon.getSize(), is(3));
        assertThat(longWeapon.getName(), is("方天画戟"));
        assertThat(longWeapon.getAttackValue(), is(20));
    }
}
