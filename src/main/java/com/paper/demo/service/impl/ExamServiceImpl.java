package com.paper.demo.service.impl;

import com.paper.demo.model.domain.Exam;
import com.paper.demo.mapper.ExamMapper;
import com.paper.demo.service.ExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements ExamService {

}
