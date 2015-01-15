package com.thoughtworks.academy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertNull;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;

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
}
