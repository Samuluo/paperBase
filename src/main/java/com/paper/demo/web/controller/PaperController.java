package com.paper.demo.web.controller;

import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.paper.demo.common.JsonResponse;
import com.paper.demo.service.PaperService;
import com.paper.demo.model.domain.Paper;


/**
 *
 *  前端控制器
 *
 *
 * @author hjh
 * @since 2021-12-03
 * @version v1.0
 */
@Controller
@CrossOrigin
@RequestMapping("/paper")
public class PaperController {

    private final Logger logger = LoggerFactory.getLogger( PaperController.class );

    @Autowired
    private PaperService paperService;


    /**
     * 描述:根据题目id获取题目
     *
     */
    @RequestMapping(value = "/get", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse get(@RequestParam(value = "paperId",required = true) String paperId) {
        Paper paper = paperService.getById(paperId);
        return JsonResponse.success(paper);
    }

    /**
     * 描述:随机获取一题
     *
     */
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getOne(@RequestParam(value = "openid",required = false) String userId) {
        Paper paper = paperService.getOneRandomly();
        return JsonResponse.success(paper);
    }

    /**
     * 描述:考试，随机获取十题
     *
     */
    @RequestMapping(value = "/getExam", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getExam(@RequestParam(value = "openid",required = false) String userId) {
        List<Paper> paperList = paperService.getExam();
        return JsonResponse.success(paperList);
    }

}

