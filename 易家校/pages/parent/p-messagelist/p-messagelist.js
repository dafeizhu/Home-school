// pages/Parent/p-messagelist/p-messagelist.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    content:""

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/P_GetMessageList',
      data:{
        studentNo:wx.getStorageSync("CurrentNo")
      },
      success:function(res){
        that.setData({
          content:res.data
        })
      }
    })
  },
  FightNotice: function (e) {
    wx.navigateTo({
      url: '../p-sent-message/p-sent-message',
    })
  },


  MessageDetail:function(options){
    var id = options.currentTarget.dataset.id;
    wx.navigateTo({
      url: '../p-message-details/p-message-details?id=' + id,
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