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
import com.petegg.socketio.request.ContinueActionRequest;
import com.petegg.socketio.response.BaseResponse;
import com.petegg.socketio.vo.ContinueActionVO;

/**
 * <p>Title: ContinueEventServer</p>
 * <p>Description: com.petegg.socketio.bussiness</p>
 * <p>Copyright: Copyright (c) 2015</p>
 * <p>Company: 客如云</p>
 * @author    Peng Yanan
 * @date      2016年9月14日
 */
@Component
public class ContinueEventServer {
  
private static Logger log = LoggerFactory.getLogger(ContinueEventServer.class);
  
  @Autowired
  private EventService eventService;

  public void listener(final SocketIOServer server) throws InterruptedException {

    // 监听数据事件
    server.addEventListener("continueActionEvent", ContinueActionRequest.class, new DataListener<ContinueActionRequest>() {

      @Override
      public void onData(SocketIOClient client, ContinueActionRequest data, AckRequest ackSender)
          throws Exception {
        ContinueEventServer.log.info("client[{}] 获取的数据 [{}]", client.getSessionId(),
            JSONObject.toJSONString(data));

        // 业务处理更新状态值

        ContinueActionVO continueActionVO = new ContinueActionVO();
        continueActionVO.setPetStatus(eventService.washAction(data.getPetInfoId(),
            ActionEnu.getById(data.getActionId()).value()));

        BaseResponse response = new BaseResponse();
        response.setData(continueActionVO);
        response.setCode(Constants.CODE_SUCCESS);
        response.setMsg(ActionEnu.getById(data.getActionId()).getMsg() + "更新状态值成功");
        // 发送给单独客服端
        server.getClient(client.getSessionId()).sendEvent("continueActionEvent",
            JSONObject.toJSONString(response));
      }

    });
  }
}

