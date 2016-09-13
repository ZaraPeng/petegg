package com.petegg.socketio.bussiness;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.petegg.Constants;
import com.petegg.enume.ActionEnu;
import com.petegg.service.bussiness.EventService;
import com.petegg.socketio.request.WashRequest;
import com.petegg.socketio.response.BaseResponse;
import com.petegg.socketio.vo.WashVO;

/**
 * <p>
 * Title: 宠物洗澡事件
 * </p>
 * <p>
 * Description: com.corundumstudio.socketio.demo
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月23日
 */
@Component
public class WashEventServer {
  private static Logger log = LoggerFactory.getLogger(WashEventServer.class);
  @Autowired
  private EventService eventService;

  public void listener(final SocketIOServer server) throws InterruptedException {

    // 监听数据事件
    server.addEventListener("washEvent", WashRequest.class, new DataListener<WashRequest>() {

      @Override
      public void onData(SocketIOClient client, WashRequest data, AckRequest ackSender)
          throws Exception {
        WashEventServer.log.info("client[{}] 获取的数据 [{}]", client.getSessionId(),
            JSONObject.toJSONString(data));

        // 业务处理更新状态值

        WashVO washVO = new WashVO();
        washVO.setPetStatus(eventService.washAction(data.getPetInfoId(), ActionEnu.WASH.value()));

        BaseResponse response = new BaseResponse();
        response.setData(washVO);
        response.setCode(Constants.CODE_SUCCESS);
        response.setMsg(ActionEnu.WASH.getMsg() + "更新状态值成功");
        // 发送给单独客服端
        server.getClient(client.getSessionId()).sendEvent("washEvent",
            JSONObject.toJSONString(response));
      }

    });
  }
}
