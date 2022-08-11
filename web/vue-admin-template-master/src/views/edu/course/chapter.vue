<template>
  <div class="app-container">
    <h2 style="text-align: center;">发布新课程</h2>
    <el-steps
      :active="2"
      process-status="wait"
      align-center
      style="margin-bottom: 40px;"
    >
      <el-step title="填写课程基本信息" />
      <el-step title="创建课程大纲" />
      <el-step title="提交审核" />
    </el-steps>

    <el-button type="text" @click="openChapterInfo">添加章节</el-button>
    <!-- 添加和修改章节表单 -->
    <el-dialog :visible.sync="dialogChapterFormVisible" title="添加章节">
      <el-form :model="chapter" label-width="120px">
        <el-form-item label="章节标题">
          <el-input v-model="chapter.title" />
        </el-form-item>
        <el-form-item label="章节排序">
          <el-input-number
            v-model="chapter.sort"
            :min="0"
            controls-position="right"
          />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button @click="dialogChapterFormVisible = false">取 消</el-button>
        <el-button type="primary" @click="saveOrUpdateChapter">确 定</el-button>
      </div>
    </el-dialog>
    <!-- 章节 -->
    <ul class="chanpterList">
      <li v-for="chapter in chapterVideoList" :key="chapter.id">
        <p>
          {{ chapter.title }}
          <span class="acts">
            <el-button type="text" @click="openVideoInfo(chapter.id)"
              >添加小节</el-button
            >
            <el-button
              style=""
              type="text"
              @click="openToUpdateChapter(chapter.id)"
              >编辑</el-button
            >
            <el-button type="text" @click="deleteChapterInfo(chapter.id)"
              >删除</el-button
            >

            <!-- 添加和修改小节表单 -->
            <el-dialog :visible.sync="dialogVideoFormVisible" title="添加小节">
              <el-form :model="video" label-width="120px">
                <el-form-item label="小节标题">
                  <el-input v-model="video.title" />
                </el-form-item>
                <el-form-item label="小节排序">
                  <el-input-number
                    v-model="video.sort"
                    :min="0"
                    controls-position="right"
                  />
                </el-form-item>
                <el-form-item label="是否免费">
                  <el-radio-group v-model="video.isFree">
                    <el-radio :label="1">免费</el-radio>
                    <el-radio :label="0">默认</el-radio>
                  </el-radio-group>
                </el-form-item>
                <el-form-item label="上传视频">
                  <el-upload
                    :on-success="handleVodUploadSuccess"
                    :on-remove="handleVodRemove"
                    :before-remove="beforeVodRemove"
                    :on-exceed="handleUploadExceed"
                    :file-list="fileList"
                    :action="BASE_API + '/eduvod/video/uploadVideoAli'"
                    :limit="1"
                    class="upload-demo"
                  >
                    <el-button size="small" type="primary">上传视频</el-button>
                    <el-tooltip placement="right-end">
                      <div slot="content">
                        最大支持1G，<br />
                        支持3GP、ASF、AVI、DAT、DV、FLV、F4V、<br />
                        GIF、M2T、M4V、MJ2、MJPEG、MKV、MOV、MP4、<br />
                        MPE、MPG、MPEG、MTS、OGG、QT、RM、RMVB、<br />
                        SWF、TS、VOB、WMV、WEBM 等视频格式上传
                      </div>
                      <i class="el-icon-question" />
                    </el-tooltip>
                  </el-upload>
                </el-form-item>
              </el-form>
              <div slot="footer" class="dialog-footer">
                <el-button @click="dialogVideoFormVisible = false"
                  >取 消</el-button
                >
                <el-button
                  :disabled="saveVideoBtnDisabled"
                  type="primary"
                  @click="saveOrUpdateVideoInfo"
                >
                  确 定</el-button
                >
              </div>
            </el-dialog>
          </span>
        </p>
        <!-- 视频 -->
        <ul class="chanpterList videoList">
          <li v-for="video in chapter.children" :key="video.id">
            <p>
              {{ video.title }}
              <span class="acts">
                <el-button type="text" @click="openUpdateVideoInfo(video.id)"
                  >编辑</el-button
                >
                <el-button type="text" @click="deleteVideoInfo(video.id)"
                  >删除</el-button
                >
              </span>
            </p>
          </li>
        </ul>
      </li>
    </ul>
    <el-form label-width="120px">
      <el-form-item>
        <el-button @click="previous">上一步</el-button>
        <el-button :disabled="saveBtnDisabled" type="primary" @click="next"
          >下一步</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import chapterPackge from "@/api/edu/chapter";
import videoPackge from "@/api/edu/video";
export default {
  data() {
    return {
      saveBtnDisabled: false,
      courseId: "", // 所属课程
      chapterVideoList: [], // 章节嵌套课时列表
      dialogChapterFormVisible: false,
      dialogVideoFormVisible: false,
      chapter: {
        courseId: "",
        title: "",
        sort: 0
      },
      saveVideoBtnDisabled: false,
      video: {
        courseId: "",
        chapterId: "",
        title: "",
        sort: 0,
        isFree: 0,
        videoSourceId: "",
        videoOriginalName:""

      },
      fileList: [], //上传文件列表
      BASE_API: process.env.BASE_API // 接口API地址
    };
  },
  created() {
    if (this.$route.params && this.$route.params.id) {
      this.courseId = this.$route.params.id;
      // 获取路由id值
      this.getAllChapterVideo();
    }
  },
  methods: {
    previous() {
      this.$router.push({ path: "/edu/course/info/" + this.courseId });
    },
    next() {
      this.$router.push({ path: "/edu/course/publish/" + this.courseId });
    },
    // =================章节管理=========================
    getAllChapterVideo() {
      chapterPackge.getAllChapterVo(this.courseId).then(respnse => {
        this.chapterVideoList = respnse.data.allChapterVideo;
        // console.log(respnse.data)
      });
    },
    openChapterInfo() {
      this.chapter.title = "";
      this.chapter.sort = 0;
      this.dialogChapterFormVisible = true;
    },
    openToUpdateChapter(id) {
      chapterPackge.getChapter(id).then(response => {
        this.chapter = response.data.chapter;
      });
      this.dialogChapterFormVisible = true;
    },
    addChapterInfo() {
      // 要在本对象里面赋值
      this.chapter.courseId = this.courseId;
      chapterPackge.addChapter(this.chapter).then(response => {
        this.$message({
          type: "success",
          message: "添加章节成功"
        });
        this.dialogChapterFormVisible = false;
        this.getAllChapterVideo();
      });
    },
    updateChapterInfo() {
      // 要在本对象里面赋值
      this.chapter.courseId = this.courseId;
      chapterPackge.updateChapter(this.chapter).then(response => {
        this.$message({
          type: "success",
          message: "更改章节成功"
        });
        this.dialogChapterFormVisible = false;
        this.getAllChapterVideo();
      });
    },
    saveOrUpdateChapter() {
      if (!this.chapter.id) {
        this.addChapterInfo();
      } else {
        this.updateChapterInfo();
        // this.chapter.id = "";
      }
    },
    deleteChapterInfo(chapterId) {
      this.$confirm("此操作将永久删除章节记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        chapterPackge.deleteChapter(chapterId).then(response => {
          // 提示信息
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          // 回到列表页面
          this.getAllChapterVideo();
        });
      });
    },
    // =============================小节管理========================
    openVideoInfo(chapterId) {
      this.dialogVideoFormVisible = true;
      this.video.title = "";
      this.video.sort = 0;
      this.video.isFree = 0;
      this.video.chapterId = chapterId;
      this.video.courseId = this.courseId;
    },
    addVideoInfo() {
      videoPackge.addVideo(this.video).then(response => {
        this.$message({
          type: "success",
          message: "添加小节成功"
        });
        this.dialogVideoFormVisible = false;
        this.getAllChapterVideo();
      });
    },
    openUpdateVideoInfo(videoId) {
      this.dialogVideoFormVisible = true;
      videoPackge.getVideo(videoId).then(response => {
        this.video = response.data.video;
      });
    },
    updateVideoInfo() {
      videoPackge.updateVideo(this.video).then(response => {
        this.$message({
          type: "success",
          message: "更改小节成功"
        });
        this.dialogVideoFormVisible = false;
        this.getAllChapterVideo();
      });
    },
    saveOrUpdateVideoInfo() {
      if (!this.video.id) {
        this.addVideoInfo();
      } else {
        this.updateVideoInfo();
      }
    },
    deleteVideoInfo(videoId) {
      this.$confirm("此操作将永久删除章节记录, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        videoPackge.deleteVideo(videoId).then(response => {
          // 提示信息
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          // 回到列表页面
          this.getAllChapterVideo();
        })
      })
    },
    // ==============上传视频==================
    handleVodUploadSuccess(response,file,fileList){
      this.video.videoSourceId = response.data.videoId
      this.video.videoOriginalName = file.name
      

    },
    handleUploadExceed(){
      this.$message.console.warn('想重新上传视频，请先删除旧视频')
    },
    handleVodRemove(){
        // 调用接口中删除视频的方法
         videoPackge.deleteVideoAli(this.video.videoSourceId)
         .then(response=>{
           this.$message({
            type: "success",
            message: "删除成功!"
          })
          this.fileList = []
          this.video.videoOriginalName = ""
          this.video.videoSourceId = ""
         })
    },
    beforeVodRemove(file,fileList){
      return this.$confirm(`确定移除${file.name}?`)
    }

  }
};
</script>
<style scoped>
.chanpterList {
  position: relative;
  list-style: none;
  margin: 0;
  padding: 0;
}
.chanpterList li {
  position: relative;
}
.chanpterList p {
  /* float: left; */
  font-size: 20px;
  margin: 10px 0;
  padding: 10px;
  height: 70px;
  line-height: 50px;
  width: 100%;
  border: 1px solid #ddd;
}
.chanpterList .acts {
  float: right;
  font-size: 14px;
}
.videoList {
  padding-left: 50px;
}
.videoList p {
  /* float: left; */
  font-size: 14px;
  margin: 10px 0;
  padding: 10px;
  height: 50px;
  line-height: 30px;
  width: 100%;
  border: 1px dotted #ddd;
}
</style>
