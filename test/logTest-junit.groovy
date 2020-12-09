import com.lesfurets.jenkins.unit.BasePipelineTest
import org.junit.Before
import org.junit.Test
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class logTest extends  BasePipelineTest {

    def log

    @Before
    void setUp() {
        super.setUp()
        log = loadScript("vars/log.groovy")
    }

    @Test
    void logInfo() {
        log.info("info message info")
        assertThat(helper.methodCallCount("info"), is(1L))
    }

    @Test
    void logWarn() {
        log.warn("warn message")
        assertThat(helper.methodCallCount("warn"), is(1L))
        printCallStack()
    }

}