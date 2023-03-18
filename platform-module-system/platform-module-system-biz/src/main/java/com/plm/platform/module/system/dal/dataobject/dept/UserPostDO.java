package com.plm.platform.module.system.dal.dataobject.dept;

import com.plm.platform.framework.mybatis.core.dataobject.BaseDO;
import com.plm.platform.module.system.dal.dataobject.user.AdminUserDO;
import com.baomidou.mybatisplus.annotation.KeySequence;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户和岗位关联
 *
 * @author PDM
 */
@TableName("system_user_post")
@KeySequence("system_user_post_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
public class UserPostDO extends BaseDO {

    /**
     * 自增主键
     */
    @TableId
    private Long id;
    /**
     * 用户 ID
     *
     * 关联 {@link AdminUserDO#getId()}
     */
    private Long userId;
    /**
     * 角色 ID
     *
     * 关联 {@link PostDO#getId()}
     */
    private Long postId;

}
