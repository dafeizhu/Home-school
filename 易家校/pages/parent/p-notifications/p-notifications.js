// pages/Parent/p-notifications/p-notifications.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: [{
      title: "内容：",
      brief_message: "尊敬的各位家长，我校定于10月2...",
      data: "10-26"
    },
    {
      title: "内容：",
      brief_message: "关于家教月刊《父母课堂》订阅意...",
      data: "10-17"
    },
    ],
    content:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/P_NoticeList',
      data:{
        currentNo:wx.getStorageSync("CurrentNo")
      },
      success(res){
        console.log(res.data)
        that.setData({
          content:res.data
        })
      }
    })
  },
  NoticeDetail:function(e){
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../p-notification-details/p-notification-details?id='+id,
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})