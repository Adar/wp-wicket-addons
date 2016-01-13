/**
 * MIT License.
 */
package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import java.util.List;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;

/**
 * TopNavbar.
 *
 * @author Christian Senkowski (cs@e-cs.co)
 * @version $Id$
 * @since 03.08.15
 */
@SuppressWarnings("unused")
public class TopNavbar extends Navbar {
    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -3725636639523022220L;
    /**
     * Badge Label.
     */
    private Component label;
    /**
     * Badge Link List.
     */
    private List<AbstractLink> linklist;

    /**
     * Construct.
     *
     * @param markupid Wicket markup id.
     * @param label Label Component.
     * @param list Link list.
     */
    public TopNavbar(final String markupid, final Component label,
        final List<AbstractLink> list) {
        super(markupid);
        this.label = label;
        this.linklist = list;
    }

    /**
     * Badge Label.
     *
     * @return Wicket Component.
     */
    public final Component getLabel() {
        return this.label;
    }

    /**
     * Set label.
     *
     * @param value Label.
     */
    public final void setLabel(final Component value) {
        this.label = value;
    }

    /**
     * Get badge link list.
     *
     * @return Link List.
     */
    public final List<AbstractLink> getLinklist() {
        return this.linklist;
    }

    /**
     * Set link list.
     *
     * @param list Link list.
     */
    public final void setLinklist(final List<AbstractLink> list) {
        this.linklist = list;
    }

}
