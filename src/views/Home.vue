<template>
    <div>
      <div style="margin-top: 20px">
        <el-input placeholder="请输入昵称" v-model="nickName" clearable style="width: 200px"></el-input>
        <el-button type="primary" plain @click="load">搜索</el-button>
      </div>
      <div style="margin-top: 15px">
        <el-button type="primary" @click="add" plain size="mini"><i class="el-icon-plus"></i>新增</el-button>
        <el-button type="warning" plain size="mini"><i class="el-icon-edit"></i>修改</el-button>
        <el-button type="info" plain size="mini">导入</el-button>
        <el-button type="info" plain size="mini">导出</el-button>
      </div>
      <el-table
        :data="tableData"
        style="width: 100%">
        <el-table-column
          prop="id"
          label="ID"
          sortable
          width="200px">
        </el-table-column>
        <el-table-column
          prop="userName"
          label="用户名"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="password"
          label="密码"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="nickName"
          label="昵称"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="age"
          label="年龄"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="sex"
          label="性别"
          width="200px">
        </el-table-column>
        <el-table-column
          prop="address"
          label="地址"
          width="200px">
        </el-table-column>
        <el-table-column
          fixed="right"
          label="操作"
          width="100">
          <template slot-scope="scope">
            <el-button @click="update(scope.row)" type="text" size="small">修改</el-button>
            <el-popconfirm title="你确定要删除吗？" @confirm="del(scope.row.id)">
              <template #reference>
                <el-button type="text" size="small">删除</el-button>
              </template>
            </el-popconfirm>
          </template>
        </el-table-column>
      </el-table>
      <el-pagination
        @size-change="handleSizeChange"
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-sizes="[5, 10, 20]"
        :page-size="pageSize"
        layout="total, sizes, prev, pager, next, jumper"
        :total="total">
      </el-pagination>

<!--添加弹窗-->
      <el-dialog
        title="提示"
        :visible.sync="dialogVisible"
        width="30%">
        <el-form ref="form" :model="form" label-width="80px">
          <el-form-item label="用户名">
            <el-input v-model="form.userName" style="width: 350px;"></el-input>
          </el-form-item>
          <el-form-item label="昵称">
            <el-input v-model="form.nickName" style="width: 350px;"></el-input>
          </el-form-item>
          <el-form-item label="年龄">
            <el-input v-model="form.age" style="width: 350px;"></el-input>
          </el-form-item>
          <el-form-item label="性别">
            <el-radio v-model="form.sex" label="男">男</el-radio>
            <el-radio v-model="form.sex" label="女">女</el-radio>
          </el-form-item>
          <el-form-item label="地址">
            <el-input v-model="form.address" style="width: 350px;"></el-input>
          </el-form-item>
        </el-form>
        <span slot="footer" class="dialog-footer">
    <el-button @click="dialogVisible = false">取 消</el-button>
    <el-button type="submit" @click="save">确 定</el-button>
  </span>
      </el-dialog>
    </div>
</template>

<script>
    import request from "../utils/request";

    export default {
        name: "Home",
      data(){
          return {
            nickName: '',
            radio: '',
            form: {},

            dialogVisible: false,
            currentPage: 1,
            pageSize: 10,
            total: 0,
            tableData: []
          }
      },
      created() {
        this.load()
      },
      methods: {

        load(){
          request.get("http://localhost:9090/user",{
            params: {
              pageNum: this.currentPage,
              pageSize: this.pageSize,
              name: this.nickName
            }
          }).then(res =>{
            console.log(res)
            this.tableData = res.data.records
            this.total = res.data.total
          })
        },
        add(){
          this.dialogVisible = true
          this.form = {}
        },
        update(row){
          this.form = JSON.parse(JSON.stringify(row))
          this.dialogVisible = true
        },
        del(id){
            request.delete("http://localhost:9090/user/"+ id ).then(res =>{
              console.log(id)
              if(res.code === '0'){
                  this.$message({
                    type: "success",
                    message: "删除成功",
                  })
                if(res.current){

                }
              }else {
                this.$message({
                  type: "error",
                  message: res.msg
                })
              }
              this.load();
            })
        },
        save(){
          if (this.form.id) { //更新
              request.put("http://localhost:9090/user",this.form).then(res =>{
                if(res.code === '0'){
                  this.$message({
                    type: "success",
                    message: "更新成功",
                  })
                }else {
                  this.$message({
                    type: "error",
                    message: res.msg
                  })
                }
                this.load()
                this.dialogVisible = false
              })
          } else{ //新增
            request.post("http://localhost:9090/user",this.form).then(res =>{
              if(res.code === '0'){
                this.$message({
                  type: "success",
                  message: "更新成功",
                })
              }else {
                this.$message({
                  type: "error",
                  message: res.msg,
                })
              }
              this.load()
              this.dialogVisible = false
            })
          }
        },
        handleSizeChange(pageSize){ //改变当前页面的条数
          this.pageSize = pageSize
          this.load()
        },
        handleCurrentChange(pageNum){ //改变当前页码
          this.currentPage = pageNum
          this.load()
        },
      }
    }
</script>

<style scoped>

</style>
