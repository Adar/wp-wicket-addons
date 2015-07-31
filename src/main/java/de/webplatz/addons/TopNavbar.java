package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;

import java.util.List;

public class TopNavbar extends Navbar {
  //  private static final Logger logger = LoggerFactory.getLogger(TopNavbar.class);
  private Component basketBadge;
  private List<AbstractLink> basketBadgeDomainLinkList;


  public TopNavbar(String componentId) {
    super(componentId);
  }

  public Component getBasketBadge() {
    return basketBadge;
  }

  public void setBasketBadge(Component basketBadge) {
    this.basketBadge = basketBadge;
  }

  public List<AbstractLink> getBasketBadgeDomainLinkList() {
    return basketBadgeDomainLinkList;
  }

  public void setBasketBadgeDomainLinkList(List<AbstractLink> basketBadgeDomainLinkList) {
    this.basketBadgeDomainLinkList = basketBadgeDomainLinkList;
  }
}
