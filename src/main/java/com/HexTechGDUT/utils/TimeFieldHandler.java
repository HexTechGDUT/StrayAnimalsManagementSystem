package com.HexTechGDUT.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 实体类共有属性自动填充;
 * create_time & update_time;
 * @author HexTechGDUT
 */
@Component
public class TimeFieldHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createTime", LocalDateTime.now(), metaObject);
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        //数据库已经设置更新时插入当前时间戳，这里可以不再添加值
        this.setFieldValByName("updateTime", LocalDateTime.now(), metaObject);
    }
}
