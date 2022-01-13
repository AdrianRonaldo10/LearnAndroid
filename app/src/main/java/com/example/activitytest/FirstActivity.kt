package com.example.activitytest
/* 在该包下编写activity相关代码，如onCreate */

/* 视图与逻辑分离，在./res/layout下新建一个Layout resource file */


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import com.example.activitytest.databinding.FirstLayoutBinding

class FirstActivity : AppCompatActivity() {

    // 在onCreate()函数之外的地方对控件进行操作，那么就将binding变量声明成全局变量
    // 使用lateinit关键字对binding变量进行延迟初始化。
    private lateinit var binding: FirstLayoutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      布局编写完成后通过setContentView()z在Activity中加载布局
//      项目中添加的资源会在R文件中生成对应的ID
        setContentView(R.layout.first_layout) // 代码中通过R.layout.XXX引用资源
        Log.d("bzd", "尝试")

        // Activity中其他的一些行为
        // Toast信息通知,一段时间后自动消失
        // findViewById方法返回继承View的泛型对象，无法自动推导

        // 提示 kotlin-android-extensions被deprecated 而使用view binding
        val pressBtn: Button = findViewById(R.id.PressBtn) // 在R文件中通过id找到
        // 设置onClick事件监听器
        // 通过静态方法makeText()创建出一个Toast对象
        // 第一个参数是Context (Activity是Context对象), 第三个参数是显示的时长
        pressBtn.setOnClickListener {
            Toast.makeText(this, "菜菜 捞捞 呜呜", Toast.LENGTH_SHORT).show()
        } // 使用了lambda表达式

        // 使用viewBinding
        // 启动ViewBinding功能后，AS自动为的每一个布局文件都生成一个对应的Binding类。
        // 命名规则:将布局文件按驼峰方式重命名后，加上Binding作为结尾。
        binding = FirstLayoutBinding.inflate(layoutInflater)
        // setContentView(binding.root)
        binding.textView.setText(R.string.jiaran) // 貌似没用，回头试试


    }
}