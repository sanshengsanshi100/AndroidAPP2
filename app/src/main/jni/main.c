/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_example_xiaoming_so_MyJni */

#ifndef _Included_com_example_xiaoming_so_MyJni
#define _Included_com_example_xiaoming_so_MyJni
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_example_xiaoming_so_MyJni
 * Method:    sayHello
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_example_xiaoming_so_MyJni_sayHello(JNIEnv *env, jclass obj){
    //返回一句话
    return (*env)->NewStringUTF(env,"hello world");
};

#ifdef __cplusplus
}
#endif
#endif