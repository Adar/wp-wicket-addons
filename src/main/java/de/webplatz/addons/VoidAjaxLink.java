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
 * VoidAjaxLink.
 * Ajax Link without any functionality.
 * Basically for when you do not need/want any onclick-behaviour.
 *
 * @param <T> Type of Link, p.e. String.
 * @author Christian Senkowski (cs@e-cs.co)
 * @version $Id$
 * @since 03.08.15
 */
@SuppressWarnings("unused")
public class VoidAjaxLink<T> extends AjaxLink<T> {
    /**
     * Serial Version UID.
     */
    private static final long serialVersionUID = -8071764479474551469L;
    /**
     * Construct.
     *
     * @param markupid Wicket markup id.
     */
    public VoidAjaxLink(final String markupid) {
        super(markupid);
    }

    /**
     * Construct.
     *
     * @param markupid Wicket markup id.
     * @param model Wicket model.
     */
    public VoidAjaxLink(final String markupid, final IModel<T> model) {
        super(markupid, model);
    }

    /**
     * Overriden empty onClick.
     *
     * @param target Ajax request target.
     */
    @Override
    public void onClick(final AjaxRequestTarget target) {
        // nothing to do
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
