package utilclass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainTest {
	// Logger和LoggerFactory导入的是org.slf4j包
    private final static Logger logger = LoggerFactory.getLogger(MainTest.class);
    public static void main(String[] args) {
        long beginTime = System.currentTimeMillis();

        for(int i = 0; i < 100; i++) {  
            logger.trace("trace level");  
            logger.debug("debug level");  
            logger.info("info level");  
            logger.warn("warn level");  
            logger.error("error level");
        }

        	Log4j2Test.start();  


        logger.info("请求处理结束，耗时：{}毫秒", (System.currentTimeMillis() - beginTime));    //第一种用法
        logger.debug("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime)  + "毫秒");    //第二种用法
        logger.warn("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime)  + "毫秒");    //第二种用法
        logger.error("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime)  + "毫秒");    //第二种用法

    }
}
