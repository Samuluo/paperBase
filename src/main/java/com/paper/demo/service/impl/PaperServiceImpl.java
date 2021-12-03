package com.paper.demo.service.impl;

import com.paper.demo.model.domain.Paper;
import com.paper.demo.mapper.PaperMapper;
import com.paper.demo.service.PaperService;
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
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements PaperService {

}
