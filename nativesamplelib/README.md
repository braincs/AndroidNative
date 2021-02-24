## SDK 编译

执行gradle task中的 assemble 会触发cmake的编译

输出

- `libs/arm64-v8a/` 路径下



## SDK调用

由于是C++ SDK 库，所以符号表会发生变化

使用指令`nm -D`查看

```bash
❯ nm -D nativedlopen/libs/arm64-v8a/libsdk.so |grep " T "
000000000000057c T _ZN3sdk11get_versionEPPKc

#调用方法 _ZN3sdk11get_versionEPPKc
```

