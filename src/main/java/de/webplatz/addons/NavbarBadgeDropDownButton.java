package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarDropDownButton;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * Created by chris on 27.07.15.
 * <p>
 * NavbarBadgeDropDownButton
 */
public abstract class NavbarBadgeDropDownButton extends NavbarDropDownButton {
  private Component basketBadge;

  public NavbarBadgeDropDownButton(IModel<String> model) {
    super(model);
    this.setRenderBodyOnly(false);
  }

  public Component getBasketBadge() {
    return this.basketBadge;
  }

  @Override
  protected Component newButtonLabel(String markupId, IModel<?> labelModel) {
    Component label = super.newButtonLabel(markupId, labelModel);
    label.setRenderBodyOnly(false);
    label.add(new CssClassNameAppender("badge"));
    this.basketBadge = label;
    return label;
  }
}
