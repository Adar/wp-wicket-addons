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
     * Text.
     */
    private String text;
    /**
     * Label.
     */
    private String label;
    /**
     * Popover Config.
     */
    private PopoverConfig popconfig;

    /**
     * Help Link.
     *
     * @param markupid Wicket id.
     * @param label Link label.
     * @param text DIV text.
     */
    public HelpLink(final String markupid, final String label,
        final String text) {
        super(markupid, new Model<>(""), Buttons.Type.Link);
        this.popconfig = new PopoverConfig();
        this.label = label;
        this.text = text;
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
                new Model<>(this.label),
                new Model<>(this.text),
                this.popconfig
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

    /**
     * Get popconfig.
     *
     * @return Popover Config.
     */
    public final PopoverConfig getPopconfig() {
        return this.popconfig;
    }

    /**
     * Set popconfig.
     *
     * @param config Popover config.
     */
    public final void setPopconfig(final PopoverConfig config) {
        this.popconfig = config;
    }

    /**
     * Get text.
     *
     * @return Text.
     */
    public final String getText() {
        return this.text;
    }

    /**
     * Set text.
     *
     * @param value Description.
     */
    public final void setText(final String value) {
        this.text = value;
    }

    /**
     * Get label.
     *
     * @return Label.
     */
    public final String getLabel() {
        return this.label;
    }

    /**
     * Set label.
     *
     * @param value Label.
     */
    public final void setLabel(final String value) {
        this.label = value;
    }
}
