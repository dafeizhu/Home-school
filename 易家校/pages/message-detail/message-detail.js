// pages/message-detail/message-detail.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    id:"",
    Par:"",
    Tea:"",
    time:"",
    content:""
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var id = options.id
    var Par = options.Par
    var Tea = options.Tea
    var time = options.time
    var that = this
    this.setData({
      id:id,
      Par:Par,
      Tea:Tea,
      time:time
    })
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/GetMessageDetail',
      data:{
        id:id
      },
      success:function(res){
        console.log(res.data)
        that.setData({
          content:res.data
        })
      }
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