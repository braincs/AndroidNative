## so库常见问题

### 不裁剪

gradle需要增加配置

```groovy
android{
    // 不对so进行裁剪
    packagingOptions { 
        doNotStrip "**/*.so"
    }
}	

```



### so库输出

gradle配置so库path

```groovy
android{
    sourceSets.main {
        jni.srcDirs = []
        jniLibs.srcDirs = ['libs']
    }
}
```

配置后libs下的so库会打包到apk中