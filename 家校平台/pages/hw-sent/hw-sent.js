var util = require('../../utils/util.js')

Page({

  /**
   * 页面的初始数据
   */
  data: {
    show: false,
    selectData: ['语文', '数学', '英语', '历史', '生物', '地理', '政治', '物理','化学'],
    index: 15,
    content: null,
    currentNo:"",
    SelectedObject:"",
    time:""
  },

  voteTitle: function (e) {
    this.setData({
      content:e.detail.value,
    })
  },

  // 点击下拉显示框
  selectTap() {
    this.setData({
      show: !this.data.show
    });
  },
  // 点击下拉列表
  optionTap(e) {
    let Index = e.currentTarget.dataset.index; //获取点击的下拉列表的下标
    this.setData({
      index: Index,
      show: !this.data.show,
      SelectedObject:this.data.selectData[Index],
    });
    console.log(this.data.SelectedObject);
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    this.setData({
      'currentNo':options.currentNo,
    })
    console.log(this.data.currentNo)
  },
  fightHW:function(e){
    var DATE = util.formatDate(new Date())
    this.setData({
      time:DATE
    })
    wx.request({
      url: 'http://localhost:8080/chapter03/UpdateHW',
      data:{
        ClassNo: this.data.currentNo,
        Object: this.data.SelectedObject,
        HWcontent: this.data.content,
        SendTime:this.data.time
      },
      success:function(e){
        wx.switchTab({
          url: '../teachermain/teachermain',
        })
        wx.showToast({
          title: '发布成功',
          icon: 'none',
          duration: 1000
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