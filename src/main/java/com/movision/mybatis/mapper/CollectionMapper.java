package com.movision.mybatis.mapper;

import com.movision.mybatis.collection.entity.Collection;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface CollectionMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Collection record);

    int insertSelective(Collection record);

    Collection selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Collection record);

    int updateByPrimaryKey(Collection record);

    int checkIsHave(Collection collection);

    int checkIsHaveGoods(Collection collection);

    int collectionPost(Collection collection);

    void cancelCollectionPost(Map<String, Object> parammap);

    void cancelCollectionGoods(Map<String, Object> parammap);

    void addCollectionSum(int postid);

    int queryCollectionCount(int userid);

    int userPostCollection(int userid);
}