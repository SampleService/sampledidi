package com.septemberhx.didi.controller;

import com.septemberhx.common.bean.MResponse;
import com.septemberhx.didi.utils.MBaseUtils;
import com.septemberhx.mclient.annotation.MFuncDescription;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

    private Logger logger = LogManager.getLogger(this);

    @PostMapping(path = "/taxi")
    @ResponseBody
    @MFuncDescription(value = "taxi", level = 2)
    public MResponse weather(@RequestBody MResponse params, HttpServletRequest request) {

        boolean r = MBaseUtils.verDepRequest("weather", 20, request, logger)
                && MBaseUtils.verDepRequest("pay", 18, request, logger);

        if (!r) {
            return MResponse.failResponse();
        }
        return MBaseUtils.generateResInKBSize(13);
    }

    @PostMapping(path = "/rent")
    @ResponseBody
    @MFuncDescription(value = "rent", level = 1)
    public MResponse rent(@RequestBody MResponse params, HttpServletRequest request) {

        boolean r = MBaseUtils.verDepRequest("pay", 18, request, logger);

        if (!r) {
            return MResponse.failResponse();
        }
        return MBaseUtils.generateResInKBSize(13);
    }
}
