# 项目简介

本项目主要用于个人Android开发的学习<br>
项目在《第一行代码Android（第三版）》的指导下编写<br>
项目中的注释及代码均为本人在学习中思考写下<br>
项目会持续更新，直至学期结束<br>
本项目完全开源，可任意使用<br>
欢迎各位大佬点评，指导<br>
写于 2022-1-14 3:57 a.m. 中国 江苏 南京<br>
晚安, 好梦~<br>
<br>
## 项目的一些配置
SDK放在了 E:/SDK 并且设置了用户环境变量 ANDROID_SDK_HOME 为 该目录 (完全路径 E:/SDK)<br>
.gradle文件 放并设置在了E:/Android/Configuration下 (完全路径 E:/Android/Configuration/.gradle)<br>
.android文件 放在了E:/SDK下 (完全路径 E:/SDK/.android)<br>
本人这些配置出于C盘空间不足的原因进行配置，可以根据个人喜好决定是否搬迁文件(推荐搬了)<br>
<br>
<br>
## 程序运行的提示
如果你在build里看到BUILD SUCCESSFUL in ...<br>
且在Run app的时候下面有绿色的框框Launch Succeed就代表程序已经在模拟器中安装好了<br>
另外，每次模拟结束不要关机，点×就行，关机的话，在下一次的run前<br>
在AVD manager中对你用的AVD右击进行Cold Boot Now<br>

每次调试不关闭AVD也是很香的，每次就re-run就行了<br>
导入本项目后，需修改相关配置，请注意<br>
<br>
<br>
## 遇到的一些Error及解决方案
### 1. 关于AVD的屏幕在左上角的问题
这个问题的出现应该是dpi的问题，不必去调整电脑的缩放比率，可以看看这篇文章<br>
https://blog.csdn.net/qq_44539785/article/details/109277086<br>
<br>
### 2. 打开AVD报terminated
我碰到也是很头疼，因为我已经搬迁并设置好了.ini文件<br>
可以先试试在AVD manager中能不能cold boot now，如果可以那就build就行了，不行的话就下面的步骤<br>
但是我通过删除这个avd(删的时候也会报一个An error occurred..无视)<br>
然后重新create一个avd解决了这个问题...<br>
<br>
### 3.Your anti-virus program might be impacting your build performance.
出现这个，打开你的杀毒软件，把提到的文件夹全部放入信任区就行<br>
<br>
### 4. Low disk space on a Android Studio system directory partition: ...
赶紧把.gradle文件从C盘给他扔了,我吐了<br>
<br>
<br>
## 程序的一些warning及解决方法
个人对warning其实都很难受，所以遇见一个warning就会去尝试fix<br>
### 1.在AndroidManifest.xml中
On SDK version 23 and up, <br>
your app data will be automatically backed up and restored on app install. <br>
Consider adding the attribute `android:fullBackupContent` to specify an `@xml` resource <br>
which configures which files to backup, or just set `android:fullBackupOnly=true`.<br>
<br>
解决:说的很清楚了,我选择添加<I>android:fullBackupContent="true"</I>到application的属性<br>
(另:挺方便的是你打afbc就行了)<br>
<br>
### 2.在任意文件中的字符串英文检查问题
如 Typo: In word 'activitytest'<br>
<br>
解决:alt+Enter点击save进dictionary<br>
(有时候不是我不想用camel命名法，而是真的没办法)<br>
<br>
### 3.在项目的build.gradle中，dependencies闭包内
Kotlin version that is used for building with Gradle (1.5.20)<br>
differs from the one bundled into the IDE plugin (1.6.10)<br>
版本不一样<br>
解决:修改为classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10"即可<br>
然后换个页面点gradle的sync自动下载<br>
(另:双击shift跳搜索框是什么鬼,让我切换语言特别不爽...)<br>
<br>
### 4.在app的build.gradle中
Avoid using + in version numbers; <br>
can lead to unpredictable and unrepeatable builds (junit:junit:4.+)<br>
<br>
解决: file -> project structure 在dependency中的app找到JUnit点右边小框框选择最新版本即可<br>
(只要离开页面gradle提示你sync最好都s(oul)一下)<br>
<br>
### 5. 任意布局文件的设计模式中
Hardcoded string "XXX", should use `@string` resource<br>
在res/values/string.xml中添加string name="XXX"即可,通过@string/XXX引用<br>
尽量不要硬编码,即在页面中写死数据,否则维护会很麻烦<br>
<br>
### 6. 在项目的settings.gradle中的repositories闭包下
Warning:(6, 9) JCenter Maven repository is no longer receiving updates:<br>
newer library versions may be available elsewhere<br>
这个仓库不更新了应该是<br>
<br>
## 关于AS(Asoul)更新后此书一些变动
### 1.kotlin-android-extensions被deprecated
在本书作者的新的一篇blog中可以得到很多帮助(新的DLC捏)<br>
https://blog.csdn.net/guolin_blog/article/details/113089706<br>
概述一下: ①该extensions通过HashMap存储增加了空间和时间的开支, ②多个布局中，控件使用了相同的id，会混淆<br>
<br>
### 2.ViewBinding替代kotlin-android-extensions
与1同一篇blog<br>
概述一下: 目的只有一个,为了避免编写findViewById<br>
使用条件: ①Android Studio是3.6或更高的版本 ②项目的build.gradle中加入以下配置<br>
android{buildFeatures{viewBinding true}}<br>
启动ViewBinding功能后，AS会自动为<u>每一个布局文件</u>都生成一个对应的Binding类。(注意是布局文件)<br>
<br>
<br>
## 一些零散的小技巧
### 1.
点击Android Studio顶部导航栏的Tools -> Kotlin -> Show Kotlin Bytecode<br>
来查看这段代码对应的Kotlin字节码，然后在弹出窗口中点击Decompile按钮将字节码反编译成Java代码。<br>
<br>
<br>
## 暂时就这么多, 后续碰到一些问题我会持续更新
如果你也在学习Android开发可以star一下哈哈, Thanks♪(･ω･)ﾉ<br>
大家一起进步呀~<br>
<br>
