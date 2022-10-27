package com.ventoss.crud.service;

import com.ventoss.crud.bean.Department;
import com.ventoss.crud.dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Date:2022/7/13
 * Author:Vent
 * Description:
 **/
@Service
public class DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    public List<Department> getDepts(){
        List<Department> list = departmentMapper.selectByExample(null);
        return list;
    }

    public Department getDept(Integer id){
        Department department = departmentMapper.selectByPrimaryKey(id);
        return department;
    }


}
