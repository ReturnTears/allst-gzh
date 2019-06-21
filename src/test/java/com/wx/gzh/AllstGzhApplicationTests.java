package com.wx.gzh;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AllstGzhApplicationTests {

    @Test
    public void contextLoads() {
        // 1
        String[] strs = new String[]{"TOKEN", "1230125487", "hhh"};
        Arrays.sort(strs);
        // 2 将拍下后的结果拼成一个字符串
        String str = strs[0].concat(strs[1]).concat(strs[2]);
        System.out.println(str);
    }

}
