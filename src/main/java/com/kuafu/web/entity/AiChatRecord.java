package com.kuafu.web.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.*;
import com.kuafu.common.entity.StaticResource;
import com.baomidou.mybatisplus.annotation.TableName;
import com.kuafu.web.annotation.IsNotNullField;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import com.kuafu.common.annotation.*;
/**
 * <p>  AI问答 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/04/14 21:40
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@TableName("ai_chat_record")
public class AiChatRecord  {
    @TableId(value = "ai_chat_record_id", type = IdType.AUTO)
    @JsonProperty("ai_chat_record_id")
    
    
    
    private Integer aiChatRecordId;
    @JsonProperty("user_info_user_info_id_1")
    @IsNotNullField(description = "用户ID")
    
    
    @TableField("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;
    @JsonProperty("question_text")
    @IsNotNullField(description = "提问内容")
    
    
    @TableField("question_text")
    private String questionText;
    @JsonProperty("answer_text")
    
    
    @TableField("answer_text")
    private String answerText;
    @JsonProperty("audio_url")
    
    
    @TableField("audio_url")
    private String audioUrl;
    @JsonProperty("create_time")
    @TableField(fill = FieldFill.INSERT)
    
    
    private Date createTime;





}
