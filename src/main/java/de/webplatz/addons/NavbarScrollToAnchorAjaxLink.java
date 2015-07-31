package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarAjaxLink;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * Created by chris on 31.07.15.
 *
 * Scroll to an anchor
 */
public class NavbarScrollToAnchorAjaxLink<T> extends NavbarAjaxLink<T> {

  private final String anchorName;

  public NavbarScrollToAnchorAjaxLink(String anchorName) {
    super();
    this.anchorName = anchorName;
  }

  public NavbarScrollToAnchorAjaxLink(IModel<String> model, String anchorName) {
    super(model);
    this.anchorName = anchorName;
  }

  public NavbarScrollToAnchorAjaxLink(String markupId, IModel<String> label, String anchorName) {
    super(markupId, label);
    this.anchorName = anchorName;
  }

  @Override
  public void onClick(AjaxRequestTarget ajaxRequestTarget) {
    ajaxRequestTarget.prependJavaScript("$('html,body').animate({scrollTop: $(\"a[name='\" + " + anchorName + " + \"']\").offset().top - 50}, 'slow');");
  }
}
