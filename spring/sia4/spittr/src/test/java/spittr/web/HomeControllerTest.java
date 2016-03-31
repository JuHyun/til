package spittr.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import spittr.SpittrApplication;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * HomeController Test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SpittrApplication.class)
public class HomeControllerTest {

    @Autowired
    private HomeController homeController;

    @Test
    public void testHomePage() throws Exception {

        MockMvc mockMvc = standaloneSetup(homeController).build();

        for (String pathName : new String[]{"/", "/homepage"}) {
            mockMvc.perform(get(pathName))
                    .andExpect(view().name("welcome/home"));
        }
    }
}
