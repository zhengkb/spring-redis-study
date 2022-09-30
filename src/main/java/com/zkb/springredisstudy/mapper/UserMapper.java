package com.zkb.springredisstudy.mapper;

import com.zkb.springredisstudy.entity.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    @Update("update T_USER set IMEI=#{imei} where Uid=#{uid}")
    void updateImei(User user);
}
