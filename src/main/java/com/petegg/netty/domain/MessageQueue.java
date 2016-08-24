package com.petegg.netty.domain;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * <p>Title: MessageQueue</p>
 * <p>Description: com.petegg.netty.domain</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年8月14日
 */
public class MessageQueue {
  private Queue<GameRequest> requestQueue;
  private boolean running = false;

  public MessageQueue(ConcurrentLinkedQueue<GameRequest> concurrentLinkedQueue) {
      this.requestQueue = concurrentLinkedQueue;
  }

  public Queue<GameRequest> getRequestQueue() {
      return this.requestQueue;
  }

  public void setRequestQueue(Queue<GameRequest> requestQueue) {
      this.requestQueue = requestQueue;
  }

  public void clear() {
      this.requestQueue.clear();
      this.requestQueue = null;
  }

  public int size() {
      return this.requestQueue != null ? this.requestQueue.size() : 0;
  }

  public boolean add(GameRequest request) {
      return this.requestQueue.add(request);
  }

  public void setRunning(boolean running) {
      this.running = running;
  }

  public boolean isRunning() {
      return this.running;
  }
}
