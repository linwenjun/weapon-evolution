package com.thoughtworks.academy;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.*;

public class FireAttackTest {

    @Test
    public void testFireAttackActOnReceiver() throws Exception {
        Player tom = mock(Player.class);

        FireAttack fireAttack = new FireAttack();
        fireAttack.actOnReceiver(tom);
        verify(tom, times(1)).addStateAttack((FireStateAttack) anyObject());
    }

    @Test
    public void testFireAttackAppendTo() throws Exception {
        FireAttack fireAttack = new FireAttack();

        Map<String, IAttack> attackMap = new HashMap<String, IAttack>();
        fireAttack.appendTo(attackMap);
        assertThat(attackMap.get("state"), is((IAttack)fireAttack));
    }
}
