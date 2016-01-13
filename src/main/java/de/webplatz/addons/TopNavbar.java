/**
 * MIT License.
 */
package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
     * Mutex.
     */
    private static final Object MUTEX = new Object();
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

    /**
     * Read object.
     *
     * @param stream Stream.
     * @throws IOException if io fails.
     * @throws ClassNotFoundException if class not found.
     */
    @SuppressWarnings("unchecked")
    private void readObject(final ObjectInputStream stream)
        throws IOException, ClassNotFoundException {
        synchronized (MUTEX) {
            stream.defaultReadObject();
            stream.readObject();
            this.label = (Component) stream.readObject();
            this.linklist = (List<AbstractLink>) stream.readObject();
        }
    }

    /**
     * Write object.
     *
     * @param stream Stream.
     * @throws IOException if io fails.
     */
    private void writeObject(final ObjectOutputStream stream)
        throws IOException {
        synchronized (MUTEX) {
            stream.defaultWriteObject();
            stream.writeObject(this.getLabel());
            stream.writeObject(this.getLinklist());
        }
    }
}
