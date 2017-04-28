package com.movision.task;

import com.movision.mybatis.post.entity.Post;
import com.movision.mybatis.post.entity.PostVo;
import com.movision.mybatis.post.service.PostService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.movision.utils.propertiesLoader.PropertiesLoader;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;

/**
 * @Author shuxf
 * @Date 2017/4/24 10:44
 */
@Service
public class CleanScanAllImgTask {

    private static final Logger log = LoggerFactory.getLogger(CleanScanAllImgTask.class);

    @Autowired
    private PostService postService;

    public void run() {

        log.info("开始查询所有的帖子列表");
        //开始查询所有的帖子列表
        List<PostVo> allPostList = postService.queryAllPost();

        //扫描服务器下帖子图片和封面存放路径下的所有图片
        String compressimgpath = PropertiesLoader.getValue("post.compress.img.domain");//帖子内容中压缩后的图片存放路径
        String postprotoimgpath = PropertiesLoader.getValue("post.proto.img.domain");//帖子内容中原图存放路径
        String activeprotoimgpath = PropertiesLoader.getValue("active.proto.img.domain");//活动内容中原图的存放路径
        String postprotovideopath = PropertiesLoader.getValue("post.proto.video.domain");//帖子内容中视频存放路径

        log.info("帖子内容中压缩后的图片存放路径>>>>>>>>>>>>>>>>>>>" + compressimgpath);
        log.info("帖子内容中原图存放路径>>>>>>>>>>>>>>>>>>>" + postprotoimgpath);
        log.info("活动内容中原图的存放路径>>>>>>>>>>>>>>>>>>>" + activeprotoimgpath);
        log.info("帖子内容中视频存放路径>>>>>>>>>>>>>>>>>>>" + postprotovideopath);

        //根据文件路径扫描所有带扫描的文件
        String [] compressimgFileName = getFileName(compressimgpath);//压缩图片文件名数组
        String [] postprotoimgFileName = getFileName(postprotoimgpath);//帖子中原图文件名数组
        String [] activeprotoimgFileName = getFileName(activeprotoimgpath);//活动中原图文件名数组
        String [] postprotovideoFileName = getFileName(postprotovideopath);//帖子中视频存放路径

        //遍历所有文件夹下的文件名
        for(String name:compressimgFileName)
        {
            clean(name, allPostList, compressimgpath);//清理图片
        }
        for(String name:postprotoimgFileName)
        {
            clean(name, allPostList, postprotoimgpath);//清理图片
        }
        for(String name:activeprotoimgFileName)
        {
            clean(name, allPostList, activeprotoimgpath);//清理图片
        }
        for(String name:postprotovideoFileName)
        {
            cleanvideo(name, allPostList, postprotovideopath);//清理视频
        }


        //扫描所有帖子的内容和封面进行检查
        for (int i = 0; i < allPostList.size(); i++) {
            log.info("当前处理的帖子id>>>>>>>>>>>>>>>>>>" + allPostList.get(i).getId());
        }
    }

    public static String [] getFileName(String path) {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }

    //清理帖子或活动内容中未使用到的图片
    public void clean(String name, List<PostVo> allPostList, String path){
        //定义标志位（0 未使用到 1 有使用到）
        int flag = 0;//初始化为未使用到
        for (int i = 0; i < allPostList.size(); i++){
            int index = allPostList.get(i).getPostcontent().indexOf(name);
            if (index != -1){
                flag = flag + 1;//每使用一次+1
            }
        }
        //删除所有未使用到的图片文件
        if (flag == 0){
            String filepath = path + name;//文件路径和文件名
            File file = new File(filepath);
            file.delete();
        }
    }

    //清理或活动中无用的视频文件
    public void cleanvideo(String name, List<PostVo> allPostList, String path){
        //定义标志位（0 未使用到 1 有使用到）
        int flag = 0;//初始化为未使用到
        for (int i = 0; i < allPostList.size(); i++){
            if (null != allPostList.get(i).getVideourl()) {
                int index = allPostList.get(i).getVideourl().indexOf(name);
                if (index != -1) {
                    flag = flag + 1;//每使用一次+1
                }
            }
        }
        //删除所有未使用到的视频文件
        if (flag == 0){
            String filepath = path + name;//文件路径和文件名
            File file = new File(filepath);
            file.delete();
        }
    }
}
