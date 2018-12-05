Page({

  /**
   * 页面的初始数据
   */
  data: {
    content: [{ Class: '', LoginNo: '', LoginPwd: '' }],
    SaveContent: [{ Class: '', LoginNo: '', LoginPwd: '' }],
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    if (wx.getStorageSync("CurrentClass") != "" && wx.getStorageSync("CurrentNo") != "" && wx.getStorageSync("Pw")) {
      this.setData({
        'SaveContent[0].Class': wx.getStorageSync('CurrentClass'),
        'SaveContent[0].LoginNo': wx.getStorageSync('CurrentNo'),
        'SaveContent[0].LoginPwd': wx.getStorageSync('Pw'),
      })
      wx.request({
        url: 'http://localhost:8080/chapter03/LoginServlet',
        dataType: "json",
        data: {
          content: this.data.SaveContent,
        },
        method: 'GET',
        success: function (res) {
          if (res.data == 'Tea') {
            wx.switchTab({
              url: '../teachermain/teachermain',
            })
            wx.showToast({
              title: '登录成功',
              icon: 'none',
              duration: 500
            })
          }
          else if (res.data == 'Par') {
            wx.redirectTo({
              url: '../parent/parentmain/parentmain',
            })
          } else {
            wx.showToast({
              title: '请重新登录',
              icon: 'none',
              duration: 2000
            })
          }
        }
      })
    }
  },
  GetClass: function (e) {
    wx.setStorage({
      key: 'CurrentClass',
      data: e.detail.value,
    })
  },
  GetNo:function(e){
    wx.setStorage({
      key: 'CurrentNo',
      data: e.detail.value,
    })
  },
  GetPw:function(e){
    wx.setStorage({
      key: 'Pw',
      data: e.detail.value,
    })
  },
  loginclick: function (event) {
    if(wx.getStorageSync("CurrentClass")==""){
      wx.showToast({
        title: '请选择登录身份',
        icon: 'none',
        duration: 500
      })
    }else if(wx.getStorageSync("CurrentNo")==""){
      wx.showToast({
        title: '账号不能为空',
        icon: 'none',
        duration: 500
      })
    }else if(wx.getStorageSync('Pw')==""){
      wx.showToast({
        title: '密码不能为空',
        icon: 'none',
        duration: 500
      })
    }else{
    this.setData({
      'content[0].Class': wx.getStorageSync('CurrentClass'),
      'content[0].LoginNo': wx.getStorageSync('CurrentNo'),
      'content[0].LoginPwd': wx.getStorageSync('Pw'),

    })
    wx.request({
      url: 'http://localhost:8080/chapter03/LoginServlet',
      dataType: "json",
      data: {
        content: this.data.content,
      },
      method: 'GET',
      success: function (res) {
        if (res.data == 'Tea') {
          wx.switchTab({
            url: '../teachermain/teachermain',
          })
          wx.showToast({
            title: '登录成功',
            icon: 'none',
            duration: 500
          })
        }
        else if(res.data == 'Par') {
          wx.redirectTo({
            url: '../parent/parentmain/parentmain',
          })
          wx.showToast({
            title: '登录成功',
            icon: 'none',
            duration: 500
          })
        }else{
          wx.showToast({
            title: '密码或者账号错误！',
            icon: 'none',
            duration: 2000
          })
        }
      }
    })
    }
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