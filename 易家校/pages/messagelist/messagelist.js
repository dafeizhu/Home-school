// pages/massagelist/massagelist.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    ListData:""

  },
  

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/GetMessageList',
      data:{
        currentNo:wx.getStorageSync("CurrentNo")
      },
      success:function(res){
        console.log(res.data)
        that.setData({
          ListData:res.data
        })
      }
    })
  },
  ClickDetails:function(event){
    var id = event.currentTarget.dataset.id
    var Par = event.currentTarget.dataset.sendname
    var Tea = event.currentTarget.dataset.getname
    var time =event.currentTarget.dataset.time
    wx.navigateTo({
      url: '../message-detail/message-detail?id='+id +'&Par='+Par +'&Tea='+Tea +'&time='+time,
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
    var that = this
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/GetMessageList',
      data: {
        currentNo: wx.getStorageSync("CurrentNo")
      },
      success: function (res) {
        console.log(res.data)
        that.setData({
          ListData: res.data
        })
      }
    })
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