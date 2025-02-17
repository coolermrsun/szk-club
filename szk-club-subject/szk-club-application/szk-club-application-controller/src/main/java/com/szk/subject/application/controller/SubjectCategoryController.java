package com.szk.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.szk.subject.application.convert.SubjectCategoryDTOConverter;
import com.szk.subject.application.dto.SubjectCategoryDTO;
import com.szk.subject.common.entity.Result;
import com.szk.subject.domain.entity.SubjectCategoryBO;
import com.szk.subject.domain.service.SubjectCategoryDomainService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 刷题分类controller
 */
@RestController
@RequestMapping("/subject/category")
@Slf4j
public class SubjectCategoryController {
    @Resource
    private SubjectCategoryDomainService subjectCategoryDomainService;

    /**
     * 新增标签
     * @param subjectCategoryDTO
     * @return
     */
    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectCategoryDTO subjectCategoryDTO)
    {
        try
        {
            if(log.isInfoEnabled())
            {
                log.info("SubjectCategoryController.add.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }

            Preconditions.checkNotNull(subjectCategoryDTO.getCategory_type(),"分类类型不能为空");
            Preconditions.checkArgument(!StringUtils.isBlank(subjectCategoryDTO.getCategory_name()), "分类名称不能为空");
            Preconditions.checkNotNull(subjectCategoryDTO.getParent_id(),"分类父级id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.convertDtoToCategoryBO(subjectCategoryDTO);
            subjectCategoryDomainService.add(subjectCategoryBO);
            return Result.ok(true);
        }catch (Exception e)
        {
            log.error("SubjectCategoryController.add.error:{}", e.getMessage(),e);
            return Result.fail(e.getMessage());
        }
    }
    @PostMapping("/queryPrimaryCategory")
    public Result<List<SubjectCategoryDTO>> queryPrimaryCategory(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try{
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
                    convertBoToCategoryDTOList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        }catch (Exception e)
        {
            log.error("SubjectCategoryController.queryPrimaryCategory.error:{}", e.getMessage(),e);
        }
        return Result.fail("查询失败");
    }
    @PostMapping("/queryPrimaryByPrimary")
    public Result<List<SubjectCategoryDTO>> queryPrimaryByPrimary(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try{
            if(log.isInfoEnabled())
            {
                log.info("SubjectCategoryController.queryPrimaryByPrimary.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            Preconditions.checkNotNull(subjectCategoryDTO.getParent_id(),"分类id不能为空");
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            List<SubjectCategoryBO> subjectCategoryBOList = subjectCategoryDomainService.queryCategory(subjectCategoryBO);
            List<SubjectCategoryDTO> subjectCategoryDTOList = SubjectCategoryDTOConverter.INSTANCE.
                    convertBoToCategoryDTOList(subjectCategoryBOList);
            return Result.ok(subjectCategoryDTOList);
        }catch (Exception e)
        {
            log.error("SubjectCategoryController.queryPrimaryByPrimary.error:{}", e.getMessage(),e);
        }
        return Result.fail("查询失败");
    }

    /**
     * 更新查询
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try{
            if(log.isInfoEnabled())
            {
                log.info("SubjectCategoryController.update.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }
            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);
            Boolean result = subjectCategoryDomainService.update(subjectCategoryBO);
            return Result.ok(result);
        }catch (Exception e)
        {
            log.error("SubjectCategoryController.update.error:{}", e.getMessage(),e);
        }
        return Result.fail("更新分类失败");
    }

    /**
     * 逻辑删除
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectCategoryDTO subjectCategoryDTO) {
        try{
            if(log.isInfoEnabled()) {
                log.info("SubjectCategoryController.delete.dto:{}", JSON.toJSONString(subjectCategoryDTO));
            }

            SubjectCategoryBO subjectCategoryBO = SubjectCategoryDTOConverter.INSTANCE.
                    convertDtoToCategoryBO(subjectCategoryDTO);

            Boolean result = subjectCategoryDomainService.delete(subjectCategoryBO);
            return Result.ok(result);
        }catch (Exception e)
        {
            log.error("SubjectCategoryController.delete.error:{}", e.getMessage(),e);
        }
        return Result.fail("删除分类失败");
    }
}
