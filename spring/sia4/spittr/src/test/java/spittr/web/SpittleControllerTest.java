package spittr.web;

import static org.hamcrest.Matchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import spittr.SpittrApplication;
import spittr.domain.Spittle;
import spittr.repository.SpittleRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by seoungjuhyun on 3/30/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpittrApplication.class)
public class SpittleControllerTest {

    private static final int COUNT_OF_SPITTLES = 20;

    @Test
    public void shouldShowRecentSpittles() throws Exception {
//        List<Spittle> expectedSpittles = createSpittles(COUNT_OF_SPITTLES);

//        SpittleRepository mockRepository = mock(SpittleRepository.class);
//        when(mockRepository.findAll())
//                .thenReturn(expectedSpittles);

//        SpittleController spittleController =
//                new SpittleController(mockRepository);
        SpittleController spittleController =
                new SpittleController();

        MockMvc mockMvc = standaloneSetup(spittleController).build();
        mockMvc.perform(get("/test"))
                .andExpect(view().name("spittles"));
//                .andExpect(model().attributeExists("spittles"))
//                .andExpect(model().attribute("spittles",
//                        hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittles(int count) {
        List<Spittle> spittles = new ArrayList<Spittle>();

        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, LocalDateTime.now()));
        }

        return spittles;
    }
}
