package com.kuafu.llm.controller;

import com.kuafu.common.domin.ResultUtils;
import com.kuafu.common.login.LoginUser;
import com.kuafu.common.login.SecurityUtils;
import com.kuafu.llm.chat.Chat;
import com.kuafu.llm.config.LLMStartBusiness;
import com.kuafu.llm.config.PromptConfig;
import com.kuafu.llm.model.ChatResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("chat")
@ConditionalOnProperty(prefix = "llm", name = "enable", havingValue = "true")
public class ChatController {

    @Autowired
    private LLMStartBusiness llmStartBusiness;

    @Autowired
    private Chat chat;

    @Value("${llm.chat.default_prompt}")
    private String defaultPrompt;

    /**
     * 对话流
     *
     * @param chatRequest
     * @return
     */
    @PostMapping("")
    public Object stream(@RequestBody ChatRequest chatRequest, HttpServletRequest request) {
        if (StringUtils.isBlank(chatRequest.getQuery())) {
            return ResultUtils.error("query不能为空");
        }

        List<String> search = llmStartBusiness.search(chatRequest.getQuery());
        log.info("embedding search: {}", search);

        String conversionId = chatRequest.getResolvedConversationId();

        String userId = resolveUserId(chatRequest.getUserId());

        String query = chatRequest.getQuery();

        if (StringUtils.isEmpty(conversionId)) {

            query = PromptConfig.PROMPT + "\n" + query;
//            ChatResponse chatResponse = chat.callApiBlock(PromptConfig.PROMPT + "\n当你接收到这段话时,你只需要回复【收到】即可，不要回复多余的内容",
//                    null, chatRequest.getUserId());
//            conversionId = chatResponse.getConversionId();
        }

        StringBuilder context = new StringBuilder("context is \n");
        for (String s : search) {
            context.append(s).append("\n");
        }
        query = query + "\n" + context;

        log.info("content : {}", query);

        if (isStreamRequest(chatRequest, request)) {
            // 用于创建一个 SSE 连接对象
            SseEmitter emitter = new SseEmitter(3600000L);
            chat.callApiStream(query, conversionId, userId, emitter);
            return emitter;
        }

        ChatResponse chatResponse = chat.callApiBlock(query, conversionId, userId);
        if (chatResponse == null) {
            return ResultUtils.error("聊天服务暂时不可用");
        }

        String nextConversationId = chatResponse.getConversionId();
        if (StringUtils.isBlank(nextConversationId)) {
            nextConversationId = conversionId;
        }

        Map<String, Object> data = new HashMap<>();
        data.put("answer", chatResponse.getAnswer());
        data.put("conversationId", nextConversationId);
        data.put("conversation_id", nextConversationId);
        return ResultUtils.success(data);
    }

    private boolean isStreamRequest(ChatRequest chatRequest, HttpServletRequest request) {
        if (Boolean.TRUE.equals(chatRequest.getStream())) {
            return true;
        }
        String accept = request.getHeader("Accept");
        return StringUtils.containsIgnoreCase(accept, "text/event-stream");
    }

    private String resolveUserId(String requestUserId) {
        if (StringUtils.isNotBlank(requestUserId)) {
            return requestUserId;
        }
        try {
            LoginUser loginUser = SecurityUtils.getLoginUser();
            if (loginUser != null && loginUser.getUserId() != null) {
                return String.valueOf(loginUser.getUserId());
            }
            if (loginUser != null && StringUtils.isNotBlank(loginUser.getRelevanceId())) {
                return loginUser.getRelevanceId();
            }
        } catch (Exception e) {
            log.debug("resolve user id by login context failed: {}", e.getMessage());
        }
        return "anonymous";
    }

}
