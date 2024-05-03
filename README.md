# SSRS
软件过程管理 - 实践项目：自习座位预约系统

文件结构：

![file-structure](file-structure.png)

|-src

​        |-main

​                |-java  // Java主源代码目录

​                        |-com\huawei\ibooking

​                                |-business

​                                        *|-StudentBusiness.java*

​                                |-controller

​                                        *|-IndexController.java*

​                                        *|-StudentController.java*

​                                        *|-StudyRoomController.java*

​                                |-dao

​                                        *|-StudentDao.java*

​                                |-mapper

​                                        *|-StudentMapper.java*

​                                |-model

​                                        *|-StudentDO.java*

​                                        *|-StudyRoomDO.java*

​                                *|-BookingApplication.java*

​                                *|-WebConfigurer.java*

​                |-resources // 资源文件目录

​                        |-com\huawei\ibooking\mapper

​                                |-*StudentMapper.xml*

​                        |-static

​                        |-templates

​                        *|-application.yml*

​                        *|-data.sql*

​                        *|-schema.sql*

​        |-test

​                |-java // 测试主代码目录

​                |-resources // 测试资源文件目录
