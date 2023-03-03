package io.github.agbaroni.jhee.frontend.services;

import java.io.Serializable;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/")
public class ApplicationImpl extends Application implements Serializable {

    private static final long serialVersionUID = 14888308826227L;
}
