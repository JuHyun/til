package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents, Handler}

@Singleton
class HttpRoutingController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def show(id: Long) = Action {
    Ok("id = " + id)
  }

}
