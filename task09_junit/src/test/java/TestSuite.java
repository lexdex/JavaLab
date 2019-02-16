import io.FilesTest;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;
import util.ArrayUtilsTest;

@RunWith(JUnitPlatform.class)
@SelectClasses({FilesTest.class, ArrayUtilsTest.class})
public class TestSuite {

}
