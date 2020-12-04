package two;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

public class AdventDayTwoTest {
    @Test
    public void test_readResourceFile() {
        AdventDayTwo day2 = new AdventDayTwo();
        List<String> lines = day2.readInputFile("test-input");
        assertEquals(3, lines.size());
    }

    @Test
    public void test_parseEntry() {
        PasswordSet set = new PasswordSet("1-3 a: abcde");
        assertEquals("1-3 a", set.getPolicy().toString());
        assertEquals("abcde", set.getPassword());
    }

    @Test
    public void test_verifyPassword() {
        PasswordSet set = new PasswordSet("1-3 a: abcde");
        assertEquals(false, set.verify());
    }

    @Test
    public void test_failedVerification() {
        PasswordSet set = new PasswordSet("1-3 a: aaaab");
        assertEquals(true, set.verify());
    }
}
