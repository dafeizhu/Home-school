Page({

  /**
   * 页面的初始数据
   */
  data: {
    show: false,
    selectData: ['语文', '数学', '英语', '历史', '生物', '地理', '政治', '物理'],
    index: 0,

    voteTitle: null,
  },
  voteTitle: function(e) {
    this.data.voteTitle = e.detail.value;
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
      show: !this.data.show
    });
  },


})