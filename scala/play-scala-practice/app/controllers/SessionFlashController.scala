package controllers

import javax.inject.{Inject, Singleton}
import play.api.mvc.{AbstractController, ControllerComponents}

@Singleton
class SessionFlashController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  def create = Action { implicit request =>
    Ok {
      request.flash.get("success").getOrElse("Welcome!")
    }
  }

  def save = Action {
    Redirect("/sessions/home").flashing("success" -> "The item has been created!!!")
  }

  def home = Action { implicit request =>
    Ok(views.html.home())
  }
}
