<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- /课程详情 开始 -->
    <section class="container">
      <section class="path-wrap txtOf hLh30">
        <a href="#" title class="c-999 fsize14">首页</a>
        \
        <a href="#" title class="c-999 fsize14">课程列表</a>
        \
        <span class="c-333 fsize14">{{ courseInfo.title }}</span>
      </section>
      <div>
        <article class="c-v-pic-wrap" style="height: 357px">
          <section class="p-h-video-box" id="videoPlay">
            <img
              height="357px"
              width="400px"
              :src="courseInfo.cover"
              :alt="courseInfo.title"
              class="dis c-v-pic"
            />
          </section>
        </article>
        <aside class="c-attr-wrap">
          <section class="ml20 mr15">
            <h2 class="hLh30 txtOf mt15">
              <span class="c-fff fsize24">{{ courseInfo.title }}</span>
            </h2>
            <section class="c-attr-jg">
              <span class="c-fff">价格：</span>
              <b class="c-yellow" style="font-size: 24px"
                >￥{{ courseInfo.price }}</b
              >
            </section>
            <section class="c-attr-mt c-attr-undis">
              <span class="c-fff fsize14"
                >主讲： {{ teacherInfo.name }}&nbsp;&nbsp;&nbsp;</span
              >
            </section>
            <section class="c-attr-mt of">
              <span class="ml10 vam">
                <em class="icon18 scIcon"></em>
                <a class="c-fff vam" title="收藏" href="#">收藏</a>
              </span>
            </section>
            <section class="c-attr-mt">
              <a
                href="#"
                title="立即观看"
                class="comm-btn c-btn-3"
                v-if="Number(courseInfo.price)==0  || Number(isBuycount) == 1"
                >立即观看</a
              >
                 <a
                href="#"
                @click="createOrders()"
                title="立即购买"
                class="comm-btn c-btn-3"
                v-else=""
                >立即购买</a
              >
            </section>
          </section>
        </aside>
        <aside class="thr-attr-box">
          <ol class="thr-attr-ol clearfix">
            <li>
              <p>&nbsp;</p>
              <aside>
                <span class="c-fff f-fM">购买数</span>
                <br />
                <h6 class="c-fff f-fM mt10">{{ courseInfo.buyCount }}</h6>
              </aside>
            </li>
            <li>
              <p>&nbsp;</p>
              <aside>
                <span class="c-fff f-fM">课时数</span>
                <br />
                <h6 class="c-fff f-fM mt10">{{ courseInfo.lessonNum }}</h6>
              </aside>
            </li>
            <li>
              <p>&nbsp;</p>
              <aside>
                <span class="c-fff f-fM">浏览数</span>
                <br />
                <h6 class="c-fff f-fM mt10">{{ courseInfo.viewCount }}</h6>
              </aside>
            </li>
          </ol>
        </aside>
        <div class="clear"></div>
      </div>
      <!-- /课程封面介绍 -->
      <div class="mt20 c-infor-box">
        <article class="fl col-7">
          <section class="mr30">
            <div class="i-box">
              <div>
                <section id="c-i-tabTitle" class="c-infor-tabTitle c-tab-title">
                  <a name="c-i" class="current" title="课程详情">课程详情</a>
                </section>
              </div>
              <article class="ml10 mr10 pt20">
                <div>
                  <h6 class="c-i-content c-infor-title">
                    <span>课程介绍</span>
                  </h6>
                  <div class="course-txt-body-wrap">
                    <section class="course-txt-body">
                      <p v-html="descriptionInfo.description"></p>
                    </section>
                  </div>
                </div>
                <!-- /课程介绍 -->
                <div class="mt50">
                  <h6 class="c-g-content c-infor-title">
                    <span>课程大纲</span>
                  </h6>
                  <section class="mt20">
                    <div class="lh-menu-wrap">
                      <menu id="lh-menu" class="lh-menu mt10 mr10">
                        <ul>
                          <!-- 文件目录 -->
                          <li
                            class="lh-menu-stair"
                            v-for="chapter in chapterVoList"
                            :key="chapter.id"
                          >
                            <a
                              href="javascript: void(0)"
                              title="第一章"
                              class="current-1"
                            >
                              <em class="lh-menu-i-1 icon18 mr10"></em
                              >{{ chapter.title }}
                            </a>
                            <ol class="lh-menu-ol" style="display: block">
                              <li
                                class="lh-menu-second ml30"
                                v-for="video in chapter.children"
                                :key="video.id"
                              >
                                <a
                                  :href="'/player/' + video.videoSourceId"
                                  target="_blank"
                                >
                                  <span class="fr">
                                    <i
                                      class="free-icon vam mr10"
                                      v-if="video.isFree == 0"
                                      >免费</i
                                    >
                                  </span>
                                  <em class="lh-menu-i-2 icon16 mr5">&nbsp;</em
                                  >{{ video.title }}
                                </a>
                              </li>
                            </ol>
                          </li>
                        </ul>
                      </menu>
                    </div>
                  </section>
                </div>
                <!-- /课程大纲 -->
              </article>
            </div>
          </section>
        </article>
        <aside class="fl col-3">
          <div class="i-box">
            <div>
              <section class="c-infor-tabTitle c-tab-title">
                <a title href="javascript:void(0)">主讲讲师</a>
              </section>
              <section class="stud-act-list">
                <ul style="height: auto">
                  <li>
                    <div class="u-face">
                      <a href="#">
                        <img
                          :src="teacherInfo.avatar"
                          width="50"
                          height="50"
                          alt
                        />
                      </a>
                    </div>
                    <section class="hLh30 txtOf">
                      <a class="c-333 fsize16 fl" href="#">{{
                        teacherInfo.name
                      }}</a>
                    </section>
                    <section class="hLh20 txtOf">
                      <span class="c-999">{{ teacherInfo.intro }}</span>
                    </section>
                  </li>
                </ul>
              </section>
            </div>
          </div>
        </aside>
        <div class="clear"></div>
      </div>
    </section>

    <!-- /课程详情 结束 -->
    <div class="mt50 commentHtml"></div>
    <h6 class="c-c-content c-infor-title" id="i-art-comment">
      <span class="commentTitle">课程评论</span>
    </h6>
    <section class="lh-bj-list pr mt20 replyhtml">
      <ul>
        <li class="unBr">
          <aside class="noter-pic">
            <img
              width="50"
              height="50"
              class="picImg"
              src="~/assets/img/avatar-boy.gif"
            />
          </aside>
          <div class="of">
            <section class="n-reply-wrap">
              <fieldset>
                <textarea
                  name=""
                  v-model="comment.content"
                  placeholder="输入您要评论的文字"
                  id="commentContent"
                ></textarea>
              </fieldset>
              <p class="of mt5 tar pl10 pr10">
                <span class="fl"
                  ><tt
                    class="c-red commentContentmeg"
                    style="display: none"
                  ></tt
                ></span>
                <input
                  type="button"
                  @click="addCommentInfo()"
                  value="回复"
                  class="lh-reply-btn"
                />
              </p>
            </section>
          </div>
        </li>
      </ul>
    </section>
    <section class="">
      <section class="question-list lh-bj-list pr">
        <ul class="pr10">
          <li v-for="(comment, index) in commentList" v-bind:key="index">
            <aside class="noter-pic">
              <img
                width="50"
                height="50"
                class="picImg"
                :src="comment.avatar"
              />
            </aside>
            <div class="of">
              <span class="fl">
                <font class="fsize12 c-blue"> {{ comment.nickname }}</font>
                <font class="fsize12 c-999 ml5">评论：</font></span
              >
            </div>
            <div class="noter-txt mt5">
              <p>{{ comment.content }}</p>
            </div>
            <div class="of mt5">
              <span class="fr"
                ><font class="fsize12 c-999 ml5"
                  >{{ comment.gmtCreate }}
                </font></span
              >
            </div>
          </li>
        </ul>
      </section>
    </section>
    <el-pagination
      :page-size="limit"
      :total="total"
      style="padding: 30px 0; text-align: center"
      layout="total, prev, pager, next, jumper"
      @current-change="goToPage"
    />
  </div>
</template>
<script>
import courseApi from "@/api/course";
import commentApi from "@/api/comment";
import cookie from "js-cookie";
import orderApi from "@/api/order";
export default {
  data() {
    return {
      id: "",
      courseInfo: {},
      teacherInfo: {},
      descriptionInfo: {},
      chapterVoList: {},
      comment: {},
      commentList: {},
      page: 1,
      limit: 4,
      total: 0,
      loginInfo: {},
      isBuycount:0,
    };
  },
  created() {
    // 可以从cookie中直接取用户id，用户昵称，用户名字
    var userStr = cookie.get("guli_ucenter");
    // console.log(userStr);
    if (userStr) {
      this.loginInfo = JSON.parse(userStr);
      // console.log(this.loginInfo);
    }
    // console.log(this.$route.params.id)
    if (this.$route.params && this.$route.params.id) {
      this.id = this.$route.params.id;
      // console.log(this.id);
      // 获取路由id值
      this.getCourseInfo();
      this.initCommentList();
      this.getBuyStatusInfo()
    }
    
    // console.log(this.id)
  },
  methods: {
    getBuyStatusInfo(){
      orderApi.getBuyStatus(this.id)
      .then(response=>{
        this.isBuycount = response.data.data.count
      })
    },
    // 生成订单
    createOrders() {
      orderApi.createOrder(this.id)
      .then(response=>{
        // 返回订单号
        this.orderId = response.data.data.orderId
        
        // 生成订单之后，跳转订单页面
         this.$router.push({ path: '/orders/'+ this.orderId })
      })
    },
    initCommentList() {
      this.goToPage(1);
    },

    goToPage(page = 1) {
      this.page = page;
      commentApi.getComment(page, this.limit, this.id).then((response) => {
        this.commentList = response.data.data.records;
        this.total = response.data.data.total;
        // console.log(response.data.data);
      });
    },
    addCommentInfo() {
      this.comment.courseId = this.id;
      this.comment.teacherId = this.teacherInfo.id;
      commentApi.addComment(this.comment).then((response) => {
        this.$message({
          type: "success",
          message: "评论成功",
        });
      });
      this.initCommentList();
    },
    getCourseInfo() {
      courseApi.getCourseById(this.id).then((response) => {
        this.courseInfo = response.data.data.singleCourse;
        this.descriptionInfo = response.data.data.description;
        this.teacherInfo = response.data.data.teacher;
        this.chapterVoList = response.data.data.chapterVoList;
        // console.log(this.courseInfo)
        // console.log(this.chapterVoList);
      });
    },
  },
};
</script>
