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
    var UserNo = wx.getStorageSync('CurrentNo');
    var that = this;


    this.setData({
      'content[0].teacherNo': wx.getStorageSync('CurrentNo'),
    })
    wx.request({
      url: 'http://localhost:8080/chapter03/TeacherMineServlet',
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
          name: item[0],
          'items[0].text': '科目：' + item[1],
          'items[1].text': '学历：' + item[2],
          'items[2].text': '介绍：' + item[3]
        })

        // that.setData({
        //   cartList: res.data.cartList,
        //   cartSize: res.data.cartSize,
        //   totalAmount: res.data.totalAmount

        // })

      }

    })

  },

})