package com.paper.demo.service;

import com.paper.demo.model.domain.Record;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjh
 * @since 2021-12-03
 */
public interface RecordService extends IService<Record> {

    List<Record> getByUserId(String userId);

    Record check(Record record);
}
