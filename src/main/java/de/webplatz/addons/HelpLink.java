/**
 * MIT License.
 */
package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameRemover;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.BootstrapAjaxLink;
import de.agilecoders.wicket.core.markup.html.bootstrap.button.Buttons;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.PopoverBehavior;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.PopoverConfig;
import de.agilecoders.wicket.core.markup.html.bootstrap.components.TooltipConfig;
import java.util.ResourceBundle;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.time.Duration;

/**
 * HelpLink.
 * Adds a questionmark with a onhover div which contains
 * the text.
 *
 * @author Christian Senkowski (cs@e-cs.co)
 * @version $Id$
 * @since 31.07.15
 */
@SuppressWarnings("unused")
public class HelpLink extends BootstrapAjaxLink<String> {

    /**
     * Popover duration in milliseconds.
     */
    public static final long POPOVER_DURATION = 50L;
    /**
     * Serial version UID.
     */
    private static final long serialVersionUID = -4587985046907677156L;
    /**
     * Popover Config.
     */
    private final transient PopoverConfig popconfig;
    /**
     * Resource base name.
     */
    private final transient String resource;
    /**
     * Message source.
     */
    private final transient ResourceBundle messagesource;

    /**
     * Help Link.
     *
     * @param markupid Wicket id.
     * @param resource Resource base name.
     * @param messagesource Message source.
     */
    public HelpLink(final String markupid, final String resource,
        final ResourceBundle messagesource) {
        super(markupid, new Model<>(""), Buttons.Type.Link);
        this.popconfig = new PopoverConfig();
        this.resource = resource;
        this.messagesource = messagesource;
    }

    /**
     * Overriden OnBeforeRender.
     */
    @Override
    public final void onBeforeRender() {
        super.onBeforeRender();
        this.popconfig.withHoverTrigger();
        this.popconfig.withHtml(true);
        add(
            new CssClassNameRemover(
                "btn",
                "btn-link"
            )
        );
        add(
            new PopoverBehavior(
                new Model<>(
                    this.messagesource.getString(
                        String.format("%s.label", this.resource)
                    )
                ),
                new Model<>(
                    this.messagesource.getString(
                        String.format("%s.text", this.resource)
                    )
                ), this.popconfig
            )
        );
        add(new CssClassNameAppender("fa"));
        add(new CssClassNameAppender("fa-question-circle"));
    }

    /**
     * Add animation.
     *
     * @return HelpLink
     */
    public final HelpLink withAnimation() {
        this.popconfig.withAnimation(true);
        this.popconfig.withDelay(Duration.milliseconds(POPOVER_DURATION));
        return this;
    }

    /**
     * Add top location attribute.
     *
     * @return HelpLink.
     */
    public final HelpLink withTopLocation() {
        this.popconfig.withPlacement(TooltipConfig.Placement.top);
        return this;
    }

    /**
     * Add bottom location attribute.
     *
     * @return HelpLink.
     */
    public final HelpLink withBottomLocation() {
        this.popconfig.withPlacement(TooltipConfig.Placement.bottom);
        return this;
    }

    /**
     * Add left location attribute.
     *
     * @return HelpLink.
     */
    public final HelpLink withLeftLocation() {
        this.popconfig.withPlacement(TooltipConfig.Placement.left);
        return this;
    }

    /**
     * Add right location attribute.
     *
     * @return HelpLink.
     */
    public final HelpLink withRightLocation() {
        this.popconfig.withPlacement(TooltipConfig.Placement.right);
        return this;
    }

    /**
     * Overriden onClick.
     * Nothing to do here.
     *
     * @param target Ajax request target.
     */
    @Override
    public final void onClick(final AjaxRequestTarget target) {
        // nothing to do
    }

}
