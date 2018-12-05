// pages/parentmine/parentmine.js 
var app = getApp();
Page({
  data: {
    name: "韩家长",
    items: [{
      img: "/images/mine/g2.png",
      text: "科任：辅导员",
    },
    {
      img: "/images/mine/g3.png",
      text: "学历：研究生",
    },
    {
      img: "/images/mine/g11.png",
      text: "介绍：今年刚结婚，喜得千金",
    },
    ]
  },
  onShow: function () {
    app.editTabBar();    //显示自定义的底部导航
  },
  onLoad: function () {

  }
})
