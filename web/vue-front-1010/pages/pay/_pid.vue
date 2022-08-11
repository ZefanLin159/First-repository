<template>
  <div class="cart py-container">
    <!--主内容-->
    <div class="checkout py-container pay">
      <div class="checkout-tit">
        <h4 class="fl tit-txt">
          <span class="success-icon"></span
          ><span class="success-info"
            >订单提交成功，请您及时付款！订单号：{{ payObj.out_trade_no }}</span
          >
        </h4>
        <span class="fr"
          ><em class="sui-lead">应付金额：</em
          ><em class="orange money">￥ {{ payObj.total_fee }}</em></span
        >
        <div class="clearfix"></div>
      </div>
      <div class="checkout-steps">
        <div class="fl weixin">微信支付</div>
        <div class="fl sao">
          <p class="red">请使用微信扫一扫。</p>
          <div class="fl code">
            <!-- <img id="qrious" src="~/assets/img/erweima.png" alt=""> -->
            <!-- <qriously value="weixin://wxpay/bizpayurl?pr=R7tnDpZ" :size="338"/> -->
            <qriously :value="payObj.code_url" :size="338" />
            <div class="saosao">
              <p>请使用微信扫一扫</p>
              <p>扫描二维码支付</p>
            </div>
          </div>
        </div>
        <div class="clearfix"></div>
        <!-- <p><a href="pay.html" target="_blank">> 其他支付方式</a></p> -->
      </div>
    </div>
  </div>
</template>
<script>
import orderApi from "@/api/order";
export default {
  data() {
    return {
      orderId: "",
      payObj: {},
      timer:"",
    };
  },
  created() {
    if (this.$route.params && this.$route.params.pid) {
      this.orderId = this.$route.params.pid;
      this.cretateNativeInfo();
    }
  },
  //   支付后调用，每隔三秒调用一次查询订单状态的方法
  mounted() {
    this.timer =  setInterval(() => {
      this.queryPayStatusInfo(this.payObj.out_trade_no);
    }, 3000);
  },
  methods: {
    queryPayStatusInfo(orderId) {
      orderApi.queryPayStatus(orderId).then((response) => {
        // 支付成功，清除定时器
        // console.log(response.data)
        if(response.data.data.code != 25000){
        clearInterval(this.timer)
        this.$message({
          type: "success",
          message: "支付成功！",
        });
        // 跳转回到课程详情页面
        this.$router.push({ path: "/course/" + this.payObj.course_id });
        }
      });
    },
    cretateNativeInfo() {
      orderApi.createNative(this.orderId).then((response) => {
        this.payObj = response.data.data;
        console.log(response.data.data);
      });
    },
  },
};
</script>
