package api

import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter

class AppRouter @Inject()(apiRouter: ApiRouter, sampleRouter: SampleRouter, sessionRouter: SessionRouter) extends SimpleRouter {
  override def routes: Routes = apiRouter.routes.orElse(sampleRouter.routes).orElse(sessionRouter.routes)
}
