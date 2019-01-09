// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Wed Jan 09 10:38:14 COT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package application.controllers {

  // @LINE:7
  class ReverseVehiculosQueryController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getVehiculos(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "vehiculos")
    }
  
    // @LINE:8
    def getVehiculo(placa:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "vehiculos/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("placa", placa)))
    }
  
  }

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:9
  class ReverseVehiculosCommandController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def updateVehiculo(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "vehiculos")
    }
  
    // @LINE:11
    def deleteVehiculo(placa:String): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "vehiculos/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("placa", placa)))
    }
  
    // @LINE:9
    def addVehiculo(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vehiculos")
    }
  
  }


}
