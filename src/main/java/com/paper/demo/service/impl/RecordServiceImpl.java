package com.paper.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.paper.demo.mapper.PaperMapper;
import com.paper.demo.model.domain.Paper;
import com.paper.demo.model.domain.Record;
import com.paper.demo.mapper.RecordMapper;
import com.paper.demo.service.RecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjh
 * @since 2021-12-03
 */
@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {

    @Autowired
    RecordMapper recordMapper;

    @Autowired
    PaperMapper paperMapper;

    @Override
    public List<Record> getByUserId(String userId) {
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", userId);
        List<Record> recordList = recordMapper.selectList(wrapper);
        return recordList;
    }

    @Override
    public Record check(Record record) {
        QueryWrapper<Paper> wrapper = new QueryWrapper<>();
        wrapper.eq("id", record.getPaperId());
        Paper paper = paperMapper.selectOne(wrapper);
        if (paper.getAnswer().equals(record.getOriginAnswer()))
            record.setCorrectOrNot(1);
        else
            record.setCorrectOrNot(0);
        return record;
    }
}
