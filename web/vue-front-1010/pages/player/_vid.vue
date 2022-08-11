<template>
  <div>
    <!-- 阿里云视频播放器样式 -->
    <title>Vod</title>
    <link
      rel="stylesheet"
      href="//g.alicdn.com/de/prismplayer/2.9.18/skins/default/aliplayer-min.css"
    />
    <script
      type="text/javascript"
      src="//g.alicdn.com/de/prismplayer/2.9.18/aliplayer-min.js"
    />
    <!-- 定义播放器dom -->
    <div id="J_prismPlayer" class="prism-player" />
  </div>
</template>
<script>
import vodApi from "@/api/vod";
export default {
  data() {
    return {
      videoSourceId: "",
      playAuth: "",
    };
  },
  created() {
    if (this.$route.params && this.$route.params.vid) {
      this.videoSourceId = this.$route.params.vid;
      // console.log(this.videoSourceId);
      this.getTicket();
    }
  },
  methods: {
    getTicket() {
      vodApi.getVideoTicket(this.videoSourceId).then((response) => {
        this.playAuth = response.data.data.playAuth;
        // console.log(this.playAuth)
      });
    },
  },
  mounted() {
    // console.log(this.videoSourceId)
    // console.log(this.playAuth)
    setTimeout(() => {
      var player = new Aliplayer(
        {
          id: "J_prismPlayer",
          autoplay: false,
          width: "500px",
          height: "500px",
          encryptType: "1",
          vid: this.videoSourceId,
          playauth: this.playAuth,
          cover: "",
        },
        function (player) {
          console.log("播放器创建成功");
        }
      );
    }, 500)
  },
};
</script>
