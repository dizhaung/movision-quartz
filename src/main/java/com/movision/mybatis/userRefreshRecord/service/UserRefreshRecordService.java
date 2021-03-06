package com.movision.mybatis.userRefreshRecord.service;

import com.mongodb.*;
import com.movision.mybatis.userRefreshRecord.entity.UserRefreshRecord;
import com.movision.mybatis.userRefreshRecord.entity.UserRefreshRecordCount;
import com.movision.utils.propertiesLoader.MongoDbPropertiesLoader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author zhanglei
 * @Date 2017/10/26 16:40
 */
@Service
public class UserRefreshRecordService {
    private static final Logger log = LoggerFactory.getLogger(UserRefreshRecordService.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    public void insert(UserRefreshRecord userRefreshRecord) {

        mongoTemplate.insert(userRefreshRecord);
    }

    /**
     * 查询用户刷新记录表的总记录数
     *
     * @return
     */
    public Integer mongodbCount(int userid) {
        MongoClient mongoClient = null;
        int obj = 0;
        DB db = null;
        DBCursor cursor = null;
        try {
            mongoClient = new MongoClient(MongoDbPropertiesLoader.getValue("mongo.hostport"));
            db = mongoClient.getDB("searchRecord");
            DBCollection table = db.getCollection("userRefreshRecord");//表名
            BasicDBObject queryObject = new BasicDBObject("userid", userid);
            cursor = table.find(queryObject);
            obj = cursor.count();
            cursor.close();
        } catch (Exception e) {
            log.error("查询用户刷新记录表的总记录数失败", e);
        } finally {
            if (null != db) {
                db.requestDone();
                db = null;
                mongoClient.close();
            }
        }
        return obj;
    }

    /**
     * 统计用户浏览的帖子所属的每个圈子的数量
     *
     * @return
     */
    public List userFlush(int userid) {
        Aggregation aggregation = Aggregation.newAggregation(
                Aggregation.match(Criteria.where("userid").is(userid)),
                Aggregation.group("crileid").count().as("count"),
                Aggregation.sort(Sort.Direction.DESC, "count"),
                Aggregation.limit(3)
        );
        AggregationResults<UserRefreshRecordCount> list = mongoTemplate.aggregate(aggregation, "userRefreshRecord", UserRefreshRecordCount.class);
        List<UserRefreshRecordCount> list1 = list.getMappedResults();
        return list1;

    }

    /**
     * 根据postid查询帖子的浏览量
     *
     * @return
     */
    public Integer postcount(int postid) {
        MongoClient mongoClient = null;
        int obj = 0;
        DB db = null;
        DBCursor cursor = null;
        try {
            mongoClient = new MongoClient(MongoDbPropertiesLoader.getValue("mongo.hostport"));
            db = mongoClient.getDB("searchRecord");
            DBCollection collection = db.getCollection("userRefreshRecord");
            BasicDBObject queryObject = new BasicDBObject("postid", postid);
            cursor = collection.find(queryObject);
            obj = cursor.count();
            cursor.close();
        } catch (Exception e) {
            log.error("根据postid查询帖子的浏览量失败", e);
        } finally {
            if (null != db) {
                db.requestDone();
                cursor.close();
                mongoClient.close();
            }
        }
        return obj;

    }
    /**
     * 查询
     * 根据postid查询帖子的浏览量
     *
     * @return
     */
    public Integer postcountRecord(int postid) {
        MongoClient mongoClient = null;
        int obj = 0;
        DB db = null;
        DBCursor cursor = null;
        try {
            mongoClient = new MongoClient(MongoDbPropertiesLoader.getValue("mongo.hostport"));
            db = mongoClient.getDB("searchRecord");
            DBCollection collection = db.getCollection("postAndUserRecord");
            BasicDBObject queryObject = new BasicDBObject("postid", postid);
//            obj = collection.find(queryObject).count();
            cursor = collection.find(queryObject);
            obj = cursor.count();
            cursor.close();
        } catch (Exception e) {
            log.error("根据postid查询帖子的浏览量失败", e);
        } finally {
            if (null != db) {
                db.requestDone();
                cursor.close();
                mongoClient.close();
            }
        }
        return obj;

    }

}
