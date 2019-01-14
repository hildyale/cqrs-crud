// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Ceiba/Downloads/prueba/conf/routes
// @DATE:Fri Jan 11 13:45:45 COT 2019

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
  }

}
