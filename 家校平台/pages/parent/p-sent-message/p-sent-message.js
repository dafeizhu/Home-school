// pages/Parent/p-sent-message/p-sent-message.js
var util = require('../../../utils/util.js')
Page({

  /**
   * 页面的初始数据
   */
  data: {
    selectData:"",
    index: 10,
    SelectedObject:"",
    time:"",
    content:"",
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://localhost:8080/chapter03/P_GetTeaList',
      data:{
        currentNo:wx.getStorageSync("CurrentNo")
      },
      success:function(res){
        that.setData({
          selectData:res.data
        })
        console.log(that.data.selectData)
      }
    })
  },
  voteTitle: function (e) {
    this.setData({
      content: e.detail.value,
    })
  },
  FightLetter:function(e){
    var DATE = util.formatDate(new Date())
    this.setData({
      time: DATE
    })
    console.log(this.data.SelectedObject);
    console.log(this.data.time);
    wx.request({
      url: 'http://localhost:8080/chapter03/UpdateLetter',
      data:{
        currentNo:wx.getStorageSync("CurrentNo"),
        teacherName:this.data.SelectedObject,
        time:this.data.time,
        content:this.data.content,
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },
  selectTap() {
    this.setData({
      show: !this.data.show
    });
  },
  optionTap(e) {
    let Index = e.currentTarget.dataset.index; //获取点击的下拉列表的下标
    this.setData({
      index: Index,
      show: !this.data.show,
      SelectedObject: this.data.selectData[Index],
    });
    console.log(this.data.SelectedObject);
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