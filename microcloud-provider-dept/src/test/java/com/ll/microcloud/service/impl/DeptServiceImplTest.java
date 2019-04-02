package com.ll.microcloud.service.impl;

import com.ll.microcloud.Dept_8001_StartSpringCloudApplication;
import com.ll.microcloud.service.IDeptService;
import com.ll.vo.Dept;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;


@SpringBootTest(classes = Dept_8001_StartSpringCloudApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class DeptServiceImplTest {

    @Resource
    private IDeptService deptService;
    @Test
    public void get() {
        System.out.println(this.deptService.get(1L));
    }

    @Test
    public void add() {
        Dept dept = new Dept() ;
        dept.setDname("测试部-" + System.currentTimeMillis());
        System.out.println(this.deptService.add(dept));
    }

    @Test
    public void list() {
        System.out.println(this.deptService.list());
    }
}