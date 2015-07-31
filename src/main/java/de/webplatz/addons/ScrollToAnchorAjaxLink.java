package de.webplatz.addons;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;

/**
 * Created by chris on 31.07.15.
 *
 * ScrollToAnchorAjaxLink
 */
public class ScrollToAnchorAjaxLink<T> extends AjaxLink<T> {

  private final String anchorName;

  public ScrollToAnchorAjaxLink(String id, String anchorName) {
    super(id);
    this.anchorName = anchorName;
  }

  public ScrollToAnchorAjaxLink(String id, IModel<T> model, String anchorName) {
    super(id, model);
    this.anchorName = anchorName;
  }

  @Override
  public void onClick(AjaxRequestTarget ajaxRequestTarget) {
    ajaxRequestTarget.prependJavaScript("$('html,body').animate({scrollTop: $(\"a[name='" + anchorName + "']\").offset().top - 50}, 'slow');");
  }
}
