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


@PrepareForTest(PhysicalAttackHandler.class)
@RunWith(PowerMockRunner.class)
public class PhysicalAttackHandlerTest {

    @Test
    public void testManagerOneAttack() throws Exception {
        PhysicalAttackHandler physicalAttackHandler = new PhysicalAttackHandler();

        Player tom = mock(Player.class);
        Player bob = mock(Player.class);
        when(tom.getAttack()).thenReturn(10);

        physicalAttackHandler.actOnPlayers(tom, bob);

        verify(bob, times(1)).beenAttack(10);
    }

    @Test
    public void testManagerMoreThanOneAttack() throws Exception {
        PhysicalAttackHandler physicalAttackHandler = new PhysicalAttackHandler();
        IAttack attack1 = new PhysicalAttack();
        IAttack attack2 = new PhysicalAttack();

        List<IAttack> attackList = new ArrayList<IAttack>();
        attackList.add(attack1);
        attackList.add(attack2);

        physicalAttackHandler.add(attackList);

        Map<String, IAttack> expectAttackMap = physicalAttackHandler.getMap();

        PhysicalAttack attack = (PhysicalAttack)expectAttackMap.get("physical");
        assertThat(attack.getAttack(), is(20));
    }

    @Test
    public void testAttackManagerShouldBeCleanAfterActOnReceiver() throws Exception {
        PhysicalAttackHandler physicalAttackHandler = new PhysicalAttackHandler();
        IAttack attack1 = new PhysicalAttack();
        IAttack attack2 = new PhysicalAttack();

        List<IAttack> attackList = new ArrayList<IAttack>();
        attackList.add(attack1);
        attackList.add(attack2);

        physicalAttackHandler.add(attackList);

        Player tom = mock(Player.class);
        physicalAttackHandler.actOnReceiver(tom);

        Map<String, IAttack> expectAttackMap = physicalAttackHandler.getMap();
        PhysicalAttack attack = (PhysicalAttack)expectAttackMap.get("physical");
        assertNull(attack);
    }

    @Test
    public void testAttackManagerShouldInvokeActOnProvider() throws Exception {

        Player provider = mock(Player.class);
        Player receiver = mock(Player.class);
        PhysicalAttackHandler physicalAttackHandler = mock(PhysicalAttackHandler.class);

        Turn turn = new Turn(physicalAttackHandler);
        turn.process(provider, receiver);
        verify(physicalAttackHandler, times(1)).actOnPlayer(provider, receiver);
    }

    @Test
    public void testActOnPlayer() throws Exception {
        Player tom = mock(Player.class);
        Player bob = mock(Player.class);

        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));
        PhysicalAttackHandler physicalAttackHandler = new PhysicalAttackHandler();
        physicalAttackHandler.actOnPlayer(tom, bob);

        verifyNew(GameMessage.class).withArguments(eq("attack"), anyObject());
    }

    @Test
    public void testActOnPlayerWithWeapon() throws Exception {
        Soldier tom = mock(Soldier.class);
        Player bob = mock(Player.class);
        when(tom.getWeapon()).thenReturn(mock(Weapon.class));

        whenNew(GameMessage.class).withAnyArguments().thenReturn(mock(GameMessage.class));
        PhysicalAttackHandler physicalAttackHandler = new PhysicalAttackHandler();
        physicalAttackHandler.actOnPlayer(tom, bob);

        verifyNew(GameMessage.class).withArguments(eq("attackWithWeapon"), anyObject());
    }
}
