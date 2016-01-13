/**
 * MIT License.
 */
package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.NavbarAjaxLink;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * NavbarScrollToAnchorAjaxLink.
 * Ajax link that scrolls onclick to given anchor.
 *
 * @param <T> Type of link, p.e. String.
 * @author Christian Senkowski (cs@e-cs.co)
 * @version $Id$
 * @since 31.07.15
 */
@SuppressWarnings("unused")
public class NavbarScrollToAnchorAjaxLink<T> extends NavbarAjaxLink<T> {
    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -8827197347714921011L;
    /**
     * Mutex.
     */
    private static final Object MUTEX = new Object();
    /**
     * Anchor name.
     */
    private String anchor;

    /**
     * Construct with markup id, label and anchor name.
     *
     * @param markupid Wicket Markup ID.
     * @param label Label.
     * @param anchor Anchor which to scroll to.
     */
    public NavbarScrollToAnchorAjaxLink(final String markupid,
        final IModel<String> label, final String anchor) {
        super(markupid, label);
        this.anchor = anchor;
    }

    /**
     * Overriden onclick.
     * Adds javaScript to the request target which scrolls to the anchor.
     *
     * @param target Request target where to add the scroll.
     */
    @Override
    public final void onClick(final AjaxRequestTarget target) {
        target.prependJavaScript(
            String.format(
                "%1s%2$s%3$s",
                "$('html,body').animate({scrollTop: $(\"a[name='",
                this.anchor,
                "']\").offset().top - 50}, 'slow');"
            )
        );
    }

    /**
     * Get anchor.
     *
     * @return Anchor.
     */
    public final String getAnchor() {
        return this.anchor;
    }

    /**
     * Set anchor.
     *
     * @param value Anchor.
     */
    public final void setAnchor(final String value) {
        this.anchor = value;
    }

    /**
     * Read object.
     *
     * @param stream Stream.
     * @throws IOException if io fails.
     * @throws ClassNotFoundException if class not found.
     */
    private void readObject(final ObjectInputStream stream)
        throws IOException, ClassNotFoundException {
        synchronized (MUTEX) {
            stream.defaultReadObject();
            stream.readObject();
            this.anchor = (String) stream.readObject();
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
            stream.writeObject(this.getAnchor());
        }
    }
}
