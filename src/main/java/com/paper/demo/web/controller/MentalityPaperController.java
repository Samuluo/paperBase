package com.paper.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.paper.demo.common.JsonResponse;
import com.paper.demo.service.MentalityPaperService;
import com.paper.demo.model.domain.MentalityPaper;


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
@RequestMapping("/mentalityPaper")
public class MentalityPaperController {

    private final Logger logger = LoggerFactory.getLogger( MentalityPaperController.class );

    @Autowired
    private MentalityPaperService mentalityPaperService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        MentalityPaper  mentalityPaper =  mentalityPaperService.getById(id);
        return JsonResponse.success(mentalityPaper);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        mentalityPaperService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateMentalityPaper(@PathVariable("id") Integer  id,MentalityPaper  mentalityPaper) throws Exception {
        mentalityPaper.setId(id);
        mentalityPaperService.updateById(mentalityPaper);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建MentalityPaper
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(MentalityPaper  mentalityPaper) throws Exception {
        mentalityPaperService.save(mentalityPaper);
        return JsonResponse.success(null);
    }
}

