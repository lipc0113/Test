# Test

# 一、简介
项目主要用来知识积累，学习使用

## 1.app


## 2.library
用于管理所有android库还有第三方库

## 3.android-skin-loader-lib皮肤框架

    1.load增加同步加载方法，用于处理某些在app外部换肤需求
    2.扩展了BaseSkinAppCompatActivity
    	a.先调用的**setFactory2**，再调用super.onCreate(savedInstanceState)，因为在中的super.onCreate会设置mFactory
    	b.然后改写onCreateView方法

## 4.skin-library
皮肤包

# 二、项目功能列表截图

# 三、功能TODO List

- [x] 首页
- [ ] 欢迎页

# 四、使用的开源库
[Android-Skin-Loader](https://github.com/fengjundev/Android-Skin-Loader)

