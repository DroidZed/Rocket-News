package tech.droidzed.sessionmanagement

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class DataStoreModule {

	@Binds
	abstract fun provideSessionInterface(sessionInterfaceImpl: SessionInterfaceImpl): SessionInterface
}
