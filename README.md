#Spring cloud 项目
#部署说明
1.配置安装mysql，导入初始化脚本
2.配置安装redis
3.下载kafka，并启动
4.下载xxl-job，并打包，创建相应的数据库并启动
5.使用maven package 打包各个项目
6.使用nohup java -jar your_jar_file.jar >/dev/null 2>&1 & 启动项目
7.启动顺序，先启动gateway，再启动system，infra，随后启动各个业务服务