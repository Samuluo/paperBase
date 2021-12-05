package com.paper.demo.web.controller;

import com.paper.demo.model.domain.Paper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.paper.demo.common.JsonResponse;
import com.paper.demo.service.ExamService;
import com.paper.demo.model.domain.Exam;


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
@RequestMapping("/exam")
public class ExamController {

    private final Logger logger = LoggerFactory.getLogger( ExamController.class );

    @Autowired
    private ExamService examService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Exam  exam =  examService.getById(id);
        return JsonResponse.success(exam);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        examService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateExam(@PathVariable("id") Integer  id,Exam  exam) throws Exception {
        exam.setId(id);
        examService.updateById(exam);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Exam
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Exam  exam) throws Exception {
        examService.save(exam);
        return JsonResponse.success(null);
    }

    /**
     * 描述：随机生成考试
     *
     */
    @RequestMapping(value = "/getExam", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getExam(@RequestParam(value = "openid",required = false)String id)throws Exception {
        Exam exam = examService.getOneRandomly();
        return JsonResponse.success(exam);
    }

    /**
     * 描述：获取考试分数
     *
     */
    @RequestMapping(value = "/getScore", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse getScore(@RequestParam(value = "id")String id)throws Exception {
        Exam exam = examService.getById(id);
        return JsonResponse.success(exam);
    }
}

