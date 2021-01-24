package borrow;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.example.borrow.controller.BorrowController;
import org.example.borrow.model.Borrow;
import org.example.borrow.repos.BorrowRepository;
import org.example.borrow.services.NotificationClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(BorrowController.class)
@AutoConfigureMockMvc
public class BorrowingControllerUnitTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    NotificationClient notificationClient;

    @MockBean
    private BorrowRepository borrowRepository;

    //GET
    @Test
    public void testGetAllBorrow(){
        try{
            mockMvc.perform(MockMvcRequestBuilders
                    .get("/v2/borrow")
                    .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk());
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }

}
