package com.xwhking.elasticsearchtest.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.xwhking.elasticsearchtest.Entity.Hotel;
import com.xwhking.elasticsearchtest.service.HotelService;
import com.xwhking.elasticsearchtest.mapper.HotelMapper;
import org.springframework.stereotype.Service;

/**
* @author 28374
* @description 针对表【hotel】的数据库操作Service实现
* @createDate 2023-12-22 15:22:33
*/
@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel>
    implements HotelService {

}




