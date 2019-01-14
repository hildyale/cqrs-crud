// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Fri Jan 11 13:45:45 COT 2019

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: application.controllers.HomeController,
  // @LINE:7
  VehiculosQueryController_1: application.controllers.VehiculosQueryController,
  // @LINE:10
  VehiculosCommandController_3: application.controllers.VehiculosCommandController,
  // @LINE:15
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: application.controllers.HomeController,
    // @LINE:7
    VehiculosQueryController_1: application.controllers.VehiculosQueryController,
    // @LINE:10
    VehiculosCommandController_3: application.controllers.VehiculosCommandController,
    // @LINE:15
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_0, VehiculosQueryController_1, VehiculosCommandController_3, Assets_2, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, VehiculosQueryController_1, VehiculosCommandController_3, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """application.controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos""", """application.controllers.VehiculosQueryController.getVehiculos"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos/""" + "$" + """placa<[^/]+>""", """application.controllers.VehiculosQueryController.getVehiculo(placa:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """eventos""", """application.controllers.VehiculosQueryController.eventos"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos""", """application.controllers.VehiculosCommandController.addVehiculo"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos""", """application.controllers.VehiculosCommandController.updateVehiculo"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos/""" + "$" + """placa<[^/]+>""", """application.controllers.VehiculosCommandController.deleteVehiculo(placa:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(path:String = "/public", file:Asset)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val application_controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val application_controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val application_controllers_VehiculosQueryController_getVehiculos1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos")))
  )
  private[this] lazy val application_controllers_VehiculosQueryController_getVehiculos1_invoker = createInvoker(
    VehiculosQueryController_1.getVehiculos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosQueryController",
      "getVehiculos",
      Nil,
      "GET",
      this.prefix + """vehiculos""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val application_controllers_VehiculosQueryController_getVehiculo2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos/"), DynamicPart("placa", """[^/]+""",true)))
  )
  private[this] lazy val application_controllers_VehiculosQueryController_getVehiculo2_invoker = createInvoker(
    VehiculosQueryController_1.getVehiculo(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosQueryController",
      "getVehiculo",
      Seq(classOf[String]),
      "GET",
      this.prefix + """vehiculos/""" + "$" + """placa<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val application_controllers_VehiculosQueryController_eventos3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("eventos")))
  )
  private[this] lazy val application_controllers_VehiculosQueryController_eventos3_invoker = createInvoker(
    VehiculosQueryController_1.eventos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosQueryController",
      "eventos",
      Nil,
      "GET",
      this.prefix + """eventos""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val application_controllers_VehiculosCommandController_addVehiculo4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos")))
  )
  private[this] lazy val application_controllers_VehiculosCommandController_addVehiculo4_invoker = createInvoker(
    VehiculosCommandController_3.addVehiculo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosCommandController",
      "addVehiculo",
      Nil,
      "POST",
      this.prefix + """vehiculos""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val application_controllers_VehiculosCommandController_updateVehiculo5_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos")))
  )
  private[this] lazy val application_controllers_VehiculosCommandController_updateVehiculo5_invoker = createInvoker(
    VehiculosCommandController_3.updateVehiculo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosCommandController",
      "updateVehiculo",
      Nil,
      "PUT",
      this.prefix + """vehiculos""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val application_controllers_VehiculosCommandController_deleteVehiculo6_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos/"), DynamicPart("placa", """[^/]+""",true)))
  )
  private[this] lazy val application_controllers_VehiculosCommandController_deleteVehiculo6_invoker = createInvoker(
    VehiculosCommandController_3.deleteVehiculo(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosCommandController",
      "deleteVehiculo",
      Seq(classOf[String]),
      "DELETE",
      this.prefix + """vehiculos/""" + "$" + """placa<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_Assets_versioned7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned7_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String], fakeValue[Asset]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String], classOf[Asset]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case application_controllers_HomeController_index0_route(params@_) =>
      call { 
        application_controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:7
    case application_controllers_VehiculosQueryController_getVehiculos1_route(params@_) =>
      call { 
        application_controllers_VehiculosQueryController_getVehiculos1_invoker.call(VehiculosQueryController_1.getVehiculos)
      }
  
    // @LINE:8
    case application_controllers_VehiculosQueryController_getVehiculo2_route(params@_) =>
      call(params.fromPath[String]("placa", None)) { (placa) =>
        application_controllers_VehiculosQueryController_getVehiculo2_invoker.call(VehiculosQueryController_1.getVehiculo(placa))
      }
  
    // @LINE:9
    case application_controllers_VehiculosQueryController_eventos3_route(params@_) =>
      call { 
        application_controllers_VehiculosQueryController_eventos3_invoker.call(VehiculosQueryController_1.eventos)
      }
  
    // @LINE:10
    case application_controllers_VehiculosCommandController_addVehiculo4_route(params@_) =>
      call { 
        application_controllers_VehiculosCommandController_addVehiculo4_invoker.call(VehiculosCommandController_3.addVehiculo)
      }
  
    // @LINE:11
    case application_controllers_VehiculosCommandController_updateVehiculo5_route(params@_) =>
      call { 
        application_controllers_VehiculosCommandController_updateVehiculo5_invoker.call(VehiculosCommandController_3.updateVehiculo)
      }
  
    // @LINE:12
    case application_controllers_VehiculosCommandController_deleteVehiculo6_route(params@_) =>
      call(params.fromPath[String]("placa", None)) { (placa) =>
        application_controllers_VehiculosCommandController_deleteVehiculo6_invoker.call(VehiculosCommandController_3.deleteVehiculo(placa))
      }
  
    // @LINE:15
    case controllers_Assets_versioned7_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned7_invoker.call(Assets_2.versioned(path, file))
      }
  }
}
