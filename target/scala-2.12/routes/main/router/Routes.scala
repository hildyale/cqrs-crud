// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Tue Jan 08 09:39:20 COT 2019

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
  VehiculosViewController_2: application.controllers.VehiculosViewController,
  // @LINE:8
  VehiculosController_3: application.controllers.VehiculosController,
  // @LINE:13
  Assets_1: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: application.controllers.HomeController,
    // @LINE:7
    VehiculosViewController_2: application.controllers.VehiculosViewController,
    // @LINE:8
    VehiculosController_3: application.controllers.VehiculosController,
    // @LINE:13
    Assets_1: controllers.Assets
  ) = this(errorHandler, HomeController_0, VehiculosViewController_2, VehiculosController_3, Assets_1, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, VehiculosViewController_2, VehiculosController_3, Assets_1, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """application.controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos""", """application.controllers.VehiculosViewController.getVehiculos"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos""", """application.controllers.VehiculosController.addVehiculo"""),
    ("""PUT""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos""", """application.controllers.VehiculosController.updateVehiculo"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """vehiculos""", """application.controllers.VehiculosController.deleteVehiculo"""),
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
  private[this] lazy val application_controllers_VehiculosViewController_getVehiculos1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos")))
  )
  private[this] lazy val application_controllers_VehiculosViewController_getVehiculos1_invoker = createInvoker(
    VehiculosViewController_2.getVehiculos,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosViewController",
      "getVehiculos",
      Nil,
      "GET",
      this.prefix + """vehiculos""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val application_controllers_VehiculosController_addVehiculo2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos")))
  )
  private[this] lazy val application_controllers_VehiculosController_addVehiculo2_invoker = createInvoker(
    VehiculosController_3.addVehiculo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosController",
      "addVehiculo",
      Nil,
      "POST",
      this.prefix + """vehiculos""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val application_controllers_VehiculosController_updateVehiculo3_route = Route("PUT",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos")))
  )
  private[this] lazy val application_controllers_VehiculosController_updateVehiculo3_invoker = createInvoker(
    VehiculosController_3.updateVehiculo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosController",
      "updateVehiculo",
      Nil,
      "PUT",
      this.prefix + """vehiculos""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val application_controllers_VehiculosController_deleteVehiculo4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("vehiculos")))
  )
  private[this] lazy val application_controllers_VehiculosController_deleteVehiculo4_invoker = createInvoker(
    VehiculosController_3.deleteVehiculo,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "application.controllers.VehiculosController",
      "deleteVehiculo",
      Nil,
      "DELETE",
      this.prefix + """vehiculos""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_Assets_versioned5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned5_invoker = createInvoker(
    Assets_1.versioned(fakeValue[String], fakeValue[Asset]),
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
    case application_controllers_VehiculosViewController_getVehiculos1_route(params@_) =>
      call { 
        application_controllers_VehiculosViewController_getVehiculos1_invoker.call(VehiculosViewController_2.getVehiculos)
      }
  
    // @LINE:8
    case application_controllers_VehiculosController_addVehiculo2_route(params@_) =>
      call { 
        application_controllers_VehiculosController_addVehiculo2_invoker.call(VehiculosController_3.addVehiculo)
      }
  
    // @LINE:9
    case application_controllers_VehiculosController_updateVehiculo3_route(params@_) =>
      call { 
        application_controllers_VehiculosController_updateVehiculo3_invoker.call(VehiculosController_3.updateVehiculo)
      }
  
    // @LINE:10
    case application_controllers_VehiculosController_deleteVehiculo4_route(params@_) =>
      call { 
        application_controllers_VehiculosController_deleteVehiculo4_invoker.call(VehiculosController_3.deleteVehiculo)
      }
  
    // @LINE:13
    case controllers_Assets_versioned5_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[Asset]("file", None)) { (path, file) =>
        controllers_Assets_versioned5_invoker.call(Assets_1.versioned(path, file))
      }
  }
}
