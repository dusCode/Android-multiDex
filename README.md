### 在Gradle和代码中配置使用MultiDex

由于Android 的Gradle插件在Android Build Tool 21.1开始之处使用mulitidex,所以我们需要使用Android Build Tools 21.1及以上版本，修改app目录下的build.gradle文件:

1. 在defaultConfig中添加multiDexEnabled true这个配置项

2. 在dependencies中添加multidex的依赖 compile 'com.android.support:multidex:1.0.0'

**注意：buildToolsVersion要高于21.1**
配置如下：
// defaultConfig
multiDexEnabled true
// dependencies
compile files('libs/android-support-multidex.jar')

###  在Gradle中配置好之后，我们还需要在代码中加入支持multidex的功能，有三种方案可选
1. 在manifest文件中指定Application为MultiDexApplication
2. 写一个Application类并继承MultiDexApplication，并在AndroidManifest.xml的application标签中进行注册（在application标签中增加name属性，并添加自己的Application类名即可），如果不是想重写MultiDexApplication中一些方法的话，还是方案一更方便些
3. 如果不想按方案二继承，我们可以重写Application的attachBaseContext方法，注意，这个方法比onCreate方法先执行。具体方法是创建一个新类，继承Application，然后重写attachBaseContext方法，并在AndroidManifest.xml的application标签中进行注册（与方案二注册相同）