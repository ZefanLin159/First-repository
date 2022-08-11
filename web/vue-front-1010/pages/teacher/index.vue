<template>
  <div id="aCoursesList" class="bg-fa of">
    <!-- 讲师列表 开始 -->
    <section class="container">
      <header class="comm-title all-teacher-title">
        <h2 class="fl tac">
          <span class="c-333">全部讲师</span>
        </h2>
        <section class="c-tab-title">
          <a id="subjectAll" title="全部" href="#">全部</a>
          <!-- <c:forEach var="subject" items="${subjectList }">
<a id="${subject.subjectId}" title="${subject.subjectName }"
href="javascript:void(0)" onclick="submitForm(${subject.subjectId})">${subject.subjectName
}</a>
</c:forEach>-->
        </section>
      </header>
      <section class="c-sort-box unBr">
        <div>
          <!-- /无数据提示 开始-->
          <section class="no-data-wrap" v-if="map.total == 0">
            <em class="icon30 no-data-ico">&nbsp;</em>
            <span class="c-666 fsize14 ml10 vam"
              >没有相关数据，小编正在努力整理中...</span
            >
          </section>
          <!-- /无数据提示 结束-->
          <article class="i-teacher-list" v-if="map.total != 0">
            <ul class="of">
              <li v-for="teacher in map.records" :key="teacher.id">
                <section class="i-teach-wrap">
                  <div class="i-teach-pic">
                    <a :href="'/teacher/'+teacher.id" :title="teacher.name" target="_blank">
                      <img :src="teacher.avatar" alt />
                    </a>
                  </div>
                  <div class="mt10 hLh30 txtOf tac">
                    <a
                      :href="'/teacher/'+teacher.id"
                      :title="teacher.name"
                      target="_blank"
                      class="fsize18 c-666"
                      >{{ teacher.name }}</a
                    >
                  </div>
                  <div class="hLh30 txtOf tac">
                    <span class="fsize14 c-999">
                      {{ teacher.intro }}
                    </span>
                  </div>
                  <div class="mt15 i-q-txt">
                    <p class="c-999 f-fA">{{ teacher.career }}</p>
                  </div>
                </section>
              </li>
            </ul>
            <div class="clear"></div>
          </article>
        </div>
        <!-- 公共分页 开始 -->
        <div>
          <div class="paging">
            <!-- undisable这个class是否存在，取决于数据属性hasPrevious -->
            <a
              :class="{ undisable: !map.hasPrevious }"
              href="#"
              title="首页"
              @click.prevent="gotoPage(1)"
              >首</a
            >
            <a v-if="map.hasPrevious"
              :class="{ undisable: !map.hasPrevious }"
              href="#"
              title="前一页"
              @click.prevent="gotoPage(map.current - 1)"
              >&lt;</a
            >
             <!-- <a v-if="page<=3" 
              v-for="page in map.pages" :key="page"
              :class="{
                current: map.current == page,
                undisable: map.current == page,
              }"
              :title="'第' + page + '页'"
              href="#"
              @click.prevent="gotoPage(page)"
              >{{ page }}</a
            > -->
            <a 
              v-for="page in map.pages"
              :key="page"
              :class="{
                current: map.current == page,
                undisable: map.current == page,
              }"
              :title="'第' + page + '页'"
              href="#"
              @click.prevent="gotoPage(page)"
              >{{ page }}</a
            >
            <a v-if="map.hasNext"
              :class="{ undisable: !map.hasNext }"
              href="#"
              title="后一页"
              @click.prevent="gotoPage(map.current + 1)"
              >&gt;</a
            >
            <a
              :class="{ undisable: !map.hasNext }"
              href="#"
              title="末页"
              @click.prevent="gotoPage(map.pages)"
              >末</a
            >
            <div class="clear" />
          </div>
        </div>
      </section>
    </section>
    <!-- /讲师列表 结束 -->
  </div>
</template>
<script>
import teacher from "@/api/teacher";
export default {
  data() {
    return {
      map: {},
    };
  },
  created() {
    this.getTeacherFrontInfo();
  },
  methods: {
    getTeacherFrontInfo() {
      teacher.getTeacherFrontList(1, 8).then((response) => {
        this.map = response.data.data;
        console.log(response.data.data);
      });
    },
    gotoPage(page) {
      if(page>this.map.pages){
        page = this.map.pages
      }
      teacher.getTeacherFrontList(page, 8).then((response) => {
        this.map = response.data.data;
      });
    },
    pageShow(){

    }
  },
};
</script>
