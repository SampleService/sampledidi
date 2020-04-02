package com.septemberhx.didi.utils;

import com.septemberhx.common.bean.MResponse;
import com.septemberhx.mclient.utils.MVerRequestUtils;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @author SeptemberHX
 * @version 0.1
 * @date 2019/12/3
 */
public class MBaseUtils {

    public static String generateStringInKBSize(int kbSize, MResponse response) {
        // 1 kb is 1024 characters
        StringBuilder stringBuffer = new StringBuilder();
        for (int i = 0; i < 1024 * kbSize; ++i) {
            stringBuffer.append('+');
        }
        String str = stringBuffer.toString();
        response.set("data", str);

        return str;
    }

    public static MResponse generateResInKBSize(int kbSize) {
        MResponse response = MResponse.successResponse();
        generateStringInKBSize(kbSize, response);
        return response;
    }

    public static boolean verDepRequest(String depId, int kbSize, HttpServletRequest request, Logger logger) {
        MResponse r1 = MVerRequestUtils.request(depId, MBaseUtils.generateResInKBSize(kbSize), RequestMethod.POST, request);
        if (r1 == null || r1.isFailed()) {
            logger.error("Failed to perform [weather] dep request");
            return false;
        } else {
            logger.error("Success to perform [weather] dep request");
            return true;
        }
    }
}
