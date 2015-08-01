package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import de.agilecoders.wicket.core.markup.html.bootstrap.image.IconType;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarDropDownButton;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * Created by chris on 27.07.15.
 * <p>
 * NavbarBadgeDropDownButton
 */
public abstract class NavbarBadgeDropDownButton extends NavbarDropDownButton {
  private Component badgeLabel;

  public NavbarBadgeDropDownButton(IModel<String> model) {
    super(model);
    this.setRenderBodyOnly(false);
  }

  public NavbarBadgeDropDownButton(IModel<String> model, IModel<IconType> iconTypeModel) {
    super(model, iconTypeModel);
  }

  public Component getBadgeLabel() {
    return this.badgeLabel;
  }

  @Override
  protected Component newButtonLabel(String markupId, IModel<?> labelModel) {
    Component label = super.newButtonLabel(markupId, labelModel);
    label.setRenderBodyOnly(false);
    label.add(new CssClassNameAppender("badge"));
    this.badgeLabel = label;
    return label;
  }
}
