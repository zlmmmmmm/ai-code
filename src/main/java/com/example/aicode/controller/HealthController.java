package com.example.aicode.controller;

import com.example.aicode.common.BaseResponse;
import com.example.aicode.common.ResultUtils;
import com.example.aicode.exception.ErrorCode;
import com.example.aicode.exception.ThrowUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthController {

    @GetMapping("/")
    public BaseResponse<String> healthCheck() {
        return ResultUtils.success("ok");
    }

    @GetMapping("/error")
    public BaseResponse healthCheck1() {
        return ResultUtils.error(ErrorCode.FORBIDDEN_ERROR);
    }

    @GetMapping("exception")
    public BaseResponse healthCheck2() {
        if (true){
            ThrowUtils.throwIf(true, ErrorCode.FORBIDDEN_ERROR);
        }
        return ResultUtils.error(ErrorCode.PARAMS_ERROR);
    }
}
