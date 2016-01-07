/**
 * MIT License.
 */
package de.webplatz.addons;

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
     * Anchor where to scroll to.
     */
    private final transient String anchor;

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
