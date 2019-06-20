package controllers

import akka.util.ByteString
import javax.inject.{Inject, Singleton}
import play.api.Logging
import play.api.http.HttpEntity
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class SampleController @Inject()(cc: ControllerComponents)
                                (implicit ec: ExecutionContext) extends AbstractController(cc) with Logging {

  implicit val myCustomCharset = Codec.javaSupported("euc-kr")

  def anotherMethod(params: String)(implicit request: Request[_]) = {
    logger.info(s"Using the anotherMethod with implicit ==> $request, params = $params")
  }

  def echo = Action { implicit request =>
    anotherMethod("Some Param value")
    Ok("성주현 [" + request + "]")
      .withCookies(Cookie("theme", "blue"))
      .bakeCookies()
  }

  def hello(name: String) = Action {
    Ok("Hello, " + name)
  }

  def user = Action(parse.json) { implicit request =>
    Ok("Got request[" + request + "]")
      .discardingCookies(DiscardingCookie("theme"))
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
