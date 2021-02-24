//
// Created by Shuai on 2/24/21.
//

#include <jni.h>
#include <dlfcn.h>
#include <stdio.h>
#include <android/log.h>
#include <string>

typedef void (*CALL_FUNC1)(const char **);

#define FUNCNAME(x)   Java_com_braincs_nativedlopen_NDlopenActivity_##x

extern "C"
JNIEXPORT jstring JNICALL FUNCNAME(getVersion)(JNIEnv *env, jobject instance) {
    __android_log_print(ANDROID_LOG_DEBUG, "SDK", "jni call getSDKVersion");
    void *handle = NULL;
    CALL_FUNC1 func = NULL;
    const char *err;
    handle = dlopen("libsdk.so", RTLD_LAZY);
    if (!handle) {
        err = dlerror();
        __android_log_print(ANDROID_LOG_ERROR, "SDK", "%s", err);
        return env->NewStringUTF(err);
    }

    //Use dlsym() to get square() function
    func = (CALL_FUNC1) dlsym(handle, "_ZN3sdk11get_versionEPPKc");
    if (!func) {
        err = dlerror();
        __android_log_print(ANDROID_LOG_ERROR, "SDK", "%s", err);
        return env->NewStringUTF(dlerror());
    }

    __android_log_print(ANDROID_LOG_DEBUG, "SDK", "call get_version");

    const char *version;
    func(&version);
    dlclose(handle);

    return env->NewStringUTF(version);
}
