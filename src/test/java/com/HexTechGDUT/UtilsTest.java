package com.HexTechGDUT;

import com.HexTechGDUT.utils.Md5Utils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UtilsTest {

    @Test
    public void md5Test(){
        String en = Md5Utils.encrypt("abc");
        System.out.println(en);
        System.out.println(Md5Utils.verify("abc", en));
    }
}
