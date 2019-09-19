//
// Created by TY on 2019-09-02.
//

#ifndef STATICLIBRARYDEMO_STATICLIB_H
#define STATICLIBRARYDEMO_STATICLIB_H

#include <android/log.h>

#define LOG "JNILOG"

#define LOGD(...) __android_log_print(ANDROID_LOG_DEBUG,LOG,__VA_ARGS__)
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG,__VA_ARGS__)
#define LOGW(...) __android_log_print(ANDROID_LOG_WARN,LOG,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG,__VA_ARGS__)
#define LOGF(...) __android_log_print(ANDROID_LOG_FATAL,LOG,__VA_ARGS__)

#ifdef __cplusplus
extern "C" {
#endif
    const char* apple();
#ifdef __cplusplus
}
#endif


#endif //STATICLIBRARYDEMO_STATICLIB_H
