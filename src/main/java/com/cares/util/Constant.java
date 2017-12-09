package com.cares.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Constant {

    private static final Logger logger = LoggerFactory.getLogger(Constant.class);

    //properties文件路径
    private static final String properties_file_url = "baseConfig.properties";
    //properties值
    static final String WX_CHAT_MSG_URL = "wx_chat_msg_url";
    static final String WX_CHAT_MSG_USER = "wx_chat_msg_user";
    static final String WX_CHAT_MSG_AGENTID = "wx_chat_msg_agentid";

    private static Properties props;

    public static synchronized void init() {
        InputStream inputStream = null;
        Properties properties = new Properties();
        try {
            inputStream = Constant.class.getClassLoader().getResourceAsStream(properties_file_url);
            properties.load(inputStream);
        } catch (Exception e) {
            logger.error("====系统加载消息模块baseConfig.properties报错====");
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        logger.info("====系统加载消息模块baseConfig.properties成功====");
        props = properties;
    }

    /**
     * 读取配置项
     *
     * @param key
     * @return
     */
    public static final String getProperty(String key) {
        return props.getProperty(key);
    }
}
