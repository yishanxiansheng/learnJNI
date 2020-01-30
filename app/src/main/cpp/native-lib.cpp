#include <jni.h>
#include <string>

//""直接写路径
//<>代表从搜索路径开始搜索
//如果这里想用<>，这需要将people.h的路径people/加入到搜索路径
#include "people/people.h"

extern "C" JNIEXPORT jstring JNICALL
Java_com_noodle_learnjni_MainActivity_stringFromJNI(JNIEnv *env, jobject /* this */) {
    std::string hello = "Hello from C++";
    people people;
    return env->NewStringUTF(people.getString().c_str());
}
