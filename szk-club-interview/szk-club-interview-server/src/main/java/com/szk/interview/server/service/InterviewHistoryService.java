package com.szk.interview.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.szk.interview.api.common.PageResult;
import com.szk.interview.api.req.InterviewHistoryReq;
import com.szk.interview.api.req.InterviewSubmitReq;
import com.szk.interview.api.vo.InterviewHistoryVO;
import com.szk.interview.api.vo.InterviewResultVO;
import com.szk.interview.server.entity.po.InterviewHistory;

/**
 * 面试汇总记录表(InterviewHistory)表服务接口
 *
 * @author makejava
 * @since 2024-05-23 22:56:03
 */
public interface InterviewHistoryService extends IService<InterviewHistory> {

    void logInterview(InterviewSubmitReq req, InterviewResultVO submit);


    PageResult<InterviewHistoryVO> getHistory(InterviewHistoryReq req);

}
