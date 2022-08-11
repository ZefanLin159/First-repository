<template>
  <div class="app-container">
    <h2 style="text-align: center;">发布新课程</h2>
    <el-steps
      :active="1"
      process-status="wait"
      align-center
      style="margin-bottom: 40px;"
    >
      <el-step title="填写课程基本信息" />
      <el-step title="创建课程大纲" />
      <el-step title="提交审核" />
    </el-steps>
    <el-form label-width="120px">
      <el-form-item label="课程标题">
        <el-input
          v-model="courseInfo.title"
          placeholder=" 示例：机器学习项目课：从基础到搭建项目视频课程。专业名称注意大小写"
        />
      </el-form-item>
      <!-- 所属分类 TODO -->
      <!-- 一级分类 -->
      <el-form-item label="课程分类">
        <el-select
          v-model="courseInfo.subjectParentId"
          placeholder="一级分类"
          @change="subjectLevelOneChanged"
        >
          <el-option
            v-for="subject in subjectListOne"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>
      </el-form-item>
      <!-- 二级分类 -->
      <el-form-item label="课程分类">
        <el-select v-model="courseInfo.subjectId" placeholder="二级分类">
          <el-option
            v-for="subject in subjectListTwo"
            :key="subject.id"
            :label="subject.title"
            :value="subject.id"
          />
        </el-select>
      </el-form-item>
      <!-- 课程讲师 -->
      <el-form-item label="课程讲师">
        <el-select v-model="courseInfo.teacherId" placeholder="请选择">
          <el-option
            v-for="teacher in teacherList"
            :key="teacher.id"
            :label="teacher.name"
            :value="teacher.id"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="总课时">
        <el-input-number
          :min="0"
          v-model="courseInfo.lessonNum"
          controls-position="right"
          placeholder="请填写课程的总课时数"
        />
      </el-form-item>
      <!-- 课程简介 TODO -->
      <!-- 课程简介-->
      <el-form-item label="课程简介">
        <tinymce :height="300" v-model="courseInfo.description" />
      </el-form-item>
      <!-- 课程封面-->
      <el-form-item label="课程封面">
        <el-upload
          :show-file-list="false"
          :on-success="handleAvatarSuccess"
          :before-upload="beforeAvatarUpload"
          :action="BASE_API + '/eduoss/fileoss'"
          class="avatar-uploader"
        >
          <img :src="courseInfo.cover" />
        </el-upload>
      </el-form-item>

      <el-form-item label="课程价格">
        <el-input-number
          :min="0"
          v-model="courseInfo.price"
          controls-position="right"
          placeholder="免费课程请设置为0元"
        />
        元
      </el-form-item>
      <el-form-item>
        <el-button
          :disabled="saveBtnDisabled"
          type="primary"
          @click="saveOrUpdate"
          >保存并下一步</el-button
        >
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import course from "@/api/edu/course";
import subject from "@/api/edu/subject";
import Tinymce from "@/components/Tinymce";
export default {
  // 声明组件
  components: { Tinymce },
  data() {
    return {
      saveBtnDisabled: false,
      courseInfo: {
        title: "",
        subjectId: "", //二级分类id
        subjectParentId: "", //一级分类id
        teacherId: "",
        lessonNum: 0,
        description: "",
        cover: "/static/100.jpg",
        price: 0
      },
      courseId: "",
      teacherList: [],
      subjectListOne: [],
      subjectListTwo: [],
      BASE_API: process.env.BASE_API
    };
  },
  created() {
    // 获取路由中的id值
    if (this.$route.params && this.$route.params.id) {
      this.courseId = this.$route.params.id;
      this.getInfo();
    }
    this.getAllTeacherList();
    this.getOneSubject();
  },
  methods: {
    // 保存下一步的区别（添加/更改）
    addCourse() {
      course.addCourseInfo(this.courseInfo).then(response => {
        this.$message({
          type: "success",
          message: "添加课程信息成功"
        })
        this.$router.push({
          path: "/edu/course/chapter/" + response.data.courseId
        })
      })
    },
    updateCourse() {
      course.updateCourseInfo(this.courseInfo).then(response => {
        this.$message({
          type: "success",
          message: "更改课程信息成功"
        })
        this.$router.push({
          // 这里添加的不是响应的id，而是更改的id
          path: "/edu/course/chapter/" + this.courseId
        })
        
      })
    },
    saveOrUpdate() {
      if (this.$route.params && this.$route.params.id) {
        this.updateCourse();
      } else {
        this.addCourse();
      }
    },
    getAllTeacherList() {
      course.getAllTeacher().then(response => {
        this.teacherList = response.data.items;
        // console.log(response.data);
      });
    },
    getOneSubject() {
      subject.getSubjectList().then(response => {
        this.subjectListOne = response.data.list;
        // console.log(response.data);
      });
    },
    subjectLevelOneChanged(value) {
      // value就是一级分类id值
      // console.log(value);
      for (let i = 0; i < this.subjectListOne.length; i++) {
        if (this.subjectListOne[i].id === value) {
          this.subjectListTwo = this.subjectListOne[i].twoSubject;
          this.courseInfo.subjectId = "";
        }
      }
    },
    // 上传之前调用的方法
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;
      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isJPG && isLt2M;
    },
    // 上传封面成功调用的方法
    handleAvatarSuccess(res, file) {
      console.log(res); // 上传响应
      console.log(URL.createObjectURL(file.raw)); // base64编码
      this.courseInfo.cover = res.data.url;
    },
    getInfo() {
      course.getCourseInfo(this.courseId).then(response => {
        this.courseInfo = response.data.courseInfoVo;
        // 查询所有分类包含一级和二级
        subject.getSubjectList().then(response => {
          this.subjectListOne = response.data.list;
          // 初始化讲师
          this.getAllTeacherList();
          // 找到就退出
          for (var i = 0; i < this.subjectListOne.length; i++) {
            console.log(
              this.courseInfo.subjectParentId == this.subjectListOne[i].id
            );
            if (this.courseInfo.subjectParentId == this.subjectListOne[i].id) {
              this.subjectListTwo = this.subjectListOne[i].twoSubject;
              break;
            }
          }
        });
      });
    },
    
  }
};
</script>
<style scoped>
.tinymce-container {
  line-height: 29px;
}
</style>
