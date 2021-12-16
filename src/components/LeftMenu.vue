<template>
    <div>
      <div>
        <el-row class="tac">
          <el-col :span="12">
            <el-menu style="width: 200px;min-height: calc(100vh - 50px)"
                     default-active="2"
                     class="el-menu-vertical-demo">
              <el-submenu index="1">
                <template slot="title">
                  <i class="el-icon-location"></i>
                  <span>导航一</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">选项1</el-menu-item>
                  <el-menu-item index="1-2">选项2</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
              <el-submenu index="2">
                <template slot="title">
                  <i class="el-icon-menu"></i>
                  <span>导航二</span>
                </template>
                <el-menu-item-group>
                  <el-menu-item index="1-1">选项一</el-menu-item>
                  <el-menu-item index="1-2">选项二</el-menu-item>
                </el-menu-item-group>
              </el-submenu>
            </el-menu>
          </el-col>
        </el-row>
      </div>
    </div>
</template>

<script>
    export default {
        name: "LeftMenu"
    }
</script>

<style scoped>

</style>
