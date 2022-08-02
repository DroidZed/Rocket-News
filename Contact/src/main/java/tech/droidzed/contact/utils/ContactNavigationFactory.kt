package tech.droidzed.contact.utils

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import net.lachlanmckee.hilt.compose.navigation.factory.ComposeNavigationFactory
import net.lachlanmckee.hilt.compose.navigation.factory.HiltComposeNavigationFactory
import tech.droidzed.contact.screens.ContactScreen
import tech.droidzed.sharedlib.Routes
import javax.inject.Inject
import javax.inject.Singleton

@HiltComposeNavigationFactory
internal class ContactNavigationFactory @Inject constructor() : ComposeNavigationFactory {
	override fun create(builder: NavGraphBuilder, navController: NavHostController) {
		builder.composable(
			route = Routes.Login.route,
			content = {
				ContactScreen(
					navController = navController
				)
			}
		)
	}
}

@Module
@InstallIn(SingletonComponent::class)
internal interface ComposeNavigationFactoryModule {
	@Singleton
	@Binds
	@IntoSet
	fun bindComposeNavigationFactory(factory: ContactNavigationFactory): ComposeNavigationFactory
}
