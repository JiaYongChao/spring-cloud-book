package com.book.cloud.module.system.api.dept;

import com.book.cloud.framework.common.pojo.CommonResult;
import com.book.cloud.framework.common.util.object.BeanUtils;
import com.book.cloud.module.system.api.dept.dto.DeptRespDTO;
import com.book.cloud.module.system.dal.dataobject.dept.DeptDO;
import com.book.cloud.module.system.service.dept.DeptService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

import static com.book.cloud.framework.common.pojo.CommonResult.success;

@RestController // 提供 RESTful API 接口，给 Feign 调用
@Validated
public class DeptApiImpl implements DeptApi {

    @Resource
    private DeptService deptService;

    @Override
    public CommonResult<DeptRespDTO> getDept(Long id) {
        DeptDO dept = deptService.getDept(id);
        return success(BeanUtils.toBean(dept, DeptRespDTO.class));
    }

    @Override
    public CommonResult<List<DeptRespDTO>> getDeptList(Collection<Long> ids) {
        List<DeptDO> depts = deptService.getDeptList(ids);
        return success(BeanUtils.toBean(depts, DeptRespDTO.class));
    }

    @Override
    public CommonResult<Boolean> validateDeptList(Collection<Long> ids) {
        deptService.validateDeptList(ids);
        return success(true);
    }

}
