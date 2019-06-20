package api

import controllers.SessionFlashController
import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter

class SessionRouter @Inject()(controller: SessionFlashController) extends SimpleRouter {

  import play.api.routing.sird._

  override def routes: Routes = {
    case GET(p"/create") => controller.create
    case GET(p"/save") => controller.save
    case GET(p"/home") => controller.home
  }
}
