package com.thoughtworks.academy.equipment;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShortWeaponTest {

    ShortWeapon shortWeapon;

    @Before
    public void setUp() throws Exception {

        shortWeapon = new ShortWeapon("峨眉刺", 5);
    }

    @Test
    public void testNewShortWeapon() throws Exception {

        assertThat(shortWeapon.getSize(), is(1));
        assertThat(shortWeapon.getName(), is("峨眉刺"));
        assertThat(shortWeapon.getAttackValue(), is(5));
    }
}
