package com.xwhking.elasticsearchtest.mapper;

import com.xwhking.elasticsearchtest.Entity.Hotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 28374
* @description 针对表【hotel】的数据库操作Mapper
* @createDate 2023-12-22 15:22:33
* @Entity com.xwhking.elasticsearchtest.Entity.Hotel
*/
@Mapper
public interface HotelMapper extends BaseMapper<Hotel> {

}




