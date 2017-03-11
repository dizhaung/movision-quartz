package com.movision.utils.sms;

import java.io.IOException;
import java.util.*;

import com.alibaba.druid.support.json.JSONUtils;
import com.google.gson.Gson;
import org.apache.commons.collections.map.LinkedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.cloopen.rest.sdk.CCPRestSmsSDK;

public class SDKSendTemplateSMS {

    private static Logger log = LoggerFactory.getLogger(SDKSendTemplateSMS.class);

    private static final String SERVER_IP = "app.cloopen.com";
    private static final String PORT = "8883";
    private static final String ACCOUNT_SID = "8a48b55152a56fc20152eea1041e55f2";
    private static final String ACCOUNT_TOKEN = "1c51056e0ae74d7f8302d42b42a162e4";
    private static final String APP_ID = "8a48b55152a56fc20152eea7373d5605";


    /**
     * 发送短信
     *
     * @param mobile
     * @param params
     * @param templateCode
     * @return
     */
    public static Boolean sendSMS(String mobile, String params, String templateCode) {
        try {
            Gson gson = new Gson();
            List<String> paramsList = new ArrayList<>();
            Map<String, String> map = gson.fromJson(params, LinkedMap.class);
            for (Map.Entry<String, String> entry : map.entrySet()) {
                String value = entry.getValue();
                paramsList.add(value);
            }

            HashMap<String, Object> result;
            CCPRestSmsSDK restAPI = new CCPRestSmsSDK();
            restAPI.init(SERVER_IP, PORT);
            // 初始化服务器地址和端口，沙盒环境配置成sandboxapp.cloopen.com，生产环境配置成app.cloopen.com，端口都是8883.
            restAPI.setAccount(ACCOUNT_SID, ACCOUNT_TOKEN);
            // 初始化主账号名称和主账号令牌，登陆云通讯网站后，可在"控制台-应用"中看到开发者主账号ACCOUNT SID和 主账号令牌AUTH TOKEN。
            restAPI.setAppId(APP_ID);
            // 初始化应用ID，如果是在沙盒环境开发，请配置"控制台-应用-测试DEMO"中的APPID。
            //如切换到生产环境，请使用自己创建应用的APPID
            result = restAPI.sendTemplateSMS(mobile, templateCode,
                    paramsList.toArray(new String[paramsList.size()]));
            log.info("SDKTestGetSubAccounts result=" + result);
            if ("000000".equals(result.get("statusCode"))) {
                //正常返回输出data包体信息（map）
                return true;
            } else {
                //异常返回输出错误码和错误信息
                log.info("错误码=" + result.get("statusCode") + " 错误信息= " + result.get("statusMsg"));
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            log.error("发送短信异常");
            return false;
        }

    }




    public static void main(String[] args) throws IOException {
        Map<String, String> map = new HashMap<>();
        map.put("code", "3798");
        map.put("time", "10");
        String params = JSONUtils.toJSONString(map);
        boolean suc = SDKSendTemplateSMS.sendSMS("18652093798", params, "1");
        System.out.println(suc);
    }

}
