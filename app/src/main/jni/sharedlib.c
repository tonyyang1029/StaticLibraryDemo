#include <jni.h>
#include <malloc.h>
#include <string.h>
#include <stdbool.h>

#include "staticlib.h"

JNIEXPORT jstring JNICALL
Java_com_ty_android_staticlibrarydemo_SharedLib_getData(JNIEnv *env, jclass clazz) {
    return (*env)->NewStringUTF(env, apple());
}

JNIEXPORT jstring JNICALL
Java_com_ty_android_staticlibrarydemo_SharedLib_updateData(JNIEnv *env, jclass clazz, jstring data) {
    char string[50] = {0};
    char* updates = (char *) (*env)->GetStringUTFChars(env, data, 0);
    strcpy(string, "Greeting from Apple ");
    strcpy((string + strlen(string)), updates);
    (*env)->ReleaseStringUTFChars(env, data, updates);
    return (*env)->NewStringUTF(env, string);
}

JNIEXPORT void JNICALL
Java_com_ty_android_staticlibrarydemo_SharedLib_updateNumber(JNIEnv *env, jclass clazz) {
    (*env)->SetStaticIntField(env, clazz, (*env)->GetStaticFieldID(env, clazz, "number", "I"), 8);
}

JNIEXPORT jstring JNICALL
Java_com_ty_android_staticlibrarydemo_SharedLib_getLocalData(JNIEnv *env, jobject thiz, jstring updates) {
    char data[50] = {0};
    char* updatesdata = (char *) (*env)->GetStringUTFChars(env, updates, 0);
    (*env)->SetIntField(env, thiz, (*env)->GetFieldID(env, (*env)->GetObjectClass(env, thiz), "localnumber", "I"), 6);

    strcpy(data, "Greeting from local apple");
    if (updatesdata != NULL)
    {
        strcpy((data + strlen(data)), ", ");
        strcpy((data + strlen(data)), updatesdata);
    }
    (*env)->ReleaseStringUTFChars(env, updates, updatesdata);
    return (*env)->NewStringUTF(env, data);
}