// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Fri Jan 11 13:45:45 COT 2019

package application.controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final application.controllers.ReverseVehiculosQueryController VehiculosQueryController = new application.controllers.ReverseVehiculosQueryController(RoutesPrefix.byNamePrefix());
  public static final application.controllers.ReverseHomeController HomeController = new application.controllers.ReverseHomeController(RoutesPrefix.byNamePrefix());
  public static final application.controllers.ReverseVehiculosCommandController VehiculosCommandController = new application.controllers.ReverseVehiculosCommandController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final application.controllers.javascript.ReverseVehiculosQueryController VehiculosQueryController = new application.controllers.javascript.ReverseVehiculosQueryController(RoutesPrefix.byNamePrefix());
    public static final application.controllers.javascript.ReverseHomeController HomeController = new application.controllers.javascript.ReverseHomeController(RoutesPrefix.byNamePrefix());
    public static final application.controllers.javascript.ReverseVehiculosCommandController VehiculosCommandController = new application.controllers.javascript.ReverseVehiculosCommandController(RoutesPrefix.byNamePrefix());
  }

}
