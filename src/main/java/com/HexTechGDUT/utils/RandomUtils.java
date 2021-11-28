package com.HexTechGDUT.utils;

/**
 * @author HexTechGDUT
 */
public class RandomUtils {

    /**
     * 返回一个随机整数[1, range]
     * @param range 范围
     * @return int
     */
    public static int randomInt(int range){
        // range必定大于1
        range = (range > 0) ? range : 1;
        return (int)(Math.random()*(range-1)+1);
    }
}
