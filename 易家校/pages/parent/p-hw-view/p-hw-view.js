// pages/Parent/p-hw-view/p-hw-view.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    items: [{
      sub: '语文',
      date: "2018年11月01日",
      postId: 0
    },
    {
      sub: '数学',
      date: "2018年11月01日",
      postId: 1
    },
    {
      sub: '英语',
      date: "2018年11月01日",
    },
    {
      sub: '语文',
      date: "2018年11月02日",
    },
    {
      sub: '数学',
      date: "2018年11月02日",
    },
    {
      sub: '英语',
      date: "2018年11月02日",
    },
    {
      sub: '语文',
      date: "2018年11月03日",
    },
    {
      sub: '数学',
      date: "2018年11月03日",
    },
    {
      sub: '英语',
      date: "2018年11月03日",
    },
    ],
    HwList:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/P_HwList',
      data:{
        currentNo:wx.getStorageSync("CurrentNo")
      },
      success:function(res){
        that.setData({
          HwList:res.data
        })
      }
    })
  },
  ClickHwDetail:function(options){
    var content=options.currentTarget.dataset.content
    wx.navigateTo({
      url: '../p-hw-details/p-hw-details?content='+content,
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