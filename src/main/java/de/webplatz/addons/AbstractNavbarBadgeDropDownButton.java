/**
 * MIT License.
 */
package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.behavior.CssClassNameAppender;
import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarDropDownButton;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;

/**
 * AbstractNavbarBadgeDropDownButton.
 *
 * @author Christian Senkowski (cs@e-cs.co)
 * @version $Id$
 * @since 31.07.15
 */
@SuppressWarnings("unused")
public abstract class AbstractNavbarBadgeDropDownButton
    extends NavbarDropDownButton {
    /**
     * Badge Label.
     */
    private transient Component badgelabel;

    /**
     * Construct.
     *
     * @param model Wicket model.
     */
    public AbstractNavbarBadgeDropDownButton(final IModel<String> model) {
        super(model);
    }

    /**
     * Get badge label.
     *
     * @return Wicket component.
     */
    public final Component getBadgelabel() {
        return this.badgelabel;
    }

    /**
     * Overriden newButtonLabel.
     *
     * @param markupid Markup id.
     * @param labelmodel Label model.
     * @return Wicket component.
     */
    @Override
    protected final Component newButtonLabel(final String markupid,
        final IModel<?> labelmodel) {
        this.setRenderBodyOnly(false);
        final Component label = super.newButtonLabel(markupid, labelmodel);
        label.setRenderBodyOnly(false);
        label.add(new CssClassNameAppender("badge"));
        this.badgelabel = label;
        return label;
    }

    /**
     * Write Object.
     *
     * @param stream Stream to write to.
     * @throws java.io.IOException if stream fails.
     */
    private void writeObject(final ObjectOutputStream stream)
        throws java.io.IOException {
        throw new java.io.NotSerializableException(getClass().getName());
    }

    /**
     * Read Object.
     *
     * @param stream Stream to read from.
     * @throws java.io.IOException if stream fails.
     * @throws ClassNotFoundException if class read is invalid.
     */
    private void readObject(final ObjectInputStream stream)
        throws java.io.IOException, ClassNotFoundException {
        throw new java.io.NotSerializableException(getClass().getName());
    }
}
