package com.hoangson.baseandroid.domain.usecase

import com.hoangson.baseandroid.core.bases.BaseUseCase
import com.hoangson.baseandroid.core.models.Output
import com.hoangson.baseandroid.domain.model.LoginEntity
import com.hoangson.baseandroid.domain.repository.LoginRepository

class LoginUseCase(var loginRepository: LoginRepository) : BaseUseCase<LoginEntity, LoginUseCase.Params>() {

    override suspend fun run(params: Params): Output<LoginEntity> {

        return loginRepository.login(params.username, params.password)
    }

    data class Params(val username: String, val password: String)

}