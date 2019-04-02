package com.ll.microcloud.rest;

import com.ll.microcloud.service.IDeptService;
import com.ll.vo.Dept;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program: microcloud
 * @description: DeptRest of Controller
 * @author: liuliang
 * @create: 2019-04-02 15:28
 **/
@RestController
public class DeptRest {
    @Resource
    private IDeptService deptService ;
    @RequestMapping(value="/dept/get/{id}",method= RequestMethod.GET)
    public Object get(@PathVariable("id") long id) {
        return this.deptService.get(id) ;
    }
    @RequestMapping(value="/dept/add",method=RequestMethod.GET)
    public Object add(@RequestBody Dept dept) {
        return this.deptService.add(dept) ;
    }
    @RequestMapping(value="/dept/list",method=RequestMethod.GET)
    public Object list() {
        return this.deptService.list() ;
    }
}
