package tech.kotlin.china.model

import com.baidu.bjf.remoting.protobuf.EnumReadable
import com.baidu.bjf.remoting.protobuf.FieldType
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.annotation.JsonValue

/*********************************************************************
 * Created by chpengzh@foxmail.com
 * Copyright (c) http://chpengzh.com - All Rights Reserved
 *
 * 用户主账号
 *********************************************************************/
class Account {

    @Protobuf(order = 1, required = true, fieldType = FieldType.UINT64, description = "用户uid")
    @JsonProperty("id")
    var id: Long = 0

    @Protobuf(order = 2, fieldType = FieldType.STRING, description = "密码")
    @JsonProperty("password")
    var password: String = ""

    @Protobuf(order = 3, fieldType = FieldType.UINT64, description = "上次登录时间(毫秒)")
    @JsonProperty("last_login")
    var lastLogin: Long = 0

    @Protobuf(order = 4, required = true, fieldType = FieldType.ENUM, description = "账号状态")
    @JsonProperty("state")
    var state: State = State.NORMAL

    @Protobuf(order = 5, required = true, fieldType = FieldType.ENUM, description = "账号角色")
    @JsonProperty("role")
    var role: Role = Role.NORMAL

    @Protobuf(order = 6, required = true, fieldType = FieldType.UINT64, description = "创建时间")
    @JsonProperty("create_time")
    var createTime: Long = 0

    enum class State : EnumReadable {
        NORMAL, BAN;

        @JsonValue override fun value() = ordinal
    }

    enum class Role : EnumReadable {
        NORMAL, ADMIN;

        @JsonValue override fun value() = ordinal
    }
}