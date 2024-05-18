package com.giraffe.countriesapp.di

import com.apollographql.apollo3.ApolloClient
import com.giraffe.countriesapp.data.datasource.remote.RemoteDataSource
import com.giraffe.countriesapp.data.datasource.remote.RemoteDataSourceImp
import com.giraffe.countriesapp.data.repository.RepositoryImp
import com.giraffe.countriesapp.domain.repository.Repository
import com.giraffe.countriesapp.domain.usecases.GetCountriesUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }


    @Provides
    @Singleton
    fun provideRemoteDataSource(
        apolloClient: ApolloClient
    ): RemoteDataSource {
        return RemoteDataSourceImp(apolloClient)
    }

    @Provides
    @Singleton
    fun provideRepository(remoteDataSource: RemoteDataSource): Repository {
        return RepositoryImp(remoteDataSource)
    }
}


