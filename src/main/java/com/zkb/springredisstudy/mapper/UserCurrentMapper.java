package com.zkb.springredisstudy.mapper;

import com.zkb.springredisstudy.entity.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCurrentMapper {

    @Update("update T_USER_CURRENT set ImeiOriginal=#{imei} where Uid=#{uid}")
    void updateImei(User user);
}
