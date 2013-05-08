package com.glassbox.webinvoice.client.view;

import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.Event;
import com.google.gwt.user.client.EventListener;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

public class ViewController {

	// Initialize the nav bar
	static {
		for (final Views v : Views.values()) {

			final Element li = DOM.createElement("li");
			final Element a = DOM.createAnchor();

			if (v == Views.Home)
				li.addClassName("active");

			a.setInnerHTML(v.getPageName());
			a.setAttribute("href", "javascript:void(0);");
			DOM.sinkEvents(a, Event.ONCLICK);

			DOM.setEventListener(a, new EventListener() {
				public void onBrowserEvent(Event event) {

					showView(v);

					for (int i = 0; i < RootPanel.get("nav").getElement()
							.getElementsByTagName("li").getLength(); i++) {
						RootPanel.get("nav").getElement()
								.getElementsByTagName("li").getItem(i)
								.removeClassName("active");
					}
					li.setClassName("active");
				}
			});

			li.appendChild(a);
			RootPanel.get("nav").getElement().appendChild(li);
		}

	}

	private static void showView(Widget w) {
		RootPanel.get("start").clear();
		RootPanel.get("start").add(w);
	}

	public static void showView(Views v) {
		switch (v) {
		case SignIn:
			showView(new SignInView().load());
			break;
		case SignUp:
			showView(new SignUpView().load());
			break;
		default:
			showView(new SignInView().load());

		}
	}
}
