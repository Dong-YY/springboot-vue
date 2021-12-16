<template>
    <div>
      <div style="margin-top: 20px">
        <el-input placeholder="请输入用户名" clearable style="width: 200px"></el-input>
        <el-button type="primary" plain>搜索</el-button>
      </div>
      <div style="margin-top: 15px">
        <el-button type="primary" plain size="mini"><i class="el-icon-plus"></i>新增</el-button>
        <el-button type="warning" plain size="mini"><i class="el-icon-edit"></i>修改</el-button>
        <el-button type="info" plain size="mini">导入</el-button>
        <el-button type="info" plain size="mini">导出</el-button>
      </div>
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          prop="date"
          label="日期"
          sortable
          width="300px"
          >
        </el-table-column>
        <el-table-column
          prop="name"
          label="姓名"
          width="300px">
        </el-table-column>
        <el-table-column
          prop="address"
          label="地址"
          width="300px">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <el-button @click="handleClick(scope.row)" type="text" size="small">修改</el-button>
            <el-button type="text" size="small">删除</el-button>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20]"
        :page-size="10"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>
    </div>
</template>

<script>
    export default {
        name: "Home",
      data(){
          return {
            total: 10,
            currentPage: 1,
            tableData: [{
              date: '2016-05-02',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1518 弄'
            }, {
              date: '2016-05-04',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1517 弄'
            }, {
              date: '2016-05-01',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1519 弄'
            }, {
              date: '2016-05-03',
              name: '王小虎',
              address: '上海市普陀区金沙江路 1516 弄'
            }]
          }
      },
      methods: {
        handleClick(){

        },
        handleSizeChange(){

        },
        handleCurrentChange(){

        },
      }
    }
</script>

<style scoped>

</style>
