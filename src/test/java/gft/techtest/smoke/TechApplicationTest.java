package gft.techtest.smoke;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import gft.techtest.TechApplication;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = TechApplication.class)
public class TechApplicationTest {

    @Test
    public void contextLoads() {
    }
}
