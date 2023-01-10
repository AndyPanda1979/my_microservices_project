package net.exclamation;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;

/**
 * Unit test for simple App.
 */
public class AppTest
{

    @BeforeAll
    public static void initData() {
        System.out.println("Initialization...");
    }

    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
