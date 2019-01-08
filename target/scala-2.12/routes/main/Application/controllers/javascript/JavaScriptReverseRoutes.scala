// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Tue Jan 08 09:39:20 COT 2019

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package application.controllers.javascript {

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

  // @LINE:7
  class ReverseVehiculosViewController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getVehiculos: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosViewController.getVehiculos",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReverseVehiculosController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def deleteVehiculo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosController.deleteVehiculo",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos"})
        }
      """
    )
  
    // @LINE:9
    def updateVehiculo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosController.updateVehiculo",
      """
        function() {
          return _wA({method:"PUT", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos"})
        }
      """
    )
  
    // @LINE:8
    def addVehiculo: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "application.controllers.VehiculosController.addVehiculo",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "vehiculos"})
        }
      """
    )
  
  }


}
