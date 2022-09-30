package com.zkb.springredisstudy.mapper;

import com.zkb.springredisstudy.entity.User;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRoleMapper {

    @Update("update T_GAME_ROLE set Imei=#{imei} where Uid=#{uid}")
    void updateImei(User user);
}
