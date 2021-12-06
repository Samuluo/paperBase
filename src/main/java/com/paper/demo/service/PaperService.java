package com.paper.demo.service;

import com.paper.demo.model.domain.Paper;
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
public interface PaperService extends IService<Paper> {

    Paper getOneRandomly();

    List<Paper> getExam();
}
