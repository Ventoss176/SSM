package com.ventoss.crud.controller;

import com.ventoss.crud.bean.Department;
import com.ventoss.crud.bean.Msg;
import com.ventoss.crud.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Date:2022/7/13
 * Author:Vent
 * Description:部门控制器
 **/
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    /**
     * 获取部门信息
     */
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){

        List<Department> list = departmentService.getDepts();
        return Msg.success().add("depts", list);
    }
}
