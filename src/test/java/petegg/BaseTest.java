package petegg;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * <p>
 * Title: BaseTest
 * </p>
 * <p>
 * Description: petegg.dao
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月13日
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-context.xml"})
@TestPropertySource(properties = {"jdbc.url = jdbc:mysql://127.0.0.1:3306/petegg",
    "jdbc.username = root", "jdbc.pasword=root", "redis.host =127.0.0.1","redis.port=6379","redis.password="})
public class BaseTest {

}
