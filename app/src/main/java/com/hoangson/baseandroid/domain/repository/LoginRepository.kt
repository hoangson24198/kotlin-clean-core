package com.hoangson.baseandroid.domain.repository

import com.hoangson.baseandroid.core.models.Output
import com.hoangson.baseandroid.domain.model.LoginEntity

interface LoginRepository {

     fun login(username: String, password: String) : Output<LoginEntity>
}