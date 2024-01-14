package com.book.cloud.module.user.dal.dataobject;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.book.cloud.framework.mybatis.core.dataobject.BaseDO;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @ClassNAME BookUserDO
 * @Description TODO
 * @Author jiayongchao
 * @Date 2024/1/14 21:36
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@TableName("cloud_book_user")
public class BookUserDO extends BaseDO {
    //用户id
    @TableId
    private Long userId;
    //用户名
    private String userName;
    //用户密码
    private String password;
    //用户昵称
    private String userNickname;
    //用户联系方式
    private String  userPhone;
    //用户性别
    private Integer userSex;
    //用户年龄
    private Integer userAge;
    //用户地址
    private String userAddress;

}
