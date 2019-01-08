// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Tue Jan 08 09:39:20 COT 2019

package application.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final application.controllers.ReverseHomeController HomeController = new application.controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final application.controllers.ReverseVehiculosViewController VehiculosViewController = new application.controllers.ReverseVehiculosViewController(RoutesPrefix.byNamePrefix());
  public static final application.controllers.ReverseVehiculosController VehiculosController = new application.controllers.ReverseVehiculosController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final application.controllers.javascript.ReverseHomeController HomeController = new application.controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final application.controllers.javascript.ReverseVehiculosViewController VehiculosViewController = new application.controllers.javascript.ReverseVehiculosViewController(RoutesPrefix.byNamePrefix());
    public static final application.controllers.javascript.ReverseVehiculosController VehiculosController = new application.controllers.javascript.ReverseVehiculosController(RoutesPrefix.byNamePrefix());
  }

}
