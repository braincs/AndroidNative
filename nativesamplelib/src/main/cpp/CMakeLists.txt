cmake_minimum_required(VERSION 3.4.1)

set(jnilibs "${CMAKE_SOURCE_DIR}../../../../libs")
set(CMAKE_LIBRARY_OUTPUT_DIRECTORY ${jnilibs}/${ANDROID_ABI})
add_library(sdk
        SHARED
        sdk.cpp)


find_library(
        log-lib
        log )

target_link_libraries(sdk  ${log-lib} )