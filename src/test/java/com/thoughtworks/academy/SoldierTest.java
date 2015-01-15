package com.thoughtworks.academy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class SoldierTest {

    @Test
    public void testName() throws Exception {
        Soldier jack = new Soldier("jack", 100, 10);
        assertThat(jack.getCareer(), is("战士"));
    }

}
