cmake_minimum_required(VERSION 3.4.1)

add_library(staticlib
            STATIC
            src/main/jni/staticlib.cpp)

#[[add_library(staticlib
            STATIC
            IMPORTED)
set_target_properties(staticlib
                      PROPERTIES
                      IMPORTED_LOCATION
                      ${CMAKE_SOURCE_DIR}/libs/libstaticlib.a)]]

add_library(sharedlib
            SHARED
            src/main/jni/sharedlib.c)

target_link_libraries(sharedlib
                      staticlib
                      log)

