// pages/parentmain/parentmain.js
var app = getApp();
Page({
  data: {
    items: [{
      one: "作业",
      two: "通知",
      three: "班级",
      four: "私信"
    },

    ],
  },
  onShow: function () {
    app.editTabBar();    //显示自定义的底部导航
  },
  onLoad: function () {
    
  },
  // 查看作业
  ClickHW:function(e){
    wx.navigateTo({
      url: '../p-hw-view/p-hw-view',
    })
  },
  // 查询通知
  ClickNT:function(e){
    wx.navigateTo({
      url: '../p-notifications/p-notifications',
    })
  },
  // 查看私信
  ClickMg:function(e){
    wx.navigateTo({
      url: '../p-messagelist/p-messagelist',
    })
  }
})  
