Page({

  /**
   * 页面的初始数据
   */
  data: {
    homelist: [],
    ClassNo:"",
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      'ClassNo': options.ClassNo
    })
    var that = this;
    wx.request({
      url: 'http://localhost:8080/chapter03/GetHWList',
      data:{
        currentNo:this.data.ClassNo,
      },
      success: function (res) {
        console.log(res.data)
        that.setData({
          'homelist': res.data,
        })
      }
    })
  },
  ClickFightHW: function (e) {
    var classno = this.data.ClassNo
    wx.navigateTo({
      url: '../hw-sent/hw-sent?ClassNo=' + classno,
    })
  },
  onclick:function(e){
    var HWcontent = e.currentTarget.dataset.content;
    wx.navigateTo({
      url: '../hw-details/hw-details?HWcontent='+HWcontent,
    })
  },
  FightNotice: function (e) {
    wx.navigateTo({
      url: '../hw-sent/hw-sent?currentNo=' + this.data.ClassNo,
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