<template>
	<div>
		<el-container>
			<!--			<el-divider class="m-divider"><i class="el-icon-arrow-up"></i></el-divider>-->
			<el-footer>
				<a href="https://github.com/krislinzhao/KrislinBlog" target="_blank">KrislinBlog</a>
			</el-footer>
		</el-container>
	</div>
</template>

<script>
export default {
	name: "Footer"
}
</script>

<style scoped>
/*底栏样式*/
.el-footer {
	color: #333;
	text-align: center;
	line-height: 65px;
	font-family: 'Dubai Light';
	font-size: 18px;
	margin-top: 100px;
}

/*分割线样式*/
.m-divider {
	margin-top: 100px;
	margin-bottom: -100px;
}
</style>
