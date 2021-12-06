package com.paper.demo.service.impl;

import java.util.List;
import com.paper.demo.model.domain.Paper;
import com.paper.demo.mapper.PaperMapper;
import com.paper.demo.service.PaperService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author hjh
 * @since 2021-12-03
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

    @Autowired
    private PaperMapper paperMapper;

    @Override
    public Paper getOneRandomly() {
        return paperMapper.selectOneRandomly();
    }

    @Override
    public List<Paper> getExam() {
        return paperMapper.getExam();
    }
}
