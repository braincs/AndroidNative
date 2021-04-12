//
// Created by Shuai on 4/11/21.
//
#include <jni.h>
#include <android/log.h>
#define NATIVE_JNI_FUNC(name)Java_com_braincs_nativebytes_##name

extern "C"
JNIEXPORT void JNICALL
NATIVE_JNI_FUNC(NativeAPI_passBytes)(JNIEnv *env, jclass type, jbyteArray data_) {
jbyte *data = env->GetByteArrayElements(data_, NULL);
jbyte *tmp = data;
for(int i= 0; i < 10; i++){
    __android_log_print(ANDROID_LOG_ERROR, "SDK", "data %d: %c", i, *tmp);
    tmp++;
}

env->ReleaseByteArrayElements(data_, data, 0);
}
