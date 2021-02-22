package com.hoangson.baseandroid.data.repository

import com.hoangson.baseandroid.core.bases.BaseRepository
import com.hoangson.baseandroid.core.models.Output
import com.hoangson.baseandroid.data.remote.LoginResponse
import com.hoangson.baseandroid.data.remote.RemoteDataSource
import com.hoangson.baseandroid.data.wrapper.toLoginResponse
import com.hoangson.baseandroid.domain.model.LoginEntity
import com.hoangson.baseandroid.domain.repository.LoginRepository

class LoginRepositoryImpl : BaseRepository(), LoginRepository {

    override  fun login(username: String, password: String): Output<LoginEntity> {

        return safeApiCall(remoteDataSource.makeRemoteCall(RemoteDataSource::class.java)
            .login(username, password), transform = { it.toLoginResponse() }, default = LoginResponse(), error = "")

    }


}

