package com.thoughtworks.academy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.*;
import static org.powermock.api.mockito.PowerMockito.verifyNew;
import static org.powermock.api.mockito.PowerMockito.whenNew;


@PrepareForTest(AttackManager.class)
@RunWith(PowerMockRunner.class)
public class AttackManagerTest {

    @Test
    public void testManagerOneAttack() throws Exception {
        AttackManager attackManager = new AttackManager();
        IAttack bodyAttack = new PhysicalAttack();
        attackManager.add(bodyAttack);

        Map<String, IAttack> attackMap = attackManager.getMap();
        assertThat(attackMap.get("physical"), is(bodyAttack));
    }

    @Test
    public void testManagerMoreThanOneAttack() throws Exception {
        AttackManager attackManager = new AttackManager();
        IAttack attack1 = new PhysicalAttack();
        IAttack attack2 = new PhysicalAttack();

        List<IAttack> attackList = new ArrayList<IAttack>();
        attackList.add(attack1);
        attackList.add(attack2);

        attackManager.add(attackList);

        Map<String, IAttack> expectAttackMap = attackManager.getMap();

        PhysicalAttack attack = (PhysicalAttack)expectAttackMap.get("physical");
        assertThat(attack.getAttack(), is(20));
    }

    @Test
    public void testAttackManagerShouldBeCleanAfterActOnReceiver() throws Exception {
        AttackManager attackManager = new AttackManager();
        IAttack attack1 = new PhysicalAttack();
        IAttack attack2 = new PhysicalAttack();

        List<IAttack> attackList = new ArrayList<IAttack>();
        attackList.add(attack1);
        attackList.add(attack2);

        attackManager.add(attackList);

        Player tom = mock(Player.class);
        attackManager.actOnReceiver(tom);

        Map<String, IAttack> expectAttackMap = attackManager.getMap();
        PhysicalAttack attack = (PhysicalAttack)expectAttackMap.get("physical");
        assertNull(attack);
    }

    @Test
    public void testAttackManagerShouldInvokeActOnProvider() throws Exception {

        Player provider = mock(Player.class);
        Player receiver = mock(Player.class);
        AttackManager attackManager = mock(AttackManager.class);

        Turn turn = new Turn(attackManager);
        turn.process(provider, receiver);
        verify(attackManager, times(1)).actOnPlayer(provider, receiver);
    }

    @Test
    public void testActOnPlayer() throws Exception {
        Player tom = mock(Player.class);
        Player bob = mock(Player.class);

        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));
        AttackManager attackManager = new AttackManager();
        attackManager.actOnPlayer(tom, bob);

        verifyNew(GameMessage.class).withArguments(eq("attack"), anyObject());
    }
}
