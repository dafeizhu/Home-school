Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: [{
        one: "作业",
        two: "通知",
        three: "班级",
        four:"私信"
      },

    ],
  },

  ClickHW: function() {
    wx.navigateTo({
      url: '../classlist/classlist',
    })
  },
  ClickNotice:function(e){
    wx.navigateTo({
      url: '../notifications/notifications',
    })
  },
  ClickMessage:function(e){
    wx.navigateTo({
      url: '../messagelist/messagelist',
    })
  }
})