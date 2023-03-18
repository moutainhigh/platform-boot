package com.plm.platform.module.system.job;

import com.plm.platform.framework.quartz.core.handler.JobHandler;
import com.plm.platform.framework.tenant.core.context.TenantContextHolder;
import com.plm.platform.framework.tenant.core.job.TenantJob;
import com.plm.platform.module.system.dal.dataobject.user.AdminUserDO;
import com.plm.platform.module.system.dal.mysql.user.AdminUserMapper;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
@TenantJob // 标记多租户
public class DemoJob implements JobHandler {

    @Resource
    private AdminUserMapper adminUserMapper;

    @Override
    public String execute(String param) throws Exception {
        System.out.println("当前租户：" + TenantContextHolder.getTenantId());
        List<AdminUserDO> users = adminUserMapper.selectList();
        return "用户数量：" + users.size();
    }

}
