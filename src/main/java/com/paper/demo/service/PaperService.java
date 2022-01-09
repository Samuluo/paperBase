package com.paper.demo.service;

import com.paper.demo.model.domain.Paper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hjh
 * @since 2022-01-02
 */
public interface PaperService extends IService<Paper> {
    Paper getOneRandomly();
}
