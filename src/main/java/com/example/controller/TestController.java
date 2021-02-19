package com.example.controller;

import com.example.core.model.Result;
import com.example.model.LoginModel;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@Api(tags = "01-模块")
@RestController
@RequestMapping("/v1")
public class TestController {

    @ApiOperation(value = "列表查询")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "state", value = "状态数组", required = false),
        @ApiImplicitParam(paramType="query", name = "page", value = "页码（默认为1）", required = false, dataType = "Long"),
        @ApiImplicitParam(paramType="query", name = "pagesize", value = "每页记录数（默认为10）", required = false, dataType = "Long"),
        @ApiImplicitParam(paramType="query", name = "startTime", value = "开始时间，long类型毫秒级时间戳", required = false, dataType = "Long"),
        @ApiImplicitParam(paramType="query", name = "endTime", value = "结束时间，long类型毫秒级时间戳", required = false, dataType = "Long")
    })
    @GetMapping("/list")
    public Result queryList(
            @RequestParam(name = "page", defaultValue = "1") Long page,
            @RequestParam(name = "pagesize", defaultValue = "10") Long pagesize,
            @RequestParam(name = "state", required = false) List<String> state,
            @RequestParam(name = "startTime", required = false) Timestamp startTime,
            @RequestParam(name = "endTime", required = false) Timestamp endTime) {
        return Result.success();
    }

    @ApiOperation(value = "登录")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType="query", name = "appId", value = "应用ID", required = false)
    })
    @PostMapping("/login")
    public Result login(@RequestParam(name = "appId", required = false) Long appId,
                        @RequestBody LoginModel loginModel) {
        return Result.success();
    }
}
