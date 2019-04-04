var app = getApp();
Page({

  /**
   * 页面的初始数据
   */
  data: {
    name: '',
    items: [{
      img: "/images/mine/g2.png",
      text: '',
    },
    {
      img: "/images/mine/g3.png",
      text: '',
    },
    {
      img: "/images/mine/g11.png",
      text: '',
    },
    ],
    content: [{
      teacherNo: ''
    }]
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    app.editTabBar();    //显示自定义的底部导航
    var UserNo = wx.getStorageSync('CurrentNo');
    var that = this;


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
          'items[0].text': '班级：' + item[1],
          'items[1].text': '班主任：' + item[2],
          'items[2].text': '联系方式：' + item[3]
        })
      }

    })

  },
  Loginout: function (e) {
    wx.clearStorage();
    wx.redirectTo({
      url: '../../login/login',
    })
  }

})