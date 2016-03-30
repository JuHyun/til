package spittr.web;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Matchers.contains;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

/**
 * Created by seoungjuhyun on 3/30/16.
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
            MvcResult mvcResult = mockMvc.perform(get(pathName))
                    .andExpect(view().name("home"))
                    .andReturn();

            String content = mvcResult.getResponse().getContentAsString();
            assertThat(content, equalTo(contains("Hello,")));
        }
    }
}
