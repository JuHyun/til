package api

import controllers.HttpRoutingController
import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter

class ApiRouter @Inject()(controller: HttpRoutingController) extends SimpleRouter {

  import play.api.routing.sird._

  override def routes: Routes = {
    case GET(p"/${long(id)}") => controller.show(id: Long)
  }
}
