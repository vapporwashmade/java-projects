package org.apoorv.progfun;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class GreeterTest {

    @Test
    public void greeting() {
        String act = Greeter.greeting();
        String exp = "hello, world!";
        Assert.assertEquals("Greetings should match", exp, act);
    }
}