package com.example.invoketest;

import com.example.demo.FileInvoke;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigBean implements InitializingBean {


    @Autowired
    FileInvoke fileInvoke;


    @Override
    public void afterPropertiesSet() throws Exception {
        fileInvoke.invokeFile();
    }
}
