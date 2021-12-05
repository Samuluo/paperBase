package com.paper.demo.mapper;

import com.paper.demo.model.domain.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.paper.demo.model.domain.Paper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author hjh
 * @since 2021-12-03
 */
@Mapper
public interface ExamMapper extends BaseMapper<Exam> {
    Exam selectOneRandomly();
}
