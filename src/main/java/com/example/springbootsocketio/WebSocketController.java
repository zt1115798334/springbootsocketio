package com.example.springbootsocketio;

import com.corundumstudio.socketio.SocketIOClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 *
 * @author zhang tong
 * date: 2019/3/29 16:40
 * description:
 */
@Controller
@RequestMapping("/socket")
public class WebSocketController {


    /**
     * 第一个用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/chatIO1")
    public String chatIO1(HttpServletRequest request) {
        // 假设用户tom登录,存储到session中
        request.getSession().setAttribute("WEBSOCKET_USERNAME", "tom");
        return "chatIO1";
    }
    /**
     * 第一个用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/mess")
    public String mess(HttpServletRequest request) {
        // 假设用户tom登录,存储到session中
        request.getSession().setAttribute("WEBSOCKET_USERNAME", "tom");
        return "mess";
    }

    /**
     * 第一个用户
     *
     * @param request
     * @return
     */
    @RequestMapping("/mseeage")
    @ResponseBody
    public String mseeage(HttpServletRequest request) {
        MessageInfo sendData = new MessageInfo();
        sendData.setMsg("happ");
        for (SocketIOClient client: SocketIoServerMapUtil.getValues()) {
            client.sendEvent("message_event", sendData);
        }
        return "mess";
    }



}
