package controllers

import javax.inject.{Inject, Singleton}
import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, ControllerComponents, Request}

@Singleton
class BodyParsersController @Inject()(loggingAction: LoggingAction,
                                      cc: ControllerComponents) extends AbstractController(cc) {

  //  def save = Action { request: Request[AnyContent] =>
  //    val body: AnyContent = request.body
  //    val jsonBody: Option[JsValue] = body.asJson
  //
  //    jsonBody
  //      .map { json =>
  //        Ok("Got: " + (json \ "name").as[String])
  //      }
  //      .getOrElse {
  //        BadRequest("Expecting application/json request body")
  //      }
  //  }

  def save = loggingAction(parse.json) { request: Request[JsValue] =>
    Ok("Got a body " + request.body.toString().length + " bytes long")
  }
}
