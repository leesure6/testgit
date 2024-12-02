package com.sure.zerotoone.controller;

import com.sure.zerotoone.common.BaseResponse;
import com.sure.zerotoone.common.ErrorCode;
import com.sure.zerotoone.common.ResultUtils;
import com.sure.zerotoone.exception.BusinessException;
import com.sure.zerotoone.model.dto.interfaceInfo.InterfaceInfoAddRequest;
import com.sure.zerotoone.model.entity.InterfaceInfo;
import com.sure.zerotoone.model.entity.User;
import com.sure.zerotoone.service.InterfaceInfoService;
import com.sure.zerotoone.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/interfaceInfo")

public  class InterfaceInfoController{
    @Resource
    private InterfaceInfoService interfaceInfoService;

    @Resource
    private UserService userService;

    @RequestMapping("/add")
    @ResponseBody

    public BaseResponse<Long> addInterfaceInfo(@RequestBody InterfaceInfoAddRequest interfaceInfoAddRequest, HttpServletRequest request){
        if (interfaceInfoAddRequest == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        InterfaceInfo interfaceInfo = new InterfaceInfo();
        BeanUtils.copyProperties(interfaceInfoAddRequest, interfaceInfo);
        // 校验
        interfaceInfoService.validInterfaceInfo(interfaceInfo, true);
        User loginUser = userService.getLoginUser(request);
        interfaceInfo.setUserId(loginUser.getId());
        boolean result = interfaceInfoService.save(interfaceInfo);
        if (!result) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR);
        }
        long newInterfaceInfoId = interfaceInfo.getId();
        return ResultUtils.success(newInterfaceInfoId);

    }

    @GetMapping("/get")
    public String getNameByGet(String name, HttpServletRequest request) {
        System.out.println(request.getHeader("yupi"));
        return "GET 你的名字是" + name;
    }

    @PostMapping("/post")
    public String getNameByPost(@RequestParam String name) {
        return "POST 你的名字是" + name;
    }
}
