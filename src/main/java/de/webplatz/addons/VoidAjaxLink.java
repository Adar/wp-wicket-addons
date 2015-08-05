package de.webplatz.addons;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;

/**
 * Created by chris on 03.08.15.
 *
 * VoidAjaxLink
 */
public class VoidAjaxLink<T> extends AjaxLink<T> {

  public VoidAjaxLink(String id) {
    super(id);
  }

  public VoidAjaxLink(String id, IModel<T> model) {
    super(id, model);
  }

  @Override
  public void onClick(AjaxRequestTarget ajaxRequestTarget) {
    // nothing to do
  }
}
