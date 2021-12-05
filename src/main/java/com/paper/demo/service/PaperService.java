package com.paper.demo.service;

import com.paper.demo.model.domain.Paper;
import com.baomidou.mybatisplus.extension.service.IService;

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
}
