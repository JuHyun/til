package controllers

import javax.inject.{Inject, Singleton}
import play.api.libs.json.JsValue
import play.api.mvc.{AbstractController, ControllerComponents, Request}

@Singleton
class BodyParsersController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

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

  def save = Action(parse.json) { request: Request[JsValue] =>
    //    Ok("Got: " + (request.body \ "name").as[String])
    Ok(request.body)
  }
}
