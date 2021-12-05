package com.paper.demo.web.controller;

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
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Paper  paper =  paperService.getById(id);
        return JsonResponse.success(paper);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        paperService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updatePaper(@PathVariable("id") Integer  id,Paper  paper) throws Exception {
        paper.setId(id);
        paperService.updateById(paper);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Paper
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Paper  paper) throws Exception {
        paperService.save(paper);
        return JsonResponse.success(null);
    }

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
     * 描述:根据用户id随机获取一题
     *
     */
    @RequestMapping(value = "/getOne", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getOne(@RequestParam(value = "openid",required = false) String userId) {
        Paper paper = paperService.getOneRandomly();
        return JsonResponse.success(paper);
    }
}

