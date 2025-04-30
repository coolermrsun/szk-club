package com.szk.interview.server.service;

import com.szk.interview.api.req.InterviewReq;
import com.szk.interview.api.req.InterviewSubmitReq;
import com.szk.interview.api.req.StartReq;
import com.szk.interview.api.vo.InterviewQuestionVO;
import com.szk.interview.api.vo.InterviewResultVO;
import com.szk.interview.api.vo.InterviewVO;

public interface InterviewService {

    InterviewVO analyse(InterviewReq req);

    InterviewQuestionVO start(StartReq req);

    InterviewResultVO submit(InterviewSubmitReq req);
}
