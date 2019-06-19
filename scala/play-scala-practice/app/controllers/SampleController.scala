package controllers

import akka.util.ByteString
import javax.inject.{Inject, Singleton}
import play.api.Logger
import play.api.http.HttpEntity
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class SampleController @Inject()(cc: ControllerComponents)
                                (implicit ec: ExecutionContext) extends AbstractController(cc) {

  def anotherMethod(params: String)(implicit request: Request[_]) = {
    Logger.info(s"Using the anotherMethod with implicit ==> $request, params = $params")
  }

  def echo = Action { implicit request =>
    anotherMethod("Some Param value")
    Ok("Got request [" + request + "]")
  }

  def hello(name: String) = Action {
    Ok("Hello, " + name)
  }

  def user = Action(parse.json) { implicit request =>
    Ok("Got request[" + request + "]")
  }

  def index = Action { implicit request =>
    Result(
      header = ResponseHeader(200, Map.empty),
      body = HttpEntity.Strict(ByteString("Helllow world"), Some("application/json"))
    )
  }

  def result = Action { implicit request =>
    InternalServerError("Oops!")
  }

  def redirect = Action { implicit request =>
    Redirect("/count", PERMANENT_REDIRECT)
  }

  def todo(name: String) = TODO
}
