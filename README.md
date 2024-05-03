# SSRS
软件过程管理 - 实践项目：自习座位预约系统

文件结构：

![file-structure](file-structure.png)

|-src

&emsp;&emsp;|-main

&emsp;&emsp;&emsp;&emsp;|-java  // Java主源代码目录

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-com\huawei\ibooking

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-business

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-StudentBusiness.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-controller

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-IndexController.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-StudentController.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-StudyRoomController.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-dao

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-StudentDao.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-mapper

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-StudentMapper.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-model

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-StudentDO.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-StudyRoomDO.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-BookingApplication.java*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-WebConfigurer.java*

&emsp;&emsp;&emsp;&emsp;|-resources // 资源文件目录

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-com\huawei\ibooking\mapper

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-*StudentMapper.xml*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-static

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;|-templates

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-application.yml*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-data.sql*

&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;*|-schema.sql*

&emsp;&emsp;|-test

&emsp;&emsp;&emsp;&emsp;|-java // 测试主代码目录

&emsp;&emsp;&emsp;&emsp;|-resources // 测试资源文件目录
