<template>
  <div style="height: 50px; border-bottom: 1px solid #CCCCCC; display: flex">
    <div style="width: 200px; color: cornflowerblue"><h1>后台管理</h1></div>
    <div style="flex: 1"></div>
    <div style="width: 100px">
      <el-dropdown>
        <el-button>
          个人中心
          <i class="el-icon-arrow-down el-icon--right"></i>
        </el-button>
        <el-dropdown-menu slot="dropdown">
          <el-dropdown-item>个人信息</el-dropdown-item>
          <el-dropdown-item>退出</el-dropdown-item>
        </el-dropdown-menu>
      </el-dropdown>
    </div>
  </div>
</template>

<script>
    export default {
        name: "Header"
    }
</script>

<style scoped>

</style>
