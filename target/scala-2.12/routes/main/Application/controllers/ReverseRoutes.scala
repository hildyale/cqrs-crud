// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Tue Jan 08 09:39:20 COT 2019

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package application.controllers {

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

  // @LINE:7
  class ReverseVehiculosViewController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:7
    def getVehiculos(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "vehiculos")
    }
  
  }

  // @LINE:8
  class ReverseVehiculosController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def deleteVehiculo(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "vehiculos")
    }
  
    // @LINE:9
    def updateVehiculo(): Call = {
      
      Call("PUT", _prefix + { _defaultPrefix } + "vehiculos")
    }
  
    // @LINE:8
    def addVehiculo(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "vehiculos")
    }
  
  }


}
