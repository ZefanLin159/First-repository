<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- /课程列表 开始 -->
    <section class="container">
      <header class="comm-title">
        <h2 class="fl tac">
          <span class="c-333">全部课程</span>
        </h2>
      </header>
      <section class="c-sort-box">
        <section class="c-s-dl">
          <dl>
            <dt>
              <span class="c-999 fsize14">课程类别</span>
            </dt>
            <dd class="c-s-dl-li">
              <ul class="clearfix">
                <li>
                  <a title="全部" href="#" @click="getFrontCourseInfo">全部</a>
                </li>
                <li v-for="(oneSubject, index) in oneSubjectList" :key="index"  >
                  <a
                    :title="oneSubject.title"
                    href="#"
                    @click="searchOne(oneSubject)"
                    >{{ oneSubject.title }}</a
                  >
                </li>
              </ul>
            </dd>
          </dl>
          <dl>
            <dt>
              <span class="c-999 fsize14"></span>
            </dt>
            <dd class="c-s-dl-li">
              <ul class="clearfix">
                <li v-for="twoSubject in twoSubjectList" :key="twoSubject.id">
                  <a :title="twoSubject.title" href="#" @click="searchTwo(twoSubject)">{{
                    twoSubject.title
                  }}</a>
                </li>
              </ul>
            </dd>
          </dl>
          <div class="clear"></div>
        </section>
        <div class="js-wrap">
          <section class="fr">
            <span class="c-ccc">
              <i class="c-master f-fM">1</i>/
              <i class="c-666 f-fM">1</i>
            </span>
          </section>
          <section class="fl">
            <ol class="js-tap clearfix">
              <li>
                <a title="关注度" href="#"  @click="getbuyCountSort()">关注度</a>
              </li>
              <li>
                <a title="最新" href="#" @click="getgmtCreateSort()">最新</a>
              </li>
              <li class="current bg-orange">
                <a title="价格" href="#" @click="getPriceSort()"
                  >价格&nbsp;
                  <span>↓</span>
                </a>
              </li>
            </ol>
          </section>
        </div>
        <div class="mt40">
          <!-- /无数据提示 开始-->
          <section class="no-data-wrap" v-if="pageCourseListInfo.length == 0">
            <em class="icon30 no-data-ico">&nbsp;</em>
            <span class="c-666 fsize14 ml10 vam"
              >没有相关数据，小编正在努力整理中...</span
            >
          </section>
          <!-- /无数据提示 结束-->
          <article class="comm-course-list">
            <ul class="of" id="bna">
              <li v-for="course in pageCourseListInfo" :key="course.id">
                <div class="cc-l-wrap">
                  <section class="course-img">
                    <img
                      :src="course.cover"
                      class="img-responsive"
                      alt="听力口语"
                    />
                    <div class="cc-mask">
                      <a
                        :href="'/course/'+course.id"
                        title="开始学习"
                        class="comm-btn c-btn-1"
                        >开始学 习</a
                      >
                    </div>
                  </section>
                  <h3 class="hLh30 txtOf mt10">
                    <a
                     :href="'/course/'+course.id"
                      :title="course.title"
                      class="course-title fsize18 c-333"
                      >{{ course.title }}</a
                    >
                  </h3>
                  <section class="mt10 hLh20 of">
                    <span class="fr jgTag bg-green">
                      <i class="c-fff fsize12 f-fA">{{
                        course.price == 0 ? "免费" : "收费"
                      }}</i>
                    </span>
                    <span class="fl jgAttr c-ccc f-fA">
                      <i class="c-999 f-fA">9634人学习</i>
                      |
                      <i class="c-999 f-fA">9634评论</i>
                    </span>
                  </section>
                </div>
              </li>
            </ul>
            <div class="clear"></div>
          </article>
        </div>
        <!-- 公共分页 开始 -->
        <!-- <div>
          <div class="paging">
            <a class="undisable" title>首</a>
            <a id="backpage" class="undisable" href="#" title>&lt;</a>
            <a href="#" title class="current undisable">1</a>
            <a href="#" title>2</a>
            <a id="nextpage" href="#" title>&gt;</a>
            <a href="#" title>末</a>
            <div class="clear"></div>
          </div>
        </div> -->
        <el-pagination
          :page-size="limit"
          :total="total"
          style="padding: 30px 0; text-align: center"
          layout="total, prev, pager, next, jumper"
          @current-change="getList"
        />
        <!-- 公共分页 结束 -->
      </section>
    </section>
    <!-- /课程列表 结束 -->
  </div>
</template>
<script>
import courseApi from "@/api/course";
export default {
  data() {
    return {
      page: 1,
      limit: 8,
      total: 0,
      courseVo: {
        teacherId: "",
        subjectId: "",
        subjectParentId: "",
        buyCountSort: "",
        gmtCreateSort: "",
        priceSort: "",
      },
      pageCourseListInfo: {},
      oneSubjectList: {},
      twoSubjectList: {},
    };
  },
  created() {
    this.getFrontCourseInfo();
    this.getAllSubject();
  },
  methods: {
    getPriceSort(){
      this.courseVo.priceSort = 1
      this.courseVo.gmtCreateSort = ""
      this.courseVo.buyCountSort = ""
      this.getList()
    },
    getgmtCreateSort(){
      this.courseVo.priceSort = ""
      this.courseVo.gmtCreateSort = 1
      this.courseVo.buyCountSort = ""
      this.getList()
    },
    getbuyCountSort(){
      this.courseVo.priceSort = ""
      this.courseVo.gmtCreateSort = ""
      this.courseVo.buyCountSort = 1
      this.getList()
    },
    // 获取一级分类得到二级类
    searchOne(oneSubject) {
      this.twoSubjectList = oneSubject.twoSubject
      
      this.courseVo.subjectParentId = oneSubject.id
      this.courseVo.subjectId = ""
      // console.log(this.courseVo.subjectParentId)
      this.getList();
    },
     searchTwo(twoSubject) {

      this.courseVo.subjectId = twoSubject.id;
      // console.log(this.courseVo.subjectParentId)
      this.getList();
    },
    getFrontCourseInfo() {
      this.courseVo = {}
      courseApi
        .getFrontCourseList(this.page, this.limit, this.courseVo)
        .then((response) => {
          this.pageCourseListInfo = response.data.data.pageCourse.records;
          this.total = response.data.data.pageCourse.total;
          // console.log(this.pageCourseListInfo)
          // console.log(this.total)
        });
    },
    getAllSubject() {
      courseApi.getAllSubject().then((response) => {
        this.oneSubjectList = response.data.data.subjectList;
        // console.log(this.oneSubjectList);
      });
    },
    getList(page = 1) {
      this.page = page;
      courseApi
        .getFrontCourseList(this.page, this.limit, this.courseVo)
        .then((response) => {
          this.pageCourseListInfo = response.data.data.pageCourse.records;
          this.total = response.data.data.pageCourse.total;
          // console.log(this.pageCourseListInfo)
          // console.log(this.total)
        });
      this.getAllSubject(); 
    },
  },
};
</script>
