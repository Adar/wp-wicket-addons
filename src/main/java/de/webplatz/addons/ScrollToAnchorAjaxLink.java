/**
 * MIT License.
 */
package de.webplatz.addons;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;

/**
 * ScrollToAnchorAjaxLink.
 *
 * @param <T> Type of link, p.e. String.
 * @author Christian Senkowski (cs@e-cs.co)
 * @version $Id$
 * @since 31.07.15
 */
@SuppressWarnings("unused")
public class ScrollToAnchorAjaxLink<T> extends AjaxLink<T> {
    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -3961769989136447178L;
    /**
     * Mutex.
     */
    private static final Object MUTEX = new Object();
    /**
     * Anchor where to scroll to.
     */
    private String anchor;

    /**
     * Construct with markup id, model and anchor name.
     *
     * @param markupid Wicket markup id.
     * @param model Wicket model.
     * @param anchor Anchor which to scroll to.
     */
    public ScrollToAnchorAjaxLink(final String markupid, final IModel<T> model,
        final String anchor) {
        super(markupid, model);
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
