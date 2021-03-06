package utilclass;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
	private final static Logger logger = LogManager.getLogger(Log4j2Test.class);

	public static void start() {
		long beginTime = System.currentTimeMillis();

		for (int i = 0; i < 100; i++) {
			logger.trace("trace level");
			logger.debug("debug level");
			logger.info("info level");
			logger.warn("warn level");
			logger.error("error level");
			logger.fatal("fatal level");
		}

		logger.info("请求处理结束，耗时：{}毫秒", (System.currentTimeMillis() - beginTime)); // 第一种用法
		logger.debug("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime) + "毫秒"); // 第二种用法
		logger.warn("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime) + "毫秒"); // 第二种用法
		logger.error("请求处理结束，耗时：" + (System.currentTimeMillis() - beginTime) + "毫秒"); // 第二种用法

	}

	public static void main(String[] args) {
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					start();
				}
			}
		}).start();
		new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {

					start();
				}
			}
		}).start();

	}
}
