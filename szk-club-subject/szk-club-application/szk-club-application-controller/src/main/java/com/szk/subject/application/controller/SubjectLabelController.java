package com.szk.subject.application.controller;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Preconditions;
import com.szk.subject.application.convert.SubjectLabelDTOConverter;
import com.szk.subject.application.dto.SubjectLabelDTO;
import com.szk.subject.common.entity.Result;
import com.szk.subject.domain.entity.SubjectLabelBO;
import com.szk.subject.domain.service.SubjectLabelDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 标签controller
 */
@RestController
@RequestMapping("/subject/label")
@Slf4j
public class SubjectLabelController {
    /**
     * 新增标签
     * @param subjectCategoryDTO
     * @return
     */
    @Resource
    private SubjectLabelDomainService subjectLabelDomainService;

    @PostMapping("/add")
    public Result<Boolean> add(@RequestBody SubjectLabelDTO subjectLabelDTO)
    {
        try
        {
            if(log.isInfoEnabled())
            {
                log.info("SubjectLabelController.add.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }

            Preconditions.checkNotNull(subjectLabelDTO.getLabelName(),"标签名称不能为空");
            SubjectLabelBO SubjectLabelBO = SubjectLabelDTOConverter.INSTANCE.convertDtoToLabelBO(subjectLabelDTO);
            Boolean result = subjectLabelDomainService.add(SubjectLabelBO);
            return Result.ok(result);
        }catch (Exception e)
        {
            log.error("SubjectLabelController.add.error:{}", e.getMessage(),e);
            return Result.fail("新增标签失败");
        }
    }

    /**
     * 更新标签
     * @return
     */
    @PostMapping("/update")
    public Result<Boolean> update(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try{
            if(log.isInfoEnabled())
            {
                log.info("SubjectLabelController.update.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBO(subjectLabelDTO);
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");
            Boolean result = subjectLabelDomainService.update(subjectLabelBO);
            return Result.ok(result);
        }catch (Exception e)
        {
            log.error("SubjectLabelController.update.error:{}", e.getMessage(),e);
        }
        return Result.fail("更新标签失败");
    }

    /**
     * 删除标签
     * @return
     */
    @PostMapping("/delete")
    public Result<Boolean> delete(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try{
            if(log.isInfoEnabled())
            {
                log.info("SubjectLabelController.delete.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBO(subjectLabelDTO);
            Preconditions.checkNotNull(subjectLabelDTO.getId(),"标签id不能为空");
            Boolean result = subjectLabelDomainService.delete(subjectLabelBO);
            return Result.ok(result);
        }catch (Exception e)
        {
            log.error("SubjectLabelController.delete.error:{}", e.getMessage(),e);
        }
        return Result.fail("删除标签失败");
    }

    /**
     * 查询分类下标签
     * @return
     */
    @PostMapping("/queryLabelByCategoryId")
    public Result<List<SubjectLabelDTO>> queryLabelByCategoryId(@RequestBody SubjectLabelDTO subjectLabelDTO) {
        try{
            if(log.isInfoEnabled())
            {
                log.info("SubjectLabelController.queryLabelByCategoryId.dto:{}", JSON.toJSONString(subjectLabelDTO));
            }
            SubjectLabelBO subjectLabelBO = SubjectLabelDTOConverter.INSTANCE.
                    convertDtoToLabelBO(subjectLabelDTO);
            Preconditions.checkNotNull(subjectLabelDTO.getCategoryId(),"分类id不能为空");
            List<SubjectLabelBO> resultList = subjectLabelDomainService.queryLabelByCategoryId(subjectLabelBO);
            List<SubjectLabelDTO> subjectLabelDTOS = SubjectLabelDTOConverter.INSTANCE.convertBOToLabelDTOList(resultList);
            return Result.ok(subjectLabelDTOS);
        }catch (Exception e)
        {
            log.error("SubjectLabelController.queryLabelByCategoryId.error:{}", e.getMessage(),e);
        }
        return Result.fail("查询分类下标签失败");
    }
}
