package com.paper.demo.web.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
 * @since 2022-01-02
 * @version v1.0
 */
@Controller
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
    public JsonResponse getById(@PathVariable("id") Integer id)throws Exception {
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
     * 获取所有练习并分页
     */
    @RequestMapping(value = "/getPractice",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage,600);
        IPage pagedata = paperService.page(page,new QueryWrapper<Paper>().orderByAsc("id"));

        return JsonResponse.success(pagedata);
    }

    /**
     * 随机获取一道练习
     */
    @RequestMapping(value = "/getOne",method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse random() {
        //Integer x = 1+(int)(Math.random()*400);
        Paper paper = paperService.getOneRandomly();
        return JsonResponse.success(paper);
    }
}
