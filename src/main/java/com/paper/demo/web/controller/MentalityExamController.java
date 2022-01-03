package com.paper.demo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paper.demo.model.domain.MentalityPaper;
import com.paper.demo.model.domain.Paper;
import com.paper.demo.service.MentalityPaperService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.paper.demo.common.JsonResponse;
import com.paper.demo.service.MentalityExamService;
import com.paper.demo.model.domain.MentalityExam;

import java.sql.Wrapper;
import java.util.List;


/**
 *
 *  前端控制器
 *
 *
 * @author hjh
 * @since 2022-01-02
 * @version v1.0
 */
@Controller
@RequestMapping("/mentalityExam")
public class MentalityExamController {

    private final Logger logger = LoggerFactory.getLogger( MentalityExamController.class );

    @Autowired
    private MentalityExamService mentalityExamService;
    @Autowired
    private MentalityPaperService mentalityPaperService;
    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        MentalityExam  mentalityExam =  mentalityExamService.getById(id);
        return JsonResponse.success(mentalityExam);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        mentalityExamService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateMentalityExam(@PathVariable("id") String  id,MentalityExam  mentalityExam) throws Exception {
        mentalityExam.setId(id);
        mentalityExamService.updateById(mentalityExam);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建MentalityExam
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(MentalityExam  mentalityExam) throws Exception {
        mentalityExamService.save(mentalityExam);
        return JsonResponse.success(null);
    }

    /**
     * 根据id获取一场考试：题目
     */
    @RequestMapping(value = "/getExam/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getExam(@PathVariable("id") String id)throws Exception {
        List<MentalityPaper> examList = mentalityPaperService.list(new QueryWrapper<MentalityPaper>().eq("exam_id", id));
        return JsonResponse.success(examList);
    }
}

