// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Fri Jan 11 13:45:45 COT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package application.controllers.javascript {

  // @LINE:7
  class ReverseVehiculosQueryController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:9
    def eventos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosQueryController.eventos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "eventos"})
        }
      """
    )
  
    // @LINE:7
    def getVehiculos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosQueryController.getVehiculos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos"})
        }
      """
    )
  
    // @LINE:8
    def getVehiculo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosQueryController.getVehiculo",
      """
        function(placa0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("placa", placa0))})
        }
      """
    )
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseVehiculosCommandController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def updateVehiculo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosCommandController.updateVehiculo",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos"})
        }
      """
    )
  
    // @LINE:12
    def deleteVehiculo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosCommandController.deleteVehiculo",
      """
        function(placa0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("placa", placa0))})
        }
      """
    )
  
    // @LINE:10
    def addVehiculo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosCommandController.addVehiculo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos"})
        }
      """
    )
  
  }


}
