var util = require("../../utils/util.js")

Page({

  /**
   * 页面的初始数据
   */
  data: {
    show: false, //控制下拉列表的显示隐藏，false隐藏、true显示
    selectData:"", //下拉列表的数据
    index: 15 ,//选择的下拉列表下标
    time:"",
    content:"",
    grade:"",
    hide:true
  },
  // 点击下拉显示框
  selectTap() {
    if (this.data.hide == true) {
      this.setData({
        hide: false
      });
    }
    else {
      this.setData({
        hide: true
      });
    }
    this.setData({
      show: !this.data.show,
    });
  },
  // 点击下拉列表
  optionTap(e) {
    let Index = e.currentTarget.dataset.index; //获取点击的下拉列表的下标
    this.setData({
      index: Index,
      show: !this.data.show,
      SelectedObject: this.data.selectData[Index],
      hide: true
    });
    console.log(this.data.SelectedObject);
  },


  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    var that = this
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/GetSentNTClassList',
      data:{
        currentNo:wx.getStorageSync('CurrentNo')
      },
      success:function(res){
        console.log(res.data)
        that.setData({
          'selectData':res.data,
        })
      }
    })
  },
  FightNotice:function(e){
    var Time = util.formatDate(new Date())
    this.setData({
      time:Time
    })
    if(this.data.content == ""){
      wx.showToast({
        title: '内容不能为空',
        icon:'none',
        duration: 500,
      })
    } else if (this.data.SelectedObject ==""){
      wx.showToast({
        title: '班级不能为空',
        icon: 'none',
        duration: 500,
      })
    }else{
      wx.request({
        url: 'http://139.199.192.171:8080/chapter03/UpdateInformAction',
        data: {
          currentNo: wx.getStorageSync("CurrentNo"),
          time: this.data.time,
          content: this.data.content,
          grade: this.data.SelectedObject,
        },
        success: function (e) {
          wx.switchTab({
            url: '../teachermain/teachermain',
          })
          wx.showToast({
            title: '发送成功',
            icon: 'none',
            duration: 1000
          })
        }
      })
    }
  },
  voteTitle: function (e) {
    this.setData({
      content: e.detail.value,
    })
    console.log(this.data.content)
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