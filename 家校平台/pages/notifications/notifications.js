// pages/notifications/notifications.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    notice:"",
  },
  // FightNotice:function(e){
  //   wx.navigateTo({
  //     url: '../sent-notice/sent-notice',
  //   })
  // },
  HWdetail:function(e){
    var Id = e.currentTarget.dataset.id
    var name = e.currentTarget.dataset.name
    wx.navigateTo({
      url: '../notification-details/notification-details?id='+Id + '&name='+ name,
    })
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/chapter03/GetNoticeList',
      data:{
        currentNo:wx.getStorageSync("CurrentNo")
      },
      success:function(res){
        that.setData({
          notice:res.data,
        })
      }
    })
  },
  FightNotice:function(e){
    wx.navigateTo({
      url: '../sent-notice/sent-notice',
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})