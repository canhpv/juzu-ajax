package org.sample;

import juzu.Action;
import juzu.Path;
import juzu.Resource;
import juzu.Response;
import juzu.View;
import juzu.io.Stream;
import juzu.plugin.ajax.Ajax;
import juzu.template.Template;

import javax.inject.Inject;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Controller {

  @Inject
  @Path("index.gtmpl")
  org.sample.templates.index index;

  @View
  public void index() throws IOException {
    index("", "");
  }

  @View
  public void index(String location, String mapURL) throws IOException {
  index.with().location(location).mapURL(mapURL).render();
  }

  @Action
  public Response updateLocation(String location) throws IOException {
    String mapURL = "https://maps.google.fr/maps?f=q&source=s_q&hl=en&geocode=&q=" + location + "&aq=&t=m&ie=UTF8&hq=&hnear=" + location + "&z=12&output=embed";

  return Controller_.index(location, mapURL);
  }
  
  @Ajax
  @Resource
  public Response.Content<Stream.Char> getMapURL(String location) throws IOException {
    String mapURL = "https://maps.google.fr/maps?f=q&source=s_q&hl=en&geocode=&q=" + location + "&aq=&t=m&ie=UTF8&hq=&hnear=" + location + "&z=12&output=embed";

  return Response.ok("{\"mapURL\": \"" + mapURL +"\"}").withMimeType("application/json");
  }
  
}

