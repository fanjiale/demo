package com.cares.service.impl;

import com.cares.util.Constant;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ConstantLoader implements ApplicationListener<ContextRefreshedEvent> {

    public ConstantLoader() {
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        //root application context 没有parent，他就是老大
        if (event.getApplicationContext().getParent() == null) {
            //初始化消息模块properties文件
            Constant.init();
        }
    }
}
