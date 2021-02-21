package com.sjzxy.fwpt.mapper;

import com.sjzxy.fwpt.entity.QuesLike;
import org.apache.ibatis.annotations.Delete;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Mapper
public interface QuesLikeMapper
//        extends BaseMapper<QuesLike>
{

    @Delete("DELETE FROM ques_like WHERE rid = #{rid} and uid = #{uid}")
    List<QuesLike> deleteByRidAndUid(@Param("rid") int rid, @Param("uid") int uid);
}
