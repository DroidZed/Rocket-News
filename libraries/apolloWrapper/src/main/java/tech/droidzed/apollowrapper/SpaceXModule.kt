package tech.droidzed.apollowrapper

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import tech.droidzed.apollowrapper.repositories.companyinfo.CompanyInfoRepository
import tech.droidzed.apollowrapper.repositories.companyinfo.CompanyInfoRepositoryImpl
import tech.droidzed.apollowrapper.repositories.dragons.DragonsRepository
import tech.droidzed.apollowrapper.repositories.dragons.DragonsRepositoryImpl
import tech.droidzed.apollowrapper.repositories.launches.LaunchesRepository
import tech.droidzed.apollowrapper.repositories.launches.LaunchesRepositoryImpl
import tech.droidzed.apollowrapper.repositories.missions.MissionsRepository
import tech.droidzed.apollowrapper.repositories.missions.MissionsRepositoryImpl
import tech.droidzed.apollowrapper.repositories.rockets.RocketsRepository
import tech.droidzed.apollowrapper.repositories.rockets.RocketsRepositoryImpl

@Module
@InstallIn(SingletonComponent::class)
abstract class SpaceXModule {

	// rockets
	@Binds
	abstract fun provideRocketsRepository(impl: RocketsRepositoryImpl): RocketsRepository

	// launches
	@Binds
	abstract fun provideLaunchesRepository(impl: LaunchesRepositoryImpl): LaunchesRepository

	// spaceX info
	@Binds
	abstract fun provideCompanyInfoRepository(impl: CompanyInfoRepositoryImpl): CompanyInfoRepository

	// Dragons
	@Binds
	abstract fun provideDragonsRepository(impl: DragonsRepositoryImpl): DragonsRepository

	// Missions
	@Binds
	abstract fun provideMissionsRepository(impl: MissionsRepositoryImpl): MissionsRepository

}
