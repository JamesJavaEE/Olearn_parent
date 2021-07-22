package com.example.serviceedu.controller;


import com.example.commonutils.CommonReturn;
import com.example.serviceedu.entity.EduTeacher;
import com.example.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Junzhou Liu
 * @since 2021-07-21
 */
@Api(description="teacher management")
@RestController //responsebody返回json controller ioc容器
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {
    //注入service
    @Autowired
    private EduTeacherService eduTeacherService;

    // 查询讲师表的所有数据
    //rest风格
    @ApiOperation(value="query all teacher")
    @GetMapping("findAll")
    public CommonReturn findAllTeacher(){
        //参数wrapper是空
        List<EduTeacher> list = eduTeacherService.list(null);
        return CommonReturn.success().data("teachers",list);
    }

    //讲师的逻辑删除 浏览器不能/delete 需要用swagger测试
    @DeleteMapping("{id}")
    @ApiOperation(value="logical delete teacher ")
    public CommonReturn removeTeacher(@ApiParam(name="id",value="teacher id",required = true) @PathVariable("id") String id){
        boolean flag = eduTeacherService.removeById(id);
        if(flag) return CommonReturn.success();
        return CommonReturn.error();
    }

}

