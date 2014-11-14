package de.dentrassi.osgiee.service1.impl;

import de.dentrassi.osgiee.service1.Service;

public class ServiceImpl implements Service {

	@Override
	public String getHello() {
		return "Hello from: " + this;
	}

}
