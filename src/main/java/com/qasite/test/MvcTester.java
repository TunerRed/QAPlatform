package com.qasite.test;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 使用Spring测试模块提供的测试请求功能，测试crud的正确性
 * Spring4测试需要servlet3.0支持
 * @author copywang
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations= {"classpath:applicationContext.xml",
        "classpath:spring-mvc.xml"})
public class MvcTester {
    @Autowired
    WebApplicationContext context;
    //虚拟MVC请求，获取到处理结果
    MockMvc mockMvc;

    @Before
    public void initMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }
    @Test
    public void testPage() throws Exception {
        //模拟请求拿到返回值
        String result = mockMvc.perform(MockMvcRequestBuilders.post("/common/login")
                .contentType("application/json;charset=utf-8")
                .param("email","12@qq.com").param("password","123456"))
                .andDo(print())         //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString();
        /*Map<String,String[]> map = result.getRequest().getParameterMap();
        for (String attr :map.keySet()
             ) {
            System.out.println(attr+" : "+map.get(attr));
        }
        System.out.println(result.getResponse().getContentAsString());*/
        System.out.println(result);
    }
}
