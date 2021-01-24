package borrow;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.example.borrow.model.Borrow;
import org.example.borrow.repos.BorrowRepository;
import org.example.borrow.services.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.util.stream.StreamSupport;
//import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource(locations="classpath:application-test.properties")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class BorrowingRepositoryUnitTest {
    @MockBean
    NotificationClient notificationClient;

    @Autowired
    private BorrowRepository borrowRepository;

    @Test
    public void testEmptyDb(){
       // assertEquals(0, StreamSupport.stream(borrowRepository.findAll().spliterator(), false).count());
    }
}
