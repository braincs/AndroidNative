//
// Created by Shuai on 2/24/21.
//

#include "sdk.h"

static const char* version = "1.0.1";
void sdk::get_version(const char **result) {
    *result = version;
}
