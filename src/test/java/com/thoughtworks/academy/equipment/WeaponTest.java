package com.thoughtworks.academy.equipment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Random;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.powermock.api.mockito.PowerMockito.whenNew;

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
        AbstractDiamond diamond = new FireDiamond();

        assertThat(weapon.getName(), is("优质木棒"));
        assertThat(weapon.getAttackValue(), is(10));
    }

    @Test
    public void testAttachDiamondMayBeReturnNull() throws Exception {
        AbstractDiamond diamond1 = mock(AbstractDiamond.class);
        AbstractDiamond diamond2 = mock(AbstractDiamond.class);

        Random random = mock(Random.class);
        weapon.attachDiamond(diamond1);
        weapon.attachDiamond(diamond2);

        whenNew(Random.class).withAnyArguments().thenReturn(random);
        when(random.nextDouble()).thenReturn(0.25).thenReturn(0.3);

        assertThat(weapon.getEffectiveDiamond(), is(nullValue()));
    }

    @Test
    public void testAttachDiamondWillReturnNullWhenNoDiamond() throws Exception {
        Random random = mock(Random.class);
        whenNew(Random.class).withAnyArguments().thenReturn(random);
        when(random.nextDouble()).thenReturn(0.1).thenReturn(0.1);

        assertThat(weapon.getEffectiveDiamond(), is(nullValue()));
    }

    @Test
    public void testAttachDiamondMayBeReturnFirstDiamond() throws Exception {
        AbstractDiamond diamond1 = mock(AbstractDiamond.class);
        AbstractDiamond diamond2 = mock(AbstractDiamond.class);

        Random random = mock(Random.class);
        weapon.attachDiamond(diamond1);
        weapon.attachDiamond(diamond2);

        whenNew(Random.class).withAnyArguments().thenReturn(random);
        when(random.nextDouble()).thenReturn(0.1).thenReturn(0.1);

        assertThat(weapon.getEffectiveDiamond(), is(diamond1));
    }

    @Test
    public void testAttachDiamondMayBeReturnThirdDiamond() throws Exception {
        AbstractDiamond diamond1 = mock(AbstractDiamond.class);
        AbstractDiamond diamond2 = mock(AbstractDiamond.class);
        AbstractDiamond diamond3 = mock(AbstractDiamond.class);

        Random random = mock(Random.class);
        weapon.attachDiamond(diamond1);
        weapon.attachDiamond(diamond2);
        weapon.attachDiamond(diamond3);

        whenNew(Random.class).withAnyArguments().thenReturn(random);
        when(random.nextDouble()).thenReturn(0.5).thenReturn(0.25).thenReturn(0.1);

        assertThat(weapon.getEffectiveDiamond(), is(diamond3));
    }

    @Test
    public void testGetEffectiveDiamondWillMaintainResult() throws Exception {
        AbstractDiamond diamond1 = mock(AbstractDiamond.class);
        AbstractDiamond diamond2 = mock(AbstractDiamond.class);
        AbstractDiamond diamond3 = mock(AbstractDiamond.class);

        Random random = mock(Random.class);
        weapon.attachDiamond(diamond1);
        weapon.attachDiamond(diamond2);
        weapon.attachDiamond(diamond3);

        whenNew(Random.class).withAnyArguments().thenReturn(random);
        when(random.nextDouble()).thenReturn(0.5).thenReturn(0.25).thenReturn(0.1).thenReturn(0.1);

        assertThat(weapon.getEffectiveDiamond(), is(diamond3));
        assertThat(weapon.getEffectiveDiamond(), is(diamond3));
    }

    @Test
    public void testGetEffectiveDiamondWillMaintainResultEvenIfResultIsNUll() throws Exception {
        AbstractDiamond diamond1 = mock(AbstractDiamond.class);
        AbstractDiamond diamond2 = mock(AbstractDiamond.class);
        AbstractDiamond diamond3 = mock(AbstractDiamond.class);

        Random random = mock(Random.class);
        weapon.attachDiamond(diamond1);
        weapon.attachDiamond(diamond2);
        weapon.attachDiamond(diamond3);

        whenNew(Random.class).withAnyArguments().thenReturn(random);
        when(random.nextDouble()).thenReturn(0.5).thenReturn(0.5).thenReturn(0.5).thenReturn(0.1);

        assertThat(weapon.getEffectiveDiamond(), is(nullValue()));
        assertThat(weapon.getEffectiveDiamond(), is(nullValue()));
    }

    @Test
    public void testGetEffectiveDiamondWillMaintainResultEvenIfResultIsNullUntilWeaponRestore() throws Exception {
        AbstractDiamond diamond1 = mock(AbstractDiamond.class);
        AbstractDiamond diamond2 = mock(AbstractDiamond.class);
        AbstractDiamond diamond3 = mock(AbstractDiamond.class);

        Random random = mock(Random.class);
        weapon.attachDiamond(diamond1);
        weapon.attachDiamond(diamond2);
        weapon.attachDiamond(diamond3);

        whenNew(Random.class).withAnyArguments().thenReturn(random);
        when(random.nextDouble()).thenReturn(0.5).thenReturn(0.5).thenReturn(0.5).thenReturn(0.1);
        assertThat(weapon.getEffectiveDiamond(), is(nullValue()));
        weapon.restore();
        assertThat(weapon.getEffectiveDiamond(), is(diamond1));
    }
}
