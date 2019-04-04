//app.js  
App({
  onLaunch: function () {

  },

  //第一种底部  
  editTabBar: function () {
    //使用getCurrentPages可以获取当前加载中所有的页面对象的一个数组，数组最后一个就是当前页面。

    var curPageArr = getCurrentPages(); //获取加载的页面
    var curPage = curPageArr[curPageArr.length - 1]; //获取当前页面的对象
    var pagePath = curPage.route; //当前页面url
    if (pagePath.indexOf('/') != 0) {
      pagePath = '/' + pagePath;
    }

    var tabBar = this.globalData.tabBar;
    for (var i = 0; i < tabBar.list.length; i++) {
      tabBar.list[i].active = false;
      if (tabBar.list[i].pagePath == pagePath) {
        tabBar.list[i].active = true; //根据页面地址设置当前页面状态    
      }
    }
    curPage.setData({
      tabBar: tabBar
    });
  },
  globalData: {
    //第一种底部导航栏显示
    tabBar: {
      "color": "#bfbfbf",
      "selectedColor": "#d81e06",
      "backgroundColor": "while",
      "borderStyle": "#ccc",
      "list": [{
        "pagePath": "/pages/parent/parentmain/parentmain",
        "text": "主 页",
        "iconPath": "/images/teachermain/h18.png",
        "selectedIconPath": "/images/teachermain/h18.png",
        "clas": "menu-item",
        active: true
      },
      {
        "pagePath": "/pages/parent/parentmine/parentmine",
        "text": "我 的",
        "iconPath": "/images/teachermain/Document_Fav.png",
        "selectedIconPath": "/images/teachermain/Document_Fav.png",
        "clas": "menu-item",
        active: false
      }
      ],
      "position": "bottom"
    },
    
  }
})