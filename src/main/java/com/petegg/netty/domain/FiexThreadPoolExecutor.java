package com.petegg.netty.domain;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Title: FiexThreadPoolExecutor</p>
 * <p>Description: com.petegg.netty.domain</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月14日
 */
public class FiexThreadPoolExecutor extends ThreadPoolExecutor {
  private static Logger logger = LoggerFactory.getLogger(FiexThreadPoolExecutor.class);
  private String poolName;


  public FiexThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
          long keepAliveSecond, String poolName) {
      super(corePoolSize, maximumPoolSize, keepAliveSecond, TimeUnit.SECONDS,
              new LinkedBlockingQueue<Runnable>(10 * corePoolSize), Executors
                      .defaultThreadFactory());
      this.poolName = poolName;
      setRejectedExecutionHandler(new DiscardPolicy() {
          @Override
          public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
              StackTraceElement stes[] = Thread.currentThread()
                      .getStackTrace();
              for (StackTraceElement ste : stes) {
                  logger.warn(ste.toString());
              }
          }

      });
  }

  public FiexThreadPoolExecutor(int corePoolSize, int maximumPoolSize,
          long keepAliveSecond) {
      super(corePoolSize, maximumPoolSize, keepAliveSecond, TimeUnit.SECONDS,
              new LinkedBlockingQueue<Runnable>(10 * corePoolSize));
      setRejectedExecutionHandler(new DiscardPolicy() {

          @Override
          public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
              StackTraceElement stes[] = Thread.currentThread()
                      .getStackTrace();
              for (StackTraceElement ste : stes) {
                  logger.warn(ste.toString());
              }
          }

      });
  }

  @Override
  public void execute(Runnable command) {
      super.execute(command);
      if (super.getCorePoolSize() * 10 - this.getQueue()
              .remainingCapacity()>100) {
          logger.error(poolName
                  + " ThreadPool blocking Queue  size : "
                  + (super.getCorePoolSize() * 10 - this.getQueue()
                          .remainingCapacity()));
      }
  }

}

