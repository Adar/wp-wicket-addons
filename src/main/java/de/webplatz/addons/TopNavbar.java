package de.webplatz.addons;

import de.agilecoders.wicket.core.markup.html.bootstrap.navbar.Navbar;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;

import java.util.List;

public class TopNavbar extends Navbar {
  //  private static final Logger logger = LoggerFactory.getLogger(TopNavbar.class);
  private Component badgeLabel;
  private List<AbstractLink> badgeDropDownLinkList;

  public TopNavbar(String componentId) {
    super(componentId);
  }

  public Component getBadgeLabel() {
    return badgeLabel;
  }

  public void setBadgeLabel(Component badgeLabel) {
    this.badgeLabel = badgeLabel;
  }

  public List<AbstractLink> getBadgeDropDownLinkList() {
    return badgeDropDownLinkList;
  }

  public void setBadgeDropDownLinkList(List<AbstractLink> badgeDropDownLinkList) {
    this.badgeDropDownLinkList = badgeDropDownLinkList;
  }
}
