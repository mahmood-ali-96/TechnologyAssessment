package com.example.technologyassessment.di.module;

import com.example.technologyassessment.data.network.requset.ApiInterfac;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * The type Api module.
 */
@Module(includes = {NetworkModule.class})
public class ApiModule {

    /**
     * Provide api service api service.
     *
     * @param retrofit the retrofit
     * @return the api service
     */
    @Provides
    @Singleton
    ApiInterfac providerApiInterfac(Retrofit retrofit) {
        return retrofit.create(ApiInterfac.class);
    }
}
