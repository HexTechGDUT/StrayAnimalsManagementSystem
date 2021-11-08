package com.HexTechGDUT.service;

import com.HexTechGDUT.po.animal.Animal;

/**
 * @author HexTechGDUT
 */
public interface AnimalService {

    /**
     * 动物登记
     * @param animal 要登记的动物
     * @return 是否登记成功
     */
     boolean register(Animal animal);

    /**
     * 动物信息更新
     * @param animal 要更新信息的动物
     * @return 是否更新成功
     */
    boolean update(Animal animal);
}
