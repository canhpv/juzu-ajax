@juzu.plugin.asset.Assets(
                          scripts = {
                            @juzu.plugin.asset.Script(
                              id = "jquery",  
                              src = "public/scripts/jquery-1.7.1.min.js")
                          }, stylesheets = @Stylesheet(src = "css/bootstrap.css", location = juzu.asset.AssetLocation.CLASSPATH)
                        )

@juzu.Application package org.sample;
import juzu.plugin.asset.Stylesheet;


