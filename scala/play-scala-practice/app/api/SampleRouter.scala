package api

import controllers.SampleController
import javax.inject.Inject
import play.api.routing.Router.Routes
import play.api.routing.SimpleRouter

class SampleRouter @Inject()(controller: SampleController) extends SimpleRouter {

  import play.api.routing.sird._

  override def routes: Routes = {
    case GET(p"/echo") => controller.echo
    case GET(p"/hello" ? q"name=$name") => controller.hello(name: String)
    case GET(p"/user") => controller.user
    case GET(p"/index") => controller.index
    case GET(p"/result") => controller.result
    case GET(p"/redirect") => controller.redirect
    case GET(p"/todo" ? q"name=$name") => controller.todo(name: String)
  }
}
