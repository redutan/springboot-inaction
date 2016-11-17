package io.redutan.springboot.inaction;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AmazonPropertiesTest {

    @Autowired
    AmazonProperties amazonProperties;

    @Test
    public void getAssociateId() throws Exception {
        assertThat(amazonProperties.getAssociateId(), is("redutan"));
    }
}