package com.septemberhx.didi.controller;

import com.septemberhx.common.bean.MResponse;
import com.septemberhx.mclient.annotation.MFuncDescription;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SeptemberHX
 * @version 0.1
 * @date 2020/3/31
 */
@Controller
public class MainController {

    @PostMapping(path = "/taxi")
    @ResponseBody
    @MFuncDescription(value = "taxi", level = 1)
    public MResponse weather(@RequestBody MResponse params, HttpServletRequest request) {
        return MResponse.successResponse();
    }
}
