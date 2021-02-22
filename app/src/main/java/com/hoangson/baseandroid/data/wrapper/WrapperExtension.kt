package com.hoangson.baseandroid.data.wrapper

import com.hoangson.baseandroid.data.remote.LoginResponse
import com.hoangson.baseandroid.domain.model.LoginEntity


fun LoginResponse.toLoginResponse() = LoginEntity(isLoggedIn = loginSuccess, message = rMessage )


