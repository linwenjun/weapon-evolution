package com.thoughtworks.academy.additionalAttackState;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class AdditionalAttackStateTest {

    private AdditionalAttackState attackState;

    @Before
    public void setUp() throws Exception {
        attackState = mock(AdditionalAttackState.class);
        when(attackState.getType()).thenReturn("fake");
        when(attackState.update(any(AdditionalAttackState.class))).thenReturn(attackState);
        when(attackState.turn(any(AdditionalAttackState.class))).thenCallRealMethod();
    }

    @Test
    public void testTurnWillChangeIfAttackStateTypeIsDiff() throws Exception {
        AdditionalAttackState newAttackState = mock(AdditionalAttackState.class);
        when(newAttackState.getType()).thenReturn("newAttack");
        AdditionalAttackState result = attackState.turn(newAttackState);

        assertThat(result, is(newAttackState));
    }

    @Test
    public void testTurnKeepIfNewAttackStateTypeIsSame() throws Exception {
        AdditionalAttackState newAttackState = mock(AdditionalAttackState.class);
        when(newAttackState.getType()).thenReturn("fake");
        attackState.turn(newAttackState);

        verify(attackState, times(1)).update(newAttackState);
    }
}