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
    name:"",
    hide:true
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var that = this;
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/P_GetTeaList',
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

    this.setData({
      'content[0].studentNo': wx.getStorageSync('CurrentNo'),
    })
    wx.request({
      url: 'http://139.199.192.171:8080/chapter03/P_Mine',
      dataType: "json",
      data: {
        content: this.data.content
      },
      method: 'GET',
      header: {
        "Content-Type": 'json'
      },
      success: function (res) {
        console.log(res.data)
        var itemList = res.data
        var item = [];
        for (let i in itemList) {
          item.push(itemList[i])
        }
        that.setData({
          name: item[0] + '家长',
        })
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
      url: 'http://139.199.192.171:8080/chapter03/UpdateLetter',
      data:{
        currentNo:wx.getStorageSync("CurrentNo"),
        teacherName:this.data.SelectedObject,
        time:this.data.time,
        content:this.data.content,
      },
      success: function (e) {
        wx.redirectTo({
          url: '../parentmain/parentmain',
        })
        wx.showToast({
          title: '发送成功',
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