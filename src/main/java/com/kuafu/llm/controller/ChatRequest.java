package com.kuafu.llm.controller;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class ChatRequest {

    @NotBlank(message = "query不能为空")
    private String query;

    /**
     * 历史字段（拼写保留兼容）
     */
    private String conversionId;

    /**
     * 新字段（前端常用）
     */
    private String conversationId;

    private String userId;

    /**
     * stream=true 时返回 SSE；否则返回阻塞 JSON 结果
     */
    private Boolean stream;

    public String getResolvedConversationId() {
        if (conversationId != null && !conversationId.trim().isEmpty()) {
            return conversationId;
        }
        return conversionId;
    }
}
