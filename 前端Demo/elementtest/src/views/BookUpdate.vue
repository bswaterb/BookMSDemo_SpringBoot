<template>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="图书编号" prop="id">
            <el-input v-model="ruleForm.id"></el-input>
        </el-form-item>

        <el-form-item label="图书名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">确认修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置为空</el-button>
        </el-form-item>
    </el-form>

</template>

<script>
    export default {
        data() {
            return {
                ruleForm: {
                    id:'',
                    name: '',
                    author:''
                },
                rules: {
                    id:[
                        { required: true, message: '请输入编号', trigger: 'blur' }
                    ],
                    name: [
                        { required: true, message: '请输入书名', trigger: 'blur' },
                        { min: 1, max: 40, message: '长度在 3 到 5 个字符', trigger: 'blur' }
                    ],
                    author: [
                        { required: true, message: '请输入作者名', trigger: 'blur' },
                        { min: 1, max: 20, message: '长度在 1 到 20 个字符', trigger: 'blur' }
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put('http://localhost:8181/book/updateBook',_this.ruleForm).then(function (resp) {
                            //console.log(resp)
                            if(resp.data == 'success'){
                                _this.$alert('《'+_this.ruleForm.name+'》修改成功！','消息',{
                                    confirmButtonText: '确定',
                                    callback:action => {
                                        _this.$router.push('/BookManage')
                                    }
                                })
                            }else{
                                _this.$message('修改失败');
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            }
        },
        created() {
            const _this = this
            axios.get("http://localhost:8181/book/findById/"+_this.$route.query.id).then(function (resp) {
                _this.ruleForm = resp.data
            })
        }
    }
</script>