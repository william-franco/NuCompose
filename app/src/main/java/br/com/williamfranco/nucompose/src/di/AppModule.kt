package br.com.williamfranco.nucompose.src.di

import br.com.williamfranco.nucompose.src.features.home.repositories.HomeRepository
import br.com.williamfranco.nucompose.src.features.home.repositories.HomeRepositoryImpl
import br.com.williamfranco.nucompose.src.features.home.view_models.HomeViewModel
import br.com.williamfranco.nucompose.src.features.home.view_models.HomeViewModelImpl
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {
    single<HomeRepository> { HomeRepositoryImpl() }
    viewModelOf(::HomeViewModelImpl) { bind<HomeViewModel>() }
}
