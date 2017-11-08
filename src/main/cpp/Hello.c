#include <stdio.h>
#include "jni_JNITest.h"

JNIEXPORT void JNICALL Java_jni_JNITest_Hello
  (JNIEnv *env, jclass cls)
{
    printf("hello jni,successful.");

}
