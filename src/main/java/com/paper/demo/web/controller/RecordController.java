package com.paper.demo.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.paper.demo.common.JsonResponse;
import com.paper.demo.service.RecordService;
import com.paper.demo.model.domain.Record;

import java.util.List;


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
@RequestMapping("/record")
public class RecordController {

    private final Logger logger = LoggerFactory.getLogger( RecordController.class );

    @Autowired
    private RecordService recordService;

    /**
    * 描述：根据Id 查询
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getById(@PathVariable("id") Long id)throws Exception {
        Record  record =  recordService.getById(id);
        return JsonResponse.success(record);
    }

    /**
    * 描述：根据Id删除
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public JsonResponse deleteById(@PathVariable("id") Long id) throws Exception {
        recordService.removeById(id);
        return JsonResponse.success(null);
    }


    /**
    * 描述：根据Id 更新
    *
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public JsonResponse updateRecord(@PathVariable("id") Integer  id,Record  record) throws Exception {
        record.setId(id);
        recordService.updateById(record);
        return JsonResponse.success(null);
    }


    /**
    * 描述:创建Record
    *
    */
    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse create(Record  record) throws Exception {
        recordService.save(record);
        return JsonResponse.success(null);
    }

    /**
     * 描述：根据用户作答情况生成记录
     *
     */
    @RequestMapping(value = "/addRecord", method = RequestMethod.POST)
    @ResponseBody
    public JsonResponse addRecord(@RequestBody Record record) {
        record = recordService.check(record);
        boolean save = recordService.save(record);
        return JsonResponse.success(save);
    }


    /**
     * 描述：根据用户openid获取所有记录
     *
     */
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    @ResponseBody
    public JsonResponse getAll(@RequestParam(value = "openid",required = true) String userId) {
        List<Record> recordList = recordService.getByUserId(userId);
        return JsonResponse.success(recordList);
    }
}

