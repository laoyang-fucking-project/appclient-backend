package com.kuafu.web.entity;

import java.util.Date;
import java.math.BigDecimal;
import java.util.List;
import com.kuafu.common.entity.StaticResource;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



/**
 * <p>  AI问答 </p>
 *
 * @author kuafuai
 * @description
 * @date 2026/03/27 09:59
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AiChatRecordAll {
    @TableField(value="acr.question_text")
    @JsonProperty("question_text")
    private String questionText;
    @TableField(value="acr.answer_text")
    @JsonProperty("answer_text")
    private String answerText;
    @TableField(value="ui.password")
    @JsonProperty("password")
    private String password;
    @TableField(value="acr.user_info_user_info_id_1")
    @JsonProperty("user_info_user_info_id_1")
    private Integer userInfoUserInfoId1;
    @TableField(value="acr.create_time")
    @JsonProperty("create_time")
    private Date createTime;
    @TableField(value="ui.role_enum_role_enum_id_1")
    @JsonProperty("role_enum_role_enum_id_1")
    private Integer roleEnumRoleEnumId1;
    @TableField(value="acr.audio_url")
    @JsonProperty("audio_url")
    private String audioUrl;
    @TableField(value="ui.phone_number")
    @JsonProperty("phone_number")
    private String phoneNumber;
    @TableField(value="acr.ai_chat_record_id")
    @JsonProperty("ai_chat_record_id")
    private Integer aiChatRecordId;
    @TableField(value="ui.username")
    @JsonProperty("username")
    private String username;










}
