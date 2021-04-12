cmake_minimum_required(VERSION 3.4.1)

#set(jnilibs "${CMAKE_SOURCE_DIR}../../../libs")
#set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${jnilibs}/${ANDROID_ABI})

#add_library(sdkcore SHARED IMPORTED )
#set_target_properties(sdkcore PROPERTIES
#        IMPORTED_LOCATION "${jnilibs}/${ANDROID_ABI}/libsdk.so")
#

add_library(abytes SHARED bytes_jni.cpp)
find_library(log-lib log )

target_link_libraries(abytes  ${log-lib})