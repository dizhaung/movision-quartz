package com.movision.mybatis.mapper;

import com.movision.mybatis.followUser.entity.FollowUser;
import com.movision.mybatis.followUser.entity.FollowUserVo;

import java.util.List;
import java.util.Map;

public interface FollowUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(FollowUser record);

    int insertSelective(FollowUser record);

    FollowUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(FollowUser record);


    int updateByPrimaryKey(FollowUser record);

    int yesOrNo(Map map);

    int cancleFollowUser(Map map);

    void updateUserAttention(Integer userid);

    List<FollowUserVo> selectFollowUserVoList(Integer userid);

    int insertUserFans(int interestedusers);

    void insertUserFansLess(int interestedusers);

    int queryUserIsRead(int userid);

    void updateAttentionIsRead(Integer userid);
}