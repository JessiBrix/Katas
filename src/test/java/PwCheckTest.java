import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PwCheckTest {
    private PwCheck pw;

    @Before
    public void init() {
        pw = new PwCheck();
    }

    @Test
    public void testLengthMin8() {
        //8 chars
        assertThat(pw.verify("Aa345678")).isEqualTo(true);
        //more then 8 chars
        assertThat(pw.verify("Aa3456789")).isEqualTo(true);
        //less then 8 chars
        assertThat(pw.verify("Aa34567")).isEqualTo(false);
    }

    @Test
    public void testPwNotEmpty() {
        assertThat(pw.verify("")).isEqualTo(false);
        assertThat(pw.verify("          ")).isEqualTo(false);
    }

    @Test
    public void testContainsCamelCaseAndNumbers() {
        //contains upper and lower case and a number
        assertThat(pw.verify("Aa345678")).isEqualTo(true);
        //contains no lower case
        assertThat(pw.verify("A2345678")).isEqualTo(false);
        //contains no upper case
        assertThat(pw.verify("a2345678")).isEqualTo(false);
        //contains no number
        assertThat(pw.verify("Aaaaaaaa")).isEqualTo(false);
    }
}