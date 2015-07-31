package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameRemover;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.PopoverBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.PopoverConfig;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipConfig;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.Model;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.apache.wicket.util.time.Duration;
import org.springframework.context.MessageSource;

import java.util.Locale;

/**
 * Created by chris on 29.07.15.
 * <p>
 * Help Link -> (?)
 */
public class HelpLink extends BootstrapAjaxLink<String> {

  private final PopoverConfig popoverConfig;
  private final String resourceBaseName;
  @SpringBean
  transient MessageSource messageSource;

  public HelpLink(String id, String resourceBaseName) {
    super(id, new Model<>(""), Buttons.Type.Link);
    this.popoverConfig = new PopoverConfig();
    this.resourceBaseName = resourceBaseName;
  }

  @Override
  protected void onBeforeRender() {
    super.onBeforeRender();

    // initialize, not sure if it belongs here though ...
    this.popoverConfig.withHoverTrigger();
    this.popoverConfig.withHtml(true);
    add(new CssClassNameRemover("btn", "btn-link"));
    String labelText = this.messageSource.getMessage(this.resourceBaseName + ".label", new String[]{}, Locale.getDefault());
    String contentText = this.messageSource.getMessage(this.resourceBaseName + ".text", new String[]{}, Locale.getDefault());
    add(new PopoverBehavior(new Model<>(labelText), new Model<>(contentText), this.popoverConfig));
    add(new CssClassNameAppender("fa"));
    add(new CssClassNameAppender("fa-question-circle"));
  }

  public HelpLink withAnimation() {
    this.popoverConfig.withAnimation(true);
    this.popoverConfig.withDelay(Duration.milliseconds(50L));
    return this;
  }

  public HelpLink withTopLocation() {
    this.popoverConfig.withPlacement(TooltipConfig.Placement.top);
    return this;
  }

  public HelpLink withBottomLocation() {
    this.popoverConfig.withPlacement(TooltipConfig.Placement.bottom);
    return this;
  }

  public HelpLink withLeftLocation() {
    this.popoverConfig.withPlacement(TooltipConfig.Placement.left);
    return this;
  }

  public HelpLink withRightLocation() {
    this.popoverConfig.withPlacement(TooltipConfig.Placement.right);
    return this;
  }

  @Override
  public void onClick(AjaxRequestTarget ajaxRequestTarget) {
    // nothing to do
  }
}
