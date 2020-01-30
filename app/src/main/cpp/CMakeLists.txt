# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.4.1)

#将var赋值hello
set(var hello)
# 打印
message(${var})

#CMAKE自带的常量，CMAKE自己所在路径的常量
message(${CMAKE_CURRENT_LIST_DIR})
#CMAKE自带的常量，CMAKE自己所在文件夹的路径的常量
message(${CMAKE_CURRENT_LIST_FILE})

# 将native-lib.cpp库命名为native-lib添加为so库
add_library(
        native-lib
        SHARED
        native-lib.cpp)

add_library(
        people-lib
        SHARED
        people/people.cpp)

# 将/people加入到搜索路径
include_directories(/people)

# 需要加载的androidNDK中的库，将log库命名为log-lib
find_library(
        log-lib
        log)

# 将android的log-lib库与生成的native-lib库进行链接
target_link_libraries(
        native-lib
        ${log-lib})